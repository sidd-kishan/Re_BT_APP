/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzat
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzat;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class zzau
extends zzat {
    public final String zzc;
    public final Map<String, List<String>> zzd;
    public final byte[] zze;

    public zzau(int n, String string, IOException iOException, Map<String, List<String>> map, zzan zzan2, byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("Response code: ");
        stringBuilder.append(n);
        super(stringBuilder.toString(), iOException, zzan2, 2004, 1);
        this.zzc = string;
        this.zzd = map;
        this.zze = byArray;
    }
}
