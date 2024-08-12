/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaub
 *  com.google.android.gms.internal.ads.zzauf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzauf;
import java.util.List;
import java.util.Map;

public final class zzaug
extends zzauf {
    public final Map<String, List<String>> zzb;

    public zzaug(int n, Map<String, List<String>> map, zzaub zzaub2) {
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("Response code: ");
        stringBuilder.append(n);
        super(stringBuilder.toString(), zzaub2, 1);
        this.zzb = map;
    }
}
