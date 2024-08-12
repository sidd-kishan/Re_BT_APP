/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils$TruncateAt
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.layout.QMUIRelativeLayout
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$MenuItemViewListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

public class QMUIDialogMenuItemView
extends QMUIRelativeLayout {
    private int index = -1;
    private boolean mIsChecked = false;
    private MenuItemViewListener mListener;

    public QMUIDialogMenuItemView(Context context) {
        super(context, null, R.attr.qmui_dialog_menu_item_style);
    }

    public static TextView createItemTextView(Context context) {
        TextView textView = new TextView(context);
        context = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuTextStyleDef, R.attr.qmui_dialog_menu_item_style, 0);
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                context.recycle();
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setDuplicateParentStateEnabled(false);
                return textView;
            }
            int n3 = context.getIndex(n2);
            if (n3 == R.styleable.QMUIDialogMenuTextStyleDef_android_gravity) {
                textView.setGravity(context.getInt(n3, -1));
            } else if (n3 == R.styleable.QMUIDialogMenuTextStyleDef_android_textColor) {
                textView.setTextColor(context.getColorStateList(n3));
            } else if (n3 == R.styleable.QMUIDialogMenuTextStyleDef_android_textSize) {
                textView.setTextSize(0, (float)context.getDimensionPixelSize(n3, 0));
            }
            ++n2;
        }
    }

    public int getMenuIndex() {
        return this.index;
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    protected void notifyCheckChange(boolean bl) {
    }

    public boolean performClick() {
        MenuItemViewListener menuItemViewListener = this.mListener;
        if (menuItemViewListener == null) return super.performClick();
        menuItemViewListener.onClick(this.index);
        return super.performClick();
    }

    public void setChecked(boolean bl) {
        this.mIsChecked = bl;
        this.notifyCheckChange(bl);
    }

    public void setListener(MenuItemViewListener menuItemViewListener) {
        if (!this.isClickable()) {
            this.setClickable(true);
        }
        this.mListener = menuItemViewListener;
    }

    public void setMenuIndex(int n) {
        this.index = n;
    }
}
