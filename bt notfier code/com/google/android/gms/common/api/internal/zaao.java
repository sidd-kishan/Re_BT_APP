/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zaan
 *  com.google.android.gms.common.api.internal.zaar
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabb
 *  com.google.android.gms.signin.internal.zac
 *  com.google.android.gms.signin.internal.zak
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaan;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabb;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

final class zaao
extends zac {
    private final WeakReference<zaar> zaa;

    zaao(zaar zaar2) {
        this.zaa = new WeakReference<zaar>(zaar2);
    }

    public final void zab(zak zak2) {
        zaar zaar2 = (zaar)this.zaa.get();
        if (zaar2 == null) {
            return;
        }
        zaar.zal((zaar)zaar2).zar((zabb)new zaan(this, (zaba)zaar2, zaar2, zak2));
    }
}
