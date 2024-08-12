/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.PictureExternalPreviewActivity
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 */
package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.dialog.PictureCustomDialog;

public final class _$$Lambda$PictureExternalPreviewActivity$wteLrkruQxV_Pz_YQfcha8xSBUA
implements View.OnClickListener {
    private final PictureExternalPreviewActivity f$0;
    private final PictureCustomDialog f$1;

    public /* synthetic */ _$$Lambda$PictureExternalPreviewActivity$wteLrkruQxV_Pz_YQfcha8xSBUA(PictureExternalPreviewActivity pictureExternalPreviewActivity, PictureCustomDialog pictureCustomDialog) {
        this.f$0 = pictureExternalPreviewActivity;
        this.f$1 = pictureCustomDialog;
    }

    public final void onClick(View view) {
        this.f$0.lambda$showDownLoadDialog$1$PictureExternalPreviewActivity(this.f$1, view);
    }
}
