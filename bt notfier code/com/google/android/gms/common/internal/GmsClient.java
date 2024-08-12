/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Handler
 *  android.os.IInterface
 *  android.os.Looper
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.internal.ConnectionCallbacks
 *  com.google.android.gms.common.api.internal.OnConnectionFailedListener
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.GmsClientSupervisor
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zah
 *  com.google.android.gms.common.internal.zai
 *  com.google.android.gms.common.internal.zaj
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zah;
import com.google.android.gms.common.internal.zai;
import com.google.android.gms.common.internal.zaj;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public abstract class GmsClient<T extends IInterface>
extends BaseGmsClient<T>
implements Api.Client,
zaj {
    private final ClientSettings zaa;
    private final Set<Scope> zab;
    private final Account zac;

    protected GmsClient(Context context, Handler handler, int n, ClientSettings clientSettings) {
        super(context, handler, GmsClientSupervisor.getInstance((Context)context), (GoogleApiAvailabilityLight)GoogleApiAvailability.getInstance(), n, null, null);
        this.zaa = (ClientSettings)Preconditions.checkNotNull((Object)clientSettings);
        this.zac = clientSettings.getAccount();
        this.zab = this.zaa(clientSettings.getAllRequestedScopes());
    }

    protected GmsClient(Context context, Looper looper, int n, ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.getInstance((Context)context), GoogleApiAvailability.getInstance(), n, clientSettings, null, null);
    }

    @Deprecated
    protected GmsClient(Context context, Looper looper, int n, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, n, clientSettings, (ConnectionCallbacks)connectionCallbacks, (OnConnectionFailedListener)onConnectionFailedListener);
    }

    protected GmsClient(Context context, Looper looper, int n, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.getInstance((Context)context), GoogleApiAvailability.getInstance(), n, clientSettings, (ConnectionCallbacks)Preconditions.checkNotNull((Object)connectionCallbacks), (OnConnectionFailedListener)Preconditions.checkNotNull((Object)onConnectionFailedListener));
    }

    protected GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int n, ClientSettings clientSettings, ConnectionCallbacks object, OnConnectionFailedListener object2) {
        object = object == null ? null : new zah(object);
        object2 = object2 == null ? null : new zai(object2);
        super(context, looper, gmsClientSupervisor, (GoogleApiAvailabilityLight)googleApiAvailability, n, (BaseGmsClient.BaseConnectionCallbacks)object, (BaseGmsClient.BaseOnConnectionFailedListener)object2, clientSettings.zab());
        this.zaa = clientSettings;
        this.zac = clientSettings.getAccount();
        this.zab = this.zaa(clientSettings.getAllRequestedScopes());
    }

    private final Set<Scope> zaa(Set<Scope> set) {
        Set<Scope> set2 = this.validateScopes(set);
        Iterator<Scope> iterator = set2.iterator();
        while (iterator.hasNext()) {
            if (!set.contains(iterator.next())) throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
        }
        return set2;
    }

    public final Account getAccount() {
        return this.zac;
    }

    protected final ClientSettings getClientSettings() {
        return this.zaa;
    }

    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    protected final Set<Scope> getScopes() {
        return this.zab;
    }

    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        Set<Object> set = this.requiresSignIn() ? this.zab : Collections.emptySet();
        return set;
    }

    protected Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
