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

final class zzh
implements DynamiteModule.VersionPolicy {
    zzh() {
    }

    public final zzn zza(Context context, String string, zzm zzm2) throws DynamiteModule.LoadingException {
        zzn zzn2;
        block2: {
            int n;
            int n2;
            block1: {
                int n3;
                block0: {
                    zzn2 = new zzn();
                    zzn2.zza = n2 = zzm2.zzb(context, string);
                    n = 0;
                    zzn2.zzb = n2 != 0 ? (n2 = zzm2.zza(context, string, false)) : (n2 = zzm2.zza(context, string, true));
                    n3 = zzn2.zza;
                    if (n3 != 0) break block0;
                    if (n2 != 0) break block1;
                    zzn2.zzc = 0;
                    break block2;
                }
                n = n3;
            }
            zzn2.zzc = n >= n2 ? -1 : 1;
        }
        return zzn2;
    }
}
