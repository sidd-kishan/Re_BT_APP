/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdbg
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdfx
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzeds
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfbe
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdbg;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdfx;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzeds;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfbe;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import java.util.regex.Pattern;

public final class zzeby
implements zzdfx,
zzbcv,
zzdbw,
zzdbg {
    private final Context zza;
    private final zzfbe zzb;
    private final zzfal zzc;
    private final zzezz zzd;
    private final zzedq zze;
    private Boolean zzf;
    private final boolean zzg;
    private final zzffc zzh;
    private final String zzi;

    public zzeby(Context context, zzfbe zzfbe2, zzfal zzfal2, zzezz zzezz2, zzedq zzedq2, zzffc zzffc2, String string) {
        this.zza = context;
        this.zzb = zzfbe2;
        this.zzc = zzfal2;
        this.zzd = zzezz2;
        this.zze = zzedq2;
        context = zzbjl.zzfc;
        this.zzg = (Boolean)zzbet.zzc().zzc((zzbjd)context);
        this.zzh = zzffc2;
        this.zzi = string;
    }

    private final boolean zzf() {
        if (this.zzf != null) return this.zzf;
        synchronized (this) {
            boolean bl;
            if (this.zzf != null) return this.zzf;
            Object object = zzbjl.zzaY;
            object = (String)zzbet.zzc().zzc(object);
            zzt.zzc();
            String string = zzs.zzv((Context)this.zza);
            boolean bl2 = bl = false;
            if (object != null) {
                if (string == null) {
                    bl2 = bl;
                } else {
                    try {
                        bl2 = Pattern.matches((String)object, string);
                    }
                    catch (RuntimeException runtimeException) {
                        zzt.zzg().zzk((Throwable)runtimeException, "CsiActionsListener.isPatternMatched");
                        bl2 = bl;
                    }
                }
            }
            this.zzf = bl2;
        }
        return this.zzf;
    }

    private final zzffb zzh(String string) {
        zzffb zzffb2 = zzffb.zza((String)string);
        zzffb2.zzg(this.zzc, null);
        zzffb2.zzi(this.zzd);
        zzffb2.zzc("request_id", this.zzi);
        if (!this.zzd.zzt.isEmpty()) {
            zzffb2.zzc("ancn", (String)this.zzd.zzt.get(0));
        }
        if (!this.zzd.zzaf) return zzffb2;
        zzt.zzc();
        string = true != zzs.zzI((Context)this.zza) ? "offline" : "online";
        zzffb2.zzc("device_connectivity", string);
        zzffb2.zzc("event_timestamp", String.valueOf(zzt.zzj().currentTimeMillis()));
        zzffb2.zzc("offline_ad", "1");
        return zzffb2;
    }

    private final void zzi(zzffb object) {
        if (this.zzd.zzaf) {
            object = this.zzh.zzb(object);
            object = new zzeds(zzt.zzj().currentTimeMillis(), this.zzc.zzb.zzb.zzb, (String)object, 2);
            this.zze.zze((zzeds)object);
            return;
        }
        this.zzh.zza(object);
    }

    public final void onAdClicked() {
        if (!this.zzd.zzaf) {
            return;
        }
        this.zzi(this.zzh("click"));
    }

    public final void zza(zzbcz zzbcz2) {
        if (!this.zzg) {
            return;
        }
        int n = zzbcz2.zza;
        String string = zzbcz2.zzb;
        int n2 = n;
        String string2 = string;
        if (zzbcz2.zzc.equals("com.google.android.gms.ads")) {
            zzbcz zzbcz3 = zzbcz2.zzd;
            n2 = n;
            string2 = string;
            if (zzbcz3 != null) {
                n2 = n;
                string2 = string;
                if (!zzbcz3.zzc.equals("com.google.android.gms.ads")) {
                    zzbcz2 = zzbcz2.zzd;
                    n2 = zzbcz2.zza;
                    string2 = zzbcz2.zzb;
                }
            }
        }
        string2 = this.zzb.zza(string2);
        zzbcz2 = this.zzh("ifts");
        zzbcz2.zzc("reason", "adapter");
        if (n2 >= 0) {
            zzbcz2.zzc("arec", String.valueOf(n2));
        }
        if (string2 != null) {
            zzbcz2.zzc("areec", string2);
        }
        this.zzh.zza((zzffb)zzbcz2);
    }

    public final void zzb(zzdkm zzdkm2) {
        if (!this.zzg) {
            return;
        }
        zzffb zzffb2 = this.zzh("ifts");
        zzffb2.zzc("reason", "exception");
        if (!TextUtils.isEmpty((CharSequence)zzdkm2.getMessage())) {
            zzffb2.zzc("msg", zzdkm2.getMessage());
        }
        this.zzh.zza(zzffb2);
    }

    public final void zzc() {
        if (!this.zzf()) {
            return;
        }
        this.zzh.zza(this.zzh("adapter_impression"));
    }

    public final void zzd() {
        if (!this.zzg) {
            return;
        }
        zzffc zzffc2 = this.zzh;
        zzffb zzffb2 = this.zzh("ifts");
        zzffb2.zzc("reason", "blocked");
        zzffc2.zza(zzffb2);
    }

    public final void zze() {
        if (!this.zzf()) {
            return;
        }
        this.zzh.zza(this.zzh("adapter_shown"));
    }

    public final void zzg() {
        if (!this.zzf() && !this.zzd.zzaf) {
            return;
        }
        this.zzi(this.zzh("impression"));
    }
}
