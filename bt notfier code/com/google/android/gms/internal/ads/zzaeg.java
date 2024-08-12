/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzaef
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzahc
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzo
 */
package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaef;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzahc;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzo;
import java.io.IOException;

public final class zzaeg
extends zzahc {
    public static final zzadw<zzaeg> zzh = zzaef.zza;
    public final int zza;
    public final String zzb;
    public final int zzc;
    public final zzafv zzd;
    public final int zze;
    public final zzo zzf;
    final boolean zzg;

    private zzaeg(int n, Throwable throwable, int n2) {
        this(n, throwable, null, n2, null, -1, null, 4, false);
    }

    private zzaeg(int n, Throwable throwable, String string, int n2, String string2, int n3, zzafv zzafv2, int n4, boolean bl) {
        CharSequence charSequence;
        if (n != 0) {
            if (n != 1) {
                string = "Unexpected runtime error";
            } else {
                String string3 = String.valueOf(zzafv2);
                string = zzadx.zzd((int)n4);
                charSequence = new StringBuilder(String.valueOf(string2).length() + 53 + String.valueOf(string3).length() + string.length());
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(" error, index=");
                ((StringBuilder)charSequence).append(n3);
                ((StringBuilder)charSequence).append(", format=");
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(", format_supported=");
                ((StringBuilder)charSequence).append(string);
                string = ((StringBuilder)charSequence).toString();
            }
        } else {
            string = "Source error";
        }
        charSequence = string;
        if (!TextUtils.isEmpty(null)) {
            charSequence = string.concat(": null");
        }
        this((String)charSequence, throwable, n2, n, string2, n3, zzafv2, n4, null, SystemClock.elapsedRealtime(), bl);
    }

    private zzaeg(String string, Throwable throwable, int n, int n2, String string2, int n3, zzafv zzafv2, int n4, zzo zzo2, long l, boolean bl) {
        boolean bl2;
        boolean bl3;
        block3: {
            block2: {
                block0: {
                    block1: {
                        super(string, throwable, n, l);
                        bl3 = false;
                        if (!bl) break block0;
                        n = n2;
                        if (n != 1) break block1;
                        n = 1;
                        break block2;
                    }
                    bl2 = false;
                    break block3;
                }
                n = n2;
            }
            bl2 = true;
        }
        zzakt.zza((boolean)bl2);
        bl2 = throwable == null ? bl3 : true;
        zzakt.zza((boolean)bl2);
        this.zza = n;
        this.zzb = string2;
        this.zzc = n3;
        this.zzd = zzafv2;
        this.zze = n4;
        this.zzf = zzo2;
        this.zzg = bl;
    }

    public static zzaeg zza(IOException iOException, int n) {
        return new zzaeg(0, iOException, n);
    }

    public static zzaeg zzb(Throwable throwable, String string, int n, zzafv zzafv2, int n2, boolean bl, int n3) {
        if (zzafv2 != null) return new zzaeg(1, throwable, null, n3, string, n, zzafv2, n2, bl);
        n2 = 4;
        return new zzaeg(1, throwable, null, n3, string, n, zzafv2, n2, bl);
    }

    public static zzaeg zzc(RuntimeException runtimeException, int n) {
        return new zzaeg(2, runtimeException, n);
    }

    final zzaeg zzd(zzo zzo2) {
        String string = this.getMessage();
        int n = zzamq.zza;
        return new zzaeg(string, this.getCause(), this.zzi, this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzo2, this.zzj, this.zzg);
    }
}
