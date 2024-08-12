/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaController$TransportControls
 *  android.net.Uri
 *  android.os.Bundle
 */
package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

public static class MediaControllerCompatApi23.TransportControls {
    private MediaControllerCompatApi23.TransportControls() {
    }

    public static void playFromUri(Object object, Uri uri, Bundle bundle) {
        ((MediaController.TransportControls)object).playFromUri(uri, bundle);
    }
}
