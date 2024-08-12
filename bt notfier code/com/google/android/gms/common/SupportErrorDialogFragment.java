/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.os.Bundle
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.FragmentManager
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.Preconditions;

public class SupportErrorDialogFragment
extends DialogFragment {
    private Dialog zaa;
    private DialogInterface.OnCancelListener zab;
    private Dialog zac;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return SupportErrorDialogFragment.newInstance(dialog, null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        dialog = (Dialog)Preconditions.checkNotNull((Object)dialog, (Object)"Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        supportErrorDialogFragment.zaa = dialog;
        if (onCancelListener == null) return supportErrorDialogFragment;
        supportErrorDialogFragment.zab = onCancelListener;
        return supportErrorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener == null) return;
        onCancelListener.onCancel(dialogInterface);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.zaa;
        bundle = dialog;
        if (dialog != null) return bundle;
        this.setShowsDialog(false);
        if (this.zac == null) {
            this.zac = new AlertDialog.Builder((Context)this.getActivity()).create();
        }
        bundle = this.zac;
        return bundle;
    }

    public void show(FragmentManager fragmentManager, String string) {
        super.show(fragmentManager, string);
    }
}
