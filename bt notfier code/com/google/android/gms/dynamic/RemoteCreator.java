/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 */
package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.RemoteCreator;

public abstract class RemoteCreator<T> {
    private final String zza;
    private T zzb;

    protected RemoteCreator(String string) {
        this.zza = string;
    }

    protected abstract T getRemoteCreator(IBinder var1);

    protected final T getRemoteCreatorInstance(Context object) throws RemoteCreatorException {
        if (this.zzb != null) return this.zzb;
        Preconditions.checkNotNull((Object)object);
        object = GooglePlayServicesUtilLight.getRemoteContext((Context)object);
        if (object == null) throw new RemoteCreatorException("Could not get remote context.");
        object = object.getClassLoader();
        try {
            this.zzb = this.getRemoteCreator((IBinder)((ClassLoader)object).loadClass(this.zza).newInstance());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RemoteCreatorException("Could not access creator.", (Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new RemoteCreatorException("Could not instantiate creator.", (Throwable)instantiationException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RemoteCreatorException("Could not load creator class.", (Throwable)classNotFoundException);
        }
        return this.zzb;
    }
}
