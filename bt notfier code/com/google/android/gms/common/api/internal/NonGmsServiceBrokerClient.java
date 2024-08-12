/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.internal.ConnectionCallbacks
 *  com.google.android.gms.common.api.internal.OnConnectionFailedListener
 *  com.google.android.gms.common.api.internal.zabz
 *  com.google.android.gms.common.api.internal.zaca
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks
 *  com.google.android.gms.common.internal.GmsClientSupervisor
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zabz;
import com.google.android.gms.common.api.internal.zaca;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

public final class NonGmsServiceBrokerClient
implements Api.Client,
ServiceConnection {
    private static final String zaa = NonGmsServiceBrokerClient.class.getSimpleName();
    private final String zab;
    private final String zac;
    private final ComponentName zad;
    private final Context zae;
    private final ConnectionCallbacks zaf;
    private final Handler zag;
    private final OnConnectionFailedListener zah;
    private IBinder zai;
    private boolean zaj = false;
    private String zak = null;
    private String zal;

    public NonGmsServiceBrokerClient(Context context, Looper looper, ComponentName componentName, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, null, null, componentName, connectionCallbacks, onConnectionFailedListener);
    }

    private NonGmsServiceBrokerClient(Context context, Looper looper, String string, String string2, ComponentName componentName, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.zae = context;
        this.zag = new zap(looper);
        this.zaf = connectionCallbacks;
        this.zah = onConnectionFailedListener;
        if (string != null && string2 != null) {
            if (componentName != null) throw new AssertionError((Object)"Must specify either package or component, but not both");
            componentName = null;
        } else if (componentName == null) throw new AssertionError((Object)"Must specify either package or component, but not both");
        this.zab = string;
        this.zac = string2;
        this.zad = componentName;
    }

    public NonGmsServiceBrokerClient(Context context, Looper looper, String string, String string2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, string, string2, null, connectionCallbacks, onConnectionFailedListener);
    }

    private final void zad() {
        if (Thread.currentThread() != this.zag.getLooper().getThread()) throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
    }

    private final void zae(String string) {
        String string2 = String.valueOf(this.zai);
        string.length();
        String.valueOf(string2).length();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        block7: {
            this.zad();
            this.zae("Connect started.");
            if (this.isConnected()) {
                try {
                    this.disconnect("connect() called when already connected");
                }
                catch (Exception exception) {}
            }
            try {
                boolean bl;
                connectionProgressReportCallbacks = new Intent();
                ComponentName componentName = this.zad;
                if (componentName != null) {
                    connectionProgressReportCallbacks.setComponent(componentName);
                } else {
                    connectionProgressReportCallbacks.setPackage(this.zab).setAction(this.zac);
                }
                this.zaj = bl = this.zae.bindService((Intent)connectionProgressReportCallbacks, (ServiceConnection)this, GmsClientSupervisor.getDefaultBindFlags());
                if (bl) break block7;
                this.zai = null;
            }
            catch (SecurityException securityException) {
                this.zaj = false;
                this.zai = null;
                throw securityException;
            }
            this.zah.onConnectionFailed(new ConnectionResult(16));
        }
        this.zae("Finished connect.");
    }

    /*
     * Unable to fully structure code
     */
    public final void disconnect() {
        this.zad();
        this.zae("Disconnect called.");
        try {
            this.zae.unbindService((ServiceConnection)this);
lbl5:
            // 2 sources

            while (true) {
                this.zaj = false;
                this.zai = null;
                return;
            }
        }
        catch (IllegalArgumentException var1_1) {
            ** continue;
        }
    }

    public final void disconnect(String string) {
        this.zad();
        this.zak = string;
        this.disconnect();
    }

    public final void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    public IBinder getBinder() {
        this.zad();
        return this.zai;
    }

    public final String getEndpointPackageName() {
        String string = this.zab;
        if (string != null) {
            return string;
        }
        Preconditions.checkNotNull((Object)this.zad);
        return this.zad.getPackageName();
    }

    public final String getLastDisconnectMessage() {
        return this.zak;
    }

    public final int getMinApkVersion() {
        return 0;
    }

    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
    }

    public final Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    public final IBinder getServiceBrokerBinder() {
        return null;
    }

    public final Intent getSignInIntent() {
        return new Intent();
    }

    public final boolean isConnected() {
        this.zad();
        if (this.zai == null) return false;
        return true;
    }

    public final boolean isConnecting() {
        this.zad();
        return this.zaj;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zag.post((Runnable)new zabz(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zag.post((Runnable)new zaca(this));
    }

    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }

    public final boolean providesSignIn() {
        return false;
    }

    public final boolean requiresAccount() {
        return false;
    }

    public final boolean requiresGooglePlayServices() {
        return false;
    }

    public final boolean requiresSignIn() {
        return false;
    }

    public final void zaa(String string) {
        this.zal = string;
    }

    final /* synthetic */ void zab() {
        this.zaj = false;
        this.zai = null;
        this.zae("Disconnected.");
        this.zaf.onConnectionSuspended(1);
    }

    final /* synthetic */ void zac(IBinder iBinder) {
        this.zaj = false;
        this.zai = iBinder;
        this.zae("Connected.");
        this.zaf.onConnected(new Bundle());
    }
}
