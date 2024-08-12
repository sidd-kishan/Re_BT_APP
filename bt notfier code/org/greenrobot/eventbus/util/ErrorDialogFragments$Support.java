/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  androidx.fragment.app.DialogFragment
 *  org.greenrobot.eventbus.util.ErrorDialogFragments
 */
package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import org.greenrobot.eventbus.util.ErrorDialogFragments;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ErrorDialogFragments.Support
extends DialogFragment
implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialogInterface, int n) {
        ErrorDialogFragments.handleOnClick((DialogInterface)dialogInterface, (int)n, (Activity)this.getActivity(), (Bundle)this.getArguments());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return ErrorDialogFragments.createDialog((Context)this.getActivity(), (Bundle)this.getArguments(), (DialogInterface.OnClickListener)this);
    }
}
