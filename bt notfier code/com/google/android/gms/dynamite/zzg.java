/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.dynamite.DynamiteModule$LoadingException
 *  com.google.android.gms.dynamite.DynamiteModule$VersionPolicy
 *  com.google.android.gms.dynamite.zzm
 *  com.google.android.gms.dynamite.zzn
 */
package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.zzm;
import com.google.android.gms.dynamite.zzn;

final class zzg
implements DynamiteModule.VersionPolicy {
    zzg() {
    }

    /*
     * Enabled force condition propagation
     */
    public final zzn zza(Context context, String string, zzm zzm2) throws DynamiteModule.LoadingException {
        int n;
        int n2;
        zzn zzn2 = new zzn();
        zzn2.zza = zzm2.zzb(context, string);
        zzn2.zzb = n2 = zzm2.zza(context, string, true);
        int n3 = n = zzn2.zza;
        if (n == 0) {
            if (n2 == 0) {
                zzn2.zzc = 0;
                return zzn2;
            }
            n3 = 0;
        }
        if (n3 >= n2) {
            zzn2.zzc = -1;
            return zzn2;
        }
        zzn2.zzc = 1;
        return zzn2;
    }
}
