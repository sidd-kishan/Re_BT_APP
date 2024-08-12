/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  androidx.appcompat.app.AppCompatDialogFragment
 *  com.google.android.material.bottomsheet.BottomSheetDialog
 */
package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetDialogFragment
extends AppCompatDialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(this.getContext(), this.getTheme());
    }
}
