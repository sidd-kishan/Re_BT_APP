/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.AccountAccessor
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.common.internal.IAccountAccessor$Stub
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.zzl
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzl;

public class GetServiceRequest
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzl();
    final int zza;
    final int zzb;
    int zzc;
    String zzd;
    IBinder zze;
    Scope[] zzf;
    Bundle zzg;
    Account zzh;
    Feature[] zzi;
    Feature[] zzj;
    boolean zzk;
    int zzl;
    boolean zzm;
    private final String zzn;

    GetServiceRequest(int n, int n2, int n3, String string, IBinder iBinder, Scope[] scopeArray, Bundle bundle, Account account, Feature[] featureArray, Feature[] featureArray2, boolean bl, int n4, boolean bl2, String string2) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = "com.google.android.gms".equals(string) ? "com.google.android.gms" : string;
        if (n < 2) {
            string = iBinder != null ? AccountAccessor.getAccountBinderSafe((IAccountAccessor)IAccountAccessor.Stub.asInterface((IBinder)iBinder)) : null;
            this.zzh = string;
        } else {
            this.zze = iBinder;
            this.zzh = account;
        }
        this.zzf = scopeArray;
        this.zzg = bundle;
        this.zzi = featureArray;
        this.zzj = featureArray2;
        this.zzk = bl;
        this.zzl = n4;
        this.zzm = bl2;
        this.zzn = string2;
    }

    public GetServiceRequest(int n, String string) {
        this.zza = 6;
        this.zzc = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzb = n;
        this.zzk = true;
        this.zzn = string;
    }

    public Bundle getExtraArgs() {
        return this.zzg;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        com.google.android.gms.common.internal.zzl.zza((GetServiceRequest)this, (Parcel)parcel, (int)n);
    }

    public final String zza() {
        return this.zzn;
    }
}
