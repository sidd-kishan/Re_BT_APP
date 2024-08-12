/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zabk
 *  com.google.android.gms.common.api.internal.zabl
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.common.api.internal.zabl;

final class zabj
implements Runnable {
    final zabk zaa;

    zabj(zabk zabk2) {
        this.zaa = zabk2;
    }

    @Override
    public final void run() {
        zabl.zaA((zabl)this.zaa.zaa).disconnect(String.valueOf(zabl.zaA((zabl)this.zaa.zaa).getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
