/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbfa
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbfa;

public abstract class zzbez
extends zzadk
implements zzbfa {
    public zzbez() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 8: {
                this.zzd((zzbcz)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbcz.CREATOR));
                break;
            }
            case 7: {
                this.zzi();
                break;
            }
            case 6: {
                this.zzh();
                break;
            }
            case 5: {
                this.zzg();
                break;
            }
            case 4: {
                this.zzf();
                break;
            }
            case 2: {
                this.zzc(parcel.readInt());
                break;
            }
            case 1: {
                this.zzb();
                break;
            }
            case 3: 
        }
        parcel2.writeNoException();
        return true;
    }
}
