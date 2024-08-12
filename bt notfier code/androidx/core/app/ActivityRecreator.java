/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.util.Log
 *  androidx.core.app.ActivityRecreator$1
 *  androidx.core.app.ActivityRecreator$3
 *  androidx.core.app.ActivityRecreator$LifecycleCheckCallbacks
 */
package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.ActivityRecreator;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass;
    private static final Handler mainHandler;
    protected static final Field mainThreadField;
    protected static final Method performStopActivity2ParamsMethod;
    protected static final Method performStopActivity3ParamsMethod;
    protected static final Method requestRelaunchActivityMethod;
    protected static final Field tokenField;

    static {
        mainHandler = new Handler(Looper.getMainLooper());
        activityThreadClass = ActivityRecreator.getActivityThreadClass();
        mainThreadField = ActivityRecreator.getMainThreadField();
        tokenField = ActivityRecreator.getTokenField();
        performStopActivity3ParamsMethod = ActivityRecreator.getPerformStopActivity3Params(activityThreadClass);
        performStopActivity2ParamsMethod = ActivityRecreator.getPerformStopActivity2Params(activityThreadClass);
        requestRelaunchActivityMethod = ActivityRecreator.getRequestRelaunchActivityMethod(activityThreadClass);
    }

    private ActivityRecreator() {
    }

    private static Class<?> getActivityThreadClass() {
        try {
            Class<?> clazz = Class.forName("android.app.ActivityThread");
            return clazz;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Field getMainThreadField() {
        try {
            Field field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
            return field;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Method getPerformStopActivity2Params(Class<?> genericDeclaration) {
        if (genericDeclaration == null) {
            return null;
        }
        try {
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
            return genericDeclaration;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Method getPerformStopActivity3Params(Class<?> genericDeclaration) {
        if (genericDeclaration == null) {
            return null;
        }
        try {
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
            return genericDeclaration;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> genericDeclaration) {
        if (!ActivityRecreator.needsRelaunchCall()) return null;
        if (genericDeclaration == null) return null;
        try {
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
            return genericDeclaration;
        }
        catch (Throwable throwable) {
        }
        return null;
    }

    private static Field getTokenField() {
        try {
            Field field = Activity.class.getDeclaredField("mToken");
            field.setAccessible(true);
            return field;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static boolean needsRelaunchCall() {
        boolean bl = Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
        return bl;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    protected static boolean queueOnStopIfNecessary(Object object, int n, Activity object2) {
        Object object3;
        try {
            object3 = tokenField.get(object2);
            if (object3 != object) return false;
        }
        catch (Throwable throwable) {
            Log.e((String)LOG_TAG, (String)"Exception while fetching field values", (Throwable)throwable);
            return false;
        }
        {
            if (object2.hashCode() != n) return false;
            object2 = mainThreadField.get(object2);
            object = mainHandler;
            3 var4_5 = new /* Unavailable Anonymous Inner Class!! */;
            object.postAtFrontOfQueue((Runnable)var4_5);
            return true;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     */
    static boolean recreate(Activity activity) {
        LifecycleCheckCallbacks lifecycleCheckCallbacks;
        Application application;
        Object object;
        Object object2;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (ActivityRecreator.needsRelaunchCall() && requestRelaunchActivityMethod == null) {
            return false;
        }
        if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
            return false;
        }
        try {
            object2 = tokenField.get(activity);
            if (object2 == null) {
                return false;
            }
            object = mainThreadField.get(activity);
            if (object == null) {
                return false;
            }
            application = activity.getApplication();
            lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
            application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)lifecycleCheckCallbacks);
            Handler handler = mainHandler;
            1 var6_8 = new /* Unavailable Anonymous Inner Class!! */;
            handler.post((Runnable)var6_8);
        }
        catch (Throwable throwable) {
            return false;
        }
        if (ActivityRecreator.needsRelaunchCall()) {
            requestRelaunchActivityMethod.invoke(object, object2, null, null, 0, false, null, null, false, false);
        } else {
            activity.recreate();
        }
        {
            catch (Throwable throwable) {
                object2 = mainHandler;
                object = new /* Unavailable Anonymous Inner Class!! */;
                object2.post((Runnable)object);
                throw throwable;
            }
            object = mainHandler;
            activity = new /* Unavailable Anonymous Inner Class!! */;
            object.post((Runnable)activity);
            return true;
        }
    }
}
