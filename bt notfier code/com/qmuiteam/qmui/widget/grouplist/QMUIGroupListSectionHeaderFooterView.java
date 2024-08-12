/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.util.QMUILangHelper
 */
package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUILangHelper;

public class QMUIGroupListSectionHeaderFooterView
extends LinearLayout {
    private TextView mTextView;

    public QMUIGroupListSectionHeaderFooterView(Context context) {
        this(context, null, R.attr.QMUIGroupListSectionViewStyle);
    }

    public QMUIGroupListSectionHeaderFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIGroupListSectionViewStyle);
    }

    public QMUIGroupListSectionHeaderFooterView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context);
    }

    public QMUIGroupListSectionHeaderFooterView(Context context, CharSequence charSequence) {
        this(context);
        this.setText(charSequence);
    }

    public QMUIGroupListSectionHeaderFooterView(Context context, CharSequence charSequence, boolean bl) {
        this(context);
        if (bl) {
            this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), 0);
        }
        this.setText(charSequence);
    }

    private void init(Context context) {
        LayoutInflater.from((Context)context).inflate(R.layout.qmui_group_list_section_layout, (ViewGroup)this, true);
        this.setGravity(80);
        this.mTextView = (TextView)this.findViewById(R.id.group_list_section_header_textView);
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public void setText(CharSequence charSequence) {
        if (QMUILangHelper.isNullOrEmpty((CharSequence)charSequence)) {
            this.mTextView.setVisibility(8);
        } else {
            this.mTextView.setVisibility(0);
        }
        this.mTextView.setText(charSequence);
    }

    public void setTextGravity(int n) {
        this.mTextView.setGravity(n);
    }
}
