/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.HttpServiceMethod
 *  retrofit2.RequestFactory
 *  retrofit2.Retrofit
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.HttpServiceMethod;
import retrofit2.RequestFactory;
import retrofit2.Retrofit;
import retrofit2.Utils;

abstract class ServiceMethod<T> {
    ServiceMethod() {
    }

    static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method) {
        RequestFactory requestFactory = RequestFactory.parseAnnotations((Retrofit)retrofit, (Method)method);
        Type type = method.getGenericReturnType();
        if (Utils.hasUnresolvableType((Type)type)) throw Utils.methodError((Method)method, (String)"Method return type must not include a type variable or wildcard: %s", (Object[])new Object[]{type});
        if (type == Void.TYPE) throw Utils.methodError((Method)method, (String)"Service methods cannot return void.", (Object[])new Object[0]);
        return HttpServiceMethod.parseAnnotations((Retrofit)retrofit, (Method)method, (RequestFactory)requestFactory);
    }

    @Nullable
    abstract T invoke(Object[] var1);
}
