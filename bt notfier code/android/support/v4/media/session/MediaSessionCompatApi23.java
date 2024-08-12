/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.support.v4.media.session.MediaSessionCompatApi23$Callback
 *  android.support.v4.media.session.MediaSessionCompatApi23$CallbackProxy
 */
package android.support.v4.media.session;

import android.support.v4.media.session.MediaSessionCompatApi23;

class MediaSessionCompatApi23 {
    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
