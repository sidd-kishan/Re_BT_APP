/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentOnAttachListener
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

class FragmentManager.8
implements FragmentOnAttachListener {
    final FragmentManager this$0;
    final Fragment val$parent;

    FragmentManager.8(FragmentManager fragmentManager, Fragment fragment) {
        this.this$0 = fragmentManager;
        this.val$parent = fragment;
    }

    public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
        this.val$parent.onAttachFragment(fragment);
    }
}
