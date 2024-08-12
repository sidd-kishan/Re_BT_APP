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

final class zzf
implements DynamiteModule.VersionPolicy {
    zzf() {
    }

    public final zzn zza(Context context, String string, zzm zzm2) throws DynamiteModule.LoadingException {
        int n;
        zzn zzn2 = new zzn();
        zzn2.zzb = n = zzm2.zza(context, string, false);
        zzn2.zzc = n == 0 ? 0 : 1;
        return zzn2;
    }
}
