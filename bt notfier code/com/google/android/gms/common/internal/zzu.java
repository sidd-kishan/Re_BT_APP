/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.internal.common.zza
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzu
extends zza
implements IAccountAccessor {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account zzb() throws RemoteException {
        Parcel parcel = this.zzB(2, this.zza());
        Account account = (Account)zzc.zzc((Parcel)parcel, (Parcelable.Creator)Account.CREATOR);
        parcel.recycle();
        return account;
    }
}
