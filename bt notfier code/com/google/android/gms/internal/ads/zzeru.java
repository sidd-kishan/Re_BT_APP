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

final class zzeru
implements zzerx {
    private final Bundle zza;

    zzeru(Bundle bundle) {
        this.zza = bundle;
    }

    public final void zzf(Object object) {
        Bundle bundle = this.zza;
        ((Bundle)object).putBundle("shared_pref", bundle);
    }
}
