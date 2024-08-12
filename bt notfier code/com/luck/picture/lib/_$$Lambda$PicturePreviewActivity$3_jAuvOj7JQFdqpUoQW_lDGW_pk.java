/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.luck.picture.lib.PicturePreviewActivity
 */
package com.luck.picture.lib;

import android.widget.CompoundButton;
import com.luck.picture.lib.PicturePreviewActivity;

public final class _$$Lambda$PicturePreviewActivity$3_jAuvOj7JQFdqpUoQW_lDGW_pk
implements CompoundButton.OnCheckedChangeListener {
    private final PicturePreviewActivity f$0;

    public /* synthetic */ _$$Lambda$PicturePreviewActivity$3_jAuvOj7JQFdqpUoQW_lDGW_pk(PicturePreviewActivity picturePreviewActivity) {
        this.f$0 = picturePreviewActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        this.f$0.lambda$initWidgets$0$PicturePreviewActivity(compoundButton, bl);
    }
}
