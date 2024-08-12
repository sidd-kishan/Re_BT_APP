/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgfn
 *  com.google.android.gms.internal.ads.zzgfp
 *  com.google.android.gms.internal.ads.zzgfv
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggw
 *  com.google.android.gms.internal.ads.zzggy
 *  com.google.android.gms.internal.ads.zzggz
 *  com.google.android.gms.internal.ads.zzghd
 *  com.google.android.gms.internal.ads.zzghe
 *  com.google.android.gms.internal.ads.zzghf
 *  com.google.android.gms.internal.ads.zzghg
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghl
 *  com.google.android.gms.internal.ads.zzghm
 *  com.google.android.gms.internal.ads.zzghn
 *  com.google.android.gms.internal.ads.zzgho
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgia
 *  com.google.android.gms.internal.ads.zzgib
 *  com.google.android.gms.internal.ads.zzgio
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfn;
import com.google.android.gms.internal.ads.zzgfp;
import com.google.android.gms.internal.ads.zzgfv;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggw;
import com.google.android.gms.internal.ads.zzggy;
import com.google.android.gms.internal.ads.zzggz;
import com.google.android.gms.internal.ads.zzghd;
import com.google.android.gms.internal.ads.zzghe;
import com.google.android.gms.internal.ads.zzghf;
import com.google.android.gms.internal.ads.zzghg;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghl;
import com.google.android.gms.internal.ads.zzghm;
import com.google.android.gms.internal.ads.zzghn;
import com.google.android.gms.internal.ads.zzgho;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgia;
import com.google.android.gms.internal.ads.zzgib;
import com.google.android.gms.internal.ads.zzgio;

final class zzgha
implements zzgia {
    private static final zzghg zzb = new zzggy();
    private final zzghg zza;

    public zzgha() {
        zzghg zzghg2;
        zzgfv zzgfv2 = zzgfv.zza();
        try {
            zzghg2 = (zzghg)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception) {
            zzghg2 = zzb;
        }
        zzghg2 = new zzggz(new zzghg[]{zzgfv2, zzghg2});
        zzggk.zzb((Object)zzghg2, (String)"messageInfoFactory");
        this.zza = zzghg2;
    }

    private static boolean zzb(zzghf zzghf2) {
        if (zzghf2.zzc() != 1) return false;
        return true;
    }

    public final <T> zzghz<T> zza(Class<T> zzghl2) {
        zzgib.zza(zzghl2);
        zzghf zzghf2 = this.zza.zzc(zzghl2);
        if (zzghf2.zza()) {
            if (!zzgga.class.isAssignableFrom((Class<?>)zzghl2)) return zzghm.zzg((zzgio)zzgib.zzA(), (zzgfn)zzgfp.zzb(), (zzghi)zzghf2.zzb());
            return zzghm.zzg((zzgio)zzgib.zzC(), (zzgfn)zzgfp.zza(), (zzghi)zzghf2.zzb());
        }
        zzghl2 = zzgga.class.isAssignableFrom((Class<?>)zzghl2) ? (zzgha.zzb(zzghf2) ? zzghl.zzl(zzghl2, (zzghf)zzghf2, (zzghn)zzgho.zzb(), (zzggw)zzggw.zze(), (zzgio)zzgib.zzC(), (zzgfn)zzgfp.zza(), (zzghd)zzghe.zzb()) : zzghl.zzl(zzghl2, (zzghf)zzghf2, (zzghn)zzgho.zzb(), (zzggw)zzggw.zze(), (zzgio)zzgib.zzC(), null, (zzghd)zzghe.zzb())) : (zzgha.zzb(zzghf2) ? zzghl.zzl(zzghl2, (zzghf)zzghf2, (zzghn)zzgho.zza(), (zzggw)zzggw.zzd(), (zzgio)zzgib.zzA(), (zzgfn)zzgfp.zzb(), (zzghd)zzghe.zza()) : zzghl.zzl(zzghl2, (zzghf)zzghf2, (zzghn)zzgho.zza(), (zzggw)zzggw.zzd(), (zzgio)zzgib.zzB(), null, (zzghd)zzghe.zza()));
        return zzghl2;
    }
}
