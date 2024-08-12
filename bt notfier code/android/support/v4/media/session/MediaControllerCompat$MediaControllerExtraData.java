/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.support.v4.media.session.MediaControllerCompat
 *  androidx.core.app.ComponentActivity$ExtraData
 */
package android.support.v4.media.session;

import android.support.v4.media.session.MediaControllerCompat;
import androidx.core.app.ComponentActivity;

private static class MediaControllerCompat.MediaControllerExtraData
extends ComponentActivity.ExtraData {
    private final MediaControllerCompat mMediaController;

    MediaControllerCompat.MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
        this.mMediaController = mediaControllerCompat;
    }

    MediaControllerCompat getMediaController() {
        return this.mMediaController;
    }
}
