/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  androidx.coordinatorlayout.R$styleable
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.ViewCompat
 */
package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.R;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static class CoordinatorLayout.LayoutParams
extends ViewGroup.MarginLayoutParams {
    public int anchorGravity = 0;
    public int dodgeInsetEdges = 0;
    public int gravity = 0;
    public int insetEdge = 0;
    public int keyline = -1;
    View mAnchorDirectChild;
    int mAnchorId = -1;
    View mAnchorView;
    CoordinatorLayout.Behavior mBehavior;
    boolean mBehaviorResolved = false;
    Object mBehaviorTag;
    private boolean mDidAcceptNestedScrollNonTouch;
    private boolean mDidAcceptNestedScrollTouch;
    private boolean mDidBlockInteraction;
    private boolean mDidChangeAfterNestedScroll;
    int mInsetOffsetX;
    int mInsetOffsetY;
    final Rect mLastChildRect = new Rect();

    public CoordinatorLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    CoordinatorLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean bl;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
        this.gravity = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.mAnchorId = typedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
        this.anchorGravity = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.keyline = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
        this.insetEdge = typedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.dodgeInsetEdges = typedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        this.mBehaviorResolved = bl = typedArray.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
        if (bl) {
            this.mBehavior = CoordinatorLayout.parseBehavior((Context)context, (AttributeSet)attributeSet, (String)typedArray.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
        }
        typedArray.recycle();
        context = this.mBehavior;
        if (context == null) return;
        context.onAttachedToLayoutParams(this);
    }

    public CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public CoordinatorLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super((ViewGroup.MarginLayoutParams)layoutParams);
    }

    private void resolveAnchorView(View object, CoordinatorLayout coordinatorLayout) {
        View view;
        this.mAnchorView = view = coordinatorLayout.findViewById(this.mAnchorId);
        if (view != null) {
            if (view == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            }
        } else {
            if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
            stringBuilder.append(coordinatorLayout.getResources().getResourceName(this.mAnchorId));
            stringBuilder.append(" to anchor view ");
            stringBuilder.append(object);
            object = new IllegalStateException(stringBuilder.toString());
            throw object;
        }
        for (ViewParent viewParent = view.getParent(); viewParent != coordinatorLayout && viewParent != null; viewParent = viewParent.getParent()) {
            if (viewParent == object) {
                if (!coordinatorLayout.isInEditMode()) throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            }
            if (!(viewParent instanceof View)) continue;
            view = (View)viewParent;
        }
        this.mAnchorDirectChild = view;
    }

    private boolean shouldDodge(View view, int n) {
        int n2 = GravityCompat.getAbsoluteGravity((int)((CoordinatorLayout.LayoutParams)view.getLayoutParams()).insetEdge, (int)n);
        boolean bl = n2 != 0 && (GravityCompat.getAbsoluteGravity((int)this.dodgeInsetEdges, (int)n) & n2) == n2;
        return bl;
    }

    private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
        if (this.mAnchorView.getId() != this.mAnchorId) {
            return false;
        }
        View view2 = this.mAnchorView;
        ViewParent viewParent = view2.getParent();
        while (true) {
            if (viewParent == coordinatorLayout) {
                this.mAnchorDirectChild = view2;
                return true;
            }
            if (viewParent == null || viewParent == view) break;
            if (viewParent instanceof View) {
                view2 = (View)viewParent;
            }
            viewParent = viewParent.getParent();
        }
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
        return false;
    }

    boolean checkAnchorChanged() {
        boolean bl = this.mAnchorView == null && this.mAnchorId != -1;
        return bl;
    }

    boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        CoordinatorLayout.Behavior behavior;
        boolean bl = view2 == this.mAnchorDirectChild || this.shouldDodge(view2, ViewCompat.getLayoutDirection((View)coordinatorLayout)) || (behavior = this.mBehavior) != null && behavior.layoutDependsOn(coordinatorLayout, view, view2);
        return bl;
    }

    boolean didBlockInteraction() {
        if (this.mBehavior != null) return this.mDidBlockInteraction;
        this.mDidBlockInteraction = false;
        return this.mDidBlockInteraction;
    }

    View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
        if (this.mAnchorId == -1) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        }
        if (this.mAnchorView != null) {
            if (this.verifyAnchorView(view, coordinatorLayout)) return this.mAnchorView;
        }
        this.resolveAnchorView(view, coordinatorLayout);
        return this.mAnchorView;
    }

    public int getAnchorId() {
        return this.mAnchorId;
    }

    public CoordinatorLayout.Behavior getBehavior() {
        return this.mBehavior;
    }

    boolean getChangedAfterNestedScroll() {
        return this.mDidChangeAfterNestedScroll;
    }

    Rect getLastChildRect() {
        return this.mLastChildRect;
    }

    void invalidateAnchor() {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
    }

    boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
        boolean bl = this.mDidBlockInteraction;
        if (bl) {
            return true;
        }
        CoordinatorLayout.Behavior behavior = this.mBehavior;
        boolean bl2 = behavior != null ? behavior.blocksInteractionBelow(coordinatorLayout, view) : false;
        this.mDidBlockInteraction = bl2 |= bl;
        return bl2;
    }

    boolean isNestedScrollAccepted(int n) {
        if (n == 0) return this.mDidAcceptNestedScrollTouch;
        if (n == 1) return this.mDidAcceptNestedScrollNonTouch;
        return false;
    }

    void resetChangedAfterNestedScroll() {
        this.mDidChangeAfterNestedScroll = false;
    }

    void resetNestedScroll(int n) {
        this.setNestedScrollAccepted(n, false);
    }

    void resetTouchBehaviorTracking() {
        this.mDidBlockInteraction = false;
    }

    public void setAnchorId(int n) {
        this.invalidateAnchor();
        this.mAnchorId = n;
    }

    public void setBehavior(CoordinatorLayout.Behavior behavior) {
        CoordinatorLayout.Behavior behavior2 = this.mBehavior;
        if (behavior2 == behavior) return;
        if (behavior2 != null) {
            behavior2.onDetachedFromLayoutParams();
        }
        this.mBehavior = behavior;
        this.mBehaviorTag = null;
        this.mBehaviorResolved = true;
        if (behavior == null) return;
        behavior.onAttachedToLayoutParams(this);
    }

    void setChangedAfterNestedScroll(boolean bl) {
        this.mDidChangeAfterNestedScroll = bl;
    }

    void setLastChildRect(Rect rect) {
        this.mLastChildRect.set(rect);
    }

    void setNestedScrollAccepted(int n, boolean bl) {
        if (n != 0) {
            if (n != 1) return;
            this.mDidAcceptNestedScrollNonTouch = bl;
        } else {
            this.mDidAcceptNestedScrollTouch = bl;
        }
    }
}
