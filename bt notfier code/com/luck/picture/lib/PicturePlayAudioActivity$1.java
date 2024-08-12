/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  com.luck.picture.lib.PicturePlayAudioActivity
 */
package com.luck.picture.lib;

import android.widget.SeekBar;
import com.luck.picture.lib.PicturePlayAudioActivity;

/*
 * Exception performing whole class analysis ignored.
 */
class PicturePlayAudioActivity.1
implements SeekBar.OnSeekBarChangeListener {
    final PicturePlayAudioActivity this$0;

    PicturePlayAudioActivity.1(PicturePlayAudioActivity picturePlayAudioActivity) {
        this.this$0 = picturePlayAudioActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int n, boolean bl) {
        if (!bl) return;
        PicturePlayAudioActivity.access$000((PicturePlayAudioActivity)this.this$0).seekTo(n);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
