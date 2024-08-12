/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  androidx.fragment.app.DialogFragment
 */
package androidx.fragment.app;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

/*
 * Exception performing whole class analysis ignored.
 */
class DialogFragment.1
implements Runnable {
    final DialogFragment this$0;

    DialogFragment.1(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @Override
    public void run() {
        DialogFragment.access$100((DialogFragment)this.this$0).onDismiss((DialogInterface)DialogFragment.access$000((DialogFragment)this.this$0));
    }
}
