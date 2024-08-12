/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.GetServiceRequest
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzl
implements Parcelable.Creator<GetServiceRequest> {
    static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)getServiceRequest.zza);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)getServiceRequest.zzb);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)getServiceRequest.zzc);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)getServiceRequest.zzd, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)5, (IBinder)getServiceRequest.zze, (boolean)false);
        SafeParcelWriter.writeTypedArray((Parcel)parcel, (int)6, (Parcelable[])getServiceRequest.zzf, (int)n, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)7, (Bundle)getServiceRequest.zzg, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)8, (Parcelable)getServiceRequest.zzh, (int)n, (boolean)false);
        SafeParcelWriter.writeTypedArray((Parcel)parcel, (int)10, (Parcelable[])getServiceRequest.zzi, (int)n, (boolean)false);
        SafeParcelWriter.writeTypedArray((Parcel)parcel, (int)11, (Parcelable[])getServiceRequest.zzj, (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)12, (boolean)getServiceRequest.zzk);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)13, (int)getServiceRequest.zzl);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)14, (boolean)getServiceRequest.zzm);
        SafeParcelWriter.writeString((Parcel)parcel, (int)15, (String)getServiceRequest.zza(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
