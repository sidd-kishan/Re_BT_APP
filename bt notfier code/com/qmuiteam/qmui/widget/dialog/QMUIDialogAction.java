/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.layout.QMUIButton
 *  com.qmuiteam.qmui.util.QMUISpanHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.util.QMUISpanHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

public class QMUIDialogAction {
    public static final int ACTION_PROP_NEGATIVE = 2;
    public static final int ACTION_PROP_NEUTRAL = 1;
    public static final int ACTION_PROP_POSITIVE = 0;
    private int mActionProp;
    private QMUIButton mButton;
    private Context mContext;
    private int mIconRes;
    private boolean mIsEnabled = true;
    private ActionListener mOnClickListener;
    private CharSequence mStr;

    public QMUIDialogAction(Context context, int n, int n2, ActionListener actionListener) {
        this.mContext = context;
        this.mStr = context.getResources().getString(n);
        this.mActionProp = n2;
        this.mOnClickListener = actionListener;
    }

    public QMUIDialogAction(Context context, int n, ActionListener actionListener) {
        this(context, context.getResources().getString(n), 1, actionListener);
    }

    public QMUIDialogAction(Context context, int n, CharSequence charSequence, int n2, ActionListener actionListener) {
        this.mContext = context;
        this.mIconRes = n;
        this.mStr = charSequence;
        this.mActionProp = n2;
        this.mOnClickListener = actionListener;
    }

    public QMUIDialogAction(Context context, CharSequence charSequence, int n, ActionListener actionListener) {
        this.mContext = context;
        this.mStr = charSequence;
        this.mActionProp = n;
        this.mOnClickListener = actionListener;
    }

    public QMUIDialogAction(Context context, String string, ActionListener actionListener) {
        this(context, string, 1, actionListener);
    }

    static /* synthetic */ ActionListener access$000(QMUIDialogAction qMUIDialogAction) {
        return qMUIDialogAction.mOnClickListener;
    }

    static /* synthetic */ QMUIButton access$100(QMUIDialogAction qMUIDialogAction) {
        return qMUIDialogAction.mButton;
    }

    private QMUIButton generateActionButton(Context context, CharSequence charSequence, int n) {
        QMUIButton qMUIButton = new QMUIButton(context);
        QMUIViewHelper.setBackground((View)qMUIButton, null);
        qMUIButton.setMinHeight(0);
        qMUIButton.setMinimumHeight(0);
        qMUIButton.setChangeAlphaWhenDisable(true);
        qMUIButton.setChangeAlphaWhenPress(true);
        TypedArray typedArray = context.obtainStyledAttributes(null, R.styleable.QMUIDialogActionStyleDef, R.attr.qmui_dialog_action_style, 0);
        int n2 = typedArray.getIndexCount();
        ColorStateList colorStateList = null;
        ColorStateList colorStateList2 = null;
        int n3 = 0;
        int n4 = 0;
        for (int i = 0; i < n2; ++i) {
            ColorStateList colorStateList3;
            ColorStateList colorStateList4;
            int n5;
            int n6;
            int n7 = typedArray.getIndex(i);
            if (n7 == R.styleable.QMUIDialogActionStyleDef_android_gravity) {
                qMUIButton.setGravity(typedArray.getInt(n7, -1));
                n6 = n3;
                n5 = n4;
                colorStateList4 = colorStateList;
                colorStateList3 = colorStateList2;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_android_textColor) {
                qMUIButton.setTextColor(typedArray.getColorStateList(n7));
                n6 = n3;
                n5 = n4;
                colorStateList4 = colorStateList;
                colorStateList3 = colorStateList2;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_android_textSize) {
                qMUIButton.setTextSize(0, (float)typedArray.getDimensionPixelSize(n7, 0));
                n6 = n3;
                n5 = n4;
                colorStateList4 = colorStateList;
                colorStateList3 = colorStateList2;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_qmui_dialog_action_button_padding_horizontal) {
                n6 = typedArray.getDimensionPixelSize(n7, 0);
                colorStateList3 = colorStateList2;
                colorStateList4 = colorStateList;
                n5 = n4;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_android_background) {
                QMUIViewHelper.setBackground((View)qMUIButton, (Drawable)typedArray.getDrawable(n7));
                n6 = n3;
                n5 = n4;
                colorStateList4 = colorStateList;
                colorStateList3 = colorStateList2;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_android_minWidth) {
                n5 = typedArray.getDimensionPixelSize(n7, 0);
                qMUIButton.setMinWidth(n5);
                qMUIButton.setMinimumWidth(n5);
                n6 = n3;
                n5 = n4;
                colorStateList4 = colorStateList;
                colorStateList3 = colorStateList2;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_qmui_dialog_positive_action_text_color) {
                colorStateList3 = typedArray.getColorStateList(n7);
                n6 = n3;
                n5 = n4;
                colorStateList4 = colorStateList;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_qmui_dialog_negative_action_text_color) {
                colorStateList4 = typedArray.getColorStateList(n7);
                n6 = n3;
                n5 = n4;
                colorStateList3 = colorStateList2;
            } else if (n7 == R.styleable.QMUIDialogActionStyleDef_qmui_dialog_action_icon_space) {
                n5 = typedArray.getDimensionPixelSize(n7, 0);
                n6 = n3;
                colorStateList4 = colorStateList;
                colorStateList3 = colorStateList2;
            } else {
                n6 = n3;
                n5 = n4;
                colorStateList4 = colorStateList;
                colorStateList3 = colorStateList2;
                if (n7 == R.styleable.QMUITextCommonStyleDef_android_textStyle) {
                    qMUIButton.setTypeface(null, typedArray.getInt(n7, -1));
                    continue;
                }
            }
            n3 = n6;
            n4 = n5;
            colorStateList = colorStateList4;
            colorStateList2 = colorStateList3;
        }
        typedArray.recycle();
        qMUIButton.setPadding(n3, 0, n3, 0);
        if (n <= 0) {
            qMUIButton.setText(charSequence);
        } else {
            qMUIButton.setText(QMUISpanHelper.generateSideIconText((boolean)true, (int)n4, (CharSequence)charSequence, (Drawable)ContextCompat.getDrawable((Context)context, (int)n)));
        }
        qMUIButton.setClickable(true);
        qMUIButton.setEnabled(this.mIsEnabled);
        n = this.mActionProp;
        if (n == 2) {
            qMUIButton.setTextColor(colorStateList);
        } else {
            if (n != 0) return qMUIButton;
            qMUIButton.setTextColor(colorStateList2);
        }
        return qMUIButton;
    }

    public QMUIButton buildActionView(QMUIDialog qMUIDialog, int n) {
        QMUIButton qMUIButton;
        this.mButton = qMUIButton = this.generateActionButton(qMUIDialog.getContext(), this.mStr, this.mIconRes);
        qMUIButton.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        return this.mButton;
    }

    public int getActionProp() {
        return this.mActionProp;
    }

    public void setEnabled(boolean bl) {
        this.mIsEnabled = bl;
        QMUIButton qMUIButton = this.mButton;
        if (qMUIButton == null) return;
        qMUIButton.setEnabled(bl);
    }

    public void setOnClickListener(ActionListener actionListener) {
        this.mOnClickListener = actionListener;
    }
}
