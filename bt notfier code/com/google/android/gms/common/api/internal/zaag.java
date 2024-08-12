/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.zaae
 *  com.google.android.gms.common.api.internal.zaaf
 *  com.google.android.gms.common.api.internal.zaaz
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabb
 *  com.google.android.gms.common.api.internal.zabd
 *  com.google.android.gms.common.api.internal.zacv
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zaaf;
import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabb;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.internal.Preconditions;

public final class zaag
implements zaba {
    private final zabd zaa;
    private boolean zab = false;

    public zaag(zabd zabd2) {
        this.zaa = zabd2;
    }

    static /* synthetic */ zabd zaj(zaag zaag2) {
        return zaag2.zaa;
    }

    public final void zaa() {
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        this.zac(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        try {
            this.zaa.zag.zai.zaa(t);
            zaaz zaaz2 = this.zaa.zag;
            Api.AnyClientKey anyClientKey = t.getClientKey();
            zaaz2 = (Api.Client)zaaz2.zac.get(anyClientKey);
            Preconditions.checkNotNull((Object)zaaz2, (Object)"Appropriate Api was not requested.");
            if (!zaaz2.isConnected() && this.zaa.zab.containsKey(t.getClientKey())) {
                zaaz2 = new Status(17);
                t.setFailedResult((Status)zaaz2);
            } else {
                t.run((Api.AnyClient)zaaz2);
            }
        }
        catch (DeadObjectException deadObjectException) {
            this.zaa.zar((zabb)new zaae(this, (zaba)this));
        }
        return t;
    }

    public final boolean zad() {
        if (this.zab) {
            return false;
        }
        Object object = this.zaa.zag.zah;
        if (object != null && !object.isEmpty()) {
            this.zab = true;
            object = object.iterator();
            while (object.hasNext()) {
                ((zacv)object.next()).zab();
            }
            return false;
        }
        this.zaa.zaq(null);
        return true;
    }

    public final void zae() {
        if (!this.zab) return;
        this.zab = false;
        this.zaa.zar((zabb)new zaaf(this, (zaba)this));
    }

    public final void zaf(Bundle bundle) {
    }

    public final void zag(ConnectionResult connectionResult, Api<?> api, boolean bl) {
    }

    public final void zah(int n) {
        this.zaa.zaq(null);
        this.zaa.zah.zac(n, this.zab);
    }

    final void zai() {
        if (!this.zab) return;
        this.zab = false;
        this.zaa.zag.zai.zab();
        this.zad();
    }
}
