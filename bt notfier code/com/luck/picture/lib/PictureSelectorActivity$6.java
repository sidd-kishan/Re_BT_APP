/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.tools.DateUtils
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.tools.DateUtils;

class PictureSelectorActivity.6
implements Runnable {
    final PictureSelectorActivity this$0;

    PictureSelectorActivity.6(PictureSelectorActivity pictureSelectorActivity) {
        this.this$0 = pictureSelectorActivity;
    }

    @Override
    public void run() {
        try {
            if (this.this$0.mediaPlayer == null) return;
            this.this$0.mTvMusicTime.setText((CharSequence)DateUtils.formatDurationTime((long)this.this$0.mediaPlayer.getCurrentPosition()));
            this.this$0.musicSeekBar.setProgress(this.this$0.mediaPlayer.getCurrentPosition());
            this.this$0.musicSeekBar.setMax(this.this$0.mediaPlayer.getDuration());
            this.this$0.mTvMusicTotal.setText((CharSequence)DateUtils.formatDurationTime((long)this.this$0.mediaPlayer.getDuration()));
            this.this$0.mHandler.postDelayed(this.this$0.mRunnable, 200L);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
