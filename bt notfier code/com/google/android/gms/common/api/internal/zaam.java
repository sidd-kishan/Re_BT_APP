/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.internal.zaaq
 *  com.google.android.gms.common.api.internal.zaar
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zaaq;
import com.google.android.gms.common.api.internal.zaar;
import java.util.ArrayList;

final class zaam
extends zaaq {
    final zaar zaa;
    private final ArrayList<Api.Client> zac;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zaam(zaar zaar2, ArrayList arrayList) {
        this.zaa = zaar2;
        super(zaar2, null);
        this.zac = arrayList;
    }

    public final void zaa() {
        zaar.zal((zaar)this.zaa).zag.zad = zaar.zap((zaar)this.zaa);
        ArrayList<Api.Client> arrayList = this.zac;
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            ((Api.Client)arrayList.get(n2)).getRemoteService(zaar.zaq((zaar)this.zaa), zaar.zal((zaar)this.zaa).zag.zad);
            ++n2;
        }
    }
}
