/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.api.internal.RegistrationMethods$Builder
 *  com.google.android.gms.common.api.internal.UnregisterListenerMethod
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zaci
extends UnregisterListenerMethod {
    final RegistrationMethods.Builder zaa;

    zaci(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        this.zaa = builder;
        super(listenerKey);
    }

    protected final void unregisterListener(Api.AnyClient anyClient, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        RegistrationMethods.Builder.zac((RegistrationMethods.Builder)this.zaa).accept((Object)anyClient, taskCompletionSource);
    }
}
