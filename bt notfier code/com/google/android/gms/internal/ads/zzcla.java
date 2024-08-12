/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.api.Releasable
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcks
 *  com.google.android.gms.internal.ads.zzckv
 *  com.google.android.gms.internal.ads.zzckw
 *  com.google.android.gms.internal.ads.zzckx
 *  com.google.android.gms.internal.ads.zzcky
 *  com.google.android.gms.internal.ads.zzckz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcks;
import com.google.android.gms.internal.ads.zzckv;
import com.google.android.gms.internal.ads.zzckw;
import com.google.android.gms.internal.ads.zzckx;
import com.google.android.gms.internal.ads.zzcky;
import com.google.android.gms.internal.ads.zzckz;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class zzcla
implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference<zzcjb> zzc;

    public zzcla(zzcjb zzcjb2) {
        this.zza = zzcjb2.getContext();
        this.zzb = zzt.zzc().zzi(this.zza, zzcjb2.zzt().zza);
        this.zzc = new WeakReference<zzcjb>(zzcjb2);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzs(zzcla zzcla2, String string, Map map) {
        zzcla2 = (zzcjb)zzcla2.zzc.get();
        if (zzcla2 == null) return;
        zzcla2.zze("onPrecacheEvent", map);
    }

    public void release() {
    }

    public abstract boolean zzd(String var1);

    public boolean zze(String string, String[] stringArray) {
        return this.zzd(string);
    }

    public boolean zzf(String string, String[] stringArray, zzcks zzcks2) {
        return this.zzd(string);
    }

    protected void zzg(int n) {
    }

    protected void zzh(int n) {
    }

    protected void zzi(int n) {
    }

    protected void zzl(int n) {
    }

    public abstract void zzm();

    public final void zzn(String string, String string2, long l, long l2, boolean bl, long l3, long l4, long l5, int n, int n2) {
        zzcgm.zza.post((Runnable)new zzckv(this, string, string2, l, l2, l3, l4, l5, bl, n, n2));
    }

    public final void zzo(String string, String string2, int n, int n2, long l, long l2, boolean bl, int n3, int n4) {
        zzcgm.zza.post((Runnable)new zzckw(this, string, string2, n, n2, l, l2, bl, n3, n4));
    }

    protected final void zzp(String string, String string2, int n) {
        zzcgm.zza.post((Runnable)new zzckx(this, string, string2, n));
    }

    public final void zzq(String string, String string2, long l) {
        zzcgm.zza.post((Runnable)new zzcky(this, string, string2, l));
    }

    public final void zzr(String string, String string2, String string3, String string4) {
        zzcgm.zza.post((Runnable)new zzckz(this, string, string2, string3, string4));
    }
}
