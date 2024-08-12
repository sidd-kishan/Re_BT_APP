/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.AdRequest$ErrorCode
 *  com.google.ads.AdRequest$Gender
 *  com.google.ads.mediation.MediationAdRequest
 *  com.google.android.gms.internal.ads.zzbdg
 */
package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.internal.ads.zzbdg;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public final class zzbwx {
    public static int zza(AdRequest.ErrorCode errorCode) {
        AdRequest.ErrorCode errorCode2 = AdRequest.ErrorCode.INVALID_REQUEST;
        errorCode2 = AdRequest.Gender.UNKNOWN;
        int n = errorCode.ordinal();
        if (n == 0) return 1;
        if (n == 1) return 3;
        if (n == 2) return 2;
        return 0;
    }

    public static MediationAdRequest zzb(zzbdg zzbdg2, boolean bl) {
        List list = zzbdg2.zze;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        Date date = new Date(zzbdg2.zzb);
        int n = zzbdg2.zzd;
        list = n != 1 ? (n != 2 ? AdRequest.Gender.UNKNOWN : AdRequest.Gender.FEMALE) : AdRequest.Gender.MALE;
        return new MediationAdRequest(date, (AdRequest.Gender)list, hashSet, bl, zzbdg2.zzk);
    }
}
