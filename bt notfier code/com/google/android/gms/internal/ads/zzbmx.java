/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbmy
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbmy;
import java.util.List;

public abstract class zzbmx
extends zzadk
implements zzbmy {
    public zzbmx() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 17: {
                object = this.zzq();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 16: {
                object = this.zzp();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 15: {
                object = this.zzo();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 14: {
                this.zzn((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 13: {
                boolean bl = this.zzm((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 12: {
                this.zzl((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 11: {
                object = this.zzk();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 10: {
                this.zzj();
                parcel.writeNoException();
                break;
            }
            case 9: {
                object = this.zzi();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 8: {
                object = this.zzh();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 7: {
                object = this.zzg();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 6: {
                object = this.zzf();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 5: {
                object = this.zze();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 4: {
                object = this.zzd();
                parcel.writeNoException();
                parcel.writeList((List)object);
                break;
            }
            case 3: {
                object = this.zzc();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 2: {
                object = this.zzb();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
            }
        }
        return true;
    }
}
