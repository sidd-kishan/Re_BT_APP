/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnSuccessListener
 *  com.google.android.gms.tasks.OnTokenCanceledListener
 *  com.google.android.gms.tasks.zzb
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.zzb;

final class zza
implements OnSuccessListener<Void> {
    final OnTokenCanceledListener zza;

    zza(zzb zzb2, OnTokenCanceledListener onTokenCanceledListener) {
        this.zza = onTokenCanceledListener;
    }
}
