/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityManager
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$layout
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.behavior.SwipeDismissBehavior
 *  com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener
 *  com.google.android.material.internal.ThemeEnforcement
 *  com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback
 *  com.google.android.material.snackbar.BaseTransientBottomBar$Behavior
 *  com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener
 *  com.google.android.material.snackbar.BaseTransientBottomBar$OnLayoutChangeListener
 *  com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout
 *  com.google.android.material.snackbar.ContentViewCallback
 *  com.google.android.material.snackbar.SnackbarManager
 *  com.google.android.material.snackbar.SnackbarManager$Callback
 */
package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.ContentViewCallback;
import com.google.android.material.snackbar.SnackbarManager;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR;
    private static final boolean USE_OFFSET_API;
    static final Handler handler;
    private final AccessibilityManager accessibilityManager;
    private Behavior behavior;
    private List<BaseCallback<B>> callbacks;
    private final ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    final SnackbarManager.Callback managerCallback = new /* Unavailable Anonymous Inner Class!! */;
    private final ViewGroup targetParent;
    protected final SnackbarBaseLayout view;

    static {
        boolean bl = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        USE_OFFSET_API = bl;
        SNACKBAR_STYLE_ATTR = new int[]{R.attr.snackbarStyle};
        handler = new Handler(Looper.getMainLooper(), (Handler.Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        if (viewGroup == null) throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        if (view == null) throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        if (contentViewCallback == null) throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        this.targetParent = viewGroup;
        this.contentViewCallback = contentViewCallback;
        viewGroup = viewGroup.getContext();
        this.context = viewGroup;
        ThemeEnforcement.checkAppCompatTheme((Context)viewGroup);
        viewGroup = (SnackbarBaseLayout)LayoutInflater.from((Context)this.context).inflate(this.getSnackbarBaseLayoutResId(), this.targetParent, false);
        this.view = viewGroup;
        viewGroup.addView(view);
        ViewCompat.setAccessibilityLiveRegion((View)this.view, (int)1);
        ViewCompat.setImportantForAccessibility((View)this.view, (int)1);
        ViewCompat.setFitsSystemWindows((View)this.view, (boolean)true);
        ViewCompat.setOnApplyWindowInsetsListener((View)this.view, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
        ViewCompat.setAccessibilityDelegate((View)this.view, (AccessibilityDelegateCompat)new /* Unavailable Anonymous Inner Class!! */);
        this.accessibilityManager = (AccessibilityManager)this.context.getSystemService("accessibility");
    }

    static /* synthetic */ ContentViewCallback access$100(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.contentViewCallback;
    }

    static /* synthetic */ boolean access$200() {
        return USE_OFFSET_API;
    }

    private void animateViewOut(int n) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, this.getTranslationYBottom()});
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.start();
    }

    private int getTranslationYBottom() {
        int n = this.view.getHeight();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        int n2 = n;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return n2;
        n2 = n + ((ViewGroup.MarginLayoutParams)layoutParams).bottomMargin;
        return n2;
    }

    public B addCallback(BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return (B)this;
        }
        if (this.callbacks == null) {
            this.callbacks = new ArrayList<BaseCallback<B>>();
        }
        this.callbacks.add(baseCallback);
        return (B)this;
    }

    void animateViewIn() {
        int n = this.getTranslationYBottom();
        if (USE_OFFSET_API) {
            ViewCompat.offsetTopAndBottom((View)this.view, (int)n);
        } else {
            this.view.setTranslationY((float)n);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{n, 0});
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.start();
    }

    public void dismiss() {
        this.dispatchDismiss(3);
    }

    protected void dispatchDismiss(int n) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, n);
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    protected SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    protected int getSnackbarBaseLayoutResId() {
        int n = this.hasSnackbarStyleAttr() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
        return n;
    }

    public View getView() {
        return this.view;
    }

    protected boolean hasSnackbarStyleAttr() {
        TypedArray typedArray = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        boolean bl = false;
        int n = typedArray.getResourceId(0, -1);
        typedArray.recycle();
        if (n == -1) return bl;
        bl = true;
        return bl;
    }

    final void hideView(int n) {
        if (this.shouldAnimate() && this.view.getVisibility() == 0) {
            this.animateViewOut(n);
        } else {
            this.onViewHidden(n);
        }
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    void onViewHidden(int n) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        ViewParent viewParent = this.callbacks;
        if (viewParent != null) {
            for (int i = viewParent.size() - 1; i >= 0; --i) {
                this.callbacks.get(i).onDismissed((Object)this, n);
            }
        }
        if (!((viewParent = this.view.getParent()) instanceof ViewGroup)) return;
        ((ViewGroup)viewParent).removeView((View)this.view);
    }

    void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List<BaseCallback<B>> list = this.callbacks;
        if (list == null) return;
        int n = list.size() - 1;
        while (n >= 0) {
            this.callbacks.get(n).onShown((Object)this);
            --n;
        }
    }

    public B removeCallback(BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return (B)this;
        }
        List<BaseCallback<B>> list = this.callbacks;
        if (list == null) {
            return (B)this;
        }
        list.remove(baseCallback);
        return (B)this;
    }

    public B setBehavior(Behavior behavior) {
        this.behavior = behavior;
        return (B)this;
    }

    public B setDuration(int n) {
        this.duration = n;
        return (B)this;
    }

    boolean shouldAnimate() {
        Object object = this.accessibilityManager;
        boolean bl = true;
        if ((object = object.getEnabledAccessibilityServiceList(1)) != null && object.isEmpty()) return bl;
        bl = false;
        return bl;
    }

    public void show() {
        SnackbarManager.getInstance().show(this.getDuration(), this.managerCallback);
    }

    final void showView() {
        if (this.view.getParent() == null) {
            SwipeDismissBehavior<View> swipeDismissBehavior = this.view.getLayoutParams();
            if (swipeDismissBehavior instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)swipeDismissBehavior;
                Behavior behavior = this.behavior;
                swipeDismissBehavior = behavior;
                if (behavior == null) {
                    swipeDismissBehavior = this.getNewBehavior();
                }
                if (swipeDismissBehavior instanceof Behavior) {
                    Behavior.access$000((Behavior)((Behavior)swipeDismissBehavior), (BaseTransientBottomBar)this);
                }
                swipeDismissBehavior.setListener((SwipeDismissBehavior.OnDismissListener)new /* Unavailable Anonymous Inner Class!! */);
                layoutParams.setBehavior(swipeDismissBehavior);
                layoutParams.insetEdge = 80;
            }
            this.targetParent.addView((View)this.view);
        }
        this.view.setOnAttachStateChangeListener((OnAttachStateChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        if (ViewCompat.isLaidOut((View)this.view)) {
            if (this.shouldAnimate()) {
                this.animateViewIn();
            } else {
                this.onViewShown();
            }
        } else {
            this.view.setOnLayoutChangeListener((OnLayoutChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        }
    }
}
