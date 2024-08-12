/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.view.ContextThemeWrapper
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.SpinnerAdapter
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$id
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBar$LayoutParams
 *  androidx.appcompat.app.ActionBar$OnMenuVisibilityListener
 *  androidx.appcompat.app.ActionBar$OnNavigationListener
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.app.NavItemSelectedListener
 *  androidx.appcompat.app.WindowDecorActionBar$ActionModeImpl
 *  androidx.appcompat.app.WindowDecorActionBar$TabImpl
 *  androidx.appcompat.view.ActionBarPolicy
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.view.ViewPropertyAnimatorCompatSet
 *  androidx.appcompat.widget.ActionBarContainer
 *  androidx.appcompat.widget.ActionBarContextView
 *  androidx.appcompat.widget.ActionBarOverlayLayout
 *  androidx.appcompat.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback
 *  androidx.appcompat.widget.DecorToolbar
 *  androidx.appcompat.widget.ScrollingTabContainerView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 *  androidx.core.view.ViewPropertyAnimatorUpdateListener
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentTransaction
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.NavItemSelectedListener;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

public class WindowDecorActionBar
extends ActionBar
implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final long FADE_IN_DURATION_MS = 200L;
    private static final long FADE_OUT_DURATION_MS = 100L;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    private static final Interpolator sShowInterpolator = new DecelerateInterpolator();
    ActionModeImpl mActionMode;
    private Activity mActivity;
    ActionBarContainer mContainerView;
    boolean mContentAnimations = true;
    View mContentView;
    Context mContext;
    ActionBarContextView mContextView;
    private int mCurWindowVisibility = 0;
    ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    boolean mHiddenByApp;
    boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener;
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    private boolean mNowShowing = true;
    ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener;
    private boolean mShowingForMode;
    ScrollingTabContainerView mTabScrollView;
    private ArrayList<TabImpl> mTabs = new ArrayList();
    private Context mThemedContext;
    final ViewPropertyAnimatorUpdateListener mUpdateListener;

    public WindowDecorActionBar(Activity activity, boolean bl) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mHideListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mShowListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mUpdateListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mActivity = activity;
        activity = activity.getWindow().getDecorView();
        this.init((View)activity);
        if (bl) return;
        this.mContentView = activity.findViewById(0x1020002);
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mHideListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mShowListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mUpdateListener = new /* Unavailable Anonymous Inner Class!! */;
        this.init(dialog.getWindow().getDecorView());
    }

    public WindowDecorActionBar(View view) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mHideListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mShowListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mUpdateListener = new /* Unavailable Anonymous Inner Class!! */;
        this.init(view);
    }

    static boolean checkShowingFlags(boolean bl, boolean bl2, boolean bl3) {
        if (bl3) {
            return true;
        }
        if (bl) return false;
        if (!bl2) return true;
        return false;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            this.selectTab(null);
        }
        this.mTabs.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab object, int n) {
        if ((object = (TabImpl)object).getCallback() == null) {
            object = new IllegalStateException("Action Bar Tab must have a Callback");
            throw object;
        }
        object.setPosition(n);
        this.mTabs.add(n, (TabImpl)object);
        int n2 = this.mTabs.size();
        while (++n < n2) {
            this.mTabs.get(n).setPosition(n);
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView != null) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs) {
            scrollingTabContainerView.setVisibility(0);
            this.mDecorToolbar.setEmbeddedTabView(scrollingTabContainerView);
        } else {
            if (this.getNavigationMode() == 2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            this.mContainerView.setTabContainer(scrollingTabContainerView);
        }
        this.mTabScrollView = scrollingTabContainerView;
    }

    private DecorToolbar getDecorToolbar(View object) {
        if (object instanceof DecorToolbar) {
            return (DecorToolbar)object;
        }
        if (object instanceof Toolbar) {
            return ((Toolbar)object).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        object = object != null ? object.getClass().getSimpleName() : "null";
        stringBuilder.append((String)object);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void hideForActionMode() {
        if (!this.mShowingForMode) return;
        this.mShowingForMode = false;
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(false);
        }
        this.updateVisibility(false);
    }

    private void init(View object) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        this.mOverlayLayout = actionBarOverlayLayout = (ActionBarOverlayLayout)object.findViewById(R.id.decor_content_parent);
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback((ActionBarOverlayLayout.ActionBarVisibilityCallback)this);
        }
        this.mDecorToolbar = this.getDecorToolbar(object.findViewById(R.id.action_bar));
        this.mContextView = (ActionBarContextView)object.findViewById(R.id.action_context_bar);
        actionBarOverlayLayout = (ActionBarContainer)object.findViewById(R.id.action_bar_container);
        this.mContainerView = actionBarOverlayLayout;
        object = this.mDecorToolbar;
        if (object != null && this.mContextView != null && actionBarOverlayLayout != null) {
            this.mContext = object.getContext();
            int n = (this.mDecorToolbar.getDisplayOptions() & 4) != 0 ? 1 : 0;
            if (n != 0) {
                this.mDisplayHomeAsUpSet = true;
            }
            boolean bl = (object = ActionBarPolicy.get((Context)this.mContext)).enableHomeButtonByDefault() || n != 0;
            this.setHomeButtonEnabled(bl);
            this.setHasEmbeddedTabs(object.hasEmbeddedTabs());
            object = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
            if (object.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
                this.setHideOnContentScrollEnabled(true);
            }
            if ((n = object.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0)) != 0) {
                this.setElevation(n);
            }
            object.recycle();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(((Object)((Object)this)).getClass().getSimpleName());
        ((StringBuilder)object).append(" can only be used with a compatible window decor layout");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    private void setHasEmbeddedTabs(boolean bl) {
        this.mHasEmbeddedTabs = bl;
        if (!bl) {
            this.mDecorToolbar.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        } else {
            this.mContainerView.setTabContainer(null);
            this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        }
        int n = this.getNavigationMode();
        boolean bl2 = true;
        n = n == 2 ? 1 : 0;
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            if (n != 0) {
                scrollingTabContainerView.setVisibility(0);
                scrollingTabContainerView = this.mOverlayLayout;
                if (scrollingTabContainerView != null) {
                    ViewCompat.requestApplyInsets((View)scrollingTabContainerView);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        scrollingTabContainerView = this.mDecorToolbar;
        bl = !this.mHasEmbeddedTabs && n != 0;
        scrollingTabContainerView.setCollapsible(bl);
        scrollingTabContainerView = this.mOverlayLayout;
        bl = !this.mHasEmbeddedTabs && n != 0 ? bl2 : false;
        scrollingTabContainerView.setHasNonEmbeddedTabs(bl);
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut((View)this.mContainerView);
    }

    private void showForActionMode() {
        if (this.mShowingForMode) return;
        this.mShowingForMode = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        this.updateVisibility(false);
    }

    private void updateVisibility(boolean bl) {
        if (WindowDecorActionBar.checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (this.mNowShowing) return;
            this.mNowShowing = true;
            this.doShow(bl);
        } else {
            if (!this.mNowShowing) return;
            this.mNowShowing = false;
            this.doHide(bl);
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        this.addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, int n) {
        this.addTab(tab, n, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, int n, boolean bl) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(tab, n, bl);
        this.configureTab(tab, n);
        if (!bl) return;
        this.selectTab(tab);
    }

    public void addTab(ActionBar.Tab tab, boolean bl) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(tab, bl);
        this.configureTab(tab, this.mTabs.size());
        if (!bl) return;
        this.selectTab(tab);
    }

    public void animateToMode(boolean bl) {
        if (bl) {
            this.showForActionMode();
        } else {
            this.hideForActionMode();
        }
        if (this.shouldAnimateContextView()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
            if (bl) {
                viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(4, 100L);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, 200L);
            } else {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(0, 200L);
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
        } else if (bl) {
            this.mDecorToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null) return false;
        if (!decorToolbar.hasExpandedActionView()) return false;
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    void completeDeferredDestroyActionMode() {
        ActionMode.Callback callback = this.mDeferredModeDestroyCallback;
        if (callback == null) return;
        callback.onDestroyActionMode(this.mDeferredDestroyActionMode);
        this.mDeferredDestroyActionMode = null;
        this.mDeferredModeDestroyCallback = null;
    }

    public void dispatchMenuVisibilityChanged(boolean bl) {
        if (bl == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = bl;
        int n = this.mMenuVisibilityListeners.size();
        int n2 = 0;
        while (n2 < n) {
            this.mMenuVisibilityListeners.get(n2).onMenuVisibilityChanged(bl);
            ++n2;
        }
    }

    public void doHide(boolean bl) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.mCurWindowVisibility == 0 && (this.mShowHideAnimationEnabled || bl)) {
            Object object;
            float f;
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTransitioning(true);
            viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            float f2 = f = (float)(-this.mContainerView.getHeight());
            if (bl) {
                object[0] = 0;
                (object = new int[2])[1] = 0;
                this.mContainerView.getLocationInWindow(object);
                f2 = f - (float)object[1];
            }
            object = ViewCompat.animate((View)this.mContainerView).translationY(f2);
            object.setUpdateListener(this.mUpdateListener);
            viewPropertyAnimatorCompatSet.play((ViewPropertyAnimatorCompat)object);
            if (this.mContentAnimations && (object = (Object)this.mContentView) != null) {
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate((View)object).translationY(f2));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(sHideInterpolator);
            viewPropertyAnimatorCompatSet.setDuration(250L);
            viewPropertyAnimatorCompatSet.setListener(this.mHideListener);
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
        } else {
            this.mHideListener.onAnimationEnd(null);
        }
    }

    public void doShow(boolean bl) {
        Object object = this.mCurrentShowAnim;
        if (object != null) {
            object.cancel();
        }
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility == 0 && (this.mShowHideAnimationEnabled || bl)) {
            float f;
            this.mContainerView.setTranslationY(0.0f);
            float f2 = f = (float)(-this.mContainerView.getHeight());
            if (bl) {
                Object object2 = object = (Object)new int[2];
                object2[0] = (ViewPropertyAnimatorCompatSet)false;
                object2[1] = (ViewPropertyAnimatorCompatSet)false;
                this.mContainerView.getLocationInWindow((int[])object);
                f2 = f - (float)object[1];
            }
            this.mContainerView.setTranslationY(f2);
            object = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.mContainerView).translationY(0.0f);
            viewPropertyAnimatorCompat.setUpdateListener(this.mUpdateListener);
            object.play(viewPropertyAnimatorCompat);
            if (this.mContentAnimations && (viewPropertyAnimatorCompat = this.mContentView) != null) {
                viewPropertyAnimatorCompat.setTranslationY(f2);
                object.play(ViewCompat.animate((View)this.mContentView).translationY(0.0f));
            }
            object.setInterpolator(sShowInterpolator);
            object.setDuration(250L);
            object.setListener(this.mShowListener);
            this.mCurrentShowAnim = object;
            object.start();
        } else {
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(0.0f);
            if (this.mContentAnimations && (object = this.mContentView) != null) {
                object.setTranslationY(0.0f);
            }
            this.mShowListener.onAnimationEnd(null);
        }
        object = this.mOverlayLayout;
        if (object == null) return;
        ViewCompat.requestApplyInsets((View)object);
    }

    public void enableContentAnimations(boolean bl) {
        this.mContentAnimations = bl;
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation((View)this.mContainerView);
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        int n = this.mDecorToolbar.getNavigationMode();
        if (n == 1) return this.mDecorToolbar.getDropdownItemCount();
        if (n == 2) return this.mTabs.size();
        return 0;
    }

    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        int n = this.mDecorToolbar.getNavigationMode();
        if (n == 1) return this.mDecorToolbar.getDropdownSelectedPosition();
        int n2 = -1;
        if (n != 2) {
            return -1;
        }
        TabImpl tabImpl = this.mSelectedTab;
        if (tabImpl == null) return n2;
        n2 = tabImpl.getPosition();
        return n2;
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int n) {
        return (ActionBar.Tab)this.mTabs.get(n);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext != null) return this.mThemedContext;
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
        int n = typedValue.resourceId;
        this.mThemedContext = n != 0 ? new ContextThemeWrapper(this.mContext, n) : this.mContext;
        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    public void hide() {
        if (this.mHiddenByApp) return;
        this.mHiddenByApp = true;
        this.updateVisibility(false);
    }

    public void hideForSystem() {
        if (this.mHiddenBySystem) return;
        this.mHiddenBySystem = true;
        this.updateVisibility(true);
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }

    public boolean isShowing() {
        int n = this.getHeight();
        boolean bl = this.mNowShowing && (n == 0 || this.getHideOffset() < n);
        return bl;
    }

    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        boolean bl = decorToolbar != null && decorToolbar.isTitleTruncated();
        return bl;
    }

    public ActionBar.Tab newTab() {
        return new TabImpl(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.setHasEmbeddedTabs(ActionBarPolicy.get((Context)this.mContext).hasEmbeddedTabs());
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet == null) return;
        viewPropertyAnimatorCompatSet.cancel();
        this.mCurrentShowAnim = null;
    }

    public void onContentScrollStopped() {
    }

    public boolean onKeyShortcut(int n, KeyEvent keyEvent) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl == null) {
            return false;
        }
        if ((actionModeImpl = actionModeImpl.getMenu()) == null) return false;
        int n2 = keyEvent != null ? keyEvent.getDeviceId() : -1;
        n2 = KeyCharacterMap.load((int)n2).getKeyboardType();
        boolean bl = true;
        if (n2 == 1) {
            bl = false;
        }
        actionModeImpl.setQwertyMode(bl);
        return actionModeImpl.performShortcut(n, keyEvent, 0);
    }

    public void onWindowVisibilityChanged(int n) {
        this.mCurWindowVisibility = n;
    }

    public void removeAllTabs() {
        this.cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        this.removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int n) {
        if (this.mTabScrollView == null) {
            return;
        }
        Object object = this.mSelectedTab;
        int n2 = object != null ? object.getPosition() : this.mSavedTabPosition;
        this.mTabScrollView.removeTabAt(n);
        object = this.mTabs.remove(n);
        if (object != null) {
            object.setPosition(-1);
        }
        int n3 = this.mTabs.size();
        for (int i = n; i < n3; ++i) {
            this.mTabs.get(i).setPosition(i);
        }
        if (n2 != n) return;
        object = this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, n - 1));
        this.selectTab((ActionBar.Tab)object);
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup == null) return false;
        if (viewGroup.hasFocus()) return false;
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        int n = this.getNavigationMode();
        int n2 = -1;
        if (n != 2) {
            if (tab != null) {
                n2 = tab.getPosition();
            }
            this.mSavedTabPosition = n2;
            return;
        }
        FragmentTransaction fragmentTransaction = this.mActivity instanceof FragmentActivity && !this.mDecorToolbar.getViewGroup().isInEditMode() ? ((FragmentActivity)this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack() : null;
        TabImpl tabImpl = this.mSelectedTab;
        if (tabImpl == tab) {
            if (tabImpl != null) {
                tabImpl.getCallback().onTabReselected((ActionBar.Tab)this.mSelectedTab, fragmentTransaction);
                this.mTabScrollView.animateToTab(tab.getPosition());
            }
        } else {
            tabImpl = this.mTabScrollView;
            if (tab != null) {
                n2 = tab.getPosition();
            }
            tabImpl.setTabSelected(n2);
            tabImpl = this.mSelectedTab;
            if (tabImpl != null) {
                tabImpl.getCallback().onTabUnselected((ActionBar.Tab)this.mSelectedTab, fragmentTransaction);
            }
            tab = (TabImpl)tab;
            this.mSelectedTab = tab;
            if (tab != null) {
                tab.getCallback().onTabSelected((ActionBar.Tab)this.mSelectedTab, fragmentTransaction);
            }
        }
        if (fragmentTransaction == null) return;
        if (fragmentTransaction.isEmpty()) return;
        fragmentTransaction.commit();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setPrimaryBackground(drawable);
    }

    public void setCustomView(int n) {
        this.setCustomView(LayoutInflater.from((Context)this.getThemedContext()).inflate(n, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setCustomView(View view) {
        this.mDecorToolbar.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean bl) {
        if (this.mDisplayHomeAsUpSet) return;
        this.setDisplayHomeAsUpEnabled(bl);
    }

    public void setDisplayHomeAsUpEnabled(boolean bl) {
        int n = bl ? 4 : 0;
        this.setDisplayOptions(n, 4);
    }

    public void setDisplayOptions(int n) {
        if ((n & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions(n);
    }

    public void setDisplayOptions(int n, int n2) {
        int n3 = this.mDecorToolbar.getDisplayOptions();
        if ((n2 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions(n & n2 | ~n2 & n3);
    }

    public void setDisplayShowCustomEnabled(boolean bl) {
        int n = bl ? 16 : 0;
        this.setDisplayOptions(n, 16);
    }

    public void setDisplayShowHomeEnabled(boolean bl) {
        int n = bl ? 2 : 0;
        this.setDisplayOptions(n, 2);
    }

    public void setDisplayShowTitleEnabled(boolean bl) {
        int n = bl ? 8 : 0;
        this.setDisplayOptions(n, 8);
    }

    public void setDisplayUseLogoEnabled(boolean bl) {
        this.setDisplayOptions(bl ? 1 : 0, 1);
    }

    public void setElevation(float f) {
        ViewCompat.setElevation((View)this.mContainerView, (float)f);
    }

    public void setHideOffset(int n) {
        if (n != 0) {
            if (!this.mOverlayLayout.isInOverlayMode()) throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.mOverlayLayout.setActionBarHideOffset(n);
    }

    public void setHideOnContentScrollEnabled(boolean bl) {
        if (bl) {
            if (!this.mOverlayLayout.isInOverlayMode()) throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.mHideOnContentScroll = bl;
        this.mOverlayLayout.setHideOnContentScrollEnabled(bl);
    }

    public void setHomeActionContentDescription(int n) {
        this.mDecorToolbar.setNavigationContentDescription(n);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(int n) {
        this.mDecorToolbar.setNavigationIcon(n);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean bl) {
        this.mDecorToolbar.setHomeButtonEnabled(bl);
    }

    public void setIcon(int n) {
        this.mDecorToolbar.setIcon(n);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, (AdapterView.OnItemSelectedListener)new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int n) {
        this.mDecorToolbar.setLogo(n);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public void setNavigationMode(int n) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int n2 = this.mDecorToolbar.getNavigationMode();
        if (n2 == 2) {
            this.mSavedTabPosition = this.getSelectedNavigationIndex();
            this.selectTab(null);
            this.mTabScrollView.setVisibility(8);
        }
        if (n2 != n && !this.mHasEmbeddedTabs && (actionBarOverlayLayout = this.mOverlayLayout) != null) {
            ViewCompat.requestApplyInsets((View)actionBarOverlayLayout);
        }
        this.mDecorToolbar.setNavigationMode(n);
        boolean bl = false;
        if (n == 2) {
            this.ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            n2 = this.mSavedTabPosition;
            if (n2 != -1) {
                this.setSelectedNavigationItem(n2);
                this.mSavedTabPosition = -1;
            }
        }
        actionBarOverlayLayout = this.mDecorToolbar;
        boolean bl2 = n == 2 && !this.mHasEmbeddedTabs;
        actionBarOverlayLayout.setCollapsible(bl2);
        actionBarOverlayLayout = this.mOverlayLayout;
        bl2 = bl;
        if (n == 2) {
            bl2 = bl;
            if (!this.mHasEmbeddedTabs) {
                bl2 = true;
            }
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(bl2);
    }

    public void setSelectedNavigationItem(int n) {
        int n2 = this.mDecorToolbar.getNavigationMode();
        if (n2 != 1) {
            if (n2 != 2) throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            this.selectTab((ActionBar.Tab)this.mTabs.get(n));
        } else {
            this.mDecorToolbar.setDropdownSelectedPosition(n);
        }
    }

    public void setShowHideAnimationEnabled(boolean bl) {
        this.mShowHideAnimationEnabled = bl;
        if (bl) return;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet == null) return;
        viewPropertyAnimatorCompatSet.cancel();
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setStackedBackground(drawable);
    }

    public void setSubtitle(int n) {
        this.setSubtitle(this.mContext.getString(n));
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(int n) {
        this.setTitle(this.mContext.getString(n));
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        if (!this.mHiddenByApp) return;
        this.mHiddenByApp = false;
        this.updateVisibility(false);
    }

    public void showForSystem() {
        if (!this.mHiddenBySystem) return;
        this.mHiddenBySystem = false;
        this.updateVisibility(true);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        callback = new ActionModeImpl(this, this.mContextView.getContext(), callback);
        if (!callback.dispatchOnCreate()) return null;
        this.mActionMode = callback;
        callback.invalidate();
        this.mContextView.initForMode((ActionMode)callback);
        this.animateToMode(true);
        this.mContextView.sendAccessibilityEvent(32);
        return callback;
    }
}
