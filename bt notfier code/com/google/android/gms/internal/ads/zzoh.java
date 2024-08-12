/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzajc
 *  com.google.android.gms.internal.ads.zzaje
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzog
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzajc;
import com.google.android.gms.internal.ads.zzaje;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzoh {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzog zzk;
    private final zzaiv zzl;

    private zzoh(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, zzog zzog2, zzaiv zzaiv2) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = n4;
        this.zze = n5;
        this.zzf = zzoh.zzh(n5);
        this.zzg = n6;
        this.zzh = n7;
        this.zzi = zzoh.zzi(n7);
        this.zzj = l;
        this.zzk = zzog2;
        this.zzl = zzaiv2;
    }

    public zzoh(byte[] object, int n) {
        object = new zzame(object, ((byte[])object).length);
        object.zzd(n * 8);
        this.zza = object.zzh(16);
        this.zzb = object.zzh(16);
        this.zzc = object.zzh(24);
        this.zzd = object.zzh(24);
        this.zze = n = object.zzh(20);
        this.zzf = zzoh.zzh(n);
        this.zzg = object.zzh(3) + 1;
        this.zzh = n = object.zzh(5) + 1;
        this.zzi = zzoh.zzi(n);
        this.zzj = zzamq.zzL((int)object.zzh(4), (int)object.zzh(32));
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int n) {
        switch (n) {
            default: {
                return -1;
            }
            case 192000: {
                return 3;
            }
            case 176400: {
                return 2;
            }
            case 96000: {
                return 11;
            }
            case 88200: {
                return 1;
            }
            case 48000: {
                return 10;
            }
            case 44100: {
                return 9;
            }
            case 32000: {
                return 8;
            }
            case 24000: {
                return 7;
            }
            case 22050: {
                return 6;
            }
            case 16000: {
                return 5;
            }
            case 8000: 
        }
        return 4;
    }

    private static int zzi(int n) {
        if (n == 8) return 1;
        if (n == 12) return 2;
        if (n == 16) return 4;
        if (n == 20) return 5;
        if (n == 24) return 6;
        return -1;
    }

    private static zzaiv zzj(List<String> list, List<zzajc> list2) {
        if (list.isEmpty()) {
            if (list2.isEmpty()) return null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n = 0;
        while (true) {
            if (n >= list.size()) {
                arrayList.addAll(list2);
                if (!arrayList.isEmpty()) return new zzaiv(arrayList);
                return null;
            }
            String string = list.get(n);
            Object object = zzamq.zzu((String)string, (String)"=");
            if (((String[])object).length != 2) {
                object = String.valueOf(string);
                object = ((String)object).length() != 0 ? "Failed to parse Vorbis comment: ".concat((String)object) : new String("Failed to parse Vorbis comment: ");
                Log.w((String)"FlacStreamMetadata", (String)object);
            } else {
                arrayList.add(new zzaje((String)object[0], (String)object[1]));
            }
            ++n;
        }
    }

    public final long zza() {
        long l = this.zzj;
        if (l != 0L) return l * 1000000L / (long)this.zze;
        return -9223372036854775807L;
    }

    public final long zzb(long l) {
        return zzamq.zzy((long)(l * (long)this.zze / 1000000L), (long)0L, (long)(this.zzj - 1L));
    }

    public final zzafv zzc(byte[] byArray, zzaiv zzaiv2) {
        int n;
        byArray[4] = -128;
        int n2 = n = this.zzd;
        if (n <= 0) {
            n2 = -1;
        }
        zzaiv2 = this.zzd(zzaiv2);
        zzaft zzaft2 = new zzaft();
        zzaft2.zzN("audio/flac");
        zzaft2.zzO(n2);
        zzaft2.zzaa(this.zzg);
        zzaft2.zzab(this.zze);
        zzaft2.zzP(Collections.singletonList(byArray));
        zzaft2.zzL(zzaiv2);
        return zzaft2.zzah();
    }

    public final zzaiv zzd(zzaiv zzaiv2) {
        zzaiv zzaiv3 = this.zzl;
        if (zzaiv3 != null) return zzaiv3.zzc(zzaiv2);
        return zzaiv2;
    }

    public final zzoh zze(zzog zzog2) {
        return new zzoh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzog2, this.zzl);
    }

    public final zzoh zzf(List<String> zzaiv2) {
        zzaiv2 = this.zzd(zzoh.zzj(zzaiv2, Collections.<zzajc>emptyList()));
        return new zzoh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzaiv2);
    }

    public final zzoh zzg(List<zzajc> zzaiv2) {
        zzaiv2 = this.zzd(zzoh.zzj(Collections.<String>emptyList(), zzaiv2));
        return new zzoh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzaiv2);
    }
}
