/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzcaf
 *  com.google.android.gms.internal.ads.zzcam
 *  com.google.android.gms.internal.ads.zzcfk
 *  com.google.android.gms.internal.ads.zzcfr
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfr;
import java.util.List;

public interface zzcfn
extends IInterface {
    public void zze(IObjectWrapper var1, zzcfr var2, zzcfk var3) throws RemoteException;

    public void zzf(IObjectWrapper var1) throws RemoteException;

    public void zzg(List<Uri> var1, IObjectWrapper var2, zzcaf var3) throws RemoteException;

    public void zzh(List<Uri> var1, IObjectWrapper var2, zzcaf var3) throws RemoteException;

    public void zzi(zzcam var1) throws RemoteException;

    public void zzj(IObjectWrapper var1) throws RemoteException;
}
