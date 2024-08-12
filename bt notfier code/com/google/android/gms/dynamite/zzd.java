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

final class zzd
implements DynamiteModule.VersionPolicy {
    zzd() {
    }

    public final zzn zza(Context context, String string, zzm zzm2) throws DynamiteModule.LoadingException {
        int n;
        zzn zzn2 = new zzn();
        zzn2.zzb = n = zzm2.zza(context, string, true);
        if (n != 0) {
            zzn2.zzc = 1;
        } else {
            zzn2.zza = n = zzm2.zzb(context, string);
            if (n == 0) return zzn2;
            zzn2.zzc = -1;
        }
        return zzn2;
    }
}
