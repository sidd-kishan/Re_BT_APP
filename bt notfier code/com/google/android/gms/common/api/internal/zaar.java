/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.zaah
 *  com.google.android.gms.common.api.internal.zaai
 *  com.google.android.gms.common.api.internal.zaal
 *  com.google.android.gms.common.api.internal.zaam
 *  com.google.android.gms.common.api.internal.zaap
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabd
 *  com.google.android.gms.common.api.internal.zabe
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zab
 *  com.google.android.gms.common.internal.zav
 *  com.google.android.gms.signin.SignInOptions
 *  com.google.android.gms.signin.internal.zak
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.zaah;
import com.google.android.gms.common.api.internal.zaai;
import com.google.android.gms.common.api.internal.zaal;
import com.google.android.gms.common.api.internal.zaam;
import com.google.android.gms.common.api.internal.zaap;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zaar
implements zaba {
    private final zabd zaa;
    private final Lock zab;
    private final Context zac;
    private final GoogleApiAvailabilityLight zad;
    private ConnectionResult zae;
    private int zaf;
    private int zag = 0;
    private int zah;
    private final Bundle zai = new Bundle();
    private final Set<Api.AnyClientKey> zaj = new HashSet<Api.AnyClientKey>();
    private zae zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;
    private IAccountAccessor zao;
    private boolean zap;
    private boolean zaq;
    private final ClientSettings zar;
    private final Map<Api<?>, Boolean> zas;
    private final Api.AbstractClientBuilder<? extends zae, SignInOptions> zat;
    private final ArrayList<Future<?>> zau = new ArrayList();

    public zaar(zabd zabd2, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zabd2;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    private final void zaA() {
        if (this.zah != 0) {
            return;
        }
        if (this.zam) {
            if (!this.zan) return;
        }
        ArrayList<Api.Client> arrayList = new ArrayList<Api.Client>();
        this.zag = 1;
        this.zah = this.zaa.zaa.size();
        Iterator iterator = this.zaa.zaa.keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                if (arrayList.isEmpty()) return;
                this.zau.add(zabe.zaa().submit((Runnable)new zaam(this, arrayList)));
                return;
            }
            Api.AnyClientKey anyClientKey = (Api.AnyClientKey)iterator.next();
            if (this.zaa.zab.containsKey(anyClientKey)) {
                if (!this.zaz()) continue;
                this.zaB();
                continue;
            }
            arrayList.add((Api.Client)this.zaa.zaa.get(anyClientKey));
        }
    }

    private final void zaB() {
        this.zaa.zap();
        zabe.zaa().execute((Runnable)new zaah(this));
        Object object2 = this.zak;
        if (object2 != null) {
            if (this.zap) {
                object2.zab((IAccountAccessor)Preconditions.checkNotNull((Object)this.zao), this.zaq);
            }
            this.zaG(false);
        }
        for (Object object2 : this.zaa.zab.keySet()) {
            ((Api.Client)Preconditions.checkNotNull((Object)((Api.Client)this.zaa.zaa.get(object2)))).disconnect();
        }
        object2 = this.zai.isEmpty() ? null : this.zai;
        this.zaa.zah.zaa((Bundle)object2);
    }

    private final void zaC(ConnectionResult connectionResult, Api<?> api, boolean bl) {
        int n = api.zaa().getPriority();
        if (!(bl && !connectionResult.hasResolution() && this.zad.getErrorResolutionIntent(connectionResult.getErrorCode()) == null || this.zae != null && n >= this.zaf)) {
            this.zae = connectionResult;
            this.zaf = n;
        }
        this.zaa.zab.put(api.zac(), connectionResult);
    }

    private final void zaD() {
        this.zam = false;
        this.zaa.zag.zad = Collections.emptySet();
        Iterator<Api.AnyClientKey> iterator = this.zaj.iterator();
        while (iterator.hasNext()) {
            Api.AnyClientKey anyClientKey = iterator.next();
            if (this.zaa.zab.containsKey(anyClientKey)) continue;
            this.zaa.zab.put(anyClientKey, new ConnectionResult(17, null));
        }
    }

    private final boolean zaE(ConnectionResult connectionResult) {
        if (!this.zal) return false;
        if (connectionResult.hasResolution()) return false;
        return true;
    }

    private final void zaF(ConnectionResult connectionResult) {
        this.zaH();
        this.zaG(connectionResult.hasResolution() ^ true);
        this.zaa.zaq(connectionResult);
        this.zaa.zah.zab(connectionResult);
    }

    private final void zaG(boolean bl) {
        zae zae2 = this.zak;
        if (zae2 == null) return;
        if (zae2.isConnected() && bl) {
            zae2.zac();
        }
        zae2.disconnect();
        zae2 = (ClientSettings)Preconditions.checkNotNull((Object)this.zar);
        this.zao = null;
    }

    private final void zaH() {
        ArrayList<Future<?>> arrayList = this.zau;
        int n = arrayList.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zau.clear();
                return;
            }
            ((Future)arrayList.get(n2)).cancel(true);
            ++n2;
        }
    }

    private final boolean zaI(int n) {
        if (this.zag == n) return true;
        Log.w((String)"GACConnecting", (String)this.zaa.zag.zae());
        CharSequence charSequence = String.valueOf(this);
        CharSequence charSequence2 = new StringBuilder(String.valueOf(charSequence).length() + 23);
        ((StringBuilder)charSequence2).append("Unexpected callback in ");
        ((StringBuilder)charSequence2).append((String)charSequence);
        Log.w((String)"GACConnecting", (String)((StringBuilder)charSequence2).toString());
        int n2 = this.zah;
        charSequence = new StringBuilder(33);
        ((StringBuilder)charSequence).append("mRemainingConnections=");
        ((StringBuilder)charSequence).append(n2);
        Log.w((String)"GACConnecting", (String)((StringBuilder)charSequence).toString());
        charSequence2 = zaar.zaJ(this.zag);
        String string = zaar.zaJ(n);
        charSequence = new StringBuilder(((String)charSequence2).length() + 70 + string.length());
        ((StringBuilder)charSequence).append("GoogleApiClient connecting is in step ");
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(" but received callback for step ");
        ((StringBuilder)charSequence).append(string);
        Log.e((String)"GACConnecting", (String)((StringBuilder)charSequence).toString(), (Throwable)new Exception());
        this.zaF(new ConnectionResult(8, null));
        return false;
    }

    private static final String zaJ(int n) {
        if (n == 0) return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
        return "STEP_GETTING_REMOTE_SERVICE";
    }

    static /* synthetic */ Context zai(zaar zaar2) {
        return zaar2.zac;
    }

    static /* synthetic */ GoogleApiAvailabilityLight zaj(zaar zaar2) {
        return zaar2.zad;
    }

    static /* synthetic */ Lock zak(zaar zaar2) {
        return zaar2.zab;
    }

    static /* synthetic */ zabd zal(zaar zaar2) {
        return zaar2.zaa;
    }

    static /* synthetic */ void zam(zaar zaar2, ConnectionResult connectionResult) {
        zaar2.zaF(connectionResult);
    }

    static /* synthetic */ boolean zan(zaar zaar2) {
        return zaar2.zam;
    }

    static /* synthetic */ zae zao(zaar zaar2) {
        return zaar2.zak;
    }

    static /* synthetic */ Set zap(zaar object) {
        Object object2 = ((zaar)object).zar;
        if (object2 == null) {
            object = Collections.emptySet();
        } else {
            object2 = new HashSet(object2.getRequiredScopes());
            Map map = ((zaar)object).zar.zaa();
            for (Api api : map.keySet()) {
                if (((zaar)object).zaa.zab.containsKey(api.zac())) continue;
                object2.addAll(((zab)map.get((Object)api)).zaa);
            }
            object = object2;
        }
        return object;
    }

    static /* synthetic */ IAccountAccessor zaq(zaar zaar2) {
        return zaar2.zao;
    }

    static /* synthetic */ ClientSettings zar(zaar zaar2) {
        return zaar2.zar;
    }

    static /* synthetic */ boolean zas(zaar zaar2, ConnectionResult connectionResult) {
        return zaar2.zaE(connectionResult);
    }

    static /* synthetic */ void zat(zaar zaar2) {
        zaar2.zaD();
    }

    static /* synthetic */ void zau(zaar zaar2) {
        zaar2.zaA();
    }

    static /* synthetic */ boolean zav(zaar zaar2, int n) {
        return zaar2.zaI(0);
    }

    static /* synthetic */ void zaw(zaar zaar2, ConnectionResult connectionResult, Api api, boolean bl) {
        zaar2.zaC(connectionResult, api, bl);
    }

    static /* synthetic */ boolean zax(zaar zaar2) {
        return zaar2.zaz();
    }

    static /* synthetic */ void zay(zaar zaar2, zak zak2) {
        if (!zaar2.zaI(0)) {
            return;
        }
        Object object = zak2.zaa();
        if (object.isSuccess()) {
            object = (zav)Preconditions.checkNotNull((Object)zak2.zab());
            if (!(zak2 = object.zab()).isSuccess()) {
                String string = String.valueOf(zak2);
                object = new StringBuilder(String.valueOf(string).length() + 48);
                ((StringBuilder)object).append("Sign-in succeeded with resolve account failure: ");
                ((StringBuilder)object).append(string);
                Log.wtf((String)"GACConnecting", (String)((StringBuilder)object).toString(), (Throwable)new Exception());
                zaar2.zaF((ConnectionResult)zak2);
                return;
            }
            zaar2.zan = true;
            zaar2.zao = (IAccountAccessor)Preconditions.checkNotNull((Object)object.zaa());
            zaar2.zap = object.zac();
            zaar2.zaq = object.zad();
            zaar2.zaA();
            return;
        }
        if (zaar2.zaE((ConnectionResult)object)) {
            zaar2.zaD();
            zaar2.zaA();
            return;
        }
        zaar2.zaF((ConnectionResult)object);
    }

    private final boolean zaz() {
        int n;
        this.zah = n = this.zah - 1;
        if (n > 0) {
            return false;
        }
        if (n < 0) {
            Log.w((String)"GACConnecting", (String)this.zaa.zag.zae());
            Log.wtf((String)"GACConnecting", (String)"GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", (Throwable)new Exception());
            this.zaF(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult == null) return true;
        this.zaa.zaf = this.zaf;
        this.zaF(connectionResult);
        return false;
    }

    public final void zaa() {
        Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder;
        Context context;
        this.zaa.zab.clear();
        this.zam = false;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap<Api.AbstractClientBuilder<? extends zae, SignInOptions>, zaai> hashMap = new HashMap<Api.AbstractClientBuilder<? extends zae, SignInOptions>, zaai>();
        ClientSettings clientSettings = this.zas.keySet().iterator();
        boolean bl = false;
        while (clientSettings.hasNext()) {
            context = clientSettings.next();
            abstractClientBuilder = (Api.AbstractClientBuilder<? extends zae, SignInOptions>)Preconditions.checkNotNull((Object)((Api.Client)this.zaa.zaa.get(context.zac())));
            boolean bl2 = context.zaa().getPriority() == 1;
            bl |= bl2;
            boolean bl3 = this.zas.get(context);
            if (abstractClientBuilder.requiresSignIn()) {
                this.zam = true;
                if (bl3) {
                    this.zaj.add(context.zac());
                } else {
                    this.zal = false;
                }
            }
            hashMap.put(abstractClientBuilder, new zaai(this, (Api)context, bl3));
        }
        if (bl) {
            this.zam = false;
        }
        if (this.zam) {
            Preconditions.checkNotNull((Object)this.zar);
            Preconditions.checkNotNull(this.zat);
            this.zar.zae(Integer.valueOf(System.identityHashCode(this.zaa.zag)));
            zaap zaap2 = new zaap(this, null);
            abstractClientBuilder = this.zat;
            context = this.zac;
            Looper looper = this.zaa.zag.getLooper();
            clientSettings = this.zar;
            this.zak = abstractClientBuilder.buildClient(context, looper, clientSettings, (Object)clientSettings.zac(), (GoogleApiClient.ConnectionCallbacks)zaap2, (GoogleApiClient.OnConnectionFailedListener)zaap2);
        }
        this.zah = this.zaa.zaa.size();
        this.zau.add(zabe.zaa().submit((Runnable)new zaal(this, hashMap)));
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        this.zaa.zag.zaa.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean zad() {
        this.zaH();
        this.zaG(true);
        this.zaa.zaq(null);
        return true;
    }

    public final void zae() {
    }

    public final void zaf(Bundle bundle) {
        if (!this.zaI(1)) {
            return;
        }
        if (bundle != null) {
            this.zai.putAll(bundle);
        }
        if (!this.zaz()) return;
        this.zaB();
    }

    public final void zag(ConnectionResult connectionResult, Api<?> api, boolean bl) {
        if (!this.zaI(1)) {
            return;
        }
        this.zaC(connectionResult, api, bl);
        if (!this.zaz()) return;
        this.zaB();
    }

    public final void zah(int n) {
        this.zaF(new ConnectionResult(8, null));
    }
}
