/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import android.view.View;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;

class FragmentAnim.1
implements CancellationSignal.OnCancelListener {
    final Fragment val$fragment;

    FragmentAnim.1(Fragment fragment) {
        this.val$fragment = fragment;
    }

    public void onCancel() {
        if (this.val$fragment.getAnimatingAway() != null) {
            View view = this.val$fragment.getAnimatingAway();
            this.val$fragment.setAnimatingAway(null);
            view.clearAnimation();
        }
        this.val$fragment.setAnimator(null);
    }
}
