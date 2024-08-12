/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeg
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfe
 *  com.google.android.gms.internal.ads.zzgfh
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggs
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeg;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfe;
import com.google.android.gms.internal.ads.zzgfh;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggs;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghz;
import java.io.IOException;
import java.util.List;

final class zzgfi {
    private final zzgfh zza;

    private zzgfi(zzgfh zzgfh2) {
        zzggk.zzb((Object)zzgfh2, (String)"output");
        this.zza = zzgfh2;
        zzgfh2.zza = this;
    }

    public static zzgfi zza(zzgfh zzgfh2) {
        zzgfi zzgfi2 = zzgfh2.zza;
        if (zzgfi2 == null) return new zzgfi(zzgfh2);
        return zzgfi2;
    }

    public final void zzA(int n, List<Float> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzd(n, Float.floatToRawIntBits(list.get(n2).floatValue()));
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n = 0;
        for (n2 = 0; n2 < list.size(); n += 4, ++n2) {
            list.get(n2).floatValue();
        }
        this.zza.zzl(n);
        n = n3;
        while (n < list.size()) {
            this.zza.zzm(Float.floatToRawIntBits(list.get(n).floatValue()));
            ++n;
        }
    }

    public final void zzB(int n, List<Double> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzf(n, Double.doubleToRawLongBits(list.get(n2)));
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += 8, ++n) {
            list.get(n).doubleValue();
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzo(Double.doubleToRawLongBits(list.get(n)));
            ++n;
        }
    }

    public final void zzC(int n, List<Integer> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzb(n, list.get(n2).intValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n = 0;
        for (n2 = 0; n2 < list.size(); n += zzgfh.zzw((int)list.get(n2)), ++n2) {
        }
        this.zza.zzl(n);
        n = n3;
        while (n < list.size()) {
            this.zza.zzk(list.get(n).intValue());
            ++n;
        }
    }

    public final void zzD(int n, List<Boolean> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzg(n, list.get(n2).booleanValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); ++n2, ++n) {
            list.get(n).booleanValue();
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzj((byte)(list.get(n).booleanValue() ? 1 : 0));
            ++n;
        }
    }

    public final void zzE(int n, List<String> list) throws IOException {
        boolean bl = list instanceof zzggs;
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzh(n, list.get(n2));
                ++n2;
            }
            return;
        }
        zzggs zzggs2 = (zzggs)list;
        n2 = n3;
        while (n2 < list.size()) {
            Object object = zzggs2.zzg(n2);
            if (object instanceof String) {
                this.zza.zzh(n, (String)object);
            } else {
                this.zza.zzi(n, (zzgex)object);
            }
            ++n2;
        }
    }

    public final void zzF(int n, List<zzgex> list) throws IOException {
        int n2 = 0;
        while (n2 < list.size()) {
            this.zza.zzi(n, list.get(n2));
            ++n2;
        }
    }

    public final void zzG(int n, List<Integer> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzc(n, list.get(n2).intValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n = 0;
        for (n2 = 0; n2 < list.size(); n += zzgfh.zzx((int)list.get(n2)), ++n2) {
        }
        this.zza.zzl(n);
        n = n3;
        while (n < list.size()) {
            this.zza.zzl(list.get(n).intValue());
            ++n;
        }
    }

    public final void zzH(int n, List<Integer> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzd(n, list.get(n2).intValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += 4, ++n) {
            list.get(n).intValue();
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzm(list.get(n).intValue());
            ++n;
        }
    }

    public final void zzI(int n, List<Long> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzf(n, list.get(n2).longValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += 8, ++n) {
            list.get(n).longValue();
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzo(list.get(n).longValue());
            ++n;
        }
    }

    public final void zzJ(int n, List<Integer> list, boolean bl) throws IOException {
        int n2;
        int n3 = 0;
        int n4 = 0;
        if (!bl) {
            while (n3 < list.size()) {
                zzgfh zzgfh2 = this.zza;
                n4 = list.get(n3);
                zzgfh2.zzc(n, n4 >> 31 ^ n4 + n4);
                ++n3;
            }
            return;
        }
        this.zza.zza(n, 2);
        n = 0;
        for (n3 = 0; n3 < list.size(); n += zzgfh.zzx((int)(n2 >> 31 ^ n2 + n2)), ++n3) {
            n2 = list.get(n3);
        }
        this.zza.zzl(n);
        n = n4;
        while (n < list.size()) {
            zzgfh zzgfh3 = this.zza;
            n3 = list.get(n);
            zzgfh3.zzl(n3 >> 31 ^ n3 + n3);
            ++n;
        }
    }

    public final void zzK(int n, List<Long> list, boolean bl) throws IOException {
        long l;
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                zzgfh zzgfh2 = this.zza;
                long l2 = list.get(n2);
                zzgfh2.zze(n, l2 >> 63 ^ l2 + l2);
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n = 0;
        for (n2 = 0; n2 < list.size(); n += zzgfh.zzy((long)(l >> 63 ^ l + l)), ++n2) {
            l = list.get(n2);
        }
        this.zza.zzl(n);
        n = n3;
        while (n < list.size()) {
            zzgfh zzgfh3 = this.zza;
            l = list.get(n);
            zzgfh3.zzn(l >> 63 ^ l + l);
            ++n;
        }
    }

    public final void zzb(int n, int n2) throws IOException {
        this.zza.zzd(n, n2);
    }

    public final void zzc(int n, long l) throws IOException {
        this.zza.zze(n, l);
    }

    public final void zzd(int n, long l) throws IOException {
        this.zza.zzf(n, l);
    }

    public final void zze(int n, float f) throws IOException {
        this.zza.zzd(n, Float.floatToRawIntBits(f));
    }

    public final void zzf(int n, double d) throws IOException {
        this.zza.zzf(n, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int n, int n2) throws IOException {
        this.zza.zzb(n, n2);
    }

    public final void zzh(int n, long l) throws IOException {
        this.zza.zze(n, l);
    }

    public final void zzi(int n, int n2) throws IOException {
        this.zza.zzb(n, n2);
    }

    public final void zzj(int n, long l) throws IOException {
        this.zza.zzf(n, l);
    }

    public final void zzk(int n, int n2) throws IOException {
        this.zza.zzd(n, n2);
    }

    public final void zzl(int n, boolean bl) throws IOException {
        this.zza.zzg(n, bl);
    }

    public final void zzm(int n, String string) throws IOException {
        this.zza.zzh(n, string);
    }

    public final void zzn(int n, zzgex zzgex2) throws IOException {
        this.zza.zzi(n, zzgex2);
    }

    public final void zzo(int n, int n2) throws IOException {
        this.zza.zzc(n, n2);
    }

    public final void zzp(int n, int n2) throws IOException {
        this.zza.zzc(n, n2 >> 31 ^ n2 + n2);
    }

    public final void zzq(int n, long l) throws IOException {
        this.zza.zze(n, l >> 63 ^ l + l);
    }

    public final void zzr(int n, Object object, zzghz zzghz2) throws IOException {
        int n2;
        zzgfh zzgfh2 = this.zza;
        object = (zzghi)object;
        zzgfe zzgfe2 = (zzgfe)zzgfh2;
        zzgfe2.zzl(n << 3 | 2);
        zzgfh2 = (zzgeg)object;
        n = n2 = zzgfh2.zzap();
        if (n2 == -1) {
            n = zzghz2.zze((Object)zzgfh2);
            zzgfh2.zzaq(n);
        }
        zzgfe2.zzl(n);
        zzghz2.zzn(object, zzgfe2.zza);
    }

    public final void zzs(int n, Object object, zzghz zzghz2) throws IOException {
        zzgfh zzgfh2 = this.zza;
        object = (zzghi)object;
        zzgfh2.zza(n, 3);
        zzghz2.zzn(object, zzgfh2.zza);
        zzgfh2.zza(n, 4);
    }

    public final void zzt(int n) throws IOException {
        this.zza.zza(n, 3);
    }

    public final void zzu(int n) throws IOException {
        this.zza.zza(n, 4);
    }

    public final void zzv(int n, List<Integer> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzb(n, list.get(n2).intValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += zzgfh.zzw((int)list.get(n)), ++n) {
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzk(list.get(n).intValue());
            ++n;
        }
    }

    public final void zzw(int n, List<Integer> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzd(n, list.get(n2).intValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += 4, ++n) {
            list.get(n).intValue();
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzm(list.get(n).intValue());
            ++n;
        }
    }

    public final void zzx(int n, List<Long> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zze(n, list.get(n2).longValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += zzgfh.zzy((long)list.get(n)), ++n) {
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzn(list.get(n).longValue());
            ++n;
        }
    }

    public final void zzy(int n, List<Long> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zze(n, list.get(n2).longValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += zzgfh.zzy((long)list.get(n)), ++n) {
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzn(list.get(n).longValue());
            ++n;
        }
    }

    public final void zzz(int n, List<Long> list, boolean bl) throws IOException {
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            while (n2 < list.size()) {
                this.zza.zzf(n, list.get(n2).longValue());
                ++n2;
            }
            return;
        }
        this.zza.zza(n, 2);
        n2 = 0;
        for (n = 0; n < list.size(); n2 += 8, ++n) {
            list.get(n).longValue();
        }
        this.zza.zzl(n2);
        n = n3;
        while (n < list.size()) {
            this.zza.zzo(list.get(n).longValue());
            ++n;
        }
    }
}
