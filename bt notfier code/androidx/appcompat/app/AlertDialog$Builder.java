/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnMultiChoiceClickListener
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.view.ContextThemeWrapper
 *  android.view.View
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ListAdapter
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertDialog
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;

/*
 * Exception performing whole class analysis ignored.
 */
public static class AlertDialog.Builder {
    private final AlertController.AlertParams P;
    private final int mTheme;

    public AlertDialog.Builder(Context context) {
        this(context, AlertDialog.resolveDialogTheme((Context)context, (int)0));
    }

    public AlertDialog.Builder(Context context, int n) {
        this.P = new AlertController.AlertParams((Context)new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme((Context)context, (int)n)));
        this.mTheme = n;
    }

    public AlertDialog create() {
        AlertDialog alertDialog = new AlertDialog(this.P.mContext, this.mTheme);
        this.P.apply(alertDialog.mAlert);
        alertDialog.setCancelable(this.P.mCancelable);
        if (this.P.mCancelable) {
            alertDialog.setCanceledOnTouchOutside(true);
        }
        alertDialog.setOnCancelListener(this.P.mOnCancelListener);
        alertDialog.setOnDismissListener(this.P.mOnDismissListener);
        if (this.P.mOnKeyListener == null) return alertDialog;
        alertDialog.setOnKeyListener(this.P.mOnKeyListener);
        return alertDialog;
    }

    public Context getContext() {
        return this.P.mContext;
    }

    public AlertDialog.Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.P.mAdapter = listAdapter;
        this.P.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setCancelable(boolean bl) {
        this.P.mCancelable = bl;
        return this;
    }

    public AlertDialog.Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String string) {
        this.P.mCursor = cursor;
        this.P.mLabelColumn = string;
        this.P.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setCustomTitle(View view) {
        this.P.mCustomTitleView = view;
        return this;
    }

    public AlertDialog.Builder setIcon(int n) {
        this.P.mIconId = n;
        return this;
    }

    public AlertDialog.Builder setIcon(Drawable drawable) {
        this.P.mIcon = drawable;
        return this;
    }

    public AlertDialog.Builder setIconAttribute(int n) {
        TypedValue typedValue = new TypedValue();
        this.P.mContext.getTheme().resolveAttribute(n, typedValue, true);
        this.P.mIconId = typedValue.resourceId;
        return this;
    }

    @Deprecated
    public AlertDialog.Builder setInverseBackgroundForced(boolean bl) {
        this.P.mForceInverseBackground = bl;
        return this;
    }

    public AlertDialog.Builder setItems(int n, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mItems = alertParams.mContext.getResources().getTextArray(n);
        this.P.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setItems(CharSequence[] charSequenceArray, DialogInterface.OnClickListener onClickListener) {
        this.P.mItems = charSequenceArray;
        this.P.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setMessage(int n) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mMessage = alertParams.mContext.getText(n);
        return this;
    }

    public AlertDialog.Builder setMessage(CharSequence charSequence) {
        this.P.mMessage = charSequence;
        return this;
    }

    public AlertDialog.Builder setMultiChoiceItems(int n, boolean[] blArray, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mItems = alertParams.mContext.getResources().getTextArray(n);
        this.P.mOnCheckboxClickListener = onMultiChoiceClickListener;
        this.P.mCheckedItems = blArray;
        this.P.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog.Builder setMultiChoiceItems(Cursor cursor, String string, String string2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.P.mCursor = cursor;
        this.P.mOnCheckboxClickListener = onMultiChoiceClickListener;
        this.P.mIsCheckedColumn = string;
        this.P.mLabelColumn = string2;
        this.P.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog.Builder setMultiChoiceItems(CharSequence[] charSequenceArray, boolean[] blArray, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.P.mItems = charSequenceArray;
        this.P.mOnCheckboxClickListener = onMultiChoiceClickListener;
        this.P.mCheckedItems = blArray;
        this.P.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog.Builder setNegativeButton(int n, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mNegativeButtonText = alertParams.mContext.getText(n);
        this.P.mNegativeButtonListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.P.mNegativeButtonText = charSequence;
        this.P.mNegativeButtonListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setNegativeButtonIcon(Drawable drawable) {
        this.P.mNegativeButtonIcon = drawable;
        return this;
    }

    public AlertDialog.Builder setNeutralButton(int n, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mNeutralButtonText = alertParams.mContext.getText(n);
        this.P.mNeutralButtonListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.P.mNeutralButtonText = charSequence;
        this.P.mNeutralButtonListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setNeutralButtonIcon(Drawable drawable) {
        this.P.mNeutralButtonIcon = drawable;
        return this;
    }

    public AlertDialog.Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.P.mOnCancelListener = onCancelListener;
        return this;
    }

    public AlertDialog.Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.P.mOnDismissListener = onDismissListener;
        return this;
    }

    public AlertDialog.Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.P.mOnItemSelectedListener = onItemSelectedListener;
        return this;
    }

    public AlertDialog.Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.P.mOnKeyListener = onKeyListener;
        return this;
    }

    public AlertDialog.Builder setPositiveButton(int n, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mPositiveButtonText = alertParams.mContext.getText(n);
        this.P.mPositiveButtonListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.P.mPositiveButtonText = charSequence;
        this.P.mPositiveButtonListener = onClickListener;
        return this;
    }

    public AlertDialog.Builder setPositiveButtonIcon(Drawable drawable) {
        this.P.mPositiveButtonIcon = drawable;
        return this;
    }

    public AlertDialog.Builder setRecycleOnMeasureEnabled(boolean bl) {
        this.P.mRecycleOnMeasure = bl;
        return this;
    }

    public AlertDialog.Builder setSingleChoiceItems(int n, int n2, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mItems = alertParams.mContext.getResources().getTextArray(n);
        this.P.mOnClickListener = onClickListener;
        this.P.mCheckedItem = n2;
        this.P.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog.Builder setSingleChoiceItems(Cursor cursor, int n, String string, DialogInterface.OnClickListener onClickListener) {
        this.P.mCursor = cursor;
        this.P.mOnClickListener = onClickListener;
        this.P.mCheckedItem = n;
        this.P.mLabelColumn = string;
        this.P.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog.Builder setSingleChoiceItems(ListAdapter listAdapter, int n, DialogInterface.OnClickListener onClickListener) {
        this.P.mAdapter = listAdapter;
        this.P.mOnClickListener = onClickListener;
        this.P.mCheckedItem = n;
        this.P.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog.Builder setSingleChoiceItems(CharSequence[] charSequenceArray, int n, DialogInterface.OnClickListener onClickListener) {
        this.P.mItems = charSequenceArray;
        this.P.mOnClickListener = onClickListener;
        this.P.mCheckedItem = n;
        this.P.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog.Builder setTitle(int n) {
        AlertController.AlertParams alertParams = this.P;
        alertParams.mTitle = alertParams.mContext.getText(n);
        return this;
    }

    public AlertDialog.Builder setTitle(CharSequence charSequence) {
        this.P.mTitle = charSequence;
        return this;
    }

    public AlertDialog.Builder setView(int n) {
        this.P.mView = null;
        this.P.mViewLayoutResId = n;
        this.P.mViewSpacingSpecified = false;
        return this;
    }

    public AlertDialog.Builder setView(View view) {
        this.P.mView = view;
        this.P.mViewLayoutResId = 0;
        this.P.mViewSpacingSpecified = false;
        return this;
    }

    @Deprecated
    public AlertDialog.Builder setView(View view, int n, int n2, int n3, int n4) {
        this.P.mView = view;
        this.P.mViewLayoutResId = 0;
        this.P.mViewSpacingSpecified = true;
        this.P.mViewSpacingLeft = n;
        this.P.mViewSpacingTop = n2;
        this.P.mViewSpacingRight = n3;
        this.P.mViewSpacingBottom = n4;
        return this;
    }

    public AlertDialog show() {
        AlertDialog alertDialog = this.create();
        alertDialog.show();
        return alertDialog;
    }
}
