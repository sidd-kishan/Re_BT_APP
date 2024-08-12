/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.ViewCompat
 *  androidx.customview.widget.ViewDragHelper
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$styleable
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable
 */
package com.google.android.material.bottomsheet;

import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
extends CoordinatorLayout.Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int activePointerId;
    private BottomSheetCallback callback;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback = new /* Unavailable Anonymous Inner Class!! */;
    private boolean fitToContents = true;
    int fitToContentsOffset;
    int halfExpandedOffset;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int lastNestedScrollDy;
    private int lastPeekHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private boolean skipCollapsed;
    int state = 4;
    boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue typedValue = attributeSet.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValue != null && typedValue.data == -1) {
            this.setPeekHeight(typedValue.data);
        } else {
            this.setPeekHeight(attributeSet.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        this.setHideable(attributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.setFitToContents(attributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        this.setSkipCollapsed(attributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        attributeSet.recycle();
        this.maximumVelocity = ViewConfiguration.get((Context)context).getScaledMaximumFlingVelocity();
    }

    static /* synthetic */ boolean access$000(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.fitToContents;
    }

    static /* synthetic */ int access$100(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.getExpandedOffset();
    }

    private void calculateCollapsedOffset() {
        this.collapsedOffset = this.fitToContents ? Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset) : this.parentHeight - this.lastPeekHeight;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V object) {
        if (!((object = object.getLayoutParams()) instanceof CoordinatorLayout.LayoutParams)) throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        if (!((object = ((CoordinatorLayout.LayoutParams)object).getBehavior()) instanceof BottomSheetBehavior)) throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        return (BottomSheetBehavior)((Object)object);
    }

    private int getExpandedOffset() {
        int n = this.fitToContents ? this.fitToContentsOffset : 0;
        return n;
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) return;
        velocityTracker.recycle();
        this.velocityTracker = null;
    }

    private void updateImportantForAccessibility(boolean bl) {
        ViewParent viewParent = this.viewRef;
        if (viewParent == null) {
            return;
        }
        if (!((viewParent = ((View)viewParent.get()).getParent()) instanceof CoordinatorLayout)) {
            return;
        }
        viewParent = (CoordinatorLayout)viewParent;
        int n = viewParent.getChildCount();
        if (Build.VERSION.SDK_INT >= 16 && bl) {
            if (this.importantForAccessibilityMap != null) return;
            this.importantForAccessibilityMap = new HashMap<View, Integer>(n);
        }
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (bl) return;
                this.importantForAccessibilityMap = null;
                return;
            }
            View view = viewParent.getChildAt(n2);
            if (view != this.viewRef.get()) {
                if (!bl) {
                    Map<View, Integer> map = this.importantForAccessibilityMap;
                    if (map != null && map.containsKey(view)) {
                        ViewCompat.setImportantForAccessibility((View)view, (int)this.importantForAccessibilityMap.get(view));
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.importantForAccessibilityMap.put(view, view.getImportantForAccessibility());
                    }
                    ViewCompat.setImportantForAccessibility((View)view, (int)4);
                }
            }
            ++n2;
        }
    }

    void dispatchOnSlide(int n) {
        View view = (View)this.viewRef.get();
        if (view == null) return;
        BottomSheetCallback bottomSheetCallback = this.callback;
        if (bottomSheetCallback == null) return;
        int n2 = this.collapsedOffset;
        if (n > n2) {
            bottomSheetCallback.onSlide(view, (float)(n2 - n) / (float)(this.parentHeight - n2));
        } else {
            bottomSheetCallback.onSlide(view, (float)(n2 - n) / (float)(n2 - this.getExpandedOffset()));
        }
    }

    View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled((View)view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) return null;
        ViewGroup viewGroup = (ViewGroup)view;
        int n = 0;
        int n2 = viewGroup.getChildCount();
        while (n < n2) {
            view = this.findScrollingChild(viewGroup.getChildAt(n));
            if (view != null) {
                return view;
            }
            ++n;
        }
        return null;
    }

    public final int getPeekHeight() {
        int n = this.peekHeightAuto ? -1 : this.peekHeight;
        return n;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public final int getState() {
        return this.state;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V object, MotionEvent motionEvent) {
        Object object2;
        boolean bl = object.isShown();
        boolean bl2 = false;
        if (!bl) {
            this.ignoreEvents = true;
            return false;
        }
        int n = motionEvent.getActionMasked();
        if (n == 0) {
            this.reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        Object var9_7 = null;
        if (n != 0) {
            if (n == 1 || n == 3) {
                this.touchingScrollingChild = false;
                this.activePointerId = -1;
                if (this.ignoreEvents) {
                    this.ignoreEvents = false;
                    return false;
                }
            }
        } else {
            int n2 = (int)motionEvent.getX();
            this.initialY = (int)motionEvent.getY();
            object2 = this.nestedScrollingChildRef;
            object2 = object2 != null ? (View)object2.get() : null;
            if (object2 != null && coordinatorLayout.isPointInChildBounds(object2, n2, this.initialY)) {
                this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.touchingScrollingChild = true;
            }
            bl = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(object, n2, this.initialY);
            this.ignoreEvents = bl;
        }
        if (!this.ignoreEvents && (object = this.viewDragHelper) != null && object.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        object2 = this.nestedScrollingChildRef;
        object = var9_7;
        if (object2 != null) {
            object = (View)object2.get();
        }
        bl = bl2;
        if (n != 2) return bl;
        bl = bl2;
        if (object == null) return bl;
        bl = bl2;
        if (this.ignoreEvents) return bl;
        bl = bl2;
        if (this.state == 1) return bl;
        bl = bl2;
        if (coordinatorLayout.isPointInChildBounds(object, (int)motionEvent.getX(), (int)motionEvent.getY())) return bl;
        bl = bl2;
        if (this.viewDragHelper == null) return bl;
        bl = bl2;
        if (!(Math.abs((float)this.initialY - motionEvent.getY()) > (float)this.viewDragHelper.getTouchSlop())) return bl;
        bl = true;
        return bl;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int n) {
        if (ViewCompat.getFitsSystemWindows((View)coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        int n2 = v.getTop();
        coordinatorLayout.onLayoutChild(v, n);
        this.parentHeight = coordinatorLayout.getHeight();
        if (this.peekHeightAuto) {
            if (this.peekHeightMin == 0) {
                this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - coordinatorLayout.getWidth() * 9 / 16);
        } else {
            this.lastPeekHeight = this.peekHeight;
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - v.getHeight());
        this.halfExpandedOffset = this.parentHeight / 2;
        this.calculateCollapsedOffset();
        n = this.state;
        if (n == 3) {
            ViewCompat.offsetTopAndBottom(v, (int)this.getExpandedOffset());
        } else if (n == 6) {
            ViewCompat.offsetTopAndBottom(v, (int)this.halfExpandedOffset);
        } else if (this.hideable && n == 5) {
            ViewCompat.offsetTopAndBottom(v, (int)this.parentHeight);
        } else {
            n = this.state;
            if (n == 4) {
                ViewCompat.offsetTopAndBottom(v, (int)this.collapsedOffset);
            } else if (n == 1 || n == 2) {
                ViewCompat.offsetTopAndBottom(v, (int)(n2 - v.getTop()));
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create((ViewGroup)coordinatorLayout, (ViewDragHelper.Callback)this.dragCallback);
        }
        this.viewRef = new WeakReference<V>(v);
        this.nestedScrollingChildRef = new WeakReference<View>(this.findScrollingChild((View)v));
        return true;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        boolean bl = view == this.nestedScrollingChildRef.get() && (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
        return bl;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n, int n2, int[] nArray, int n3) {
        if (n3 == 1) {
            return;
        }
        if (view != (View)this.nestedScrollingChildRef.get()) {
            return;
        }
        int n4 = v.getTop();
        n = n4 - n2;
        if (n2 > 0) {
            if (n < this.getExpandedOffset()) {
                nArray[1] = n4 - this.getExpandedOffset();
                ViewCompat.offsetTopAndBottom(v, (int)(-nArray[1]));
                this.setStateInternal(3);
            } else {
                nArray[1] = n2;
                ViewCompat.offsetTopAndBottom(v, (int)(-n2));
                this.setStateInternal(1);
            }
        } else if (n2 < 0 && !view.canScrollVertically(-1)) {
            n3 = this.collapsedOffset;
            if (n > n3 && !this.hideable) {
                nArray[1] = n4 - n3;
                ViewCompat.offsetTopAndBottom(v, (int)(-nArray[1]));
                this.setStateInternal(4);
            } else {
                nArray[1] = n2;
                ViewCompat.offsetTopAndBottom(v, (int)(-n2));
                this.setStateInternal(1);
            }
        }
        this.dispatchOnSlide(v.getTop());
        this.lastNestedScrollDy = n2;
        this.nestedScrolled = true;
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, parcelable.getSuperState());
        this.state = parcelable.state != 1 && parcelable.state != 2 ? parcelable.state : 4;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.state);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int n, int n2) {
        boolean bl = false;
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((n & 2) == 0) return bl;
        bl = true;
        return bl;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n) {
        int n2;
        block4: {
            block9: {
                block6: {
                    block13: {
                        block12: {
                            int n3;
                            block10: {
                                block11: {
                                    block7: {
                                        block8: {
                                            block5: {
                                                block3: {
                                                    n = v.getTop();
                                                    n3 = this.getExpandedOffset();
                                                    n2 = 3;
                                                    if (n == n3) {
                                                        this.setStateInternal(3);
                                                        return;
                                                    }
                                                    if (view != this.nestedScrollingChildRef.get()) return;
                                                    if (!this.nestedScrolled) return;
                                                    if (this.lastNestedScrollDy <= 0) break block3;
                                                    n = this.getExpandedOffset();
                                                    break block4;
                                                }
                                                if (!this.hideable || !this.shouldHide((View)v, this.getYVelocity())) break block5;
                                                n = this.parentHeight;
                                                n2 = 5;
                                                break block4;
                                            }
                                            if (this.lastNestedScrollDy != 0) break block6;
                                            n3 = v.getTop();
                                            if (!this.fitToContents) break block7;
                                            if (Math.abs(n3 - this.fitToContentsOffset) >= Math.abs(n3 - this.collapsedOffset)) break block8;
                                            n = this.fitToContentsOffset;
                                            break block4;
                                        }
                                        n = this.collapsedOffset;
                                        break block9;
                                    }
                                    n = this.halfExpandedOffset;
                                    if (n3 >= n) break block10;
                                    if (n3 >= Math.abs(n3 - this.collapsedOffset)) break block11;
                                    n = 0;
                                    break block4;
                                }
                                n = this.halfExpandedOffset;
                                break block12;
                            }
                            if (Math.abs(n3 - n) >= Math.abs(n3 - this.collapsedOffset)) break block13;
                            n = this.halfExpandedOffset;
                        }
                        n2 = 6;
                        break block4;
                    }
                    n = this.collapsedOffset;
                    break block9;
                }
                n = this.collapsedOffset;
            }
            n2 = 4;
        }
        if (this.viewDragHelper.smoothSlideViewTo(v, v.getLeft(), n)) {
            this.setStateInternal(2);
            ViewCompat.postOnAnimation(v, (Runnable)new SettleRunnable(this, v, n2));
        } else {
            this.setStateInternal(n2);
        }
        this.nestedScrolled = false;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int n = motionEvent.getActionMasked();
        if (this.state == 1 && n == 0) {
            return true;
        }
        coordinatorLayout = this.viewDragHelper;
        if (coordinatorLayout != null) {
            coordinatorLayout.processTouchEvent(motionEvent);
        }
        if (n == 0) {
            this.reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (n != 2) return this.ignoreEvents ^ true;
        if (this.ignoreEvents) return this.ignoreEvents ^ true;
        if (!(Math.abs((float)this.initialY - motionEvent.getY()) > (float)this.viewDragHelper.getTouchSlop())) return this.ignoreEvents ^ true;
        this.viewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return this.ignoreEvents ^ true;
    }

    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callback = bottomSheetCallback;
    }

    public void setFitToContents(boolean bl) {
        if (this.fitToContents == bl) {
            return;
        }
        this.fitToContents = bl;
        if (this.viewRef != null) {
            this.calculateCollapsedOffset();
        }
        int n = this.fitToContents && this.state == 6 ? 3 : this.state;
        this.setStateInternal(n);
    }

    public void setHideable(boolean bl) {
        this.hideable = bl;
    }

    /*
     * Unable to fully structure code
     */
    public final void setPeekHeight(int var1_1) {
        block3: {
            block2: {
                var2_2 = 1;
                if (var1_1 != -1) break block2;
                if (this.peekHeightAuto) ** GOTO lbl-1000
                this.peekHeightAuto = true;
                var1_1 = var2_2;
                break block3;
            }
            if (!this.peekHeightAuto && this.peekHeight == var1_1) lbl-1000:
            // 2 sources

            {
                var1_1 = 0;
            } else {
                this.peekHeightAuto = false;
                this.peekHeight = Math.max(0, var1_1);
                this.collapsedOffset = this.parentHeight - var1_1;
                var1_1 = var2_2;
            }
        }
        if (var1_1 == 0) return;
        if (this.state != 4) return;
        var3_3 = this.viewRef;
        if (var3_3 == null) return;
        if ((var3_3 = (View)var3_3.get()) == null) return;
        var3_3.requestLayout();
    }

    public void setSkipCollapsed(boolean bl) {
        this.skipCollapsed = bl;
    }

    public final void setState(int n) {
        if (n == this.state) {
            return;
        }
        ViewParent viewParent = this.viewRef;
        if (viewParent == null) {
            if (n != 4 && n != 3 && n != 6) {
                if (!this.hideable) return;
                if (n != 5) return;
            }
            this.state = n;
            return;
        }
        View view = (View)viewParent.get();
        if (view == null) {
            return;
        }
        viewParent = view.getParent();
        if (viewParent != null && viewParent.isLayoutRequested() && ViewCompat.isAttachedToWindow((View)view)) {
            view.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            this.startSettlingAnimation(view, n);
        }
    }

    void setStateInternal(int n) {
        View view;
        if (this.state == n) {
            return;
        }
        this.state = n;
        if (n != 6 && n != 3) {
            if (n == 5 || n == 4) {
                this.updateImportantForAccessibility(false);
            }
        } else {
            this.updateImportantForAccessibility(true);
        }
        if ((view = (View)this.viewRef.get()) == null) return;
        BottomSheetCallback bottomSheetCallback = this.callback;
        if (bottomSheetCallback == null) return;
        bottomSheetCallback.onStateChanged(view, n);
    }

    boolean shouldHide(View view, float f) {
        boolean bl = this.skipCollapsed;
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((float)view.getTop() + f * 0.1f - (float)this.collapsedOffset) / (float)this.peekHeight > 0.5f) return bl2;
        bl2 = false;
        return bl2;
    }

    void startSettlingAnimation(View object, int n) {
        block11: {
            int n2;
            block8: {
                block10: {
                    block9: {
                        int n3;
                        block7: {
                            if (n != 4) break block7;
                            n2 = this.collapsedOffset;
                            break block8;
                        }
                        if (n != 6) break block9;
                        n2 = this.halfExpandedOffset;
                        if (this.fitToContents && n2 <= (n3 = this.fitToContentsOffset)) {
                            n2 = n3;
                            n = 3;
                        }
                        break block8;
                    }
                    if (n != 3) break block10;
                    n2 = this.getExpandedOffset();
                    break block8;
                }
                if (!this.hideable || n != 5) break block11;
                n2 = this.parentHeight;
            }
            if (this.viewDragHelper.smoothSlideViewTo((View)object, object.getLeft(), n2)) {
                this.setStateInternal(2);
                ViewCompat.postOnAnimation((View)object, (Runnable)new SettleRunnable(this, (View)object, n));
            } else {
                this.setStateInternal(n);
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Illegal state argument: ");
        ((StringBuilder)object).append(n);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }
}
