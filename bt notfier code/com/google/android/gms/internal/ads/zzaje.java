/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzajd
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzajd;
import com.google.android.gms.internal.ads.zzamq;

public final class zzaje
implements zzaiu {
    public static final Parcelable.Creator<zzaje> CREATOR = new zzajd();
    public final String zza;
    public final String zzb;

    zzaje(Parcel parcel) {
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        this.zzb = parcel.readString();
    }

    public zzaje(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzaje)object;
        if (!this.zza.equals(((zzaje)object).zza)) return false;
        if (!this.zzb.equals(((zzaje)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        return (this.zza.hashCode() + 527) * 31 + this.zzb.hashCode();
    }

    public final String toString() {
        String string = this.zza;
        String string2 = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 5 + String.valueOf(string2).length());
        stringBuilder.append("VC: ");
        stringBuilder.append(string);
        stringBuilder.append("=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public final void zza(zzagm zzagm2) {
        int n;
        block12: {
            String string = this.zza;
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 1939198791: {
                    if (!string.equals("ARTIST")) break;
                    n = 1;
                    break block12;
                }
                case 1746739798: {
                    if (!string.equals("ALBUMARTIST")) break;
                    n = 3;
                    break block12;
                }
                case 428414940: {
                    if (!string.equals("DESCRIPTION")) break;
                    n = 4;
                    break block12;
                }
                case 79833656: {
                    if (!string.equals("TITLE")) break;
                    n = 0;
                    break block12;
                }
                case 62359119: {
                    if (!string.equals("ALBUM")) break;
                    n = 2;
                    break block12;
                }
            }
            n = -1;
        }
        if (n == 0) {
            zzagm2.zzs((CharSequence)this.zzb);
            return;
        }
        if (n == 1) {
            zzagm2.zzt((CharSequence)this.zzb);
            return;
        }
        if (n == 2) {
            zzagm2.zzu((CharSequence)this.zzb);
            return;
        }
        if (n == 3) {
            zzagm2.zzv((CharSequence)this.zzb);
            return;
        }
        if (n != 4) {
            return;
        }
        zzagm2.zzw((CharSequence)this.zzb);
    }
}
