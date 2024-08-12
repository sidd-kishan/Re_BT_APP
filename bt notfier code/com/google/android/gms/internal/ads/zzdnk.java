/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.internal.ads.zzblt
 *  com.google.android.gms.internal.ads.zzdnh
 *  com.google.android.gms.internal.ads.zzdog
 *  com.google.android.gms.internal.ads.zzfoj
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzdnh;
import com.google.android.gms.internal.ads.zzdog;
import com.google.android.gms.internal.ads.zzfoj;
import org.json.JSONObject;

final class zzdnk
implements zzblt {
    final zzdog zza;
    final ViewGroup zzb;

    zzdnk(zzdog zzdog2, ViewGroup viewGroup) {
        this.zza = zzdog2;
        this.zzb = viewGroup;
    }

    public final void zza() {
        block2: {
            Object object = this.zza;
            zzfoj zzfoj2 = zzdnh.zza;
            if ((object = object.zzk()) == null) return;
            int n = zzfoj2.size();
            int n2 = 0;
            while (n2 < n) {
                if (object.get((String)zzfoj2.get(n2)) == null) {
                    ++n2;
                    continue;
                }
                break block2;
            }
            return;
        }
        this.zza.onClick((View)this.zzb);
    }

    public final void zzb(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }

    public final JSONObject zzc() {
        return this.zza.zzp();
    }

    public final JSONObject zzd() {
        return this.zza.zzq();
    }
}
