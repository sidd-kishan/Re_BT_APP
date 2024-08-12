/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzanc
 *  com.google.android.gms.internal.ads.zzanv
 *  com.google.android.gms.internal.ads.zzanx
 *  com.google.android.gms.internal.ads.zzapq
 *  com.google.android.gms.internal.ads.zzasl
 *  com.google.android.gms.internal.ads.zzasm
 *  com.google.android.gms.internal.ads.zzasp
 *  com.google.android.gms.internal.ads.zzasq
 *  com.google.android.gms.internal.ads.zzasr
 *  com.google.android.gms.internal.ads.zzate
 *  com.google.android.gms.internal.ads.zzaty
 *  com.google.android.gms.internal.ads.zzauc
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzanv;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzasl;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzasp;
import com.google.android.gms.internal.ads.zzasq;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzate;
import com.google.android.gms.internal.ads.zzaty;
import com.google.android.gms.internal.ads.zzauc;
import com.google.android.gms.internal.ads.zzaup;
import java.io.IOException;

public final class zzasn
implements zzasr,
zzasq {
    private final Uri zza;
    private final zzaty zzb;
    private final zzapq zzc;
    private final int zzd;
    private final Handler zze;
    private final zzasm zzf;
    private final zzanv zzg;
    private final int zzh;
    private zzasq zzi;
    private zzanx zzj;
    private boolean zzk;

    public zzasn(Uri uri, zzaty zzaty2, zzapq zzapq2, int n, Handler handler, zzasm zzasm2, String string, int n2) {
        this.zza = uri;
        this.zzb = zzaty2;
        this.zzc = zzapq2;
        this.zzd = n;
        this.zze = handler;
        this.zzf = zzasm2;
        this.zzh = n2;
        this.zzg = new zzanv();
    }

    public final void zza(zzanc zzanc2, boolean bl, zzasq zzasq2) {
        this.zzi = zzasq2;
        zzanc2 = new zzate(-9223372036854775807L, false);
        this.zzj = zzanc2;
        zzasq2.zzi((zzanx)zzanc2, null);
    }

    public final void zzb() throws IOException {
    }

    public final void zzc(zzasp zzasp2) {
        ((zzasl)zzasp2).zzk();
    }

    public final void zzd() {
        this.zzi = null;
    }

    public final zzasp zze(int n, zzauc zzauc2) {
        boolean bl = n == 0;
        zzaup.zza((boolean)bl);
        return new zzasl(this.zza, this.zzb.zza(), this.zzc.zza(), this.zzd, this.zze, this.zzf, (zzasq)this, zzauc2, null, this.zzh, null);
    }

    public final void zzi(zzanx zzanx2, Object object) {
        object = this.zzg;
        boolean bl = false;
        zzanx2.zzd(0, (zzanv)object, false);
        if (((zzanv)object).zzc != -9223372036854775807L) {
            bl = true;
        }
        if (this.zzk && !bl) {
            return;
        }
        this.zzj = zzanx2;
        this.zzk = bl;
        this.zzi.zzi(zzanx2, null);
    }
}
