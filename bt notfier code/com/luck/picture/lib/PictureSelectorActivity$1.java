/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.model.LocalMediaLoader
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.model.LocalMediaLoader;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureSelectorActivity.1
extends PictureThreadUtils.SimpleTask<List<LocalMediaFolder>> {
    final PictureSelectorActivity this$0;

    PictureSelectorActivity.1(PictureSelectorActivity pictureSelectorActivity) {
        this.this$0 = pictureSelectorActivity;
    }

    public List<LocalMediaFolder> doInBackground() {
        return new LocalMediaLoader(this.this$0.getContext()).loadAllMedia();
    }

    public void onSuccess(List<LocalMediaFolder> list) {
        PictureSelectorActivity.access$000((PictureSelectorActivity)this.this$0, list);
    }
}
