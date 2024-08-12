/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 */
package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.dialog.PictureCustomDialog;

public final class _$$Lambda$PictureBaseActivity$_bvsXD9WQydPpsTHM1mfy4FuA4g
implements View.OnClickListener {
    private final PictureBaseActivity f$0;
    private final PictureCustomDialog f$1;

    public /* synthetic */ _$$Lambda$PictureBaseActivity$_bvsXD9WQydPpsTHM1mfy4FuA4g(PictureBaseActivity pictureBaseActivity, PictureCustomDialog pictureCustomDialog) {
        this.f$0 = pictureBaseActivity;
        this.f$1 = pictureCustomDialog;
    }

    public final void onClick(View view) {
        this.f$0.lambda$showPromptDialog$0$PictureBaseActivity(this.f$1, view);
    }
}
