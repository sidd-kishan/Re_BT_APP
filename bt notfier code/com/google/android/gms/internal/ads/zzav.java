/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzav {
    private final Map<String, String> zza = new HashMap<String, String>();
    private Map<String, String> zzb;

    public final Map<String, String> zza() {
        synchronized (this) {
            Map<String, String> map;
            if (this.zzb == null) {
                map = new Map<String, String>(this.zza);
                this.zzb = Collections.unmodifiableMap(map);
            }
            map = this.zzb;
            return map;
        }
    }
}
