/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  androidx.fragment.app.DialogFragment
 */
package androidx.fragment.app;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

/*
 * Exception performing whole class analysis ignored.
 */
class DialogFragment.2
implements DialogInterface.OnCancelListener {
    final DialogFragment this$0;

    DialogFragment.2(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (DialogFragment.access$000((DialogFragment)this.this$0) == null) return;
        dialogInterface = this.this$0;
        dialogInterface.onCancel((DialogInterface)DialogFragment.access$000((DialogFragment)dialogInterface));
    }
}
