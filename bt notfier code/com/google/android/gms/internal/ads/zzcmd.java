/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.webkit.JsResult
 */
package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzcmd
implements DialogInterface.OnCancelListener {
    final JsResult zza;

    zzcmd(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.cancel();
    }
}
