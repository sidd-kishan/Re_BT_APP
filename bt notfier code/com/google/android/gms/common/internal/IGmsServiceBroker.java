/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.GetServiceRequest
 *  com.google.android.gms.common.internal.IGmsCallbacks
 */
package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;

public interface IGmsServiceBroker
extends IInterface {
    public void getService(IGmsCallbacks var1, GetServiceRequest var2) throws RemoteException;
}
