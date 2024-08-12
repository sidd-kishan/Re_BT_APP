/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.arch.core.util.Function
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;

class Fragment.7
implements Function<Void, ActivityResultRegistry> {
    final Fragment this$0;
    final ActivityResultRegistry val$registry;

    Fragment.7(Fragment fragment, ActivityResultRegistry activityResultRegistry) {
        this.this$0 = fragment;
        this.val$registry = activityResultRegistry;
    }

    public ActivityResultRegistry apply(Void void_) {
        return this.val$registry;
    }
}
