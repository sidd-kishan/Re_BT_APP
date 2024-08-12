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

public final class zah
extends zad<Boolean> {
    public final ListenerHolder.ListenerKey<?> zab;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    public final Feature[] zaa(zabl<?> zacc2) {
        if ((zacc2 = (zacc)zacc2.zag().get(this.zab)) != null) return zacc2.zaa.getRequiredFeatures();
        return null;
    }

    public final boolean zab(zabl<?> zacc2) {
        if ((zacc2 = (zacc)zacc2.zag().get(this.zab)) == null) return false;
        if (!zacc2.zaa.zaa()) return false;
        return true;
    }

    public final void zag(zabl<?> zabl2) throws RemoteException {
        zacc zacc2 = (zacc)zabl2.zag().remove(this.zab);
        if (zacc2 != null) {
            zacc2.zab.unregisterListener((Api.AnyClient)zabl2.zaf(), this.zaa);
            zacc2.zaa.clearListener();
            return;
        }
        this.zaa.trySetResult((Object)false);
    }
}
