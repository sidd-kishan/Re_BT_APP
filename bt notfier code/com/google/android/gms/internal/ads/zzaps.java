/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapr
 *  com.google.android.gms.internal.ads.zzaru
 *  com.google.android.gms.internal.ads.zzary
 *  com.google.android.gms.internal.ads.zzarz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapr;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzary;
import com.google.android.gms.internal.ads.zzarz;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzaps {
    public static final zzarz zza = new zzapr();
    private static final Pattern zzd = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzb = -1;
    public int zzc = -1;

    public final boolean zza(zzaru zzaru2) {
        int n = 0;
        while (n < zzaru2.zza()) {
            Object object = zzaru2.zzb(n);
            if (object instanceof zzary) {
                Object object2 = (zzary)object;
                object = object2.zzb;
                object2 = object2.zzc;
                if ("iTunSMPB".equals(object) && ((Matcher)(object = zzd.matcher((CharSequence)object2))).find()) {
                    try {
                        int n2 = Integer.parseInt(((Matcher)object).group(1), 16);
                        int n3 = Integer.parseInt(((Matcher)object).group(2), 16);
                        if (n2 > 0 || n3 > 0) {
                            this.zzb = n2;
                            this.zzc = n3;
                            return true;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {}
                }
            }
            ++n;
        }
        return false;
    }

    public final boolean zzb() {
        if (this.zzb == -1) return false;
        if (this.zzc == -1) return false;
        return true;
    }
}
