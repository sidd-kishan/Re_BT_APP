/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.webkit.JsPromptResult
 */
package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzcmg
implements DialogInterface.OnCancelListener {
    final JsPromptResult zza;

    zzcmg(JsPromptResult jsPromptResult) {
        this.zza = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.cancel();
    }
}
