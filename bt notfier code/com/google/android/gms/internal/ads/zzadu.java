/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahp
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;

public abstract class zzadu
implements zzahp {
    protected final zzaip zza = new zzaip();

    protected zzadu() {
    }

    public final boolean zza() {
        zzaiq zzaiq2 = this.zzF();
        if (zzaiq2.zzt()) {
            return false;
        }
        int n = this.zzv();
        this.zzn();
        this.zzo();
        if (zzaiq2.zzc(n, 0, false) == -1) return false;
        return true;
    }

    public final boolean zzb() {
        zzaiq zzaiq2 = this.zzF();
        if (zzaiq2.zzt()) {
            return false;
        }
        int n = this.zzv();
        this.zzn();
        this.zzo();
        if (zzaiq2.zzb(n, 0, false) == -1) return false;
        return true;
    }

    public final boolean zzc() {
        zzaiq zzaiq2 = this.zzF();
        if (zzaiq2.zzt()) return false;
        if (!zzaiq2.zzf(this.zzv(), this.zza, 0L).zzb()) return false;
        return true;
    }

    public final boolean zzd() {
        zzaiq zzaiq2 = this.zzF();
        if (zzaiq2.zzt()) return false;
        if (!zzaiq2.zzf((int)this.zzv(), (zzaip)this.zza, (long)0L).zzg) return false;
        return true;
    }
}
