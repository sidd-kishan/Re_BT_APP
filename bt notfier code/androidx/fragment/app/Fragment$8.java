/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.arch.core.util.Function
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$OnPreAttachedListener
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.atomic.AtomicReference;

class Fragment.8
extends Fragment.OnPreAttachedListener {
    final Fragment this$0;
    final ActivityResultCallback val$callback;
    final ActivityResultContract val$contract;
    final AtomicReference val$ref;
    final Function val$registryProvider;

    Fragment.8(Fragment fragment, Function function, AtomicReference atomicReference, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        this.this$0 = fragment;
        this.val$registryProvider = function;
        this.val$ref = atomicReference;
        this.val$contract = activityResultContract;
        this.val$callback = activityResultCallback;
        super(null);
    }

    void onPreAttached() {
        String string = this.this$0.generateActivityResultKey();
        ActivityResultRegistry activityResultRegistry = (ActivityResultRegistry)this.val$registryProvider.apply(null);
        this.val$ref.set(activityResultRegistry.register(string, (LifecycleOwner)this.this$0, this.val$contract, this.val$callback));
    }
}
