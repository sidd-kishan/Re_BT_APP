/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  android.os.Message
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.SignInConnectionListener
 *  com.google.android.gms.common.api.internal.zaag
 *  com.google.android.gms.common.api.internal.zaar
 *  com.google.android.gms.common.api.internal.zaas
 *  com.google.android.gms.common.api.internal.zaaz
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabb
 *  com.google.android.gms.common.api.internal.zabc
 *  com.google.android.gms.common.api.internal.zabt
 *  com.google.android.gms.common.api.internal.zabu
 *  com.google.android.gms.common.api.internal.zas
 *  com.google.android.gms.common.api.internal.zat
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.signin.SignInOptions
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaag;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.api.internal.zaas;
import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabb;
import com.google.android.gms.common.api.internal.zabc;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.api.internal.zas;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabd
implements zabu,
zat {
    final Map<Api.AnyClientKey<?>, Api.Client> zaa;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zab = new HashMap();
    final ClientSettings zac;
    final Map<Api<?>, Boolean> zad;
    final Api.AbstractClientBuilder<? extends zae, SignInOptions> zae;
    int zaf;
    final zaaz zag;
    final zabt zah;
    private final Lock zai;
    private final Condition zaj;
    private final Context zak;
    private final GoogleApiAvailabilityLight zal;
    private final zabc zam;
    @NotOnlyInitialized
    private volatile zaba zan;
    private ConnectionResult zao = null;

    public zabd(Context context, zaaz zaaz2, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zas> arrayList, zabt zabt2) {
        this.zak = context;
        this.zai = lock;
        this.zal = googleApiAvailabilityLight;
        this.zaa = map;
        this.zac = clientSettings;
        this.zad = map2;
        this.zae = abstractClientBuilder;
        this.zag = zaaz2;
        this.zah = zabt2;
        int n = arrayList.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zam = new zabc(this, looper);
                this.zaj = lock.newCondition();
                this.zan = new zaas(this);
                return;
            }
            ((zas)arrayList.get(n2)).zaa((zat)this);
            ++n2;
        }
    }

    static /* synthetic */ Lock zat(zabd zabd2) {
        return zabd2.zai;
    }

    static /* synthetic */ zaba zau(zabd zabd2) {
        return zabd2.zan;
    }

    public final void onConnected(Bundle bundle) {
        this.zai.lock();
        try {
            this.zan.zaf(bundle);
            return;
        }
        finally {
            this.zai.unlock();
        }
    }

    public final void onConnectionSuspended(int n) {
        this.zai.lock();
        try {
            this.zan.zah(n);
            return;
        }
        finally {
            this.zai.unlock();
        }
    }

    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean bl) {
        this.zai.lock();
        try {
            this.zan.zag(connectionResult, api, bl);
            return;
        }
        finally {
            this.zai.unlock();
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        t.zak();
        this.zan.zab(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        t.zak();
        return (T)this.zan.zac(t);
    }

    public final ConnectionResult zad(Api<?> anyClientKey) {
        if (!this.zaa.containsKey(anyClientKey = anyClientKey.zac())) return null;
        if (this.zaa.get(anyClientKey).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (!this.zab.containsKey(anyClientKey)) return null;
        return this.zab.get(anyClientKey);
    }

    public final void zae() {
        this.zan.zae();
    }

    public final ConnectionResult zaf() {
        this.zae();
        while (this.zan instanceof zaar) {
            try {
                this.zaj.await();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.zan instanceof zaag) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        if (connectionResult == null) return new ConnectionResult(13, null);
        return connectionResult;
    }

    /*
     * Unable to fully structure code
     */
    public final ConnectionResult zag(long var1_1, TimeUnit var3_2) {
        this.zae();
        var1_1 = var3_2.toNanos(var1_1);
        while (this.zan instanceof zaar) {
            if (var1_1 > 0L) ** GOTO lbl8
            try {
                this.zah();
                return new ConnectionResult(14, null);
lbl8:
                // 1 sources

                var1_1 = this.zaj.awaitNanos(var1_1);
            }
            catch (InterruptedException var3_3) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.zan instanceof zaag) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        var3_2 = this.zao;
        if (var3_2 == null) return new ConnectionResult(13, null);
        return var3_2;
    }

    public final void zah() {
        if (!this.zan.zad()) return;
        this.zab.clear();
    }

    public final boolean zai() {
        return this.zan instanceof zaag;
    }

    public final boolean zaj() {
        return this.zan instanceof zaar;
    }

    public final boolean zak(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void zal() {
        if (!(this.zan instanceof zaag)) return;
        ((zaag)this.zan).zai();
    }

    public final void zam() {
    }

    public final void zan(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        String string2 = String.valueOf(string).concat("  ");
        printWriter.append(string).append("mState=").println(this.zan);
        Iterator<Api<?>> iterator = this.zad.keySet().iterator();
        while (iterator.hasNext()) {
            Api<?> api = iterator.next();
            printWriter.append(string).append(api.zad()).println(":");
            ((Api.Client)Preconditions.checkNotNull((Object)this.zaa.get(api.zac()))).dump(string2, fileDescriptor, printWriter, stringArray);
        }
    }

    final void zao() {
        this.zai.lock();
        try {
            zaar zaar2 = new zaar(this, this.zac, this.zad, this.zal, this.zae, this.zai, this.zak);
            this.zan = zaar2;
            this.zan.zaa();
            this.zaj.signalAll();
            return;
        }
        finally {
            this.zai.unlock();
        }
    }

    final void zap() {
        this.zai.lock();
        try {
            this.zag.zad();
            zaag zaag2 = new zaag(this);
            this.zan = zaag2;
            this.zan.zaa();
            this.zaj.signalAll();
            return;
        }
        finally {
            this.zai.unlock();
        }
    }

    final void zaq(ConnectionResult connectionResult) {
        this.zai.lock();
        try {
            this.zao = connectionResult;
            connectionResult = new zaas(this);
            this.zan = connectionResult;
            this.zan.zaa();
            this.zaj.signalAll();
            return;
        }
        finally {
            this.zai.unlock();
        }
    }

    final void zar(zabb zabb2) {
        zabb2 = this.zam.obtainMessage(1, (Object)zabb2);
        this.zam.sendMessage((Message)zabb2);
    }

    final void zas(RuntimeException runtimeException) {
        runtimeException = this.zam.obtainMessage(2, (Object)runtimeException);
        this.zam.sendMessage((Message)runtimeException);
    }
}
