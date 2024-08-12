/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzeeh
 *  com.google.android.gms.internal.ads.zzeho
 *  com.google.android.gms.internal.ads.zzehq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzeeh;
import com.google.android.gms.internal.ads.zzeho;
import com.google.android.gms.internal.ads.zzehq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public final class zzehp {
    private final Clock zza;
    private final zzehq zzb;
    private final List<String> zzc = Collections.synchronizedList(new ArrayList());
    private final boolean zzd;
    private final zzeeh zze;

    public zzehp(Clock clock, zzehq zzehq2, zzeeh zzeeh2) {
        this.zza = clock;
        this.zzb = zzehq2;
        clock = zzbjl.zzfd;
        this.zzd = (Boolean)zzbet.zzc().zzc((zzbjd)clock);
        this.zze = zzeeh2;
    }

    static /* synthetic */ Clock zza(zzehp zzehp2) {
        return zzehp2.zza;
    }

    static /* synthetic */ zzehq zzb(zzehp zzehp2) {
        return zzehp2.zzb;
    }

    static /* synthetic */ boolean zzc(zzehp zzehp2) {
        return zzehp2.zzd;
    }

    static /* synthetic */ zzeeh zzd(zzehp zzehp2) {
        return zzehp2.zze;
    }

    static /* synthetic */ void zzf(zzehp zzehp2, String charSequence, int n, long l, String string) {
        CharSequence charSequence2 = new StringBuilder(((String)charSequence).length() + 33);
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(".");
        ((StringBuilder)charSequence2).append(n);
        ((StringBuilder)charSequence2).append(".");
        ((StringBuilder)charSequence2).append(l);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        charSequence = charSequence2;
        if (!TextUtils.isEmpty((CharSequence)string)) {
            n = String.valueOf(string).length();
            charSequence = new StringBuilder(((String)charSequence2).length() + 1 + n);
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(".");
            ((StringBuilder)charSequence).append(string);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        zzehp2.zzc.add((String)charSequence);
    }

    final <T> zzfsm<T> zze(zzfac zzfac2, zzezz zzezz2, zzfsm<T> zzfsm2) {
        long l = this.zza.elapsedRealtime();
        String string = zzezz2.zzw;
        if (string == null) return zzfsm2;
        zzfsd.zzp(zzfsm2, (zzfrz)new zzeho(this, l, string, zzezz2, zzfac2), (Executor)zzchg.zzf);
        return zzfsm2;
    }

    public final String zzg() {
        return TextUtils.join((CharSequence)"_", this.zzc);
    }
}
