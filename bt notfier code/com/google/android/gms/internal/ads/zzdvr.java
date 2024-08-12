/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdvn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdvn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzdvr {
    private final zzg zza;
    private final List<Map<String, String>> zzb = new ArrayList<Map<String, String>>();
    private boolean zzc = false;
    private boolean zzd = false;
    private final String zze;
    private final zzdvn zzf;

    public zzdvr(String string, zzdvn zzdvn2) {
        this.zze = string;
        this.zzf = zzdvn2;
        this.zza = zzt.zzg().zzp();
    }

    private final Map<String, String> zzf() {
        Map map = this.zzf.zza();
        map.put("tms", Long.toString(zzt.zzj().elapsedRealtime(), 10));
        String string = this.zza.zzC() ? "" : this.zze;
        map.put("tid", string);
        return map;
    }

    public final void zza(String string) {
        synchronized (this) {
            Object object = zzbjl.zzbr;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
            object = zzbjl.zzgi;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                return;
            }
            object = this.zzf();
            object.put("action", "adapter_init_started");
            object.put("ancn", string);
            this.zzb.add((Map<String, String>)object);
            return;
        }
    }

    public final void zzb(String string) {
        synchronized (this) {
            Object object = zzbjl.zzbr;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
            object = zzbjl.zzgi;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                return;
            }
            object = this.zzf();
            object.put("action", "adapter_init_finished");
            object.put("ancn", string);
            this.zzb.add((Map<String, String>)object);
            return;
        }
    }

    public final void zzc(String string, String string2) {
        synchronized (this) {
            Object object = zzbjl.zzbr;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
            object = zzbjl.zzgi;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                return;
            }
            object = this.zzf();
            object.put("action", "adapter_init_finished");
            object.put("ancn", string);
            object.put("rqe", string2);
            this.zzb.add((Map<String, String>)object);
            return;
        }
    }

    public final void zzd() {
        synchronized (this) {
            Object object = zzbjl.zzbr;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
            object = zzbjl.zzgi;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                return;
            }
            if (this.zzc) return;
            object = this.zzf();
            object.put("action", "init_started");
            this.zzb.add((Map<String, String>)object);
            this.zzc = true;
            return;
        }
    }

    public final void zze() {
        synchronized (this) {
            try {
                Object object = zzbjl.zzbr;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
                object = zzbjl.zzgi;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                    return;
                }
                if (this.zzd) return;
                object = this.zzf();
                object.put("action", "init_finished");
                this.zzb.add((Map<String, String>)object);
                Iterator<Map<String, String>> iterator = this.zzb.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.zzd = true;
                        return;
                    }
                    object = iterator.next();
                    this.zzf.zzb((Map)object);
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
