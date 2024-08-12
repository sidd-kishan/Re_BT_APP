/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStub
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.legacy.widget.Space
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView$LayoutParamConfig
 */
package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.legacy.widget.Space;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;

public class QMUICommonListItemView
extends RelativeLayout {
    public static final int ACCESSORY_TYPE_CHEVRON = 1;
    public static final int ACCESSORY_TYPE_CUSTOM = 3;
    public static final int ACCESSORY_TYPE_NONE = 0;
    public static final int ACCESSORY_TYPE_SWITCH = 2;
    public static final int HORIZONTAL = 1;
    public static final int REDDOT_POSITION_LEFT = 0;
    public static final int REDDOT_POSITION_RIGHT = 1;
    public static final int VERTICAL = 0;
    private int mAccessoryType;
    private ViewGroup mAccessoryView;
    protected TextView mDetailTextView;
    protected ImageView mImageView;
    private View mNewTip;
    private ViewStub mNewTipViewStub;
    private int mOrientation = 1;
    private ImageView mRedDot;
    private int mRedDotPosition = 0;
    protected CheckBox mSwitch;
    protected LinearLayout mTextContainer;
    protected Space mTextDetailSpace;
    protected TextView mTextView;

    public QMUICommonListItemView(Context context) {
        this(context, null);
    }

    public QMUICommonListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUICommonListItemViewStyle);
    }

    public QMUICommonListItemView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private ImageView getAccessoryImageView() {
        ImageView imageView = new ImageView(this.getContext());
        imageView.setLayoutParams(this.getAccessoryLayoutParams());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }

    private ViewGroup.LayoutParams getAccessoryLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public void addAccessoryCustomView(View view) {
        if (this.mAccessoryType != 3) return;
        this.mAccessoryView.addView(view);
    }

    public ViewGroup getAccessoryContainerView() {
        return this.mAccessoryView;
    }

    public int getAccessoryType() {
        return this.mAccessoryType;
    }

    public CharSequence getDetailText() {
        return this.mDetailTextView.getText();
    }

    public TextView getDetailTextView() {
        return this.mDetailTextView;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public CheckBox getSwitch() {
        return this.mSwitch;
    }

    public CharSequence getText() {
        return this.mTextView.getText();
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    protected void init(Context context, AttributeSet attributeSet, int n) {
        LayoutInflater.from((Context)context).inflate(R.layout.qmui_common_list_item, (ViewGroup)this, true);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICommonListItemView, n, 0);
        int n2 = attributeSet.getInt(R.styleable.QMUICommonListItemView_qmui_orientation, 1);
        int n3 = attributeSet.getInt(R.styleable.QMUICommonListItemView_qmui_accessory_type, 0);
        n = attributeSet.getColor(R.styleable.QMUICommonListItemView_qmui_commonList_titleColor, QMUIResHelper.getAttrColor((Context)this.getContext(), (int)R.attr.qmui_config_color_gray_1));
        int n4 = attributeSet.getColor(R.styleable.QMUICommonListItemView_qmui_commonList_detailColor, QMUIResHelper.getAttrColor((Context)this.getContext(), (int)R.attr.qmui_config_color_gray_5));
        attributeSet.recycle();
        this.mImageView = (ImageView)this.findViewById(R.id.group_list_item_imageView);
        this.mTextContainer = (LinearLayout)this.findViewById(R.id.group_list_item_textContainer);
        attributeSet = (TextView)this.findViewById(R.id.group_list_item_textView);
        this.mTextView = attributeSet;
        attributeSet.setTextColor(n);
        this.mRedDot = (ImageView)this.findViewById(R.id.group_list_item_tips_dot);
        this.mNewTipViewStub = (ViewStub)this.findViewById(R.id.group_list_item_tips_new);
        this.mDetailTextView = (TextView)this.findViewById(R.id.group_list_item_detailTextView);
        this.mTextDetailSpace = (Space)this.findViewById(R.id.group_list_item_space);
        this.mDetailTextView.setTextColor(n4);
        attributeSet = (LinearLayout.LayoutParams)this.mDetailTextView.getLayoutParams();
        if (QMUIViewHelper.getIsLastLineSpacingExtraError()) {
            ((LinearLayout.LayoutParams)attributeSet).bottomMargin = -QMUIResHelper.getAttrDimen((Context)context, (int)R.attr.qmui_common_list_item_detail_line_space);
        }
        ((LinearLayout.LayoutParams)attributeSet).topMargin = n2 == 0 ? QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)6) : 0;
        this.mAccessoryView = (ViewGroup)this.findViewById(R.id.group_list_item_accessoryView);
        this.setOrientation(n2);
        this.setAccessoryType(n3);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        float f;
        super.onLayout(bl, n, n2, n3, n4);
        ImageView imageView = this.mRedDot;
        if (imageView != null && imageView.getVisibility() == 0) {
            n2 = this.getHeight() / 2 - this.mRedDot.getMeasuredHeight() / 2;
            n3 = this.mTextContainer.getLeft();
            n = this.mRedDotPosition;
            if (n == 0) {
                f = this.mTextView.getPaint().measureText(this.mTextView.getText().toString());
                n = (int)((float)n3 + f + (float)QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)4));
            } else {
                if (n != 1) return;
                n = n3 + this.mTextContainer.getWidth() - this.mRedDot.getMeasuredWidth();
            }
            imageView = this.mRedDot;
            imageView.layout(n, n2, imageView.getMeasuredWidth() + n, this.mRedDot.getMeasuredHeight() + n2);
        }
        if ((imageView = this.mNewTip) == null) return;
        if (imageView.getVisibility() != 0) return;
        n = this.mTextContainer.getLeft();
        f = this.mTextView.getPaint().measureText(this.mTextView.getText().toString());
        n = (int)((float)n + f + (float)QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)4));
        n2 = this.getHeight() / 2 - this.mNewTip.getMeasuredHeight() / 2;
        imageView = this.mNewTip;
        imageView.layout(n, n2, imageView.getMeasuredWidth() + n, this.mNewTip.getMeasuredHeight() + n2);
    }

    public void setAccessoryType(int n) {
        this.mAccessoryView.removeAllViews();
        this.mAccessoryType = n;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) return;
                    this.mAccessoryView.setVisibility(0);
                } else {
                    if (this.mSwitch == null) {
                        CheckBox checkBox;
                        this.mSwitch = checkBox = new CheckBox(this.getContext());
                        checkBox.setButtonDrawable(QMUIResHelper.getAttrDrawable((Context)this.getContext(), (int)R.attr.qmui_common_list_item_switch));
                        this.mSwitch.setLayoutParams(this.getAccessoryLayoutParams());
                        this.mSwitch.setClickable(false);
                        this.mSwitch.setEnabled(false);
                    }
                    this.mAccessoryView.addView((View)this.mSwitch);
                    this.mAccessoryView.setVisibility(0);
                }
            } else {
                ImageView imageView = this.getAccessoryImageView();
                imageView.setImageDrawable(QMUIResHelper.getAttrDrawable((Context)this.getContext(), (int)R.attr.qmui_common_list_item_chevron));
                this.mAccessoryView.addView((View)imageView);
                this.mAccessoryView.setVisibility(0);
            }
        } else {
            this.mAccessoryView.setVisibility(8);
        }
    }

    public void setDetailText(CharSequence charSequence) {
        this.mDetailTextView.setText(charSequence);
        if (QMUILangHelper.isNullOrEmpty((CharSequence)charSequence)) {
            this.mDetailTextView.setVisibility(8);
        } else {
            this.mDetailTextView.setVisibility(0);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mImageView.setVisibility(8);
        } else {
            this.mImageView.setImageDrawable(drawable);
            this.mImageView.setVisibility(0);
        }
    }

    public void setOrientation(int n) {
        this.mOrientation = n;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.mTextDetailSpace.getLayoutParams();
        if (this.mOrientation == 0) {
            this.mTextContainer.setOrientation(1);
            this.mTextContainer.setGravity(3);
            layoutParams.width = -2;
            layoutParams.height = QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)4);
            layoutParams.weight = 0.0f;
            this.mTextView.setTextSize(0, (float)QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_common_list_item_title_v_text_size));
            this.mDetailTextView.setTextSize(0, (float)QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_common_list_item_detail_v_text_size));
        } else {
            this.mTextContainer.setOrientation(0);
            this.mTextContainer.setGravity(16);
            layoutParams.width = 0;
            layoutParams.height = 0;
            layoutParams.weight = 1.0f;
            this.mTextView.setTextSize(0, (float)QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_common_list_item_title_h_text_size));
            this.mDetailTextView.setTextSize(0, (float)QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_common_list_item_detail_h_text_size));
        }
    }

    public void setRedDotPosition(int n) {
        this.mRedDotPosition = n;
        this.requestLayout();
    }

    public void setText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
        if (QMUILangHelper.isNullOrEmpty((CharSequence)charSequence)) {
            this.mTextView.setVisibility(8);
        } else {
            this.mTextView.setVisibility(0);
        }
    }

    public void showNewTip(boolean bl) {
        if (bl) {
            if (this.mNewTip == null) {
                this.mNewTip = this.mNewTipViewStub.inflate();
            }
            this.mNewTip.setVisibility(0);
            this.mRedDot.setVisibility(8);
        } else {
            View view = this.mNewTip;
            if (view == null) return;
            if (view.getVisibility() != 0) return;
            this.mNewTip.setVisibility(8);
        }
    }

    public void showRedDot(boolean bl) {
        this.showRedDot(bl, true);
    }

    public void showRedDot(boolean bl, boolean bl2) {
        ImageView imageView = this.mRedDot;
        int n = bl && bl2 ? 0 : 8;
        imageView.setVisibility(n);
    }

    public void updateImageViewLp(LayoutParamConfig layoutParamConfig) {
        if (layoutParamConfig == null) return;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.mImageView.getLayoutParams();
        this.mImageView.setLayoutParams((ViewGroup.LayoutParams)layoutParamConfig.onConfig(layoutParams));
    }
}
