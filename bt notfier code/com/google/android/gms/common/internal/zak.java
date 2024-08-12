/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zaj
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zak
implements Handler.Callback {
    final ArrayList<GoogleApiClient.ConnectionCallbacks> zaa;
    @NotOnlyInitialized
    private final zaj zab;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zac = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zad;
    private volatile boolean zae = false;
    private final AtomicInteger zaf;
    private boolean zag = false;
    private final Handler zah;
    private final Object zai;

    public zak(Looper looper, zaj zaj2) {
        this.zaa = new ArrayList();
        this.zad = new ArrayList();
        this.zaf = new AtomicInteger(0);
        this.zai = new Object();
        this.zab = zaj2;
        this.zah = new zap(looper, (Handler.Callback)this);
    }

    public final boolean handleMessage(Message object) {
        if (((Message)object).what != 1) {
            int n = ((Message)object).what;
            object = new StringBuilder(45);
            ((StringBuilder)object).append("Don't know how to handle message: ");
            ((StringBuilder)object).append(n);
            Log.wtf((String)"GmsClientEvents", (String)((StringBuilder)object).toString(), (Throwable)new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Message)object).obj;
        object = this.zai;
        synchronized (object) {
            if (!this.zae) return true;
            if (!this.zab.isConnected()) return true;
            if (!this.zac.contains(connectionCallbacks)) return true;
            connectionCallbacks.onConnected(null);
            return true;
        }
    }

    public final void zaa() {
        this.zae = false;
        this.zaf.incrementAndGet();
    }

    public final void zab() {
        this.zae = true;
    }

    public final void zac(Bundle bundle) {
        Preconditions.checkHandlerThread((Handler)this.zah, (String)"onConnectionSuccess must only be called on the Handler thread");
        Object object = this.zai;
        synchronized (object) {
            try {
                boolean bl = this.zag;
                boolean bl2 = true;
                Preconditions.checkState((boolean)(bl ^ true));
                this.zah.removeMessages(1);
                this.zag = true;
                if (this.zaa.size() != 0) {
                    bl2 = false;
                }
                Preconditions.checkState((boolean)bl2);
                GoogleApiClient.ConnectionCallbacks connectionCallbacks2 = new ArrayList(this.zac);
                int n = this.zaf.get();
                for (GoogleApiClient.ConnectionCallbacks connectionCallbacks2 : connectionCallbacks2) {
                    if (!this.zae || !this.zab.isConnected() || this.zaf.get() != n) break;
                    if (this.zaa.contains(connectionCallbacks2)) continue;
                    connectionCallbacks2.onConnected(bundle);
                }
                this.zaa.clear();
                this.zag = false;
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zad(int n) {
        Preconditions.checkHandlerThread((Handler)this.zah, (String)"onUnintentionalDisconnection must only be called on the Handler thread");
        this.zah.removeMessages(1);
        Object object = this.zai;
        synchronized (object) {
            try {
                this.zag = true;
                Object object2 = new ArrayList(this.zac);
                int n2 = this.zaf.get();
                object2 = ((ArrayList)object2).iterator();
                while (object2.hasNext()) {
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)object2.next();
                    if (!this.zae || this.zaf.get() != n2) break;
                    if (!this.zac.contains(connectionCallbacks)) continue;
                    connectionCallbacks.onConnectionSuspended(n);
                }
                this.zaa.clear();
                this.zag = false;
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zae(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread((Handler)this.zah, (String)"onConnectionFailure must only be called on the Handler thread");
        this.zah.removeMessages(1);
        Object object = this.zai;
        synchronized (object) {
            try {
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = new ArrayList(this.zad);
                int n = this.zaf.get();
                Iterator<GoogleApiClient.OnConnectionFailedListener> iterator = onConnectionFailedListener.iterator();
                while (iterator.hasNext()) {
                    onConnectionFailedListener = iterator.next();
                    if (!this.zae) return;
                    if (this.zaf.get() != n) {
                        return;
                    }
                    if (!this.zad.contains(onConnectionFailedListener)) continue;
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull((Object)connectionCallbacks);
        Object object = this.zai;
        synchronized (object) {
            if (this.zac.contains(connectionCallbacks)) {
                String string = String.valueOf(connectionCallbacks);
                int n = String.valueOf(string).length();
                StringBuilder stringBuilder = new StringBuilder(n + 62);
                stringBuilder.append("registerConnectionCallbacks(): listener ");
                stringBuilder.append(string);
                stringBuilder.append(" is already registered");
                Log.w((String)"GmsClientEvents", (String)stringBuilder.toString());
            } else {
                this.zac.add(connectionCallbacks);
            }
        }
        if (!this.zab.isConnected()) return;
        object = this.zah;
        object.sendMessage(object.obtainMessage(1, (Object)connectionCallbacks));
    }

    public final boolean zag(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull((Object)connectionCallbacks);
        Object object = this.zai;
        synchronized (object) {
            boolean bl = this.zac.contains(connectionCallbacks);
            return bl;
        }
    }

    public final void zah(GoogleApiClient.ConnectionCallbacks object) {
        Preconditions.checkNotNull((Object)object);
        Object object2 = this.zai;
        synchronized (object2) {
            if (!this.zac.remove(object)) {
                object = String.valueOf(object);
                int n = String.valueOf(object).length();
                StringBuilder stringBuilder = new StringBuilder(n + 52);
                stringBuilder.append("unregisterConnectionCallbacks(): listener ");
                stringBuilder.append((String)object);
                stringBuilder.append(" not found");
                Log.w((String)"GmsClientEvents", (String)stringBuilder.toString());
            } else {
                if (!this.zag) return;
                this.zaa.add((GoogleApiClient.ConnectionCallbacks)object);
            }
            return;
        }
    }

    public final void zai(GoogleApiClient.OnConnectionFailedListener object) {
        Preconditions.checkNotNull((Object)object);
        Object object2 = this.zai;
        synchronized (object2) {
            if (this.zad.contains(object)) {
                object = String.valueOf(object);
                int n = String.valueOf(object).length();
                StringBuilder stringBuilder = new StringBuilder(n + 67);
                stringBuilder.append("registerConnectionFailedListener(): listener ");
                stringBuilder.append((String)object);
                stringBuilder.append(" is already registered");
                Log.w((String)"GmsClientEvents", (String)stringBuilder.toString());
            } else {
                this.zad.add((GoogleApiClient.OnConnectionFailedListener)object);
            }
            return;
        }
    }

    public final boolean zaj(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull((Object)onConnectionFailedListener);
        Object object = this.zai;
        synchronized (object) {
            boolean bl = this.zad.contains(onConnectionFailedListener);
            return bl;
        }
    }

    public final void zak(GoogleApiClient.OnConnectionFailedListener object) {
        Preconditions.checkNotNull((Object)object);
        Object object2 = this.zai;
        synchronized (object2) {
            if (this.zad.remove(object)) return;
            String string = String.valueOf(object);
            int n = String.valueOf(string).length();
            object = new StringBuilder(n + 57);
            ((StringBuilder)object).append("unregisterConnectionFailedListener(): listener ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" not found");
            Log.w((String)"GmsClientEvents", (String)((StringBuilder)object).toString());
            return;
        }
    }
}
