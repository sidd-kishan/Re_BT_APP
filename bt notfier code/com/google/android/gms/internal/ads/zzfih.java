/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfkk
 *  com.google.android.gms.internal.ads.zzxv
 *  com.google.android.gms.internal.ads.zzxz
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfkk;
import com.google.android.gms.internal.ads.zzxv;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzfih
implements Continuation {
    private final zzxv zza;
    private final int zzb;

    zzfih(zzxv zzxv2, int n) {
        this.zza = zzxv2;
        this.zzb = n;
    }

    public final Object then(Task object) {
        zzxv zzxv2 = this.zza;
        int n = this.zzb;
        int n2 = zzfii.zza;
        if (object.isSuccessful()) {
            object = ((zzfkk)object.getResult()).zza(((zzxz)zzxv2.zzah()).zzao());
            object.zzc(n);
            object.zza();
            object = true;
        } else {
            object = false;
        }
        return object;
    }
}
