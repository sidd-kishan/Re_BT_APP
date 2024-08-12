/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzafs
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafu
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzj
 *  com.google.android.gms.internal.ads.zzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzafs;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafu;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzj;
import com.google.android.gms.internal.ads.zzn;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzafv {
    public static final zzadw<zzafv> zzF;
    private static final zzafv zzG;
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    private int zzH;
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final String zzi;
    public final zzaiv zzj;
    public final String zzk;
    public final String zzl;
    public final int zzm;
    public final List<byte[]> zzn;
    public final zzn zzo;
    public final long zzp;
    public final int zzq;
    public final int zzr;
    public final float zzs;
    public final int zzt;
    public final float zzu;
    public final byte[] zzv;
    public final int zzw;
    public final zzj zzx;
    public final int zzy;
    public final int zzz;

    static {
        zzG = new zzafv(new zzaft());
        zzF = zzafs.zza;
    }

    private zzafv(zzaft zzaft2) {
        int n;
        this.zza = zzaft.zza((zzaft)zzaft2);
        this.zzb = zzaft.zzb((zzaft)zzaft2);
        this.zzc = zzamq.zzq((String)zzaft.zzc((zzaft)zzaft2));
        this.zzd = zzaft.zzd((zzaft)zzaft2);
        int n2 = 0;
        this.zze = 0;
        this.zzf = zzaft.zze((zzaft)zzaft2);
        this.zzg = n = zzaft.zzf((zzaft)zzaft2);
        int n3 = n;
        if (n == -1) {
            n3 = this.zzf;
        }
        this.zzh = n3;
        this.zzi = zzaft.zzg((zzaft)zzaft2);
        this.zzj = zzaft.zzh((zzaft)zzaft2);
        this.zzk = zzaft.zzi((zzaft)zzaft2);
        this.zzl = zzaft.zzj((zzaft)zzaft2);
        this.zzm = zzaft.zzk((zzaft)zzaft2);
        List list = zzaft.zzl((zzaft)zzaft2) == null ? Collections.emptyList() : zzaft.zzl((zzaft)zzaft2);
        this.zzn = list;
        this.zzo = zzaft.zzm((zzaft)zzaft2);
        this.zzp = zzaft.zzn((zzaft)zzaft2);
        this.zzq = zzaft.zzo((zzaft)zzaft2);
        this.zzr = zzaft.zzp((zzaft)zzaft2);
        this.zzs = zzaft.zzq((zzaft)zzaft2);
        n3 = zzaft.zzr((zzaft)zzaft2) == -1 ? 0 : zzaft.zzr((zzaft)zzaft2);
        this.zzt = n3;
        float f = zzaft.zzs((zzaft)zzaft2) == -1.0f ? 1.0f : zzaft.zzs((zzaft)zzaft2);
        this.zzu = f;
        this.zzv = zzaft.zzt((zzaft)zzaft2);
        this.zzw = zzaft.zzu((zzaft)zzaft2);
        this.zzx = zzaft.zzv((zzaft)zzaft2);
        this.zzy = zzaft.zzw((zzaft)zzaft2);
        this.zzz = zzaft.zzx((zzaft)zzaft2);
        this.zzA = zzaft.zzy((zzaft)zzaft2);
        n3 = zzaft.zzz((zzaft)zzaft2) == -1 ? 0 : zzaft.zzz((zzaft)zzaft2);
        this.zzB = n3;
        n3 = zzaft.zzA((zzaft)zzaft2) == -1 ? n2 : zzaft.zzA((zzaft)zzaft2);
        this.zzC = n3;
        this.zzD = zzaft.zzB((zzaft)zzaft2);
        n3 = zzaft.zzC((zzaft)zzaft2) == 0 && this.zzo != null ? 1 : zzaft.zzC((zzaft)zzaft2);
        this.zzE = n3;
    }

    /* synthetic */ zzafv(zzaft zzaft2, zzafu zzafu2) {
        this(zzaft2);
    }

    public final boolean equals(Object object) {
        int n;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzafv)object;
        int n2 = this.zzH;
        if (n2 != 0 && (n = ((zzafv)object).zzH) != 0) {
            if (n2 != n) return false;
        }
        if (this.zzd != ((zzafv)object).zzd) return false;
        if (this.zzf != ((zzafv)object).zzf) return false;
        if (this.zzg != ((zzafv)object).zzg) return false;
        if (this.zzm != ((zzafv)object).zzm) return false;
        if (this.zzp != ((zzafv)object).zzp) return false;
        if (this.zzq != ((zzafv)object).zzq) return false;
        if (this.zzr != ((zzafv)object).zzr) return false;
        if (this.zzt != ((zzafv)object).zzt) return false;
        if (this.zzw != ((zzafv)object).zzw) return false;
        if (this.zzy != ((zzafv)object).zzy) return false;
        if (this.zzz != ((zzafv)object).zzz) return false;
        if (this.zzA != ((zzafv)object).zzA) return false;
        if (this.zzB != ((zzafv)object).zzB) return false;
        if (this.zzC != ((zzafv)object).zzC) return false;
        if (this.zzD != ((zzafv)object).zzD) return false;
        if (this.zzE != ((zzafv)object).zzE) return false;
        if (Float.compare(this.zzs, ((zzafv)object).zzs) != 0) return false;
        if (Float.compare(this.zzu, ((zzafv)object).zzu) != 0) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzafv)object).zza)) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzafv)object).zzb)) return false;
        if (!zzamq.zzc((Object)this.zzi, (Object)((zzafv)object).zzi)) return false;
        if (!zzamq.zzc((Object)this.zzk, (Object)((zzafv)object).zzk)) return false;
        if (!zzamq.zzc((Object)this.zzl, (Object)((zzafv)object).zzl)) return false;
        if (!zzamq.zzc((Object)this.zzc, (Object)((zzafv)object).zzc)) return false;
        if (!Arrays.equals(this.zzv, ((zzafv)object).zzv)) return false;
        if (!zzamq.zzc((Object)this.zzj, (Object)((zzafv)object).zzj)) return false;
        if (!zzamq.zzc((Object)this.zzx, (Object)((zzafv)object).zzx)) return false;
        if (!zzamq.zzc((Object)this.zzo, (Object)((zzafv)object).zzo)) return false;
        if (!this.zzd((zzafv)object)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzH;
        if (n != 0) return n2;
        String string = this.zza;
        int n3 = 0;
        n2 = string == null ? 0 : string.hashCode();
        string = this.zzb;
        n = string != null ? string.hashCode() : 0;
        string = this.zzc;
        int n4 = string == null ? 0 : string.hashCode();
        int n5 = this.zzd;
        int n6 = this.zzf;
        int n7 = this.zzg;
        string = this.zzi;
        int n8 = string == null ? 0 : string.hashCode();
        string = this.zzj;
        int n9 = string == null ? 0 : string.hashCode();
        string = this.zzk;
        int n10 = string == null ? 0 : string.hashCode();
        string = this.zzl;
        if (string != null) {
            n3 = string.hashCode();
        }
        this.zzH = n2 = ((((((((((((((((((((((((n2 + 527) * 31 + n) * 31 + n4) * 31 + n5) * 961 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n3) * 31 + this.zzm) * 31 + (int)this.zzp) * 31 + this.zzq) * 31 + this.zzr) * 31 + Float.floatToIntBits(this.zzs)) * 31 + this.zzt) * 31 + Float.floatToIntBits(this.zzu)) * 31 + this.zzw) * 31 + this.zzy) * 31 + this.zzz) * 31 + this.zzA) * 31 + this.zzB) * 31 + this.zzC) * 31 + this.zzD) * 31 + this.zzE;
        return n2;
    }

    public final String toString() {
        String string = this.zza;
        String string2 = this.zzb;
        String string3 = this.zzk;
        String string4 = this.zzl;
        String string5 = this.zzi;
        int n = this.zzh;
        String string6 = this.zzc;
        int n2 = this.zzq;
        int n3 = this.zzr;
        float f = this.zzs;
        int n4 = this.zzy;
        int n5 = this.zzz;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 104 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length() + String.valueOf(string5).length() + String.valueOf(string6).length());
        stringBuilder.append("Format(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(string3);
        stringBuilder.append(", ");
        stringBuilder.append(string4);
        stringBuilder.append(", ");
        stringBuilder.append(string5);
        stringBuilder.append(", ");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(string6);
        stringBuilder.append(", [");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(", ");
        stringBuilder.append(f);
        stringBuilder.append("], [");
        stringBuilder.append(n4);
        stringBuilder.append(", ");
        stringBuilder.append(n5);
        stringBuilder.append("])");
        return stringBuilder.toString();
    }

    public final zzaft zza() {
        return new zzaft(this, null);
    }

    public final zzafv zzb(int n) {
        zzaft zzaft2 = new zzaft(this, null);
        zzaft2.zzag(n);
        return new zzafv(zzaft2);
    }

    public final int zzc() {
        int n = this.zzq;
        if (n == -1) return -1;
        int n2 = this.zzr;
        if (n2 != -1) return n * n2;
        return -1;
    }

    public final boolean zzd(zzafv zzafv2) {
        if (this.zzn.size() != zzafv2.zzn.size()) return false;
        int n = 0;
        while (n < this.zzn.size()) {
            if (!Arrays.equals(this.zzn.get(n), zzafv2.zzn.get(n))) {
                return false;
            }
            ++n;
        }
        return true;
    }
}
