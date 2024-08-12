/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgax
 *  com.google.android.gms.internal.ads.zzgbx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgax;
import com.google.android.gms.internal.ads.zzgbx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import java.util.List;

@Deprecated
public final class zzgby
extends zzgga<zzgby, zzgbx>
implements zzghj {
    private static final zzgby zzf;
    private String zzb = "";
    private zzggj<zzgax> zze = zzgby.zzaE();

    static {
        zzgby zzgby2;
        zzf = zzgby2 = new zzgby();
        zzgga.zzay(zzgby.class, (zzgga)zzgby2);
    }

    private zzgby() {
    }

    public static zzgby zzc() {
        return zzf;
    }

    static /* synthetic */ zzgby zzd() {
        return zzf;
    }

    public final List<zzgax> zza() {
        return this.zze;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgby.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0208\u0002\u001b", (Object[])new Object[]{"zzb", "zze", zzgax.class});
        if (n == 3) return new zzgby();
        if (n == 4) return new zzgbx(null);
        if (n == 5) return zzf;
        return null;
    }
}
