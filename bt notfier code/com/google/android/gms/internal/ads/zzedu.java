/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzedy
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzffc;
import java.util.HashMap;

final class zzedu
implements DialogInterface.OnClickListener {
    private final zzedq zza;
    private final String zzb;
    private final zzdvi zzc;
    private final Activity zzd;
    private final zzffc zze;
    private final zzl zzf;

    zzedu(zzedq zzedq2, String string, zzdvi zzdvi2, Activity activity, zzffc zzffc2, zzl zzl2) {
        this.zza = zzedq2;
        this.zzb = string;
        this.zzc = zzdvi2;
        this.zzd = activity;
        this.zze = zzffc2;
        this.zzf = zzl2;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        zzedq zzedq2 = this.zza;
        String string = this.zzb;
        zzdvi zzdvi2 = this.zzc;
        Activity activity = this.zzd;
        dialogInterface = this.zze;
        zzl zzl2 = this.zzf;
        zzedq2.zzd(string);
        if (zzdvi2 != null) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("dialog_action", "dismiss");
            zzedy.zzh((Context)activity, (zzdvi)zzdvi2, (zzffc)dialogInterface, (zzedq)zzedq2, (String)string, (String)"dialog_click", hashMap);
        }
        if (zzl2 == null) return;
        zzl2.zzb();
    }
}
