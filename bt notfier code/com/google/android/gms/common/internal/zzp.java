/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzm
 *  com.google.android.gms.common.internal.zzn
 *  com.google.android.gms.common.internal.zzo
 *  com.google.android.gms.common.internal.zzq
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzq;
import java.util.HashMap;

final class zzp
implements Handler.Callback {
    final zzq zza;

    /* synthetic */ zzp(zzq zzq2, zzn zzn2) {
        this.zza = zzq2;
    }

    public final boolean handleMessage(Message object) {
        int n = ((Message)object).what;
        if (n != 0) {
            if (n != 1) {
                return false;
            }
            HashMap hashMap = zzq.zzd((zzq)this.zza);
            synchronized (hashMap) {
                zzm zzm2 = (zzm)((Message)object).obj;
                zzo zzo2 = (zzo)zzq.zzd((zzq)this.zza).get(zzm2);
                if (zzo2 == null) return true;
                if (zzo2.zzf() != 3) return true;
                Object object2 = String.valueOf(zzm2);
                n = String.valueOf(object2).length();
                object = new StringBuilder(n + 47);
                ((StringBuilder)object).append("Timeout waiting for ServiceConnection callback ");
                ((StringBuilder)object).append((String)object2);
                object2 = ((StringBuilder)object).toString();
                object = new Exception();
                Log.e((String)"GmsClientSupervisor", (String)object2, (Throwable)object);
                object = object2 = zzo2.zzj();
                if (object2 == null) {
                    object = zzm2.zzb();
                }
                object2 = object;
                if (object == null) {
                    object = zzm2.zza();
                    Preconditions.checkNotNull((Object)object);
                    object2 = new ComponentName((String)object, "unknown");
                }
                zzo2.onServiceDisconnected((ComponentName)object2);
                return true;
            }
        }
        HashMap hashMap = zzq.zzd((zzq)this.zza);
        synchronized (hashMap) {
            zzm zzm3 = (zzm)((Message)object).obj;
            object = (zzo)zzq.zzd((zzq)this.zza).get(zzm3);
            if (object == null) return true;
            if (!object.zzh()) return true;
            if (object.zze()) {
                object.zzb("GmsClientSupervisor");
            }
            zzq.zzd((zzq)this.zza).remove(zzm3);
            return true;
        }
    }
}
