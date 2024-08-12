/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzfar;

public final class zzeml
implements zzerx<Bundle> {
    final zzfar zza;
    private final long zzb;

    public zzeml(zzfar zzfar2, long l) {
        Preconditions.checkNotNull((Object)zzfar2, (Object)"the targeting must not be null");
        this.zza = zzfar2;
        this.zzb = l;
    }
}
