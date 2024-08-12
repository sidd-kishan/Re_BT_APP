/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;

static interface FragmentTransition.Callback {
    public void onComplete(Fragment var1, CancellationSignal var2);

    public void onStart(Fragment var1, CancellationSignal var2);
}
