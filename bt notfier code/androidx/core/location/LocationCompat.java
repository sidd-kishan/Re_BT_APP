/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.SystemClock
 *  androidx.core.location.LocationCompat$Api17Impl
 *  androidx.core.location.LocationCompat$Api18Impl
 */
package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.location.LocationCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis ignored.
 */
public final class LocationCompat {
    private static final String EXTRA_IS_MOCK = "mockLocation";
    private static Method sSetIsFromMockProviderMethod;

    private LocationCompat() {
    }

    public static long getElapsedRealtimeMillis(Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos((Location)location));
        }
        long l = System.currentTimeMillis() - location.getTime();
        long l2 = SystemClock.elapsedRealtime();
        if (l < 0L) {
            return l2;
        }
        if (l <= l2) return l2 - l;
        return 0L;
    }

    public static long getElapsedRealtimeNanos(Location location) {
        if (Build.VERSION.SDK_INT < 17) return TimeUnit.MILLISECONDS.toNanos(LocationCompat.getElapsedRealtimeMillis(location));
        return Api17Impl.getElapsedRealtimeNanos((Location)location);
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        Method method;
        if (sSetIsFromMockProviderMethod != null) return sSetIsFromMockProviderMethod;
        sSetIsFromMockProviderMethod = method = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
        method.setAccessible(true);
        return sSetIsFromMockProviderMethod;
    }

    public static boolean isMock(Location location) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.isMock((Location)location);
        }
        if ((location = location.getExtras()) != null) return location.getBoolean("mockLocation", false);
        return false;
    }

    public static void setMock(Location location, boolean bl) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                LocationCompat.getSetIsFromMockProviderMethod().invoke(location, bl);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new RuntimeException(invocationTargetException);
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
        } else {
            Bundle bundle = location.getExtras();
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("mockLocation", true);
                location.setExtras(bundle);
            } else {
                bundle.putBoolean("mockLocation", true);
            }
        }
    }
}
