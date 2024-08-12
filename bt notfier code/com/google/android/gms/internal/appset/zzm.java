/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.appset.zza
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.internal.appset.zzd
 *  com.google.android.gms.internal.appset.zzf
 *  com.google.android.gms.internal.appset.zzg
 *  com.google.android.gms.internal.appset.zzo
 *  com.google.android.gms.internal.appset.zzp
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.internal.appset;

import com.google.android.gms.appset.zza;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.appset.zzd;
import com.google.android.gms.internal.appset.zzf;
import com.google.android.gms.internal.appset.zzg;
import com.google.android.gms.internal.appset.zzo;
import com.google.android.gms.internal.appset.zzp;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzm
implements RemoteCall {
    public final zzp zza;

    public /* synthetic */ zzm(zzp zzp2) {
        this.zza = zzp2;
    }

    public final void accept(Object object, Object object2) {
        zzp zzp2 = this.zza;
        object = (zzd)object;
        object2 = (TaskCompletionSource)object2;
        ((zzg)object.getService()).zzc(new zza(null, null), (zzf)new zzo(zzp2, (TaskCompletionSource)object2));
    }
}
