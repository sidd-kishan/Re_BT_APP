/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

public static class QMUIDialogMenuItemView.CheckItemView
extends QMUIDialogMenuItemView {
    private ImageView mCheckedView;
    private Context mContext;
    private TextView mTextView;

    public QMUIDialogMenuItemView.CheckItemView(Context context, boolean bl) {
        super(context);
        ImageView imageView;
        this.mContext = context;
        this.mCheckedView = imageView = new ImageView(this.mContext);
        imageView.setId(QMUIViewHelper.generateViewId());
        imageView = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuCheckDef, R.attr.qmui_dialog_menu_item_style, 0);
        int n = imageView.getIndexCount();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            int n3;
            int n4 = imageView.getIndex(i);
            if (n4 == R.styleable.QMUIDialogMenuCheckDef_qmui_dialog_menu_item_check_mark_margin_hor) {
                n3 = imageView.getDimensionPixelSize(n4, 0);
            } else {
                n3 = n2;
                if (n4 == R.styleable.QMUIDialogMenuCheckDef_qmui_dialog_menu_item_check_drawable) {
                    this.mCheckedView.setImageDrawable(QMUIResHelper.getAttrDrawable((Context)context, (TypedArray)imageView, (int)n4));
                    n3 = n2;
                }
            }
            n2 = n3;
        }
        imageView.recycle();
        context = new RelativeLayout.LayoutParams(-2, -2);
        context.addRule(15, -1);
        if (bl) {
            context.addRule(11, -1);
            context.leftMargin = n2;
        } else {
            context.addRule(9, -1);
            context.rightMargin = n2;
        }
        this.addView((View)this.mCheckedView, (ViewGroup.LayoutParams)context);
        this.mTextView = QMUIDialogMenuItemView.CheckItemView.createItemTextView((Context)this.mContext);
        context = new RelativeLayout.LayoutParams(-1, -1);
        if (bl) {
            context.addRule(0, this.mCheckedView.getId());
        } else {
            context.addRule(1, this.mCheckedView.getId());
        }
        this.addView((View)this.mTextView, (ViewGroup.LayoutParams)context);
    }

    public QMUIDialogMenuItemView.CheckItemView(Context context, boolean bl, CharSequence charSequence) {
        this(context, bl);
        this.setText(charSequence);
    }

    public CharSequence getText() {
        return this.mTextView.getText();
    }

    protected void notifyCheckChange(boolean bl) {
        QMUIViewHelper.safeSetImageViewSelected((ImageView)this.mCheckedView, (boolean)bl);
    }

    public void setText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
    }
}
