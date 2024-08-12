/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.service.media.MediaBrowserService
 *  android.service.media.MediaBrowserService$Result
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompatApi26$MediaBrowserServiceAdaptor
 *  androidx.media.MediaBrowserServiceCompatApi26$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompatApi26;
import java.lang.reflect.Field;

class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";
    static Field sResultFlags;

    static {
        try {
            Field field;
            sResultFlags = field = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            field.setAccessible(true);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Log.w((String)TAG, (Throwable)noSuchFieldException);
        }
    }

    private MediaBrowserServiceCompatApi26() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static Bundle getBrowserRootHints(Object object) {
        return ((MediaBrowserService)object).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object object, String string, Bundle bundle) {
        ((MediaBrowserService)object).notifyChildrenChanged(string, bundle);
    }
}
