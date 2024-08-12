/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zza
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zza;

public final class zzf
extends zza {
    public final IBinder zze;
    final BaseGmsClient zzf;

    public zzf(BaseGmsClient baseGmsClient, int n, IBinder iBinder, Bundle bundle) {
        this.zzf = baseGmsClient;
        super(baseGmsClient, n, bundle);
        this.zze = iBinder;
    }

    protected final boolean zza() {
        Object object;
        block3: {
            try {
                object = this.zze;
                Preconditions.checkNotNull((Object)object);
                object = object.getInterfaceDescriptor();
                if (this.zzf.getServiceDescriptor().equals(object)) break block3;
            }
            catch (RemoteException remoteException) {
                Log.w((String)"GmsClient", (String)"service probably died");
                return false;
            }
            String string = this.zzf.getServiceDescriptor();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 34 + String.valueOf(object).length());
            stringBuilder.append("service descriptor mismatch: ");
            stringBuilder.append(string);
            stringBuilder.append(" vs. ");
            stringBuilder.append((String)object);
            Log.e((String)"GmsClient", (String)stringBuilder.toString());
            return false;
        }
        object = this.zzf.createServiceInterface(this.zze);
        if (object == null) return false;
        if (!BaseGmsClient.zzl((BaseGmsClient)this.zzf, (int)2, (int)4, (IInterface)object)) {
            if (!BaseGmsClient.zzl((BaseGmsClient)this.zzf, (int)3, (int)4, (IInterface)object)) return false;
        }
        BaseGmsClient.zzf((BaseGmsClient)this.zzf, null);
        object = this.zzf.getConnectionHint();
        if (BaseGmsClient.zzk((BaseGmsClient)this.zzf) == null) return true;
        BaseGmsClient.zzk((BaseGmsClient)this.zzf).onConnected((Bundle)object);
        return true;
    }

    protected final void zzb(ConnectionResult connectionResult) {
        if (BaseGmsClient.zzn((BaseGmsClient)this.zzf) != null) {
            BaseGmsClient.zzn((BaseGmsClient)this.zzf).onConnectionFailed(connectionResult);
        }
        this.zzf.onConnectionFailed(connectionResult);
    }
}
