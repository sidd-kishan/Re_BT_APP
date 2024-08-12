/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzkd
 *  com.google.android.gms.internal.ads.zzkm
 *  com.google.android.gms.internal.ads.zzkn
 *  com.google.android.gms.internal.ads.zzkx
 *  com.google.android.gms.internal.ads.zzlj
 *  com.google.android.gms.internal.ads.zzlr
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzkd;
import com.google.android.gms.internal.ads.zzkm;
import com.google.android.gms.internal.ads.zzkn;
import com.google.android.gms.internal.ads.zzkx;
import com.google.android.gms.internal.ads.zzlj;
import com.google.android.gms.internal.ads.zzlr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzkt
implements zzaj {
    private final Context zza;
    private final List<zzay> zzb;
    private final zzaj zzc;
    private zzaj zzd;
    private zzaj zze;
    private zzaj zzf;
    private zzaj zzg;
    private zzaj zzh;
    private zzaj zzi;
    private zzaj zzj;
    private zzaj zzk;

    public zzkt(Context context, zzaj zzaj2) {
        this.zza = context.getApplicationContext();
        this.zzc = zzaj2;
        this.zzb = new ArrayList<zzay>();
    }

    private final zzaj zzb() {
        if (this.zze != null) return this.zze;
        zzkd zzkd2 = new zzkd(this.zza);
        this.zze = zzkd2;
        this.zzc((zzaj)zzkd2);
        return this.zze;
    }

    private final void zzc(zzaj zzaj2) {
        int n = 0;
        while (n < this.zzb.size()) {
            zzaj2.zza(this.zzb.get(n));
            ++n;
        }
    }

    private static final void zzd(zzaj zzaj2, zzay zzay2) {
        if (zzaj2 == null) return;
        zzaj2.zza(zzay2);
    }

    public final void zza(zzay zzay2) {
        if (zzay2 == null) throw null;
        this.zzc.zza(zzay2);
        this.zzb.add(zzay2);
        zzkt.zzd(this.zzd, zzay2);
        zzkt.zzd(this.zze, zzay2);
        zzkt.zzd(this.zzf, zzay2);
        zzkt.zzd(this.zzg, zzay2);
        zzkt.zzd(this.zzh, zzay2);
        zzkt.zzd(this.zzi, zzay2);
        zzkt.zzd(this.zzj, zzay2);
    }

    public final Map<String, List<String>> zzf() {
        Object object = this.zzk;
        object = object == null ? Collections.emptyMap() : object.zzf();
        return object;
    }

    public final int zzg(byte[] byArray, int n, int n2) throws IOException {
        zzaj zzaj2 = this.zzk;
        if (zzaj2 == null) throw null;
        return zzaj2.zzg(byArray, n, n2);
    }

    public final long zzh(zzan zzan2) throws IOException {
        boolean bl = this.zzk == null;
        zzakt.zzd((boolean)bl);
        String string = zzan2.zza.getScheme();
        if (zzamq.zzb((Uri)zzan2.zza)) {
            string = zzan2.zza.getPath();
            if (string != null && string.startsWith("/android_asset/")) {
                this.zzk = this.zzb();
            } else {
                if (this.zzd == null) {
                    string = new zzkx();
                    this.zzd = string;
                    this.zzc((zzaj)string);
                }
                this.zzk = this.zzd;
            }
        } else if ("asset".equals(string)) {
            this.zzk = this.zzb();
        } else if ("content".equals(string)) {
            if (this.zzf == null) {
                string = new zzkm(this.zza);
                this.zzf = string;
                this.zzc((zzaj)string);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(string)) {
            if (this.zzg == null) {
                try {
                    string = (zzaj)Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = string;
                    this.zzc((zzaj)string);
                }
                catch (Exception exception) {
                    throw new RuntimeException("Error instantiating RTMP extension", exception);
                }
                catch (ClassNotFoundException classNotFoundException) {
                    Log.w((String)"DefaultDataSource", (String)"Attempting to play RTMP stream without depending on the RTMP extension");
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(string)) {
            if (this.zzh == null) {
                string = new zzlr(2000);
                this.zzh = string;
                this.zzc((zzaj)string);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(string)) {
            if (this.zzi == null) {
                string = new zzkn();
                this.zzi = string;
                this.zzc((zzaj)string);
            }
            this.zzk = this.zzi;
        } else {
            if (!"rawresource".equals(string) && !"android.resource".equals(string)) {
                string = this.zzc;
            } else {
                if (this.zzj == null) {
                    string = new zzlj(this.zza);
                    this.zzj = string;
                    this.zzc((zzaj)string);
                }
                string = this.zzj;
            }
            this.zzk = string;
        }
        return this.zzk.zzh(zzan2);
    }

    public final Uri zzi() {
        zzaj zzaj2 = this.zzk;
        if (zzaj2 != null) return zzaj2.zzi();
        return null;
    }

    public final void zzj() throws IOException {
        zzaj zzaj2 = this.zzk;
        if (zzaj2 == null) return;
        try {
            zzaj2.zzj();
            return;
        }
        finally {
            this.zzk = null;
        }
    }
}
