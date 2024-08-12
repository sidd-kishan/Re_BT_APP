/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbme
 */
package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbme;

public interface zzbml
extends IInterface {
    public void zzb(String var1, IObjectWrapper var2) throws RemoteException;

    public void zzbu(IObjectWrapper var1) throws RemoteException;

    public void zzbv(IObjectWrapper var1) throws RemoteException;

    public void zzbw(zzbme var1) throws RemoteException;

    public IObjectWrapper zzc(String var1) throws RemoteException;

    public void zzd(IObjectWrapper var1) throws RemoteException;

    public void zze() throws RemoteException;

    public void zzf(IObjectWrapper var1, int var2) throws RemoteException;

    public void zzg(IObjectWrapper var1) throws RemoteException;
}
