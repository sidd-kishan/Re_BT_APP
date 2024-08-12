/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApkChecksum
 *  android.content.pm.PackageManager$OnChecksumsReadyListener
 *  com.google.android.gms.internal.ads.zzabu
 *  com.google.android.gms.internal.ads.zzfsu
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzfsu;
import java.util.List;

final class zzadb
implements PackageManager.OnChecksumsReadyListener {
    private final zzfsu zza;

    zzadb(zzfsu zzfsu2) {
        this.zza = zzfsu2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void onChecksumsReady(List list) {
        zzfsu zzfsu2 = this.zza;
        if (list == null) {
            zzfsu2.zzp(null);
            return;
        }
        try {
            int n = list.size();
            for (int i = 0; i < n; ++i) {
                ApkChecksum apkChecksum = (ApkChecksum)list.get(i);
                if (apkChecksum.getType() != 8) continue;
                zzfsu2.zzp((Object)zzabu.zzb((byte[])apkChecksum.getValue()));
                return;
            }
        }
        finally {
            zzfsu2.zzp(null);
            return;
        }
        {
        }
    }
}
