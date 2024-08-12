/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PicturePlayAudioActivity
 *  com.luck.picture.lib.tools.DateUtils
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PicturePlayAudioActivity;
import com.luck.picture.lib.tools.DateUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class PicturePlayAudioActivity.2
implements Runnable {
    final PicturePlayAudioActivity this$0;

    PicturePlayAudioActivity.2(PicturePlayAudioActivity picturePlayAudioActivity) {
        this.this$0 = picturePlayAudioActivity;
    }

    @Override
    public void run() {
        try {
            if (PicturePlayAudioActivity.access$000((PicturePlayAudioActivity)this.this$0) == null) return;
            PicturePlayAudioActivity.access$100((PicturePlayAudioActivity)this.this$0).setText((CharSequence)DateUtils.formatDurationTime((long)PicturePlayAudioActivity.access$000((PicturePlayAudioActivity)this.this$0).getCurrentPosition()));
            PicturePlayAudioActivity.access$200((PicturePlayAudioActivity)this.this$0).setProgress(PicturePlayAudioActivity.access$000((PicturePlayAudioActivity)this.this$0).getCurrentPosition());
            PicturePlayAudioActivity.access$200((PicturePlayAudioActivity)this.this$0).setMax(PicturePlayAudioActivity.access$000((PicturePlayAudioActivity)this.this$0).getDuration());
            PicturePlayAudioActivity.access$300((PicturePlayAudioActivity)this.this$0).setText((CharSequence)DateUtils.formatDurationTime((long)PicturePlayAudioActivity.access$000((PicturePlayAudioActivity)this.this$0).getDuration()));
            this.this$0.handler.postDelayed(this.this$0.runnable, 200L);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
