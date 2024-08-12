/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.compress.Luban
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 */
package com.luck.picture.lib;

import android.content.Context;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.File;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureBaseActivity.2
extends PictureThreadUtils.SimpleTask<List<File>> {
    final PictureBaseActivity this$0;
    final List val$result;

    PictureBaseActivity.2(PictureBaseActivity pictureBaseActivity, List list) {
        this.this$0 = pictureBaseActivity;
        this.val$result = list;
    }

    public List<File> doInBackground() throws Exception {
        return Luban.with((Context)this.this$0.getContext()).loadMediaData(this.val$result).isCamera(this.this$0.config.camera).setTargetDir(this.this$0.config.compressSavePath).setCompressQuality(this.this$0.config.compressQuality).isAutoRotating(this.this$0.config.isAutoRotating).setFocusAlpha(this.this$0.config.focusAlpha).setNewCompressFileName(this.this$0.config.renameCompressFileName).ignoreBy(this.this$0.config.minimumCompressSize).get();
    }

    public void onSuccess(List<File> list) {
        if (list != null && list.size() > 0 && list.size() == this.val$result.size()) {
            PictureBaseActivity.access$000((PictureBaseActivity)this.this$0, (List)this.val$result, list);
        } else {
            this.this$0.onResult(this.val$result);
        }
    }
}
