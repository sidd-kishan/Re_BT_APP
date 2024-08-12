/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  androidx.fragment.app.DialogFragment
 */
package androidx.fragment.app;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

/*
 * Exception performing whole class analysis ignored.
 */
class DialogFragment.3
implements DialogInterface.OnDismissListener {
    final DialogFragment this$0;

    DialogFragment.3(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (DialogFragment.access$000((DialogFragment)this.this$0) == null) return;
        dialogInterface = this.this$0;
        dialogInterface.onDismiss((DialogInterface)DialogFragment.access$000((DialogFragment)dialogInterface));
    }
}
