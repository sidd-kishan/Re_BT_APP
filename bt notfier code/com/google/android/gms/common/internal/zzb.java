/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.zzc
 *  com.google.android.gms.internal.common.zzh
 */
package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.common.zzh;

final class zzb
extends zzh {
    final BaseGmsClient zza;

    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        this.zza = baseGmsClient;
        super(looper);
    }

    private static final void zza(Message message) {
        message = (zzc)message.obj;
        message.zzc();
        message.zzf();
    }

    private static final boolean zzb(Message message) {
        if (message.what == 2) return true;
        if (message.what == 1) return true;
        if (message.what != 7) return false;
        return true;
    }

    public final void handleMessage(Message object) {
        if (this.zza.zzd.get() != ((Message)object).arg1) {
            if (!zzb.zzb((Message)object)) return;
            zzb.zza((Message)object);
            return;
        }
        if ((((Message)object).what == 1 || ((Message)object).what == 7 || ((Message)object).what == 4 && !this.zza.enableLocalFallback() || ((Message)object).what == 5) && !this.zza.isConnecting()) {
            zzb.zza((Message)object);
            return;
        }
        int n = ((Message)object).what;
        PendingIntent pendingIntent = null;
        if (n == 4) {
            BaseGmsClient.zzf((BaseGmsClient)this.zza, (ConnectionResult)new ConnectionResult(((Message)object).arg2));
            if (BaseGmsClient.zzg((BaseGmsClient)this.zza) && !BaseGmsClient.zzh((BaseGmsClient)this.zza)) {
                BaseGmsClient.zzi((BaseGmsClient)this.zza, (int)3, null);
                return;
            }
            object = BaseGmsClient.zzj((BaseGmsClient)this.zza) != null ? BaseGmsClient.zzj((BaseGmsClient)this.zza) : new ConnectionResult(8);
            this.zza.zzc.onReportServiceBinding((ConnectionResult)object);
            this.zza.onConnectionFailed((ConnectionResult)object);
            return;
        }
        if (((Message)object).what == 5) {
            object = BaseGmsClient.zzj((BaseGmsClient)this.zza) != null ? BaseGmsClient.zzj((BaseGmsClient)this.zza) : new ConnectionResult(8);
            this.zza.zzc.onReportServiceBinding((ConnectionResult)object);
            this.zza.onConnectionFailed((ConnectionResult)object);
            return;
        }
        if (((Message)object).what == 3) {
            if (((Message)object).obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent)((Message)object).obj;
            }
            object = new ConnectionResult(((Message)object).arg2, pendingIntent);
            this.zza.zzc.onReportServiceBinding((ConnectionResult)object);
            this.zza.onConnectionFailed((ConnectionResult)object);
            return;
        }
        if (((Message)object).what == 6) {
            BaseGmsClient.zzi((BaseGmsClient)this.zza, (int)5, null);
            if (BaseGmsClient.zzk((BaseGmsClient)this.zza) != null) {
                BaseGmsClient.zzk((BaseGmsClient)this.zza).onConnectionSuspended(((Message)object).arg2);
            }
            this.zza.onConnectionSuspended(((Message)object).arg2);
            BaseGmsClient.zzl((BaseGmsClient)this.zza, (int)5, (int)1, null);
            return;
        }
        if (((Message)object).what == 2 && !this.zza.isConnected()) {
            zzb.zza((Message)object);
            return;
        }
        if (zzb.zzb((Message)object)) {
            ((zzc)((Message)object).obj).zze();
            return;
        }
        n = ((Message)object).what;
        object = new StringBuilder(45);
        ((StringBuilder)object).append("Don't know how to handle message: ");
        ((StringBuilder)object).append(n);
        Log.wtf((String)"GmsClient", (String)((StringBuilder)object).toString(), (Throwable)new Exception());
    }
}
