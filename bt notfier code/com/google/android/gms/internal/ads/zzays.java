/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzaym
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzayp
 *  com.google.android.gms.internal.ads.zzayu
 *  com.google.android.gms.internal.ads.zzayv
 *  com.google.android.gms.internal.ads.zzayx
 *  com.google.android.gms.internal.ads.zzayz
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzaym;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzayx;
import com.google.android.gms.internal.ads.zzayz;
import com.google.android.gms.internal.ads.zzchl;
import java.io.IOException;
import java.io.InputStream;

final class zzays
implements Runnable {
    private final zzayv zza;
    private final zzaym zzb;
    private final zzayn zzc;
    private final zzchl zzd;

    zzays(zzayv zzayv2, zzaym zzaym2, zzayn zzayn2, zzchl zzchl2) {
        this.zza = zzayv2;
        this.zzb = zzaym2;
        this.zzc = zzayn2;
        this.zzd = zzchl2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void run() {
        void var2_5;
        zzayv zzayv2 = this.zza;
        Object object = this.zzb;
        zzayn zzayn2 = this.zzc;
        zzchl zzchl2 = this.zzd;
        try {
            zzayp zzayp2 = object.zzq();
            object = object.zzp() ? zzayp2.zzf(zzayn2) : zzayp2.zze(zzayn2);
            if (!object.zza()) {
                object = new RuntimeException("No entry contents.");
                zzchl2.zzd((Throwable)object);
                zzayx.zzf((zzayx)zzayv2.zzc);
                return;
            }
            zzayn2 = new zzayu(zzayv2, object.zzb(), 1);
            int n = zzayn2.read();
            if (n != -1) {
                zzayn2.unread(n);
                zzchl2.zzc((Object)zzayz.zza((InputStream)zzayn2, (boolean)object.zzd(), (boolean)object.zzg(), (long)object.zzf(), (boolean)object.zze()));
                return;
            }
            object = new IOException("Unable to read from cache.");
            throw object;
        }
        catch (RemoteException remoteException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        zze.zzg((String)"Unable to obtain a cache service instance.", (Throwable)var2_5);
        zzchl2.zzd((Throwable)var2_5);
        zzayx.zzf((zzayx)zzayv2.zzc);
    }
}
