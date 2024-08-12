/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.compress.OnCompressListener
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.compress.OnCompressListener;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

class PictureBaseActivity.3
implements OnCompressListener {
    final PictureBaseActivity this$0;
    final List val$result;

    PictureBaseActivity.3(PictureBaseActivity pictureBaseActivity, List list) {
        this.this$0 = pictureBaseActivity;
        this.val$result = list;
    }

    public void onError(Throwable throwable) {
        this.this$0.onResult(this.val$result);
    }

    public void onStart() {
    }

    public void onSuccess(List<LocalMedia> list) {
        this.this$0.onResult(list);
    }
}
