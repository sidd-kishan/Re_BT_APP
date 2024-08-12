/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzbvg
 */
package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbvg;
import java.util.List;

public interface zzbge
extends IInterface {
    public void zze() throws RemoteException;

    public void zzf(float var1) throws RemoteException;

    public void zzg(String var1) throws RemoteException;

    public void zzh(boolean var1) throws RemoteException;

    public void zzi(IObjectWrapper var1, String var2) throws RemoteException;

    public void zzj(String var1, IObjectWrapper var2) throws RemoteException;

    public float zzk() throws RemoteException;

    public boolean zzl() throws RemoteException;

    public String zzm() throws RemoteException;

    public void zzn(String var1) throws RemoteException;

    public void zzo(zzbvg var1) throws RemoteException;

    public void zzp(zzbrs var1) throws RemoteException;

    public List<zzbrl> zzq() throws RemoteException;

    public void zzr(zzbim var1) throws RemoteException;

    public void zzs() throws RemoteException;

    public void zzt(zzbgq var1) throws RemoteException;
}
