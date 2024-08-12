/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzx
 *  com.google.android.gms.common.internal.zzy
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 */
package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzi
extends zzx {
    private final int zza;

    protected zzi(byte[] byArray) {
        boolean bl = byArray.length == 25;
        Preconditions.checkArgument((boolean)bl);
        this.zza = Arrays.hashCode(byArray);
    }

    protected static byte[] zzf(String object) {
        try {
            object = ((String)object).getBytes("ISO-8859-1");
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }

    public final boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof zzy)) return false;
        try {
            object = (zzy)object;
            if (object.zze() != this.zza) {
                return false;
            }
            if ((object = object.zzd()) == null) {
                return false;
            }
            object = (byte[])ObjectWrapper.unwrap((IObjectWrapper)object);
            boolean bl = Arrays.equals(this.zzc(), (byte[])object);
            return bl;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)remoteException);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    abstract byte[] zzc();

    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap((Object)this.zzc());
    }

    public final int zze() {
        return this.zza;
    }
}
