/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.CompletableFutureCallAdapterFactory
 *  retrofit2.Converter$Factory
 *  retrofit2.DefaultCallAdapterFactory
 *  retrofit2.OptionalConverterFactory
 *  retrofit2.Platform$Android
 */
package retrofit2;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.CompletableFutureCallAdapterFactory;
import retrofit2.Converter;
import retrofit2.DefaultCallAdapterFactory;
import retrofit2.OptionalConverterFactory;
import retrofit2.Platform;

class Platform {
    private static final Platform PLATFORM = Platform.findPlatform();
    private final boolean hasJava8Types;
    @Nullable
    private final Constructor<MethodHandles.Lookup> lookupConstructor;

    Platform(boolean bl) {
        this.hasJava8Types = bl;
        Constructor constructor = null;
        Constructor constructor2 = null;
        if (bl) {
            constructor2 = constructor;
            try {
                constructor2 = constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
                constructor2 = constructor;
            }
            catch (NoClassDefFoundError | NoSuchMethodException throwable) {}
        }
        this.lookupConstructor = constructor2;
    }

    private static Platform findPlatform() {
        Object object = "Dalvik".equals(System.getProperty("java.vm.name")) ? new Android() : new Platform(true);
        return object;
    }

    static Platform get() {
        return PLATFORM;
    }

    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor list) {
        list = new DefaultCallAdapterFactory((Executor)((Object)list));
        list = this.hasJava8Types ? Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, list) : Collections.singletonList(list);
        return list;
    }

    int defaultCallAdapterFactoriesSize() {
        int n = this.hasJava8Types ? 2 : 1;
        return n;
    }

    @Nullable
    Executor defaultCallbackExecutor() {
        return null;
    }

    List<? extends Converter.Factory> defaultConverterFactories() {
        List<Object> list = this.hasJava8Types ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList();
        return list;
    }

    int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    @Nullable
    Object invokeDefaultMethod(Method method, Class<?> clazz, Object object, Object ... objectArray) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.lookupConstructor;
        constructor = constructor != null ? constructor.newInstance(clazz, -1) : MethodHandles.lookup();
        return ((MethodHandles.Lookup)((Object)constructor)).unreflectSpecial(method, clazz).bindTo(object).invokeWithArguments(objectArray);
    }

    boolean isDefaultMethod(Method method) {
        boolean bl = this.hasJava8Types && method.isDefault();
        return bl;
    }
}
