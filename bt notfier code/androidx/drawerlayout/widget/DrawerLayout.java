/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.WindowInsets
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.ViewCompat
 *  androidx.customview.widget.ViewDragHelper
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  androidx.drawerlayout.widget.DrawerLayout$AccessibilityDelegate
 *  androidx.drawerlayout.widget.DrawerLayout$ChildAccessibilityDelegate
 *  androidx.drawerlayout.widget.DrawerLayout$DrawerListener
 *  androidx.drawerlayout.widget.DrawerLayout$LayoutParams
 *  androidx.drawerlayout.widget.DrawerLayout$SavedState
 *  androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback
 */
package androidx.drawerlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
extends ViewGroup {
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    static final int[] LAYOUT_ATTRS;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS;
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout = true;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd = 3;
    private int mLockModeLeft = 3;
    private int mLockModeRight = 3;
    private int mLockModeStart = 3;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor = -1728053248;
    private float mScrimOpacity;
    private Paint mScrimPaint = new Paint();
    private Drawable mShadowEnd = null;
    private Drawable mShadowLeft = null;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight = null;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart = null;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    static {
        boolean bl = true;
        THEME_ATTRS = new int[]{16843828};
        LAYOUT_ATTRS = new int[]{16842931};
        boolean bl2 = Build.VERSION.SDK_INT >= 19;
        CAN_HIDE_DESCENDANTS = bl2;
        bl2 = Build.VERSION.SDK_INT >= 21 ? bl : false;
        SET_DRAWER_SHADOW_FROM_ELEVATION = bl2;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.setDescendantFocusability(262144);
        float f = this.getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int)(64.0f * f + 0.5f);
        float f2 = 400.0f * f;
        this.mLeftCallback = new ViewDragCallback(this, 3);
        this.mRightCallback = new ViewDragCallback(this, 5);
        attributeSet = ViewDragHelper.create((ViewGroup)this, (float)1.0f, (ViewDragHelper.Callback)this.mLeftCallback);
        this.mLeftDragger = attributeSet;
        attributeSet.setEdgeTrackingEnabled(1);
        this.mLeftDragger.setMinVelocity(f2);
        this.mLeftCallback.setDragger(this.mLeftDragger);
        attributeSet = ViewDragHelper.create((ViewGroup)this, (float)1.0f, (ViewDragHelper.Callback)this.mRightCallback);
        this.mRightDragger = attributeSet;
        attributeSet.setEdgeTrackingEnabled(2);
        this.mRightDragger.setMinVelocity(f2);
        this.mRightCallback.setDragger(this.mRightDragger);
        this.setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility((View)this, (int)1);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)new AccessibilityDelegate(this));
        this.setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows((View)this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
                this.setSystemUiVisibility(1280);
                attributeSet = context.obtainStyledAttributes(THEME_ATTRS);
                try {
                    this.mStatusBarBackground = attributeSet.getDrawable(0);
                }
                finally {
                    attributeSet.recycle();
                }
            } else {
                this.mStatusBarBackground = null;
            }
        }
        this.mDrawerElevation = f * 10.0f;
        this.mNonDrawerViews = new ArrayList();
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        boolean bl;
        if (!view.getMatrix().isIdentity()) {
            motionEvent = this.getTransformedMotionEvent(motionEvent, view);
            bl = view.dispatchGenericMotionEvent(motionEvent);
            motionEvent.recycle();
        } else {
            float f = this.getScrollX() - view.getLeft();
            float f2 = this.getScrollY() - view.getTop();
            motionEvent.offsetLocation(f, f2);
            bl = view.dispatchGenericMotionEvent(motionEvent);
            motionEvent.offsetLocation(-f, -f2);
        }
        return bl;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        float f = this.getScrollX() - view.getLeft();
        float f2 = this.getScrollY() - view.getTop();
        motionEvent = MotionEvent.obtain((MotionEvent)motionEvent);
        motionEvent.offsetLocation(f, f2);
        view = view.getMatrix();
        if (view.isIdentity()) return motionEvent;
        if (this.mChildInvertedMatrix == null) {
            this.mChildInvertedMatrix = new Matrix();
        }
        view.invert(this.mChildInvertedMatrix);
        motionEvent.transform(this.mChildInvertedMatrix);
        return motionEvent;
    }

    static String gravityToString(int n) {
        if ((n & 3) == 3) {
            return "LEFT";
        }
        if ((n & 5) != 5) return Integer.toHexString(n);
        return "RIGHT";
    }

    private static boolean hasOpaqueBackground(View view) {
        boolean bl;
        view = view.getBackground();
        boolean bl2 = bl = false;
        if (view == null) return bl2;
        bl2 = bl;
        if (view.getOpacity() != -1) return bl2;
        bl2 = true;
        return bl2;
    }

    private boolean hasPeekingDrawer() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            if (((LayoutParams)this.getChildAt((int)n2).getLayoutParams()).isPeeking) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        boolean bl = this.findVisibleDrawer() != null;
        return bl;
    }

    static boolean includeChildForAccessibility(View view) {
        boolean bl = ViewCompat.getImportantForAccessibility((View)view) != 4 && ViewCompat.getImportantForAccessibility((View)view) != 2;
        return bl;
    }

    private boolean isInBoundsOfChild(float f, float f2, View view) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        view.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int)f, (int)f2);
    }

    private boolean mirror(Drawable drawable, int n) {
        if (drawable == null) return false;
        if (!DrawableCompat.isAutoMirrored((Drawable)drawable)) {
            return false;
        }
        DrawableCompat.setLayoutDirection((Drawable)drawable, (int)n);
        return true;
    }

    private Drawable resolveLeftShadow() {
        int n = ViewCompat.getLayoutDirection((View)this);
        if (n == 0) {
            Drawable drawable = this.mShadowStart;
            if (drawable == null) return this.mShadowLeft;
            this.mirror(drawable, n);
            return this.mShadowStart;
        }
        Drawable drawable = this.mShadowEnd;
        if (drawable == null) return this.mShadowLeft;
        this.mirror(drawable, n);
        return this.mShadowEnd;
    }

    private Drawable resolveRightShadow() {
        int n = ViewCompat.getLayoutDirection((View)this);
        if (n == 0) {
            Drawable drawable = this.mShadowEnd;
            if (drawable == null) return this.mShadowRight;
            this.mirror(drawable, n);
            return this.mShadowEnd;
        }
        Drawable drawable = this.mShadowStart;
        if (drawable == null) return this.mShadowRight;
        this.mirror(drawable, n);
        return this.mShadowStart;
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        this.mShadowLeftResolved = this.resolveLeftShadow();
        this.mShadowRightResolved = this.resolveRightShadow();
    }

    private void updateChildrenImportantForAccessibility(View view, boolean bl) {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view2 = this.getChildAt(n2);
            if (!bl && !this.isDrawerView(view2) || bl && view2 == view) {
                ViewCompat.setImportantForAccessibility((View)view2, (int)1);
            } else {
                ViewCompat.setImportantForAccessibility((View)view2, (int)4);
            }
            ++n2;
        }
    }

    public void addDrawerListener(DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<DrawerListener>();
        }
        this.mListeners.add(drawerListener);
    }

    public void addFocusables(ArrayList<View> arrayList, int n, int n2) {
        View view;
        int n3;
        if (this.getDescendantFocusability() == 393216) {
            return;
        }
        int n4 = this.getChildCount();
        int n5 = 0;
        int n6 = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            view = this.getChildAt(n3);
            if (this.isDrawerView(view)) {
                if (!this.isDrawerOpen(view)) continue;
                view.addFocusables(arrayList, n, n2);
                n6 = 1;
                continue;
            }
            this.mNonDrawerViews.add(view);
        }
        if (n6 == 0) {
            n6 = this.mNonDrawerViews.size();
            for (n3 = n5; n3 < n6; ++n3) {
                view = this.mNonDrawerViews.get(n3);
                if (view.getVisibility() != 0) continue;
                view.addFocusables(arrayList, n, n2);
            }
        }
        this.mNonDrawerViews.clear();
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n, layoutParams);
        if (this.findOpenDrawer() == null && !this.isDrawerView(view)) {
            ViewCompat.setImportantForAccessibility((View)view, (int)1);
        } else {
            ViewCompat.setImportantForAccessibility((View)view, (int)4);
        }
        if (CAN_HIDE_DESCENDANTS) return;
        ViewCompat.setAccessibilityDelegate((View)view, (AccessibilityDelegateCompat)this.mChildAccessibilityDelegate);
    }

    void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch) return;
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain((long)l, (long)l, (int)3, (float)0.0f, (float)0.0f, (int)0);
        int n = this.getChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                motionEvent.recycle();
                this.mChildrenCanceledTouch = true;
                return;
            }
            this.getChildAt(n2).dispatchTouchEvent(motionEvent);
            ++n2;
        }
    }

    boolean checkDrawerViewAbsoluteGravity(View view, int n) {
        boolean bl = (this.getDrawerViewAbsoluteGravity(view) & n) == n;
        return bl;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = layoutParams instanceof LayoutParams && super.checkLayoutParams(layoutParams);
        return bl;
    }

    public void closeDrawer(int n) {
        this.closeDrawer(n, true);
    }

    public void closeDrawer(int n, boolean bl) {
        Object object = this.findDrawerWithGravity(n);
        if (object != null) {
            this.closeDrawer((View)object, bl);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No drawer view found with gravity ");
        ((StringBuilder)object).append(DrawerLayout.gravityToString(n));
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void closeDrawer(View view) {
        this.closeDrawer(view, true);
    }

    public void closeDrawer(View view, boolean bl) {
        if (!this.isDrawerView(view)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a sliding drawer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (this.mFirstLayout) {
            layoutParams.onScreen = 0.0f;
            layoutParams.openState = 0;
        } else if (bl) {
            layoutParams.openState |= 4;
            if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
                this.mLeftDragger.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
            } else {
                this.mRightDragger.smoothSlideViewTo(view, this.getWidth(), view.getTop());
            }
        } else {
            this.moveDrawerToOffset(view, 0.0f);
            this.updateDrawerState(layoutParams.gravity, 0, view);
            view.setVisibility(4);
        }
        this.invalidate();
    }

    public void closeDrawers() {
        this.closeDrawers(false);
    }

    void closeDrawers(boolean bl) {
        int n = this.getChildCount();
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= n) {
                this.mLeftCallback.removeCallbacks();
                this.mRightCallback.removeCallbacks();
                if (n3 == 0) return;
                this.invalidate();
                return;
            }
            View view = this.getChildAt(n2);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int n4 = n3;
            if (this.isDrawerView(view)) {
                if (bl && !layoutParams.isPeeking) {
                    n4 = n3;
                } else {
                    n4 = view.getWidth();
                    int n5 = (this.checkDrawerViewAbsoluteGravity(view, 3) ? this.mLeftDragger.smoothSlideViewTo(view, -n4, view.getTop()) : this.mRightDragger.smoothSlideViewTo(view, this.getWidth(), view.getTop())) ? 1 : 0;
                    n4 = n3 | n5;
                    layoutParams.isPeeking = false;
                }
            }
            ++n2;
            n3 = n4;
        }
    }

    public void computeScroll() {
        int n = this.getChildCount();
        float f = 0.0f;
        for (int i = 0; i < n; ++i) {
            f = Math.max(f, ((LayoutParams)this.getChildAt((int)i).getLayoutParams()).onScreen);
        }
        this.mScrimOpacity = f;
        boolean bl = this.mLeftDragger.continueSettling(true);
        boolean bl2 = this.mRightDragger.continueSettling(true);
        if (!bl) {
            if (!bl2) return;
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) return super.dispatchGenericMotionEvent(motionEvent);
        if (motionEvent.getAction() == 10) return super.dispatchGenericMotionEvent(motionEvent);
        if (this.mScrimOpacity <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int n = this.getChildCount();
        if (n == 0) return false;
        float f = motionEvent.getX();
        float f2 = motionEvent.getY();
        --n;
        while (n >= 0) {
            View view = this.getChildAt(n);
            if (this.isInBoundsOfChild(f, f2, view) && !this.isContentView(view) && this.dispatchTransformedGenericPointerEvent(motionEvent, view)) {
                return true;
            }
            --n;
        }
        return false;
    }

    void dispatchOnDrawerClosed(View view) {
        Object object = (LayoutParams)view.getLayoutParams();
        if ((((LayoutParams)object).openState & 1) != 1) return;
        ((LayoutParams)object).openState = 0;
        object = this.mListeners;
        if (object != null) {
            for (int i = object.size() - 1; i >= 0; --i) {
                this.mListeners.get(i).onDrawerClosed(view);
            }
        }
        this.updateChildrenImportantForAccessibility(view, false);
        if (!this.hasWindowFocus()) return;
        view = this.getRootView();
        if (view == null) return;
        view.sendAccessibilityEvent(32);
    }

    void dispatchOnDrawerOpened(View view) {
        Object object = (LayoutParams)view.getLayoutParams();
        if ((((LayoutParams)object).openState & 1) != 0) return;
        ((LayoutParams)object).openState = 1;
        object = this.mListeners;
        if (object != null) {
            for (int i = object.size() - 1; i >= 0; --i) {
                this.mListeners.get(i).onDrawerOpened(view);
            }
        }
        this.updateChildrenImportantForAccessibility(view, true);
        if (!this.hasWindowFocus()) return;
        this.sendAccessibilityEvent(32);
    }

    void dispatchOnDrawerSlide(View view, float f) {
        List<DrawerListener> list = this.mListeners;
        if (list == null) return;
        int n = list.size() - 1;
        while (n >= 0) {
            this.mListeners.get(n).onDrawerSlide(view, f);
            --n;
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        int n;
        int n2 = this.getHeight();
        boolean bl = this.isContentView(view);
        int n3 = this.getWidth();
        int n4 = canvas.save();
        int n5 = 0;
        int n6 = n3;
        if (bl) {
            int n7 = this.getChildCount();
            n6 = 0;
            for (n5 = 0; n5 < n7; ++n5) {
                View view2 = this.getChildAt(n5);
                n = n3;
                int n8 = n6;
                if (view2 != view) {
                    n = n3;
                    n8 = n6;
                    if (view2.getVisibility() == 0) {
                        n = n3;
                        n8 = n6;
                        if (DrawerLayout.hasOpaqueBackground(view2)) {
                            n = n3;
                            n8 = n6;
                            if (this.isDrawerView(view2)) {
                                int n9;
                                if (view2.getHeight() < n2) {
                                    n = n3;
                                    n8 = n6;
                                } else if (this.checkDrawerViewAbsoluteGravity(view2, 3)) {
                                    n9 = view2.getRight();
                                    n = n3;
                                    n8 = n6;
                                    if (n9 > n6) {
                                        n8 = n9;
                                        n = n3;
                                    }
                                } else {
                                    n9 = view2.getLeft();
                                    n = n3;
                                    n8 = n6;
                                    if (n9 < n3) {
                                        n = n9;
                                        n8 = n6;
                                    }
                                }
                            }
                        }
                    }
                }
                n3 = n;
                n6 = n8;
            }
            canvas.clipRect(n6, 0, n3, this.getHeight());
            n5 = n6;
            n6 = n3;
        }
        boolean bl2 = super.drawChild(canvas, view, l);
        canvas.restoreToCount(n4);
        float f = this.mScrimOpacity;
        if (f > 0.0f && bl) {
            n = this.mScrimColor;
            n3 = (int)((float)((0xFF000000 & n) >>> 24) * f);
            this.mScrimPaint.setColor(n & 0xFFFFFF | n3 << 24);
            canvas.drawRect((float)n5, 0.0f, (float)n6, (float)this.getHeight(), this.mScrimPaint);
        } else if (this.mShadowLeftResolved != null && this.checkDrawerViewAbsoluteGravity(view, 3)) {
            n3 = this.mShadowLeftResolved.getIntrinsicWidth();
            n6 = view.getRight();
            n5 = this.mLeftDragger.getEdgeSize();
            f = Math.max(0.0f, Math.min((float)n6 / (float)n5, 1.0f));
            this.mShadowLeftResolved.setBounds(n6, view.getTop(), n3 + n6, view.getBottom());
            this.mShadowLeftResolved.setAlpha((int)(f * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
        } else {
            if (this.mShadowRightResolved == null) return bl2;
            if (!this.checkDrawerViewAbsoluteGravity(view, 5)) return bl2;
            n5 = this.mShadowRightResolved.getIntrinsicWidth();
            n3 = view.getLeft();
            n = this.getWidth();
            n6 = this.mRightDragger.getEdgeSize();
            f = Math.max(0.0f, Math.min((float)(n - n3) / (float)n6, 1.0f));
            this.mShadowRightResolved.setBounds(n3 - n5, view.getTop(), n3, view.getBottom());
            this.mShadowRightResolved.setAlpha((int)(f * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return bl2;
    }

    View findDrawerWithGravity(int n) {
        int n2 = GravityCompat.getAbsoluteGravity((int)n, (int)ViewCompat.getLayoutDirection((View)this));
        int n3 = this.getChildCount();
        n = 0;
        while (n < n3) {
            View view = this.getChildAt(n);
            if ((this.getDrawerViewAbsoluteGravity(view) & 7) == (n2 & 7)) {
                return view;
            }
            ++n;
        }
        return null;
    }

    View findOpenDrawer() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = this.getChildAt(n2);
            if ((((LayoutParams)view.getLayoutParams()).openState & 1) == 1) {
                return view;
            }
            ++n2;
        }
        return null;
    }

    View findVisibleDrawer() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = this.getChildAt(n2);
            if (this.isDrawerView(view) && this.isDrawerVisible(view)) {
                return view;
            }
            ++n2;
        }
        return null;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams)layoutParams) : (layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams)layoutParams) : new LayoutParams(layoutParams));
        return layoutParams;
    }

    public float getDrawerElevation() {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) return 0.0f;
        return this.mDrawerElevation;
    }

    public int getDrawerLockMode(int n) {
        int n2 = ViewCompat.getLayoutDirection((View)this);
        if (n != 3) {
            if (n != 5) {
                if (n != 0x800003) {
                    if (n != 0x800005) {
                        return 0;
                    }
                    n = this.mLockModeEnd;
                    if (n != 3) {
                        return n;
                    }
                    n = n2 == 0 ? this.mLockModeRight : this.mLockModeLeft;
                    if (n == 3) return 0;
                    return n;
                }
                n = this.mLockModeStart;
                if (n != 3) {
                    return n;
                }
                n = n2 == 0 ? this.mLockModeLeft : this.mLockModeRight;
                if (n == 3) return 0;
                return n;
            }
            n = this.mLockModeRight;
            if (n != 3) {
                return n;
            }
            n = n2 == 0 ? this.mLockModeEnd : this.mLockModeStart;
            if (n == 3) return 0;
            return n;
        }
        n = this.mLockModeLeft;
        if (n != 3) {
            return n;
        }
        n = n2 == 0 ? this.mLockModeStart : this.mLockModeEnd;
        if (n == 3) return 0;
        return n;
    }

    public int getDrawerLockMode(View view) {
        if (this.isDrawerView(view)) {
            return this.getDrawerLockMode(((LayoutParams)view.getLayoutParams()).gravity);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a drawer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public CharSequence getDrawerTitle(int n) {
        if ((n = GravityCompat.getAbsoluteGravity((int)n, (int)ViewCompat.getLayoutDirection((View)this))) == 3) {
            return this.mTitleLeft;
        }
        if (n != 5) return null;
        return this.mTitleRight;
    }

    int getDrawerViewAbsoluteGravity(View view) {
        return GravityCompat.getAbsoluteGravity((int)((LayoutParams)view.getLayoutParams()).gravity, (int)ViewCompat.getLayoutDirection((View)this));
    }

    float getDrawerViewOffset(View view) {
        return ((LayoutParams)view.getLayoutParams()).onScreen;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    boolean isContentView(View view) {
        boolean bl = ((LayoutParams)view.getLayoutParams()).gravity == 0;
        return bl;
    }

    public boolean isDrawerOpen(int n) {
        View view = this.findDrawerWithGravity(n);
        if (view == null) return false;
        return this.isDrawerOpen(view);
    }

    public boolean isDrawerOpen(View view) {
        if (!this.isDrawerView(view)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a drawer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int n = ((LayoutParams)view.getLayoutParams()).openState;
        boolean bl = true;
        if ((n & 1) == 1) return bl;
        bl = false;
        return bl;
    }

    boolean isDrawerView(View view) {
        int n = GravityCompat.getAbsoluteGravity((int)((LayoutParams)view.getLayoutParams()).gravity, (int)ViewCompat.getLayoutDirection((View)view));
        if ((n & 3) != 0) {
            return true;
        }
        if ((n & 5) == 0) return false;
        return true;
    }

    public boolean isDrawerVisible(int n) {
        View view = this.findDrawerWithGravity(n);
        if (view == null) return false;
        return this.isDrawerVisible(view);
    }

    public boolean isDrawerVisible(View view) {
        if (!this.isDrawerView(view)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a drawer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        boolean bl = ((LayoutParams)view.getLayoutParams()).onScreen > 0.0f;
        return bl;
    }

    void moveDrawerToOffset(View view, float f) {
        float f2 = this.getDrawerViewOffset(view);
        float f3 = view.getWidth();
        int n = (int)(f2 * f3);
        n = (int)(f3 * f) - n;
        if (!this.checkDrawerViewAbsoluteGravity(view, 3)) {
            n = -n;
        }
        view.offsetLeftAndRight(n);
        this.setDrawerViewOffset(view, f);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public void onDraw(Canvas canvas) {
        Object object;
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground) return;
        if (this.mStatusBarBackground == null) return;
        int n = Build.VERSION.SDK_INT >= 21 && (object = this.mLastInsets) != null ? ((WindowInsets)object).getSystemWindowInsetTop() : 0;
        if (n <= 0) return;
        this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), n);
        this.mStatusBarBackground.draw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        int n;
        block5: {
            block1: {
                block4: {
                    block2: {
                        block3: {
                            n = motionEvent.getActionMasked();
                            bl3 = this.mLeftDragger.shouldInterceptTouchEvent(motionEvent);
                            bl2 = this.mRightDragger.shouldInterceptTouchEvent(motionEvent);
                            bl = true;
                            if (n == 0) break block1;
                            if (n == 1) break block2;
                            if (n == 2) break block3;
                            if (n == 3) break block2;
                            break block4;
                        }
                        if (this.mLeftDragger.checkTouchSlop(3)) {
                            this.mLeftCallback.removeCallbacks();
                            this.mRightCallback.removeCallbacks();
                        }
                        break block4;
                    }
                    this.closeDrawers(true);
                    this.mDisallowInterceptRequested = false;
                    this.mChildrenCanceledTouch = false;
                }
                n = 0;
                break block5;
            }
            float f = motionEvent.getX();
            float f2 = motionEvent.getY();
            this.mInitialMotionX = f;
            this.mInitialMotionY = f2;
            n = this.mScrimOpacity > 0.0f && (motionEvent = this.mLeftDragger.findTopChildUnder((int)f, (int)f2)) != null && this.isContentView((View)motionEvent) ? 1 : 0;
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        }
        boolean bl4 = bl;
        if (bl3 | bl2) return bl4;
        bl4 = bl;
        if (n != 0) return bl4;
        bl4 = bl;
        if (this.hasPeekingDrawer()) return bl4;
        bl4 = this.mChildrenCanceledTouch ? bl : false;
        return bl4;
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (n != 4) return super.onKeyDown(n, keyEvent);
        if (!this.hasVisibleDrawer()) return super.onKeyDown(n, keyEvent);
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        if (n != 4) return super.onKeyUp(n, keyEvent);
        keyEvent = this.findVisibleDrawer();
        if (keyEvent != null && this.getDrawerLockMode((View)keyEvent) == 0) {
            this.closeDrawers();
        }
        boolean bl = keyEvent != null;
        return bl;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        this.mInLayout = true;
        int n5 = n3 - n;
        int n6 = this.getChildCount();
        n3 = 0;
        while (true) {
            if (n3 >= n6) {
                this.mInLayout = false;
                this.mFirstLayout = false;
                return;
            }
            View view = this.getChildAt(n3);
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (this.isContentView(view)) {
                    view.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + view.getMeasuredWidth(), layoutParams.topMargin + view.getMeasuredHeight());
                } else {
                    int n7;
                    float f;
                    int n8 = view.getMeasuredWidth();
                    int n9 = view.getMeasuredHeight();
                    if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
                        n = -n8;
                        f = n8;
                        n7 = n + (int)(layoutParams.onScreen * f);
                        f = (float)(n8 + n7) / f;
                    } else {
                        f = n8;
                        n7 = n5 - (int)(layoutParams.onScreen * f);
                        f = (float)(n5 - n7) / f;
                    }
                    boolean bl2 = f != layoutParams.onScreen;
                    n = layoutParams.gravity & 0x70;
                    if (n != 16) {
                        if (n != 80) {
                            view.layout(n7, layoutParams.topMargin, n8 + n7, layoutParams.topMargin + n9);
                        } else {
                            n = n4 - n2;
                            view.layout(n7, n - layoutParams.bottomMargin - view.getMeasuredHeight(), n8 + n7, n - layoutParams.bottomMargin);
                        }
                    } else {
                        int n10 = n4 - n2;
                        int n11 = (n10 - n9) / 2;
                        if (n11 < layoutParams.topMargin) {
                            n = layoutParams.topMargin;
                        } else {
                            n = n11;
                            if (n11 + n9 > n10 - layoutParams.bottomMargin) {
                                n = n10 - layoutParams.bottomMargin - n9;
                            }
                        }
                        view.layout(n7, n, n8 + n7, n9 + n);
                    }
                    if (bl2) {
                        this.setDrawerViewOffset(view, f);
                    }
                    n = layoutParams.onScreen > 0.0f ? 0 : 4;
                    if (view.getVisibility() != n) {
                        view.setVisibility(n);
                    }
                }
            }
            ++n3;
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        block30: {
            block29: {
                n8 = View.MeasureSpec.getMode((int)n);
                n7 = View.MeasureSpec.getMode((int)n2);
                n6 = View.MeasureSpec.getSize((int)n);
                n5 = View.MeasureSpec.getSize((int)n2);
                if (n8 != 0x40000000) break block29;
                n4 = n6;
                n3 = n5;
                if (n7 == 0x40000000) break block30;
            }
            if (!this.isInEditMode()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
                throw illegalArgumentException;
            }
            if (n8 != Integer.MIN_VALUE && n8 == 0) {
                n6 = 300;
            }
            if (n7 == Integer.MIN_VALUE) {
                n4 = n6;
                n3 = n5;
            } else {
                n4 = n6;
                n3 = n5;
                if (n7 == 0) {
                    n3 = 300;
                    n4 = n6;
                }
            }
        }
        this.setMeasuredDimension(n4, n3);
        n7 = this.mLastInsets != null && ViewCompat.getFitsSystemWindows((View)this) ? 1 : 0;
        int n9 = ViewCompat.getLayoutDirection((View)this);
        int n10 = this.getChildCount();
        n8 = 0;
        n5 = 0;
        n6 = 0;
        while (n8 < n10) {
            View view = this.getChildAt(n8);
            if (view.getVisibility() != 8) {
                StringBuilder stringBuilder;
                int n11;
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (n7 != 0) {
                    WindowInsets windowInsets;
                    n11 = GravityCompat.getAbsoluteGravity((int)layoutParams.gravity, (int)n9);
                    if (ViewCompat.getFitsSystemWindows((View)view)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            windowInsets = (WindowInsets)this.mLastInsets;
                            if (n11 == 3) {
                                stringBuilder = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                            } else {
                                stringBuilder = windowInsets;
                                if (n11 == 5) {
                                    stringBuilder = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                                }
                            }
                            view.dispatchApplyWindowInsets((WindowInsets)stringBuilder);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        windowInsets = (WindowInsets)this.mLastInsets;
                        if (n11 == 3) {
                            stringBuilder = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else {
                            stringBuilder = windowInsets;
                            if (n11 == 5) {
                                stringBuilder = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                        }
                        layoutParams.leftMargin = stringBuilder.getSystemWindowInsetLeft();
                        layoutParams.topMargin = stringBuilder.getSystemWindowInsetTop();
                        layoutParams.rightMargin = stringBuilder.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = stringBuilder.getSystemWindowInsetBottom();
                    }
                }
                if (this.isContentView(view)) {
                    view.measure(View.MeasureSpec.makeMeasureSpec((int)(n4 - layoutParams.leftMargin - layoutParams.rightMargin), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n3 - layoutParams.topMargin - layoutParams.bottomMargin), (int)0x40000000));
                } else {
                    int n12;
                    float f;
                    float f2;
                    if (!this.isDrawerView(view)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Child ");
                        stringBuilder.append(view);
                        stringBuilder.append(" at index ");
                        stringBuilder.append(n8);
                        stringBuilder.append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
                        stringBuilder.append("Gravity.RIGHT or Gravity.NO_GRAVITY");
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION && (f2 = ViewCompat.getElevation((View)view)) != (f = this.mDrawerElevation)) {
                        ViewCompat.setElevation((View)view, (float)f);
                    }
                    if ((n11 = (n12 = this.getDrawerViewAbsoluteGravity(view) & 7) == 3 ? 1 : 0) != 0 && n5 != 0 || n11 == 0 && n6 != 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Child drawer has absolute gravity ");
                        stringBuilder.append(DrawerLayout.gravityToString(n12));
                        stringBuilder.append(" but this ");
                        stringBuilder.append(TAG);
                        stringBuilder.append(" already has a ");
                        stringBuilder.append("drawer view along that edge");
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    if (n11 != 0) {
                        n5 = 1;
                    } else {
                        n6 = 1;
                    }
                    view.measure(DrawerLayout.getChildMeasureSpec((int)n, (int)(this.mMinDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin), (int)layoutParams.width), DrawerLayout.getChildMeasureSpec((int)n2, (int)(layoutParams.topMargin + layoutParams.bottomMargin), (int)layoutParams.height));
                }
            }
            ++n8;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        View view;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (parcelable.openDrawerGravity != 0 && (view = this.findDrawerWithGravity(parcelable.openDrawerGravity)) != null) {
            this.openDrawer(view);
        }
        if (parcelable.lockModeLeft != 3) {
            this.setDrawerLockMode(parcelable.lockModeLeft, 3);
        }
        if (parcelable.lockModeRight != 3) {
            this.setDrawerLockMode(parcelable.lockModeRight, 5);
        }
        if (parcelable.lockModeStart != 3) {
            this.setDrawerLockMode(parcelable.lockModeStart, 0x800003);
        }
        if (parcelable.lockModeEnd == 3) return;
        this.setDrawerLockMode(parcelable.lockModeEnd, 0x800005);
    }

    public void onRtlPropertiesChanged(int n) {
        this.resolveShadowDrawables();
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int n = this.getChildCount();
        for (int i = 0; i < n; ++i) {
            LayoutParams layoutParams = (LayoutParams)this.getChildAt(i).getLayoutParams();
            int n2 = layoutParams.openState;
            boolean bl = true;
            n2 = n2 == 1 ? 1 : 0;
            if (layoutParams.openState != 2) {
                bl = false;
            }
            if (n2 == 0 && !bl) {
                continue;
            }
            savedState.openDrawerGravity = layoutParams.gravity;
            break;
        }
        savedState.lockModeLeft = this.mLockModeLeft;
        savedState.lockModeRight = this.mLockModeRight;
        savedState.lockModeStart = this.mLockModeStart;
        savedState.lockModeEnd = this.mLockModeEnd;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mLeftDragger.processTouchEvent(motionEvent);
        this.mRightDragger.processTouchEvent(motionEvent);
        int n = motionEvent.getAction() & 0xFF;
        if (n != 0) {
            if (n != 1) {
                if (n != 3) return true;
                this.closeDrawers(true);
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
            } else {
                float f;
                float f2 = motionEvent.getX();
                boolean bl = (motionEvent = this.mLeftDragger.findTopChildUnder((int)f2, (int)(f = motionEvent.getY()))) == null || !this.isContentView((View)motionEvent) || !((f2 -= this.mInitialMotionX) * f2 + (f -= this.mInitialMotionY) * f < (float)((n = this.mLeftDragger.getTouchSlop()) * n)) || (motionEvent = this.findOpenDrawer()) == null || this.getDrawerLockMode((View)motionEvent) == 2;
                this.closeDrawers(bl);
                this.mDisallowInterceptRequested = false;
            }
        } else {
            float f = motionEvent.getX();
            float f3 = motionEvent.getY();
            this.mInitialMotionX = f;
            this.mInitialMotionY = f3;
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        }
        return true;
    }

    public void openDrawer(int n) {
        this.openDrawer(n, true);
    }

    public void openDrawer(int n, boolean bl) {
        Object object = this.findDrawerWithGravity(n);
        if (object != null) {
            this.openDrawer((View)object, bl);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No drawer view found with gravity ");
        ((StringBuilder)object).append(DrawerLayout.gravityToString(n));
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void openDrawer(View view) {
        this.openDrawer(view, true);
    }

    public void openDrawer(View view, boolean bl) {
        if (!this.isDrawerView(view)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a sliding drawer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (this.mFirstLayout) {
            layoutParams.onScreen = 1.0f;
            layoutParams.openState = 1;
            this.updateChildrenImportantForAccessibility(view, true);
        } else if (bl) {
            layoutParams.openState |= 2;
            if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
                this.mLeftDragger.smoothSlideViewTo(view, 0, view.getTop());
            } else {
                this.mRightDragger.smoothSlideViewTo(view, this.getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            this.moveDrawerToOffset(view, 1.0f);
            this.updateDrawerState(layoutParams.gravity, 0, view);
            view.setVisibility(0);
        }
        this.invalidate();
    }

    public void removeDrawerListener(DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        List<DrawerListener> list = this.mListeners;
        if (list == null) {
            return;
        }
        list.remove(drawerListener);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl) {
        super.requestDisallowInterceptTouchEvent(bl);
        this.mDisallowInterceptRequested = bl;
        if (!bl) return;
        this.closeDrawers(true);
    }

    public void requestLayout() {
        if (this.mInLayout) return;
        super.requestLayout();
    }

    public void setChildInsets(Object object, boolean bl) {
        this.mLastInsets = object;
        this.mDrawStatusBarBackground = bl;
        bl = !bl && this.getBackground() == null;
        this.setWillNotDraw(bl);
        this.requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.mDrawerElevation = f;
        int n = 0;
        while (n < this.getChildCount()) {
            View view = this.getChildAt(n);
            if (this.isDrawerView(view)) {
                ViewCompat.setElevation((View)view, (float)this.mDrawerElevation);
            }
            ++n;
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.mListener;
        if (drawerListener2 != null) {
            this.removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            this.addDrawerListener(drawerListener);
        }
        this.mListener = drawerListener;
    }

    public void setDrawerLockMode(int n) {
        this.setDrawerLockMode(n, 3);
        this.setDrawerLockMode(n, 5);
    }

    public void setDrawerLockMode(int n, int n2) {
        ViewDragHelper viewDragHelper;
        int n3 = GravityCompat.getAbsoluteGravity((int)n2, (int)ViewCompat.getLayoutDirection((View)this));
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 0x800003) {
                    if (n2 == 0x800005) {
                        this.mLockModeEnd = n;
                    }
                } else {
                    this.mLockModeStart = n;
                }
            } else {
                this.mLockModeRight = n;
            }
        } else {
            this.mLockModeLeft = n;
        }
        if (n != 0) {
            viewDragHelper = n3 == 3 ? this.mLeftDragger : this.mRightDragger;
            viewDragHelper.cancel();
        }
        if (n != 1) {
            if (n != 2) return;
            viewDragHelper = this.findDrawerWithGravity(n3);
            if (viewDragHelper == null) return;
            this.openDrawer((View)viewDragHelper);
        } else {
            viewDragHelper = this.findDrawerWithGravity(n3);
            if (viewDragHelper == null) return;
            this.closeDrawer((View)viewDragHelper);
        }
    }

    public void setDrawerLockMode(int n, View view) {
        if (this.isDrawerView(view)) {
            this.setDrawerLockMode(n, ((LayoutParams)view.getLayoutParams()).gravity);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a ");
        stringBuilder.append("drawer with appropriate layout_gravity");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setDrawerShadow(int n, int n2) {
        this.setDrawerShadow(ContextCompat.getDrawable((Context)this.getContext(), (int)n), n2);
    }

    public void setDrawerShadow(Drawable drawable, int n) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        if ((n & 0x800003) == 0x800003) {
            this.mShadowStart = drawable;
        } else if ((n & 0x800005) == 0x800005) {
            this.mShadowEnd = drawable;
        } else if ((n & 3) == 3) {
            this.mShadowLeft = drawable;
        } else {
            if ((n & 5) != 5) return;
            this.mShadowRight = drawable;
        }
        this.resolveShadowDrawables();
        this.invalidate();
    }

    public void setDrawerTitle(int n, CharSequence charSequence) {
        if ((n = GravityCompat.getAbsoluteGravity((int)n, (int)ViewCompat.getLayoutDirection((View)this))) == 3) {
            this.mTitleLeft = charSequence;
        } else {
            if (n != 5) return;
            this.mTitleRight = charSequence;
        }
    }

    void setDrawerViewOffset(View view, float f) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (f == layoutParams.onScreen) {
            return;
        }
        layoutParams.onScreen = f;
        this.dispatchOnDrawerSlide(view, f);
    }

    public void setScrimColor(int n) {
        this.mScrimColor = n;
        this.invalidate();
    }

    public void setStatusBarBackground(int n) {
        Drawable drawable = n != 0 ? ContextCompat.getDrawable((Context)this.getContext(), (int)n) : null;
        this.mStatusBarBackground = drawable;
        this.invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.mStatusBarBackground = drawable;
        this.invalidate();
    }

    public void setStatusBarBackgroundColor(int n) {
        this.mStatusBarBackground = new ColorDrawable(n);
        this.invalidate();
    }

    void updateDrawerState(int n, int n2, View object) {
        int n3 = this.mLeftDragger.getViewDragState();
        int n4 = this.mRightDragger.getViewDragState();
        int n5 = 2;
        if (n3 != 1 && n4 != 1) {
            n = n5;
            if (n3 != 2) {
                n = n4 == 2 ? n5 : 0;
            }
        } else {
            n = 1;
        }
        if (object != null && n2 == 0) {
            LayoutParams layoutParams = (LayoutParams)object.getLayoutParams();
            if (layoutParams.onScreen == 0.0f) {
                this.dispatchOnDrawerClosed((View)object);
            } else if (layoutParams.onScreen == 1.0f) {
                this.dispatchOnDrawerOpened((View)object);
            }
        }
        if (n == this.mDrawerState) return;
        this.mDrawerState = n;
        object = this.mListeners;
        if (object == null) return;
        n2 = object.size() - 1;
        while (n2 >= 0) {
            this.mListeners.get(n2).onDrawerStateChanged(n);
            --n2;
        }
    }
}
