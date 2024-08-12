/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import java.util.ArrayList;
import java.util.List;

public static class QMUITabSegment.Tab {
    public static final int USE_TAB_SEGMENT = Integer.MIN_VALUE;
    private int contentLeft = 0;
    private int contentWidth = 0;
    private boolean dynamicChangeIconColor = true;
    private int gravity = 17;
    private int iconPosition;
    private int leftAddonMargin = 0;
    private float leftSpaceWeight = 0.0f;
    private List<View> mCustomViews;
    private int mSignCountDigits = 2;
    private int mSignCountMarginLeft = 0;
    private int mSignCountMarginTop = 0;
    private TextView mSignCountTextView;
    private int normalColor;
    private Drawable normalIcon = null;
    private int rightAddonMargin = 0;
    private float rightSpaceWeight = 0.0f;
    private int selectedColor;
    private Drawable selectedIcon = null;
    private CharSequence text;
    private int textSize = Integer.MIN_VALUE;

    public QMUITabSegment.Tab(Drawable drawable, Drawable drawable2, CharSequence charSequence, boolean bl) {
        this(drawable, drawable2, charSequence, bl, true);
    }

    public QMUITabSegment.Tab(Drawable drawable, Drawable drawable2, CharSequence charSequence, boolean bl, boolean bl2) {
        this.normalColor = Integer.MIN_VALUE;
        this.selectedColor = Integer.MIN_VALUE;
        this.iconPosition = Integer.MIN_VALUE;
        this.normalIcon = drawable;
        if (drawable != null && bl2) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.selectedIcon = drawable2;
        if (drawable2 != null && bl2) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        this.text = charSequence;
        this.dynamicChangeIconColor = bl;
    }

    public QMUITabSegment.Tab(CharSequence charSequence) {
        this.normalColor = Integer.MIN_VALUE;
        this.selectedColor = Integer.MIN_VALUE;
        this.iconPosition = Integer.MIN_VALUE;
        this.text = charSequence;
    }

    static /* synthetic */ int access$1500(QMUITabSegment.Tab tab) {
        return tab.contentLeft;
    }

    static /* synthetic */ int access$1600(QMUITabSegment.Tab tab) {
        return tab.contentWidth;
    }

    static /* synthetic */ int access$2600(QMUITabSegment.Tab tab) {
        return tab.leftAddonMargin;
    }

    static /* synthetic */ int access$2602(QMUITabSegment.Tab tab, int n) {
        tab.leftAddonMargin = n;
        return n;
    }

    static /* synthetic */ int access$2700(QMUITabSegment.Tab tab) {
        return tab.rightAddonMargin;
    }

    static /* synthetic */ int access$2702(QMUITabSegment.Tab tab, int n) {
        tab.rightAddonMargin = n;
        return n;
    }

    static /* synthetic */ float access$2900(QMUITabSegment.Tab tab) {
        return tab.leftSpaceWeight;
    }

    static /* synthetic */ float access$3000(QMUITabSegment.Tab tab) {
        return tab.rightSpaceWeight;
    }

    private TextView ensureSignCountView(Context context) {
        if (this.mSignCountTextView == null) {
            this.mSignCountTextView = new TextView(context, null, R.attr.qmui_tab_sign_count_view);
            context = new RelativeLayout.LayoutParams(-2, QMUIResHelper.getAttrDimen((Context)context, (int)R.attr.qmui_tab_sign_count_view_minSize));
            context.addRule(6, R.id.qmui_tab_segment_item_id);
            context.addRule(1, R.id.qmui_tab_segment_item_id);
            this.mSignCountTextView.setLayoutParams((ViewGroup.LayoutParams)context);
            this.addCustomView((View)this.mSignCountTextView);
        }
        this.setSignCountMargin(this.mSignCountMarginLeft, this.mSignCountMarginTop);
        return this.mSignCountTextView;
    }

    private RelativeLayout.LayoutParams getDefaultCustomLayoutParam() {
        return new RelativeLayout.LayoutParams(-2, -2);
    }

    private String getNumberDigitsFormattingValue(int n) {
        if (QMUILangHelper.getNumberDigits((int)n) <= this.mSignCountDigits) return String.valueOf(n);
        StringBuilder stringBuilder = new StringBuilder();
        n = 1;
        while (true) {
            if (n > this.mSignCountDigits) {
                stringBuilder.append("+");
                return stringBuilder.toString();
            }
            stringBuilder.append("9");
            ++n;
        }
    }

