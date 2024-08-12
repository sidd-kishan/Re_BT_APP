/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  com.luck.picture.lib.PictureSelectorActivity
 */
package com.luck.picture.lib;

import android.widget.SeekBar;
import com.luck.picture.lib.PictureSelectorActivity;

class PictureSelectorActivity.4
implements SeekBar.OnSeekBarChangeListener {
    final PictureSelectorActivity this$0;

    PictureSelectorActivity.4(PictureSelectorActivity pictureSelectorActivity) {
        this.this$0 = pictureSelectorActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int n, boolean bl) {
        if (!bl) return;
        this.this$0.mediaPlayer.seekTo(n);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
