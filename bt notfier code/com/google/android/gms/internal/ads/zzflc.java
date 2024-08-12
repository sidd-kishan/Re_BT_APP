/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflb
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfst
 *  com.google.android.gms.internal.ads.zzfsu
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflb;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfst;
import com.google.android.gms.internal.ads.zzfsu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class zzflc {
    public static <V> zzfsm<V> zza(Task<V> task) {
        zzfsu zzfsu2 = zzfsu.zza();
        task.addOnCompleteListener(zzfst.zza(), (OnCompleteListener)new zzflb(zzfsu2));
        return zzfsu2;
    }
}
