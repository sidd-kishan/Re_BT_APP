/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzdcv
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzfid
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzdcv;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzfid;
import java.util.Set;

public final class zzdcw
extends zzdgm<zzfid>
implements zzbor {
    private final Bundle zzb = new Bundle();

    public zzdcw(Set<zzdih<zzfid>> set) {
        super(set);
    }

    public final void zza(String string, Bundle bundle) {
        synchronized (this) {
            this.zzb.putAll(bundle);
            this.zzk(zzdcv.zza);
            return;
        }
    }

    public final Bundle zzb() {
        synchronized (this) {
            Bundle bundle = new Bundle(this.zzb);
            return bundle;
        }
    }
}
