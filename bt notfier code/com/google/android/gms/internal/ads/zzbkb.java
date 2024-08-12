/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.internal.zzf
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbkc
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbkc;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbkb
extends zzbkc {
    private final zzf zza;
    private final String zzb;
    private final String zzc;

    public zzbkb(zzf zzf2, String string, String string2) {
        this.zza = zzf2;
        this.zzb = string;
        this.zzc = string2;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.zza.zza((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
    }

    public final void zze() {
        this.zza.zzb();
    }

    public final void zzf() {
        this.zza.zzc();
    }
}
