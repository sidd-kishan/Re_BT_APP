/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.model.LocalMediaPageLoader
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 */
package com.luck.picture.lib;

import android.content.Context;
import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.thread.PictureThreadUtils;

class PictureSelectorActivity.2
extends PictureThreadUtils.SimpleTask<Boolean> {
    final PictureSelectorActivity this$0;

    PictureSelectorActivity.2(PictureSelectorActivity pictureSelectorActivity) {
        this.this$0 = pictureSelectorActivity;
    }

    public Boolean doInBackground() {
        int n = this.this$0.folderWindow.getFolderData().size();
        int n2 = 0;
        while (n2 < n) {
            LocalMediaFolder localMediaFolder = this.this$0.folderWindow.getFolder(n2);
            if (localMediaFolder != null) {
                localMediaFolder.setFirstImagePath(LocalMediaPageLoader.getInstance((Context)this.this$0.getContext()).getFirstCover(localMediaFolder.getBucketId()));
            }
            ++n2;
        }
        return true;
    }

    public void onSuccess(Boolean bl) {
    }
}
