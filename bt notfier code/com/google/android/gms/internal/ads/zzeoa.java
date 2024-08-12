/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 *  com.google.android.gms.internal.ads.zzenz
 *  com.google.android.gms.internal.ads.zzeob
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.internal.ads.zzenz;
import com.google.android.gms.internal.ads.zzeob;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzeoa
implements zzery<zzeob> {
    private final zzfsn zza;
    private final Context zzb;

    public zzeoa(zzfsn zzfsn2, Context context) {
        this.zza = zzfsn2;
        this.zzb = context;
    }

    public final zzfsm<zzeob> zza() {
        return this.zza.zzb((Callable)new zzenz(this));
    }

    final /* synthetic */ zzeob zzb() throws Exception {
        double d;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter = this.zzb.registerReceiver(null, intentFilter);
        boolean bl = false;
        if (intentFilter != null) {
            int n = intentFilter.getIntExtra("status", -1);
            double d2 = intentFilter.getIntExtra("level", -1);
            d = intentFilter.getIntExtra("scale", -1);
            Double.isNaN(d2);
            Double.isNaN(d);
            d2 /= d;
            if (n != 2) {
                d = d2;
                if (n != 5) return new zzeob(d, bl);
            }
            bl = true;
            d = d2;
        } else {
            d = -1.0;
        }
        return new zzeob(d, bl);
    }
}
