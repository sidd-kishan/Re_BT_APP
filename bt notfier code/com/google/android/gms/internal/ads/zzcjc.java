/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzbf
 *  com.google.android.gms.ads.internal.util.zzbg
 *  com.google.android.gms.ads.internal.util.zzbi
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbjs
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbka
 *  com.google.android.gms.internal.ads.zzbll
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcii
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzbi;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbjs;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbll;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcii;
import java.util.concurrent.TimeUnit;

public final class zzcjc {
    private final Context zza;
    private final String zzb;
    private final zzcgz zzc;
    private final zzbjx zzd;
    private final zzbka zze;
    private final zzbi zzf;
    private final long[] zzg;
    private final String[] zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private zzcii zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;

    public zzcjc(Context stringArray, zzcgz zzcgz2, String string, zzbka zzbka2, zzbjx zzbjx2) {
        zzbg zzbg2 = new zzbg();
        zzbg2.zzd("min_1", Double.MIN_VALUE, 1.0);
        zzbg2.zzd("1_5", 1.0, 5.0);
        zzbg2.zzd("5_10", 5.0, 10.0);
        zzbg2.zzd("10_20", 10.0, 20.0);
        zzbg2.zzd("20_30", 20.0, 30.0);
        zzbg2.zzd("30_max", 30.0, Double.MAX_VALUE);
        this.zzf = zzbg2.zze();
        int n = 0;
        this.zzi = false;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzq = -1L;
        this.zza = stringArray;
        this.zzc = zzcgz2;
        this.zzb = string;
        this.zze = zzbka2;
        this.zzd = zzbjx2;
        stringArray = zzbjl.zzv;
        stringArray = (String)zzbet.zzc().zzc((zzbjd)stringArray);
        if (stringArray == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        stringArray = TextUtils.split((String)stringArray, (String)",");
        int n2 = stringArray.length;
        this.zzh = new String[n2];
        this.zzg = new long[n2];
        while (n < stringArray.length) {
            try {
                this.zzg[n] = Long.parseLong(stringArray[n]);
            }
            catch (NumberFormatException numberFormatException) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Unable to parse frame hash target time number.", (Throwable)numberFormatException);
                this.zzg[n] = -1L;
            }
            ++n;
        }
    }

    public final void zza(zzcii zzcii2) {
        zzbjs.zza((zzbka)this.zze, (zzbjx)this.zzd, (String[])new String[]{"vpc2"});
        this.zzi = true;
        this.zze.zzd("vpn", zzcii2.zzd());
        this.zzn = zzcii2;
    }

    public final void zzb() {
        if (!this.zzi) return;
        if (this.zzj) return;
        zzbjs.zza((zzbka)this.zze, (zzbjx)this.zzd, (String[])new String[]{"vfr2"});
        this.zzj = true;
    }

    public final void zzc() {
        String string;
        if ((Boolean)zzbll.zza.zze() == false) return;
        if (this.zzo) return;
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.zzb);
        bundle.putString("player", this.zzn.zzd());
        Object object = this.zzf.zzb().iterator();
        while (object.hasNext()) {
            zzbf zzbf2 = (zzbf)object.next();
            string = String.valueOf(zzbf2.zza);
            string = string.length() != 0 ? "fps_c_".concat(string) : new String("fps_c_");
            bundle.putString(string, Integer.toString(zzbf2.zze));
            string = String.valueOf(zzbf2.zza);
            string = string.length() != 0 ? "fps_p_".concat(string) : new String("fps_p_");
            bundle.putString(string, Double.toString(zzbf2.zzd));
        }
        int n = 0;
        while (true) {
            if (n >= ((Object)(object = (Object)this.zzg)).length) {
                zzt.zzc().zzn(this.zza, this.zzc.zza, "gmob-apps", bundle, true);
                this.zzo = true;
                return;
            }
            string = this.zzh[n];
            if (string != null) {
                bundle.putString("fh_".concat(((Object)((long)object[n])).toString()), string);
            }
            ++n;
        }
    }

    public final void zzd(zzcii zzcii2) {
        String[] stringArray;
        long l;
        long l2;
        long l3;
        block8: {
            if (this.zzk && !this.zzl) {
                if (com.google.android.gms.ads.internal.util.zze.zzc() && !this.zzl) {
                    com.google.android.gms.ads.internal.util.zze.zza((String)"VideoMetricsMixin first frame");
                }
                zzbjs.zza((zzbka)this.zze, (zzbjx)this.zzd, (String[])new String[]{"vff2"});
                this.zzl = true;
            }
            l3 = zzt.zzj().nanoTime();
            if (this.zzm && this.zzp && this.zzq != -1L) {
                l2 = TimeUnit.SECONDS.toNanos(1L);
                l = this.zzq;
                stringArray = this.zzf;
                double d = l2;
                double d2 = l3 - l;
                Double.isNaN(d);
                Double.isNaN(d2);
                stringArray.zza(d / d2);
            }
            this.zzp = this.zzm;
            this.zzq = l3;
            stringArray = zzbjl.zzw;
            l3 = (Long)zzbet.zzc().zzc((zzbjd)stringArray);
            l = zzcii2.zzk();
            int n = 0;
            while (n < (stringArray = this.zzh).length) {
                if (stringArray[n] != null || l3 <= Math.abs(l - this.zzg[n])) {
                    ++n;
                    continue;
                }
                break block8;
            }
            return;
        }
        stringArray = this.zzh;
        zzcii2 = zzcii2.getBitmap(8, 8);
        l3 = 63L;
        l = 0L;
        int n = 0;
        while (true) {
            if (n >= 8) {
                stringArray[n] = String.format("%016X", l);
                return;
            }
            for (int i = 0; i < 8; l |= l2 << (int)l3, ++i, --l3) {
                int n2 = zzcii2.getPixel(i, n);
                l2 = Color.blue((int)n2) + Color.red((int)n2) + Color.green((int)n2) > 128 ? 1L : 0L;
            }
            ++n;
        }
    }

    public final void zze() {
        this.zzm = true;
        if (!this.zzj) return;
        if (this.zzk) return;
        zzbjs.zza((zzbka)this.zze, (zzbjx)this.zzd, (String[])new String[]{"vfp2"});
        this.zzk = true;
    }

    public final void zzf() {
        this.zzm = false;
    }
}
