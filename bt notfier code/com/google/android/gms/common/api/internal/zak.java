/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseArray
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.internal.LifecycleActivity
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.api.internal.zaj
 *  com.google.android.gms.common.api.internal.zam
 *  com.google.android.gms.common.api.internal.zap
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class zak
extends zap {
    private final SparseArray<zaj> zad = new SparseArray();

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.mLifecycleFragment.addCallback("AutoManageHelper", (LifecycleCallback)this);
    }

    public static zak zaa(LifecycleActivity object) {
        LifecycleFragment lifecycleFragment = zak.getFragment((LifecycleActivity)object);
        if ((object = (zak)lifecycleFragment.getCallbackOrNull("AutoManageHelper", zak.class)) == null) return new zak(lifecycleFragment);
        return object;
    }

    private final zaj zai(int n) {
        if (this.zad.size() <= n) {
            return null;
        }
        SparseArray<zaj> sparseArray = this.zad;
        return (zaj)sparseArray.get(sparseArray.keyAt(n));
    }

    public final void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        int n = 0;
        while (n < this.zad.size()) {
            zaj zaj2 = this.zai(n);
            if (zaj2 != null) {
                printWriter.append(string).append("GoogleApiClient #").print(zaj2.zaa);
                printWriter.println(":");
                zaj2.zab.dump(String.valueOf(string).concat("  "), fileDescriptor, printWriter, stringArray);
            }
            ++n;
        }
    }

    public final void onStart() {
        super.onStart();
        boolean bl = this.zaa;
        String string = String.valueOf(this.zad);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 14);
        stringBuilder.append("onStart ");
        stringBuilder.append(bl);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        Log.d((String)"AutoManageHelper", (String)stringBuilder.toString());
        if (this.zab.get() != null) return;
        int n = 0;
        while (n < this.zad.size()) {
            stringBuilder = this.zai(n);
            if (stringBuilder != null) {
                ((zaj)stringBuilder).zab.connect();
            }
            ++n;
        }
    }

    public final void onStop() {
        super.onStop();
        int n = 0;
        while (n < this.zad.size()) {
            zaj zaj2 = this.zai(n);
            if (zaj2 != null) {
                zaj2.zab.disconnect();
            }
            ++n;
        }
    }

    public final void zab(int n, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener object) {
        Preconditions.checkNotNull((Object)googleApiClient, (Object)"GoogleApiClient instance cannot be null");
        boolean bl = this.zad.indexOfKey(n) < 0;
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Already managing a GoogleApiClient with id ");
        stringBuilder.append(n);
        Preconditions.checkState((boolean)bl, (Object)stringBuilder.toString());
        stringBuilder = (zam)this.zab.get();
        bl = this.zaa;
        String string = String.valueOf(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(string).length() + 49);
        stringBuilder2.append("starting AutoManage for client ");
        stringBuilder2.append(n);
        stringBuilder2.append(" ");
        stringBuilder2.append(bl);
        stringBuilder2.append(" ");
        stringBuilder2.append(string);
        Log.d((String)"AutoManageHelper", (String)stringBuilder2.toString());
        object = new zaj(this, n, googleApiClient, object);
        googleApiClient.registerConnectionFailedListener(object);
        this.zad.put(n, object);
        if (!this.zaa) return;
        if (stringBuilder != null) return;
        object = String.valueOf(googleApiClient);
        stringBuilder = new StringBuilder(String.valueOf(object).length() + 11);
        stringBuilder.append("connecting ");
        stringBuilder.append((String)object);
        Log.d((String)"AutoManageHelper", (String)stringBuilder.toString());
        googleApiClient.connect();
    }

    public final void zac(int n) {
        zaj zaj2 = (zaj)this.zad.get(n);
        this.zad.remove(n);
        if (zaj2 == null) return;
        zaj2.zab.unregisterConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)zaj2);
        zaj2.zab.disconnect();
    }

    protected final void zad(ConnectionResult connectionResult, int n) {
        Log.w((String)"AutoManageHelper", (String)"Unresolved error while connecting client. Stopping auto-manage.");
        if (n < 0) {
            Log.wtf((String)"AutoManageHelper", (String)"AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", (Throwable)new Exception());
            return;
        }
        zaj zaj2 = (zaj)this.zad.get(n);
        if (zaj2 == null) return;
        this.zac(n);
        zaj2 = zaj2.zac;
        if (zaj2 == null) return;
        zaj2.onConnectionFailed(connectionResult);
    }

    protected final void zae() {
        int n = 0;
        while (n < this.zad.size()) {
            zaj zaj2 = this.zai(n);
            if (zaj2 != null) {
                zaj2.zab.connect();
            }
            ++n;
        }
    }
}
