/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzaxe
 *  com.google.android.gms.internal.ads.zzaxf
 *  com.google.android.gms.internal.ads.zzaxg
 *  com.google.android.gms.internal.ads.zzaxi
 *  com.google.android.gms.internal.ads.zzaxj
 *  com.google.android.gms.internal.ads.zzaxm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzaxe;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzaxm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.PriorityQueue;

public final class zzaxh {
    private final int zza;
    private final zzaxe zzb = new zzaxj();

    public zzaxh(int n) {
        this.zza = n;
    }

    public final String zza(ArrayList<String> object) {
        int n;
        Object object2 = new StringBuilder();
        int n2 = object.size();
        for (n = 0; n < n2; ++n) {
            ((StringBuilder)object2).append(((String)object.get(n)).toLowerCase(Locale.US));
            ((StringBuilder)object2).append('\n');
        }
        if (((String[])(object2 = ((StringBuilder)object2).toString().split("\n"))).length == 0) {
            object = "";
        } else {
            object = new zzaxg();
            Object object32 = new PriorityQueue(this.zza, new zzaxf(this));
            for (n = 0; n < ((String[])object2).length; ++n) {
                String[] stringArray = zzaxi.zzb((String)object2[n], (boolean)false);
                if (stringArray.length == 0) continue;
                zzaxm.zza((String[])stringArray, (int)this.zza, (int)6, (PriorityQueue)object32);
            }
            for (Object object32 : object32) {
                try {
                    object32 = this.zzb.zza(object32.zzb);
                    ((zzaxg)object).zzb.write((byte[])object32);
                }
                catch (IOException iOException) {
                    zze.zzg((String)"Error while writing hash to byteStream", (Throwable)iOException);
                    break;
                }
            }
            object = object.toString();
        }
        return object;
    }
}
