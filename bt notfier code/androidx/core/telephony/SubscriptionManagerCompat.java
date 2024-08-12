/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.telephony.SubscriptionManager
 *  androidx.core.telephony.SubscriptionManagerCompat$Api29Impl
 */
package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.core.telephony.SubscriptionManagerCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Exception performing whole class analysis ignored.
 */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int n) {
        if (n == -1) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getSlotIndex((int)n);
        }
        try {
            Integer n2;
            if (sGetSlotIndexMethod == null) {
                sGetSlotIndexMethod = Build.VERSION.SDK_INT >= 26 ? SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE) : SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                sGetSlotIndexMethod.setAccessible(true);
            }
            if ((n2 = (Integer)sGetSlotIndexMethod.invoke(null, n)) == null) return -1;
            n = n2;
            return n;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
        }
        return -1;
    }
}
