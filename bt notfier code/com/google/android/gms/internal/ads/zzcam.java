/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.view.View
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzcan
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzcan;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcam
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcam> CREATOR = new zzcan();
    public final View zza;
    public final Map<String, WeakReference<View>> zzb;

    public zzcam(IBinder iBinder, IBinder iBinder2) {
        this.zza = (View)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder));
        this.zzb = (Map)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder2));
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)1, (IBinder)ObjectWrapper.wrap((Object)this.zza).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)2, (IBinder)ObjectWrapper.wrap(this.zzb).asBinder(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
