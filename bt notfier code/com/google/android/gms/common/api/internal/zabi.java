/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zabl
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zabl;

final class zabi
implements Runnable {
    final int zaa;
    final zabl zab;

    zabi(zabl zabl2, int n) {
        this.zab = zabl2;
        this.zaa = n;
    }

    @Override
    public final void run() {
        zabl.zaz((zabl)this.zab, (int)this.zaa);
    }
}
