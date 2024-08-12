/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelReader
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzcav
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzcav;
import com.google.android.gms.internal.ads.zzcgz;
import java.util.ArrayList;
import java.util.List;

public final class zzcaw
implements Parcelable.Creator<zzcav> {
    public static final zzcav zza(Parcel parcel) {
        Bundle bundle;
        Bundle bundle2;
        Object object;
        Bundle bundle3;
        Bundle bundle4;
        Object object2;
        Object object3;
        Object object4;
        Bundle bundle5;
        Bundle bundle6;
        Object object5;
        Bundle bundle7;
        Object object6;
        Object object7;
        Object object8;
        Object object9;
        Bundle bundle8;
        Object object10;
        Object object11;
        Object object12;
        Object object13;
        Bundle bundle9;
        Object object14;
        Bundle bundle10;
        Bundle bundle11;
        Object object15;
        Object object16;
        Object object17;
        Object object18;
        Object object19;
        Object object20;
        Object object21;
        Object object22;
        Bundle bundle12;
        Object object23;
        int n = SafeParcelReader.validateObjectHeader((Parcel)parcel);
        long l = 0L;
        long l2 = 0L;
        Bundle bundle13 = null;
        Bundle bundle14 = object23 = (bundle12 = (object22 = (object21 = (object20 = (object19 = (object18 = (object17 = (object16 = (object15 = (bundle11 = (bundle10 = (object14 = (bundle9 = (object13 = (object12 = (object11 = (object10 = (bundle8 = (object9 = (object8 = (object7 = (object6 = (bundle7 = (object5 = (bundle6 = (bundle5 = (object4 = (object3 = (object2 = (bundle4 = (bundle3 = (object = (bundle2 = (bundle = null))))))))))))))))))))))))))))))))));
        int n2 = 0;
        int n3 = 0;
        boolean bl = false;
        int n4 = 0;
        int n5 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean bl2 = false;
        int n6 = 0;
        int n7 = 0;
        boolean bl3 = false;
        boolean bl4 = false;
        int n8 = 0;
        boolean bl5 = false;
        boolean bl6 = false;
        int n9 = 0;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        block60: while (true) {
            if (parcel.dataPosition() >= n) {
                SafeParcelReader.ensureAtEnd((Parcel)parcel, (int)n);
                return new zzcav(n2, bundle13, (zzbdg)bundle, (zzbdl)bundle2, (String)object, (ApplicationInfo)bundle3, (PackageInfo)bundle4, (String)object2, (String)object3, (String)object4, (zzcgz)bundle5, bundle6, n3, (List)object5, bundle7, bl, n4, n5, f, (String)object6, l, (String)object7, (List)object8, (String)object9, (zzblv)bundle8, (List)object10, l2, (String)object11, f2, bl2, n6, n7, bl3, (String)object12, (String)object13, bl4, n8, bundle9, (String)object14, (zzbhg)bundle10, bl5, bundle11, (String)object15, (String)object16, (String)object17, bl6, (List)object18, (String)object19, (List)object20, n9, bl7, bl8, bl9, (ArrayList)object21, (String)object22, (zzbrx)bundle12, (String)object23, bundle14);
            }
            int n10 = SafeParcelReader.readHeader((Parcel)parcel);
            switch (SafeParcelReader.getFieldId((int)n10)) {
                default: {
                    SafeParcelReader.skipUnknownField((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 65: {
                    bundle14 = SafeParcelReader.createBundle((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 64: {
                    object23 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 63: {
                    bundle12 = (zzbrx)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)zzbrx.CREATOR);
                    continue block60;
                }
                case 61: {
                    object22 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 60: {
                    object21 = SafeParcelReader.createStringList((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 59: {
                    bl9 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 58: {
                    bl8 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 57: {
                    bl7 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 56: {
                    n9 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 55: {
                    object20 = SafeParcelReader.createStringList((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 54: {
                    object19 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 53: {
                    object18 = SafeParcelReader.createIntegerList((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 52: {
                    bl6 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 51: {
                    object17 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 50: {
                    object16 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 49: {
                    object15 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 48: {
                    bundle11 = SafeParcelReader.createBundle((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 47: {
                    bl5 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 46: {
                    bundle10 = (zzbhg)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)zzbhg.CREATOR);
                    continue block60;
                }
                case 45: {
                    object14 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 44: {
                    bundle9 = SafeParcelReader.createBundle((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 43: {
                    n8 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 42: {
                    bl4 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 41: {
                    object13 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 40: {
                    bl2 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 39: {
                    object12 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 37: {
                    bl3 = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 36: {
                    n7 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 35: {
                    n6 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 34: {
                    f2 = SafeParcelReader.readFloat((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 33: {
                    object11 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 31: {
                    l2 = SafeParcelReader.readLong((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 30: {
                    object10 = SafeParcelReader.createStringList((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 29: {
                    bundle8 = (zzblv)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)zzblv.CREATOR);
                    continue block60;
                }
                case 28: {
                    object9 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 27: {
                    object8 = SafeParcelReader.createStringList((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 26: {
                    object7 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 25: {
                    l = SafeParcelReader.readLong((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 21: {
                    object6 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 20: {
                    f = SafeParcelReader.readFloat((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 19: {
                    n5 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 18: {
                    n4 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 16: {
                    bl = SafeParcelReader.readBoolean((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 15: {
                    bundle7 = SafeParcelReader.createBundle((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 14: {
                    object5 = SafeParcelReader.createStringList((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 13: {
                    n3 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 12: {
                    bundle6 = SafeParcelReader.createBundle((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 11: {
                    bundle5 = (zzcgz)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)zzcgz.CREATOR);
                    continue block60;
                }
                case 10: {
                    object4 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 9: {
                    object3 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 8: {
                    object2 = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 7: {
                    bundle4 = (PackageInfo)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)PackageInfo.CREATOR);
                    continue block60;
                }
                case 6: {
                    bundle3 = (ApplicationInfo)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)ApplicationInfo.CREATOR);
                    continue block60;
                }
                case 5: {
                    object = SafeParcelReader.createString((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 4: {
                    bundle2 = (zzbdl)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)zzbdl.CREATOR);
                    continue block60;
                }
                case 3: {
                    bundle = (zzbdg)SafeParcelReader.createParcelable((Parcel)parcel, (int)n10, (Parcelable.Creator)zzbdg.CREATOR);
                    continue block60;
                }
                case 2: {
                    bundle13 = SafeParcelReader.createBundle((Parcel)parcel, (int)n10);
                    continue block60;
                }
                case 1: 
            }
            n2 = SafeParcelReader.readInt((Parcel)parcel, (int)n10);
        }
    }
}
