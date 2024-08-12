/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.widget.QMUILoadingView
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.QMUILoadingView;

public class QMUIEmptyView
extends FrameLayout {
    protected Button mButton;
    private TextView mDetailTextView;
    private QMUILoadingView mLoadingView;
    private TextView mTitleTextView;

    public QMUIEmptyView(Context context) {
        this(context, null);
    }

    public QMUIEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIEmptyView(Context object, AttributeSet attributeSet, int n) {
        super(object, attributeSet, n);
        this.init();
        attributeSet = object.obtainStyledAttributes(attributeSet, R.styleable.QMUIEmptyView);
        boolean bl = attributeSet.getBoolean(R.styleable.QMUIEmptyView_qmui_show_loading, false);
        String string = attributeSet.getString(R.styleable.QMUIEmptyView_qmui_title_text);
        object = attributeSet.getString(R.styleable.QMUIEmptyView_qmui_detail_text);
        String string2 = attributeSet.getString(R.styleable.QMUIEmptyView_qmui_btn_text);
        attributeSet.recycle();
        this.show(bl, string, (String)object, string2, null);
    }

    private void init() {
        LayoutInflater.from((Context)this.getContext()).inflate(R.layout.qmui_empty_view, (ViewGroup)this, true);
        this.mLoadingView = (QMUILoadingView)this.findViewById(R.id.empty_view_loading);
        this.mTitleTextView = (TextView)this.findViewById(R.id.empty_view_title);
        this.mDetailTextView = (TextView)this.findViewById(R.id.empty_view_detail);
        this.mButton = (Button)this.findViewById(R.id.empty_view_button);
    }

    public void hide() {
        this.setVisibility(8);
        this.setLoadingShowing(false);
        this.setTitleText(null);
        this.setDetailText(null);
        this.setButton(null, null);
    }

    public boolean isLoading() {
        boolean bl = this.mLoadingView.getVisibility() == 0;
        return bl;
    }

    public boolean isShowing() {
        boolean bl = this.getVisibility() == 0;
        return bl;
    }

    public void setButton(String string, View.OnClickListener onClickListener) {
        this.mButton.setText((CharSequence)string);
        Button button = this.mButton;
        int n = string != null ? 0 : 8;
        button.setVisibility(n);
        this.mButton.setOnClickListener(onClickListener);
    }

    public void setDetailColor(int n) {
        this.mDetailTextView.setTextColor(n);
    }

    public void setDetailText(String string) {
        this.mDetailTextView.setText((CharSequence)string);
        TextView textView = this.mDetailTextView;
        int n = string != null ? 0 : 8;
        textView.setVisibility(n);
    }

    public void setLoadingShowing(boolean bl) {
        QMUILoadingView qMUILoadingView = this.mLoadingView;
        int n = bl ? 0 : 8;
        qMUILoadingView.setVisibility(n);
    }

    public void setTitleColor(int n) {
        this.mTitleTextView.setTextColor(n);
    }

    public void setTitleText(String string) {
        this.mTitleTextView.setText((CharSequence)string);
        TextView textView = this.mTitleTextView;
        int n = string != null ? 0 : 8;
        textView.setVisibility(n);
    }

    public void show() {
        this.setVisibility(0);
    }

    public void show(String string, String string2) {
        this.setLoadingShowing(false);
        this.setTitleText(string);
        this.setDetailText(string2);
        this.setButton(null, null);
        this.show();
    }

    public void show(boolean bl) {
        this.setLoadingShowing(bl);
        this.setTitleText(null);
        this.setDetailText(null);
        this.setButton(null, null);
        this.show();
    }

    public void show(boolean bl, String string, String string2, String string3, View.OnClickListener onClickListener) {
        this.setLoadingShowing(bl);
        this.setTitleText(string);
        this.setDetailText(string2);
        this.setButton(string3, onClickListener);
        this.show();
    }
}
