/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.util.Log
 */
package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    private EnvironmentCompat() {
    }

    public static String getStorageState(File object) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Environment.getExternalStorageState((File)object);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return Environment.getStorageState((File)object);
        }
        try {
            if (!((File)object).getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) return MEDIA_UNKNOWN;
            object = Environment.getExternalStorageState();
            return object;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to resolve canonical path: ");
            stringBuilder.append(iOException);
            Log.w((String)TAG, (String)stringBuilder.toString());
        }
        return MEDIA_UNKNOWN;
    }
}
