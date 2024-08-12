/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdc
 *  com.google.android.gms.internal.ads.zzdd
 *  com.google.android.gms.internal.ads.zzde
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdd;
import com.google.android.gms.internal.ads.zzde;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class zzeb
implements zzde {
    protected zzdc zzb;
    protected zzdc zzc;
    private zzdc zzd;
    private zzdc zze;
    private ByteBuffer zzf = zza;
    private ByteBuffer zzg = zza;
    private boolean zzh;

    public zzeb() {
        this.zzd = zzdc.zza;
        this.zze = zzdc.zza;
        this.zzb = zzdc.zza;
        this.zzc = zzdc.zza;
    }

    public final zzdc zza(zzdc zzdc2) throws zzdd {
        this.zzd = zzdc2;
        this.zze = this.zzk(zzdc2);
        zzdc2 = this.zzb() ? this.zze : zzdc.zza;
        return zzdc2;
    }

    public boolean zzb() {
        if (this.zze == zzdc.zza) return false;
        return true;
    }

    public final void zzd() {
        this.zzh = true;
        this.zzl();
    }

    public ByteBuffer zze() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zza;
        return byteBuffer;
    }

    public boolean zzf() {
        if (!this.zzh) return false;
        if (this.zzg != zza) return false;
        return true;
    }

    public final void zzg() {
        this.zzg = zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        this.zzm();
    }

    public final void zzh() {
        this.zzg();
        this.zzf = zza;
        this.zzd = zzdc.zza;
        this.zze = zzdc.zza;
        this.zzb = zzdc.zza;
        this.zzc = zzdc.zza;
        this.zzn();
    }

    protected final ByteBuffer zzi(int n) {
        ByteBuffer byteBuffer;
        if (this.zzf.capacity() < n) {
            this.zzf = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        this.zzg = byteBuffer = this.zzf;
        return byteBuffer;
    }

    protected final boolean zzj() {
        return this.zzg.hasRemaining();
    }

    protected zzdc zzk(zzdc zzdc2) throws zzdd {
        throw null;
    }

    protected void zzl() {
    }

    protected void zzm() {
    }

    protected void zzn() {
    }
}
