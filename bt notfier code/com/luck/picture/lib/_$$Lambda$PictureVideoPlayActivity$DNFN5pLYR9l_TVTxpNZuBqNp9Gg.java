/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnInfoListener
 *  com.luck.picture.lib.PictureVideoPlayActivity
 */
package com.luck.picture.lib;

import android.media.MediaPlayer;
import com.luck.picture.lib.PictureVideoPlayActivity;

public final class _$$Lambda$PictureVideoPlayActivity$DNFN5pLYR9l_TVTxpNZuBqNp9Gg
implements MediaPlayer.OnInfoListener {
    private final PictureVideoPlayActivity f$0;

    public /* synthetic */ _$$Lambda$PictureVideoPlayActivity$DNFN5pLYR9l_TVTxpNZuBqNp9Gg(PictureVideoPlayActivity pictureVideoPlayActivity) {
        this.f$0 = pictureVideoPlayActivity;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int n, int n2) {
        return this.f$0.lambda$onPrepared$0$PictureVideoPlayActivity(mediaPlayer, n, n2);
    }
}
