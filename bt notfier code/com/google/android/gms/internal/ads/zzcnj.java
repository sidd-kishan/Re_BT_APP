/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcms
 *  com.google.android.gms.internal.ads.zzcne
 *  com.google.android.gms.internal.ads.zzcnl
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcms;
import com.google.android.gms.internal.ads.zzcne;
import com.google.android.gms.internal.ads.zzcnl;

final class zzcnj
implements zzcnl {
    private final zzcml zza;

    zzcnj(zzcml zzcml2) {
        this.zza = zzcml2;
    }

    public final void zza(Uri uri) {
        zzcms zzcms2 = ((zzcne)this.zza).zzaS();
        if (zzcms2 == null) {
            zze.zzf((String)"Unable to pass GMSG, no AdWebViewClient for AdWebView!");
            return;
        }
        zzcms2.zzF(uri);
    }
}
