/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransition$Callback
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;

class FragmentTransition.3
implements Runnable {
    final FragmentTransition.Callback val$callback;
    final Fragment val$outFragment;
    final CancellationSignal val$signal;

    FragmentTransition.3(FragmentTransition.Callback callback, Fragment fragment, CancellationSignal cancellationSignal) {
        this.val$callback = callback;
        this.val$outFragment = fragment;
        this.val$signal = cancellationSignal;
    }

    @Override
    public void run() {
        this.val$callback.onComplete(this.val$outFragment, this.val$signal);
    }
}
