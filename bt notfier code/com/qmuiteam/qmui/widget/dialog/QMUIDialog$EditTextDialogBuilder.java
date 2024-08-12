/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnDismissListener
 *  android.text.method.TransformationMethod
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$drawable
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MessageDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.method.TransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;

/*
 * Exception performing whole class analysis ignored.
 */
public static class QMUIDialog.EditTextDialogBuilder
extends QMUIDialogBuilder<QMUIDialog.EditTextDialogBuilder> {
    private CharSequence mDefaultText = null;
    protected EditText mEditText;
    private int mInputType = 1;
    protected RelativeLayout mMainLayout;
    protected String mPlaceholder;
    protected ImageView mRightImageView;
    protected TransformationMethod mTransformationMethod;

    public QMUIDialog.EditTextDialogBuilder(Context context) {
        super(context);
    }

    protected RelativeLayout.LayoutParams createEditTextLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(0, this.mRightImageView.getId());
        layoutParams.addRule(15, -1);
        return layoutParams;
    }

    protected RelativeLayout.LayoutParams createRightIconLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = QMUIDisplayHelper.dpToPx((int)5);
        return layoutParams;
    }

    @Deprecated
    public EditText getEditText() {
        return this.mEditText;
    }

    public ImageView getRightImageView() {
        return this.mRightImageView;
    }

    protected void onAfter(QMUIDialog qMUIDialog, LinearLayout linearLayout, Context context) {
        super.onAfter(qMUIDialog, linearLayout, context);
        linearLayout = (InputMethodManager)context.getSystemService("input_method");
        qMUIDialog.setOnDismissListener((DialogInterface.OnDismissListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mEditText.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, 300L);
    }

    protected void onCreateContent(QMUIDialog object, ViewGroup viewGroup, Context context) {
        object = new AppCompatEditText(context);
        this.mEditText = object;
        QMUIDialog.MessageDialogBuilder.assignMessageTvWithAttr((TextView)object, (boolean)this.hasTitle(), (int)R.attr.qmui_dialog_edit_content_style);
        this.mEditText.setFocusable(true);
        this.mEditText.setFocusableInTouchMode(true);
        this.mEditText.setImeOptions(2);
        this.mEditText.setId(R.id.qmui_dialog_edit_input);
        if (!QMUILangHelper.isNullOrEmpty((CharSequence)this.mDefaultText)) {
            this.mEditText.setText(this.mDefaultText);
        }
        object = new ImageView(context);
        this.mRightImageView = object;
        object.setId(R.id.qmui_dialog_edit_right_icon);
        this.mRightImageView.setVisibility(8);
        this.mMainLayout = new RelativeLayout(context);
        object = new LinearLayout.LayoutParams(-1, -2);
        object.topMargin = this.mEditText.getPaddingTop();
        object.leftMargin = this.mEditText.getPaddingLeft();
        object.rightMargin = this.mEditText.getPaddingRight();
        object.bottomMargin = this.mEditText.getPaddingBottom();
        this.mMainLayout.setBackgroundResource(R.drawable.qmui_edittext_bg_border_bottom);
        this.mMainLayout.setLayoutParams((ViewGroup.LayoutParams)object);
        object = this.mTransformationMethod;
        if (object != null) {
            this.mEditText.setTransformationMethod((TransformationMethod)object);
        } else {
            this.mEditText.setInputType(this.mInputType);
        }
        this.mEditText.setBackgroundResource(0);
        this.mEditText.setPadding(0, 0, 0, QMUIDisplayHelper.dpToPx((int)5));
        object = new RelativeLayout.LayoutParams(-1, -2);
        object.addRule(0, this.mRightImageView.getId());
        object.addRule(15, -1);
        object = this.mPlaceholder;
        if (object != null) {
            this.mEditText.setHint((CharSequence)object);
        }
        this.mMainLayout.addView((View)this.mEditText, (ViewGroup.LayoutParams)this.createEditTextLayoutParams());
        this.mMainLayout.addView((View)this.mRightImageView, (ViewGroup.LayoutParams)this.createRightIconLayoutParams());
        viewGroup.addView((View)this.mMainLayout);
    }

    public QMUIDialog.EditTextDialogBuilder setDefaultText(CharSequence charSequence) {
        this.mDefaultText = charSequence;
        return this;
    }

    public QMUIDialog.EditTextDialogBuilder setInputType(int n) {
        this.mInputType = n;
        return this;
    }

    public QMUIDialog.EditTextDialogBuilder setPlaceholder(int n) {
        return this.setPlaceholder(this.getBaseContext().getResources().getString(n));
    }

    public QMUIDialog.EditTextDialogBuilder setPlaceholder(String string) {
        this.mPlaceholder = string;
        return this;
    }

    public QMUIDialog.EditTextDialogBuilder setTransformationMethod(TransformationMethod transformationMethod) {
        this.mTransformationMethod = transformationMethod;
        return this;
    }
}
