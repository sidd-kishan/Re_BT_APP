/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.internal.base.zab
 *  com.google.android.gms.internal.base.zac
 *  com.google.android.gms.signin.internal.zaa
 *  com.google.android.gms.signin.internal.zae
 *  com.google.android.gms.signin.internal.zag
 *  com.google.android.gms.signin.internal.zak
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zae;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zak;

public abstract class zad
extends zab
implements zae {
    public zad() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    protected final boolean zaa(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 9: {
                parcel = (zag)zac.zab((Parcel)parcel, (Parcelable.Creator)zag.CREATOR);
                break;
            }
            case 8: {
                this.zab((zak)zac.zab((Parcel)parcel, (Parcelable.Creator)zak.CREATOR));
                break;
            }
            case 7: {
                Status status = (Status)zac.zab((Parcel)parcel, (Parcelable.Creator)Status.CREATOR);
                parcel = (GoogleSignInAccount)zac.zab((Parcel)parcel, (Parcelable.Creator)GoogleSignInAccount.CREATOR);
                break;
            }
            case 6: {
                parcel = (Status)zac.zab((Parcel)parcel, (Parcelable.Creator)Status.CREATOR);
                break;
            }
            case 4: {
                parcel = (Status)zac.zab((Parcel)parcel, (Parcelable.Creator)Status.CREATOR);
                break;
            }
            case 3: {
                ConnectionResult connectionResult = (ConnectionResult)zac.zab((Parcel)parcel, (Parcelable.Creator)ConnectionResult.CREATOR);
                parcel = (zaa)zac.zab((Parcel)parcel, (Parcelable.Creator)zaa.CREATOR);
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
