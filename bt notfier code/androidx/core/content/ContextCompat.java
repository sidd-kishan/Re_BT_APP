/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Process
 *  android.util.Log
 *  androidx.core.content.ContextCompat$Api16Impl
 *  androidx.core.content.ContextCompat$Api19Impl
 *  androidx.core.content.ContextCompat$Api21Impl
 *  androidx.core.content.ContextCompat$Api23Impl
 *  androidx.core.content.ContextCompat$Api24Impl
 *  androidx.core.content.ContextCompat$Api26Impl
 *  androidx.core.content.ContextCompat$Api28Impl
 *  androidx.core.content.ContextCompat$Api30Impl
 *  androidx.core.content.ContextCompat$LegacyServiceMapHolder
 *  androidx.core.content.res.ResourcesCompat
 *  androidx.core.os.ExecutorCompat
 */
package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ExecutorCompat;
import java.io.File;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
public class ContextCompat {
    private static final String TAG = "ContextCompat";
    private static final Object sLock = new Object();
    private static final Object sSync = new Object();
    private static TypedValue sTempValue;

    protected ContextCompat() {
    }

    public static int checkSelfPermission(Context context, String string) {
        if (string == null) throw new IllegalArgumentException("permission is null");
        return context.checkPermission(string, Process.myPid(), Process.myUid());
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        if (Build.VERSION.SDK_INT < 24) return null;
        return Api24Impl.createDeviceProtectedStorageContext((Context)context);
    }

    private static File createFilesDir(File file) {
        Object object = sSync;
        synchronized (object) {
            if (file.exists()) return file;
            if (file.mkdirs()) {
                return file;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create files subdir ");
            stringBuilder.append(file.getPath());
            Log.w((String)"ContextCompat", (String)stringBuilder.toString());
            return file;
        }
    }

    public static String getAttributionTag(Context context) {
        if (Build.VERSION.SDK_INT < 30) return null;
        return Api30Impl.getAttributionTag((Context)context);
    }

    public static File getCodeCacheDir(Context context) {
        if (Build.VERSION.SDK_INT < 21) return ContextCompat.createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
        return Api21Impl.getCodeCacheDir((Context)context);
    }

    public static int getColor(Context context, int n) {
        if (Build.VERSION.SDK_INT < 23) return context.getResources().getColor(n);
        return Api23Impl.getColor((Context)context, (int)n);
    }

    public static ColorStateList getColorStateList(Context context, int n) {
        return ResourcesCompat.getColorStateList((Resources)context.getResources(), (int)n, (Resources.Theme)context.getTheme());
    }

    public static File getDataDir(Context object) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.getDataDir((Context)object);
        }
        object = object.getApplicationInfo().dataDir;
        object = object != null ? new File((String)object) : null;
        return object;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static Drawable getDrawable(Context context, int n) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getDrawable((Context)context, (int)n);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(n);
        }
        Object object = sLock;
        synchronized (object) {
            if (sTempValue == null) {
                TypedValue typedValue;
                sTempValue = typedValue = new TypedValue();
            }
            context.getResources().getValue(n, sTempValue, true);
            n = ContextCompat.sTempValue.resourceId;
            return context.getResources().getDrawable(n);
        }
    }

    public static File[] getExternalCacheDirs(Context context) {
        if (Build.VERSION.SDK_INT < 19) return new File[]{context.getExternalCacheDir()};
        return Api19Impl.getExternalCacheDirs((Context)context);
    }

    public static File[] getExternalFilesDirs(Context context, String string) {
        if (Build.VERSION.SDK_INT < 19) return new File[]{context.getExternalFilesDir(string)};
        return Api19Impl.getExternalFilesDirs((Context)context, (String)string);
    }

    public static Executor getMainExecutor(Context context) {
        if (Build.VERSION.SDK_INT < 28) return ExecutorCompat.create((Handler)new Handler(context.getMainLooper()));
        return Api28Impl.getMainExecutor((Context)context);
    }

    public static File getNoBackupFilesDir(Context context) {
        if (Build.VERSION.SDK_INT < 21) return ContextCompat.createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
        return Api21Impl.getNoBackupFilesDir((Context)context);
    }

    public static File[] getObbDirs(Context context) {
        if (Build.VERSION.SDK_INT < 19) return new File[]{context.getObbDir()};
        return Api19Impl.getObbDirs((Context)context);
    }

    public static <T> T getSystemService(Context object, Class<T> object2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (T)Api23Impl.getSystemService((Context)object, object2);
        }
        object = (object2 = ContextCompat.getSystemServiceName(object, object2)) != null ? object.getSystemService((String)object2) : null;
        return (T)object;
    }

    public static String getSystemServiceName(Context context, Class<?> clazz) {
        if (Build.VERSION.SDK_INT < 23) return (String)LegacyServiceMapHolder.SERVICES.get(clazz);
        return Api23Impl.getSystemServiceName((Context)context, clazz);
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        if (Build.VERSION.SDK_INT < 24) return false;
        return Api24Impl.isDeviceProtectedStorage((Context)context);
    }

    public static boolean startActivities(Context context, Intent[] intentArray) {
        return ContextCompat.startActivities(context, intentArray, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArray, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.startActivities((Context)context, (Intent[])intentArray, (Bundle)bundle);
        } else {
            context.startActivities(intentArray);
        }
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.startActivity((Context)context, (Intent)intent, (Bundle)bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.startForegroundService((Context)context, (Intent)intent);
        } else {
            context.startService(intent);
        }
    }
}
