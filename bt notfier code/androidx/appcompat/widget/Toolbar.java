/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.app.ActionBar$LayoutParams
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.appcompat.widget.AppCompatTextView
 *  androidx.appcompat.widget.DecorToolbar
 *  androidx.appcompat.widget.RtlSpacingHelper
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.appcompat.widget.Toolbar$ExpandedActionViewMenuPresenter
 *  androidx.appcompat.widget.Toolbar$LayoutParams
 *  androidx.appcompat.widget.Toolbar$OnMenuItemClickListener
 *  androidx.appcompat.widget.Toolbar$SavedState
 *  androidx.appcompat.widget.ToolbarWidgetWrapper
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.MarginLayoutParamsCompat
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity = 8388627;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews = new ArrayList();
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context object, AttributeSet attributeSet, int n) {
        super(object, attributeSet, n);
        int n2;
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mShowOverflowMenuRunnable = new /* Unavailable Anonymous Inner Class!! */;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.getContext(), (AttributeSet)attributeSet, (int[])R.styleable.Toolbar, (int)n, (int)0);
        ViewCompat.saveAttributeDataForStyleable((View)this, (Context)object, (int[])R.styleable.Toolbar, (AttributeSet)attributeSet, (TypedArray)tintTypedArray.getWrappedTypeArray(), (int)n, (int)0);
        this.mTitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = tintTypedArray.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = tintTypedArray.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        n = n2 = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        if (tintTypedArray.hasValue(R.styleable.Toolbar_titleMargins)) {
            n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, n2);
        }
        this.mTitleMarginBottom = n;
        this.mTitleMarginTop = n;
        this.mTitleMarginEnd = n;
        this.mTitleMarginStart = n;
        n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (n >= 0) {
            this.mTitleMarginStart = n;
        }
        if ((n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1)) >= 0) {
            this.mTitleMarginEnd = n;
        }
        if ((n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1)) >= 0) {
            this.mTitleMarginTop = n;
        }
        if ((n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1)) >= 0) {
            this.mTitleMarginBottom = n;
        }
        this.mMaxButtonHeight = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        n2 = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int n3 = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        n = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int n4 = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(n, n4);
        if (n2 != Integer.MIN_VALUE || n3 != Integer.MIN_VALUE) {
            this.mContentInsets.setRelative(n2, n3);
        }
        this.mContentInsetStartWithNavigation = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = tintTypedArray.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = tintTypedArray.getText(R.styleable.Toolbar_collapseContentDescription);
        object = tintTypedArray.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty((CharSequence)object)) {
            this.setTitle((CharSequence)object);
        }
        if (!TextUtils.isEmpty((CharSequence)(object = tintTypedArray.getText(R.styleable.Toolbar_subtitle)))) {
            this.setSubtitle((CharSequence)object);
        }
        this.mPopupContext = this.getContext();
        this.setPopupTheme(tintTypedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        object = tintTypedArray.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (object != null) {
            this.setNavigationIcon((Drawable)object);
        }
        if (!TextUtils.isEmpty((CharSequence)(object = tintTypedArray.getText(R.styleable.Toolbar_navigationContentDescription)))) {
            this.setNavigationContentDescription((CharSequence)object);
        }
        if ((object = tintTypedArray.getDrawable(R.styleable.Toolbar_logo)) != null) {
            this.setLogo((Drawable)object);
        }
        if (!TextUtils.isEmpty((CharSequence)(object = tintTypedArray.getText(R.styleable.Toolbar_logoDescription)))) {
            this.setLogoDescription((CharSequence)object);
        }
        if (tintTypedArray.hasValue(R.styleable.Toolbar_titleTextColor)) {
            this.setTitleTextColor(tintTypedArray.getColorStateList(R.styleable.Toolbar_titleTextColor));
        }
        if (tintTypedArray.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            this.setSubtitleTextColor(tintTypedArray.getColorStateList(R.styleable.Toolbar_subtitleTextColor));
        }
        if (tintTypedArray.hasValue(R.styleable.Toolbar_menu)) {
            this.inflateMenu(tintTypedArray.getResourceId(R.styleable.Toolbar_menu, 0));
        }
        tintTypedArray.recycle();
    }

    private void addCustomViewsWithGravity(List<View> list, int n) {
        int n2 = ViewCompat.getLayoutDirection((View)this);
        int n3 = 0;
        n2 = n2 == 1 ? 1 : 0;
        int n4 = this.getChildCount();
        int n5 = GravityCompat.getAbsoluteGravity((int)n, (int)ViewCompat.getLayoutDirection((View)this));
        list.clear();
        n = n3;
        if (n2 != 0) {
            n = n4 - 1;
            while (n >= 0) {
                View view = this.getChildAt(n);
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (layoutParams.mViewType == 0 && this.shouldLayout(view) && this.getChildHorizontalGravity(layoutParams.gravity) == n5) {
                    list.add(view);
                }
                --n;
            }
            return;
        }
        while (n < n4) {
            View view = this.getChildAt(n);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (layoutParams.mViewType == 0 && this.shouldLayout(view) && this.getChildHorizontalGravity(layoutParams.gravity) == n5) {
                list.add(view);
            }
            ++n;
        }
    }

    private void addSystemView(View view, boolean bl) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams = layoutParams == null ? this.generateDefaultLayoutParams() : (!this.checkLayoutParams(layoutParams) ? this.generateLayoutParams(layoutParams) : (LayoutParams)layoutParams);
        layoutParams.mViewType = 1;
        if (bl && this.mExpandedActionView != null) {
            view.setLayoutParams(layoutParams);
            this.mHiddenViews.add(view);
        } else {
            this.addView(view, layoutParams);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets != null) return;
        this.mContentInsets = new RtlSpacingHelper();
    }

    private void ensureLogoView() {
        if (this.mLogoView != null) return;
        this.mLogoView = new AppCompatImageView(this.getContext());
    }

    private void ensureMenu() {
        this.ensureMenuView();
        if (this.mMenuView.peekMenu() != null) return;
        MenuBuilder menuBuilder = (MenuBuilder)this.mMenuView.getMenu();
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
        }
        this.mMenuView.setExpandedActionViewsExclusive(true);
        menuBuilder.addMenuPresenter((MenuPresenter)this.mExpandedMenuPresenter, this.mPopupContext);
    }

    private void ensureMenuView() {
        ActionMenuView actionMenuView;
        if (this.mMenuView != null) return;
        this.mMenuView = actionMenuView = new ActionMenuView(this.getContext());
        actionMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
        actionMenuView = this.generateDefaultLayoutParams();
        actionMenuView.gravity = 0x800005 | this.mButtonGravity & 0x70;
        this.mMenuView.setLayoutParams((ViewGroup.LayoutParams)actionMenuView);
        this.addSystemView((View)this.mMenuView, false);
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) return;
        this.mNavButtonView = new AppCompatImageButton(this.getContext(), null, R.attr.toolbarNavigationButtonStyle);
        LayoutParams layoutParams = this.generateDefaultLayoutParams();
        layoutParams.gravity = 0x800003 | this.mButtonGravity & 0x70;
        this.mNavButtonView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private int getChildHorizontalGravity(int n) {
        int n2 = ViewCompat.getLayoutDirection((View)this);
        int n3 = GravityCompat.getAbsoluteGravity((int)n, (int)n2) & 7;
        if (n3 == 1) return n3;
        n = 3;
        if (n3 == 3) return n3;
        if (n3 == 5) return n3;
        if (n2 != 1) return n;
        n = 5;
        return n;
    }

    private int getChildTop(View view, int n) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n2 = view.getMeasuredHeight();
        n = n > 0 ? (n2 - n) / 2 : 0;
        int n3 = this.getChildVerticalGravity(layoutParams.gravity);
        if (n3 == 48) return this.getPaddingTop() - n;
        if (n3 == 80) return this.getHeight() - this.getPaddingBottom() - n2 - layoutParams.bottomMargin - n;
        int n4 = this.getPaddingTop();
        int n5 = this.getPaddingBottom();
        n = this.getHeight();
        n3 = (n - n4 - n5 - n2) / 2;
        if (n3 < layoutParams.topMargin) {
            n = layoutParams.topMargin;
        } else {
            n2 = n - n5 - n2 - n3 - n4;
            n = n3;
            if (n2 >= layoutParams.bottomMargin) return n4 + n;
            n = Math.max(0, n3 - (layoutParams.bottomMargin - n2));
        }
        return n4 + n;
    }

    private int getChildVerticalGravity(int n) {
        int n2;
        n = n2 = n & 0x70;
        if (n2 == 16) return n;
        n = n2;
        if (n2 == 48) return n;
        n = n2;
        if (n2 == 80) return n;
        n = this.mGravity & 0x70;
        return n;
    }

    private int getHorizontalMargins(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)view) + MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)view);
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.getContext());
    }

    private int getVerticalMargins(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return view.topMargin + view.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] object) {
        int n = object[0];
        int n2 = object[1];
        int n3 = list.size();
        int n4 = 0;
        int n5 = 0;
        while (n4 < n3) {
            object = list.get(n4);
            LayoutParams layoutParams = (LayoutParams)object.getLayoutParams();
            n = layoutParams.leftMargin - n;
            n2 = layoutParams.rightMargin - n2;
            int n6 = Math.max(0, n);
            int n7 = Math.max(0, n2);
            n = Math.max(0, -n);
            n2 = Math.max(0, -n2);
            n5 += n6 + object.getMeasuredWidth() + n7;
            ++n4;
        }
        return n5;
    }

    private boolean isChildOrHidden(View view) {
        boolean bl = view.getParent() == this || this.mHiddenViews.contains(view);
        return bl;
    }

    private int layoutChildLeft(View view, int n, int[] nArray, int n2) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n3 = layoutParams.leftMargin - nArray[0];
        n += Math.max(0, n3);
        nArray[0] = Math.max(0, -n3);
        n3 = this.getChildTop(view, n2);
        n2 = view.getMeasuredWidth();
        view.layout(n, n3, n + n2, view.getMeasuredHeight() + n3);
        return n + (n2 + layoutParams.rightMargin);
    }

    private int layoutChildRight(View view, int n, int[] nArray, int n2) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n3 = layoutParams.rightMargin - nArray[1];
        n -= Math.max(0, n3);
        nArray[1] = Math.max(0, -n3);
        n3 = this.getChildTop(view, n2);
        n2 = view.getMeasuredWidth();
        view.layout(n - n2, n3, n, view.getMeasuredHeight() + n3);
        return n - (n2 + layoutParams.leftMargin);
    }

    private int measureChildCollapseMargins(View view, int n, int n2, int n3, int n4, int[] nArray) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n5 = marginLayoutParams.leftMargin - nArray[0];
        int n6 = marginLayoutParams.rightMargin - nArray[1];
        int n7 = Math.max(0, n5) + Math.max(0, n6);
        nArray[0] = Math.max(0, -n5);
        nArray[1] = Math.max(0, -n6);
        view.measure(Toolbar.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + n7 + n2), (int)marginLayoutParams.width), Toolbar.getChildMeasureSpec((int)n3, (int)(this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + n4), (int)marginLayoutParams.height));
        return view.getMeasuredWidth() + n7;
    }

    private void measureChildConstrained(View view, int n, int n2, int n3, int n4, int n5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n6 = Toolbar.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + n2), (int)marginLayoutParams.width);
        n2 = Toolbar.getChildMeasureSpec((int)n3, (int)(this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + n4), (int)marginLayoutParams.height);
        n3 = View.MeasureSpec.getMode((int)n2);
        n = n2;
        if (n3 != 0x40000000) {
            n = n2;
            if (n5 >= 0) {
                n = n5;
                if (n3 != 0) {
                    n = Math.min(View.MeasureSpec.getSize((int)n2), n5);
                }
                n = View.MeasureSpec.makeMeasureSpec((int)n, (int)0x40000000);
            }
        }
        view.measure(n6, n);
    }

    private void postShowOverflowMenu() {
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
        this.post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = this.getChildAt(n2);
            if (this.shouldLayout(view) && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        boolean bl = view != null && view.getParent() == this && view.getVisibility() != 8;
        return bl;
    }

    void addChildrenForExpandedActionView() {
        int n = this.mHiddenViews.size() - 1;
        while (true) {
            if (n < 0) {
                this.mHiddenViews.clear();
                return;
            }
            this.addView(this.mHiddenViews.get(n));
            --n;
        }
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        boolean bl = this.getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.isOverflowReserved();
        return bl;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = super.checkLayoutParams(layoutParams) && layoutParams instanceof LayoutParams;
        return bl;
    }

    public void collapseActionView() {
        Object object = this.mExpandedMenuPresenter;
        object = object == null ? null : object.mCurrentExpandedItem;
        if (object == null) return;
        object.collapseActionView();
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null) return;
        actionMenuView.dismissPopupMenus();
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) return;
        AppCompatImageButton appCompatImageButton = new AppCompatImageButton(this.getContext(), null, R.attr.toolbarNavigationButtonStyle);
        this.mCollapseButtonView = appCompatImageButton;
        appCompatImageButton.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        appCompatImageButton = this.generateDefaultLayoutParams();
        appCompatImageButton.gravity = 0x800003 | this.mButtonGravity & 0x70;
        appCompatImageButton.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams((ViewGroup.LayoutParams)appCompatImageButton);
        this.mCollapseButtonView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
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
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new LayoutParams(layoutParams);
        return new LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        Object object = this.mCollapseButtonView;
        object = object != null ? object.getContentDescription() : null;
        return object;
    }

    public Drawable getCollapseIcon() {
        Object object = this.mCollapseButtonView;
        object = object != null ? object.getDrawable() : null;
        return object;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        int n = rtlSpacingHelper != null ? rtlSpacingHelper.getEnd() : 0;
        return n;
    }

    public int getContentInsetEndWithActions() {
        int n = this.mContentInsetEndWithActions;
        if (n != Integer.MIN_VALUE) return n;
        n = this.getContentInsetEnd();
        return n;
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        int n = rtlSpacingHelper != null ? rtlSpacingHelper.getLeft() : 0;
        return n;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        int n = rtlSpacingHelper != null ? rtlSpacingHelper.getRight() : 0;
        return n;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        int n = rtlSpacingHelper != null ? rtlSpacingHelper.getStart() : 0;
        return n;
    }

    public int getContentInsetStartWithNavigation() {
        int n = this.mContentInsetStartWithNavigation;
        if (n != Integer.MIN_VALUE) return n;
        n = this.getContentInsetStart();
        return n;
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView actionMenuView = this.mMenuView;
        int n = actionMenuView != null && (actionMenuView = actionMenuView.peekMenu()) != null && actionMenuView.hasVisibleItems() ? 1 : 0;
        n = n != 0 ? Math.max(this.getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0)) : this.getContentInsetEnd();
        return n;
    }

    public int getCurrentContentInsetLeft() {
        int n = ViewCompat.getLayoutDirection((View)this) == 1 ? this.getCurrentContentInsetEnd() : this.getCurrentContentInsetStart();
        return n;
    }

    public int getCurrentContentInsetRight() {
        int n = ViewCompat.getLayoutDirection((View)this) == 1 ? this.getCurrentContentInsetStart() : this.getCurrentContentInsetEnd();
        return n;
    }

    public int getCurrentContentInsetStart() {
        int n = this.getNavigationIcon() != null ? Math.max(this.getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0)) : this.getContentInsetStart();
        return n;
    }

    public Drawable getLogo() {
        Object object = this.mLogoView;
        object = object != null ? object.getDrawable() : null;
        return object;
    }

    public CharSequence getLogoDescription() {
        Object object = this.mLogoView;
        object = object != null ? object.getContentDescription() : null;
        return object;
    }

    public Menu getMenu() {
        this.ensureMenu();
        return this.mMenuView.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        Object object = this.mNavButtonView;
        object = object != null ? object.getContentDescription() : null;
        return object;
    }

    public Drawable getNavigationIcon() {
        Object object = this.mNavButtonView;
        object = object != null ? object.getDrawable() : null;
        return object;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        this.ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper != null) return this.mWrapper;
        this.mWrapper = new ToolbarWidgetWrapper(this, true);
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        boolean bl = expandedActionViewMenuPresenter != null && expandedActionViewMenuPresenter.mCurrentExpandedItem != null;
        return bl;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        boolean bl = actionMenuView != null && actionMenuView.hideOverflowMenu();
        return bl;
    }

    public void inflateMenu(int n) {
        this.getMenuInflater().inflate(n, this.getMenu());
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        boolean bl = actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
        return bl;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        boolean bl = actionMenuView != null && actionMenuView.isOverflowMenuShowing();
        return bl;
    }

    public boolean isTitleTruncated() {
        TextView textView = this.mTitleTextView;
        if (textView == null) {
            return false;
        }
        if ((textView = textView.getLayout()) == null) {
            return false;
        }
        int n = textView.getLineCount();
        int n2 = 0;
        while (n2 < n) {
            if (textView.getEllipsisCount(n2) > 0) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
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

    /*
     * Unable to fully structure code
     */
    protected void onLayout(boolean var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block41: {
            block42: {
                block39: {
                    block40: {
                        var8_6 = ViewCompat.getLayoutDirection((View)this) == 1 ? 1 : 0;
                        var10_7 = this.getWidth();
                        var13_8 = this.getHeight();
                        var7_9 = this.getPaddingLeft();
                        var11_10 = this.getPaddingRight();
                        var12_11 = this.getPaddingTop();
                        var14_12 = this.getPaddingBottom();
                        var9_13 = var10_7 - var11_10;
                        var18_14 = this.mTempMargins;
                        var18_14[1] = 0;
                        var18_14[0] = 0;
                        var2_2 = ViewCompat.getMinimumHeight((View)this);
                        var6_15 = var2_2 >= 0 ? Math.min(var2_2, var5_5 - var3_3) : 0;
                        if (!this.shouldLayout((View)this.mNavButtonView)) break block39;
                        if (var8_6 == 0) break block40;
                        var5_5 = this.layoutChildRight((View)this.mNavButtonView, var9_13, var18_14, var6_15);
                        var4_4 = var7_9;
                        break block41;
                    }
                    var4_4 = this.layoutChildLeft((View)this.mNavButtonView, var7_9, var18_14, var6_15);
                    break block42;
                }
                var4_4 = var7_9;
            }
            var5_5 = var9_13;
        }
        var3_3 = var4_4;
        var2_2 = var5_5;
        if (this.shouldLayout((View)this.mCollapseButtonView)) {
            if (var8_6 != 0) {
                var2_2 = this.layoutChildRight((View)this.mCollapseButtonView, var5_5, var18_14, var6_15);
                var3_3 = var4_4;
            } else {
                var3_3 = this.layoutChildLeft((View)this.mCollapseButtonView, var4_4, var18_14, var6_15);
                var2_2 = var5_5;
            }
        }
        var5_5 = var3_3;
        var4_4 = var2_2;
        if (this.shouldLayout((View)this.mMenuView)) {
            if (var8_6 != 0) {
                var5_5 = this.layoutChildLeft((View)this.mMenuView, var3_3, var18_14, var6_15);
                var4_4 = var2_2;
            } else {
                var4_4 = this.layoutChildRight((View)this.mMenuView, var2_2, var18_14, var6_15);
                var5_5 = var3_3;
            }
        }
        var3_3 = this.getCurrentContentInsetLeft();
        var2_2 = this.getCurrentContentInsetRight();
        var18_14[0] = Math.max(0, var3_3 - var5_5);
        var18_14[1] = Math.max(0, var2_2 - (var9_13 - var4_4));
        var3_3 = Math.max(var5_5, var3_3);
        var4_4 = Math.min(var4_4, var9_13 - var2_2);
        var5_5 = var3_3;
        var2_2 = var4_4;
        if (this.shouldLayout(this.mExpandedActionView)) {
            if (var8_6 != 0) {
                var2_2 = this.layoutChildRight(this.mExpandedActionView, var4_4, var18_14, var6_15);
                var5_5 = var3_3;
            } else {
                var5_5 = this.layoutChildLeft(this.mExpandedActionView, var3_3, var18_14, var6_15);
                var2_2 = var4_4;
            }
        }
        var4_4 = var5_5;
        var3_3 = var2_2;
        if (this.shouldLayout((View)this.mLogoView)) {
            if (var8_6 != 0) {
                var3_3 = this.layoutChildRight((View)this.mLogoView, var2_2, var18_14, var6_15);
                var4_4 = var5_5;
            } else {
                var4_4 = this.layoutChildLeft((View)this.mLogoView, var5_5, var18_14, var6_15);
                var3_3 = var2_2;
            }
        }
        var1_1 = this.shouldLayout((View)this.mTitleTextView);
        var15_16 = this.shouldLayout((View)this.mSubtitleTextView);
        if (var1_1) {
            var16_17 = (LayoutParams)this.mTitleTextView.getLayoutParams();
            var2_2 = var16_17.topMargin + this.mTitleTextView.getMeasuredHeight() + var16_17.bottomMargin + 0;
        } else {
            var2_2 = 0;
        }
        if (var15_16) {
            var16_17 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
            var2_2 += var16_17.topMargin + this.mSubtitleTextView.getMeasuredHeight() + var16_17.bottomMargin;
        }
        if (!var1_1 && !var15_16) ** GOTO lbl128
        var16_17 = var1_1 != false ? this.mTitleTextView : this.mSubtitleTextView;
        var17_18 = var15_16 != false ? this.mSubtitleTextView : this.mTitleTextView;
        var16_17 = (LayoutParams)var16_17.getLayoutParams();
        var17_18 = (LayoutParams)var17_18.getLayoutParams();
        var5_5 = var1_1 != false && this.mTitleTextView.getMeasuredWidth() > 0 || var15_16 != false && this.mSubtitleTextView.getMeasuredWidth() > 0 ? 1 : 0;
        var9_13 = this.mGravity & 112;
        if (var9_13 != 48) {
            if (var9_13 != 80) {
                var9_13 = (var13_8 - var12_11 - var14_12 - var2_2) / 2;
                if (var9_13 < var16_17.topMargin + this.mTitleMarginTop) {
                    var2_2 = var16_17.topMargin + this.mTitleMarginTop;
                } else {
                    var13_8 = var13_8 - var14_12 - var2_2 - var9_13 - var12_11;
                    var2_2 = var9_13;
                    if (var13_8 < var16_17.bottomMargin + this.mTitleMarginBottom) {
                        var2_2 = Math.max(0, var9_13 - (var17_18.bottomMargin + this.mTitleMarginBottom - var13_8));
                    }
                }
                var2_2 = var12_11 + var2_2;
            } else {
                var2_2 = var13_8 - var14_12 - var17_18.bottomMargin - this.mTitleMarginBottom - var2_2;
            }
        } else {
            var2_2 = this.getPaddingTop() + var16_17.topMargin + this.mTitleMarginTop;
        }
        if (var8_6 != 0) {
            var8_6 = var5_5 != 0 ? this.mTitleMarginStart : 0;
            var3_3 -= Math.max(0, var8_6 -= var18_14[1]);
            var18_14[1] = Math.max(0, -var8_6);
            if (var1_1) {
                var16_17 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                var9_13 = var3_3 - this.mTitleTextView.getMeasuredWidth();
                var8_6 = this.mTitleTextView.getMeasuredHeight() + var2_2;
                this.mTitleTextView.layout(var9_13, var2_2, var3_3, var8_6);
                var2_2 = var9_13 - this.mTitleMarginEnd;
                var9_13 = var8_6 + var16_17.bottomMargin;
            } else {
                var8_6 = var3_3;
                var9_13 = var2_2;
                var2_2 = var8_6;
            }
            if (var15_16) {
                var16_17 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                var8_6 = var9_13 + var16_17.topMargin;
                var12_11 = this.mSubtitleTextView.getMeasuredWidth();
                var9_13 = this.mSubtitleTextView.getMeasuredHeight();
                this.mSubtitleTextView.layout(var3_3 - var12_11, var8_6, var3_3, var9_13 + var8_6);
                var8_6 = var3_3 - this.mTitleMarginEnd;
                var9_13 = var16_17.bottomMargin;
            } else {
                var8_6 = var3_3;
            }
            if (var5_5 != 0) {
                var3_3 = Math.min(var2_2, var8_6);
            }
lbl128:
            // 4 sources

            var2_2 = var4_4;
            var4_4 = var3_3;
        } else {
            var8_6 = var5_5 != 0 ? this.mTitleMarginStart : 0;
            var4_4 += Math.max(0, var8_6 -= var18_14[0]);
            var18_14[0] = Math.max(0, -var8_6);
            if (var1_1) {
                var16_17 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                var8_6 = this.mTitleTextView.getMeasuredWidth() + var4_4;
                var9_13 = this.mTitleTextView.getMeasuredHeight() + var2_2;
                this.mTitleTextView.layout(var4_4, var2_2, var8_6, var9_13);
                var8_6 += this.mTitleMarginEnd;
                var2_2 = var9_13 + var16_17.bottomMargin;
            } else {
                var8_6 = var4_4;
            }
            if (var15_16) {
                var16_17 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                var9_13 = var2_2 + var16_17.topMargin;
                var12_11 = this.mSubtitleTextView.getMeasuredWidth() + var4_4;
                var2_2 = this.mSubtitleTextView.getMeasuredHeight();
                this.mSubtitleTextView.layout(var4_4, var9_13, var12_11, var2_2 + var9_13);
                var9_13 = var12_11 + this.mTitleMarginEnd;
                var2_2 = var16_17.bottomMargin;
            } else {
                var9_13 = var4_4;
            }
            var2_2 = var4_4;
            var4_4 = var3_3;
            if (var5_5 != 0) {
                var2_2 = Math.max(var8_6, var9_13);
                var4_4 = var3_3;
            }
        }
        var5_5 = 0;
        this.addCustomViewsWithGravity(this.mTempViews, 3);
        var8_6 = this.mTempViews.size();
        for (var3_3 = 0; var3_3 < var8_6; ++var3_3) {
            var2_2 = this.layoutChildLeft(this.mTempViews.get(var3_3), var2_2, var18_14, var6_15);
        }
        this.addCustomViewsWithGravity(this.mTempViews, 5);
        var8_6 = this.mTempViews.size();
        for (var3_3 = 0; var3_3 < var8_6; ++var3_3) {
            var4_4 = this.layoutChildRight(this.mTempViews.get(var3_3), var4_4, var18_14, var6_15);
        }
        this.addCustomViewsWithGravity(this.mTempViews, 1);
        var8_6 = this.getViewListMeasuredWidth(this.mTempViews, var18_14);
        var3_3 = var7_9 + (var10_7 - var7_9 - var11_10) / 2 - var8_6 / 2;
        var7_9 = var8_6 + var3_3;
        if (var3_3 >= var2_2) {
            var2_2 = var7_9 > var4_4 ? var3_3 - (var7_9 - var4_4) : var3_3;
        }
        var4_4 = this.mTempViews.size();
        var3_3 = var2_2;
        var2_2 = var5_5;
        while (true) {
            if (var2_2 >= var4_4) {
                this.mTempViews.clear();
                return;
            }
            var3_3 = this.layoutChildLeft(this.mTempViews.get(var2_2), var3_3, var18_14, var6_15);
            ++var2_2;
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int[] nArray = this.mTempMargins;
        boolean bl = ViewUtils.isLayoutRtl((View)this);
        int n8 = 0;
        if (bl) {
            n7 = 1;
            n6 = 0;
        } else {
            n7 = 0;
            n6 = 1;
        }
        if (this.shouldLayout((View)this.mNavButtonView)) {
            this.measureChildConstrained((View)this.mNavButtonView, n, 0, n2, 0, this.mMaxButtonHeight);
            n5 = this.mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mNavButtonView);
            n4 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + this.getVerticalMargins((View)this.mNavButtonView));
            n3 = View.combineMeasuredStates((int)0, (int)this.mNavButtonView.getMeasuredState());
        } else {
            n5 = 0;
            n4 = 0;
            n3 = 0;
        }
        int n9 = n5;
        int n10 = n4;
        n5 = n3;
        if (this.shouldLayout((View)this.mCollapseButtonView)) {
            this.measureChildConstrained((View)this.mCollapseButtonView, n, 0, n2, 0, this.mMaxButtonHeight);
            n9 = this.mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mCollapseButtonView);
            n10 = Math.max(n4, this.mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins((View)this.mCollapseButtonView));
            n5 = View.combineMeasuredStates((int)n3, (int)this.mCollapseButtonView.getMeasuredState());
        }
        n3 = this.getCurrentContentInsetStart();
        n4 = 0 + Math.max(n3, n9);
        nArray[n7] = Math.max(0, n3 - n9);
        if (this.shouldLayout((View)this.mMenuView)) {
            this.measureChildConstrained((View)this.mMenuView, n, n4, n2, 0, this.mMaxButtonHeight);
            n3 = this.mMenuView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mMenuView);
            n10 = Math.max(n10, this.mMenuView.getMeasuredHeight() + this.getVerticalMargins((View)this.mMenuView));
            n5 = View.combineMeasuredStates((int)n5, (int)this.mMenuView.getMeasuredState());
        } else {
            n3 = 0;
        }
        n9 = this.getCurrentContentInsetEnd();
        n7 = n4 + Math.max(n9, n3);
        nArray[n6] = Math.max(0, n9 - n3);
        n6 = n10;
        n3 = n5;
        n4 = n7;
        if (this.shouldLayout(this.mExpandedActionView)) {
            n4 = n7 + this.measureChildCollapseMargins(this.mExpandedActionView, n, n7, n2, 0, nArray);
            n6 = Math.max(n10, this.mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(this.mExpandedActionView));
            n3 = View.combineMeasuredStates((int)n5, (int)this.mExpandedActionView.getMeasuredState());
        }
        n10 = n6;
        n5 = n3;
        n7 = n4;
        if (this.shouldLayout((View)this.mLogoView)) {
            n7 = n4 + this.measureChildCollapseMargins((View)this.mLogoView, n, n4, n2, 0, nArray);
            n10 = Math.max(n6, this.mLogoView.getMeasuredHeight() + this.getVerticalMargins((View)this.mLogoView));
            n5 = View.combineMeasuredStates((int)n3, (int)this.mLogoView.getMeasuredState());
        }
        int n11 = this.getChildCount();
        n3 = 0;
        n4 = n10;
        for (n10 = n3; n10 < n11; ++n10) {
            View view = this.getChildAt(n10);
            n9 = n4;
            n6 = n5;
            n3 = n7;
            if (((LayoutParams)view.getLayoutParams()).mViewType == 0) {
                if (!this.shouldLayout(view)) {
                    n9 = n4;
                    n6 = n5;
                    n3 = n7;
                } else {
                    n3 = n7 + this.measureChildCollapseMargins(view, n, n7, n2, 0, nArray);
                    n9 = Math.max(n4, view.getMeasuredHeight() + this.getVerticalMargins(view));
                    n6 = View.combineMeasuredStates((int)n5, (int)view.getMeasuredState());
                }
            }
            n4 = n9;
            n5 = n6;
            n7 = n3;
        }
        n9 = this.mTitleMarginTop + this.mTitleMarginBottom;
        n6 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (this.shouldLayout((View)this.mTitleTextView)) {
            this.measureChildCollapseMargins((View)this.mTitleTextView, n, n7 + n6, n2, n9, nArray);
            n10 = this.mTitleTextView.getMeasuredWidth();
            n11 = this.getHorizontalMargins((View)this.mTitleTextView);
            int n12 = this.mTitleTextView.getMeasuredHeight();
            n3 = this.getVerticalMargins((View)this.mTitleTextView);
            n5 = View.combineMeasuredStates((int)n5, (int)this.mTitleTextView.getMeasuredState());
            n3 = n12 + n3;
            n10 += n11;
        } else {
            n10 = 0;
            n3 = 0;
        }
        if (this.shouldLayout((View)this.mSubtitleTextView)) {
            n10 = Math.max(n10, this.measureChildCollapseMargins((View)this.mSubtitleTextView, n, n7 + n6, n2, n3 + n9, nArray));
            n3 += this.mSubtitleTextView.getMeasuredHeight() + this.getVerticalMargins((View)this.mSubtitleTextView);
            n5 = View.combineMeasuredStates((int)n5, (int)this.mSubtitleTextView.getMeasuredState());
        }
        n3 = Math.max(n4, n3);
        n11 = this.getPaddingLeft();
        n9 = this.getPaddingRight();
        n4 = this.getPaddingTop();
        n6 = this.getPaddingBottom();
        n10 = View.resolveSizeAndState((int)Math.max(n7 + n10 + (n11 + n9), this.getSuggestedMinimumWidth()), (int)n, (int)(0xFF000000 & n5));
        n = View.resolveSizeAndState((int)Math.max(n3 + (n4 + n6), this.getSuggestedMinimumHeight()), (int)n2, (int)(n5 << 16));
        if (this.shouldCollapse()) {
            n = n8;
        }
        this.setMeasuredDimension(n10, n);
    }

    protected void onRestoreInstanceState(Parcelable object) {
        if (!(object instanceof SavedState)) {
            super.onRestoreInstanceState(object);
            return;
        }
        SavedState savedState = (SavedState)object;
        super.onRestoreInstanceState(savedState.getSuperState());
        object = this.mMenuView;
        object = object != null ? object.peekMenu() : null;
        if (savedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && object != null && (object = object.findItem(savedState.expandedMenuItemId)) != null) {
            object.expandActionView();
        }
        if (!savedState.isOverflowOpen) return;
        this.postShowOverflowMenu();
    }

    public void onRtlPropertiesChanged(int n) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(n);
        }
        this.ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        rtlSpacingHelper.setDirection(bl);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter != null && expandedActionViewMenuPresenter.mCurrentExpandedItem != null) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = this.isOverflowMenuShowing();
        return savedState;
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

    void removeChildrenForExpandedActionView() {
        int n = this.getChildCount() - 1;
        while (n >= 0) {
            View view = this.getChildAt(n);
            if (((LayoutParams)view.getLayoutParams()).mViewType != 2 && view != this.mMenuView) {
                this.removeViewAt(n);
                this.mHiddenViews.add(view);
            }
            --n;
        }
    }

    public void setCollapseContentDescription(int n) {
        CharSequence charSequence = n != 0 ? this.getContext().getText(n) : null;
        this.setCollapseContentDescription(charSequence);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        ImageButton imageButton;
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.ensureCollapseButtonView();
        }
        if ((imageButton = this.mCollapseButtonView) == null) return;
        imageButton.setContentDescription(charSequence);
    }

    public void setCollapseIcon(int n) {
        this.setCollapseIcon(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            this.ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
        } else {
            drawable = this.mCollapseButtonView;
            if (drawable == null) return;
            drawable.setImageDrawable(this.mCollapseIcon);
        }
    }

    public void setCollapsible(boolean bl) {
        this.mCollapsible = bl;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int n) {
        int n2 = n;
        if (n < 0) {
            n2 = Integer.MIN_VALUE;
        }
        if (n2 == this.mContentInsetEndWithActions) return;
        this.mContentInsetEndWithActions = n2;
        if (this.getNavigationIcon() == null) return;
        this.requestLayout();
    }

    public void setContentInsetStartWithNavigation(int n) {
        int n2 = n;
        if (n < 0) {
            n2 = Integer.MIN_VALUE;
        }
        if (n2 == this.mContentInsetStartWithNavigation) return;
        this.mContentInsetStartWithNavigation = n2;
        if (this.getNavigationIcon() == null) return;
        this.requestLayout();
    }

    public void setContentInsetsAbsolute(int n, int n2) {
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(n, n2);
    }

    public void setContentInsetsRelative(int n, int n2) {
        this.ensureContentInsets();
        this.mContentInsets.setRelative(n, n2);
    }

    public void setLogo(int n) {
        this.setLogo(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setLogo(Drawable drawable) {
        ImageView imageView;
        if (drawable != null) {
            this.ensureLogoView();
            if (!this.isChildOrHidden((View)this.mLogoView)) {
                this.addSystemView((View)this.mLogoView, true);
            }
        } else {
            imageView = this.mLogoView;
            if (imageView != null && this.isChildOrHidden((View)imageView)) {
                this.removeView((View)this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        if ((imageView = this.mLogoView) == null) return;
        imageView.setImageDrawable(drawable);
    }

    public void setLogoDescription(int n) {
        this.setLogoDescription(this.getContext().getText(n));
    }

    public void setLogoDescription(CharSequence charSequence) {
        ImageView imageView;
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.ensureLogoView();
        }
        if ((imageView = this.mLogoView) == null) return;
        imageView.setContentDescription(charSequence);
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.mMenuView == null) {
            return;
        }
        this.ensureMenuView();
        MenuBuilder menuBuilder2 = this.mMenuView.peekMenu();
        if (menuBuilder2 == menuBuilder) {
            return;
        }
        if (menuBuilder2 != null) {
            menuBuilder2.removeMenuPresenter((MenuPresenter)this.mOuterActionMenuPresenter);
            menuBuilder2.removeMenuPresenter((MenuPresenter)this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
        }
        actionMenuPresenter.setExpandedActionViewsExclusive(true);
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter((MenuPresenter)actionMenuPresenter, this.mPopupContext);
            menuBuilder.addMenuPresenter((MenuPresenter)this.mExpandedMenuPresenter, this.mPopupContext);
        } else {
            actionMenuPresenter.initForMenu(this.mPopupContext, null);
            this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
            actionMenuPresenter.updateMenuView(true);
            this.mExpandedMenuPresenter.updateMenuView(true);
        }
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(actionMenuPresenter);
        this.mOuterActionMenuPresenter = actionMenuPresenter;
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null) return;
        actionMenuView.setMenuCallbacks(callback, callback2);
    }

    public void setNavigationContentDescription(int n) {
        CharSequence charSequence = n != 0 ? this.getContext().getText(n) : null;
        this.setNavigationContentDescription(charSequence);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        ImageButton imageButton;
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.ensureNavButtonView();
        }
        if ((imageButton = this.mNavButtonView) == null) return;
        imageButton.setContentDescription(charSequence);
    }

    public void setNavigationIcon(int n) {
        this.setNavigationIcon(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setNavigationIcon(Drawable drawable) {
        ImageButton imageButton;
        if (drawable != null) {
            this.ensureNavButtonView();
            if (!this.isChildOrHidden((View)this.mNavButtonView)) {
                this.addSystemView((View)this.mNavButtonView, true);
            }
        } else {
            imageButton = this.mNavButtonView;
            if (imageButton != null && this.isChildOrHidden((View)imageButton)) {
                this.removeView((View)this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        if ((imageButton = this.mNavButtonView) == null) return;
        imageButton.setImageDrawable(drawable);
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        this.ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        this.ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int n) {
        if (this.mPopupTheme == n) return;
        this.mPopupTheme = n;
        this.mPopupContext = n == 0 ? this.getContext() : new ContextThemeWrapper(this.getContext(), n);
    }

    public void setSubtitle(int n) {
        this.setSubtitle(this.getContext().getText(n));
    }

    public void setSubtitle(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.mSubtitleTextView == null) {
                textView = this.getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView((Context)textView);
                this.mSubtitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int n = this.mSubtitleTextAppearance;
                if (n != 0) {
                    this.mSubtitleTextView.setTextAppearance((Context)textView, n);
                }
                if ((textView = this.mSubtitleTextColor) != null) {
                    this.mSubtitleTextView.setTextColor((ColorStateList)textView);
                }
            }
            if (!this.isChildOrHidden((View)this.mSubtitleTextView)) {
                this.addSystemView((View)this.mSubtitleTextView, true);
            }
        } else {
            textView = this.mSubtitleTextView;
            if (textView != null && this.isChildOrHidden((View)textView)) {
                this.removeView((View)this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        if ((textView = this.mSubtitleTextView) != null) {
            textView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int n) {
        this.mSubtitleTextAppearance = n;
        TextView textView = this.mSubtitleTextView;
        if (textView == null) return;
        textView.setTextAppearance(context, n);
    }

    public void setSubtitleTextColor(int n) {
        this.setSubtitleTextColor(ColorStateList.valueOf((int)n));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView == null) return;
        textView.setTextColor(colorStateList);
    }

    public void setTitle(int n) {
        this.setTitle(this.getContext().getText(n));
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = this.getContext();
                this.mTitleTextView = textView = new AppCompatTextView(context);
                textView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int n = this.mTitleTextAppearance;
                if (n != 0) {
                    this.mTitleTextView.setTextAppearance(context, n);
                }
                if ((textView = this.mTitleTextColor) != null) {
                    this.mTitleTextView.setTextColor((ColorStateList)textView);
                }
            }
            if (!this.isChildOrHidden((View)this.mTitleTextView)) {
                this.addSystemView((View)this.mTitleTextView, true);
            }
        } else {
            textView = this.mTitleTextView;
            if (textView != null && this.isChildOrHidden((View)textView)) {
                this.removeView((View)this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        if ((textView = this.mTitleTextView) != null) {
            textView.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleMargin(int n, int n2, int n3, int n4) {
        this.mTitleMarginStart = n;
        this.mTitleMarginTop = n2;
        this.mTitleMarginEnd = n3;
        this.mTitleMarginBottom = n4;
        this.requestLayout();
    }

    public void setTitleMarginBottom(int n) {
        this.mTitleMarginBottom = n;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int n) {
        this.mTitleMarginEnd = n;
        this.requestLayout();
    }

    public void setTitleMarginStart(int n) {
        this.mTitleMarginStart = n;
        this.requestLayout();
    }

    public void setTitleMarginTop(int n) {
        this.mTitleMarginTop = n;
        this.requestLayout();
    }

    public void setTitleTextAppearance(Context context, int n) {
        this.mTitleTextAppearance = n;
        TextView textView = this.mTitleTextView;
        if (textView == null) return;
        textView.setTextAppearance(context, n);
    }

    public void setTitleTextColor(int n) {
        this.setTitleTextColor(ColorStateList.valueOf((int)n));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView == null) return;
        textView.setTextColor(colorStateList);
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        boolean bl = actionMenuView != null && actionMenuView.showOverflowMenu();
        return bl;
    }
}
