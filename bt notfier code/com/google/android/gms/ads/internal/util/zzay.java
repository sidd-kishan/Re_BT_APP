/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  com.google.android.gms.ads.internal.util.zzax
 *  com.google.android.gms.ads.internal.util.zzaz
 */
package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzaz;

final class zzay
implements Runnable {
    final Context zza;
    final String zzb;
    final boolean zzc;
    final boolean zzd;

    zzay(zzaz zzaz2, Context context, String string, boolean bl, boolean bl2) {
        this.zza = context;
        this.zzb = string;
        this.zzc = bl;
        this.zzd = bl2;
    }

    @Override
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.zza);
        builder.setMessage((CharSequence)this.zzb);
        if (this.zzc) {
            builder.setTitle((CharSequence)"Error");
        } else {
            builder.setTitle((CharSequence)"Info");
        }
        if (this.zzd) {
            builder.setNeutralButton((CharSequence)"Dismiss", null);
        } else {
            builder.setPositiveButton((CharSequence)"Learn More", (DialogInterface.OnClickListener)new zzax(this));
            builder.setNegativeButton((CharSequence)"Dismiss", null);
        }
        builder.create().show();
    }
}
