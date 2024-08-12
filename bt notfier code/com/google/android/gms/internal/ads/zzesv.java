/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzesw
 *  com.google.android.gms.internal.ads.zzesx
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzesw;
import com.google.android.gms.internal.ads.zzesx;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzesv
implements Callable {
    private final zzesw zza;

    zzesv(zzesw zzesw2) {
        this.zza = zzesw2;
    }

    public final Object call() {
        return new zzesx(new JSONObject());
    }
}
