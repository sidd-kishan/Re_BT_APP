/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.transition.FragmentTransitionSupport
 *  androidx.transition.Transition
 */
package androidx.transition;

import androidx.core.os.CancellationSignal;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;

class FragmentTransitionSupport.4
implements CancellationSignal.OnCancelListener {
    final FragmentTransitionSupport this$0;
    final Transition val$realTransition;

    FragmentTransitionSupport.4(FragmentTransitionSupport fragmentTransitionSupport, Transition transition) {
        this.this$0 = fragmentTransitionSupport;
        this.val$realTransition = transition;
    }

    public void onCancel() {
        this.val$realTransition.cancel();
    }
}
