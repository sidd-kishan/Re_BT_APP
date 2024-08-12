/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.query.QueryInfo
 *  com.google.android.gms.ads.query.QueryInfoGenerationCallback
 *  com.google.android.gms.internal.ads.zzbhv
 *  com.google.android.gms.internal.ads.zzcah
 *  com.google.android.gms.internal.ads.zzcfj
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzcah;
import com.google.android.gms.internal.ads.zzcfj;

final class zzcag
extends zzcfj {
    final QueryInfoGenerationCallback zza;

    zzcag(zzcah zzcah2, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zza = queryInfoGenerationCallback;
    }

    public final void zzb(String string) {
        this.zza.onFailure(string);
    }

    public final void zzc(String string, String string2, Bundle bundle) {
        string = new QueryInfo(new zzbhv(string, bundle, string2));
        this.zza.onSuccess((QueryInfo)string);
    }
}
