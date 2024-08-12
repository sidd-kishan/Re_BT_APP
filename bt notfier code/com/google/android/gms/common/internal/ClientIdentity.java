/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zaa
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zaa;

public class ClientIdentity
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new zaa();
    public final int zaa;
    public final String zab;

    public ClientIdentity(int n, String string) {
        this.zaa = n;
        this.zab = string;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ClientIdentity)) {
            return false;
        }
        object = (ClientIdentity)((Object)object);
        if (((ClientIdentity)((Object)object)).zaa != this.zaa) return false;
        if (!Objects.equal((Object)((ClientIdentity)((Object)object)).zab, (Object)this.zab)) return false;
        return true;
    }

    public final int hashCode() {
        return this.zaa;
    }

    public final String toString() {
        int n = this.zaa;
        String string = this.zab;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 12);
        stringBuilder.append(n);
        stringBuilder.append(":");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zab, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
