/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewStub
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatImageView
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.alpha.QMUIAlphaLinearLayout
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaLinearLayout;

public class QMUIBottomSheetItemView
extends QMUIAlphaLinearLayout {
    private AppCompatImageView mAppCompatImageView;
    private ViewStub mSubScript;
    private TextView mTextView;

    public QMUIBottomSheetItemView(Context context) {
        super(context);
    }

    public QMUIBottomSheetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIBottomSheetItemView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public AppCompatImageView getAppCompatImageView() {
        return this.mAppCompatImageView;
    }

    public ViewStub getSubScript() {
        return this.mSubScript;
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mAppCompatImageView = (AppCompatImageView)this.findViewById(R.id.grid_item_image);
        this.mSubScript = (ViewStub)this.findViewById(R.id.grid_item_subscript);
        this.mTextView = (TextView)this.findViewById(R.id.grid_item_title);
    }
}
