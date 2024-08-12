/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  androidx.appcompat.app.AppCompatDialog
 *  androidx.fragment.app.DialogFragment
 */
package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment
extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        return new AppCompatDialog(this.getContext(), this.getTheme());
    }

    public void setupDialog(Dialog dialog, int n) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog appCompatDialog = (AppCompatDialog)dialog;
            if (n != 1 && n != 2) {
                if (n != 3) return;
                dialog.getWindow().addFlags(24);
            }
            appCompatDialog.supportRequestWindowFeature(1);
        } else {
            super.setupDialog(dialog, n);
        }
    }
}
