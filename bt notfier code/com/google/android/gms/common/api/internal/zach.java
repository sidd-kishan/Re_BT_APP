/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.ListenerHolder
 *  com.google.android.gms.common.api.internal.RegisterListenerMethod
 *  com.google.android.gms.common.api.internal.RegistrationMethods$Builder
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zach
extends RegisterListenerMethod {
    final RegistrationMethods.Builder zaa;

    zach(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArray, boolean bl, int n) {
        this.zaa = builder;
        super(listenerHolder, featureArray, bl, n);
    }

    protected final void registerListener(Api.AnyClient anyClient, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        RegistrationMethods.Builder.zab((RegistrationMethods.Builder)this.zaa).accept((Object)anyClient, taskCompletionSource);
    }
}
