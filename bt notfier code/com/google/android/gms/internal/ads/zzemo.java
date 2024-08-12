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

final class zzemo
implements zzerx {
    private final String zza;

    zzemo(String string) {
        this.zza = string;
    }

    public final void zzf(Object object) {
        String string = this.zza;
        ((Bundle)object).putString("ms", string);
    }
}
