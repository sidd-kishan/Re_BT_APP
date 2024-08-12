/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 *  android.util.Log
 *  androidx.collection.ArrayMap
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.GoogleApi
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.UnsupportedApiCallException
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.api.internal.RegisterListenerMethod
 *  com.google.android.gms.common.api.internal.zaaa
 *  com.google.android.gms.common.api.internal.zabh
 *  com.google.android.gms.common.api.internal.zabi
 *  com.google.android.gms.common.api.internal.zabk
 *  com.google.android.gms.common.api.internal.zabm
 *  com.google.android.gms.common.api.internal.zabo
 *  com.google.android.gms.common.api.internal.zac
 *  com.google.android.gms.common.api.internal.zacc
 *  com.google.android.gms.common.api.internal.zacn
 *  com.google.android.gms.common.api.internal.zaco
 *  com.google.android.gms.common.api.internal.zah
 *  com.google.android.gms.common.api.internal.zai
 *  com.google.android.gms.common.api.internal.zal
 *  com.google.android.gms.common.api.internal.zat
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.service.zap
 *  com.google.android.gms.common.util.ArrayUtils
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.zaaa;
import com.google.android.gms.common.api.internal.zabh;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.common.api.internal.zabm;
import com.google.android.gms.common.api.internal.zabo;
import com.google.android.gms.common.api.internal.zac;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.api.internal.zacn;
import com.google.android.gms.common.api.internal.zaco;
import com.google.android.gms.common.api.internal.zah;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabl<O extends Api.ApiOptions>
implements GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener,
zat {
    final GoogleApiManager zaa;
    private final Queue<zai> zab;
    @NotOnlyInitialized
    private final Api.Client zac;
    private final ApiKey<O> zad;
    private final zaaa zae;
    private final Set<zal> zaf;
    private final Map<ListenerHolder.ListenerKey<?>, zacc> zag;
    private final int zah;
    private final zaco zai;
    private boolean zaj;
    private final List<zabm> zak;
    private ConnectionResult zal;
    private int zam;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zabl(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        this.zab = new LinkedList<zai>();
        this.zaf = new HashSet<zal>();
        this.zag = new HashMap();
        this.zak = new ArrayList<zabm>();
        this.zal = null;
        this.zam = 0;
        this.zac = googleApi.zaa(GoogleApiManager.zas((GoogleApiManager)googleApiManager).getLooper(), this);
        this.zad = googleApi.getApiKey();
        this.zae = new zaaa();
        this.zah = googleApi.zab();
        if (this.zac.requiresSignIn()) {
            this.zai = googleApi.zac(GoogleApiManager.zat((GoogleApiManager)googleApiManager), GoogleApiManager.zas((GoogleApiManager)googleApiManager));
            return;
        }
        this.zai = null;
    }

    static /* synthetic */ Api.Client zaA(zabl zabl2) {
        return zabl2.zac;
    }

    private final void zaB() {
        this.zah();
        this.zaM(ConnectionResult.RESULT_SUCCESS);
        this.zaJ();
        Iterator<zacc> iterator = this.zag.values().iterator();
        while (iterator.hasNext()) {
            zacc zacc2 = iterator.next();
            if (this.zaN(zacc2.zaa.getRequiredFeatures()) != null) {
                iterator.remove();
                continue;
            }
            try {
                RegisterListenerMethod registerListenerMethod = zacc2.zaa;
                zacc2 = this.zac;
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                registerListenerMethod.registerListener((Api.AnyClient)zacc2, taskCompletionSource);
            }
            catch (RemoteException remoteException) {
                iterator.remove();
            }
            catch (DeadObjectException deadObjectException) {
                this.onConnectionSuspended(3);
                this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                break;
            }
        }
        this.zaE();
        this.zaK();
    }

    private final void zaC(int n) {
        this.zah();
        this.zaj = true;
        this.zae.zae(n, this.zac.getLastDisconnectMessage());
        GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(Message.obtain((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa), (int)9, this.zad), GoogleApiManager.zau((GoogleApiManager)this.zaa));
        GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(Message.obtain((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa), (int)11, this.zad), GoogleApiManager.zav((GoogleApiManager)this.zaa));
        GoogleApiManager.zaw((GoogleApiManager)this.zaa).zac();
        Iterator<zacc> iterator = this.zag.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().zac.run();
        }
    }

    private final boolean zaD(ConnectionResult connectionResult) {
        Object object = GoogleApiManager.zax();
        synchronized (object) {
            if (GoogleApiManager.zay((GoogleApiManager)this.zaa) == null) return false;
            if (!GoogleApiManager.zaz((GoogleApiManager)this.zaa).contains(this.zad)) return false;
            GoogleApiManager.zay((GoogleApiManager)this.zaa).zaf(connectionResult, this.zah);
            return true;
        }
    }

    private final void zaE() {
        ArrayList<zai> arrayList = new ArrayList<zai>(this.zab);
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            zai zai2 = (zai)arrayList.get(n2);
            if (!this.zac.isConnected()) {
                return;
            }
            if (this.zaF(zai2)) {
                this.zab.remove(zai2);
            }
            ++n2;
        }
    }

    private final boolean zaF(zai object) {
        if (!(object instanceof zac)) {
            this.zaG((zai)object);
            return true;
        }
        zac zac2 = (zac)object;
        Feature feature = this.zaN(zac2.zaa(this));
        if (feature == null) {
            this.zaG((zai)object);
            return true;
        }
        String string = this.zac.getClass().getName();
        String string2 = feature.getName();
        long l = feature.getVersion();
        object = new StringBuilder(String.valueOf(string).length() + 77 + String.valueOf(string2).length());
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" could not execute call because it requires feature (");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(").");
        Log.w((String)"GoogleApiManager", (String)((StringBuilder)object).toString());
        if (GoogleApiManager.zaC((GoogleApiManager)this.zaa) && zac2.zab(this)) {
            object = new zabm(this.zad, feature, null);
            int n = this.zak.indexOf(object);
            if (n >= 0) {
                object = this.zak.get(n);
                GoogleApiManager.zas((GoogleApiManager)this.zaa).removeMessages(15, object);
                GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(Message.obtain((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa), (int)15, (Object)object), GoogleApiManager.zau((GoogleApiManager)this.zaa));
            } else {
                this.zak.add((zabm)object);
                GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(Message.obtain((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa), (int)15, (Object)object), GoogleApiManager.zau((GoogleApiManager)this.zaa));
                GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(Message.obtain((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa), (int)16, (Object)object), GoogleApiManager.zav((GoogleApiManager)this.zaa));
                object = new ConnectionResult(2, null);
                if (this.zaD((ConnectionResult)object)) return false;
                this.zaa.zap((ConnectionResult)object, this.zah);
            }
            return false;
        }
        zac2.zad((Exception)new UnsupportedApiCallException(feature));
        return true;
    }

    private final void zaG(zai zai2) {
        zai2.zae(this.zae, this.zap());
        try {
            zai2.zaf(this);
            return;
        }
        catch (Throwable throwable) {
            throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.zac.getClass().getName()), throwable);
        }
        catch (DeadObjectException deadObjectException) {
            this.onConnectionSuspended(1);
            this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            return;
        }
    }

    private final void zaH(Status object, Exception exception, boolean bl) {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        boolean bl2 = false;
        boolean bl3 = object == null;
        if (exception == null) {
            bl2 = true;
        }
        if (bl3 == bl2) {
            object = new IllegalArgumentException("Status XOR exception should be null");
            throw object;
        }
        Iterator iterator = this.zab.iterator();
        while (iterator.hasNext()) {
            zai zai2 = (zai)iterator.next();
            if (bl && zai2.zac != 2) continue;
            if (object != null) {
                zai2.zac(object);
            } else {
                zai2.zad(exception);
            }
            iterator.remove();
        }
    }

    private final void zaI(Status status) {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        this.zaH(status, null, false);
    }

    private final void zaJ() {
        if (!this.zaj) return;
        GoogleApiManager.zas((GoogleApiManager)this.zaa).removeMessages(11, this.zad);
        GoogleApiManager.zas((GoogleApiManager)this.zaa).removeMessages(9, this.zad);
        this.zaj = false;
    }

    private final void zaK() {
        GoogleApiManager.zas((GoogleApiManager)this.zaa).removeMessages(12, this.zad);
        GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(GoogleApiManager.zas((GoogleApiManager)this.zaa).obtainMessage(12, this.zad), GoogleApiManager.zaE((GoogleApiManager)this.zaa));
    }

    private final boolean zaL(boolean bl) {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        if (!this.zac.isConnected()) return false;
        if (this.zag.size() != 0) return false;
        if (this.zae.zac()) {
            if (!bl) return false;
            this.zaK();
            return false;
        }
        this.zac.disconnect("Timing out service connection.");
        return true;
    }

    private final void zaM(ConnectionResult connectionResult) {
        Iterator<zal> iterator = this.zaf.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zaf.clear();
                return;
            }
            zal zal2 = iterator.next();
            String string = Objects.equal((Object)connectionResult, (Object)ConnectionResult.RESULT_SUCCESS) ? this.zac.getEndpointPackageName() : null;
            zal2.zac(this.zad, connectionResult, string);
        }
    }

    private final Feature zaN(Feature[] featureArray) {
        ArrayMap arrayMap;
        int n;
        if (featureArray == null) return null;
        if (featureArray.length == 0) {
            return null;
        }
        ArrayMap arrayMap2 = this.zac.getAvailableFeatures();
        int n2 = 0;
        Object object = arrayMap2;
        if (arrayMap2 == null) {
            object = new Feature[]{};
        }
        int n3 = ((Feature[])object).length;
        arrayMap2 = new ArrayMap(n3);
        for (n = 0; n < n3; ++n) {
            arrayMap = object[n];
            arrayMap2.put(arrayMap.getName(), arrayMap.getVersion());
        }
        n3 = featureArray.length;
        n = n2;
        while (n < n3) {
            arrayMap = featureArray[n];
            object = (Long)arrayMap2.get(arrayMap.getName());
            if (object == null) return arrayMap;
            if ((Long)object < arrayMap.getVersion()) {
                return arrayMap;
            }
            ++n;
        }
        return null;
    }

    static /* synthetic */ boolean zat(zabl zabl2, boolean bl) {
        return zabl2.zaL(false);
    }

    static /* synthetic */ void zau(zabl zabl2, zabm zabm2) {
        if (!zabl2.zak.contains(zabm2)) return;
        if (zabl2.zaj) return;
        if (!zabl2.zac.isConnected()) {
            zabl2.zam();
            return;
        }
        zabl2.zaE();
    }

    static /* synthetic */ void zav(zabl zabl2, zabm zabm2) {
        if (!zabl2.zak.remove(zabm2)) return;
        GoogleApiManager.zas((GoogleApiManager)zabl2.zaa).removeMessages(15, (Object)zabm2);
        GoogleApiManager.zas((GoogleApiManager)zabl2.zaa).removeMessages(16, (Object)zabm2);
        zabm2 = zabm.zab((zabm)zabm2);
        ArrayList<zai> arrayList = new ArrayList<zai>(zabl2.zab.size());
        for (zai zai2 : zabl2.zab) {
            Object[] objectArray;
            if (!(zai2 instanceof zac) || (objectArray = ((zac)zai2).zaa(zabl2)) == null || !ArrayUtils.contains((Object[])objectArray, (Object)zabm2)) continue;
            arrayList.add(zai2);
        }
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            zai zai2;
            zai2 = (zai)arrayList.get(n2);
            zabl2.zab.remove(zai2);
            zai2.zad((Exception)new UnsupportedApiCallException((Feature)zabm2));
            ++n2;
        }
    }

    static /* synthetic */ void zaw(zabl zabl2, Status status) {
        zabl2.zaI(status);
    }

    static /* synthetic */ ApiKey zax(zabl zabl2) {
        return zabl2.zad;
    }

    static /* synthetic */ void zay(zabl zabl2) {
        zabl2.zaB();
    }

    static /* synthetic */ void zaz(zabl zabl2, int n) {
        zabl2.zaC(n);
    }

    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == GoogleApiManager.zas((GoogleApiManager)this.zaa).getLooper()) {
            this.zaB();
            return;
        }
        GoogleApiManager.zas((GoogleApiManager)this.zaa).post((Runnable)new zabh(this));
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zac(connectionResult, null);
    }

    public final void onConnectionSuspended(int n) {
        if (Looper.myLooper() == GoogleApiManager.zas((GoogleApiManager)this.zaa).getLooper()) {
            this.zaC(n);
            return;
        }
        GoogleApiManager.zas((GoogleApiManager)this.zaa).post((Runnable)new zabi(this, n));
    }

    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean bl) {
        throw null;
    }

    public final void zab(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        Api.Client client = this.zac;
        String string = client.getClass().getName();
        String string2 = String.valueOf(connectionResult);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 25 + String.valueOf(string2).length());
        stringBuilder.append("onSignInFailed for ");
        stringBuilder.append(string);
        stringBuilder.append(" with ");
        stringBuilder.append(string2);
        client.disconnect(stringBuilder.toString());
        this.zac(connectionResult, null);
    }

    public final void zac(ConnectionResult connectionResult, Exception exception) {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        zaco zaco2 = this.zai;
        if (zaco2 != null) {
            zaco2.zad();
        }
        this.zah();
        GoogleApiManager.zaw((GoogleApiManager)this.zaa).zac();
        this.zaM(connectionResult);
        if (this.zac instanceof zap && connectionResult.getErrorCode() != 24) {
            GoogleApiManager.zaA((GoogleApiManager)this.zaa, (boolean)true);
            GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(GoogleApiManager.zas((GoogleApiManager)this.zaa).obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            this.zaI(GoogleApiManager.zaB());
            return;
        }
        if (this.zab.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (exception != null) {
            Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
            this.zaH(null, exception, false);
            return;
        }
        if (!GoogleApiManager.zaC((GoogleApiManager)this.zaa)) {
            this.zaI(GoogleApiManager.zaF(this.zad, (ConnectionResult)connectionResult));
            return;
        }
        this.zaH(GoogleApiManager.zaF(this.zad, (ConnectionResult)connectionResult), null, true);
        if (this.zab.isEmpty()) {
            return;
        }
        if (this.zaD(connectionResult)) {
            return;
        }
        if (this.zaa.zap(connectionResult, this.zah)) return;
        if (connectionResult.getErrorCode() == 18) {
            this.zaj = true;
        }
        if (this.zaj) {
            GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessageDelayed(Message.obtain((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa), (int)9, this.zad), GoogleApiManager.zau((GoogleApiManager)this.zaa));
            return;
        }
        this.zaI(GoogleApiManager.zaF(this.zad, (ConnectionResult)connectionResult));
    }

    public final void zad(zai zai2) {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        if (this.zac.isConnected()) {
            if (this.zaF(zai2)) {
                this.zaK();
                return;
            }
            this.zab.add(zai2);
            return;
        }
        this.zab.add(zai2);
        zai2 = this.zal;
        if (zai2 != null && zai2.hasResolution()) {
            this.zac(this.zal, null);
            return;
        }
        this.zam();
    }

    public final void zae() {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        this.zaI(GoogleApiManager.zaa);
        this.zae.zad();
        ListenerHolder.ListenerKey[] listenerKeyArray = this.zag.keySet();
        int n = 0;
        listenerKeyArray = listenerKeyArray.toArray(new ListenerHolder.ListenerKey[0]);
        int n2 = listenerKeyArray.length;
        while (true) {
            if (n >= n2) {
                this.zaM(new ConnectionResult(4));
                if (!this.zac.isConnected()) return;
                this.zac.onUserSignOut((BaseGmsClient.SignOutCallbacks)new zabk(this));
                return;
            }
            this.zad((zai)new zah(listenerKeyArray[n], new TaskCompletionSource()));
            ++n;
        }
    }

    public final Api.Client zaf() {
        return this.zac;
    }

    public final Map<ListenerHolder.ListenerKey<?>, zacc> zag() {
        return this.zag;
    }

    public final void zah() {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        this.zal = null;
    }

    public final ConnectionResult zai() {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        return this.zal;
    }

    public final void zaj() {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        if (!this.zaj) return;
        this.zam();
    }

    public final void zak() {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        if (!this.zaj) return;
        this.zaJ();
        Status status = GoogleApiManager.zaD((GoogleApiManager)this.zaa).isGooglePlayServicesAvailable(GoogleApiManager.zat((GoogleApiManager)this.zaa)) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error.");
        this.zaI(status);
        this.zac.disconnect("Timing out connection while resuming.");
    }

    public final boolean zal() {
        return this.zaL(true);
    }

    public final void zam() {
        block6: {
            Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
            if (this.zac.isConnected()) return;
            if (this.zac.isConnecting()) return;
            try {
                int n = GoogleApiManager.zaw((GoogleApiManager)this.zaa).zaa(GoogleApiManager.zat((GoogleApiManager)this.zaa), this.zac);
                if (n != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(n, null);
                    String string = this.zac.getClass().getName();
                    String string2 = String.valueOf(connectionResult);
                    n = String.valueOf(string).length();
                    int n2 = String.valueOf(string2).length();
                    StringBuilder stringBuilder = new StringBuilder(n + 35 + n2);
                    stringBuilder.append("The service for ");
                    stringBuilder.append(string);
                    stringBuilder.append(" is not available: ");
                    stringBuilder.append(string2);
                    Log.w((String)"GoogleApiManager", (String)stringBuilder.toString());
                    this.zac(connectionResult, null);
                    return;
                }
            }
            catch (IllegalStateException illegalStateException) {
                this.zac(new ConnectionResult(10), illegalStateException);
                break block6;
            }
            zabo zabo2 = new zabo(this.zaa, this.zac, this.zad);
            if (this.zac.requiresSignIn()) {
                ((zaco)Preconditions.checkNotNull((Object)this.zai)).zac((zacn)zabo2);
            }
            try {
                this.zac.connect((BaseGmsClient.ConnectionProgressReportCallbacks)zabo2);
                return;
            }
            catch (SecurityException securityException) {
                this.zac(new ConnectionResult(10), securityException);
                return;
            }
        }
    }

    public final void zan(zal zal2) {
        Preconditions.checkHandlerThread((Handler)GoogleApiManager.zas((GoogleApiManager)this.zaa));
        this.zaf.add(zal2);
    }

    final boolean zao() {
        return this.zac.isConnected();
    }

    public final boolean zap() {
        return this.zac.requiresSignIn();
    }

    public final int zaq() {
        return this.zah;
    }

    final int zar() {
        return this.zam;
    }

    final void zas() {
        ++this.zam;
    }
}
