/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdInspectorError
 *  com.google.android.gms.ads.OnAdInspectorClosedListener
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbgp
 *  com.google.android.gms.internal.ads.zzbhp
 *  com.google.android.gms.internal.ads.zzbhs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhs;
import javax.annotation.Nullable;

final class zzbhq
extends zzbgp {
    private zzbhq() {
    }

    /* synthetic */ zzbhq(zzbhp zzbhp2) {
    }

    public final void zze(@Nullable zzbcz object) {
        OnAdInspectorClosedListener onAdInspectorClosedListener = zzbhs.zzd((zzbhs)zzbhs.zze());
        if (onAdInspectorClosedListener == null) return;
        object = object == null ? null : new AdInspectorError(object.zza, object.zzb, object.zzc);
        onAdInspectorClosedListener.onAdInspectorClosed((AdInspectorError)object);
    }
}
