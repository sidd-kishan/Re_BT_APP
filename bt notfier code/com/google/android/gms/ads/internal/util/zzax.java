/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.net.Uri
 *  com.google.android.gms.ads.internal.util.zzay
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;

final class zzax
implements DialogInterface.OnClickListener {
    final zzay zza;

    zzax(zzay zzay2) {
        this.zza = zzay2;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        zzt.zzc();
        zzs.zzX((Context)this.zza.zza, (Uri)Uri.parse((String)"https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
