/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbup
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcti
 *  com.google.android.gms.internal.ads.zzctk
 *  com.google.android.gms.internal.ads.zzctq
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcti;
import com.google.android.gms.internal.ads.zzctk;
import com.google.android.gms.internal.ads.zzctq;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzctl {
    private final String zza;
    private final zzbup zzb;
    private final Executor zzc;
    private zzctq zzd;
    private final zzbpr<Object> zze = new zzcti(this);
    private final zzbpr<Object> zzf = new zzctk(this);

    public zzctl(String string, zzbup zzbup2, Executor executor) {
        this.zza = string;
        this.zzb = zzbup2;
        this.zzc = executor;
    }

    static /* synthetic */ Executor zza(zzctl zzctl2) {
        return zzctl2.zzc;
    }

    static /* synthetic */ zzctq zzb(zzctl zzctl2) {
        return zzctl2.zzd;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ boolean zzg(zzctl zzctl2, Map object) {
        if (object == null) {
            return false;
        }
        if (TextUtils.isEmpty((CharSequence)(object = (String)object.get("hashCode")))) return false;
        if (!((String)object).equals(zzctl2.zza)) return false;
        return true;
    }

    public final void zzc(zzctq zzctq2) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzctq2;
    }

    public final void zzd(zzcml zzcml2) {
        zzcml2.zzab("/updateActiveView", this.zze);
        zzcml2.zzab("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze(zzcml zzcml2) {
        zzcml2.zzac("/updateActiveView", this.zze);
        zzcml2.zzac("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }
}
