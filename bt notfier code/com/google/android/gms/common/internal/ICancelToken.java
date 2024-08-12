/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;

public interface ICancelToken
extends IInterface {
    public void cancel() throws RemoteException;
}
