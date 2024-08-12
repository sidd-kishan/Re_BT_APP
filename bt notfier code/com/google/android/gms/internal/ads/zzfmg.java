/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflj
 *  com.google.android.gms.internal.ads.zzflk
 *  com.google.android.gms.internal.ads.zzfma
 *  com.google.android.gms.internal.ads.zzfmc
 *  com.google.android.gms.internal.ads.zzfmd
 *  com.google.android.gms.internal.ads.zzfmf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflj;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzfma;
import com.google.android.gms.internal.ads.zzfmc;
import com.google.android.gms.internal.ads.zzfmd;
import com.google.android.gms.internal.ads.zzfmf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzfmg {
    private final zzflk zza;
    private final zzfmf zzb;

    private zzfmg(zzfmf zzfmf2) {
        zzflj zzflj2 = zzflj.zza;
        this.zzb = zzfmf2;
        this.zza = zzflj2;
    }

    static /* synthetic */ zzflk zza(zzfmg zzfmg2) {
        return zzfmg2.zza;
    }

    public static zzfmg zzb(zzflk zzflk2) {
        return new zzfmg((zzfmf)new zzfma(zzflk2));
    }

    public static zzfmg zzc(int n) {
        return new zzfmg((zzfmf)new zzfmc(4000));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ Iterator zze(zzfmg zzfmg2, CharSequence charSequence) {
        return zzfmg2.zzg(charSequence);
    }

    private final Iterator<String> zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable<String> zzd(CharSequence charSequence) {
        if (charSequence == null) throw null;
        return new zzfmd(this, charSequence);
    }

    public final List<String> zzf(CharSequence object) {
        Iterator<String> iterator = this.zzg((CharSequence)object);
        object = new ArrayList();
        while (iterator.hasNext()) {
            object.add(iterator.next());
        }
        return Collections.unmodifiableList(object);
    }
}
