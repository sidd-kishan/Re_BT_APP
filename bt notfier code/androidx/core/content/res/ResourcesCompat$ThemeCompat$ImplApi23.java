/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.util.Log
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

static class ResourcesCompat.ThemeCompat.ImplApi23 {
    private static Method sRebaseMethod;
    private static boolean sRebaseMethodFetched;
    private static final Object sRebaseMethodLock;

    static {
        sRebaseMethodLock = new Object();
    }

    private ResourcesCompat.ThemeCompat.ImplApi23() {
    }

    /*
     * WARNING - void declaration
     */
    static void rebase(Resources.Theme theme) {
        Object object = sRebaseMethodLock;
        synchronized (object) {
            block9: {
                void var0_3;
                Method method;
                boolean bl = sRebaseMethodFetched;
                if (!bl) {
                    try {
                        sRebaseMethod = method = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                        method.setAccessible(true);
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        Log.i((String)"ResourcesCompat", (String)"Failed to retrieve rebase() method", (Throwable)noSuchMethodException);
                    }
                    sRebaseMethodFetched = true;
                }
                if ((method = sRebaseMethod) == null) return;
                try {
                    sRebaseMethod.invoke(theme, new Object[0]);
                    break block9;
                }
                catch (InvocationTargetException invocationTargetException) {
                }
                catch (IllegalAccessException illegalAccessException) {
                    // empty catch block
                }
                Log.i((String)"ResourcesCompat", (String)"Failed to invoke rebase() method via reflection", (Throwable)var0_3);
                sRebaseMethod = null;
            }
            return;
        }
    }
}
