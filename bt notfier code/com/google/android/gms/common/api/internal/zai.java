/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.zaaa
 *  com.google.android.gms.common.api.internal.zabl
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zaaa;
import com.google.android.gms.common.api.internal.zabl;

public abstract class zai {
    public final int zac;

    public zai(int n) {
        this.zac = n;
    }

    static /* synthetic */ Status zah(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(remoteException.getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(19, stringBuilder.toString());
    }

    public abstract void zac(Status var1);

    public abstract void zad(Exception var1);

    public abstract void zae(zaaa var1, boolean var2);

    public abstract void zaf(zabl<?> var1) throws DeadObjectException;
}
