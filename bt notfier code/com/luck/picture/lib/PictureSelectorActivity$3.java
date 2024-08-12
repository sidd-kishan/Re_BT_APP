/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureSelectorActivity
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureSelectorActivity;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureSelectorActivity.3
implements Runnable {
    final PictureSelectorActivity this$0;
    final String val$path;

    PictureSelectorActivity.3(PictureSelectorActivity pictureSelectorActivity, String string) {
        this.this$0 = pictureSelectorActivity;
        this.val$path = string;
    }

    @Override
    public void run() {
        PictureSelectorActivity.access$100((PictureSelectorActivity)this.this$0, (String)this.val$path);
    }
}
