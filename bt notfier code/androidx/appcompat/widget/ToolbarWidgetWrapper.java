/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window$Callback
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$drawable
 *  androidx.appcompat.R$id
 *  androidx.appcompat.R$string
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.AppCompatSpinner
 *  androidx.appcompat.widget.DecorToolbar
 *  androidx.appcompat.widget.ScrollingTabContainerView
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$LayoutParams
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

public class ToolbarWidgetWrapper
implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200L;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription = 0;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode = 0;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Window.Callback mWindowCallback;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean bl) {
        this(toolbar, bl, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean bl, int n, int n2) {
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        boolean bl2 = this.mTitle != null;
        this.mTitleSet = bl2;
        this.mNavIcon = toolbar.getNavigationIcon();
        toolbar = TintTypedArray.obtainStyledAttributes((Context)toolbar.getContext(), null, (int[])R.styleable.ActionBar, (int)R.attr.actionBarStyle, (int)0);
        this.mDefaultNavigationIcon = toolbar.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (bl) {
            CharSequence charSequence = toolbar.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                this.setTitle(charSequence);
            }
            if (!TextUtils.isEmpty((CharSequence)(charSequence = toolbar.getText(R.styleable.ActionBar_subtitle)))) {
                this.setSubtitle(charSequence);
            }
            if ((charSequence = toolbar.getDrawable(R.styleable.ActionBar_logo)) != null) {
                this.setLogo((Drawable)charSequence);
            }
            if ((charSequence = toolbar.getDrawable(R.styleable.ActionBar_icon)) != null) {
                this.setIcon((Drawable)charSequence);
            }
            if (this.mNavIcon == null && (charSequence = this.mDefaultNavigationIcon) != null) {
                this.setNavigationIcon((Drawable)charSequence);
            }
            this.setDisplayOptions(toolbar.getInt(R.styleable.ActionBar_displayOptions, 0));
            n2 = toolbar.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (n2 != 0) {
                this.setCustomView(LayoutInflater.from((Context)this.mToolbar.getContext()).inflate(n2, (ViewGroup)this.mToolbar, false));
                this.setDisplayOptions(this.mDisplayOpts | 0x10);
            }
            if ((n2 = toolbar.getLayoutDimension(R.styleable.ActionBar_height, 0)) > 0) {
                charSequence = this.mToolbar.getLayoutParams();
                ((ViewGroup.LayoutParams)charSequence).height = n2;
                this.mToolbar.setLayoutParams((ViewGroup.LayoutParams)charSequence);
            }
            int n3 = toolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            n2 = toolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (n3 >= 0 || n2 >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(n3, 0), Math.max(n2, 0));
            }
            if ((n2 = toolbar.getResourceId(R.styleable.ActionBar_titleTextStyle, 0)) != 0) {
                charSequence = this.mToolbar;
                charSequence.setTitleTextAppearance(charSequence.getContext(), n2);
            }
            if ((n2 = toolbar.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0)) != 0) {
                charSequence = this.mToolbar;
                charSequence.setSubtitleTextAppearance(charSequence.getContext(), n2);
            }
            if ((n2 = toolbar.getResourceId(R.styleable.ActionBar_popupTheme, 0)) != 0) {
                this.mToolbar.setPopupTheme(n2);
            }
        } else {
            this.mDisplayOpts = this.detectDisplayOptions();
        }
        toolbar.recycle();
        this.setDefaultNavigationContentDescription(n);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private int detectDisplayOptions() {
        int n;
        if (this.mToolbar.getNavigationIcon() != null) {
            n = 15;
            this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        } else {
            n = 11;
        }
        return n;
    }

    private void ensureSpinner() {
        if (this.mSpinner != null) return;
        this.mSpinner = new AppCompatSpinner(this.getContext(), null, R.attr.actionDropDownStyle);
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2, 8388627);
        this.mSpinner.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private void setTitleInt(CharSequence charSequence) {
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 8) == 0) return;
        this.mToolbar.setTitle(charSequence);
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) == 0) return;
        if (TextUtils.isEmpty((CharSequence)this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) != 0) {
            Toolbar toolbar = this.mToolbar;
            Drawable drawable2 = this.mNavIcon;
            if (drawable2 == null) {
                drawable2 = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable2);
        } else {
            this.mToolbar.setNavigationIcon(null);
        }
    }

    private void updateToolbarLogo() {
        Drawable drawable2;
        int n = this.mDisplayOpts;
        if ((n & 2) != 0) {
            if ((n & 1) != 0) {
                drawable2 = this.mLogo;
                if (drawable2 == null) {
                    drawable2 = this.mIcon;
                }
            } else {
                drawable2 = this.mIcon;
            }
        } else {
            drawable2 = null;
        }
        this.mToolbar.setLogo(drawable2);
    }

    public void animateToVisibility(int n) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.setupAnimatorToVisibility(n, 200L);
        if (viewPropertyAnimatorCompat == null) return;
        viewPropertyAnimatorCompat.start();
    }

    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    public Context getContext() {
        return this.mToolbar.getContext();
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public int getDropdownItemCount() {
        Spinner spinner = this.mSpinner;
        int n = spinner != null ? spinner.getCount() : 0;
        return n;
    }

    public int getDropdownSelectedPosition() {
        Spinner spinner = this.mSpinner;
        int n = spinner != null ? spinner.getSelectedItemPosition() : 0;
        return n;
    }

    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        boolean bl = this.mTabView != null;
        return bl;
    }

    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    public boolean hasIcon() {
        boolean bl = this.mIcon != null;
        return bl;
    }

    public boolean hasLogo() {
        boolean bl = this.mLogo != null;
        return bl;
    }

    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        Log.i((String)TAG, (String)"Progress display unsupported");
    }

    public void initProgress() {
        Log.i((String)TAG, (String)"Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        ViewCompat.setBackground((View)this.mToolbar, (Drawable)drawable2);
    }

    public void setCollapsible(boolean bl) {
        this.mToolbar.setCollapsible(bl);
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (view2 != null && (this.mDisplayOpts & 0x10) != 0) {
            this.mToolbar.removeView(view2);
        }
        this.mCustomView = view;
        if (view == null) return;
        if ((this.mDisplayOpts & 0x10) == 0) return;
        this.mToolbar.addView(view);
    }

    public void setDefaultNavigationContentDescription(int n) {
        if (n == this.mDefaultNavigationContentDescription) {
            return;
        }
        this.mDefaultNavigationContentDescription = n;
        if (!TextUtils.isEmpty((CharSequence)this.mToolbar.getNavigationContentDescription())) return;
        this.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
    }

    public void setDefaultNavigationIcon(Drawable drawable2) {
        if (this.mDefaultNavigationIcon == drawable2) return;
        this.mDefaultNavigationIcon = drawable2;
        this.updateNavigationIcon();
    }

    public void setDisplayOptions(int n) {
        int n2 = this.mDisplayOpts ^ n;
        this.mDisplayOpts = n;
        if (n2 == 0) return;
        if ((n2 & 4) != 0) {
            if ((n & 4) != 0) {
                this.updateHomeAccessibility();
            }
            this.updateNavigationIcon();
        }
        if ((n2 & 3) != 0) {
            this.updateToolbarLogo();
        }
        if ((n2 & 8) != 0) {
            if ((n & 8) != 0) {
                this.mToolbar.setTitle(this.mTitle);
                this.mToolbar.setSubtitle(this.mSubtitle);
            } else {
                this.mToolbar.setTitle(null);
                this.mToolbar.setSubtitle(null);
            }
        }
        if ((n2 & 0x10) == 0) return;
        View view = this.mCustomView;
        if (view == null) return;
        if ((n & 0x10) != 0) {
            this.mToolbar.addView(view);
        } else {
            this.mToolbar.removeView(view);
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.ensureSpinner();
        this.mSpinner.setAdapter(spinnerAdapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int n) {
        Spinner spinner = this.mSpinner;
        if (spinner == null) throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        spinner.setSelection(n);
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        ViewParent viewParent;
        View view = this.mTabView;
        if (view != null && (viewParent = view.getParent()) == (view = this.mToolbar)) {
            view.removeView(this.mTabView);
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView == null) return;
        if (this.mNavigationMode != 2) return;
        this.mToolbar.addView((View)scrollingTabContainerView, 0);
        view = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
        view.width = -2;
        view.height = -2;
        view.gravity = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    public void setHomeButtonEnabled(boolean bl) {
    }

    public void setIcon(int n) {
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable((Context)this.getContext(), (int)n) : null;
        this.setIcon(drawable2);
    }

    public void setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        this.updateToolbarLogo();
    }

    public void setLogo(int n) {
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable((Context)this.getContext(), (int)n) : null;
        this.setLogo(drawable2);
    }

    public void setLogo(Drawable drawable2) {
        this.mLogo = drawable2;
        this.updateToolbarLogo();
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mActionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter;
            this.mActionMenuPresenter = actionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            actionMenuPresenter.setId(R.id.action_menu_presenter);
        }
        this.mActionMenuPresenter.setCallback(callback);
        this.mToolbar.setMenu((MenuBuilder)menu, this.mActionMenuPresenter);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mToolbar.setMenuCallbacks(callback, callback2);
    }

    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    public void setNavigationContentDescription(int n) {
        String string2 = n == 0 ? null : this.getContext().getString(n);
        this.setNavigationContentDescription(string2);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mHomeDescription = charSequence;
        this.updateHomeAccessibility();
    }

    public void setNavigationIcon(int n) {
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable((Context)this.getContext(), (int)n) : null;
        this.setNavigationIcon(drawable2);
    }

    public void setNavigationIcon(Drawable drawable2) {
        this.mNavIcon = drawable2;
        this.updateNavigationIcon();
    }

    public void setNavigationMode(int n) {
        Object object;
        int n2 = this.mNavigationMode;
        if (n == n2) return;
        if (n2 != 1) {
            ViewParent viewParent;
            if (n2 == 2 && (object = this.mTabView) != null && (viewParent = object.getParent()) == (object = this.mToolbar)) {
                object.removeView(this.mTabView);
            }
        } else {
            Toolbar toolbar;
            object = this.mSpinner;
            if (object != null && (object = object.getParent()) == (toolbar = this.mToolbar)) {
                toolbar.removeView((View)this.mSpinner);
            }
        }
        this.mNavigationMode = n;
        if (n == 0) return;
        if (n != 1) {
            if (n != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid navigation mode ");
                ((StringBuilder)object).append(n);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            object = this.mTabView;
            if (object == null) return;
            this.mToolbar.addView((View)object, 0);
            object = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
            ((Toolbar.LayoutParams)object).width = -2;
            ((Toolbar.LayoutParams)object).height = -2;
            ((Toolbar.LayoutParams)object).gravity = 8388691;
        } else {
            this.ensureSpinner();
            this.mToolbar.addView((View)this.mSpinner, 0);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 8) == 0) return;
        this.mToolbar.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        this.setTitleInt(charSequence);
    }

    public void setVisibility(int n) {
        this.mToolbar.setVisibility(n);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (this.mTitleSet) return;
        this.setTitleInt(charSequence);
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int n, long l) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.mToolbar);
        float f = n == 0 ? 1.0f : 0.0f;
        return viewPropertyAnimatorCompat.alpha(f).setDuration(l).setListener((ViewPropertyAnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }
}
