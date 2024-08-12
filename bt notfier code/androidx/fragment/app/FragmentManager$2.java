/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransition$Callback
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;

class FragmentManager.2
implements FragmentTransition.Callback {
    final FragmentManager this$0;

    FragmentManager.2(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public void onComplete(Fragment fragment, CancellationSignal cancellationSignal) {
        if (cancellationSignal.isCanceled()) return;
        this.this$0.removeCancellationSignal(fragment, cancellationSignal);
    }

    public void onStart(Fragment fragment, CancellationSignal cancellationSignal) {
        this.this$0.addCancellationSignal(fragment, cancellationSignal);
    }
}
