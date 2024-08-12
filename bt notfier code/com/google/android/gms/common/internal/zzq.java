/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.google.android.gms.common.internal.GmsClientSupervisor
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzm
 *  com.google.android.gms.common.internal.zzo
 *  com.google.android.gms.common.internal.zzp
 *  com.google.android.gms.common.stats.ConnectionTracker
 *  com.google.android.gms.internal.common.zzh
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzh;
import java.util.HashMap;

final class zzq
extends GmsClientSupervisor {
    private final HashMap<zzm, zzo> zza = new HashMap();
    private final Context zzb;
    private final Handler zzc;
    private final ConnectionTracker zzd;
    private final long zze;
    private final long zzf;

    zzq(Context context) {
        this.zzb = context.getApplicationContext();
        this.zzc = new zzh(context.getMainLooper(), (Handler.Callback)new zzp(this, null));
        this.zzd = ConnectionTracker.getInstance();
        this.zze = 5000L;
        this.zzf = 300000L;
    }

    static /* synthetic */ HashMap zzd(zzq zzq2) {
        return zzq2.zza;
    }

    static /* synthetic */ Handler zze(zzq zzq2) {
        return zzq2.zzc;
    }

    static /* synthetic */ Context zzf(zzq zzq2) {
        return zzq2.zzb;
    }

    static /* synthetic */ ConnectionTracker zzg(zzq zzq2) {
        return zzq2.zzd;
    }

    static /* synthetic */ long zzh(zzq zzq2) {
        return zzq2.zzf;
    }

    protected final boolean zzb(zzm object, ServiceConnection object2, String charSequence) {
        Preconditions.checkNotNull((Object)object2, (Object)"ServiceConnection must not be null");
        HashMap<zzm, zzo> hashMap = this.zza;
        synchronized (hashMap) {
            zzo zzo2 = this.zza.get(object);
            if (zzo2 == null) {
                zzo2 = new zzo(this, object);
                zzo2.zzc(object2, object2, (String)charSequence);
                zzo2.zza((String)charSequence);
                this.zza.put((zzm)object, zzo2);
                object = zzo2;
            } else {
                this.zzc.removeMessages(0, object);
                if (zzo2.zzg(object2)) {
                    object = String.valueOf(object);
                    int n = String.valueOf(object).length();
                    charSequence = new StringBuilder(n + 81);
                    ((StringBuilder)charSequence).append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    ((StringBuilder)charSequence).append((String)object);
                    object2 = new IllegalStateException(((StringBuilder)charSequence).toString());
                    throw object2;
                }
                zzo2.zzc(object2, object2, (String)charSequence);
                int n = zzo2.zzf();
                if (n != 1) {
                    if (n != 2) {
                        object = zzo2;
                    } else {
                        zzo2.zza((String)charSequence);
                        object = zzo2;
                    }
                } else {
                    object2.onServiceConnected(zzo2.zzj(), zzo2.zzi());
                    object = zzo2;
                }
            }
            boolean bl = object.zze();
            return bl;
        }
    }

    protected final void zzc(zzm object, ServiceConnection object2, String charSequence) {
        Preconditions.checkNotNull((Object)object2, (Object)"ServiceConnection must not be null");
        HashMap<zzm, zzo> hashMap = this.zza;
        synchronized (hashMap) {
            zzo zzo2 = this.zza.get(object);
            if (zzo2 == null) {
                object = String.valueOf(object);
                int n = String.valueOf(object).length();
                charSequence = new StringBuilder(n + 50);
                ((StringBuilder)charSequence).append("Nonexistent connection status for service config: ");
                ((StringBuilder)charSequence).append((String)object);
                object2 = new IllegalStateException(((StringBuilder)charSequence).toString());
                throw object2;
            }
            if (zzo2.zzg(object2)) {
                zzo2.zzd(object2, (String)charSequence);
                if (!zzo2.zzh()) return;
                object = this.zzc.obtainMessage(0, object);
                this.zzc.sendMessageDelayed((Message)object, this.zze);
                return;
            }
            charSequence = String.valueOf(object);
            int n = String.valueOf(charSequence).length();
            object = new StringBuilder(n + 76);
            ((StringBuilder)object).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
            ((StringBuilder)object).append((String)charSequence);
            object2 = new IllegalStateException(((StringBuilder)object).toString());
            throw object2;
        }
    }
}
