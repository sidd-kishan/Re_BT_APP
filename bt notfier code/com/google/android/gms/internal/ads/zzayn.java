/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzayo
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzayo;

public final class zzayn
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzayn> CREATOR = new zzayo();
    public final String zza;
    public final long zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final Bundle zzf;
    public final boolean zzg;
    public long zzh;
    public String zzi;
    public int zzj;

    zzayn(String string, long l, String string2, String string3, String string4, Bundle bundle, boolean bl, long l2, String string5, int n) {
        this.zza = string;
        this.zzb = l;
        if (string2 == null) {
            string2 = "";
        }
        this.zzc = string2;
        if (string3 == null) {
            string3 = "";
        }
        this.zzd = string3;
        if (string4 == null) {
            string4 = "";
        }
        this.zze = string4;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzf = bundle;
        this.zzg = bl;
        this.zzh = l2;
        this.zzi = string5;
        this.zzj = n;
    }

    /*
     * WARNING - void declaration
     */
    public static zzayn zza(Uri object) {
        void var0_3;
        try {
            if (!"gcache".equals(object.getScheme())) {
                return null;
            }
            Object object2 = object.getPathSegments();
            if (object2.size() != 2) {
                int n = object2.size();
                object = new StringBuilder(62);
                object.append("Expected 2 path parts for namespace and id, found :");
                object.append(n);
                com.google.android.gms.ads.internal.util.zze.zzi((String)object.toString());
                return null;
            }
            String string = (String)object2.get(0);
            object2 = (String)object2.get(1);
            String string2 = object.getHost();
            String string3 = object.getQueryParameter("url");
            boolean bl = "1".equals(object.getQueryParameter("read_only"));
            Object object3 = object.getQueryParameter("expiration");
            long l = object3 == null ? 0L : Long.parseLong((String)object3);
            Bundle bundle = new Bundle();
            object3 = object.getQueryParameterNames().iterator();
            while (true) {
                if (!object3.hasNext()) {
                    object = new zzayn(string3, l, string2, string, (String)object2, bundle, bl, 0L, "", 0);
                    return object;
                }
                String string4 = (String)object3.next();
                if (!string4.startsWith("tag.")) continue;
                bundle.putString(string4.substring(4), object.getQueryParameter(string4));
            }
        }
        catch (NumberFormatException numberFormatException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        com.google.android.gms.ads.internal.util.zze.zzj((String)"Unable to parse Uri into cache offering.", (Throwable)var0_3);
        return null;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)3, (long)this.zzb);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzc, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)5, (String)this.zzd, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)6, (String)this.zze, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)7, (Bundle)this.zzf, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)8, (boolean)this.zzg);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)9, (long)this.zzh);
        SafeParcelWriter.writeString((Parcel)parcel, (int)10, (String)this.zzi, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)11, (int)this.zzj);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
