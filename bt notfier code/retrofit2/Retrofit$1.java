/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Platform
 *  retrofit2.Retrofit
 */
package retrofit2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
import retrofit2.Platform;
import retrofit2.Retrofit;

class Retrofit.1
implements InvocationHandler {
    private final Object[] emptyArgs;
    private final Platform platform;
    final Retrofit this$0;
    final Class val$service;

    Retrofit.1() {
        this.this$0 = retrofit;
        this.val$service = clazz;
        this.platform = Platform.get();
        this.emptyArgs = new Object[0];
    }

    @Override
    @Nullable
    public Object invoke(Object object, Method method, @Nullable Object[] objectArray) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objectArray);
        }
        if (objectArray == null) {
            objectArray = this.emptyArgs;
        }
        object = this.platform.isDefaultMethod(method) ? this.platform.invokeDefaultMethod(method, this.val$service, object, objectArray) : this.this$0.loadServiceMethod(method).invoke(objectArray);
        return object;
    }
}
