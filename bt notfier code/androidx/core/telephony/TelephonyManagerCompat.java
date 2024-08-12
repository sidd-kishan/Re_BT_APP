/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  androidx.core.telephony.SubscriptionManagerCompat
 *  androidx.core.telephony.TelephonyManagerCompat$Api23Impl
 *  androidx.core.telephony.TelephonyManagerCompat$Api26Impl
 *  androidx.core.telephony.TelephonyManagerCompat$Api30Impl
 */
package androidx.core.telephony;

import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.telephony.SubscriptionManagerCompat;
import androidx.core.telephony.TelephonyManagerCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Exception performing whole class analysis ignored.
 */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    private TelephonyManagerCompat() {
    }

    public static String getImei(TelephonyManager object) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getImei((TelephonyManager)object);
        }
        if (Build.VERSION.SDK_INT < 22) return object.getDeviceId();
        int n = TelephonyManagerCompat.getSubscriptionId(object);
        if (n == Integer.MAX_VALUE) return object.getDeviceId();
        if (n == -1) return object.getDeviceId();
        n = SubscriptionManagerCompat.getSlotIndex((int)n);
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getDeviceId((TelephonyManager)object, (int)n);
        }
        try {
            if (sGetDeviceIdMethod == null) {
                Method method;
                sGetDeviceIdMethod = method = TelephonyManager.class.getDeclaredMethod("getDeviceId", Integer.TYPE);
                method.setAccessible(true);
            }
            object = (String)sGetDeviceIdMethod.invoke(object, n);
            return object;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }

    public static int getSubscriptionId(TelephonyManager object) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getSubscriptionId((TelephonyManager)object);
        }
        if (Build.VERSION.SDK_INT < 22) return Integer.MAX_VALUE;
        try {
            if (sGetSubIdMethod == null) {
                Method method;
                sGetSubIdMethod = method = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                method.setAccessible(true);
            }
            if ((object = (Integer)sGetSubIdMethod.invoke(object, new Object[0])) == null) return Integer.MAX_VALUE;
            if ((Integer)object == -1) return Integer.MAX_VALUE;
            int n = (Integer)object;
            return n;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
        }
        return Integer.MAX_VALUE;
    }
}
