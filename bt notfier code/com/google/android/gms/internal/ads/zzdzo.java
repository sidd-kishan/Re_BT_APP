/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdzp
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdzp;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfrz;
import java.util.regex.Matcher;

final class zzdzo
implements zzfrz<zzfal> {
    final zzdzp zza;

    zzdzo(zzdzp zzdzp2) {
        this.zza = zzdzp2;
    }

    public final void zza(Throwable object) {
        zzbjd zzbjd2 = zzbjl.zzex;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        object = zzdzp.zzb().matcher(((Throwable)object).getMessage());
        if (!((Matcher)object).matches()) return;
        object = ((Matcher)object).group(1);
        zzdzp.zza((zzdzp)this.zza).zza(Integer.parseInt((String)object));
    }
}
