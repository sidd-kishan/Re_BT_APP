/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzerx
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzerx;

final class zzerq
implements zzerx {
    static final zzerx zza = new zzerq();

    private zzerq() {
    }

    public final void zzf(Object object) {
        ((Bundle)object).putBoolean("sdk_prefetch", true);
    }
}
