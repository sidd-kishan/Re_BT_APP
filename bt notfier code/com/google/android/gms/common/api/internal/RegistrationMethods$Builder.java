/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.ListenerHolder
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.api.internal.RegisterListenerMethod
 *  com.google.android.gms.common.api.internal.RegistrationMethods
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.common.api.internal.UnregisterListenerMethod
 *  com.google.android.gms.common.api.internal.zacd
 *  com.google.android.gms.common.api.internal.zace
 *  com.google.android.gms.common.api.internal.zacf
 *  com.google.android.gms.common.api.internal.zacg
 *  com.google.android.gms.common.api.internal.zach
 *  com.google.android.gms.common.api.internal.zaci
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.BiConsumer
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zacd;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zacf;
import com.google.android.gms.common.api.internal.zacg;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zaci;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public static class RegistrationMethods.Builder<A extends Api.AnyClient, L> {
    private RemoteCall<A, TaskCompletionSource<Void>> zaa;
    private RemoteCall<A, TaskCompletionSource<Boolean>> zab;
    private Runnable zac = zace.zaa;
    private ListenerHolder<L> zad;
    private Feature[] zae;
    private boolean zaf = true;
    private int zag;

    private RegistrationMethods.Builder() {
    }

    /* synthetic */ RegistrationMethods.Builder(zacd zacd2) {
    }

    static /* synthetic */ RemoteCall zab(RegistrationMethods.Builder builder) {
        return builder.zaa;
    }

    static /* synthetic */ RemoteCall zac(RegistrationMethods.Builder builder) {
        return builder.zab;
    }

    public RegistrationMethods<A, L> build() {
        ListenerHolder.ListenerKey listenerKey = this.zaa;
        boolean bl = true;
        boolean bl2 = listenerKey != null;
        Preconditions.checkArgument((boolean)bl2, (Object)"Must set register function");
        bl2 = this.zab != null;
        Preconditions.checkArgument((boolean)bl2, (Object)"Must set unregister function");
        bl2 = this.zad != null ? bl : false;
        Preconditions.checkArgument((boolean)bl2, (Object)"Must set holder");
        listenerKey = (ListenerHolder.ListenerKey)Preconditions.checkNotNull((Object)this.zad.getListenerKey(), (Object)"Key must not be null");
        return new RegistrationMethods((RegisterListenerMethod)new zach(this, this.zad, this.zae, this.zaf, this.zag), (UnregisterListenerMethod)new zaci(this, listenerKey), this.zac, null);
    }

    public RegistrationMethods.Builder<A, L> onConnectionSuspended(Runnable runnable) {
        this.zac = runnable;
        return this;
    }

    public RegistrationMethods.Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
        this.zaa = remoteCall;
        return this;
    }

    @Deprecated
    public RegistrationMethods.Builder<A, L> register(BiConsumer<A, TaskCompletionSource<Void>> biConsumer) {
        this.zaa = new zacf(biConsumer);
        return this;
    }

    public RegistrationMethods.Builder<A, L> setAutoResolveMissingFeatures(boolean bl) {
        this.zaf = bl;
        return this;
    }

    public RegistrationMethods.Builder<A, L> setFeatures(Feature ... featureArray) {
        this.zae = featureArray;
        return this;
    }

    public RegistrationMethods.Builder<A, L> setMethodKey(int n) {
        this.zag = n;
        return this;
    }

    public RegistrationMethods.Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
        this.zab = remoteCall;
        return this;
    }

    @Deprecated
    public RegistrationMethods.Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> biConsumer) {
        this.zaa = new zacg(this);
        return this;
    }

    public RegistrationMethods.Builder<A, L> withHolder(ListenerHolder<L> listenerHolder) {
        this.zad = listenerHolder;
        return this;
    }

    final /* synthetic */ void zaa(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zaa.accept((Object)anyClient, (Object)taskCompletionSource);
    }
}
