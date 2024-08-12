/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbhf
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbhf;

public abstract class zzbhe
extends zzadk
implements zzbhf {
    public zzbhe() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return false;
                        }
                        this.zzi(zzadl.zza((Parcel)parcel));
                    } else {
                        this.zzh();
                    }
                } else {
                    this.zzg();
                }
            } else {
                this.zzf();
            }
        } else {
            this.zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
