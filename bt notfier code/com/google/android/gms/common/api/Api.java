/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.Api$BaseClientBuilder
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.Api$ClientKey
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;

public final class Api<O extends ApiOptions> {
    private final AbstractClientBuilder<?, O> zaa;
    private final ClientKey<?> zab;
    private final String zac;

    public <C extends Client> Api(String string, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        Preconditions.checkNotNull(abstractClientBuilder, (Object)"Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, (Object)"Cannot construct an Api with a null ClientKey");
        this.zac = string;
        this.zaa = abstractClientBuilder;
        this.zab = clientKey;
    }

    public final BaseClientBuilder<?, O> zaa() {
        return this.zaa;
    }

    public final AbstractClientBuilder<?, O> zab() {
        return this.zaa;
    }

    public final AnyClientKey<?> zac() {
        return this.zab;
    }

    public final String zad() {
        return this.zac;
    }
}
