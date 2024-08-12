/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgr
 *  com.google.android.gms.internal.ads.zzfho
 *  com.google.android.gms.internal.ads.zzfhv
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfho;
import com.google.android.gms.internal.ads.zzfhv;
import java.util.HashSet;
import org.json.JSONObject;

public final class zzfia
extends zzfhv {
    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzfia(zzfho zzfho2, HashSet hashSet, JSONObject jSONObject, long l, byte[] byArray) {
        super(zzfho2, hashSet, jSONObject, l, null);
    }

    protected final void zza(String string) {
        Object object;
        if (!TextUtils.isEmpty((CharSequence)string) && (object = zzfgr.zza()) != null) {
            for (zzfgg zzfgg2 : object.zze()) {
                if (!this.zza.contains(zzfgg2.zzh())) continue;
                zzfgg2.zzg().zzf(string, this.zzc);
            }
        }
        super.zza(string);
    }
}
