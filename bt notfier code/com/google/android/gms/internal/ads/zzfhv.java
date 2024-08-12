/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfho
 *  com.google.android.gms.internal.ads.zzfhw
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfho;
import com.google.android.gms.internal.ads.zzfhw;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class zzfhv
extends zzfhw {
    protected final HashSet<String> zza;
    protected final JSONObject zzb;
    protected final long zzc;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzfhv(zzfho zzfho2, HashSet hashSet, JSONObject jSONObject, long l, byte[] byArray) {
        super(zzfho2, null);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = l;
    }
}
