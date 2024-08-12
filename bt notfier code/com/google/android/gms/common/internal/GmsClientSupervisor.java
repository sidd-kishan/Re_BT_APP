/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  com.google.android.gms.common.internal.zzm
 *  com.google.android.gms.common.internal.zzq
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzq;

public abstract class GmsClientSupervisor {
    private static int zza = 4225;
    private static final Object zzb = new Object();
    private static GmsClientSupervisor zzc;

    public static int getDefaultBindFlags() {
        return zza;
    }

    public static GmsClientSupervisor getInstance(Context context) {
        Object object = zzb;
        synchronized (object) {
            if (zzc != null) return zzc;
            zzq zzq2 = new zzq(context.getApplicationContext());
            zzc = zzq2;
            return zzc;
        }
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String string) {
        return this.zzb(new zzm(componentName, GmsClientSupervisor.getDefaultBindFlags()), serviceConnection, string);
    }

    public boolean bindService(String string, ServiceConnection serviceConnection, String string2) {
        return this.zzb(new zzm(string, "com.google.android.gms", GmsClientSupervisor.getDefaultBindFlags()), serviceConnection, string2);
    }

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String string) {
        this.zzc(new zzm(componentName, GmsClientSupervisor.getDefaultBindFlags()), serviceConnection, string);
    }

    public void unbindService(String string, ServiceConnection serviceConnection, String string2) {
        this.zzc(new zzm(string, "com.google.android.gms", GmsClientSupervisor.getDefaultBindFlags()), serviceConnection, string2);
    }

    public final void zza(String string, String string2, int n, ServiceConnection serviceConnection, String string3, boolean bl) {
        this.zzc(new zzm(string, string2, n, bl), serviceConnection, string3);
    }

    protected abstract boolean zzb(zzm var1, ServiceConnection var2, String var3);

    protected abstract void zzc(zzm var1, ServiceConnection var2, String var3);
}
