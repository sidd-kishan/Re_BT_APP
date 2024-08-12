/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.util.zze
 */
package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zze;

public final class zzs
extends zzl {
    public zzs(Activity activity) {
        super(activity);
    }

    public final void zzh(Bundle bundle) {
        zze.zza((String)"AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzn = 4;
        this.zzb.finish();
    }
}
