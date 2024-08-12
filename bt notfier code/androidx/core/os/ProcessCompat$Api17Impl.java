/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.UserHandle
 */
package androidx.core.os;

import android.os.UserHandle;
import java.lang.reflect.Method;

static class ProcessCompat.Api17Impl {
    private static Method sMethodUserHandleIsAppMethod;
    private static boolean sResolved;
    private static final Object sResolvedLock;

    static {
        sResolvedLock = new Object();
    }

    private ProcessCompat.Api17Impl() {
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    static boolean isApplicationUid(int n) {
        Object object;
        block8: {
            object = sResolvedLock;
            // MONITORENTER : object
            if (sResolved) break block8;
            sResolved = true;
            sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
        }
        // MONITOREXIT : object
        try {
            if (sMethodUserHandleIsAppMethod == null) return true;
            if ((Boolean)sMethodUserHandleIsAppMethod.invoke(null, n) != null) {
                return true;
            }
            object = new NullPointerException();
            throw object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
}
