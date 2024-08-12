/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

public interface zzcod
extends IInterface {
    public void zzb(Bundle var1) throws RemoteException;

    public Bundle zzc(Bundle var1) throws RemoteException;

    public void zzd(String var1, String var2, Bundle var3) throws RemoteException;

    public void zze(String var1, String var2, IObjectWrapper var3) throws RemoteException;

    public Map zzf(String var1, String var2, boolean var3) throws RemoteException;

    public int zzg(String var1) throws RemoteException;

    public void zzh(Bundle var1) throws RemoteException;

    public void zzi(String var1, String var2, Bundle var3) throws RemoteException;

    public List zzj(String var1, String var2) throws RemoteException;

    public String zzk() throws RemoteException;

    public String zzl() throws RemoteException;

    public long zzm() throws RemoteException;

    public void zzn(String var1) throws RemoteException;

    public void zzo(String var1) throws RemoteException;

    public void zzp(Bundle var1) throws RemoteException;

    public void zzq(IObjectWrapper var1, String var2, String var3) throws RemoteException;

    public String zzr() throws RemoteException;

    public String zzs() throws RemoteException;

    public String zzt() throws RemoteException;
}
