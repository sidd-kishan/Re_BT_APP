/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 *  com.luck.picture.lib.camera.CustomCameraView
 */
package com.luck.picture.lib.camera;

import android.media.MediaPlayer;
import com.luck.picture.lib.camera.CustomCameraView;

public final class _$$Lambda$CustomCameraView$r62lNOB0ktvK1nIiiTeIOnkHJS0
implements MediaPlayer.OnPreparedListener {
    private final CustomCameraView f$0;

    public /* synthetic */ _$$Lambda$CustomCameraView$r62lNOB0ktvK1nIiiTeIOnkHJS0(CustomCameraView customCameraView) {
        this.f$0 = customCameraView;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.f$0.lambda$startVideoPlay$1$CustomCameraView(mediaPlayer);
    }
}
