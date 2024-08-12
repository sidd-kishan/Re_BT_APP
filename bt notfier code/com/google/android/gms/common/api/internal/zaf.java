/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zacc
 *  com.google.android.gms.common.api.internal.zad
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.api.internal.zad;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaf
extends zad<Void> {
    public final zacc zab;

    public zaf(zacc zacc2, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zab = zacc2;
    }

    public final Feature[] zaa(zabl<?> zabl2) {
        return this.zab.zaa.getRequiredFeatures();
    }

    public final boolean zab(zabl<?> zabl2) {
        return this.zab.zaa.zaa();
    }

    public final void zag(zabl<?> zabl2) throws RemoteException {
        this.zab.zaa.registerListener((Api.AnyClient)zabl2.zaf(), this.zaa);
        ListenerHolder.ListenerKey listenerKey = this.zab.zaa.getListenerKey();
        if (listenerKey == null) return;
        zabl2.zag().put(listenerKey, this.zab);
    }
}
