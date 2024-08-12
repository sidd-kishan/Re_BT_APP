/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabd
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabd;
import java.util.Collections;
import java.util.Iterator;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaas
implements zaba {
    @NotOnlyInitialized
    private final zabd zaa;

    public zaas(zabd zabd2) {
        this.zaa = zabd2;
    }

    public final void zaa() {
        Iterator iterator = this.zaa.zaa.values().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zaa.zag.zad = Collections.emptySet();
                return;
            }
            ((Api.Client)iterator.next()).disconnect();
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        this.zaa.zag.zaa.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean zad() {
        return true;
    }

    public final void zae() {
        this.zaa.zao();
    }

    public final void zaf(Bundle bundle) {
    }

    public final void zag(ConnectionResult connectionResult, Api<?> api, boolean bl) {
    }

    public final void zah(int n) {
    }
}
