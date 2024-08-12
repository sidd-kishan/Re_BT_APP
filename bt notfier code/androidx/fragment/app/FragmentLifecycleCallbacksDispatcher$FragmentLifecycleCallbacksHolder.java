/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;

private static final class FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder {
    final FragmentManager.FragmentLifecycleCallbacks mCallback;
    final boolean mRecursive;

    FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean bl) {
        this.mCallback = fragmentLifecycleCallbacks;
        this.mRecursive = bl;
    }
}
