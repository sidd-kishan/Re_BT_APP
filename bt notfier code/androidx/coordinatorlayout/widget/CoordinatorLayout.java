/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.Region$Op
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.coordinatorlayout.R$attr
 *  androidx.coordinatorlayout.R$style
 *  androidx.coordinatorlayout.R$styleable
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$DefaultBehavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$HierarchyChangeListener
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator
 *  androidx.coordinatorlayout.widget.DirectedAcyclicGraph
 *  androidx.coordinatorlayout.widget.ViewGroupUtils
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.util.ObjectsCompat
 *  androidx.core.util.Pools$Pool
 *  androidx.core.util.Pools$SynchronizedPool
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.NestedScrollingParent2
 *  androidx.core.view.NestedScrollingParentHelper
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.DirectedAcyclicGraph;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
extends ViewGroup
implements NestedScrollingParent2 {
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    private static final Pools.Pool<Rect> sRectPool;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren = new ArrayList<View>();
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final int[] mTempIntPair;
    private final List<View> mTempList1;

    static {
        Object object = CoordinatorLayout.class.getPackage();
        object = object != null ? ((Package)object).getName() : null;
        WIDGET_PACKAGE_NAME = object;
        TOP_SORTED_CHILDREN_COMPARATOR = Build.VERSION.SDK_INT >= 21 ? new ViewElevationComparator() : null;
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new Pools.SynchronizedPool(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context object, AttributeSet attributeSet, int n) {
        super(object, attributeSet, n);
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList<View>();
        this.mTempDependenciesList = new ArrayList<View>();
        this.mTempIntPair = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        int n2 = 0;
        attributeSet = n == 0 ? object.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout) : object.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, n, 0);
        n = attributeSet.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (n != 0) {
            object = object.getResources();
            this.mKeylines = object.getIntArray(n);
            float f = object.getDisplayMetrics().density;
            int n3 = this.mKeylines.length;
            for (n = n2; n < n3; ++n) {
                object = this.mKeylines;
                object[n] = (Context)((int)((float)object[n] * f));
            }
        }
        this.mStatusBarBackground = attributeSet.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        attributeSet.recycle();
        this.setupForInsets();
        super.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)new HierarchyChangeListener(this));
    }

    private static Rect acquireTempRect() {
        Rect rect;
        Rect rect2 = rect = (Rect)sRectPool.acquire();
        if (rect != null) return rect2;
        rect2 = new Rect();
        return rect2;
    }

    private static int clamp(int n, int n2, int n3) {
        if (n < n2) {
            return n2;
        }
        if (n <= n3) return n;
        return n3;
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int n, int n2) {
        int n3 = this.getWidth();
        int n4 = this.getHeight();
        n3 = Math.max(this.getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, n3 - this.getPaddingRight() - n - layoutParams.rightMargin));
        n4 = Math.max(this.getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, n4 - this.getPaddingBottom() - n2 - layoutParams.bottomMargin));
        rect.set(n3, n4, n + n3, n2 + n4);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int n = 0;
        int n2 = this.getChildCount();
        while (true) {
            WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
            if (n >= n2) return windowInsetsCompat2;
            View view = this.getChildAt(n);
            windowInsetsCompat2 = windowInsetsCompat;
            if (ViewCompat.getFitsSystemWindows((View)view)) {
                Behavior behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
                windowInsetsCompat2 = windowInsetsCompat;
                if (behavior != null) {
                    windowInsetsCompat2 = windowInsetsCompat = behavior.onApplyWindowInsets(this, view, windowInsetsCompat);
                    if (windowInsetsCompat.isConsumed()) {
                        windowInsetsCompat2 = windowInsetsCompat;
                        return windowInsetsCompat2;
                    }
                }
            }
            ++n;
            windowInsetsCompat = windowInsetsCompat2;
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int n, Rect rect, Rect rect2, LayoutParams layoutParams, int n2, int n3) {
        int n4 = GravityCompat.getAbsoluteGravity((int)CoordinatorLayout.resolveAnchoredChildGravity(layoutParams.gravity), (int)n);
        int n5 = GravityCompat.getAbsoluteGravity((int)CoordinatorLayout.resolveGravity(layoutParams.anchorGravity), (int)n);
        int n6 = n4 & 7;
        int n7 = n4 & 0x70;
        n = n5 & 7;
        n5 &= 0x70;
        n = n != 1 ? (n != 5 ? rect.left : rect.right) : rect.left + rect.width() / 2;
        n5 = n5 != 16 ? (n5 != 80 ? rect.top : rect.bottom) : rect.top + rect.height() / 2;
        if (n6 != 1) {
            n4 = n;
            if (n6 != 5) {
                n4 = n - n2;
            }
        } else {
            n4 = n - n2 / 2;
        }
        if (n7 != 16) {
            n = n5;
            if (n7 != 80) {
                n = n5 - n3;
            }
        } else {
            n = n5 - n3 / 2;
        }
        rect2.set(n4, n, n2 + n4, n3 + n);
    }

    private int getKeyline(int n) {
        Object object = this.mKeylines;
        if (object == null) {
            object = new StringBuilder();
            object.append("No keylines defined for ");
            object.append((Object)this);
            object.append(" - attempted index lookup ");
            object.append(n);
            Log.e((String)TAG, (String)object.toString());
            return 0;
        }
        if (n >= 0) {
            if (n < ((int[])object).length) return object[n];
        }
        object = new StringBuilder();
        object.append("Keyline index ");
        object.append(n);
        object.append(" out of range for ");
        object.append((Object)this);
        Log.e((String)TAG, (String)object.toString());
        return 0;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean bl = this.isChildrenDrawingOrderEnabled();
        int n = this.getChildCount();
        int n2 = n - 1;
        while (true) {
            if (n2 < 0) {
                Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
                if (comparator == null) return;
                Collections.sort(list, comparator);
                return;
            }
            int n3 = bl ? this.getChildDrawingOrder(n, n2) : n2;
            list.add(this.getChildAt(n3));
            --n2;
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.hasOutgoingEdges((Object)view);
    }

    private void layoutChild(View view, int n) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        Rect rect = CoordinatorLayout.acquireTempRect();
        rect.set(this.getPaddingLeft() + layoutParams.leftMargin, this.getPaddingTop() + layoutParams.topMargin, this.getWidth() - this.getPaddingRight() - layoutParams.rightMargin, this.getHeight() - this.getPaddingBottom() - layoutParams.bottomMargin);
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows((View)this) && !ViewCompat.getFitsSystemWindows((View)view)) {
            rect.left += this.mLastInsets.getSystemWindowInsetLeft();
            rect.top += this.mLastInsets.getSystemWindowInsetTop();
            rect.right -= this.mLastInsets.getSystemWindowInsetRight();
            rect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }
        Rect rect2 = CoordinatorLayout.acquireTempRect();
        GravityCompat.apply((int)CoordinatorLayout.resolveGravity(layoutParams.gravity), (int)view.getMeasuredWidth(), (int)view.getMeasuredHeight(), (Rect)rect, (Rect)rect2, (int)n);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        CoordinatorLayout.releaseTempRect(rect);
        CoordinatorLayout.releaseTempRect(rect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int n) {
        Rect rect = CoordinatorLayout.acquireTempRect();
        Rect rect2 = CoordinatorLayout.acquireTempRect();
        try {
            this.getDescendantRect(view2, rect);
            this.getDesiredAnchoredChildRect(view, n, rect, rect2);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            return;
        }
        finally {
            CoordinatorLayout.releaseTempRect(rect);
            CoordinatorLayout.releaseTempRect(rect2);
        }
    }

    private void layoutChildWithKeyline(View view, int n, int n2) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n3 = GravityCompat.getAbsoluteGravity((int)CoordinatorLayout.resolveKeylineGravity(layoutParams.gravity), (int)n2);
        int n4 = n3 & 7;
        int n5 = n3 & 0x70;
        int n6 = this.getWidth();
        int n7 = this.getHeight();
        int n8 = view.getMeasuredWidth();
        int n9 = view.getMeasuredHeight();
        n3 = n;
        if (n2 == 1) {
            n3 = n6 - n;
        }
        n = this.getKeyline(n3) - n8;
        n2 = 0;
        if (n4 != 1) {
            if (n4 == 5) {
                n += n8;
            }
        } else {
            n += n8 / 2;
        }
        if (n5 != 16) {
            if (n5 == 80) {
                n2 = n9 + 0;
            }
        } else {
            n2 = 0 + n9 / 2;
        }
        n = Math.max(this.getPaddingLeft() + layoutParams.leftMargin, Math.min(n, n6 - this.getPaddingRight() - n8 - layoutParams.rightMargin));
        n2 = Math.max(this.getPaddingTop() + layoutParams.topMargin, Math.min(n2, n7 - this.getPaddingBottom() - n9 - layoutParams.bottomMargin));
        view.layout(n, n2, n8 + n, n9 + n2);
    }

    private void offsetChildByInset(View object, Rect rect, int n) {
        if (!ViewCompat.isLaidOut((View)object)) {
            return;
        }
        if (object.getWidth() <= 0) return;
        if (object.getHeight() <= 0) return;
        LayoutParams layoutParams = (LayoutParams)object.getLayoutParams();
        Behavior behavior = layoutParams.getBehavior();
        Rect rect2 = CoordinatorLayout.acquireTempRect();
        Rect rect3 = CoordinatorLayout.acquireTempRect();
        rect3.set(object.getLeft(), object.getTop(), object.getRight(), object.getBottom());
        if (behavior != null && behavior.getInsetDodgeRect(this, (View)object, rect2)) {
            if (!rect3.contains(rect2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Rect should be within the child's bounds. Rect:");
                ((StringBuilder)object).append(rect2.toShortString());
                ((StringBuilder)object).append(" | Bounds:");
                ((StringBuilder)object).append(rect3.toShortString());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
        } else {
            rect2.set(rect3);
        }
        CoordinatorLayout.releaseTempRect(rect3);
        if (rect2.isEmpty()) {
            CoordinatorLayout.releaseTempRect(rect2);
            return;
        }
        int n2 = GravityCompat.getAbsoluteGravity((int)layoutParams.dodgeInsetEdges, (int)n);
        int n3 = 1;
        if ((n2 & 0x30) == 48 && (n = rect2.top - layoutParams.topMargin - layoutParams.mInsetOffsetY) < rect.top) {
            this.setInsetOffsetY((View)object, rect.top - n);
            n = 1;
        } else {
            n = 0;
        }
        int n4 = n;
        if ((n2 & 0x50) == 80) {
            int n5 = this.getHeight() - rect2.bottom - layoutParams.bottomMargin + layoutParams.mInsetOffsetY;
            n4 = n;
            if (n5 < rect.bottom) {
                this.setInsetOffsetY((View)object, n5 - rect.bottom);
                n4 = 1;
            }
        }
        if (n4 == 0) {
            this.setInsetOffsetY((View)object, 0);
        }
        if ((n2 & 3) == 3 && (n = rect2.left - layoutParams.leftMargin - layoutParams.mInsetOffsetX) < rect.left) {
            this.setInsetOffsetX((View)object, rect.left - n);
            n = 1;
        } else {
            n = 0;
        }
        if ((n2 & 5) == 5 && (n4 = this.getWidth() - rect2.right - layoutParams.rightMargin + layoutParams.mInsetOffsetX) < rect.right) {
            this.setInsetOffsetX((View)object, n4 - rect.right);
            n = n3;
        }
        if (n == 0) {
            this.setInsetOffsetX((View)object, 0);
        }
        CoordinatorLayout.releaseTempRect(rect2);
    }

    static Behavior parseBehavior(Context context, AttributeSet object, String hashMap) {
        CharSequence charSequence;
        if (TextUtils.isEmpty((CharSequence)((Object)hashMap))) {
            return null;
        }
        if (((String)((Object)hashMap)).startsWith(".")) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(context.getPackageName());
            ((StringBuilder)charSequence).append((String)((Object)hashMap));
            charSequence = ((StringBuilder)charSequence).toString();
        } else if (((String)((Object)hashMap)).indexOf(46) >= 0) {
            charSequence = hashMap;
        } else {
            charSequence = hashMap;
            if (!TextUtils.isEmpty((CharSequence)WIDGET_PACKAGE_NAME)) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(WIDGET_PACKAGE_NAME);
                ((StringBuilder)charSequence).append('.');
                ((StringBuilder)charSequence).append((String)((Object)hashMap));
                charSequence = ((StringBuilder)charSequence).toString();
            }
        }
        try {
            Constructor<?> constructor = sConstructors.get();
            hashMap = constructor;
            if (constructor == null) {
                hashMap = new HashMap();
                sConstructors.set(hashMap);
            }
            Constructor constructor2 = (Constructor)hashMap.get(charSequence);
            constructor = constructor2;
            if (constructor2 == null) {
                constructor = context.getClassLoader().loadClass((String)charSequence).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                hashMap.put(charSequence, constructor);
            }
            context = (Behavior)constructor.newInstance(context, object);
            return context;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not inflate Behavior subclass ");
            ((StringBuilder)object).append((String)charSequence);
            throw new RuntimeException(((StringBuilder)object).toString(), exception);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int n) {
        boolean bl;
        int n2 = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        this.getTopSortedChildren(list);
        int n3 = list.size();
        LayoutParams layoutParams = null;
        int n4 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        while (true) {
            boolean bl4;
            boolean bl5;
            bl = bl2;
            if (n4 >= n3) break;
            View view = list.get(n4);
            LayoutParams layoutParams2 = (LayoutParams)view.getLayoutParams();
            Behavior behavior = layoutParams2.getBehavior();
            if ((bl2 || bl3) && n2 != 0) {
                layoutParams2 = layoutParams;
                bl5 = bl2;
                bl4 = bl3;
                if (behavior != null) {
                    layoutParams2 = layoutParams;
                    if (layoutParams == null) {
                        long l = SystemClock.uptimeMillis();
                        layoutParams2 = MotionEvent.obtain((long)l, (long)l, (int)3, (float)0.0f, (float)0.0f, (int)0);
                    }
                    if (n != 0) {
                        if (n != 1) {
                            bl5 = bl2;
                            bl4 = bl3;
                        } else {
                            behavior.onTouchEvent(this, view, (MotionEvent)layoutParams2);
                            bl5 = bl2;
                            bl4 = bl3;
                        }
                    } else {
                        behavior.onInterceptTouchEvent(this, view, (MotionEvent)layoutParams2);
                        bl5 = bl2;
                        bl4 = bl3;
                    }
                }
            } else {
                bl = bl2;
                if (!bl2) {
                    bl = bl2;
                    if (behavior != null) {
                        if (n != 0) {
                            if (n == 1) {
                                bl2 = behavior.onTouchEvent(this, view, motionEvent);
                            }
                        } else {
                            bl2 = behavior.onInterceptTouchEvent(this, view, motionEvent);
                        }
                        bl = bl2;
                        if (bl2) {
                            this.mBehaviorTouchView = view;
                            bl = bl2;
                        }
                    }
                }
                bl5 = layoutParams2.didBlockInteraction();
                bl2 = layoutParams2.isBlockingInteractionBelow(this, view);
                bl3 = bl2 && !bl5;
                layoutParams2 = layoutParams;
                bl5 = bl;
                bl4 = bl3;
                if (bl2) {
                    layoutParams2 = layoutParams;
                    bl5 = bl;
                    bl4 = bl3;
                    if (!bl3) break;
                }
            }
            ++n4;
            layoutParams = layoutParams2;
            bl2 = bl5;
            bl3 = bl4;
        }
        list.clear();
        return bl;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int n = this.getChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
                Collections.reverse(this.mDependencySortedChildren);
                return;
            }
            View view = this.getChildAt(n2);
            LayoutParams layoutParams = this.getResolvedLayoutParams(view);
            layoutParams.findAnchorView(this, view);
            this.mChildDag.addNode((Object)view);
            for (int i = 0; i < n; ++i) {
                View view2;
                if (i == n2 || !layoutParams.dependsOn(this, view, view2 = this.getChildAt(i))) continue;
                if (!this.mChildDag.contains((Object)view2)) {
                    this.mChildDag.addNode((Object)view2);
                }
                this.mChildDag.addEdge((Object)view2, (Object)view);
            }
            ++n2;
        }
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.release((Object)rect);
    }

    private void resetTouchBehaviors(boolean bl) {
        int n;
        int n2 = this.getChildCount();
        for (n = 0; n < n2; ++n) {
            View view = this.getChildAt(n);
            Behavior behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
            if (behavior == null) continue;
            long l = SystemClock.uptimeMillis();
            MotionEvent motionEvent = MotionEvent.obtain((long)l, (long)l, (int)3, (float)0.0f, (float)0.0f, (int)0);
            if (bl) {
                behavior.onInterceptTouchEvent(this, view, motionEvent);
            } else {
                behavior.onTouchEvent(this, view, motionEvent);
            }
            motionEvent.recycle();
        }
        n = 0;
        while (true) {
            if (n >= n2) {
                this.mBehaviorTouchView = null;
                this.mDisallowInterceptReset = false;
                return;
            }
            ((LayoutParams)this.getChildAt(n).getLayoutParams()).resetTouchBehaviorTracking();
            ++n;
        }
    }

    private static int resolveAnchoredChildGravity(int n) {
        int n2 = n;
        if (n != 0) return n2;
        n2 = 17;
        return n2;
    }

    private static int resolveGravity(int n) {
        int n2 = n;
        if ((n & 7) == 0) {
            n2 = n | 0x800003;
        }
        n = n2;
        if ((n2 & 0x70) != 0) return n;
        n = n2 | 0x30;
        return n;
    }

    private static int resolveKeylineGravity(int n) {
        int n2 = n;
        if (n != 0) return n2;
        n2 = 8388661;
        return n2;
    }

    private void setInsetOffsetX(View view, int n) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mInsetOffsetX == n) return;
        ViewCompat.offsetLeftAndRight((View)view, (int)(n - layoutParams.mInsetOffsetX));
        layoutParams.mInsetOffsetX = n;
    }

    private void setInsetOffsetY(View view, int n) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mInsetOffsetY == n) return;
        ViewCompat.offsetTopAndBottom((View)view, (int)(n - layoutParams.mInsetOffsetY));
        layoutParams.mInsetOffsetY = n;
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.getFitsSystemWindows((View)this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new /* Unavailable Anonymous Inner Class!! */;
            }
            ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)this.mApplyWindowInsetsListener);
            this.setSystemUiVisibility(1280);
        } else {
            ViewCompat.setOnApplyWindowInsetsListener((View)this, null);
        }
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener(this);
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = layoutParams instanceof LayoutParams && super.checkLayoutParams(layoutParams);
        return bl;
    }

    public void dispatchDependentViewsChanged(View view) {
        List list = this.mChildDag.getIncomingEdges((Object)view);
        if (list == null) return;
        if (list.isEmpty()) return;
        int n = 0;
        while (n < list.size()) {
            View view2 = (View)list.get(n);
            Behavior behavior = ((LayoutParams)view2.getLayoutParams()).getBehavior();
            if (behavior != null) {
                behavior.onDependentViewChanged(this, view2, view);
            }
            ++n;
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        int n = view.getVisibility();
        boolean bl = false;
        if (n != 0) return false;
        if (view2.getVisibility() != 0) return false;
        Rect rect = CoordinatorLayout.acquireTempRect();
        boolean bl2 = view.getParent() != this;
        this.getChildRect(view, bl2, rect);
        view = CoordinatorLayout.acquireTempRect();
        bl2 = view2.getParent() != this;
        this.getChildRect(view2, bl2, (Rect)view);
        bl2 = bl;
        try {
            if (rect.left > view.right) return bl2;
            bl2 = bl;
            if (rect.top > view.bottom) return bl2;
            bl2 = bl;
            if (rect.right < view.left) return bl2;
            int n2 = rect.bottom;
            n = view.top;
            bl2 = bl;
            if (n2 < n) return bl2;
            bl2 = true;
        }
        finally {
            CoordinatorLayout.releaseTempRect(rect);
            CoordinatorLayout.releaseTempRect((Rect)view);
        }
        return bl2;
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mBehavior == null) return super.drawChild(canvas, view, l);
        float f = layoutParams.mBehavior.getScrimOpacity(this, view);
        if (!(f > 0.0f)) return super.drawChild(canvas, view, l);
        if (this.mScrimPaint == null) {
            this.mScrimPaint = new Paint();
        }
        this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view));
        this.mScrimPaint.setAlpha(CoordinatorLayout.clamp(Math.round(f * 255.0f), 0, 255));
        int n = canvas.save();
        if (view.isOpaque()) {
            canvas.clipRect((float)view.getLeft(), (float)view.getTop(), (float)view.getRight(), (float)view.getBottom(), Region.Op.DIFFERENCE);
        }
        canvas.drawRect((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()), this.mScrimPaint);
        canvas.restoreToCount(n);
        return super.drawChild(canvas, view, l);
    }

    protected void drawableStateChanged() {
        boolean bl;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean bl2 = bl = false;
        if (drawable != null) {
            bl2 = bl;
            if (drawable.isStateful()) {
                bl2 = false | drawable.setState(nArray);
            }
        }
        if (!bl2) return;
        this.invalidate();
    }

    void ensurePreDrawListener() {
        boolean bl;
        int n = this.getChildCount();
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            if (this.hasDependencies(this.getChildAt(n2))) {
                bl = true;
                break;
            }
            ++n2;
        }
        if (bl == this.mNeedsPreDrawListener) return;
        if (bl) {
            this.addPreDrawListener();
        } else {
            this.removePreDrawListener();
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new LayoutParams(layoutParams);
        return new LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
    }

    void getChildRect(View view, boolean bl, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (bl) {
                this.getDescendantRect(view, rect);
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            return;
        }
        rect.setEmpty();
    }

    public List<View> getDependencies(View object) {
        object = this.mChildDag.getOutgoingEdges(object);
        this.mTempDependenciesList.clear();
        if (object == null) return this.mTempDependenciesList;
        this.mTempDependenciesList.addAll((Collection<View>)object);
        return this.mTempDependenciesList;
    }

    final List<View> getDependencySortedChildren() {
        this.prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List<View> getDependents(View object) {
        object = this.mChildDag.getIncomingEdges(object);
        this.mTempDependenciesList.clear();
        if (object == null) return this.mTempDependenciesList;
        this.mTempDependenciesList.addAll((Collection<View>)object);
        return this.mTempDependenciesList;
    }

    void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect((ViewGroup)this, (View)view, (Rect)rect);
    }

    void getDesiredAnchoredChildRect(View view, int n, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n2 = view.getMeasuredWidth();
        int n3 = view.getMeasuredHeight();
        this.getDesiredAnchoredChildRectWithoutConstraints(view, n, rect, rect2, layoutParams, n2, n3);
        this.constrainChildRect(layoutParams, rect2, n2, n3);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams)view.getLayoutParams()).getLastChildRect());
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mBehaviorResolved) return layoutParams;
        if (view instanceof AttachedBehavior) {
            if ((view = ((AttachedBehavior)view).getBehavior()) == null) {
                Log.e((String)TAG, (String)"Attached behavior class is null");
            }
            layoutParams.setBehavior((Behavior)view);
            layoutParams.mBehaviorResolved = true;
        } else {
            Serializable serializable = view.getClass();
            view = null;
            while (serializable != null) {
                DefaultBehavior defaultBehavior = ((Class)serializable).getAnnotation(DefaultBehavior.class);
                view = defaultBehavior;
                if (defaultBehavior != null) break;
                serializable = ((Class)serializable).getSuperclass();
                view = defaultBehavior;
            }
            if (view != null) {
                try {
                    layoutParams.setBehavior((Behavior)view.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
                catch (Exception exception) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Default behavior class ");
                    ((StringBuilder)serializable).append(view.value().getName());
                    ((StringBuilder)serializable).append(" could not be instantiated. Did you forget");
                    ((StringBuilder)serializable).append(" a default constructor?");
                    Log.e((String)TAG, (String)((StringBuilder)serializable).toString(), (Throwable)exception);
                }
            }
            layoutParams.mBehaviorResolved = true;
        }
        return layoutParams;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
    }

    public boolean isPointInChildBounds(View view, int n, int n2) {
        Rect rect = CoordinatorLayout.acquireTempRect();
        this.getDescendantRect(view, rect);
        try {
            boolean bl = rect.contains(n, n2);
            return bl;
        }
        finally {
            CoordinatorLayout.releaseTempRect(rect);
        }
    }

    void offsetChildToAnchor(View view, int n) {
        Behavior behavior;
        int n2;
        int n3;
        int n4;
        Rect rect;
        Rect rect2;
        Rect rect3;
        LayoutParams layoutParams;
        block7: {
            block6: {
                layoutParams = (LayoutParams)view.getLayoutParams();
                if (layoutParams.mAnchorView == null) return;
                rect3 = CoordinatorLayout.acquireTempRect();
                rect2 = CoordinatorLayout.acquireTempRect();
                rect = CoordinatorLayout.acquireTempRect();
                this.getDescendantRect(layoutParams.mAnchorView, rect3);
                n4 = 0;
                this.getChildRect(view, false, rect2);
                n3 = view.getMeasuredWidth();
                n2 = view.getMeasuredHeight();
                this.getDesiredAnchoredChildRectWithoutConstraints(view, n, rect3, rect, layoutParams, n3, n2);
                if (rect.left != rect2.left) break block6;
                n = n4;
                if (rect.top == rect2.top) break block7;
            }
            n = 1;
        }
        this.constrainChildRect(layoutParams, rect, n3, n2);
        n3 = rect.left - rect2.left;
        n4 = rect.top - rect2.top;
        if (n3 != 0) {
            ViewCompat.offsetLeftAndRight((View)view, (int)n3);
        }
        if (n4 != 0) {
            ViewCompat.offsetTopAndBottom((View)view, (int)n4);
        }
        if (n != 0 && (behavior = layoutParams.getBehavior()) != null) {
            behavior.onDependentViewChanged(this, view, layoutParams.mAnchorView);
        }
        CoordinatorLayout.releaseTempRect(rect3);
        CoordinatorLayout.releaseTempRect(rect2);
        CoordinatorLayout.releaseTempRect(rect);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener(this);
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows((View)this)) {
            ViewCompat.requestApplyInsets((View)this);
        }
        this.mIsAttachedToWindow = true;
    }

    final void onChildViewsChanged(int n) {
        int n2 = ViewCompat.getLayoutDirection((View)this);
        int n3 = this.mDependencySortedChildren.size();
        Rect rect = CoordinatorLayout.acquireTempRect();
        Rect rect2 = CoordinatorLayout.acquireTempRect();
        Rect rect3 = CoordinatorLayout.acquireTempRect();
        int n4 = 0;
        while (true) {
            block20: {
                View view;
                int n5;
                LayoutParams layoutParams;
                View view2;
                block21: {
                    if (n4 >= n3) {
                        CoordinatorLayout.releaseTempRect(rect);
                        CoordinatorLayout.releaseTempRect(rect2);
                        CoordinatorLayout.releaseTempRect(rect3);
                        return;
                    }
                    view2 = this.mDependencySortedChildren.get(n4);
                    layoutParams = (LayoutParams)view2.getLayoutParams();
                    if (n == 0 && view2.getVisibility() == 8) break block20;
                    for (n5 = 0; n5 < n4; ++n5) {
                        view = this.mDependencySortedChildren.get(n5);
                        if (layoutParams.mAnchorDirectChild != view) continue;
                        this.offsetChildToAnchor(view2, n2);
                    }
                    this.getChildRect(view2, true, rect2);
                    if (layoutParams.insetEdge != 0 && !rect2.isEmpty()) {
                        int n6 = GravityCompat.getAbsoluteGravity((int)layoutParams.insetEdge, (int)n2);
                        n5 = n6 & 0x70;
                        if (n5 != 48) {
                            if (n5 == 80) {
                                rect.bottom = Math.max(rect.bottom, this.getHeight() - rect2.top);
                            }
                        } else {
                            rect.top = Math.max(rect.top, rect2.bottom);
                        }
                        n5 = n6 & 7;
                        if (n5 != 3) {
                            if (n5 == 5) {
                                rect.right = Math.max(rect.right, this.getWidth() - rect2.left);
                            }
                        } else {
                            rect.left = Math.max(rect.left, rect2.right);
                        }
                    }
                    if (layoutParams.dodgeInsetEdges != 0 && view2.getVisibility() == 0) {
                        this.offsetChildByInset(view2, rect, n2);
                    }
                    if (n == 2) break block21;
                    this.getLastChildRect(view2, rect3);
                    if (rect3.equals((Object)rect2)) break block20;
                    this.recordLastChildRect(view2, rect2);
                }
                for (n5 = n4 + 1; n5 < n3; ++n5) {
                    boolean bl;
                    layoutParams = this.mDependencySortedChildren.get(n5);
                    view = (LayoutParams)layoutParams.getLayoutParams();
                    Behavior behavior = view.getBehavior();
                    if (behavior == null || !behavior.layoutDependsOn(this, (View)layoutParams, view2)) continue;
                    if (n == 0 && view.getChangedAfterNestedScroll()) {
                        view.resetChangedAfterNestedScroll();
                        continue;
                    }
                    if (n != 2) {
                        bl = behavior.onDependentViewChanged(this, (View)layoutParams, view2);
                    } else {
                        behavior.onDependentViewRemoved(this, (View)layoutParams, view2);
                        bl = true;
                    }
                    if (n != 1) continue;
                    view.setChangedAfterNestedScroll(bl);
                }
            }
            ++n4;
        }
    }

    public void onDetachedFromWindow() {
        View view;
        super.onDetachedFromWindow();
        this.resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.mOnPreDrawListener);
        }
        if ((view = this.mNestedScrollingTarget) != null) {
            this.onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground) return;
        if (this.mStatusBarBackground == null) return;
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        int n = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (n <= 0) return;
        this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), n);
        this.mStatusBarBackground.draw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n == 0) {
            this.resetTouchBehaviors(true);
        }
        boolean bl = this.performIntercept(motionEvent, 0);
        if (n != 1) {
            if (n != 3) return bl;
        }
        this.resetTouchBehaviors(true);
        return bl;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        n3 = ViewCompat.getLayoutDirection((View)this);
        n2 = this.mDependencySortedChildren.size();
        n = 0;
        while (n < n2) {
            Behavior behavior;
            View view = this.mDependencySortedChildren.get(n);
            if (!(view.getVisibility() == 8 || (behavior = ((LayoutParams)view.getLayoutParams()).getBehavior()) != null && behavior.onLayoutChild(this, view, n3))) {
                this.onLayoutChild(view, n3);
            }
            ++n;
        }
    }

    public void onLayoutChild(View view, int n) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.checkAnchorChanged()) throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        if (layoutParams.mAnchorView != null) {
            this.layoutChildWithAnchor(view, layoutParams.mAnchorView, n);
        } else if (layoutParams.keyline >= 0) {
            this.layoutChildWithKeyline(view, layoutParams.keyline, n);
        } else {
            this.layoutChild(view, n);
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onMeasure(int var1_1, int var2_2) {
        this.prepareChildren();
        this.ensurePreDrawListener();
        var15_3 = this.getPaddingLeft();
        var17_4 = this.getPaddingTop();
        var16_5 = this.getPaddingRight();
        var19_6 = this.getPaddingBottom();
        var18_7 = ViewCompat.getLayoutDirection((View)this);
        var4_8 = var18_7 == 1;
        var22_9 = View.MeasureSpec.getMode((int)var1_1);
        var23_10 = View.MeasureSpec.getSize((int)var1_1);
        var21_11 = View.MeasureSpec.getMode((int)var2_2);
        var20_12 = View.MeasureSpec.getSize((int)var2_2);
        var9_13 = this.getSuggestedMinimumWidth();
        var10_14 = this.getSuggestedMinimumHeight();
        var5_15 = this.mLastInsets != null && ViewCompat.getFitsSystemWindows((View)this) != false;
        var6_16 = this.mDependencySortedChildren.size();
        var11_17 = 0;
        var7_18 = 0;
        var3_19 = var15_3;
        while (true) {
            block9: {
                var8_20 = var3_19;
                if (var7_18 >= var6_16) {
                    this.setMeasuredDimension(View.resolveSizeAndState((int)var9_13, (int)var1_1, (int)(-16777216 & var11_17)), View.resolveSizeAndState((int)var10_14, (int)var2_2, (int)(var11_17 << 16)));
                    return;
                }
                var27_27 = this.mDependencySortedChildren.get(var7_18);
                if (var27_27.getVisibility() == 8) break block9;
                var26_26 = (LayoutParams)var27_27.getLayoutParams();
                if (var26_26.keyline < 0 || var22_9 == 0) ** GOTO lbl-1000
                var3_19 = this.getKeyline(var26_26.keyline);
                var12_21 = GravityCompat.getAbsoluteGravity((int)CoordinatorLayout.resolveKeylineGravity(var26_26.gravity), (int)var18_7) & 7;
                if (var12_21 == 3 && !var4_8 || var12_21 == 5 && var4_8) {
                    var3_19 = Math.max(0, var23_10 - var16_5 - var3_19);
                } else if (var12_21 == 5 && !var4_8 || var12_21 == 3 && var4_8) {
                    var3_19 = Math.max(0, var3_19 - var8_20);
                } else lbl-1000:
                // 2 sources

                {
                    var3_19 = 0;
                }
                if (var5_15 && !ViewCompat.getFitsSystemWindows((View)var27_27)) {
                    var24_24 = this.mLastInsets.getSystemWindowInsetLeft();
                    var12_21 = this.mLastInsets.getSystemWindowInsetRight();
                    var14_23 = this.mLastInsets.getSystemWindowInsetTop();
                    var13_22 = this.mLastInsets.getSystemWindowInsetBottom();
                    var12_21 = View.MeasureSpec.makeMeasureSpec((int)(var23_10 - (var24_24 + var12_21)), (int)var22_9);
                    var13_22 = View.MeasureSpec.makeMeasureSpec((int)(var20_12 - (var14_23 + var13_22)), (int)var21_11);
                    var14_23 = var12_21;
                    var12_21 = var13_22;
                } else {
                    var13_22 = var1_1;
                    var12_21 = var2_2;
                    var14_23 = var13_22;
                }
                var25_25 = var26_26.getBehavior();
                if (var25_25 == null || !var25_25.onMeasureChild(this, var27_27, var14_23, var3_19, var12_21, 0)) {
                    this.onMeasureChild(var27_27, var14_23, var3_19, var12_21, 0);
                }
                var9_13 = Math.max(var9_13, var15_3 + var16_5 + var27_27.getMeasuredWidth() + var26_26.leftMargin + var26_26.rightMargin);
                var10_14 = Math.max(var10_14, var17_4 + var19_6 + var27_27.getMeasuredHeight() + var26_26.topMargin + var26_26.bottomMargin);
                var11_17 = View.combineMeasuredStates((int)var11_17, (int)var27_27.getMeasuredState());
            }
            ++var7_18;
            var3_19 = var8_20;
        }
    }

    public void onMeasureChild(View view, int n, int n2, int n3, int n4) {
        this.measureChildWithMargins(view, n, n2, n3, n4);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        int n = this.getChildCount();
        int n2 = 0;
        boolean bl2 = false;
        while (true) {
            boolean bl3;
            if (n2 >= n) {
                if (!bl2) return bl2;
                this.onChildViewsChanged(1);
                return bl2;
            }
            View view2 = this.getChildAt(n2);
            if (view2.getVisibility() == 8) {
                bl3 = bl2;
            } else {
                LayoutParams layoutParams = (LayoutParams)view2.getLayoutParams();
                if (!layoutParams.isNestedScrollAccepted(0)) {
                    bl3 = bl2;
                } else {
                    layoutParams = layoutParams.getBehavior();
                    bl3 = bl2;
                    if (layoutParams != null) {
                        bl3 = bl2 | layoutParams.onNestedFling(this, view2, view, f, f2, bl);
                    }
                }
            }
            ++n2;
            bl2 = bl3;
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int n = this.getChildCount();
        int n2 = 0;
        boolean bl = false;
        while (n2 < n) {
            boolean bl2;
            View view2 = this.getChildAt(n2);
            if (view2.getVisibility() == 8) {
                bl2 = bl;
            } else {
                LayoutParams layoutParams = (LayoutParams)view2.getLayoutParams();
                if (!layoutParams.isNestedScrollAccepted(0)) {
                    bl2 = bl;
                } else {
                    layoutParams = layoutParams.getBehavior();
                    bl2 = bl;
                    if (layoutParams != null) {
                        bl2 = bl | layoutParams.onNestedPreFling(this, view2, view, f, f2);
                    }
                }
            }
            ++n2;
            bl = bl2;
        }
        return bl;
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray) {
        this.onNestedPreScroll(view, n, n2, nArray, 0);
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray, int n3) {
        int n4 = this.getChildCount();
        boolean bl = false;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (true) {
            int n8;
            int n9;
            if (n5 >= n4) {
                nArray[0] = n6;
                nArray[1] = n7;
                if (!bl) return;
                this.onChildViewsChanged(1);
                return;
            }
            Object object = this.getChildAt(n5);
            if (object.getVisibility() == 8) {
                n9 = n6;
                n8 = n7;
            } else {
                LayoutParams layoutParams = (LayoutParams)object.getLayoutParams();
                if (!layoutParams.isNestedScrollAccepted(n3)) {
                    n9 = n6;
                    n8 = n7;
                } else {
                    layoutParams = layoutParams.getBehavior();
                    n9 = n6;
                    n8 = n7;
                    if (layoutParams != null) {
                        int[] nArray2 = this.mTempIntPair;
                        nArray2[1] = 0;
                        nArray2[0] = 0;
                        layoutParams.onNestedPreScroll(this, object, view, n, n2, nArray2, n3);
                        object = this.mTempIntPair;
                        n8 = n > 0 ? Math.max(n6, (int)object[0]) : Math.min(n6, (int)object[0]);
                        n6 = n8;
                        object = this.mTempIntPair;
                        n8 = n2 > 0 ? Math.max(n7, (int)object[1]) : Math.min(n7, (int)object[1]);
                        bl = true;
                        n9 = n6;
                    }
                }
            }
            ++n5;
            n6 = n9;
            n7 = n8;
        }
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4) {
        this.onNestedScroll(view, n, n2, n3, n4, 0);
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5) {
        int n6 = this.getChildCount();
        boolean bl = false;
        int n7 = 0;
        while (true) {
            LayoutParams layoutParams;
            if (n7 >= n6) {
                if (!bl) return;
                this.onChildViewsChanged(1);
                return;
            }
            View view2 = this.getChildAt(n7);
            if (view2.getVisibility() != 8 && (layoutParams = (LayoutParams)view2.getLayoutParams()).isNestedScrollAccepted(n5) && (layoutParams = layoutParams.getBehavior()) != null) {
                layoutParams.onNestedScroll(this, view2, view, n, n2, n3, n4, n5);
                bl = true;
            }
            ++n7;
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int n) {
        this.onNestedScrollAccepted(view, view2, n, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, n, n2);
        this.mNestedScrollingTarget = view2;
        int n3 = this.getChildCount();
        int n4 = 0;
        while (n4 < n3) {
            View view3 = this.getChildAt(n4);
            LayoutParams layoutParams = (LayoutParams)view3.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(n2) && (layoutParams = layoutParams.getBehavior()) != null) {
                layoutParams.onNestedScrollAccepted(this, view3, view, view2, n, n2);
            }
            ++n4;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        SparseArray sparseArray = parcelable.behaviorStates;
        int n = 0;
        int n2 = this.getChildCount();
        while (n < n2) {
            View view = this.getChildAt(n);
            int n3 = view.getId();
            Behavior behavior = this.getResolvedLayoutParams(view).getBehavior();
            if (n3 != -1 && behavior != null && (parcelable = (Parcelable)sparseArray.get(n3)) != null) {
                behavior.onRestoreInstanceState(this, view, parcelable);
            }
            ++n;
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int n = this.getChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                savedState.behaviorStates = sparseArray;
                return savedState;
            }
            View view = this.getChildAt(n2);
            int n3 = view.getId();
            Behavior behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
            if (n3 != -1 && behavior != null && (view = behavior.onSaveInstanceState(this, view)) != null) {
                sparseArray.append(n3, (Object)view);
            }
            ++n2;
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int n) {
        return this.onStartNestedScroll(view, view2, n, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int n, int n2) {
        int n3 = this.getChildCount();
        int n4 = 0;
        boolean bl = false;
        while (n4 < n3) {
            View view3 = this.getChildAt(n4);
            if (view3.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams)view3.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    boolean bl2 = behavior.onStartNestedScroll(this, view3, view, view2, n, n2);
                    bl |= bl2;
                    layoutParams.setNestedScrollAccepted(n2, bl2);
                } else {
                    layoutParams.setNestedScrollAccepted(n2, false);
                }
            }
            ++n4;
        }
        return bl;
    }

    public void onStopNestedScroll(View view) {
        this.onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int n) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view, n);
        int n2 = this.getChildCount();
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                this.mNestedScrollingTarget = null;
                return;
            }
            View view2 = this.getChildAt(n3);
            LayoutParams layoutParams = (LayoutParams)view2.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(n)) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, view2, view, n);
                }
                layoutParams.resetNestedScroll(n);
                layoutParams.resetChangedAfterNestedScroll();
            }
            ++n3;
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block8: {
            block7: {
                var2_2 = var1_1.getActionMasked();
                if (this.mBehaviorTouchView != null) break block7;
                var6_4 = var5_3 = this.performIntercept(var1_1, 1);
                if (!var5_3) ** GOTO lbl-1000
                break block8;
            }
            var5_3 = false;
        }
        var8_5 = ((LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        var6_4 = var5_3;
        if (var8_5 != null) {
            var7_6 = var8_5.onTouchEvent(this, this.mBehaviorTouchView, var1_1);
            var6_4 = var5_3;
            var5_3 = var7_6;
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = false;
        }
        var9_7 = this.mBehaviorTouchView;
        var8_5 = null;
        if (var9_7 == null) {
            var7_6 = var5_3 | super.onTouchEvent(var1_1);
            var1_1 = var8_5;
        } else {
            var7_6 = var5_3;
            var1_1 = var8_5;
            if (var6_4) {
                var3_8 = SystemClock.uptimeMillis();
                var1_1 = MotionEvent.obtain((long)var3_8, (long)var3_8, (int)3, (float)0.0f, (float)0.0f, (int)0);
                super.onTouchEvent(var1_1);
                var7_6 = var5_3;
            }
        }
        if (var1_1 != null) {
            var1_1.recycle();
        }
        if (var2_2 != 1) {
            if (var2_2 != 3) return var7_6;
        }
        this.resetTouchBehaviors(false);
        return var7_6;
    }

    void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams)view.getLayoutParams()).setLastChildRect(rect);
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl) {
        Behavior behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
        if (behavior == null) return super.requestChildRectangleOnScreen(view, rect, bl);
        if (!behavior.onRequestChildRectangleOnScreen(this, view, rect, bl)) return super.requestChildRectangleOnScreen(view, rect, bl);
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean bl) {
        super.requestDisallowInterceptTouchEvent(bl);
        if (!bl) return;
        if (this.mDisallowInterceptReset) return;
        this.resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
    }

    public void setFitsSystemWindows(boolean bl) {
        super.setFitsSystemWindows(bl);
        this.setupForInsets();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 == drawable) return;
        Drawable drawable3 = null;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable3 = drawable.mutate();
        }
        this.mStatusBarBackground = drawable3;
        if (drawable3 != null) {
            if (drawable3.isStateful()) {
                this.mStatusBarBackground.setState(this.getDrawableState());
            }
            DrawableCompat.setLayoutDirection((Drawable)this.mStatusBarBackground, (int)ViewCompat.getLayoutDirection((View)this));
            drawable = this.mStatusBarBackground;
            boolean bl = this.getVisibility() == 0;
            drawable.setVisible(bl, false);
            this.mStatusBarBackground.setCallback((Drawable.Callback)this);
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public void setStatusBarBackgroundColor(int n) {
        this.setStatusBarBackground((Drawable)new ColorDrawable(n));
    }

    public void setStatusBarBackgroundResource(int n) {
        Drawable drawable = n != 0 ? ContextCompat.getDrawable((Context)this.getContext(), (int)n) : null;
        this.setStatusBarBackground(drawable);
    }

    public void setVisibility(int n) {
        super.setVisibility(n);
        boolean bl = n == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null) return;
        if (drawable.isVisible() == bl) return;
        this.mStatusBarBackground.setVisible(bl, false);
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
        if (ObjectsCompat.equals((Object)this.mLastInsets, (Object)windowInsetsCompat)) return windowInsetsCompat2;
        this.mLastInsets = windowInsetsCompat;
        boolean bl = true;
        boolean bl2 = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        this.mDrawStatusBarBackground = bl2;
        bl2 = !bl2 && this.getBackground() == null ? bl : false;
        this.setWillNotDraw(bl2);
        windowInsetsCompat2 = this.dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
        this.requestLayout();
        return windowInsetsCompat2;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean bl = super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
        return bl;
    }
}
