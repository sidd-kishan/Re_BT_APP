/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout$LayoutParams
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.core.util.Pools$Pool
 *  androidx.core.util.Pools$SimplePool
 *  androidx.core.util.Pools$SynchronizedPool
 *  androidx.core.view.ViewCompat
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$DecorView
 *  androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.internal.ThemeEnforcement
 *  com.google.android.material.internal.ViewUtils
 *  com.google.android.material.resources.MaterialResources
 *  com.google.android.material.tabs.TabItem
 *  com.google.android.material.tabs.TabLayout$AdapterChangeListener
 *  com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
 *  com.google.android.material.tabs.TabLayout$PagerAdapterObserver
 *  com.google.android.material.tabs.TabLayout$SlidingTabIndicator
 *  com.google.android.material.tabs.TabLayout$Tab
 *  com.google.android.material.tabs.TabLayout$TabLayoutOnPageChangeListener
 *  com.google.android.material.tabs.TabLayout$TabView
 *  com.google.android.material.tabs.TabLayout$ViewPagerOnTabSelectedListener
 */
package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
@ViewPager.DecorView
public class TabLayout
extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    private BaseOnTabSelectedListener currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    private Tab selectedTab;
    private boolean setupViewPagerImplicitly;
    private final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final RectF tabViewContentBounds;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int n) {
        SlidingTabIndicator slidingTabIndicator;
        block4: {
            super(context, attributeSet, n);
            this.tabs = new ArrayList();
            this.tabViewContentBounds = new RectF();
            this.tabMaxWidth = Integer.MAX_VALUE;
            this.selectedListeners = new ArrayList();
            this.tabViewPool = new Pools.SimplePool(12);
            this.setHorizontalScrollBarEnabled(false);
            this.slidingTabIndicator = slidingTabIndicator = new SlidingTabIndicator(this, context);
            super.addView((View)slidingTabIndicator, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
            slidingTabIndicator = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.TabLayout, (int)n, (int)R.style.Widget_Design_TabLayout, (int[])new int[]{R.styleable.TabLayout_tabTextAppearance});
            this.slidingTabIndicator.setSelectedIndicatorHeight(slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
            this.slidingTabIndicator.setSelectedIndicatorColor(slidingTabIndicator.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
            this.setSelectedTabIndicator(MaterialResources.getDrawable((Context)context, (TypedArray)slidingTabIndicator, (int)R.styleable.TabLayout_tabIndicator));
            this.setSelectedTabIndicatorGravity(slidingTabIndicator.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
            this.setTabIndicatorFullWidth(slidingTabIndicator.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
            this.tabPaddingBottom = n = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
            this.tabPaddingEnd = n;
            this.tabPaddingTop = n;
            this.tabPaddingStart = n;
            this.tabPaddingStart = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.tabPaddingStart);
            this.tabPaddingTop = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
            this.tabPaddingEnd = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
            this.tabPaddingBottom = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
            this.tabTextAppearance = n = slidingTabIndicator.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
            attributeSet = context.obtainStyledAttributes(n, R.styleable.TextAppearance);
            this.tabTextSize = attributeSet.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            this.tabTextColors = MaterialResources.getColorStateList((Context)context, (TypedArray)attributeSet, (int)R.styleable.TextAppearance_android_textColor);
            if (!slidingTabIndicator.hasValue(R.styleable.TabLayout_tabTextColor)) break block4;
            this.tabTextColors = MaterialResources.getColorStateList((Context)context, (TypedArray)slidingTabIndicator, (int)R.styleable.TabLayout_tabTextColor);
        }
        if (slidingTabIndicator.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
            n = slidingTabIndicator.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0);
            this.tabTextColors = TabLayout.createColorStateList(this.tabTextColors.getDefaultColor(), n);
        }
        this.tabIconTint = MaterialResources.getColorStateList((Context)context, (TypedArray)slidingTabIndicator, (int)R.styleable.TabLayout_tabIconTint);
        this.tabIconTintMode = ViewUtils.parseTintMode((int)slidingTabIndicator.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList((Context)context, (TypedArray)slidingTabIndicator, (int)R.styleable.TabLayout_tabRippleColor);
        this.tabIndicatorAnimationDuration = slidingTabIndicator.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
        this.requestedTabMinWidth = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
        this.requestedTabMaxWidth = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
        this.tabBackgroundResId = slidingTabIndicator.getResourceId(R.styleable.TabLayout_tabBackground, 0);
        this.contentInsetStart = slidingTabIndicator.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
        this.mode = slidingTabIndicator.getInt(R.styleable.TabLayout_tabMode, 1);
        this.tabGravity = slidingTabIndicator.getInt(R.styleable.TabLayout_tabGravity, 0);
        this.inlineLabel = slidingTabIndicator.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
        this.unboundedRipple = slidingTabIndicator.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
        slidingTabIndicator.recycle();
        context = this.getResources();
        this.tabTextMultiLineSize = context.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.scrollableTabMinWidth = context.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        this.applyModeAndGravity();
        return;
        finally {
            attributeSet.recycle();
        }
    }

    static /* synthetic */ RectF access$400(TabLayout tabLayout) {
        return tabLayout.tabViewContentBounds;
    }

    private void addTabFromItemView(TabItem tabItem) {
        Tab tab = this.newTab();
        if (tabItem.text != null) {
            tab.setText(tabItem.text);
        }
        if (tabItem.icon != null) {
            tab.setIcon(tabItem.icon);
        }
        if (tabItem.customLayout != 0) {
            tab.setCustomView(tabItem.customLayout);
        }
        if (!TextUtils.isEmpty((CharSequence)tabItem.getContentDescription())) {
            tab.setContentDescription(tabItem.getContentDescription());
        }
        this.addTab(tab);
    }

    private void addTabView(Tab tab) {
        TabView tabView = tab.view;
        this.slidingTabIndicator.addView((View)tabView, tab.getPosition(), (ViewGroup.LayoutParams)this.createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (!(view instanceof TabItem)) throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        this.addTabFromItemView((TabItem)view);
    }

    private void animateToTab(int n) {
        if (n == -1) {
            return;
        }
        if (this.getWindowToken() != null && ViewCompat.isLaidOut((View)this) && !this.slidingTabIndicator.childrenNeedLayout()) {
            int n2;
            int n3 = this.getScrollX();
            if (n3 != (n2 = this.calculateScrollXForTab(n, 0.0f))) {
                this.ensureScrollAnimator();
                this.scrollAnimator.setIntValues(new int[]{n3, n2});
                this.scrollAnimator.start();
            }
            this.slidingTabIndicator.animateIndicatorToPosition(n, this.tabIndicatorAnimationDuration);
            return;
        }
        this.setScrollPosition(n, 0.0f, true);
    }

    private void applyModeAndGravity() {
        int n = this.mode == 0 ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0;
        ViewCompat.setPaddingRelative((View)this.slidingTabIndicator, (int)n, (int)0, (int)0, (int)0);
        n = this.mode;
        if (n != 0) {
            if (n == 1) {
                this.slidingTabIndicator.setGravity(1);
            }
        } else {
            this.slidingTabIndicator.setGravity(0x800003);
        }
        this.updateTabViews(true);
    }

    private int calculateScrollXForTab(int n, float f) {
        int n2 = this.mode;
        int n3 = 0;
        if (n2 != 0) return 0;
        View view = this.slidingTabIndicator.getChildAt(n);
        View view2 = ++n < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(n) : null;
        n = view != null ? view.getWidth() : 0;
        if (view2 != null) {
            n3 = view2.getWidth();
        }
        n2 = view.getLeft() + n / 2 - this.getWidth() / 2;
        n = (int)((float)(n + n3) * 0.5f * f);
        n = ViewCompat.getLayoutDirection((View)this) == 0 ? n2 + n : n2 - n;
        return n;
    }

    private void configureTab(Tab tab, int n) {
        tab.setPosition(n);
        this.tabs.add(n, tab);
        int n2 = this.tabs.size();
        while (++n < n2) {
            this.tabs.get(n).setPosition(n);
        }
    }

    private static ColorStateList createColorStateList(int n, int n2) {
        return new ColorStateList((int[][])new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{n2, n});
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private TabView createTabView(Tab tab) {
        Object object = this.tabViewPool;
        object = object != null ? (TabView)object.acquire() : null;
        TabView tabView = object;
        if (object == null) {
            tabView = new TabView(this, this.getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(this.getTabMinWidth());
        if (TextUtils.isEmpty((CharSequence)Tab.access$100((Tab)tab))) {
            tabView.setContentDescription(Tab.access$200((Tab)tab));
        } else {
            tabView.setContentDescription(Tab.access$100((Tab)tab));
        }
        return tabView;
    }

    private void dispatchTabReselected(Tab tab) {
        int n = this.selectedListeners.size() - 1;
        while (n >= 0) {
            this.selectedListeners.get(n).onTabReselected(tab);
            --n;
        }
    }

    private void dispatchTabSelected(Tab tab) {
        int n = this.selectedListeners.size() - 1;
        while (n >= 0) {
            this.selectedListeners.get(n).onTabSelected(tab);
            --n;
        }
    }

    private void dispatchTabUnselected(Tab tab) {
        int n = this.selectedListeners.size() - 1;
        while (n >= 0) {
            this.selectedListeners.get(n).onTabUnselected(tab);
            --n;
        }
    }

    private void ensureScrollAnimator() {
        ValueAnimator valueAnimator;
        if (this.scrollAnimator != null) return;
        this.scrollAnimator = valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.scrollAnimator.setDuration((long)this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private int getDefaultHeight() {
        int n;
        int n2 = this.tabs.size();
        int n3 = 0;
        int n4 = 0;
        while (true) {
            n = n3;
            if (n4 >= n2) break;
            Tab tab = this.tabs.get(n4);
            if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty((CharSequence)tab.getText())) {
                n = 1;
                break;
            }
            ++n4;
        }
        n = n != 0 && !this.inlineLabel ? 72 : 48;
        return n;
    }

    private int getTabMinWidth() {
        int n = this.requestedTabMinWidth;
        if (n != -1) {
            return n;
        }
        n = this.mode == 0 ? this.scrollableTabMinWidth : 0;
        return n;
    }

    private int getTabScrollRange() {
        return Math.max(0, this.slidingTabIndicator.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
    }

    private void removeTabViewAt(int n) {
        TabView tabView = (TabView)this.slidingTabIndicator.getChildAt(n);
        this.slidingTabIndicator.removeViewAt(n);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.release((Object)tabView);
        }
        this.requestLayout();
    }

    private void setSelectedTabView(int n) {
        int n2 = this.slidingTabIndicator.getChildCount();
        if (n >= n2) return;
        int n3 = 0;
        while (n3 < n2) {
            View view = this.slidingTabIndicator.getChildAt(n3);
            boolean bl = true;
            boolean bl2 = n3 == n;
            view.setSelected(bl2);
            bl2 = n3 == n ? bl : false;
            view.setActivated(bl2);
            ++n3;
        }
    }

    private void setupWithViewPager(ViewPager viewPager, boolean bl, boolean bl2) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener((ViewPager.OnPageChangeListener)tabLayoutOnPageChangeListener);
            }
            if ((viewPager2 = this.adapterChangeListener) != null) {
                this.viewPager.removeOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)viewPager2);
            }
        }
        if ((viewPager2 = this.currentVpSelectedListener) != null) {
            this.removeOnTabSelectedListener((BaseOnTabSelectedListener)viewPager2);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.pageChangeListener);
            viewPager2 = new ViewPagerOnTabSelectedListener(viewPager);
            this.currentVpSelectedListener = viewPager2;
            this.addOnTabSelectedListener((BaseOnTabSelectedListener)viewPager2);
            viewPager2 = viewPager.getAdapter();
            if (viewPager2 != null) {
                this.setPagerAdapter((PagerAdapter)viewPager2, bl);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener(this);
            }
            this.adapterChangeListener.setAutoRefresh(bl);
            viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)this.adapterChangeListener);
            this.setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            this.setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = bl2;
    }

    private void updateAllTabs() {
        int n = this.tabs.size();
        int n2 = 0;
        while (n2 < n) {
            this.tabs.get(n2).updateView();
            ++n2;
        }
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void addOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (this.selectedListeners.contains(baseOnTabSelectedListener)) return;
        this.selectedListeners.add(baseOnTabSelectedListener);
    }

    public void addTab(Tab tab) {
        this.addTab(tab, this.tabs.isEmpty());
    }

    public void addTab(Tab tab, int n) {
        this.addTab(tab, n, this.tabs.isEmpty());
    }

    public void addTab(Tab tab, int n, boolean bl) {
        if (tab.parent != this) throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        this.configureTab(tab, n);
        this.addTabView(tab);
        if (!bl) return;
        tab.select();
    }

    public void addTab(Tab tab, boolean bl) {
        this.addTab(tab, this.tabs.size(), bl);
    }

    public void addView(View view) {
        this.addViewInternal(view);
    }

    public void addView(View view, int n) {
        this.addViewInternal(view);
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        this.addViewInternal(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        this.addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    protected Tab createTabFromPool() {
        Tab tab;
        Tab tab2 = tab = (Tab)tabPool.acquire();
        if (tab != null) return tab2;
        tab2 = new Tab();
        return tab2;
    }

    int dpToPx(int n) {
        return Math.round(this.getResources().getDisplayMetrics().density * (float)n);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        int n = tab != null ? tab.getPosition() : -1;
        return n;
    }

    public Tab getTabAt(int n) {
        Tab tab = n >= 0 && n < this.getTabCount() ? this.tabs.get(n) : null;
        return tab;
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public Tab newTab() {
        Tab tab = this.createTabFromPool();
        tab.parent = this;
        tab.view = this.createTabView(tab);
        return tab;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.viewPager != null) return;
        ViewParent viewParent = this.getParent();
        if (!(viewParent instanceof ViewPager)) return;
        this.setupWithViewPager((ViewPager)viewParent, true, true);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.setupViewPagerImplicitly) return;
        this.setupWithViewPager(null);
        this.setupViewPagerImplicitly = false;
    }

    protected void onDraw(Canvas canvas) {
        int n = 0;
        while (true) {
            if (n >= this.slidingTabIndicator.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View view = this.slidingTabIndicator.getChildAt(n);
            if (view instanceof TabView) {
                TabView.access$300((TabView)((TabView)view), (Canvas)canvas);
            }
            ++n;
        }
    }

    protected void onMeasure(int n, int n2) {
        View view;
        block11: {
            block12: {
                block9: {
                    block10: {
                        int n3 = this.dpToPx(this.getDefaultHeight()) + this.getPaddingTop() + this.getPaddingBottom();
                        int n4 = View.MeasureSpec.getMode((int)n2);
                        if (n4 != Integer.MIN_VALUE) {
                            if (n4 == 0) {
                                n2 = View.MeasureSpec.makeMeasureSpec((int)n3, (int)0x40000000);
                            }
                        } else {
                            n2 = View.MeasureSpec.makeMeasureSpec((int)Math.min(n3, View.MeasureSpec.getSize((int)n2)), (int)0x40000000);
                        }
                        n3 = View.MeasureSpec.getSize((int)n);
                        if (View.MeasureSpec.getMode((int)n) != 0) {
                            n4 = this.requestedTabMaxWidth;
                            if (n4 <= 0) {
                                n4 = n3 - this.dpToPx(56);
                            }
                            this.tabMaxWidth = n4;
                        }
                        super.onMeasure(n, n2);
                        n4 = this.getChildCount();
                        n = 1;
                        if (n4 != 1) return;
                        n4 = 0;
                        view = this.getChildAt(0);
                        n3 = this.mode;
                        if (n3 == 0) break block9;
                        if (n3 == 1) break block10;
                        n = n4;
                        break block11;
                    }
                    if (view.getMeasuredWidth() == this.getMeasuredWidth()) break block12;
                    break block11;
                }
                if (view.getMeasuredWidth() < this.getMeasuredWidth()) break block11;
            }
            n = 0;
        }
        if (n == 0) return;
        n = TabLayout.getChildMeasureSpec((int)n2, (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)view.getLayoutParams().height);
        view.measure(View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0x40000000), n);
    }

    void populateFromPagerAdapter() {
        this.removeAllTabs();
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) return;
        int n = pagerAdapter.getCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                pagerAdapter = this.viewPager;
                if (pagerAdapter == null) return;
                if (n <= 0) return;
                n2 = pagerAdapter.getCurrentItem();
                if (n2 == this.getSelectedTabPosition()) return;
                if (n2 >= this.getTabCount()) return;
                this.selectTab(this.getTabAt(n2));
                return;
            }
            this.addTab(this.newTab().setText(this.pagerAdapter.getPageTitle(n2)), false);
            ++n2;
        }
    }

    protected boolean releaseFromTabPool(Tab tab) {
        return tabPool.release((Object)tab);
    }

    public void removeAllTabs() {
        for (int i = this.slidingTabIndicator.getChildCount() - 1; i >= 0; --i) {
            this.removeTabViewAt(i);
        }
        Iterator<Tab> iterator = this.tabs.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.selectedTab = null;
                return;
            }
            Tab tab = iterator.next();
            iterator.remove();
            tab.reset();
            this.releaseFromTabPool(tab);
        }
    }

    public void removeOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void removeTab(Tab tab) {
        if (tab.parent != this) throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        this.removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int n) {
        Object object = this.selectedTab;
        int n2 = object != null ? object.getPosition() : 0;
        this.removeTabViewAt(n);
        object = this.tabs.remove(n);
        if (object != null) {
            object.reset();
            this.releaseFromTabPool((Tab)object);
        }
        int n3 = this.tabs.size();
        for (int i = n; i < n3; ++i) {
            this.tabs.get(i).setPosition(i);
        }
        if (n2 != n) return;
        object = this.tabs.isEmpty() ? null : this.tabs.get(Math.max(0, n - 1));
        this.selectTab((Tab)object);
    }

    void selectTab(Tab tab) {
        this.selectTab(tab, true);
    }

    void selectTab(Tab tab, boolean bl) {
        Tab tab2 = this.selectedTab;
        if (tab2 == tab) {
            if (tab2 == null) return;
            this.dispatchTabReselected(tab);
            this.animateToTab(tab.getPosition());
        } else {
            int n = tab != null ? tab.getPosition() : -1;
            if (bl) {
                if ((tab2 == null || tab2.getPosition() == -1) && n != -1) {
                    this.setScrollPosition(n, 0.0f, true);
                } else {
                    this.animateToTab(n);
                }
                if (n != -1) {
                    this.setSelectedTabView(n);
                }
            }
            this.selectedTab = tab;
            if (tab2 != null) {
                this.dispatchTabUnselected(tab2);
            }
            if (tab == null) return;
            this.dispatchTabSelected(tab);
        }
    }

    public void setInlineLabel(boolean bl) {
        if (this.inlineLabel == bl) return;
        this.inlineLabel = bl;
        int n = 0;
        while (true) {
            if (n >= this.slidingTabIndicator.getChildCount()) {
                this.applyModeAndGravity();
                return;
            }
            View view = this.slidingTabIndicator.getChildAt(n);
            if (view instanceof TabView) {
                ((TabView)view).updateOrientation();
            }
            ++n;
        }
    }

    public void setInlineLabelResource(int n) {
        this.setInlineLabel(this.getResources().getBoolean(n));
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            this.removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener == null) return;
        this.addOnTabSelectedListener(baseOnTabSelectedListener);
    }

    void setPagerAdapter(PagerAdapter pagerAdapter, boolean bl) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (bl && pagerAdapter != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver(this);
            }
            pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
        }
        this.populateFromPagerAdapter();
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int n, float f, boolean bl) {
        this.setScrollPosition(n, f, bl, true);
    }

    void setScrollPosition(int n, float f, boolean bl, boolean bl2) {
        ValueAnimator valueAnimator;
        int n2 = Math.round((float)n + f);
        if (n2 < 0) return;
        if (n2 >= this.slidingTabIndicator.getChildCount()) return;
        if (bl2) {
            this.slidingTabIndicator.setIndicatorPositionFromTabPosition(n, f);
        }
        if ((valueAnimator = this.scrollAnimator) != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        this.scrollTo(this.calculateScrollXForTab(n, f), 0);
        if (!bl) return;
        this.setSelectedTabView(n2);
    }

    public void setSelectedTabIndicator(int n) {
        if (n != 0) {
            this.setSelectedTabIndicator(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
        } else {
            this.setSelectedTabIndicator(null);
        }
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.tabSelectedIndicator == drawable) return;
        this.tabSelectedIndicator = drawable;
        ViewCompat.postInvalidateOnAnimation((View)this.slidingTabIndicator);
    }

    public void setSelectedTabIndicatorColor(int n) {
        this.slidingTabIndicator.setSelectedIndicatorColor(n);
    }

    public void setSelectedTabIndicatorGravity(int n) {
        if (this.tabIndicatorGravity == n) return;
        this.tabIndicatorGravity = n;
        ViewCompat.postInvalidateOnAnimation((View)this.slidingTabIndicator);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int n) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(n);
    }

    public void setTabGravity(int n) {
        if (this.tabGravity == n) return;
        this.tabGravity = n;
        this.applyModeAndGravity();
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.tabIconTint == colorStateList) return;
        this.tabIconTint = colorStateList;
        this.updateAllTabs();
    }

    public void setTabIconTintResource(int n) {
        this.setTabIconTint(AppCompatResources.getColorStateList((Context)this.getContext(), (int)n));
    }

    public void setTabIndicatorFullWidth(boolean bl) {
        this.tabIndicatorFullWidth = bl;
        ViewCompat.postInvalidateOnAnimation((View)this.slidingTabIndicator);
    }

    public void setTabMode(int n) {
        if (n == this.mode) return;
        this.mode = n;
        this.applyModeAndGravity();
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.tabRippleColorStateList == colorStateList) return;
        this.tabRippleColorStateList = colorStateList;
        int n = 0;
        while (n < this.slidingTabIndicator.getChildCount()) {
            colorStateList = this.slidingTabIndicator.getChildAt(n);
            if (colorStateList instanceof TabView) {
                TabView.access$000((TabView)((TabView)colorStateList), (Context)this.getContext());
            }
            ++n;
        }
    }

    public void setTabRippleColorResource(int n) {
        this.setTabRippleColor(AppCompatResources.getColorStateList((Context)this.getContext(), (int)n));
    }

    public void setTabTextColors(int n, int n2) {
        this.setTabTextColors(TabLayout.createColorStateList(n, n2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.tabTextColors == colorStateList) return;
        this.tabTextColors = colorStateList;
        this.updateAllTabs();
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        this.setPagerAdapter(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean bl) {
        if (this.unboundedRipple == bl) return;
        this.unboundedRipple = bl;
        int n = 0;
        while (n < this.slidingTabIndicator.getChildCount()) {
            View view = this.slidingTabIndicator.getChildAt(n);
            if (view instanceof TabView) {
                TabView.access$000((TabView)((TabView)view), (Context)this.getContext());
            }
            ++n;
        }
    }

    public void setUnboundedRippleResource(int n) {
        this.setUnboundedRipple(this.getResources().getBoolean(n));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean bl) {
        this.setupWithViewPager(viewPager, bl, false);
    }

    public boolean shouldDelayChildPressedState() {
        boolean bl = this.getTabScrollRange() > 0;
        return bl;
    }

    void updateTabViews(boolean bl) {
        int n = 0;
        while (n < this.slidingTabIndicator.getChildCount()) {
            View view = this.slidingTabIndicator.getChildAt(n);
            view.setMinimumWidth(this.getTabMinWidth());
            this.updateTabViewLayoutParams((LinearLayout.LayoutParams)view.getLayoutParams());
            if (bl) {
                view.requestLayout();
            }
            ++n;
        }
    }
}
