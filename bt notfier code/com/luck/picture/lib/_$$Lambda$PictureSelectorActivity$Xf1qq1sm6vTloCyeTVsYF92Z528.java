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

public final class _$$Lambda$PictureSelectorActivity$Xf1qq1sm6vTloCyeTVsYF92Z528
implements View.OnClickListener {
    private final PictureSelectorActivity f$0;
    private final PictureCustomDialog f$1;
    private final boolean f$2;

    public /* synthetic */ _$$Lambda$PictureSelectorActivity$Xf1qq1sm6vTloCyeTVsYF92Z528(PictureSelectorActivity pictureSelectorActivity, PictureCustomDialog pictureCustomDialog, boolean bl) {
        this.f$0 = pictureSelectorActivity;
        this.f$1 = pictureCustomDialog;
        this.f$2 = bl;
    }

    public final void onClick(View view) {
        this.f$0.lambda$showPermissionsDialog$6$PictureSelectorActivity(this.f$1, this.f$2, view);
    }
}
