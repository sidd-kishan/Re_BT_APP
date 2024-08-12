/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zze
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdbg
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdfx
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzdvh
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzeds
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfbe
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdbg;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdfx;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzeds;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfbe;
import java.util.regex.Pattern;

public final class zzdut
implements zzdfx,
zzbcv,
zzdbw,
zzdbg {
    private final Context zza;
    private final zzfbe zzb;
    private final zzdvi zzc;
    private final zzfal zzd;
    private final zzezz zze;
    private final zzedq zzf;
    private Boolean zzg;
    private final boolean zzh;

    public zzdut(Context context, zzfbe zzfbe2, zzdvi zzdvi2, zzfal zzfal2, zzezz zzezz2, zzedq zzedq2) {
        this.zza = context;
        this.zzb = zzfbe2;
        this.zzc = zzdvi2;
        this.zzd = zzfal2;
        this.zze = zzezz2;
        this.zzf = zzedq2;
        context = zzbjl.zzfc;
        this.zzh = (Boolean)zzbet.zzc().zzc((zzbjd)context);
    }

    private final boolean zzf() {
        if (this.zzg != null) return this.zzg;
        synchronized (this) {
            boolean bl;
            if (this.zzg != null) return this.zzg;
            Object object = zzbjl.zzaY;
            String string = (String)zzbet.zzc().zzc(object);
            zzt.zzc();
            object = zzs.zzv((Context)this.zza);
            boolean bl2 = bl = false;
            if (string != null) {
                if (object == null) {
                    bl2 = bl;
                } else {
                    try {
                        bl2 = Pattern.matches(string, (CharSequence)object);
                    }
                    catch (RuntimeException runtimeException) {
                        zzt.zzg().zzk((Throwable)runtimeException, "CsiActionsListener.isPatternMatched");
                        bl2 = bl;
                    }
                }
            }
            this.zzg = bl2;
        }
        return this.zzg;
    }

    private final zzdvh zzh(String string) {
        zzdvh zzdvh2 = this.zzc.zzd();
        zzdvh2.zzb(this.zzd.zzb.zzb);
        zzdvh2.zzc(this.zze);
        zzdvh2.zzd("action", string);
        if (!this.zze.zzt.isEmpty()) {
            zzdvh2.zzd("ancn", (String)this.zze.zzt.get(0));
        }
        if (this.zze.zzaf) {
            zzt.zzc();
            string = true != zzs.zzI((Context)this.zza) ? "offline" : "online";
            zzdvh2.zzd("device_connectivity", string);
            zzdvh2.zzd("event_timestamp", String.valueOf(zzt.zzj().currentTimeMillis()));
            zzdvh2.zzd("offline_ad", "1");
        }
        string = zzbjl.zzfl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string) == false) return zzdvh2;
        boolean bl = com.google.android.gms.ads.nonagon.signalgeneration.zze.zza((zzfal)this.zzd);
        zzdvh2.zzd("scar", String.valueOf(bl));
        if (!bl) return zzdvh2;
        string = com.google.android.gms.ads.nonagon.signalgeneration.zze.zzb((zzfal)this.zzd);
        if (!TextUtils.isEmpty((CharSequence)string)) {
            zzdvh2.zzd("ragent", string);
        }
        if (TextUtils.isEmpty((CharSequence)(string = com.google.android.gms.ads.nonagon.signalgeneration.zze.zzc((zzfal)this.zzd)))) return zzdvh2;
        zzdvh2.zzd("rtype", string);
        return zzdvh2;
    }

    private final void zzi(zzdvh object) {
        if (this.zze.zzaf) {
            object = object.zzf();
            object = new zzeds(zzt.zzj().currentTimeMillis(), this.zzd.zzb.zzb.zzb, (String)object, 2);
            this.zzf.zze((zzeds)object);
            return;
        }
        object.zze();
    }

    public final void onAdClicked() {
        if (!this.zze.zzaf) {
            return;
        }
        this.zzi(this.zzh("click"));
    }

    public final void zza(zzbcz object) {
        if (!this.zzh) {
            return;
        }
        zzdvh zzdvh2 = this.zzh("ifts");
        zzdvh2.zzd("reason", "adapter");
        int n = object.zza;
        String string = object.zzb;
        int n2 = n;
        String string2 = string;
        if (object.zzc.equals("com.google.android.gms.ads")) {
            zzbcz zzbcz2 = object.zzd;
            n2 = n;
            string2 = string;
            if (zzbcz2 != null) {
                n2 = n;
                string2 = string;
                if (!zzbcz2.zzc.equals("com.google.android.gms.ads")) {
                    object = object.zzd;
                    n2 = object.zza;
                    string2 = object.zzb;
                }
            }
        }
        if (n2 >= 0) {
            zzdvh2.zzd("arec", String.valueOf(n2));
        }
        if ((object = this.zzb.zza(string2)) != null) {
            zzdvh2.zzd("areec", (String)object);
        }
        zzdvh2.zze();
    }

    public final void zzb(zzdkm zzdkm2) {
        if (!this.zzh) {
            return;
        }
        zzdvh zzdvh2 = this.zzh("ifts");
        zzdvh2.zzd("reason", "exception");
        if (!TextUtils.isEmpty((CharSequence)zzdkm2.getMessage())) {
            zzdvh2.zzd("msg", zzdkm2.getMessage());
        }
        zzdvh2.zze();
    }

    public final void zzc() {
        if (!this.zzf()) {
            return;
        }
        this.zzh("adapter_impression").zze();
    }

    public final void zzd() {
        if (!this.zzh) {
            return;
        }
        zzdvh zzdvh2 = this.zzh("ifts");
        zzdvh2.zzd("reason", "blocked");
        zzdvh2.zze();
    }

    public final void zze() {
        if (!this.zzf()) {
            return;
        }
        this.zzh("adapter_shown").zze();
    }

    public final void zzg() {
        if (!this.zzf() && !this.zze.zzaf) {
            return;
        }
        this.zzi(this.zzh("impression"));
    }
}
