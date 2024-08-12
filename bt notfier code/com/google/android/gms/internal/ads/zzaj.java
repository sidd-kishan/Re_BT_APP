/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface zzaj
extends zzah {
    public void zza(zzay var1);

    public Map<String, List<String>> zzf();

    public long zzh(zzan var1) throws IOException;

    public Uri zzi();

    public void zzj() throws IOException;
}
