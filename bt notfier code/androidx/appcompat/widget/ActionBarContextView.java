/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$id
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.widget.AbsActionBarView
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.AbsActionBarView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.ViewCompat;
import java.io.Serializable;

public class ActionBarContextView
extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        context = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.ActionMode, (int)n, (int)0);
        ViewCompat.setBackground((View)this, (Drawable)context.getDrawable(R.styleable.ActionMode_background));
        this.mTitleStyleRes = context.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = context.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = context.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = context.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        context.recycle();
    }

    private void initTitle() {
        LinearLayout linearLayout;
        if (this.mTitleLayout == null) {
            LayoutInflater.from((Context)this.getContext()).inflate(R.layout.abc_action_bar_title_item, (ViewGroup)this);
            this.mTitleLayout = linearLayout = (LinearLayout)this.getChildAt(this.getChildCount() - 1);
            this.mTitleView = (TextView)linearLayout.findViewById(R.id.action_bar_title);
            this.mSubtitleView = (TextView)this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean bl = TextUtils.isEmpty((CharSequence)this.mTitle);
        boolean bl2 = TextUtils.isEmpty((CharSequence)this.mSubtitle) ^ true;
        linearLayout = this.mSubtitleView;
        int n = 0;
        int n2 = bl2 ? 0 : 8;
        linearLayout.setVisibility(n2);
        linearLayout = this.mTitleLayout;
        n2 = n;
        if (!(bl ^ true)) {
            n2 = bl2 ? n : 8;
        }
        linearLayout.setVisibility(n2);
        if (this.mTitleLayout.getParent() != null) return;
        this.addView((View)this.mTitleLayout);
    }

    public void closeMode() {
        if (this.mClose != null) return;
        this.killMode();
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(this.getContext(), attributeSet);
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter == null) return false;
        return this.mActionMenuPresenter.hideOverflowMenu();
    }

    public void initForMode(ActionMode actionMode) {
        View view = this.mClose;
        if (view == null) {
            this.mClose = view = LayoutInflater.from((Context)this.getContext()).inflate(this.mCloseItemLayout, (ViewGroup)this, false);
            this.addView(view);
        } else if (view.getParent() == null) {
            this.addView(this.mClose);
        }
        this.mCloseButton = view = this.mClose.findViewById(R.id.action_mode_close_button);
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        actionMode = (MenuBuilder)actionMode.getMenu();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
        this.mActionMenuPresenter = new ActionMenuPresenter(this.getContext());
        this.mActionMenuPresenter.setReserveOverflow(true);
        view = new ViewGroup.LayoutParams(-2, -1);
        actionMode.addMenuPresenter((MenuPresenter)this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView((ViewGroup)this);
        ViewCompat.setBackground((View)this.mMenuView, null);
        this.addView((View)this.mMenuView, (ViewGroup.LayoutParams)view);
    }

    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter == null) return false;
        return this.mActionMenuPresenter.isOverflowMenuShowing();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        this.removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View view = this.mCloseButton;
        if (view == null) return;
        view.setOnClickListener(null);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter == null) return;
        this.mActionMenuPresenter.hideOverflowMenu();
        this.mActionMenuPresenter.hideSubMenus();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource((View)this);
            accessibilityEvent.setClassName((CharSequence)((Object)((Object)this)).getClass().getName());
            accessibilityEvent.setPackageName((CharSequence)this.getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.mTitle);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        bl = ViewUtils.isLayoutRtl((View)this);
        int n5 = bl ? n3 - n - this.getPaddingRight() : this.getPaddingLeft();
        int n6 = this.getPaddingTop();
        int n7 = n4 - n2 - this.getPaddingTop() - this.getPaddingBottom();
        View view = this.mClose;
        n2 = n5;
        if (view != null) {
            n2 = n5;
            if (view.getVisibility() != 8) {
                view = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
                n2 = bl ? view.rightMargin : view.leftMargin;
                n4 = bl ? view.leftMargin : view.rightMargin;
                n2 = ActionBarContextView.next((int)n5, (int)n2, (boolean)bl);
                n2 = ActionBarContextView.next((int)(n2 + this.positionChild(this.mClose, n2, n6, n7, bl)), (int)n4, (boolean)bl);
            }
        }
        n4 = n2;
        view = this.mTitleLayout;
        n2 = n4;
        if (view != null) {
            n2 = n4;
            if (this.mCustomView == null) {
                n2 = n4;
                if (view.getVisibility() != 8) {
                    n2 = n4 + this.positionChild((View)this.mTitleLayout, n4, n6, n7, bl);
                }
            }
        }
        if ((view = this.mCustomView) != null) {
            this.positionChild(view, n2, n6, n7, bl);
        }
        n = bl ? this.getPaddingLeft() : n3 - n - this.getPaddingRight();
        if (this.mMenuView == null) return;
        this.positionChild((View)this.mMenuView, n, n6, n7, bl ^ true);
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getMode((int)n);
        int n4 = 0x40000000;
        if (n3 != 0x40000000) {
            Serializable serializable = new StringBuilder();
            serializable.append(((Object)((Object)this)).getClass().getSimpleName());
            serializable.append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
            serializable = new IllegalStateException(serializable.toString());
            throw serializable;
        }
        if (View.MeasureSpec.getMode((int)n2) == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((Object)((Object)this)).getClass().getSimpleName());
            stringBuilder.append(" can only be used with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(stringBuilder.toString());
        }
        int n5 = View.MeasureSpec.getSize((int)n);
        n3 = this.mContentHeight > 0 ? this.mContentHeight : View.MeasureSpec.getSize((int)n2);
        int n6 = this.getPaddingTop() + this.getPaddingBottom();
        n = n5 - this.getPaddingLeft() - this.getPaddingRight();
        int n7 = n3 - n6;
        int n8 = View.MeasureSpec.makeMeasureSpec((int)n7, (int)Integer.MIN_VALUE);
        View view = this.mClose;
        int n9 = 0;
        n2 = n;
        if (view != null) {
            n = this.measureChildView(view, n, n8, 0);
            view = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
            n2 = n - (view.leftMargin + view.rightMargin);
        }
        n = n2;
        if (this.mMenuView != null) {
            n = n2;
            if (this.mMenuView.getParent() == this) {
                n = this.measureChildView((View)this.mMenuView, n2, n8, 0);
            }
        }
        view = this.mTitleLayout;
        n2 = n;
        if (view != null) {
            n2 = n;
            if (this.mCustomView == null) {
                if (this.mTitleOptional) {
                    n2 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                    this.mTitleLayout.measure(n2, n8);
                    int n10 = this.mTitleLayout.getMeasuredWidth();
                    n8 = n10 <= n ? 1 : 0;
                    n2 = n;
                    if (n8 != 0) {
                        n2 = n - n10;
                    }
                    view = this.mTitleLayout;
                    n = n8 != 0 ? 0 : 8;
                    view.setVisibility(n);
                } else {
                    n2 = this.measureChildView(view, n, n8, 0);
                }
            }
        }
        if ((view = this.mCustomView) != null) {
            view = view.getLayoutParams();
            n = view.width != -2 ? 0x40000000 : Integer.MIN_VALUE;
            n8 = n2;
            if (view.width >= 0) {
                n8 = Math.min(view.width, n2);
            }
            n2 = view.height != -2 ? n4 : Integer.MIN_VALUE;
            n4 = n7;
            if (view.height >= 0) {
                n4 = Math.min(view.height, n7);
            }
            this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec((int)n8, (int)n), View.MeasureSpec.makeMeasureSpec((int)n4, (int)n2));
        }
        if (this.mContentHeight <= 0) {
            n4 = this.getChildCount();
            n3 = 0;
            for (n = n9; n < n4; ++n) {
                n8 = this.getChildAt(n).getMeasuredHeight() + n6;
                n2 = n3;
                if (n8 > n3) {
                    n2 = n8;
                }
                n3 = n2;
            }
            this.setMeasuredDimension(n5, n3);
        } else {
            this.setMeasuredDimension(n5, n3);
        }
    }

    public void setContentHeight(int n) {
        this.mContentHeight = n;
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (view2 != null) {
            this.removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (view2 = this.mTitleLayout) != null) {
            this.removeView(view2);
            this.mTitleLayout = null;
        }
        if (view != null) {
            this.addView(view);
        }
        this.requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        this.initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.initTitle();
    }

    public void setTitleOptional(boolean bl) {
        if (bl != this.mTitleOptional) {
            this.requestLayout();
        }
        this.mTitleOptional = bl;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter == null) return false;
        return this.mActionMenuPresenter.showOverflowMenu();
    }
}
