/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzajq
 *  com.google.android.gms.internal.ads.zzajz
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzajq;
import com.google.android.gms.internal.ads.zzajz;
import com.google.android.gms.internal.ads.zzamq;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzoj {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String object) {
        if (!((Matcher)(object = zzc.matcher((CharSequence)object))).find()) return false;
        try {
            String string = ((Matcher)object).group(1);
            int n = zzamq.zza;
            n = Integer.parseInt(string, 16);
            int n2 = Integer.parseInt(((Matcher)object).group(2), 16);
            if (n <= 0) {
                if (n2 <= 0) return false;
            }
            this.zza = n;
            this.zzb = n2;
            return true;
        }
        catch (NumberFormatException numberFormatException) {
        }
        return false;
    }

    public final boolean zza(zzaiv zzaiv2) {
        int n = 0;
        while (n < zzaiv2.zza()) {
            zzaiu zzaiu2 = zzaiv2.zzb(n);
            if (zzaiu2 instanceof zzajq) {
                zzaiu2 = (zzajq)zzaiu2;
                if ("iTunSMPB".equals(zzaiu2.zzb)) {
                    if (this.zzc(zzaiu2.zzc)) return true;
                }
            } else if (zzaiu2 instanceof zzajz) {
                zzaiu2 = (zzajz)zzaiu2;
                if ("com.apple.iTunes".equals(zzaiu2.zza) && "iTunSMPB".equals(zzaiu2.zzb) && this.zzc(zzaiu2.zzc)) {
                    return true;
                }
            }
            ++n;
        }
        return false;
    }

    public final boolean zzb() {
        if (this.zza == -1) return false;
        if (this.zzb == -1) return false;
        return true;
    }
}
