/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$drawable
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.QMUILoadingView
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

public static class QMUITipDialog.Builder {
    public static final int ICON_TYPE_FAIL = 3;
    public static final int ICON_TYPE_INFO = 4;
    public static final int ICON_TYPE_LOADING = 1;
    public static final int ICON_TYPE_NOTHING = 0;
    public static final int ICON_TYPE_SUCCESS = 2;
    private Context mContext;
    private int mCurrentIconType = 0;
    private CharSequence mTipWord;

    public QMUITipDialog.Builder(Context context) {
        this.mContext = context;
    }

    public QMUITipDialog create() {
        return this.create(true);
    }

    public QMUITipDialog create(boolean bl) {
        Object object;
        QMUITipDialog qMUITipDialog = new QMUITipDialog(this.mContext);
        qMUITipDialog.setCancelable(bl);
        qMUITipDialog.setContentView(R.layout.qmui_tip_dialog_layout);
        ViewGroup viewGroup = (ViewGroup)qMUITipDialog.findViewById(R.id.contentWrap);
        int n = this.mCurrentIconType;
        if (n == 1) {
            object = new QMUILoadingView(this.mContext);
            object.setColor(-1);
            object.setSize(QMUIDisplayHelper.dp2px((Context)this.mContext, (int)32));
            object.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
            viewGroup.addView((View)object);
        } else if (n == 2 || n == 3 || n == 4) {
            object = new ImageView(this.mContext);
            object.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
            n = this.mCurrentIconType;
            if (n == 2) {
                object.setImageDrawable(ContextCompat.getDrawable((Context)this.mContext, (int)R.drawable.qmui_icon_notify_done));
            } else if (n == 3) {
                object.setImageDrawable(ContextCompat.getDrawable((Context)this.mContext, (int)R.drawable.qmui_icon_notify_error));
            } else {
                object.setImageDrawable(ContextCompat.getDrawable((Context)this.mContext, (int)R.drawable.qmui_icon_notify_info));
            }
            viewGroup.addView((View)object);
        }
        object = this.mTipWord;
        if (object == null) return qMUITipDialog;
        if (object.length() <= 0) return qMUITipDialog;
        object = new TextView(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.mCurrentIconType != 0) {
            layoutParams.topMargin = QMUIDisplayHelper.dp2px((Context)this.mContext, (int)12);
        }
        object.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        object.setEllipsize(TextUtils.TruncateAt.END);
        object.setGravity(17);
        object.setMaxLines(2);
        object.setTextColor(ContextCompat.getColor((Context)this.mContext, (int)R.color.qmui_config_color_white));
        object.setTextSize(2, 14.0f);
        object.setText(this.mTipWord);
        viewGroup.addView((View)object);
        return qMUITipDialog;
    }

    public QMUITipDialog.Builder setIconType(int n) {
        this.mCurrentIconType = n;
        return this;
    }

    public QMUITipDialog.Builder setTipWord(CharSequence charSequence) {
        this.mTipWord = charSequence;
        return this;
    }
}
