/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 */
package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

static class BundleCompat.BundleCompatBaseImpl {
    private static final String TAG = "BundleCompatBaseImpl";
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;

    private BundleCompat.BundleCompatBaseImpl() {
    }

    /*
     * WARNING - void declaration
     */
    public static IBinder getBinder(Bundle bundle, String string) {
        void var0_4;
        Method method;
        if (!sGetIBinderMethodFetched) {
            try {
                sGetIBinderMethod = method = Bundle.class.getMethod("getIBinder", String.class);
                method.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Failed to retrieve getIBinder method", (Throwable)noSuchMethodException);
            }
            sGetIBinderMethodFetched = true;
        }
        if ((method = sGetIBinderMethod) == null) return null;
        try {
            bundle = (IBinder)method.invoke(bundle, string);
            return bundle;
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        Log.i((String)TAG, (String)"Failed to invoke getIBinder via reflection", (Throwable)var0_4);
        sGetIBinderMethod = null;
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public static void putBinder(Bundle bundle, String string, IBinder iBinder) {
        block7: {
            void var0_4;
            Method method;
            if (!sPutIBinderMethodFetched) {
                try {
                    sPutIBinderMethod = method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    method.setAccessible(true);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Log.i((String)TAG, (String)"Failed to retrieve putIBinder method", (Throwable)noSuchMethodException);
                }
                sPutIBinderMethodFetched = true;
            }
            if ((method = sPutIBinderMethod) == null) return;
            try {
                method.invoke(bundle, string, iBinder);
                break block7;
            }
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException) {
                // empty catch block
            }
            Log.i((String)TAG, (String)"Failed to invoke putIBinder via reflection", (Throwable)var0_4);
            sPutIBinderMethod = null;
        }
    }
}
