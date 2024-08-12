/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentFactory
 *  androidx.fragment.app.FragmentManager
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;

class FragmentManager.3
extends FragmentFactory {
    final FragmentManager this$0;

    FragmentManager.3(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public Fragment instantiate(ClassLoader classLoader, String string) {
        return this.this$0.getHost().instantiate(this.this$0.getHost().getContext(), string, null);
    }
}
