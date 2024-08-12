/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureSelectorActivity
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureSelectorActivity;

class PictureSelectorActivity.5
implements Runnable {
    final PictureSelectorActivity this$0;
    final String val$path;

    PictureSelectorActivity.5(PictureSelectorActivity pictureSelectorActivity, String string) {
        this.this$0 = pictureSelectorActivity;
        this.val$path = string;
    }

    @Override
    public void run() {
        this.this$0.stop(this.val$path);
    }
}
