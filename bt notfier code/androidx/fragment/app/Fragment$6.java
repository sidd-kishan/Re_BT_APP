/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.ActivityResultRegistryOwner
 *  androidx.arch.core.util.Function
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;

class Fragment.6
implements Function<Void, ActivityResultRegistry> {
    final Fragment this$0;

    Fragment.6(Fragment fragment) {
        this.this$0 = fragment;
    }

    public ActivityResultRegistry apply(Void void_) {
        if (!(this.this$0.mHost instanceof ActivityResultRegistryOwner)) return this.this$0.requireActivity().getActivityResultRegistry();
        return ((ActivityResultRegistryOwner)this.this$0.mHost).getActivityResultRegistry();
    }
}
