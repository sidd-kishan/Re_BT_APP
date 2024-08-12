/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.os;

import java.lang.reflect.Method;

static class ProcessCompat.Api16Impl {
    private static Method sMethodUserIdIsAppMethod;
    private static boolean sResolved;
    private static final Object sResolvedLock;

    static {
        sResolvedLock = new Object();
    }

    private ProcessCompat.Api16Impl() {
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
            sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
        }
        // MONITOREXIT : object
        try {
            if (sMethodUserIdIsAppMethod == null) return true;
            object = (Boolean)sMethodUserIdIsAppMethod.invoke(null, n);
            if (object != null) {
                return (Boolean)object;
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
