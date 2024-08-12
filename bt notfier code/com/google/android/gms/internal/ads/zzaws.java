/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaxd
 *  com.google.android.gms.internal.ads.zzaxh
 *  com.google.android.gms.internal.ads.zzaxp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaxd;
import com.google.android.gms.internal.ads.zzaxh;
import com.google.android.gms.internal.ads.zzaxp;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzaws {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzaxh zze;
    private final zzaxp zzf;
    private final Object zzg = new Object();
    private final ArrayList<String> zzh = new ArrayList();
    private final ArrayList<String> zzi = new ArrayList();
    private final ArrayList<zzaxd> zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private int zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzaws(int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = bl;
        this.zze = new zzaxh(n4);
        this.zzf = new zzaxp(n5, n6, n7);
    }

    private final void zzp(String object, boolean bl, float f, float f2, float f3, float f4) {
        if (object == null) return;
        if (((String)object).length() < this.zzc) {
            return;
        }
        Object object2 = this.zzg;
        synchronized (object2) {
            this.zzh.add((String)object);
            this.zzk += ((String)object).length();
            if (!bl) return;
            this.zzi.add((String)object);
            object = this.zzj;
            zzaxd zzaxd2 = new zzaxd(f, f2, f3, f4, this.zzi.size() - 1);
            ((ArrayList)object).add(zzaxd2);
            return;
        }
    }

    private static final String zzq(ArrayList<String> object, int n) {
        if (((ArrayList)object).isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = object.size();
        for (n = 0; n < n2; ++n) {
            stringBuilder.append((String)object.get(n));
            stringBuilder.append(' ');
            if (stringBuilder.length() <= 100) continue;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        object = stringBuilder.toString();
        if (((String)object).length() >= 100) return ((String)object).substring(0, 100);
        return object;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzaws)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        object = ((zzaws)object).zzo;
        if (object == null) return false;
        if (!((String)object).equals(this.zzo)) return false;
        return true;
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        int n = this.zzl;
        int n2 = this.zzn;
        int n3 = this.zzk;
        String string = zzaws.zzq(this.zzh, 100);
        String string2 = zzaws.zzq(this.zzi, 100);
        String string3 = this.zzo;
        String string4 = this.zzp;
        String string5 = this.zzq;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 165 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length() + String.valueOf(string5).length());
        stringBuilder.append("ActivityContent fetchId: ");
        stringBuilder.append(n);
        stringBuilder.append(" score:");
        stringBuilder.append(n2);
        stringBuilder.append(" total_length:");
        stringBuilder.append(n3);
        stringBuilder.append("\n text: ");
        stringBuilder.append(string);
        stringBuilder.append("\n viewableText");
        stringBuilder.append(string2);
        stringBuilder.append("\n signture: ");
        stringBuilder.append(string3);
        stringBuilder.append("\n viewableSignture: ");
        stringBuilder.append(string4);
        stringBuilder.append("\n viewableSignatureForVertical: ");
        stringBuilder.append(string5);
        return stringBuilder.toString();
    }

    public final boolean zza() {
        Object object = this.zzg;
        synchronized (object) {
            boolean bl = this.zzm == 0;
            return bl;
        }
    }

    public final String zzb() {
        return this.zzo;
    }

    public final String zzc() {
        return this.zzp;
    }

    public final String zzd() {
        return this.zzq;
    }

    public final void zze() {
        Object object = this.zzg;
        synchronized (object) {
            this.zzn -= 100;
            return;
        }
    }

    public final void zzf() {
        Object object = this.zzg;
        synchronized (object) {
            --this.zzm;
            return;
        }
    }

    public final void zzg() {
        Object object = this.zzg;
        synchronized (object) {
            ++this.zzm;
            return;
        }
    }

    public final void zzh(String object, boolean bl, float f, float f2, float f3, float f4) {
        this.zzp((String)object, bl, f, f2, f3, f4);
        object = this.zzg;
        synchronized (object) {
            if (this.zzm < 0) {
                com.google.android.gms.ads.internal.util.zze.zzd((String)"ActivityContent: negative number of WebViews.");
            }
            this.zzk();
            return;
        }
    }

    public final void zzi(String string, boolean bl, float f, float f2, float f3, float f4) {
        this.zzp(string, bl, f, f2, f3, f4);
    }

    public final void zzj() {
        Object object = this.zzg;
        synchronized (object) {
            int n = this.zzl(this.zzk, this.zzl);
            if (n <= this.zzn) return;
            this.zzn = n;
            return;
        }
    }

    public final void zzk() {
        Object object = this.zzg;
        synchronized (object) {
            int n = this.zzl(this.zzk, this.zzl);
            if (n <= this.zzn) return;
            this.zzn = n;
            if (!zzt.zzg().zzp().zzd()) {
                this.zzo = this.zze.zza(this.zzh);
                this.zzp = this.zze.zza(this.zzi);
            }
            if (zzt.zzg().zzp().zzh()) return;
            this.zzq = this.zzf.zza(this.zzi, this.zzj);
            return;
        }
    }

    final int zzl(int n, int n2) {
        if (!this.zzd) return n * this.zza + n2 * this.zzb;
        return this.zzb;
    }

    public final int zzm() {
        return this.zzn;
    }

    public final void zzn(int n) {
        this.zzl = n;
    }

    final int zzo() {
        return this.zzk;
    }
}
