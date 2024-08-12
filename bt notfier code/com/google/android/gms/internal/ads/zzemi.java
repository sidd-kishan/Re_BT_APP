/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzerx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzerx;
import java.util.List;

public final class zzemi
implements zzerx<Bundle> {
    public final Context zza;
    public final zzbdl zzb;
    public final List<Parcelable> zzc;

    public zzemi(Context context, zzbdl zzbdl2, List<Parcelable> list) {
        this.zza = context;
        this.zzb = zzbdl2;
        this.zzc = list;
    }
}