    public void addCustomView(View view) {
        if (this.mCustomViews == null) {
            this.mCustomViews = new ArrayList<View>();
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams((ViewGroup.LayoutParams)this.getDefaultCustomLayoutParam());
        }
        this.mCustomViews.add(view);
    }

    public int getContentLeft() {
        return this.contentLeft;
    }

    public int getContentWidth() {
        return this.contentWidth;
    }

    public List<View> getCustomViews() {
        return this.mCustomViews;
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getIconPosition() {
        return this.iconPosition;
    }

    public int getNormalColor() {
        return this.normalColor;
    }

    public Drawable getNormalIcon() {
        return this.normalIcon;
    }

    public int getSelectedColor() {
        return this.selectedColor;
    }

    public Drawable getSelectedIcon() {
        return this.selectedIcon;
    }

    public int getSignCount() {
        TextView textView = this.mSignCountTextView;
        if (textView == null) return 0;
        if (textView.getVisibility() != 0) {
            return 0;
        }
        if (QMUILangHelper.isNullOrEmpty((CharSequence)this.mSignCountTextView.getText())) return 0;
        return Integer.parseInt(this.mSignCountTextView.getText().toString());
    }

    public CharSequence getText() {
        return this.text;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public void hideSignCountView() {
        TextView textView = this.mSignCountTextView;
        if (textView == null) return;
        textView.setVisibility(8);
    }

    public boolean isDynamicChangeIconColor() {
        return this.dynamicChangeIconColor;
    }

    public void setContentLeft(int n) {
        this.contentLeft = n;
    }

    public void setContentWidth(int n) {
        this.contentWidth = n;
    }

    public void setGravity(int n) {
        this.gravity = n;
    }

    public void setIconPosition(int n) {
        this.iconPosition = n;
    }

    public void setSignCountMargin(int n, int n2) {
        this.mSignCountMarginLeft = n;
        this.mSignCountMarginTop = n2;
        TextView textView = this.mSignCountTextView;
        if (textView == null) return;
        if (textView.getLayoutParams() == null) return;
        ((ViewGroup.MarginLayoutParams)this.mSignCountTextView.getLayoutParams()).leftMargin = n;
        ((ViewGroup.MarginLayoutParams)this.mSignCountTextView.getLayoutParams()).topMargin = n2;
    }

    public void setSpaceWeight(float f, float f2) {
        this.leftSpaceWeight = f;
        this.rightSpaceWeight = f2;
    }

    public void setText(CharSequence charSequence) {
        this.text = charSequence;
    }

    public void setTextColor(int n, int n2) {
        this.normalColor = n;
        this.selectedColor = n2;
    }

    public void setTextSize(int n) {
        this.textSize = n;
    }

    public void setmSignCountDigits(int n) {
        this.mSignCountDigits = n;
    }

    public void showSignCountView(Context context, int n) {
        this.ensureSignCountView(context);
        this.mSignCountTextView.setVisibility(0);
        context = (RelativeLayout.LayoutParams)this.mSignCountTextView.getLayoutParams();
        if (n != 0) {
            context.height = QMUIResHelper.getAttrDimen((Context)this.mSignCountTextView.getContext(), (int)R.attr.qmui_tab_sign_count_view_minSize_with_text);
            this.mSignCountTextView.setLayoutParams((ViewGroup.LayoutParams)context);
            context = this.mSignCountTextView;
            context.setMinHeight(QMUIResHelper.getAttrDimen((Context)context.getContext(), (int)R.attr.qmui_tab_sign_count_view_minSize_with_text));
            context = this.mSignCountTextView;
            context.setMinWidth(QMUIResHelper.getAttrDimen((Context)context.getContext(), (int)R.attr.qmui_tab_sign_count_view_minSize_with_text));
            this.mSignCountTextView.setText((CharSequence)this.getNumberDigitsFormattingValue(n));
        } else {
            context.height = QMUIResHelper.getAttrDimen((Context)this.mSignCountTextView.getContext(), (int)R.attr.qmui_tab_sign_count_view_minSize);
            this.mSignCountTextView.setLayoutParams((ViewGroup.LayoutParams)context);
            context = this.mSignCountTextView;
            context.setMinHeight(QMUIResHelper.getAttrDimen((Context)context.getContext(), (int)R.attr.qmui_tab_sign_count_view_minSize));
            context = this.mSignCountTextView;
            context.setMinWidth(QMUIResHelper.getAttrDimen((Context)context.getContext(), (int)R.attr.qmui_tab_sign_count_view_minSize));
            this.mSignCountTextView.setText(null);
        }
    }
}
