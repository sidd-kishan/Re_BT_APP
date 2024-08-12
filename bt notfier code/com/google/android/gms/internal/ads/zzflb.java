/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsu
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zzflb
implements OnCompleteListener {
    private final zzfsu zza;

    zzflb(zzfsu zzfsu2) {
        this.zza = zzfsu2;
    }

    public final void onComplete(Task object) {
        zzfsu zzfsu2 = this.zza;
        if (object.isCanceled()) {
            zzfsu2.cancel(false);
            return;
        }
        if (object.isSuccessful()) {
            zzfsu2.zzp(object.getResult());
            return;
        }
        if ((object = object.getException()) == null) throw new IllegalStateException();
        zzfsu2.zzq((Throwable)object);
    }
}
