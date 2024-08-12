/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbld
 *  com.google.android.gms.internal.ads.zzcbx
 */
package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzcbx;

public final class zzcgf {
    long zza = -1L;
    long zzb = -1L;
    int zzc = -1;
    int zzd = -1;
    long zze = 0L;
    final String zzf;
    int zzg = 0;
    int zzh = 0;
    private final Object zzi = new Object();
    private final zzg zzj;

    public zzcgf(String string, zzg zzg2) {
        this.zzf = string;
        this.zzj = zzg2;
    }

    private final void zzg() {
        if ((Boolean)zzbld.zza.zze() == false) return;
        Object object = this.zzi;
        synchronized (object) {
            --this.zzc;
            --this.zzd;
            return;
        }
    }

    public final void zza() {
        Object object = this.zzi;
        synchronized (object) {
            ++this.zzg;
            return;
        }
    }

    public final void zzb() {
        Object object = this.zzi;
        synchronized (object) {
            ++this.zzh;
            return;
        }
    }

    public final void zzc(zzbdg zzbdg2, long l) {
        Object object = this.zzi;
        synchronized (object) {
            int n;
            long l2 = this.zzj.zzr();
            long l3 = zzt.zzj().currentTimeMillis();
            if (this.zzb == -1L) {
                zzbjd zzbjd2 = zzbjl.zzaE;
                this.zzd = l3 - l2 > (Long)zzbet.zzc().zzc(zzbjd2) ? -1 : this.zzj.zzt();
                this.zzb = l;
                this.zza = l;
            } else {
                this.zza = l;
            }
            zzbdg2 = zzbdg2.zzc;
            if (zzbdg2 != null) {
                if (zzbdg2.getInt("gw", 2) == 1) return;
            }
            ++this.zzc;
            this.zzd = n = this.zzd + 1;
            if (n == 0) {
                this.zze = 0L;
                this.zzj.zzu(l3);
            } else {
                this.zze = l3 - this.zzj.zzv();
            }
            return;
        }
    }

    public final void zzd() {
        this.zzg();
    }

    public final void zze() {
        this.zzg();
    }

    public final Bundle zzf(Context context, String string) {
        Object object = this.zzi;
        synchronized (object) {
            Bundle bundle = new Bundle();
            String string2 = this.zzj.zzC() ? "" : this.zzf;
            bundle.putString("session_id", string2);
            bundle.putLong("basets", this.zzb);
            bundle.putLong("currts", this.zza);
            bundle.putString("seq_num", string);
            bundle.putInt("preqs", this.zzc);
            bundle.putInt("preqs_in_session", this.zzd);
            bundle.putLong("time_in_session", this.zze);
            bundle.putInt("pclick", this.zzg);
            bundle.putInt("pimp", this.zzh);
            context = zzcbx.zza((Context)context);
            int n = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
            boolean bl = false;
            if (n == 0) {
                com.google.android.gms.ads.internal.util.zze.zzh((String)"Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            } else {
                string = new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity");
                try {
                    if (n == context.getPackageManager().getActivityInfo((ComponentName)string, (int)0).theme) {
                        bl = true;
                    } else {
                        com.google.android.gms.ads.internal.util.zze.zzh((String)"Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"Fail to fetch AdActivity theme");
                    com.google.android.gms.ads.internal.util.zze.zzh((String)"Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                }
            }
            bundle.putBoolean("support_transparent_background", bl);
            return bundle;
        }
    }
}
