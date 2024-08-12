/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  com.google.android.gms.common.util.Base64Utils
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgr
 *  com.google.android.gms.internal.ads.zzcgs
 */
package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzcgs;

final class zzcgp
implements zzcgr {
    private final byte[] zza;

    zzcgp(byte[] byArray) {
        this.zza = byArray;
    }

    public final void zza(JsonWriter jsonWriter) {
        Object object = this.zza;
        int n = zzcgs.zza;
        jsonWriter.name("params").beginObject();
        n = ((byte[])object).length;
        object = Base64Utils.encode((byte[])object);
        if (n < 10000) {
            jsonWriter.name("body").value((String)object);
        } else if ((object = (Object)zzcgm.zzd((String)object)) != null) {
            jsonWriter.name("bodydigest").value((String)object);
        }
        jsonWriter.name("bodylength").value((long)n);
        jsonWriter.endObject();
    }
}
