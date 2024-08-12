/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.JsPromptResult
 *  android.widget.EditText
 */
package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzcmi
implements DialogInterface.OnClickListener {
    final JsPromptResult zza;
    final EditText zzb;

    zzcmi(JsPromptResult jsPromptResult, EditText editText) {
        this.zza = jsPromptResult;
        this.zzb = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.confirm(this.zzb.getText().toString());
    }
}
