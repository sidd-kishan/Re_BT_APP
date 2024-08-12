/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.IGmsServiceBroker
 *  com.google.android.gms.common.internal.zzab
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.zzab;

public final class zze
implements ServiceConnection {
    final BaseGmsClient zza;
    private final int zzb;

    public zze(BaseGmsClient baseGmsClient, int n) {
        this.zza = baseGmsClient;
        this.zzb = n;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onServiceConnected(ComponentName object, IBinder iBinder) {
        if (iBinder == null) {
            BaseGmsClient.zzc((BaseGmsClient)this.zza, (int)16);
            return;
        }
        Object object2 = BaseGmsClient.zzd((BaseGmsClient)this.zza);
        synchronized (object2) {
            BaseGmsClient baseGmsClient = this.zza;
            object = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            object = object != null && object instanceof IGmsServiceBroker ? (IGmsServiceBroker)object : new zzab(iBinder);
            BaseGmsClient.zze((BaseGmsClient)baseGmsClient, (IGmsServiceBroker)object);
        }
        this.zza.zzb(0, null, this.zzb);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onServiceDisconnected(ComponentName object) {
        object = BaseGmsClient.zzd((BaseGmsClient)this.zza);
        synchronized (object) {
            BaseGmsClient.zze((BaseGmsClient)this.zza, null);
        }
        object = this.zza.zzb;
        object.sendMessage(object.obtainMessage(6, this.zzb, 1));
    }
}
