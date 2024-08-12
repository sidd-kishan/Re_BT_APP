/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

static final class FragmentTabHost.TabInfo {
    final Bundle args;
    final Class<?> clss;
    Fragment fragment;
    final String tag;

    FragmentTabHost.TabInfo(String string, Class<?> clazz, Bundle bundle) {
        this.tag = string;
        this.clss = clazz;
        this.args = bundle;
    }
}
