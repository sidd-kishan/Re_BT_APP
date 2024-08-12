/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
 *  com.google.android.gms.auth.api.signin.internal.zaa
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.internal.zaa;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class GoogleSignInOptionsExtensionParcelable
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();
    final int zaa;
    private int zab;
    private Bundle zac;

    GoogleSignInOptionsExtensionParcelable(int n, int n2, Bundle bundle) {
        this.zaa = n;
        this.zab = n2;
        this.zac = bundle;
    }

    public GoogleSignInOptionsExtensionParcelable(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        this(1, googleSignInOptionsExtension.getExtensionType(), googleSignInOptionsExtension.toBundle());
    }

    public int getType() {
        return this.zab;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.getType());
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)3, (Bundle)this.zac, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
