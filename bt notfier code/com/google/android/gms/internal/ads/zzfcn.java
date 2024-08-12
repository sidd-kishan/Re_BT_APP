/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzfcm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzfcm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public final class zzfcn
implements zzfcm {
    private final Object[] zza;

    public zzfcn(zzbdg zzbdg2, String object, int n, String string, zzbdr zzbdr2) {
        HashSet<String> hashSet = new HashSet<String>(Arrays.asList(string.split(",")));
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(string);
        arrayList.add(object);
        if (hashSet.contains("networkType")) {
            arrayList.add(n);
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(zzbdg2.zzb);
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzfcn.zza(zzbdg2.zzc));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzbdg2.zzc.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(zzbdg2.zzd);
        }
        if (hashSet.contains("keywords")) {
            object = zzbdg2.zze;
            if (object != null) {
                arrayList.add(object.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(zzbdg2.zzf);
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(zzbdg2.zzg);
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(zzbdg2.zzh);
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzbdg2.zzi);
        }
        if (hashSet.contains("location")) {
            object = zzbdg2.zzk;
            if (object != null) {
                arrayList.add(object.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzbdg2.zzl);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzfcn.zza(zzbdg2.zzm));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzfcn.zza(zzbdg2.zzn));
        }
        if (hashSet.contains("categoryExclusions")) {
            object = zzbdg2.zzo;
            if (object != null) {
                arrayList.add(object.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzbdg2.zzp);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzbdg2.zzq);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(zzbdg2.zzr);
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(zzbdg2.zzt);
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzbdg2.zzu);
        }
        if (hashSet.contains("orientation")) {
            if (zzbdr2 != null) {
                arrayList.add(zzbdr2.zza);
            } else {
                arrayList.add(null);
            }
        }
        this.zza = arrayList.toArray();
    }

    private static String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = new TreeSet(bundle.keySet()).iterator();
        while (iterator.hasNext()) {
            Object object = bundle.get((String)iterator.next());
            object = object == null ? "null" : (object instanceof Bundle ? zzfcn.zza((Bundle)object) : object.toString());
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzfcn)) {
            return false;
        }
        object = (zzfcn)object;
        return Arrays.equals(this.zza, ((zzfcn)object).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        int n = Arrays.hashCode(this.zza);
        String string = Arrays.toString(this.zza);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22);
        stringBuilder.append("[PoolKey#");
        stringBuilder.append(n);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
