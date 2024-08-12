/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbny
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcwn
 *  com.google.android.gms.internal.ads.zzcwo
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzfaa
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcwn;
import com.google.android.gms.internal.ads.zzcwo;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzfaa;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcwp
extends zzcvh {
    private final zzbny zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzcwp(zzcxf zzcxf2, zzbny zzbny2, Runnable runnable, Executor executor) {
        super(zzcxf2);
        this.zzc = zzbny2;
        this.zzd = runnable;
        this.zze = executor;
    }

    public final void zzS() {
        zzcwn zzcwn2 = new zzcwn(new AtomicReference<Runnable>(this.zzd));
        this.zze.execute((Runnable)new zzcwo(this, (Runnable)zzcwn2));
    }

    public final View zza() {
        return null;
    }

    public final void zzb(ViewGroup viewGroup, zzbdl zzbdl2) {
    }

    public final zzbhc zzc() {
        return null;
    }

    public final zzfaa zze() {
        return null;
    }

    public final zzfaa zzf() {
        return null;
    }

    public final int zzg() {
        return 0;
    }

    public final void zzh() {
    }

    final /* synthetic */ void zzj(Runnable runnable) {
        try {
            if (this.zzc.zzb(ObjectWrapper.wrap((Object)runnable))) return;
            runnable.run();
            return;
        }
        catch (RemoteException remoteException) {
            runnable.run();
            return;
        }
    }
}
