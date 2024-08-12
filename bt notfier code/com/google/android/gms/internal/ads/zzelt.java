/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzels
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzely
 *  com.google.android.gms.internal.ads.zzelz
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzels;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzely;
import com.google.android.gms.internal.ads.zzelz;

public final class zzelt {
    private final zzely<zzcxg> zza;
    private final String zzb;
    private zzbgz zzc;

    public zzelt(zzely<zzcxg> zzely2, String string) {
        this.zza = zzely2;
        this.zzb = string;
    }

    static /* synthetic */ zzbgz zza(zzelt zzelt2, zzbgz zzbgz2) {
        zzelt2.zzc = zzbgz2;
        return zzbgz2;
    }

    public final boolean zzb() throws RemoteException {
        synchronized (this) {
            boolean bl = this.zza.zzb();
            return bl;
        }
    }

    public final void zzc(zzbdg zzbdg2, int n) throws RemoteException {
        synchronized (this) {
            this.zzc = null;
            zzelz zzelz2 = new zzelz(n);
            zzely<zzcxg> zzely2 = this.zza;
            String string = this.zzb;
            zzels zzels2 = new zzels(this);
            zzely2.zza(zzbdg2, string, (zzelw)zzelz2, (zzelx)zzels2);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final String zzd() {
        // MONITORENTER : this
        String string = null;
        try {
            zzbgz zzbgz2 = this.zzc;
            if (zzbgz2 != null) {
                string = zzbgz2.zze();
            }
            // MONITOREXIT : this
            return string;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            // MONITOREXIT : this
            return null;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final String zze() {
        // MONITORENTER : this
        String string = null;
        try {
            zzbgz zzbgz2 = this.zzc;
            if (zzbgz2 != null) {
                string = zzbgz2.zze();
            }
            // MONITOREXIT : this
            return string;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            // MONITOREXIT : this
            return null;
        }
    }
}
