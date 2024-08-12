/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzetg
 *  com.google.android.gms.internal.ads.zzeth
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzetg;
import com.google.android.gms.internal.ads.zzeth;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzetf
implements Callable {
    private final zzetg zza;

    zzetf(zzetg zzetg2) {
        this.zza = zzetg2;
    }

    public final Object call() {
        return new zzeth(new JSONObject());
    }
}
