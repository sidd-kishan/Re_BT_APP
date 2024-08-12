/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.QMUIWrapContentScrollView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 *  com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUIWrapContentScrollView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

public class QMUIDialogBlockBuilder
extends QMUIDialogBuilder<QMUIDialogBlockBuilder> {
    private CharSequence mContent;

    public QMUIDialogBlockBuilder(Context context) {
        super(context);
        this.setActionDivider(1, R.color.qmui_config_color_separator, 0, 0);
    }

    public QMUIDialog create(int n) {
        this.setActionContainerOrientation(1);
        return super.create(n);
    }

    protected void onConfigTitleView(TextView textView) {
        super.onConfigTitleView(textView);
        CharSequence charSequence = this.mContent;
        if (charSequence != null) {
            if (charSequence.length() != 0) return;
        }
        charSequence = textView.getContext();
        int[] nArray = R.styleable.QMUIDialogTitleTvCustomDef;
        int n = R.attr.qmui_dialog_title_style;
        int n2 = 0;
        charSequence = charSequence.obtainStyledAttributes(null, nArray, n, 0);
        n = charSequence.getIndexCount();
        while (true) {
            if (n2 >= n) {
                charSequence.recycle();
                return;
            }
            int n3 = charSequence.getIndex(n2);
            if (n3 == R.styleable.QMUIDialogTitleTvCustomDef_qmui_paddingBottomWhenNotContent) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), charSequence.getDimensionPixelSize(n3, textView.getPaddingBottom()));
            }
            ++n2;
        }
    }

    protected void onCreateContent(QMUIDialog object, ViewGroup viewGroup, Context context) {
        object = this.mContent;
        if (object == null) return;
        if (object.length() <= 0) return;
        object = new QMUISpanTouchFixTextView(context);
        QMUIResHelper.assignTextViewWithAttr((TextView)object, (int)R.attr.qmui_dialog_message_content_style);
        if (!this.hasTitle()) {
            Object object2 = R.styleable.QMUIDialogMessageTvCustomDef;
            int n = R.attr.qmui_dialog_message_content_style;
            object2 = context.obtainStyledAttributes(null, object2, n, 0);
            n = object2.getIndexCount();
            for (int i = 0; i < n; ++i) {
                int n2 = object2.getIndex(i);
                if (n2 != R.styleable.QMUIDialogMessageTvCustomDef_qmui_paddingTopWhenNotTitle) continue;
                object.setPadding(object.getPaddingLeft(), object2.getDimensionPixelSize(n2, object.getPaddingTop()), object.getPaddingRight(), object.getPaddingBottom());
            }
            object2.recycle();
        }
        object.setText(this.mContent);
        context = new QMUIWrapContentScrollView(context);
        context.setMaxHeight(this.getContentAreaMaxHeight());
        context.addView((View)object);
        viewGroup.addView((View)context);
    }

    public QMUIDialogBlockBuilder setContent(int n) {
        this.mContent = this.getBaseContext().getResources().getString(n);
        return this;
    }

    public QMUIDialogBlockBuilder setContent(CharSequence charSequence) {
        this.mContent = charSequence;
        return this;
    }
}
