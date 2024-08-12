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
 *  com.google.android.gms.internal.ads.zzbmw
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbmw;
import java.util.List;

public abstract class zzbmv
extends zzadk
implements zzbmw {
    public zzbmv() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 19: {
                object = this.zzs();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 18: {
                object = this.zzr();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 17: {
                object = this.zzq();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 16: {
                this.zzp((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 15: {
                boolean bl = this.zzo((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 14: {
                this.zzn((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 13: {
                object = this.zzm();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 12: {
                this.zzl();
                parcel.writeNoException();
                break;
            }
            case 11: {
                object = this.zzk();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 10: {
                object = this.zzj();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 9: {
                object = this.zzi();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 8: {
                double d = this.zzh();
                parcel.writeNoException();
                parcel.writeDouble(d);
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
