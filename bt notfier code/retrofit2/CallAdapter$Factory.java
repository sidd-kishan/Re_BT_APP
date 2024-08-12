/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.CallAdapter
 *  retrofit2.Retrofit
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.Utils;

public static abstract class CallAdapter.Factory {
    protected static Type getParameterUpperBound(int n, ParameterizedType parameterizedType) {
        return Utils.getParameterUpperBound((int)n, (ParameterizedType)parameterizedType);
    }

    protected static Class<?> getRawType(Type type) {
        return Utils.getRawType((Type)type);
    }

    @Nullable
    public abstract CallAdapter<?, ?> get(Type var1, Annotation[] var2, Retrofit var3);
}
