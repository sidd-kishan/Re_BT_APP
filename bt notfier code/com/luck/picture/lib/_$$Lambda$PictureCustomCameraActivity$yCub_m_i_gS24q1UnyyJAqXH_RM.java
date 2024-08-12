/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 */
package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.dialog.PictureCustomDialog;

public final class _$$Lambda$PictureCustomCameraActivity$yCub_m_i_gS24q1UnyyJAqXH_RM
implements View.OnClickListener {
    private final PictureCustomCameraActivity f$0;
    private final PictureCustomDialog f$1;

    public /* synthetic */ _$$Lambda$PictureCustomCameraActivity$yCub_m_i_gS24q1UnyyJAqXH_RM(PictureCustomCameraActivity pictureCustomCameraActivity, PictureCustomDialog pictureCustomDialog) {
        this.f$0 = pictureCustomCameraActivity;
        this.f$1 = pictureCustomDialog;
    }

    public final void onClick(View view) {
        this.f$0.lambda$showPermissionsDialog$1$PictureCustomCameraActivity(this.f$1, view);
    }
}
