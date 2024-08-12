/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 *  androidx.camera.core.Logger
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;

public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     */
    public static String getAbsolutePathFromUri(ContentResolver object, Uri uri) {
        void var1_5;
        Object object2;
        block8: {
            ContentResolver contentResolver;
            block7: {
                object2 = null;
                contentResolver = null;
                try {
                    contentResolver = object = object.query(uri, new String[]{"_data"}, null, null, null);
                    object2 = object;
                    object = (Cursor)Preconditions.checkNotNull((Object)object);
                }
                catch (RuntimeException runtimeException) {
                    // empty catch block
                    break block7;
                }
                catch (Throwable throwable) {
                    // empty catch block
                    break block8;
                }
                try {
                    int n = object.getColumnIndexOrThrow("_data");
                    object.moveToFirst();
                    object2 = object.getString(n);
                    if (object == null) return object2;
                }
                catch (Throwable throwable) {
                    object2 = object;
                    break block8;
                }
                catch (RuntimeException runtimeException) {
                    contentResolver = object;
                    object = runtimeException;
                    break block7;
                }
                object.close();
                return object2;
            }
            object2 = contentResolver;
            {
                Logger.e((String)TAG, (String)String.format("Failed in getting absolute path for Uri %s with Exception %s", uri.toString(), object.toString()));
                if (contentResolver == null) return "";
            }
            contentResolver.close();
            return "";
        }
        if (object2 == null) throw var1_5;
        object2.close();
        throw var1_5;
    }
}
