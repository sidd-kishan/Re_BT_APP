/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Status
 */
package com.google.android.gms.common.api.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface IStatusCallback
extends IInterface {
    public void onResult(Status var1) throws RemoteException;
}
