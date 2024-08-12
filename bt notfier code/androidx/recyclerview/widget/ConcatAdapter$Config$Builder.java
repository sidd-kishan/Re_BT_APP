/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ConcatAdapter$Config
 *  androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ConcatAdapter;

public static final class ConcatAdapter.Config.Builder {
    private boolean mIsolateViewTypes;
    private ConcatAdapter.Config.StableIdMode mStableIdMode;

    public ConcatAdapter.Config.Builder() {
        this.mIsolateViewTypes = ConcatAdapter.Config.DEFAULT.isolateViewTypes;
        this.mStableIdMode = ConcatAdapter.Config.DEFAULT.stableIdMode;
    }

    public ConcatAdapter.Config build() {
        return new ConcatAdapter.Config(this.mIsolateViewTypes, this.mStableIdMode);
    }

    public ConcatAdapter.Config.Builder setIsolateViewTypes(boolean bl) {
        this.mIsolateViewTypes = bl;
        return this;
    }

    public ConcatAdapter.Config.Builder setStableIdMode(ConcatAdapter.Config.StableIdMode stableIdMode) {
        this.mStableIdMode = stableIdMode;
        return this;
    }
}
