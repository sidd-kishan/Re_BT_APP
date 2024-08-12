/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzbpr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbpr;
import java.util.Map;

public final class zzbos
implements zzbpr<Object> {
    private final zzbot zza;

    public zzbos(zzbot zzbot2) {
        this.zza = zzbot2;
    }

    public final void zza(Object object, Map<String, String> map) {
        object = map.get("name");
        if (object == null) {
            zze.zzi((String)"App event with no name parameter.");
            return;
        }
        this.zza.zzbA((String)object, map.get("info"));
    }
}
