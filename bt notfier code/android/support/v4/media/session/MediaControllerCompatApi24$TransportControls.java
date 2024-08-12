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

public static class MediaControllerCompatApi24.TransportControls {
    private MediaControllerCompatApi24.TransportControls() {
    }

    public static void prepare(Object object) {
        ((MediaController.TransportControls)object).prepare();
    }

    public static void prepareFromMediaId(Object object, String string, Bundle bundle) {
        ((MediaController.TransportControls)object).prepareFromMediaId(string, bundle);
    }

    public static void prepareFromSearch(Object object, String string, Bundle bundle) {
        ((MediaController.TransportControls)object).prepareFromSearch(string, bundle);
    }

    public static void prepareFromUri(Object object, Uri uri, Bundle bundle) {
        ((MediaController.TransportControls)object).prepareFromUri(uri, bundle);
    }
}
