/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbsd
 */
package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbsd;

public interface zzbsa
extends IInterface {
    public zzbhc zzb() throws RemoteException;

    public void zzc() throws RemoteException;

    public void zzd(IObjectWrapper var1, zzbsd var2) throws RemoteException;

    public void zze(IObjectWrapper var1) throws RemoteException;

    public zzbme zzf() throws RemoteException;
}
