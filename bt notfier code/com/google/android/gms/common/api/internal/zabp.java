/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.GoogleApi
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.zaad
 *  com.google.android.gms.common.api.internal.zacv
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.zaad;
import com.google.android.gms.common.api.internal.zacv;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabp<O extends Api.ApiOptions>
extends zaad {
    @NotOnlyInitialized
    private final GoogleApi<O> zaa;

    public zabp(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zaa = googleApi;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return (T)this.zaa.doRead(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        return (T)this.zaa.doWrite(t);
    }

    public final Context getContext() {
        return this.zaa.getApplicationContext();
    }

    public final Looper getLooper() {
        return this.zaa.getLooper();
    }

    public final void zao(zacv zacv2) {
    }

    public final void zap(zacv zacv2) {
    }
}
