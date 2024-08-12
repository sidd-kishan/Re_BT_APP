/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ConcatAdapter;

public static final class ConcatAdapter.Config {
    public static final ConcatAdapter.Config DEFAULT = new ConcatAdapter.Config(true, StableIdMode.NO_STABLE_IDS);
    public final boolean isolateViewTypes;
    public final StableIdMode stableIdMode;

    ConcatAdapter.Config(boolean bl, StableIdMode stableIdMode) {
        this.isolateViewTypes = bl;
        this.stableIdMode = stableIdMode;
    }
}
