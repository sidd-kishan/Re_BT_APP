/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.media.session.MediaSession$Token
 *  android.os.IBinder
 *  android.service.media.MediaBrowserService
 *  androidx.media.MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor
 *  androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.IBinder;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompatApi21;

class MediaBrowserServiceCompatApi21 {
    private MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static void notifyChildrenChanged(Object object, String string) {
        ((MediaBrowserService)object).notifyChildrenChanged(string);
    }

    public static IBinder onBind(Object object, Intent intent) {
        return ((MediaBrowserService)object).onBind(intent);
    }

    public static void onCreate(Object object) {
        ((MediaBrowserService)object).onCreate();
    }

    public static void setSessionToken(Object object, Object object2) {
        ((MediaBrowserService)object).setSessionToken((MediaSession.Token)object2);
    }
}
