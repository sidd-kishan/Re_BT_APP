/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 *  androidx.collection.ArrayMap
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.SignInConnectionListener
 *  com.google.android.gms.common.api.internal.zaaz
 *  com.google.android.gms.common.api.internal.zabd
 *  com.google.android.gms.common.api.internal.zabt
 *  com.google.android.gms.common.api.internal.zabu
 *  com.google.android.gms.common.api.internal.zas
 *  com.google.android.gms.common.api.internal.zau
 *  com.google.android.gms.common.api.internal.zav
 *  com.google.android.gms.common.api.internal.zaw
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.base.zap
 *  com.google.android.gms.signin.SignInOptions
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.api.internal.zas;
import com.google.android.gms.common.api.internal.zau;
import com.google.android.gms.common.api.internal.zav;
import com.google.android.gms.common.api.internal.zaw;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zax
implements zabu {
    private final Context zaa;
    private final zaaz zab;
    private final Looper zac;
    private final zabd zad;
    private final zabd zae;
    private final Map<Api.AnyClientKey<?>, zabd> zaf;
    private final Set<SignInConnectionListener> zag = Collections.newSetFromMap(new WeakHashMap());
    private final Api.Client zah;
    private Bundle zai;
    private ConnectionResult zaj = null;
    private ConnectionResult zak = null;
    private boolean zal = false;
    private final Lock zam;
    private int zan = 0;

    private zax(Context context, zaaz object, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zas> arrayList, ArrayList<zas> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.zaa = context;
        this.zab = object;
        this.zam = lock;
        this.zac = looper;
        this.zah = client;
        this.zad = new zabd(context, (zaaz)object, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, (zabt)new zav(this, null));
        this.zae = new zabd(context, this.zab, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, (zabt)new zaw(this, null));
        context = new ArrayMap();
        object = map2.keySet().iterator();
        while (object.hasNext()) {
            context.put((Object)((Api.AnyClientKey)object.next()), (Object)this.zad);
        }
        object = map.keySet().iterator();
        while (true) {
            if (!object.hasNext()) {
                this.zaf = Collections.unmodifiableMap(context);
                return;
            }
            context.put((Object)((Api.AnyClientKey)object.next()), (Object)this.zae);
        }
    }

    private final void zaA() {
        Iterator<SignInConnectionListener> iterator = this.zag.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zag.clear();
                return;
            }
            iterator.next().onComplete();
        }
    }

    private final boolean zaB() {
        ConnectionResult connectionResult = this.zak;
        if (connectionResult == null) return false;
        if (connectionResult.getErrorCode() != 4) return false;
        return true;
    }

    private final boolean zaC(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> anyClientKey) {
        anyClientKey = anyClientKey.getClientKey();
        anyClientKey = this.zaf.get(anyClientKey);
        Preconditions.checkNotNull((Object)anyClientKey, (Object)"GoogleApiClient is not configured to use the API required for this call.");
        return anyClientKey.equals(this.zae);
    }

    private final PendingIntent zaD() {
        if (this.zah != null) return PendingIntent.getActivity((Context)this.zaa, (int)System.identityHashCode(this.zab), (Intent)this.zah.getSignInIntent(), (int)0x8000000);
        return null;
    }

    private static boolean zaE(ConnectionResult connectionResult) {
        if (connectionResult == null) return false;
        if (!connectionResult.isSuccess()) return false;
        return true;
    }

    public static zax zaa(Context context, zaaz zaaz2, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> client, ClientSettings clientSettings, Map<Api<?>, Boolean> object, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zas> arrayList) {
        Api.Client client2;
        Api.AnyClientKey anyClientKey;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = client.entrySet().iterator();
        client = null;
        while (arrayMap3.hasNext()) {
            anyClientKey = arrayMap3.next();
            client2 = (Api.Client)anyClientKey.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey)anyClientKey.getKey(), client2);
                continue;
            }
            arrayMap2.put((Api.AnyClientKey)anyClientKey.getKey(), client2);
        }
        Preconditions.checkState((boolean)(arrayMap.isEmpty() ^ true), (Object)"CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        client2 = new ArrayMap();
        arrayMap3 = new ArrayMap();
        for (Api zas2 : object.keySet()) {
            anyClientKey = zas2.zac();
            if (arrayMap.containsKey(anyClientKey)) {
                client2.put(zas2, (Boolean)object.get(zas2));
                continue;
            }
            if (!arrayMap2.containsKey(anyClientKey)) throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            arrayMap3.put(zas2, (Boolean)object.get(zas2));
        }
        anyClientKey = new ArrayList();
        object = new ArrayList<zas>();
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            zas zas2 = (zas)arrayList.get(n2);
            if (client2.containsKey(zas2.zaa)) {
                anyClientKey.add(zas2);
            } else {
                if (!arrayMap3.containsKey(zas2.zaa)) throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                object.add(zas2);
            }
            ++n2;
        }
        return new zax(context, zaaz2, lock, looper, googleApiAvailabilityLight, (Map<Api.AnyClientKey<?>, Api.Client>)arrayMap, (Map<Api.AnyClientKey<?>, Api.Client>)arrayMap2, clientSettings, abstractClientBuilder, client, (ArrayList<zas>)anyClientKey, object, (Map<Api<?>, Boolean>)client2, (Map<Api<?>, Boolean>)arrayMap3);
    }

    static /* synthetic */ Lock zao(zax zax2) {
        return zax2.zam;
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ void zap(zax var0) {
        block6: {
            if (!zax.zaE(var0.zaj)) break block6;
            if (!zax.zaE(var0.zak) && !var0.zaB()) {
                var2_1 = var0.zak;
                if (var2_1 == null) return;
                if (var0.zan == 1) {
                    var0.zaA();
                    return;
                }
                var0.zaz(var2_1);
                var0.zad.zah();
                return;
            }
            var1_3 = var0.zan;
            if (var1_3 == 1) ** GOTO lbl18
            if (var1_3 != 2) {
                Log.wtf((String)"CompositeGAC", (String)"Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new AssertionError());
            } else {
                ((zaaz)Preconditions.checkNotNull((Object)var0.zab)).zaa(var0.zai);
lbl18:
                // 2 sources

                var0.zaA();
            }
            var0.zan = 0;
            return;
        }
        if (var0.zaj != null && zax.zaE(var0.zak)) {
            var0.zae.zah();
            var0.zaz((ConnectionResult)Preconditions.checkNotNull((Object)var0.zaj));
            return;
        }
        var2_2 = var0.zaj;
        if (var2_2 == null) return;
        var3_4 = var0.zak;
        if (var3_4 == null) return;
        if (var0.zae.zaf < var0.zad.zaf) {
            var2_2 = var3_4;
        }
        var0.zaz(var2_2);
    }

    static /* synthetic */ void zaq(zax zax2, Bundle bundle) {
        Bundle bundle2 = zax2.zai;
        if (bundle2 == null) {
            zax2.zai = bundle;
            return;
        }
        if (bundle == null) return;
        bundle2.putAll(bundle);
    }

    static /* synthetic */ ConnectionResult zar(zax zax2, ConnectionResult connectionResult) {
        zax2.zaj = connectionResult;
        return connectionResult;
    }

    static /* synthetic */ boolean zas(zax zax2) {
        return zax2.zal;
    }

    static /* synthetic */ ConnectionResult zat(zax zax2) {
        return zax2.zak;
    }

    static /* synthetic */ boolean zau(zax zax2, boolean bl) {
        zax2.zal = bl;
        return bl;
    }

    static /* synthetic */ void zav(zax zax2, int n, boolean bl) {
        zax2.zab.zac(n, bl);
        zax2.zak = null;
        zax2.zaj = null;
    }

    static /* synthetic */ zabd zaw(zax zax2) {
        return zax2.zae;
    }

    static /* synthetic */ ConnectionResult zax(zax zax2, ConnectionResult connectionResult) {
        zax2.zak = connectionResult;
        return connectionResult;
    }

    static /* synthetic */ zabd zay(zax zax2) {
        return zax2.zad;
    }

    /*
     * Unable to fully structure code
     */
    private final void zaz(ConnectionResult var1_1) {
        var2_2 = this.zan;
        if (var2_2 == 1) ** GOTO lbl8
        if (var2_2 != 2) {
            Log.wtf((String)"CompositeGAC", (String)"Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new Exception());
        } else {
            this.zab.zab(var1_1);
lbl8:
            // 2 sources

            this.zaA();
        }
        this.zan = 0;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        if (!this.zaC(t)) {
            this.zad.zab(t);
            return t;
        }
        if (this.zaB()) {
            t.setFailedResult(new Status(4, null, this.zaD()));
            return t;
        }
        this.zae.zab(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        if (!this.zaC(t)) return (T)this.zad.zac(t);
        if (!this.zaB()) return (T)this.zae.zac(t);
        t.setFailedResult(new Status(4, null, this.zaD()));
        return t;
    }

    public final ConnectionResult zad(Api<?> api) {
        if (!Objects.equal((Object)this.zaf.get(api.zac()), (Object)this.zae)) return this.zad.zad(api);
        if (!this.zaB()) return this.zae.zad(api);
        return new ConnectionResult(4, this.zaD());
    }

    public final void zae() {
        this.zan = 2;
        this.zal = false;
        this.zak = null;
        this.zaj = null;
        this.zad.zae();
        this.zae.zae();
    }

    public final ConnectionResult zaf() {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult zag(long l, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void zah() {
        this.zak = null;
        this.zaj = null;
        this.zan = 0;
        this.zad.zah();
        this.zae.zah();
        this.zaA();
    }

    public final boolean zai() {
        this.zam.lock();
        try {
            boolean bl;
            block4: {
                block5: {
                    boolean bl2;
                    boolean bl3 = this.zad.zai();
                    bl = bl2 = false;
                    if (!bl3) break block4;
                    if (this.zae.zai() || this.zaB()) break block5;
                    int n = this.zan;
                    bl = bl2;
                    if (n != 1) break block4;
                }
                bl = true;
            }
            this.zam.unlock();
            return bl;
        }
        catch (Throwable throwable) {
            this.zam.unlock();
            throw throwable;
        }
    }

    public final boolean zaj() {
        this.zam.lock();
        try {
            int n = this.zan;
            boolean bl = n == 2;
            this.zam.unlock();
            return bl;
        }
        catch (Throwable throwable) {
            this.zam.unlock();
            throw throwable;
        }
    }

    public final boolean zak(SignInConnectionListener signInConnectionListener) {
        this.zam.lock();
        try {
            if (!this.zaj()) {
                if (!this.zai()) return false;
            }
            if (this.zae.zai()) return false;
            this.zag.add(signInConnectionListener);
            if (this.zan == 0) {
                this.zan = 1;
            }
            this.zak = null;
            this.zae.zae();
            return true;
        }
        finally {
            this.zam.unlock();
        }
    }

    public final void zal() {
        this.zad.zal();
        this.zae.zal();
    }

    public final void zam() {
        this.zam.lock();
        try {
            ConnectionResult connectionResult;
            boolean bl = this.zaj();
            this.zae.zah();
            this.zak = connectionResult = new ConnectionResult(4);
            if (bl) {
                connectionResult = new zap(this.zac);
                zau zau2 = new zau(this);
                connectionResult.post((Runnable)zau2);
            } else {
                this.zaA();
            }
            return;
        }
        finally {
            this.zam.unlock();
        }
    }

    public final void zan(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        printWriter.append(string).append("authClient").println(":");
        this.zae.zan(String.valueOf(string).concat("  "), fileDescriptor, printWriter, stringArray);
        printWriter.append(string).append("anonClient").println(":");
        this.zad.zan(String.valueOf(string).concat("  "), fileDescriptor, printWriter, stringArray);
    }
}
