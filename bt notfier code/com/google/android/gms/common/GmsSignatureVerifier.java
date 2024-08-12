/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.zzm
 *  com.google.android.gms.common.zzy
 *  com.google.android.gms.common.zzz
 *  com.google.android.gms.internal.common.zzu
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzm;
import com.google.android.gms.common.zzy;
import com.google.android.gms.common.zzz;
import com.google.android.gms.internal.common.zzu;
import java.util.List;

public class GmsSignatureVerifier {
    private static final zzz zza;
    private static final zzz zzb;

    static {
        zzy zzy2 = new zzy();
        zzy2.zza("com.google.android.gms");
        zzy2.zzb(204200000L);
        zzy2.zzc((List)zzu.zzk((Object)zzm.zzd.zzc(), (Object)zzm.zzb.zzc()));
        zzy2.zzd((List)zzu.zzk((Object)zzm.zzc.zzc(), (Object)zzm.zza.zzc()));
        zza = zzy2.zze();
        zzy2 = new zzy();
        zzy2.zza("com.android.vending");
        zzy2.zzb(82240000L);
        zzy2.zzc((List)zzu.zzj((Object)zzm.zzd.zzc()));
        zzy2.zzd((List)zzu.zzj((Object)zzm.zzc.zzc()));
        zzb = zzy2.zze();
    }
}
