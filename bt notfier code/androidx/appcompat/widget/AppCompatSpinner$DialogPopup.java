/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.widget.ListAdapter
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.widget.AppCompatSpinner
 *  androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
 */
package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSpinner;

class AppCompatSpinner.DialogPopup
implements AppCompatSpinner.SpinnerPopup,
DialogInterface.OnClickListener {
    private ListAdapter mListAdapter;
    AlertDialog mPopup;
    private CharSequence mPrompt;
    final AppCompatSpinner this$0;

    AppCompatSpinner.DialogPopup(AppCompatSpinner appCompatSpinner) {
        this.this$0 = appCompatSpinner;
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mPopup;
        if (alertDialog == null) return;
        alertDialog.dismiss();
        this.mPopup = null;
    }

    public Drawable getBackground() {
        return null;
    }

    public CharSequence getHintText() {
        return this.mPrompt;
    }

    public int getHorizontalOffset() {
        return 0;
    }

    public int getHorizontalOriginalOffset() {
        return 0;
    }

    public int getVerticalOffset() {
        return 0;
    }

    public boolean isShowing() {
        AlertDialog alertDialog = this.mPopup;
        boolean bl = alertDialog != null ? alertDialog.isShowing() : false;
        return bl;
    }

    public void onClick(DialogInterface dialogInterface, int n) {
        this.this$0.setSelection(n);
        if (this.this$0.getOnItemClickListener() != null) {
            this.this$0.performItemClick(null, n, this.mListAdapter.getItemId(n));
        }
        this.dismiss();
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.mListAdapter = listAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set popup background for MODE_DIALOG, ignoring");
    }

    public void setHorizontalOffset(int n) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    public void setHorizontalOriginalOffset(int n) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    public void setPromptText(CharSequence charSequence) {
        this.mPrompt = charSequence;
    }

    public void setVerticalOffset(int n) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    public void show(int n, int n2) {
        if (this.mListAdapter == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.getPopupContext());
        CharSequence charSequence = this.mPrompt;
        if (charSequence != null) {
            builder.setTitle(charSequence);
        }
        charSequence = builder.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), (DialogInterface.OnClickListener)this).create();
        this.mPopup = charSequence;
        charSequence = charSequence.getListView();
        if (Build.VERSION.SDK_INT >= 17) {
            charSequence.setTextDirection(n);
            charSequence.setTextAlignment(n2);
        }
        this.mPopup.show();
    }
}
