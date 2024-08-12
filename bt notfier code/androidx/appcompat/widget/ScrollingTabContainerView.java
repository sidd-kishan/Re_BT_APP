/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.AbsListView$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.HorizontalScrollView
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.view.ActionBarPolicy
 *  androidx.appcompat.widget.AppCompatSpinner
 *  androidx.appcompat.widget.LinearLayoutCompat
 *  androidx.appcompat.widget.LinearLayoutCompat$LayoutParams
 *  androidx.appcompat.widget.ScrollingTabContainerView$TabAdapter
 *  androidx.appcompat.widget.ScrollingTabContainerView$TabClickListener
 *  androidx.appcompat.widget.ScrollingTabContainerView$TabView
 *  androidx.appcompat.widget.ScrollingTabContainerView$VisibilityAnimListener
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.ScrollingTabContainerView;

public class ScrollingTabContainerView
extends HorizontalScrollView
implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener(this);
    protected ViewPropertyAnimator mVisibilityAnim;

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.setHorizontalScrollBarEnabled(false);
        context = ActionBarPolicy.get((Context)context);
        this.setContentHeight(context.getTabContainerHeight());
        this.mStackedTabMaxWidth = context.getStackedTabMaxWidth();
        context = this.createTabLayout();
        this.mTabLayout = context;
        this.addView((View)context, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(this.getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams((ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams((ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean isCollapsed() {
        Spinner spinner = this.mTabSpinner;
        boolean bl = spinner != null && spinner.getParent() == this;
        return bl;
    }

    private void performCollapse() {
        Runnable runnable;
        if (this.isCollapsed()) {
            return;
        }
        if (this.mTabSpinner == null) {
            this.mTabSpinner = this.createSpinner();
        }
        this.removeView((View)this.mTabLayout);
        this.addView((View)this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter((SpinnerAdapter)new TabAdapter(this));
        }
        if ((runnable = this.mTabSelector) != null) {
            this.removeCallbacks(runnable);
            this.mTabSelector = null;
        }
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if (!this.isCollapsed()) {
            return false;
        }
        this.removeView((View)this.mTabSpinner);
        this.addView((View)this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
        this.setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public void addTab(ActionBar.Tab tab, int n, boolean bl) {
        tab = this.createTabView(tab, false);
        this.mTabLayout.addView((View)tab, n, (ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged();
        }
        if (bl) {
            tab.setSelected(true);
        }
        if (!this.mAllowCollapse) return;
        this.requestLayout();
    }

    public void addTab(ActionBar.Tab tab, boolean bl) {
        tab = this.createTabView(tab, false);
        this.mTabLayout.addView((View)tab, (ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged();
        }
        if (bl) {
            tab.setSelected(true);
        }
        if (!this.mAllowCollapse) return;
        this.requestLayout();
    }

    public void animateToTab(int n) {
        View view = this.mTabLayout.getChildAt(n);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            this.removeCallbacks(runnable);
        }
        this.mTabSelector = runnable = new /* Unavailable Anonymous Inner Class!! */;
        this.post(runnable);
    }

    public void animateToVisibility(int n) {
        ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (n == 0) {
            if (this.getVisibility() != 0) {
                this.setAlpha(0.0f);
            }
            viewPropertyAnimator = this.animate().alpha(1.0f);
            viewPropertyAnimator.setDuration(200L);
            viewPropertyAnimator.setInterpolator((TimeInterpolator)sAlphaInterpolator);
            viewPropertyAnimator.setListener((Animator.AnimatorListener)this.mVisAnimListener.withFinalVisibility(viewPropertyAnimator, n));
            viewPropertyAnimator.start();
        } else {
            viewPropertyAnimator = this.animate().alpha(0.0f);
            viewPropertyAnimator.setDuration(200L);
            viewPropertyAnimator.setInterpolator((TimeInterpolator)sAlphaInterpolator);
            viewPropertyAnimator.setListener((Animator.AnimatorListener)this.mVisAnimListener.withFinalVisibility(viewPropertyAnimator, n));
            viewPropertyAnimator.start();
        }
    }

    TabView createTabView(ActionBar.Tab tab, boolean bl) {
        tab = new TabView(this, this.getContext(), tab, bl);
        if (bl) {
            tab.setBackgroundDrawable(null);
            tab.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            tab.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new TabClickListener(this);
            }
            tab.setOnClickListener((View.OnClickListener)this.mTabClickListener);
        }
        return tab;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable == null) return;
        this.post(runnable);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration = ActionBarPolicy.get((Context)this.getContext());
        this.setContentHeight(configuration.getTabContainerHeight());
        this.mStackedTabMaxWidth = configuration.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable == null) return;
        this.removeCallbacks(runnable);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int n, long l) {
        ((TabView)view).getTab().select();
    }

    public void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getMode((int)n);
        n2 = 1;
        boolean bl = n3 == 0x40000000;
        this.setFillViewport(bl);
        int n4 = this.mTabLayout.getChildCount();
        if (n4 > 1 && (n3 == 0x40000000 || n3 == Integer.MIN_VALUE)) {
            this.mMaxTabWidth = n4 > 2 ? (int)((float)View.MeasureSpec.getSize((int)n) * 0.4f) : View.MeasureSpec.getSize((int)n) / 2;
            this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
        } else {
            this.mMaxTabWidth = -1;
        }
        n4 = View.MeasureSpec.makeMeasureSpec((int)this.mContentHeight, (int)0x40000000);
        if (bl || !this.mAllowCollapse) {
            n2 = 0;
        }
        if (n2 != 0) {
            this.mTabLayout.measure(0, n4);
            if (this.mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize((int)n)) {
                this.performCollapse();
            } else {
                this.performExpand();
            }
        } else {
            this.performExpand();
        }
        n2 = this.getMeasuredWidth();
        super.onMeasure(n, n4);
        n = this.getMeasuredWidth();
        if (!bl) return;
        if (n2 == n) return;
        this.setTabSelected(this.mSelectedTabIndex);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged();
        }
        if (!this.mAllowCollapse) return;
        this.requestLayout();
    }

    public void removeTabAt(int n) {
        this.mTabLayout.removeViewAt(n);
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged();
        }
        if (!this.mAllowCollapse) return;
        this.requestLayout();
    }

    public void setAllowCollapse(boolean bl) {
        this.mAllowCollapse = bl;
    }

    public void setContentHeight(int n) {
        this.mContentHeight = n;
        this.requestLayout();
    }

    public void setTabSelected(int n) {
        this.mSelectedTabIndex = n;
        int n2 = this.mTabLayout.getChildCount();
        int n3 = 0;
        while (true) {
            Spinner spinner;
            if (n3 >= n2) {
                spinner = this.mTabSpinner;
                if (spinner == null) return;
                if (n < 0) return;
                spinner.setSelection(n);
                return;
            }
            spinner = this.mTabLayout.getChildAt(n3);
            boolean bl = n3 == n;
            spinner.setSelected(bl);
            if (bl) {
                this.animateToTab(n);
            }
            ++n3;
        }
    }

    public void updateTab(int n) {
        ((TabView)this.mTabLayout.getChildAt(n)).update();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged();
        }
        if (!this.mAllowCollapse) return;
        this.requestLayout();
    }
}
