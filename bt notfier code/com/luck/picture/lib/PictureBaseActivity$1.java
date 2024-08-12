/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.listener.OnCallbackListener
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnCallbackListener;
import java.util.List;

class PictureBaseActivity.1
implements OnCallbackListener<List<LocalMedia>> {
    final PictureBaseActivity this$0;

    PictureBaseActivity.1(PictureBaseActivity pictureBaseActivity) {
        this.this$0 = pictureBaseActivity;
    }

    public void onCall(List<LocalMedia> list) {
        this.this$0.onResult(list);
    }
}
