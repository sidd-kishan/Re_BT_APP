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

public static class QMUIDialogMenuItemView.MarkItemView
extends QMUIDialogMenuItemView {
    private ImageView mCheckedView;
    private Context mContext;
    private TextView mTextView;

    public QMUIDialogMenuItemView.MarkItemView(Context context) {
        super(context);
        ImageView imageView;
        this.mContext = context;
        this.mCheckedView = imageView = new ImageView(this.mContext);
        imageView.setId(QMUIViewHelper.generateViewId());
        imageView = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuMarkDef, R.attr.qmui_dialog_menu_item_style, 0);
        int n = imageView.getIndexCount();
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4;
            if (n2 >= n) {
                imageView.recycle();
                context = new RelativeLayout.LayoutParams(-2, -2);
                context.addRule(15, -1);
                context.addRule(11, -1);
                context.leftMargin = n3;
                this.addView((View)this.mCheckedView, (ViewGroup.LayoutParams)context);
                this.mTextView = QMUIDialogMenuItemView.MarkItemView.createItemTextView((Context)this.mContext);
                context = new RelativeLayout.LayoutParams(-1, -1);
                context.addRule(9, -1);
                context.addRule(0, this.mCheckedView.getId());
                this.addView((View)this.mTextView, (ViewGroup.LayoutParams)context);
                return;
            }
            int n5 = imageView.getIndex(n2);
            if (n5 == R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_check_mark_margin_hor) {
                n4 = imageView.getDimensionPixelSize(n5, 0);
            } else {
                n4 = n3;
                if (n5 == R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_mark_drawable) {
                    this.mCheckedView.setImageDrawable(QMUIResHelper.getAttrDrawable((Context)context, (TypedArray)imageView, (int)n5));
                    n4 = n3;
                }
            }
            ++n2;
            n3 = n4;
        }
    }

    public QMUIDialogMenuItemView.MarkItemView(Context context, CharSequence charSequence) {
        this(context);
        this.setText(charSequence);
    }

    protected void notifyCheckChange(boolean bl) {
        QMUIViewHelper.safeSetImageViewSelected((ImageView)this.mCheckedView, (boolean)bl);
    }

    public void setText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
    }
}
