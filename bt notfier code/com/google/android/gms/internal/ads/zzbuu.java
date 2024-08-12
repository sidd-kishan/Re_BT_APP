/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzbut
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgy
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbut;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgy;

public final class zzbuu
extends zzcgy {
    private final zzbut zza;

    public zzbuu(zzbut zzbut2, String string) {
        super(string);
        this.zza = zzbut2;
    }

    public final void zza(String string) {
        String string2 = String.valueOf(string);
        string2 = string2.length() != 0 ? "LeibnizHttpUrlPinger pinging URL: ".concat(string2) : new String("LeibnizHttpUrlPinger pinging URL: ");
        zzcgt.zzd((String)string2);
        if ("oda".equals(Uri.parse((String)string).getScheme())) {
            return;
        }
        zzcgt.zzd((String)"URL does not match oda:// scheme, falling back on HttpUrlPinger");
        super.zza(string);
    }
}
