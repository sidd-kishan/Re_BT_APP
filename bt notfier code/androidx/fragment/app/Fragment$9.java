/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.core.app.ActivityOptionsCompat
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import java.util.concurrent.atomic.AtomicReference;

class Fragment.9
extends ActivityResultLauncher<I> {
    final Fragment this$0;
    final ActivityResultContract val$contract;
    final AtomicReference val$ref;

    Fragment.9(Fragment fragment, AtomicReference atomicReference, ActivityResultContract activityResultContract) {
        this.this$0 = fragment;
        this.val$ref = atomicReference;
        this.val$contract = activityResultContract;
    }

    public ActivityResultContract<I, ?> getContract() {
        return this.val$contract;
    }

    public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher)this.val$ref.get();
        if (activityResultLauncher == null) throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        activityResultLauncher.launch(i, activityOptionsCompat);
    }

    public void unregister() {
        ActivityResultLauncher activityResultLauncher = this.val$ref.getAndSet(null);
        if (activityResultLauncher == null) return;
        activityResultLauncher.unregister();
    }
}
