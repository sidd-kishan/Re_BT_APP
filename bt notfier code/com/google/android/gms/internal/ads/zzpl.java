/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzmv
 *  com.google.android.gms.internal.ads.zzmx
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpp
 *  com.google.android.gms.internal.ads.zzpq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzmv;
import com.google.android.gms.internal.ads.zzmx;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpp;
import com.google.android.gms.internal.ads.zzpq;
import java.util.Collections;

final class zzpl
extends zzpq {
    private static final int[] zzb = new int[]{5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzpl(zzox zzox2) {
        super(zzox2);
    }

    protected final boolean zza(zzamf object) throws zzpp {
        if (!this.zzc) {
            int n;
            int n2 = object.zzn();
            this.zze = n = n2 >> 4;
            if (n == 2) {
                n2 = zzb[n2 >> 2 & 3];
                object = new zzaft();
                object.zzN("audio/mpeg");
                object.zzaa(1);
                object.zzab(n2);
                object = object.zzah();
                this.zza.zzs((zzafv)object);
                this.zzd = true;
            } else if (n != 7 && n != 8) {
                if (n != 10) {
                    object = new StringBuilder(39);
                    ((StringBuilder)object).append("Audio format not supported: ");
                    ((StringBuilder)object).append(n);
                    throw new zzpp(((StringBuilder)object).toString());
                }
            } else {
                object = n == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                zzaft zzaft2 = new zzaft();
                zzaft2.zzN((String)object);
                zzaft2.zzaa(1);
                zzaft2.zzab(8000);
                object = zzaft2.zzah();
                this.zza.zzs((zzafv)object);
                this.zzd = true;
            }
            this.zzc = true;
        } else {
            object.zzk(1);
        }
        return true;
    }

    protected final boolean zzb(zzamf zzamf2, long l) throws zzaha {
        if (this.zze == 2) {
            int n = zzamf2.zzd();
            this.zza.zzy(zzamf2, n);
            this.zza.zzv(l, 1, n, 0, null);
            return true;
        }
        int n = zzamf2.zzn();
        if (n == 0 && !this.zzd) {
            n = zzamf2.zzd();
            byte[] byArray = new byte[n];
            zzamf2.zzm(byArray, 0, n);
            zzmv zzmv2 = zzmx.zza((byte[])byArray);
            zzamf2 = new zzaft();
            zzamf2.zzN("audio/mp4a-latm");
            zzamf2.zzK(zzmv2.zzc);
            zzamf2.zzaa(zzmv2.zzb);
            zzamf2.zzab(zzmv2.zza);
            zzamf2.zzP(Collections.singletonList(byArray));
            zzamf2 = zzamf2.zzah();
            this.zza.zzs((zzafv)zzamf2);
            this.zzd = true;
            return false;
        }
        if (this.zze == 10) {
            if (n != 1) return false;
        }
        n = zzamf2.zzd();
        this.zza.zzy(zzamf2, n);
        this.zza.zzv(l, 1, n, 0, null);
        return true;
    }
}
