/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzadj
implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zzadj(IBinder iBinder, String string) {
        this.zza = iBinder;
        this.zzb = string;
    }

    public final IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel zza() {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken(this.zzb);
        return parcel;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    protected final Parcel zzbi(int n, Parcel parcel) throws RemoteException {
        Throwable throwable2222222;
        block4: {
            Parcel parcel2 = Parcel.obtain();
            this.zza.transact(n, parcel, parcel2, 0);
            parcel2.readException();
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (RuntimeException runtimeException) {}
                {
                    parcel2.recycle();
                    throw runtimeException;
                }
            }
            parcel.recycle();
            return parcel2;
        }
        parcel.recycle();
        throw throwable2222222;
    }

    protected final void zzbj(int n, Parcel parcel) throws RemoteException {
        Parcel parcel2 = Parcel.obtain();
        try {
            this.zza.transact(n, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    protected final void zzbk(int n, Parcel parcel) throws RemoteException {
        try {
            this.zza.transact(2, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
