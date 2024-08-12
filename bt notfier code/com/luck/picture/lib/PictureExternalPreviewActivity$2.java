/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureExternalPreviewActivity
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.thread.PictureThreadUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureExternalPreviewActivity.2
extends PictureThreadUtils.SimpleTask<String> {
    final PictureExternalPreviewActivity this$0;

    PictureExternalPreviewActivity.2(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        this.this$0 = pictureExternalPreviewActivity;
    }

    public String doInBackground() {
        PictureExternalPreviewActivity pictureExternalPreviewActivity = this.this$0;
        return pictureExternalPreviewActivity.showLoadingImage(PictureExternalPreviewActivity.access$400((PictureExternalPreviewActivity)pictureExternalPreviewActivity));
    }

    public void onSuccess(String string) {
        PictureExternalPreviewActivity.access$800((PictureExternalPreviewActivity)this.this$0, (String)string);
    }
}
