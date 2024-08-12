/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzecg
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfet
 *  com.google.android.gms.internal.ads.zzffb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecg;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfet;
import com.google.android.gms.internal.ads.zzffb;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzech
implements zzfet {
    private final Map<zzfem, String> zza;
    private final Map<zzfem, String> zzb;
    private final zzffb zzc;

    public zzech(Set<zzecg> object, zzffb zzffb2) {
        this.zzc = zzffb2;
        this.zza = new HashMap<zzfem, String>();
        this.zzb = new HashMap<zzfem, String>();
        object = object.iterator();
        while (object.hasNext()) {
            zzffb2 = (zzecg)object.next();
            this.zza.put(zzecg.zzb((zzecg)zzffb2), zzecg.zza((zzecg)zzffb2));
            this.zzb.put(zzecg.zzc((zzecg)zzffb2), zzecg.zza((zzecg)zzffb2));
        }
    }

    public final void zzbE(zzfem zzfem2, String string) {
    }

    public final void zzbF(zzfem object, String string) {
        zzffb zzffb2 = this.zzc;
        string = (string = String.valueOf(string)).length() != 0 ? "task.".concat(string) : new String("task.");
        zzffb2.zzd(string);
        if (!this.zza.containsKey(object)) return;
        string = this.zzc;
        object = ((String)(object = String.valueOf(this.zza.get(object)))).length() != 0 ? "label.".concat((String)object) : new String("label.");
        string.zzd((String)object);
    }

    public final void zzc(zzfem object, String string, Throwable throwable) {
        throwable = this.zzc;
        string = (string = String.valueOf(string)).length() != 0 ? "task.".concat(string) : new String("task.");
        throwable.zze(string, "f.");
        if (!this.zzb.containsKey(object)) return;
        string = this.zzc;
        object = ((String)(object = String.valueOf(this.zzb.get(object)))).length() != 0 ? "label.".concat((String)object) : new String("label.");
        string.zze((String)object, "f.");
    }

    public final void zzd(zzfem object, String string) {
        zzffb zzffb2 = this.zzc;
        string = (string = String.valueOf(string)).length() != 0 ? "task.".concat(string) : new String("task.");
        zzffb2.zze(string, "s.");
        if (!this.zzb.containsKey(object)) return;
        string = this.zzc;
        object = ((String)(object = String.valueOf(this.zzb.get(object)))).length() != 0 ? "label.".concat((String)object) : new String("label.");
        string.zze((String)object, "s.");
    }
}
