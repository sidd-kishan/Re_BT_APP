/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.TypedArray
 *  android.view.ContextThemeWrapper
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.AbsActionBarView$VisibilityAnimListener
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.widget.AbsActionBarView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

abstract class AbsActionBarView
extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener(this);
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet object, int n) {
        super(context, (AttributeSet)object, n);
        object = new TypedValue();
        this.mPopupContext = context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, (TypedValue)object, true) && ((TypedValue)object).resourceId != 0 ? new ContextThemeWrapper(context, ((TypedValue)object).resourceId) : context;
    }

    static /* synthetic */ void access$001(AbsActionBarView absActionBarView, int n) {
        super.setVisibility(n);
    }

    static /* synthetic */ void access$101(AbsActionBarView absActionBarView, int n) {
        super.setVisibility(n);
    }

    protected static int next(int n, int n2, boolean bl) {
        n = bl ? (n -= n2) : (n += n2);
        return n;
    }

    public void animateToVisibility(int n) {
        this.setupAnimatorToVisibility(n, 200L).start();
    }

    public boolean canShowOverflowMenu() {
        boolean bl = this.isOverflowReserved() && this.getVisibility() == 0;
        return bl;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter == null) return;
        actionMenuPresenter.dismissPopupMenus();
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim == null) return this.getVisibility();
        return this.mVisAnimListener.mFinalVisibility;
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter == null) return false;
        return actionMenuPresenter.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter == null) return false;
        return actionMenuPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter == null) return false;
        return actionMenuPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        boolean bl = actionMenuPresenter != null && actionMenuPresenter.isOverflowReserved();
        return bl;
    }

    protected int measureChildView(View view, int n, int n2, int n3) {
        view.measure(View.MeasureSpec.makeMeasureSpec((int)n, (int)Integer.MIN_VALUE), n2);
        return Math.max(0, n - view.getMeasuredWidth() - n3);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArray = this.getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.setContentHeight(typedArray.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArray.recycle();
        typedArray = this.mActionMenuPresenter;
        if (typedArray == null) return;
        typedArray.onConfigurationChanged(configuration);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean bl = super.onHoverEvent(motionEvent);
            if (n == 9 && !bl) {
                this.mEatingHover = true;
            }
        }
        if (n != 10) {
            if (n != 3) return true;
        }
        this.mEatingHover = false;
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean bl = super.onTouchEvent(motionEvent);
            if (n == 0 && !bl) {
                this.mEatingTouch = true;
            }
        }
        if (n != 1) {
            if (n != 3) return true;
        }
        this.mEatingTouch = false;
        return true;
    }

    protected int positionChild(View view, int n, int n2, int n3, boolean bl) {
        int n4 = view.getMeasuredWidth();
        int n5 = view.getMeasuredHeight();
        n2 += (n3 - n5) / 2;
        if (bl) {
            view.layout(n - n4, n2, n, n5 + n2);
        } else {
            view.layout(n, n2, n + n4, n5 + n2);
        }
        n = n4;
        if (!bl) return n;
        n = -n4;
        return n;
    }

    public void postShowOverflowMenu() {
        this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setContentHeight(int n) {
        this.mContentHeight = n;
        this.requestLayout();
    }

    public void setVisibility(int n) {
        if (n == this.getVisibility()) return;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        super.setVisibility(n);
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int n, long l) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        if (n != 0) {
            viewPropertyAnimatorCompat = ViewCompat.animate((View)this).alpha(0.0f);
            viewPropertyAnimatorCompat.setDuration(l);
            viewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)this.mVisAnimListener.withFinalVisibility(viewPropertyAnimatorCompat, n));
            return viewPropertyAnimatorCompat;
        }
        if (this.getVisibility() != 0) {
            this.setAlpha(0.0f);
        }
        viewPropertyAnimatorCompat = ViewCompat.animate((View)this).alpha(1.0f);
        viewPropertyAnimatorCompat.setDuration(l);
        viewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)this.mVisAnimListener.withFinalVisibility(viewPropertyAnimatorCompat, n));
        return viewPropertyAnimatorCompat;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter == null) return false;
        return actionMenuPresenter.showOverflowMenu();
    }
}
