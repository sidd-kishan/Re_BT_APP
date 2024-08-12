/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  androidx.fragment.app.FragmentActivity
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.GoogleApiClient$Builder
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.internal.LifecycleActivity
 *  com.google.android.gms.common.api.internal.ListenerHolder
 *  com.google.android.gms.common.api.internal.ListenerHolders
 *  com.google.android.gms.common.api.internal.SignInConnectionListener
 *  com.google.android.gms.common.api.internal.StatusPendingResult
 *  com.google.android.gms.common.api.internal.zaat
 *  com.google.android.gms.common.api.internal.zaau
 *  com.google.android.gms.common.api.internal.zaav
 *  com.google.android.gms.common.api.internal.zaaw
 *  com.google.android.gms.common.api.internal.zaax
 *  com.google.android.gms.common.api.internal.zaay
 *  com.google.android.gms.common.api.internal.zabd
 *  com.google.android.gms.common.api.internal.zabq
 *  com.google.android.gms.common.api.internal.zabr
 *  com.google.android.gms.common.api.internal.zabt
 *  com.google.android.gms.common.api.internal.zabu
 *  com.google.android.gms.common.api.internal.zacv
 *  com.google.android.gms.common.api.internal.zacx
 *  com.google.android.gms.common.api.internal.zak
 *  com.google.android.gms.common.api.internal.zas
 *  com.google.android.gms.common.api.internal.zax
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.service.Common
 *  com.google.android.gms.common.internal.zaj
 *  com.google.android.gms.common.internal.zak
 *  com.google.android.gms.common.util.ClientLibraryUtils
 *  com.google.android.gms.signin.SignInOptions
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaat;
import com.google.android.gms.common.api.internal.zaau;
import com.google.android.gms.common.api.internal.zaav;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zaax;
import com.google.android.gms.common.api.internal.zaay;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.api.internal.zacx;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zas;
import com.google.android.gms.common.api.internal.zax;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zaaz
extends GoogleApiClient
implements zabt {
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zaa = new LinkedList();
    zabr zab;
    final Map<Api.AnyClientKey<?>, Api.Client> zac;
    Set<Scope> zad;
    final ClientSettings zae;
    final Map<Api<?>, Boolean> zaf;
    final Api.AbstractClientBuilder<? extends zae, SignInOptions> zag;
    Set<zacv> zah;
    final zacx zai;
    private final Lock zaj;
    private final com.google.android.gms.common.internal.zak zak;
    private zabu zal = null;
    private final int zam;
    private final Context zan;
    private final Looper zao;
    private volatile boolean zap;
    private long zaq;
    private long zar;
    private final zaax zas;
    private final GoogleApiAvailability zat;
    private final ListenerHolders zau;
    private final ArrayList<zas> zav;
    private Integer zaw;
    private final zaj zax;

    /*
     * WARNING - void declaration
     */
    public zaaz(Context context2, Lock iterator, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int n, int n2, ArrayList<zas> arrayList) {
        void var9_13;
        void var8_12;
        void var13_17;
        void var10_14;
        void var7_11;
        void var11_15;
        void var5_9;
        void var3_7;
        Iterator iterator2;
        long l = true != ClientLibraryUtils.isPackageSide() ? 120000L : 10000L;
        this.zaq = l;
        this.zar = 5000L;
        this.zad = new HashSet<Scope>();
        this.zau = new ListenerHolders();
        this.zaw = null;
        this.zah = null;
        zaat zaat2 = new zaat(this);
        this.zax = zaat2;
        this.zan = context2;
        this.zaj = iterator2;
        this.zak = new com.google.android.gms.common.internal.zak((Looper)var3_7, (zaj)zaat2);
        this.zao = var3_7;
        this.zas = new zaax(this, (Looper)var3_7);
        this.zat = var5_9;
        this.zam = var11_15;
        if (var11_15 >= 0) {
            void var12_16;
            this.zaw = (int)var12_16;
        }
        this.zaf = var7_11;
        this.zac = var10_14;
        this.zav = var13_17;
        this.zai = new zacx();
        for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : var8_12) {
            this.zak.zaf(connectionCallbacks);
        }
        iterator2 = var9_13.iterator();
        while (true) {
            if (!iterator2.hasNext()) {
                void var6_10;
                void var4_8;
                this.zae = var4_8;
                this.zag = var6_10;
                return;
            }
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)iterator2.next();
            this.zak.zai(onConnectionFailedListener);
        }
    }

    public static int zaf(Iterable<Api.Client> client, boolean bl) {
        Iterator<Api.Client> iterator = client.iterator();
        boolean bl2 = false;
        boolean bl3 = false;
        while (true) {
            if (!iterator.hasNext()) {
                if (!bl2) return 3;
                if (!bl3) return 1;
                if (!bl) return 1;
                return 2;
            }
            client = iterator.next();
            bl2 |= client.requiresSignIn();
            bl3 |= client.providesSignIn();
        }
    }

    static String zag(int n) {
        if (n == 1) return "SIGN_IN_MODE_REQUIRED";
        if (n == 2) return "SIGN_IN_MODE_OPTIONAL";
        if (n == 3) return "SIGN_IN_MODE_NONE";
        return "UNKNOWN";
    }

    static /* synthetic */ void zah(zaaz zaaz2) {
        zaaz2.zaj.lock();
        try {
            if (!zaaz2.zap) return;
            zaaz2.zan();
            return;
        }
        finally {
            zaaz2.zaj.unlock();
        }
    }

    static /* synthetic */ void zai(zaaz zaaz2) {
        zaaz2.zaj.lock();
        try {
            if (!zaaz2.zad()) return;
            zaaz2.zan();
            return;
        }
        finally {
            zaaz2.zaj.unlock();
        }
    }

    static /* synthetic */ void zaj(zaaz zaaz2, GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean bl) {
        zaaz2.zal(googleApiClient, statusPendingResult, true);
    }

    static /* synthetic */ Context zak(zaaz zaaz2) {
        return zaaz2.zan;
    }

    private final void zal(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean bl) {
        Common.zaa.zaa(googleApiClient).setResultCallback((ResultCallback)new zaaw(this, statusPendingResult, bl, googleApiClient));
    }

    private final void zam(int n) {
        Object object = this.zaw;
        if (object == null) {
            this.zaw = n;
        } else if ((Integer)object != n) {
            String string = zaaz.zag(n);
            object = zaaz.zag(this.zaw);
            StringBuilder stringBuilder = new StringBuilder(string.length() + 51 + ((String)object).length());
            stringBuilder.append("Cannot use sign-in mode: ");
            stringBuilder.append(string);
            stringBuilder.append(". Mode was already set to ");
            stringBuilder.append((String)object);
            object = new IllegalStateException(stringBuilder.toString());
            throw object;
        }
        if (this.zal != null) {
            return;
        }
        Iterator<Api.Client> iterator = this.zac.values().iterator();
        boolean bl = false;
        n = 0;
        while (iterator.hasNext()) {
            object = iterator.next();
            bl |= object.requiresSignIn();
            n |= object.providesSignIn();
        }
        int n2 = this.zaw;
        if (n2 != 1) {
            if (n2 == 2 && bl) {
                this.zal = com.google.android.gms.common.api.internal.zax.zaa((Context)this.zan, (zaaz)this, (Lock)this.zaj, (Looper)this.zao, (GoogleApiAvailabilityLight)this.zat, this.zac, (ClientSettings)this.zae, this.zaf, this.zag, this.zav);
                return;
            }
        } else {
            if (!bl) throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            if (n != 0) throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
        }
        this.zal = new zabd(this.zan, this, this.zaj, this.zao, (GoogleApiAvailabilityLight)this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav, (zabt)this);
    }

    private final void zan() {
        this.zak.zab();
        ((zabu)Preconditions.checkNotNull((Object)this.zal)).zae();
    }

    public final ConnectionResult blockingConnect() {
        Object object = Looper.myLooper();
        Looper looper = Looper.getMainLooper();
        boolean bl = true;
        boolean bl2 = object != looper;
        Preconditions.checkState((boolean)bl2, (Object)"blockingConnect must not be called on the UI thread");
        this.zaj.lock();
        try {
            block9: {
                block7: {
                    block8: {
                        block6: {
                            if (this.zam < 0) break block6;
                            bl2 = this.zaw != null ? bl : false;
                            Preconditions.checkState((boolean)bl2, (Object)"Sign-in mode should have been set explicitly by auto-manage.");
                            break block7;
                        }
                        object = this.zaw;
                        if (object != null) break block8;
                        this.zaw = zaaz.zaf(this.zac.values(), false);
                        break block7;
                    }
                    if ((Integer)object == 2) break block9;
                }
                this.zam((Integer)Preconditions.checkNotNull((Object)this.zaw));
                this.zak.zab();
                object = ((zabu)Preconditions.checkNotNull((Object)this.zal)).zaf();
                return object;
            }
            object = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            throw object;
        }
        finally {
            this.zaj.unlock();
        }
    }

    public final ConnectionResult blockingConnect(long l, TimeUnit object) {
        boolean bl = Looper.myLooper() != Looper.getMainLooper();
        Preconditions.checkState((boolean)bl, (Object)"blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull((Object)object, (Object)"TimeUnit must not be null");
        this.zaj.lock();
        try {
            block8: {
                block7: {
                    Integer n;
                    block6: {
                        n = this.zaw;
                        if (n != null) break block6;
                        this.zaw = zaaz.zaf(this.zac.values(), false);
                        break block7;
                    }
                    if (n == 2) break block8;
                }
                this.zam((Integer)Preconditions.checkNotNull((Object)this.zaw));
                this.zak.zab();
                object = ((zabu)Preconditions.checkNotNull((Object)this.zal)).zag(l, object);
                return object;
            }
            object = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            throw object;
        }
        finally {
            this.zaj.unlock();
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        boolean bl;
        Preconditions.checkState((boolean)this.isConnected(), (Object)"GoogleApiClient is not connected yet.");
        Serializable serializable = this.zaw;
        boolean bl2 = bl = true;
        if (serializable != null) {
            bl2 = (Integer)serializable != 2 ? bl : false;
        }
        Preconditions.checkState((boolean)bl2, (Object)"Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient)this);
        if (this.zac.containsKey(Common.CLIENT_KEY)) {
            this.zal(this, statusPendingResult, false);
        } else {
            serializable = new AtomicReference();
            zaau zaau2 = new zaau(this, (AtomicReference)serializable, statusPendingResult);
            zaav zaav2 = new zaav(this, statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.zan);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)zaau2);
            builder.addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)zaav2);
            builder.setHandler((Handler)this.zas);
            zaau2 = builder.build();
            ((AtomicReference)serializable).set(zaau2);
            zaau2.connect();
        }
        return statusPendingResult;
    }

    /*
     * Unable to fully structure code
     */
    public final void connect() {
        block13: {
            this.zaj.lock();
            var1_1 = this.zam;
            var2_2 = 2;
            var4_3 = false;
            if (var1_1 >= 0) {
                var3_4 = this.zaw != null;
                Preconditions.checkState((boolean)var3_4, (Object)"Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                var5_5 = this.zaw;
                if (var5_5 == null) {
                    this.zaw = zaaz.zaf(this.zac.values(), false);
                } else if (var5_5.intValue() == 2) break block13;
            }
            var1_1 = (Integer)Preconditions.checkNotNull((Object)this.zaw);
            this.zaj.lock();
            if (var1_1 == 3 || var1_1 == 1) ** GOTO lbl22
            if (var1_1 != 2) {
                var3_4 = var4_3;
            } else {
                var1_1 = var2_2;
lbl22:
                // 2 sources

                var3_4 = true;
            }
            {
                catch (Throwable var5_7) {
                    this.zaj.unlock();
                    throw var5_7;
                }
            }
            var5_5 = new StringBuilder(33);
            var5_5.append("Illegal sign-in mode: ");
            var5_5.append(var1_1);
            Preconditions.checkArgument((boolean)var3_4, (Object)var5_5.toString());
            this.zam(var1_1);
            this.zan();
            this.zaj.unlock();
            return;
        }
        var5_5 = new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
        throw var5_5;
        finally {
            ** try [egrp 2[TRYBLOCK] [8 : 187->196)] { 
lbl43:
            // 1 sources

            this.zaj.unlock();
        }
    }

    public final void connect(int n) {
        boolean bl;
        this.zaj.lock();
        boolean bl2 = bl = true;
        int n2 = n;
        if (n != 3) {
            bl2 = bl;
            n2 = n;
            if (n != 1) {
                if (n == 2) {
                    n2 = 2;
                    bl2 = bl;
                } else {
                    bl2 = false;
                    n2 = n;
                }
            }
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(33);
            stringBuilder.append("Illegal sign-in mode: ");
            stringBuilder.append(n2);
            Preconditions.checkArgument((boolean)bl2, (Object)stringBuilder.toString());
            this.zam(n2);
            this.zan();
            return;
        }
        finally {
            this.zaj.unlock();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void disconnect() {
        this.zaj.lock();
        try {
            this.zai.zab();
            Object object = this.zal;
            if (object != null) {
                object.zah();
            }
            this.zau.zab();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.zaa) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            this.zaa.clear();
            object = this.zal;
            if (object == null) {
                object = this.zaj;
            } else {
                this.zad();
                this.zak.zaa();
                object = this.zaj;
            }
            object.unlock();
            return;
        }
        catch (Throwable throwable) {
            this.zaj.unlock();
            throw throwable;
        }
    }

    public final void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        printWriter.append(string).append("mContext=").println(this.zan);
        printWriter.append(string).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        zacx zacx2 = this.zai;
        printWriter.append(" mUnconsumedApiCalls.size()=").println(zacx2.zab.size());
        zacx2 = this.zal;
        if (zacx2 == null) return;
        zacx2.zan(string, fileDescriptor, printWriter, stringArray);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T object) {
        void var3_9;
        void var3_6;
        Api api = object.getApi();
        boolean bl = this.zac.containsKey(object.getClientKey());
        if (api != null) {
            String string = api.zad();
        } else {
            String string = "the API";
        }
        Object object2 = new StringBuilder(String.valueOf(var3_6).length() + 65);
        ((StringBuilder)object2).append("GoogleApiClient is not configured to use ");
        ((StringBuilder)object2).append((String)var3_6);
        ((StringBuilder)object2).append(" required for this call.");
        Preconditions.checkArgument((boolean)bl, (Object)((StringBuilder)object2).toString());
        this.zaj.lock();
        try {
            zabu zabu2 = this.zal;
            if (zabu2 == null) {
                this.zaa.add((BaseImplementation.ApiMethodImpl<?, ?>)object);
                object2 = this.zaj;
                Object object3 = object;
                object = object2;
            } else {
                BaseImplementation.ApiMethodImpl apiMethodImpl = zabu2.zab((BaseImplementation.ApiMethodImpl)object);
                object = this.zaj;
            }
            object.unlock();
        }
        catch (Throwable throwable) {
            this.zaj.unlock();
            throw throwable;
        }
        return var3_9;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T object) {
        block9: {
            void var3_11;
            void var3_6;
            Api api = object.getApi();
            boolean bl = this.zac.containsKey(object.getClientKey());
            if (api != null) {
                String string = api.zad();
            } else {
                String string = "the API";
            }
            Object object2 = new StringBuilder(String.valueOf(var3_6).length() + 65);
            ((StringBuilder)object2).append("GoogleApiClient is not configured to use ");
            ((StringBuilder)object2).append((String)var3_6);
            ((StringBuilder)object2).append(" required for this call.");
            Preconditions.checkArgument((boolean)bl, (Object)((StringBuilder)object2).toString());
            this.zaj.lock();
            try {
                zabu zabu2 = this.zal;
                if (zabu2 == null) break block9;
                if (this.zap) {
                    this.zaa.add((BaseImplementation.ApiMethodImpl<?, ?>)object);
                    while (!this.zaa.isEmpty()) {
                        BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl = this.zaa.remove();
                        this.zai.zaa(apiMethodImpl);
                        apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                    object2 = this.zaj;
                    Object object3 = object;
                    object = object2;
                } else {
                    BaseImplementation.ApiMethodImpl apiMethodImpl = zabu2.zac((BaseImplementation.ApiMethodImpl)object);
                    object = this.zaj;
                }
                object.unlock();
            }
            catch (Throwable throwable) {
                this.zaj.unlock();
                throw throwable;
            }
            return var3_11;
        }
        object = new IllegalStateException("GoogleApiClient is not connected yet.");
        throw object;
    }

    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> client) {
        client = this.zac.get(client);
        Preconditions.checkNotNull((Object)client, (Object)"Appropriate Api was not requested.");
        return (C)client;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final ConnectionResult getConnectionResult(Api<?> object) {
        this.zaj.lock();
        try {
            if (!this.isConnected() && !this.zap) {
                object = new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                throw object;
            }
            if (this.zac.containsKey(object.zac())) {
                ConnectionResult connectionResult = ((zabu)Preconditions.checkNotNull((Object)this.zal)).zad((Api)object);
                if (connectionResult == null) {
                    void var2_5;
                    if (this.zap) {
                        ConnectionResult connectionResult2 = ConnectionResult.RESULT_SUCCESS;
                        object = this.zaj;
                    } else {
                        Log.w((String)"GoogleApiClientImpl", (String)this.zae());
                        object = String.valueOf(object.zad()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map");
                        Exception exception = new Exception();
                        Log.wtf((String)"GoogleApiClientImpl", (String)object, (Throwable)exception);
                        ConnectionResult connectionResult3 = new ConnectionResult(8, null);
                        object = this.zaj;
                    }
                    object.unlock();
                    return var2_5;
                }
                this.zaj.unlock();
                return connectionResult;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(object.zad()).concat(" was never registered with GoogleApiClient"));
            throw illegalArgumentException;
        }
        catch (Throwable throwable) {
            this.zaj.unlock();
            throw throwable;
        }
    }

    public final Context getContext() {
        return this.zan;
    }

    public final Looper getLooper() {
        return this.zao;
    }

    public final boolean hasApi(Api<?> api) {
        return this.zac.containsKey(api.zac());
    }

    public final boolean hasConnectedApi(Api<?> client) {
        if (!this.isConnected()) {
            return false;
        }
        if ((client = this.zac.get(client.zac())) == null) return false;
        if (!client.isConnected()) return false;
        return true;
    }

    public final boolean isConnected() {
        zabu zabu2 = this.zal;
        if (zabu2 == null) return false;
        if (!zabu2.zai()) return false;
        return true;
    }

    public final boolean isConnecting() {
        zabu zabu2 = this.zal;
        if (zabu2 == null) return false;
        if (!zabu2.zaj()) return false;
        return true;
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zak.zag(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zak.zaj(onConnectionFailedListener);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zabu zabu2 = this.zal;
        if (zabu2 == null) return false;
        if (!zabu2.zak(signInConnectionListener)) return false;
        return true;
    }

    public final void maybeSignOut() {
        zabu zabu2 = this.zal;
        if (zabu2 == null) return;
        zabu2.zam();
    }

    public final void reconnect() {
        this.disconnect();
        this.connect();
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zaf(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zai(onConnectionFailedListener);
    }

    public final <L> ListenerHolder<L> registerListener(L object) {
        this.zaj.lock();
        try {
            object = this.zau.zaa(object, this.zao, "NO_TYPE");
            return object;
        }
        finally {
            this.zaj.unlock();
        }
    }

    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        fragmentActivity = new LifecycleActivity((Activity)fragmentActivity);
        if (this.zam < 0) throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        com.google.android.gms.common.api.internal.zak.zaa((LifecycleActivity)fragmentActivity).zac(this.zam);
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zah(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zak(onConnectionFailedListener);
    }

    public final void zaa(Bundle bundle) {
        while (true) {
            if (this.zaa.isEmpty()) {
                this.zak.zac(bundle);
                return;
            }
            this.execute(this.zaa.remove());
        }
    }

    public final void zab(ConnectionResult connectionResult) {
        if (!this.zat.isPlayServicesPossiblyUpdating(this.zan, connectionResult.getErrorCode())) {
            this.zad();
        }
        if (this.zap) return;
        this.zak.zae(connectionResult);
        this.zak.zaa();
    }

    public final void zac(int n, boolean bl) {
        zaax zaax2;
        int n2 = n;
        if (n == 1) {
            if (!bl && !this.zap) {
                this.zap = true;
                if (this.zab == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        GoogleApiAvailability googleApiAvailability = this.zat;
                        zaax2 = this.zan.getApplicationContext();
                        zaay zaay2 = new zaay(this);
                        this.zab = googleApiAvailability.zae((Context)zaax2, (zabq)zaay2);
                    }
                    catch (SecurityException securityException) {}
                }
                zaax2 = this.zas;
                zaax2.sendMessageDelayed(zaax2.obtainMessage(1), this.zaq);
                zaax2 = this.zas;
                zaax2.sendMessageDelayed(zaax2.obtainMessage(2), this.zar);
            }
            n2 = 1;
        }
        zaax2 = this.zai.zab;
        n = 0;
        zaax2 = zaax2.toArray(new BasePendingResult[0]);
        int n3 = ((zaax)zaax2).length;
        while (true) {
            if (n >= n3) {
                this.zak.zad(n2);
                this.zak.zaa();
                if (n2 != 2) return;
                this.zan();
                return;
            }
            zaax2[n].forceFailureUnlessReady(zacx.zaa);
            ++n;
        }
    }

    final boolean zad() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        this.zas.removeMessages(2);
        this.zas.removeMessages(1);
        zabr zabr2 = this.zab;
        if (zabr2 == null) return true;
        zabr2.zab();
        this.zab = null;
        return true;
    }

    final String zae() {
        StringWriter stringWriter = new StringWriter();
        this.dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public final void zao(zacv zacv2) {
        this.zaj.lock();
        try {
            if (this.zah == null) {
                HashSet<zacv> hashSet = new HashSet<zacv>();
                this.zah = hashSet;
            }
            this.zah.add(zacv2);
            return;
        }
        finally {
            this.zaj.unlock();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final void zap(zacv var1_1) {
        block12: {
            block11: {
                this.zaj.lock();
                var3_4 = this.zah;
                if (var3_4 != null) break block11;
                var1_1 = new Exception();
                Log.wtf((String)"GoogleApiClientImpl", (String)"Attempted to remove pending transform when no transforms are registered.", (Throwable)var1_1);
                ** GOTO lbl34
            }
            if (var3_4.remove(var1_1)) break block12;
            var1_1 = new Exception();
            Log.wtf((String)"GoogleApiClientImpl", (String)"Failed to remove pending transform - this may lead to memory leaks!", (Throwable)var1_1);
            ** GOTO lbl34
        }
        this.zaj.lock();
        {
            block10: {
                catch (Throwable var1_3) {
                    throw var1_3;
                }
                var1_1 = this.zah;
                if (var1_1 != null) break block10;
                ** try [egrp 2[TRYBLOCK] [5 : 90->102)] { 
lbl24:
                // 1 sources

                this.zaj.unlock();
                ** GOTO lbl31
            }
            try {
                var2_5 = var1_1.isEmpty();
                {
                    this.zaj.unlock();
                    if ((var2_5 ^ true) != false) return;
                }
lbl31:
                // 2 sources

                var1_1 = this.zal;
                if (var1_1 == null) return;
            }
            catch (Throwable var1_2) {}
            var1_1.zal();
lbl34:
            // 3 sources

            return;
            {
                this.zaj.unlock();
                throw var1_2;
            }
        }
lbl38:
        // 1 sources

        finally {
            this.zaj.unlock();
        }
    }
}
