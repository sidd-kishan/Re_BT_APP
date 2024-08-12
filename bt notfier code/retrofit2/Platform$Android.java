/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  retrofit2.Platform
 *  retrofit2.Platform$Android$MainThreadExecutor
 */
package retrofit2;

import android.os.Build;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.Platform;

static final class Platform.Android
extends Platform {
    Platform.Android() {
        boolean bl = Build.VERSION.SDK_INT >= 24;
        super(bl);
    }

    public Executor defaultCallbackExecutor() {
        return new MainThreadExecutor();
    }

    @Nullable
    Object invokeDefaultMethod(Method method, Class<?> clazz, Object object, Object ... objectArray) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        return super.invokeDefaultMethod(method, clazz, object, objectArray);
    }
}
