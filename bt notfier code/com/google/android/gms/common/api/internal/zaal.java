/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.internal.zaai
 *  com.google.android.gms.common.api.internal.zaaj
 *  com.google.android.gms.common.api.internal.zaak
 *  com.google.android.gms.common.api.internal.zaaq
 *  com.google.android.gms.common.api.internal.zaar
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabb
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.zal
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zaai;
import com.google.android.gms.common.api.internal.zaaj;
import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaaq;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabb;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.Map;

final class zaal
extends zaaq {
    final zaar zaa;
    private final Map<Api.Client, zaai> zac;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zaal(zaar zaar2, Map map) {
        this.zaa = zaar2;
        super(zaar2, null);
        this.zac = map;
    }

    public final void zaa() {
        int n;
        int n2;
        zal zal2 = new zal(zaar.zaj((zaar)this.zaa));
        Object object = new ArrayList();
        Api.Client client = new ArrayList();
        for (Api.Client client2 : this.zac.keySet()) {
            if (client2.requiresGooglePlayServices() && !zaai.zaa((zaai)this.zac.get(client2))) {
                object.add(client2);
                continue;
            }
            client.add(client2);
        }
        boolean bl = object.isEmpty();
        int n3 = -1;
        int n4 = 0;
        if (bl) {
            n2 = client.size();
            for (n = 0; n < n2; ++n) {
                object = (Api.Client)client.get(n);
                n4 = zal2.zaa(zaar.zai((zaar)this.zaa), (Api.Client)object);
                n3 = n4;
                if (n4 != 0) continue;
                n3 = n4;
                break;
            }
        } else {
            n2 = object.size();
            for (n = n4; n < n2; ++n) {
                client = (Api.Client)object.get(n);
                n4 = zal2.zaa(zaar.zai((zaar)this.zaa), client);
                n3 = n4;
                if (n4 == 0) continue;
                n3 = n4;
                break;
            }
        }
        if (n3 != 0) {
            zal2 = new ConnectionResult(n3, null);
            zaar.zal((zaar)this.zaa).zar((zabb)new zaaj(this, (zaba)this.zaa, (ConnectionResult)zal2));
            return;
        }
        if (zaar.zan((zaar)this.zaa) && zaar.zao((zaar)this.zaa) != null) {
            zaar.zao((zaar)this.zaa).zad();
        }
        object = this.zac.keySet().iterator();
        while (object.hasNext()) {
            Api.Client client2;
            client2 = (Api.Client)object.next();
            client = (BaseGmsClient.ConnectionProgressReportCallbacks)this.zac.get(client2);
            if (client2.requiresGooglePlayServices() && zal2.zaa(zaar.zai((zaar)this.zaa), client2) != 0) {
                zaar.zal((zaar)this.zaa).zar((zabb)new zaak(this, (zaba)this.zaa, (BaseGmsClient.ConnectionProgressReportCallbacks)client));
                continue;
            }
            client2.connect((BaseGmsClient.ConnectionProgressReportCallbacks)client);
        }
    }
}
