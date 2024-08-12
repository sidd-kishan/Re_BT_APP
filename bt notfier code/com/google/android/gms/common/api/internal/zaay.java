/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zaaz
 *  com.google.android.gms.common.api.internal.zabq
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.common.api.internal.zabq;
import java.lang.ref.WeakReference;

final class zaay
extends zabq {
    private final WeakReference<zaaz> zaa;

    zaay(zaaz zaaz2) {
        this.zaa = new WeakReference<zaaz>(zaaz2);
    }

    public final void zaa() {
        zaaz zaaz2 = (zaaz)this.zaa.get();
        if (zaaz2 == null) {
            return;
        }
        zaaz.zah((zaaz)zaaz2);
    }
}
