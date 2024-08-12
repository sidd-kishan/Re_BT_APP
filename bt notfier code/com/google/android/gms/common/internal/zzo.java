/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Message
 *  com.google.android.gms.common.internal.zzm
 *  com.google.android.gms.common.internal.zzq
 *  com.google.android.gms.common.internal.zzr
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class zzo
implements ServiceConnection,
zzr {
    final zzq zza;
    private final Map<ServiceConnection, ServiceConnection> zzb;
    private int zzc;
    private boolean zzd;
    private IBinder zze;
    private final zzm zzf;
    private ComponentName zzg;

    public zzo(zzq zzq2, zzm zzm2) {
        this.zza = zzq2;
        this.zzf = zzm2;
        this.zzb = new HashMap<ServiceConnection, ServiceConnection>();
        this.zzc = 2;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap = zzq.zzd((zzq)this.zza);
        synchronized (hashMap) {
            try {
                zzq.zze((zzq)this.zza).removeMessages(1, (Object)this.zzf);
                this.zze = iBinder;
                this.zzg = componentName;
                Iterator<ServiceConnection> iterator = this.zzb.values().iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.zzc = 1;
                        return;
                    }
                    iterator.next().onServiceConnected(componentName, iBinder);
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap = zzq.zzd((zzq)this.zza);
        synchronized (hashMap) {
            try {
                zzq.zze((zzq)this.zza).removeMessages(1, (Object)this.zzf);
                this.zze = null;
                this.zzg = componentName;
                Iterator<ServiceConnection> iterator = this.zzb.values().iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.zzc = 2;
                        return;
                    }
                    iterator.next().onServiceDisconnected(componentName);
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void zza(String string) {
        boolean bl;
        this.zzc = 3;
        this.zzd = bl = zzq.zzg((zzq)this.zza).zza(zzq.zzf((zzq)this.zza), string, this.zzf.zzd(zzq.zzf((zzq)this.zza)), (ServiceConnection)this, this.zzf.zzc());
        if (bl) {
            string = zzq.zze((zzq)this.zza).obtainMessage(1, (Object)this.zzf);
            zzq.zze((zzq)this.zza).sendMessageDelayed((Message)string, zzq.zzh((zzq)this.zza));
            return;
        }
        this.zzc = 2;
        try {
            zzq.zzg((zzq)this.zza).unbindService(zzq.zzf((zzq)this.zza), (ServiceConnection)this);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return;
        }
    }

    public final void zzb(String string) {
        zzq.zze((zzq)this.zza).removeMessages(1, (Object)this.zzf);
        zzq.zzg((zzq)this.zza).unbindService(zzq.zzf((zzq)this.zza), (ServiceConnection)this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final void zzc(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String string) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zzd(ServiceConnection serviceConnection, String string) {
        this.zzb.remove(serviceConnection);
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzc;
    }

    public final boolean zzg(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzh() {
        return this.zzb.isEmpty();
    }

    public final IBinder zzi() {
        return this.zze;
    }

    public final ComponentName zzj() {
        return this.zzg;
    }
}
