/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  com.luck.picture.lib.PictureSelectorActivity
 */
package com.luck.picture.lib;

import android.content.DialogInterface;
import com.luck.picture.lib.PictureSelectorActivity;

public final class _$$Lambda$PictureSelectorActivity$0RPGos1NllckBEtYh7BYh8pgRww
implements DialogInterface.OnDismissListener {
    private final PictureSelectorActivity f$0;
    private final String f$1;

    public /* synthetic */ _$$Lambda$PictureSelectorActivity$0RPGos1NllckBEtYh7BYh8pgRww(PictureSelectorActivity pictureSelectorActivity, String string) {
        this.f$0 = pictureSelectorActivity;
        this.f$1 = string;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f$0.lambda$startPlayAudioDialog$4$PictureSelectorActivity(this.f$1, dialogInterface);
    }
}
