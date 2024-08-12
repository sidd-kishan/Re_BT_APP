/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.util.CollectionUtils
 *  com.google.android.gms.internal.ads.zzbhb
 *  com.google.android.gms.internal.ads.zzbhf
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbnp
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcnf
 *  com.google.android.gms.internal.ads.zzcng
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbnp;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcnf;
import com.google.android.gms.internal.ads.zzcng;
import java.util.HashMap;
import java.util.Map;

public final class zzcnh
extends zzbhb {
    private final zzcjb zza;
    private final Object zzb = new Object();
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private zzbhf zzf;
    private boolean zzg;
    private boolean zzh = true;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbnp zzn;

    public zzcnh(zzcjb zzcjb2, float f, boolean bl, boolean bl2) {
        this.zza = zzcjb2;
        this.zzi = f;
        this.zzc = bl;
        this.zzd = bl2;
    }

    private final void zzw(String string, Map<String, String> map) {
        map = map == null ? new HashMap<String, String>() : new HashMap<String, String>(map);
        map.put("action", string);
        zzchg.zze.execute((Runnable)new zzcnf(this, map));
    }

    private final void zzx(int n, int n2, boolean bl, boolean bl2) {
        zzchg.zze.execute((Runnable)new zzcng(this, n, n2, bl, bl2));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc(zzbis object) {
        boolean bl = object.zza;
        boolean bl2 = object.zzb;
        boolean bl3 = object.zzc;
        object = this.zzb;
        synchronized (object) {
            this.zzl = bl2;
            this.zzm = bl3;
        }
        object = true != bl ? "0" : "1";
        String string = true != bl2 ? "0" : "1";
        String string2 = true != bl3 ? "0" : "1";
        this.zzw("initialState", CollectionUtils.mapOf((Object)"muteStart", (Object)object, (Object)"customControlsRequested", (Object)string, (Object)"clickToExpandRequested", (Object)string2));
    }

    public final void zzd(float f) {
        Object object = this.zzb;
        synchronized (object) {
            this.zzj = f;
            return;
        }
    }

    public final void zze() {
        this.zzw("play", null);
    }

    public final void zzf() {
        this.zzw("pause", null);
    }

    public final void zzg(boolean bl) {
        String string = true != bl ? "unmute" : "mute";
        this.zzw(string, null);
    }

    public final boolean zzh() {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl = this.zzh;
            return bl;
        }
    }

    public final int zzi() {
        Object object = this.zzb;
        synchronized (object) {
            int n = this.zze;
            return n;
        }
    }

    public final float zzj() {
        Object object = this.zzb;
        synchronized (object) {
            float f = this.zzi;
            return f;
        }
    }

    public final float zzk() {
        Object object = this.zzb;
        synchronized (object) {
            float f = this.zzj;
            return f;
        }
    }

    public final void zzl(zzbhf zzbhf2) {
        Object object = this.zzb;
        synchronized (object) {
            this.zzf = zzbhf2;
            return;
        }
    }

    public final float zzm() {
        Object object = this.zzb;
        synchronized (object) {
            float f = this.zzk;
            return f;
        }
    }

    public final boolean zzn() {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl;
            boolean bl2 = this.zzc;
            boolean bl3 = bl = false;
            if (!bl2) return bl3;
            bl3 = bl;
            if (!this.zzl) return bl3;
            bl3 = true;
            return bl3;
        }
    }

    public final zzbhf zzo() throws RemoteException {
        Object object = this.zzb;
        synchronized (object) {
            zzbhf zzbhf2 = this.zzf;
            return zzbhf2;
        }
    }

    public final boolean zzp() {
        boolean bl = this.zzn();
        Object object = this.zzb;
        synchronized (object) {
            boolean bl2;
            boolean bl3 = bl2 = false;
            if (bl) return bl3;
            bl3 = bl2;
            try {
                if (!this.zzm) return bl3;
                bl3 = bl2;
                if (!this.zzd) return bl3;
                bl3 = true;
                return bl3;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final void zzq() {
        this.zzw("stop", null);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzr() {
        int n;
        boolean bl;
        Object object = this.zzb;
        synchronized (object) {
            bl = this.zzh;
            n = this.zze;
            this.zze = 3;
        }
        this.zzx(n, 3, bl, bl);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void zzs(float f, float f2, int n, boolean bl, float f3) {
        int n2;
        Object object = this.zzb;
        // MONITORENTER : object
        float f4 = this.zzi;
        int n3 = n2 = 1;
        if (f2 == f4) {
            n3 = f3 != this.zzk ? n2 : 0;
        }
        this.zzi = f2;
        this.zzj = f;
        boolean bl2 = this.zzh;
        this.zzh = bl;
        n2 = this.zze;
        this.zze = n;
        f = this.zzk;
        this.zzk = f3;
        if (Math.abs(f3 - f) > 1.0E-4f) {
            this.zza.zzH().invalidate();
        }
        // MONITOREXIT : object
        if (n3 != 0) {
            try {
                object = this.zzn;
                if (object != null) {
                    object.zze();
                }
            }
            catch (RemoteException remoteException) {
                zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        this.zzx(n2, n, bl2, bl);
    }

    /*
     * Unable to fully structure code
     */
    final /* synthetic */ void zzt(int var1_1, int var2_2, boolean var3_3, boolean var4_4) {
        var11_5 = this.zzb;
        synchronized (var11_5) {
            var10_6 = this.zzg;
            var9_7 = false;
            if (!var10_6 && var2_2 == 1) {
                var5_8 = 1;
                var6_9 = true;
            } else {
                var5_8 = var2_2;
                var6_9 = false;
            }
            if (var1_1 != var2_2 && var5_8 == 1) {
                var8_10 = 1;
                var7_11 = true;
            } else {
                var7_11 = false;
                var8_10 = var5_8;
            }
            var5_8 = var1_1 != var2_2 && var8_10 == 2 ? 1 : 0;
            var1_1 = var1_1 != var2_2 && var8_10 == 3 ? 1 : 0;
            if (var10_6 || var6_9) {
                var9_7 = true;
            }
            this.zzg = var9_7;
            if (!var6_9) ** GOTO lbl28
            try {
                var12_12 = this.zzf;
                if (var12_12 != null) {
                    var12_12.zze();
                }
lbl28:
                // 4 sources

                if (var7_11 && (var12_12 = this.zzf) != null) {
                    var12_12.zzf();
                }
                if (var5_8 != 0 && (var12_12 = this.zzf) != null) {
                    var12_12.zzg();
                }
                if (var1_1 != 0) {
                    var12_12 = this.zzf;
                    if (var12_12 != null) {
                        var12_12.zzh();
                    }
                    this.zza.zzA();
                }
                if (var3_3 == var4_4) return;
                var12_12 = this.zzf;
                if (var12_12 == null) return;
                var12_12.zzi(var4_4);
            }
            catch (RemoteException var12_13) {}
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var12_13);
            return;
        }
    }

    final /* synthetic */ void zzu(Map map) {
        this.zza.zze("pubVideoCmd", map);
    }

    public final void zzv(zzbnp zzbnp2) {
        Object object = this.zzb;
        synchronized (object) {
            this.zzn = zzbnp2;
            return;
        }
    }
}
