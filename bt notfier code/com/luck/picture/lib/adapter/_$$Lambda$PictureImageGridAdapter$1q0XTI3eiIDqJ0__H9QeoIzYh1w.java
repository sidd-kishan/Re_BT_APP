/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.adapter.PictureImageGridAdapter
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 */
package com.luck.picture.lib.adapter;

import android.view.View;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.dialog.PictureCustomDialog;

public final class _$$Lambda$PictureImageGridAdapter$1q0XTI3eiIDqJ0__H9QeoIzYh1w
implements View.OnClickListener {
    private final PictureCustomDialog f$0;

    public /* synthetic */ _$$Lambda$PictureImageGridAdapter$1q0XTI3eiIDqJ0__H9QeoIzYh1w(PictureCustomDialog pictureCustomDialog) {
        this.f$0 = pictureCustomDialog;
    }

    public final void onClick(View view) {
        PictureImageGridAdapter.lambda$showPromptDialog$3((PictureCustomDialog)this.f$0, (View)view);
    }
}
