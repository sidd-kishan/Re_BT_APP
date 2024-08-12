/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.alpha.QMUIAlphaImageButton
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIDrawableHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIDrawableHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QMUITopBar
extends RelativeLayout {
    private static final int DEFAULT_VIEW_ID = -1;
    private View mCenterView;
    private int mLeftBackDrawableRes;
    private int mLeftLastViewId;
    private List<View> mLeftViewList;
    private int mRightLastViewId;
    private List<View> mRightViewList;
    private int mSubTitleTextColor;
    private int mSubTitleTextSize;
    private TextView mSubTitleView;
    private int mTitleContainerPaddingHor;
    private Rect mTitleContainerRect;
    private LinearLayout mTitleContainerView;
    private int mTitleGravity;
    private int mTitleMarginHorWhenNoBtnAside;
    private int mTitleTextColor;
    private int mTitleTextSize;
    private int mTitleTextSizeWithSubTitle;
    private TextView mTitleView;
    private int mTopBarBgColor;
    private Drawable mTopBarBgWithSeparatorDrawableCache;
    private int mTopBarImageBtnHeight;
    private int mTopBarImageBtnWidth;
    private int mTopBarSeparatorColor;
    private int mTopBarSeparatorHeight;
    private int mTopBarTextBtnPaddingHor;
    private ColorStateList mTopBarTextBtnTextColor;
    private int mTopBarTextBtnTextSize;
    private int mTopbarHeight = -1;

    public QMUITopBar(Context context) {
        this(context, null);
    }

    public QMUITopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITopBarStyle);
    }

    public QMUITopBar(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.initVar();
        this.init(context, attributeSet, n);
    }

    QMUITopBar(Context context, boolean bl) {
        super(context);
        this.initVar();
        if (bl) {
            int n;
            this.mTopBarSeparatorColor = n = ContextCompat.getColor((Context)context, (int)R.color.qmui_config_color_transparent);
            this.mTopBarSeparatorHeight = 0;
            this.mTopBarBgColor = n;
        } else {
            this.init(context, null, R.attr.QMUITopBarStyle);
        }
    }

    private RelativeLayout.LayoutParams generateTitleContainerViewLp() {
        return new RelativeLayout.LayoutParams(-1, QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_topbar_height));
    }

    private LinearLayout.LayoutParams generateTitleViewAndSubTitleViewLp() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mTitleGravity;
        return layoutParams;
    }

    private QMUIAlphaImageButton generateTopBarImageButton(int n) {
        QMUIAlphaImageButton qMUIAlphaImageButton = new QMUIAlphaImageButton(this.getContext());
        qMUIAlphaImageButton.setBackgroundColor(0);
        qMUIAlphaImageButton.setImageResource(n);
        return qMUIAlphaImageButton;
    }

    private Button generateTopBarTextButton(String string) {
        Button button = new Button(this.getContext());
        button.setBackgroundResource(0);
        button.setMinWidth(0);
        button.setMinHeight(0);
        button.setMinimumWidth(0);
        button.setMinimumHeight(0);
        int n = this.mTopBarTextBtnPaddingHor;
        button.setPadding(n, 0, n, 0);
        button.setTextColor(this.mTopBarTextBtnTextColor);
        button.setTextSize(0, (float)this.mTopBarTextBtnTextSize);
        button.setGravity(17);
        button.setText((CharSequence)string);
        return button;
    }

    private TextView getSubTitleView() {
        TextView textView;
        if (this.mSubTitleView != null) return this.mSubTitleView;
        this.mSubTitleView = textView = new TextView(this.getContext());
        textView.setGravity(17);
        this.mSubTitleView.setSingleLine(true);
        this.mSubTitleView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.mSubTitleView.setTextSize(0, (float)this.mSubTitleTextSize);
        this.mSubTitleView.setTextColor(this.mSubTitleTextColor);
        textView = this.generateTitleViewAndSubTitleViewLp();
        textView.topMargin = QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)1);
        this.makeSureTitleContainerView().addView((View)this.mSubTitleView, (ViewGroup.LayoutParams)textView);
        return this.mSubTitleView;
    }

    private TextView getTitleView(boolean bl) {
        TextView textView;
        if (this.mTitleView != null) return this.mTitleView;
        this.mTitleView = textView = new TextView(this.getContext());
        textView.setGravity(17);
        this.mTitleView.setSingleLine(true);
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.mTitleView.setTextColor(this.mTitleTextColor);
        this.updateTitleViewStyle();
        textView = this.generateTitleViewAndSubTitleViewLp();
        this.makeSureTitleContainerView().addView((View)this.mTitleView, (ViewGroup.LayoutParams)textView);
        return this.mTitleView;
    }

    private int getTopBarHeight() {
        if (this.mTopbarHeight != -1) return this.mTopbarHeight;
        this.mTopbarHeight = QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_topbar_height);
        return this.mTopbarHeight;
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUITopBar, n, 0);
        this.mTopBarSeparatorColor = attributeSet.getColor(R.styleable.QMUITopBar_qmui_topbar_separator_color, ContextCompat.getColor((Context)context, (int)R.color.qmui_config_color_separator));
        this.mTopBarSeparatorHeight = attributeSet.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_separator_height, 1);
        this.mTopBarBgColor = attributeSet.getColor(R.styleable.QMUITopBar_qmui_topbar_bg_color, -1);
        this.getCommonFieldFormTypedArray(context, (TypedArray)attributeSet);
        boolean bl = attributeSet.getBoolean(R.styleable.QMUITopBar_qmui_topbar_need_separator, true);
        attributeSet.recycle();
        this.setBackgroundDividerEnabled(bl);
    }

    private void initVar() {
        this.mLeftLastViewId = -1;
        this.mRightLastViewId = -1;
        this.mLeftViewList = new ArrayList<View>();
        this.mRightViewList = new ArrayList<View>();
    }

    private LinearLayout makeSureTitleContainerView() {
        LinearLayout linearLayout;
        if (this.mTitleContainerView != null) return this.mTitleContainerView;
        this.mTitleContainerView = linearLayout = new LinearLayout(this.getContext());
        linearLayout.setOrientation(1);
        this.mTitleContainerView.setGravity(17);
        linearLayout = this.mTitleContainerView;
        int n = this.mTitleContainerPaddingHor;
        linearLayout.setPadding(n, 0, n, 0);
        this.addView((View)this.mTitleContainerView, (ViewGroup.LayoutParams)this.generateTitleContainerViewLp());
        return this.mTitleContainerView;
    }

    private void updateTitleViewStyle() {
        if (this.mTitleView == null) return;
        TextView textView = this.mSubTitleView;
        if (textView != null && !QMUILangHelper.isNullOrEmpty((CharSequence)textView.getText())) {
            this.mTitleView.setTextSize(0, (float)this.mTitleTextSizeWithSubTitle);
        } else {
            this.mTitleView.setTextSize(0, (float)this.mTitleTextSize);
        }
    }

    public QMUIAlphaImageButton addLeftBackImageButton() {
        return this.addLeftImageButton(this.mLeftBackDrawableRes, R.id.qmui_topbar_item_left_back);
    }

    public QMUIAlphaImageButton addLeftImageButton(int n, int n2) {
        QMUIAlphaImageButton qMUIAlphaImageButton = this.generateTopBarImageButton(n);
        this.addLeftView((View)qMUIAlphaImageButton, n2, this.generateTopBarImageButtonLayoutParams());
        return qMUIAlphaImageButton;
    }

    public Button addLeftTextButton(int n, int n2) {
        return this.addLeftTextButton(this.getResources().getString(n), n2);
    }

    public Button addLeftTextButton(String string, int n) {
        string = this.generateTopBarTextButton(string);
        this.addLeftView((View)string, n, this.generateTopBarTextButtonLayoutParams());
        return string;
    }

    public void addLeftView(View view, int n) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams = layoutParams != null && layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams)layoutParams : new RelativeLayout.LayoutParams(-2, -2);
        this.addLeftView(view, n, (RelativeLayout.LayoutParams)layoutParams);
    }

    public void addLeftView(View view, int n, RelativeLayout.LayoutParams layoutParams) {
        int n2 = this.mLeftLastViewId;
        if (n2 == -1) {
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(1, n2);
        }
        layoutParams.alignWithParent = true;
        this.mLeftLastViewId = n;
        view.setId(n);
        this.mLeftViewList.add(view);
        this.addView(view, (ViewGroup.LayoutParams)layoutParams);
    }

    public QMUIAlphaImageButton addRightImageButton(int n, int n2) {
        QMUIAlphaImageButton qMUIAlphaImageButton = this.generateTopBarImageButton(n);
        this.addRightView((View)qMUIAlphaImageButton, n2, this.generateTopBarImageButtonLayoutParams());
        return qMUIAlphaImageButton;
    }

    public Button addRightTextButton(int n, int n2) {
        return this.addRightTextButton(this.getResources().getString(n), n2);
    }

    public Button addRightTextButton(String string, int n) {
        string = this.generateTopBarTextButton(string);
        this.addRightView((View)string, n, this.generateTopBarTextButtonLayoutParams());
        return string;
    }

    public void addRightView(View view, int n) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams = layoutParams != null && layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams)layoutParams : new RelativeLayout.LayoutParams(-2, -2);
        this.addRightView(view, n, (RelativeLayout.LayoutParams)layoutParams);
    }

    public void addRightView(View view, int n, RelativeLayout.LayoutParams layoutParams) {
        int n2 = this.mRightLastViewId;
        if (n2 == -1) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(0, n2);
        }
        layoutParams.alignWithParent = true;
        this.mRightLastViewId = n;
        view.setId(n);
        this.mRightViewList.add(view);
        this.addView(view, (ViewGroup.LayoutParams)layoutParams);
    }

    public int computeAndSetBackgroundAlpha(int n, int n2, int n3) {
        n = (int)(Math.max(0.0, Math.min((double)((float)(n - n2) / (float)(n3 - n2)), 1.0)) * 255.0);
        this.setBackgroundAlpha(n);
        return n;
    }

    public RelativeLayout.LayoutParams generateTopBarImageButtonLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mTopBarImageBtnWidth, this.mTopBarImageBtnHeight);
        layoutParams.topMargin = Math.max(0, (this.getTopBarHeight() - this.mTopBarImageBtnHeight) / 2);
        return layoutParams;
    }

    public RelativeLayout.LayoutParams generateTopBarTextButtonLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTopBarImageBtnHeight);
        layoutParams.topMargin = Math.max(0, (this.getTopBarHeight() - this.mTopBarImageBtnHeight) / 2);
        return layoutParams;
    }

    void getCommonFieldFormTypedArray(Context context, TypedArray typedArray) {
        this.mLeftBackDrawableRes = typedArray.getResourceId(R.styleable.QMUITopBar_qmui_topbar_left_back_drawable_id, R.id.qmui_topbar_item_left_back);
        this.mTitleGravity = typedArray.getInt(R.styleable.QMUITopBar_qmui_topbar_title_gravity, 17);
        this.mTitleTextSize = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_text_size, QMUIDisplayHelper.sp2px((Context)context, (int)17));
        this.mTitleTextSizeWithSubTitle = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_text_size, QMUIDisplayHelper.sp2px((Context)context, (int)16));
        this.mSubTitleTextSize = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_subtitle_text_size, QMUIDisplayHelper.sp2px((Context)context, (int)11));
        this.mTitleTextColor = typedArray.getColor(R.styleable.QMUITopBar_qmui_topbar_title_color, QMUIResHelper.getAttrColor((Context)context, (int)R.attr.qmui_config_color_gray_1));
        this.mSubTitleTextColor = typedArray.getColor(R.styleable.QMUITopBar_qmui_topbar_subtitle_color, QMUIResHelper.getAttrColor((Context)context, (int)R.attr.qmui_config_color_gray_4));
        this.mTitleMarginHorWhenNoBtnAside = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_margin_horizontal_when_no_btn_aside, 0);
        this.mTitleContainerPaddingHor = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_container_padding_horizontal, 0);
        this.mTopBarImageBtnWidth = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_image_btn_width, QMUIDisplayHelper.dp2px((Context)context, (int)48));
        this.mTopBarImageBtnHeight = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_image_btn_height, QMUIDisplayHelper.dp2px((Context)context, (int)48));
        this.mTopBarTextBtnPaddingHor = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_text_btn_padding_horizontal, QMUIDisplayHelper.dp2px((Context)context, (int)12));
        this.mTopBarTextBtnTextColor = typedArray.getColorStateList(R.styleable.QMUITopBar_qmui_topbar_text_btn_color_state_list);
        this.mTopBarTextBtnTextSize = typedArray.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_text_btn_text_size, QMUIDisplayHelper.sp2px((Context)context, (int)16));
    }

    public CharSequence getTitle() {
        TextView textView = this.mTitleView;
        if (textView != null) return textView.getText();
        return null;
    }

    public Rect getTitleContainerRect() {
        LinearLayout linearLayout;
        if (this.mTitleContainerRect == null) {
            this.mTitleContainerRect = new Rect();
        }
        if ((linearLayout = this.mTitleContainerView) == null) {
            this.mTitleContainerRect.set(0, 0, 0, 0);
        } else {
            QMUIViewHelper.getDescendantRect((ViewGroup)this, (View)linearLayout, (Rect)this.mTitleContainerRect);
        }
        return this.mTitleContainerRect;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent viewParent = this.getParent();
        while (viewParent != null) {
            if (!(viewParent instanceof View)) return;
            if (viewParent instanceof QMUICollapsingTopBarLayout) {
                this.makeSureTitleContainerView();
                return;
            }
            viewParent = viewParent.getParent();
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        LinearLayout linearLayout = this.mTitleContainerView;
        if (linearLayout == null) return;
        int n5 = linearLayout.getMeasuredWidth();
        int n6 = this.mTitleContainerView.getMeasuredHeight();
        n4 = (n4 - n2 - this.mTitleContainerView.getMeasuredHeight()) / 2;
        n2 = this.getPaddingLeft();
        if ((this.mTitleGravity & 7) == 1) {
            n = (n3 - n - this.mTitleContainerView.getMeasuredWidth()) / 2;
        } else {
            n3 = 0;
            n = n2;
            for (n2 = n3; n2 < this.mLeftViewList.size(); ++n2) {
                linearLayout = this.mLeftViewList.get(n2);
                n3 = n;
                if (linearLayout.getVisibility() != 8) {
                    n3 = n + linearLayout.getMeasuredWidth();
                }
                n = n3;
            }
            if (this.mLeftViewList.isEmpty()) {
                n += QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_topbar_title_margin_horizontal_when_no_btn_aside);
            }
        }
        this.mTitleContainerView.layout(n, n4, n5 + n, n6 + n4);
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        View view;
        int n4;
        super.onMeasure(n, n2);
        if (this.mTitleContainerView == null) return;
        int n5 = 0;
        int n6 = 0;
        for (n4 = 0; n4 < this.mLeftViewList.size(); ++n4) {
            view = this.mLeftViewList.get(n4);
            n3 = n6;
            if (view.getVisibility() != 8) {
                n3 = n6 + view.getMeasuredWidth();
            }
            n6 = n3;
        }
        n4 = 0;
        for (n3 = n5; n3 < this.mRightViewList.size(); ++n3) {
            view = this.mRightViewList.get(n3);
            n5 = n4;
            if (view.getVisibility() != 8) {
                n5 = n4 + view.getMeasuredWidth();
            }
            n4 = n5;
        }
        if ((this.mTitleGravity & 7) == 1) {
            n5 = n4;
            n3 = n6;
            if (n6 == 0) {
                n5 = n4;
                n3 = n6;
                if (n4 == 0) {
                    n5 = this.mTitleMarginHorWhenNoBtnAside;
                    n3 = n6 + n5;
                    n5 = n4 + n5;
                }
            }
            n = View.MeasureSpec.getSize((int)n) - Math.max(n3, n5) * 2 - this.getPaddingLeft();
            n6 = this.getPaddingRight();
        } else {
            n3 = n6;
            if (n6 == 0) {
                n3 = n6 + this.mTitleMarginHorWhenNoBtnAside;
            }
            n6 = n4;
            if (n4 == 0) {
                n6 = n4 + this.mTitleMarginHorWhenNoBtnAside;
            }
            n = View.MeasureSpec.getSize((int)n) - n3 - n6 - this.getPaddingLeft();
            n6 = this.getPaddingRight();
        }
        n = View.MeasureSpec.makeMeasureSpec((int)(n - n6), (int)0x40000000);
        this.mTitleContainerView.measure(n, n2);
    }

    public void removeAllLeftViews() {
        Iterator<View> iterator = this.mLeftViewList.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mLeftLastViewId = -1;
                this.mLeftViewList.clear();
                return;
            }
            this.removeView(iterator.next());
        }
    }

    public void removeAllRightViews() {
        Iterator<View> iterator = this.mRightViewList.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mRightLastViewId = -1;
                this.mRightViewList.clear();
                return;
            }
            this.removeView(iterator.next());
        }
    }

    public void removeCenterViewAndTitleView() {
        View view = this.mCenterView;
        if (view != null) {
            if (view.getParent() == this) {
                this.removeView(this.mCenterView);
            }
            this.mCenterView = null;
        }
        if ((view = this.mTitleView) == null) return;
        if (view.getParent() == this) {
            this.removeView((View)this.mTitleView);
        }
        this.mTitleView = null;
    }

    public void setBackgroundAlpha(int n) {
        this.getBackground().setAlpha(n);
    }

    public void setBackgroundDividerEnabled(boolean bl) {
        if (bl) {
            if (this.mTopBarBgWithSeparatorDrawableCache == null) {
                this.mTopBarBgWithSeparatorDrawableCache = QMUIDrawableHelper.createItemSeparatorBg((int)this.mTopBarSeparatorColor, (int)this.mTopBarBgColor, (int)this.mTopBarSeparatorHeight, (boolean)false);
            }
            QMUIViewHelper.setBackgroundKeepingPadding((View)this, (Drawable)this.mTopBarBgWithSeparatorDrawableCache);
        } else {
            QMUIViewHelper.setBackgroundColorKeepPadding((View)this, (int)this.mTopBarBgColor);
        }
    }

    public void setCenterView(View view) {
        View view2 = this.mCenterView;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            this.removeView(view2);
        }
        this.mCenterView = view;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)view.getLayoutParams();
        view2 = layoutParams;
        if (layoutParams == null) {
            view2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        view2.addRule(13);
        this.addView(view, (ViewGroup.LayoutParams)view2);
    }

    public TextView setEmojiTitle(String string) {
        TextView textView = this.getTitleView(true);
        textView.setText((CharSequence)string);
        if (QMUILangHelper.isNullOrEmpty((CharSequence)string)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        return textView;
    }

    public void setSubTitle(int n) {
        this.setSubTitle(this.getResources().getString(n));
    }

    public void setSubTitle(String string) {
        TextView textView = this.getSubTitleView();
        textView.setText((CharSequence)string);
        if (QMUILangHelper.isNullOrEmpty((CharSequence)string)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        this.updateTitleViewStyle();
    }

    public TextView setTitle(int n) {
        return this.setTitle(this.getContext().getString(n));
    }

    public TextView setTitle(String string) {
        TextView textView = this.getTitleView(false);
        textView.setText((CharSequence)string);
        if (QMUILangHelper.isNullOrEmpty((CharSequence)string)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        return textView;
    }

    public void setTitleGravity(int n) {
        this.mTitleGravity = n;
        TextView textView = this.mTitleView;
        if (textView != null) {
            ((LinearLayout.LayoutParams)textView.getLayoutParams()).gravity = n;
            if (n == 17 || n == 1) {
                this.mTitleView.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingLeft(), this.getPaddingBottom());
            }
        }
        if ((textView = this.mSubTitleView) != null) {
            ((LinearLayout.LayoutParams)textView.getLayoutParams()).gravity = n;
        }
        this.requestLayout();
    }

    public void showTitleView(boolean bl) {
        TextView textView = this.mTitleView;
        if (textView == null) return;
        int n = bl ? 0 : 8;
        textView.setVisibility(n);
    }
}
