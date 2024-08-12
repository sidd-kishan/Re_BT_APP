/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zabl
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zabl;

final class zabh
implements Runnable {
    final zabl zaa;

    zabh(zabl zabl2) {
        this.zaa = zabl2;
    }

    @Override
    public final void run() {
        zabl.zay((zabl)this.zaa);
    }
}
