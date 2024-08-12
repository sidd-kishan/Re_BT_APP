/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.internal.ads.zzcby
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.ads.zzcby;

public final class zzcbw
extends zzcby {
    private final String zza;
    private final int zzb;

    public zzcbw(String string, int n) {
        this.zza = string;
        this.zzb = n;
    }

    public final boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof zzcbw)) {
            return false;
        }
        object = (zzcbw)((Object)object);
        if (!Objects.equal((Object)this.zza, (Object)((zzcbw)((Object)object)).zza)) return false;
        if (!Objects.equal((Object)this.zzb, (Object)((zzcbw)((Object)object)).zzb)) return false;
        return true;
    }

    public final String zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }
}
