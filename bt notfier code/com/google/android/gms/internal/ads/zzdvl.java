/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzdve
 *  com.google.android.gms.internal.ads.zzdvk
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfet
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzdvk;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzdvl
implements zzfet {
    private final Map<zzfem, Long> zza;
    private final zzdve zzb;
    private final Clock zzc;
    private final Map<zzfem, zzdvk> zzd;

    public zzdvl(zzdve object, Set<zzdvk> zzdvk2, Clock clock) {
        this.zzb = object;
        this.zza = new HashMap<zzfem, Long>();
        this.zzd = new HashMap<zzfem, zzdvk>();
        object = zzdvk2.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.zzc = clock;
                return;
            }
            zzdvk2 = (zzdvk)object.next();
            this.zzd.put(zzdvk.zzc((zzdvk)zzdvk2), zzdvk2);
        }
    }

    private final void zze(zzfem object, boolean bl) {
        Object object2 = zzdvk.zzb((zzdvk)this.zzd.get(object));
        String string = true != bl ? "f." : "s.";
        if (!this.zza.containsKey(object2)) return;
        long l = this.zzc.elapsedRealtime();
        long l2 = this.zza.get(object2);
        object2 = this.zzb.zzc();
        object = ((String)(object = zzdvk.zza((zzdvk)this.zzd.get(object)))).length() != 0 ? "label.".concat((String)object) : new String("label.");
        String string2 = String.valueOf(Long.toString(l - l2));
        string = string2.length() != 0 ? string.concat(string2) : new String(string);
        object2.put(object, string);
    }

    public final void zzbE(zzfem zzfem2, String string) {
    }

    public final void zzbF(zzfem zzfem2, String string) {
        this.zza.put(zzfem2, this.zzc.elapsedRealtime());
    }

    public final void zzc(zzfem zzfem2, String string, Throwable object) {
        if (this.zza.containsKey(zzfem2)) {
            long l = this.zzc.elapsedRealtime();
            long l2 = this.zza.get(zzfem2);
            Map map = this.zzb.zzc();
            string = (string = String.valueOf(string)).length() != 0 ? "task.".concat(string) : new String("task.");
            object = String.valueOf(Long.toString(l - l2));
            object = ((String)object).length() != 0 ? "f.".concat((String)object) : new String("f.");
            map.put(string, object);
        }
        if (!this.zzd.containsKey(zzfem2)) return;
        this.zze(zzfem2, false);
    }

    public final void zzd(zzfem zzfem2, String string) {
        if (this.zza.containsKey(zzfem2)) {
            long l = this.zzc.elapsedRealtime();
            long l2 = this.zza.get(zzfem2);
            Map map = this.zzb.zzc();
            string = (string = String.valueOf(string)).length() != 0 ? "task.".concat(string) : new String("task.");
            String string2 = String.valueOf(Long.toString(l - l2));
            string2 = string2.length() != 0 ? "s.".concat(string2) : new String("s.");
            map.put(string, string2);
        }
        if (!this.zzd.containsKey(zzfem2)) return;
        this.zze(zzfem2, true);
    }
}
