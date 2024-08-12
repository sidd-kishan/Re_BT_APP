/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzvk
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvq
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwa
 *  com.google.android.gms.internal.ads.zzwb
 *  com.google.android.gms.internal.ads.zzwf
 *  com.google.android.gms.internal.ads.zzwg
 *  com.google.android.gms.internal.ads.zzwi
 *  com.google.android.gms.internal.ads.zzwl
 *  com.google.android.gms.internal.ads.zzwn
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzvk;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvq;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwa;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwn;
import java.util.Collections;
import java.util.Map;

public abstract class zzwc<T>
implements Comparable<zzwc<T>> {
    private final zzwn zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzwg zzf;
    private Integer zzg;
    private zzwf zzh;
    private boolean zzi;
    private zzvl zzj;
    private zzwb zzk;
    private final zzvq zzl;

    public zzwc(int n, String string, zzwg zzwg2) {
        zzwn zzwn2 = zzwn.zza ? new zzwn() : null;
        this.zza = zzwn2;
        this.zze = new Object();
        int n2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = n;
        this.zzc = string;
        this.zzf = zzwg2;
        this.zzl = new zzvq();
        n = n2;
        if (!TextUtils.isEmpty((CharSequence)string)) {
            string = Uri.parse((String)string);
            n = n2;
            if (string != null) {
                string = string.getHost();
                n = n2;
                if (string != null) {
                    n = string.hashCode();
                }
            }
        }
        this.zzd = n;
    }

    static /* synthetic */ zzwn zza(zzwc zzwc2) {
        return zzwc2.zza;
    }

    public final String toString() {
        String string = String.valueOf(Integer.toHexString(this.zzd));
        string = string.length() != 0 ? "0x".concat(string) : new String("0x");
        this.zzm();
        String string2 = this.zzc;
        String string3 = String.valueOf(this.zzg);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 7 + String.valueOf(string).length() + 6 + String.valueOf(string3).length());
        stringBuilder.append("[ ] ");
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        stringBuilder.append(" NORMAL ");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final void zzd(String string) {
        if (!zzwn.zza) return;
        this.zza.zza(string, Thread.currentThread().getId());
    }

    final void zze(String string) {
        zzwf zzwf2 = this.zzh;
        if (zzwf2 != null) {
            zzwf2.zzc(this);
        }
        if (!zzwn.zza) return;
        long l = Thread.currentThread().getId();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post((Runnable)new zzwa(this, string, l));
            return;
        }
        this.zza.zza(string, l);
        this.zza.zzb(this.toString());
    }

    final void zzf(int n) {
        zzwf zzwf2 = this.zzh;
        if (zzwf2 == null) return;
        zzwf2.zzd(this, n);
    }

    public final zzwc<?> zzg(zzwf zzwf2) {
        this.zzh = zzwf2;
        return this;
    }

    public final zzwc<?> zzh(int n) {
        this.zzg = n;
        return this;
    }

    public final String zzi() {
        return this.zzc;
    }

    public final String zzj() {
        String string;
        String string2 = string = this.zzc;
        if (this.zzb == 0) return string2;
        string2 = Integer.toString(1);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 1 + String.valueOf(string).length());
        stringBuilder.append(string2);
        stringBuilder.append('-');
        stringBuilder.append(string);
        string2 = stringBuilder.toString();
        return string2;
    }

    public final zzwc<?> zzk(zzvl zzvl2) {
        this.zzj = zzvl2;
        return this;
    }

    public final zzvl zzl() {
        return this.zzj;
    }

    public final boolean zzm() {
        Object object = this.zze;
        synchronized (object) {
            return false;
        }
    }

    public Map<String, String> zzn() throws zzvk {
        return Collections.emptyMap();
    }

    public byte[] zzo() throws zzvk {
        return null;
    }

    public final int zzp() {
        return this.zzl.zza();
    }

    public final void zzq() {
        Object object = this.zze;
        synchronized (object) {
            this.zzi = true;
            return;
        }
    }

    public final boolean zzr() {
        Object object = this.zze;
        synchronized (object) {
            boolean bl = this.zzi;
            return bl;
        }
    }

    protected abstract zzwi<T> zzs(zzvy var1);

    protected abstract void zzt(T var1);

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzu(zzwl zzwl2) {
        zzwg zzwg2;
        Object object = this.zze;
        synchronized (object) {
            zzwg2 = this.zzf;
        }
        if (zzwg2 == null) return;
        zzwg2.zza(zzwl2);
    }

    final void zzv(zzwb zzwb2) {
        Object object = this.zze;
        synchronized (object) {
            this.zzk = zzwb2;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final void zzw(zzwi<?> zzwi2) {
        zzwb zzwb2;
        Object object = this.zze;
        synchronized (object) {
            zzwb2 = this.zzk;
        }
        if (zzwb2 == null) return;
        zzwb2.zza(this, zzwi2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final void zzx() {
        zzwb zzwb2;
        Object object = this.zze;
        synchronized (object) {
            zzwb2 = this.zzk;
        }
        if (zzwb2 == null) return;
        zzwb2.zzb(this);
    }

    public final zzvq zzy() {
        return this.zzl;
    }
}
