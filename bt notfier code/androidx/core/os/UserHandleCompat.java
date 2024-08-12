/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.UserHandle
 *  androidx.core.os.UserHandleCompat$Api24Impl
 */
package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.core.os.UserHandleCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Exception performing whole class analysis ignored.
 */
public class UserHandleCompat {
    private static Method sGetUserIdMethod;
    private static Constructor<UserHandle> sUserHandleConstructor;

    private UserHandleCompat() {
    }

    private static Method getGetUserIdMethod() throws NoSuchMethodException {
        Method method;
        if (sGetUserIdMethod != null) return sGetUserIdMethod;
        sGetUserIdMethod = method = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
        method.setAccessible(true);
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() throws NoSuchMethodException {
        if (sUserHandleConstructor != null) return sUserHandleConstructor;
        Constructor constructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
        sUserHandleConstructor = constructor;
        constructor.setAccessible(true);
        return sUserHandleConstructor;
    }

    public static UserHandle getUserHandleForUid(int n) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.getUserHandleForUid((int)n);
        }
        try {
            Integer n2 = (Integer)UserHandleCompat.getGetUserIdMethod().invoke(null, n);
            n2 = UserHandleCompat.getUserHandleConstructor().newInstance(n2);
            return n2;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
        catch (InstantiationException instantiationException) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(instantiationException);
            throw instantiationError;
        }
        catch (IllegalAccessException illegalAccessException) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(illegalAccessException);
            throw illegalAccessError;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(noSuchMethodException);
            throw noSuchMethodError;
        }
    }
}
