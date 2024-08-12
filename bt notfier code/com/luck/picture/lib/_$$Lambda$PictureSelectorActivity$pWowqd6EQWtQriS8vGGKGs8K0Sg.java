/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 */
package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.dialog.PictureCustomDialog;

public final class _$$Lambda$PictureSelectorActivity$pWowqd6EQWtQriS8vGGKGs8K0Sg
implements View.OnClickListener {
    private final PictureSelectorActivity f$0;
    private final PictureCustomDialog f$1;

    public /* synthetic */ _$$Lambda$PictureSelectorActivity$pWowqd6EQWtQriS8vGGKGs8K0Sg(PictureSelectorActivity pictureSelectorActivity, PictureCustomDialog pictureCustomDialog) {
        this.f$0 = pictureSelectorActivity;
        this.f$1 = pictureCustomDialog;
    }

    public final void onClick(View view) {
        this.f$0.lambda$showPermissionsDialog$7$PictureSelectorActivity(this.f$1, view);
    }
}
