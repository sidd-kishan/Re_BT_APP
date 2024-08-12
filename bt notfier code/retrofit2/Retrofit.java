/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call$Factory
 *  okhttp3.HttpUrl
 *  okhttp3.RequestBody
 *  okhttp3.ResponseBody
 *  retrofit2.BuiltInConverters$ToStringConverter
 *  retrofit2.CallAdapter
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Platform
 *  retrofit2.Retrofit$1
 *  retrofit2.Retrofit$Builder
 *  retrofit2.ServiceMethod
 */
package retrofit2;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Platform;
import retrofit2.Retrofit;
import retrofit2.ServiceMethod;

public final class Retrofit {
    final HttpUrl baseUrl;
    final List<CallAdapter.Factory> callAdapterFactories;
    final Call.Factory callFactory;
    @Nullable
    final Executor callbackExecutor;
    final List<Converter.Factory> converterFactories;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache = new ConcurrentHashMap();
    final boolean validateEagerly;

    Retrofit(Call.Factory factory, HttpUrl httpUrl, List<Converter.Factory> list, List<CallAdapter.Factory> list2, @Nullable Executor executor, boolean bl) {
        this.callFactory = factory;
        this.baseUrl = httpUrl;
        this.converterFactories = list;
        this.callAdapterFactories = list2;
        this.callbackExecutor = executor;
        this.validateEagerly = bl;
    }

    private void validateServiceInterface(Class<?> serializable) {
        Class clazz;
        if (!((Class)serializable).isInterface()) {
            serializable = new IllegalArgumentException("API declarations must be interfaces.");
            throw serializable;
        }
        Serializable serializable2 = new ArrayDeque<Serializable>(1);
        serializable2.add(serializable);
        while (!serializable2.isEmpty()) {
            clazz = (Class)serializable2.removeFirst();
            if (clazz.getTypeParameters().length != 0) {
                serializable2 = new StringBuilder("Type parameters are unsupported on ");
                ((StringBuilder)serializable2).append(clazz.getName());
                if (clazz == serializable) throw new IllegalArgumentException(((StringBuilder)serializable2).toString());
                ((StringBuilder)serializable2).append(" which is an interface of ");
                ((StringBuilder)serializable2).append(((Class)serializable).getName());
                throw new IllegalArgumentException(((StringBuilder)serializable2).toString());
            }
            Collections.addAll(serializable2, clazz.getInterfaces());
        }
        if (!this.validateEagerly) return;
        clazz = Platform.get();
        serializable = ((Class)serializable).getDeclaredMethods();
        int n = ((Serializable)serializable).length;
        int n2 = 0;
        while (n2 < n) {
            serializable2 = serializable[n2];
            if (!clazz.isDefaultMethod((Method)((Object)serializable2)) && !Modifier.isStatic(((Method)((Object)serializable2)).getModifiers())) {
                this.loadServiceMethod((Method)((Object)serializable2));
            }
            ++n2;
        }
    }

    public HttpUrl baseUrl() {
        return this.baseUrl;
    }

    public CallAdapter<?, ?> callAdapter(Type type, Annotation[] annotationArray) {
        return this.nextCallAdapter(null, type, annotationArray);
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public Call.Factory callFactory() {
        return this.callFactory;
    }

    @Nullable
    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> T create(Class<T> clazz) {
        this.validateServiceInterface(clazz);
        ClassLoader classLoader = clazz.getClassLoader();
        1 var2_3 = new /* Unavailable Anonymous Inner Class!! */;
        return (T)Proxy.newProxyInstance(classLoader, new Class[]{clazz}, (InvocationHandler)var2_3);
    }

    ServiceMethod<?> loadServiceMethod(Method method) {
        ServiceMethod serviceMethod = this.serviceMethodCache.get(method);
        if (serviceMethod != null) {
            return serviceMethod;
        }
        Map<Method, ServiceMethod<?>> map = this.serviceMethodCache;
        synchronized (map) {
            ServiceMethod<?> serviceMethod2 = this.serviceMethodCache.get(method);
            serviceMethod = serviceMethod2;
            if (serviceMethod2 != null) return serviceMethod;
            serviceMethod = ServiceMethod.parseAnnotations((Retrofit)this, (Method)method);
            this.serviceMethodCache.put(method, serviceMethod);
            return serviceMethod;
        }
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CallAdapter<?, ?> nextCallAdapter(@Nullable CallAdapter.Factory object, Type type, Annotation[] object2) {
        int n;
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(object2, "annotations == null");
        int n2 = this.callAdapterFactories.indexOf(object) + 1;
        int n3 = this.callAdapterFactories.size();
        for (n = n2; n < n3; ++n) {
            CallAdapter callAdapter = this.callAdapterFactories.get(n).get(type, (Annotation[])object2, this);
            if (callAdapter == null) continue;
            return callAdapter;
        }
        object2 = new StringBuilder("Could not locate call adapter for ");
        ((StringBuilder)object2).append(type);
        ((StringBuilder)object2).append(".\n");
        if (object != null) {
            ((StringBuilder)object2).append("  Skipped:");
            for (n = 0; n < n2; ++n) {
                ((StringBuilder)object2).append("\n   * ");
                ((StringBuilder)object2).append(this.callAdapterFactories.get(n).getClass().getName());
            }
            ((StringBuilder)object2).append('\n');
        }
        ((StringBuilder)object2).append("  Tried:");
        n = this.callAdapterFactories.size();
        while (true) {
            if (n2 >= n) {
                object = new IllegalArgumentException(((StringBuilder)object2).toString());
                throw object;
            }
            ((StringBuilder)object2).append("\n   * ");
            ((StringBuilder)object2).append(this.callAdapterFactories.get(n2).getClass().getName());
            ++n2;
        }
    }

    public <T> Converter<T, RequestBody> nextRequestBodyConverter(@Nullable Converter.Factory object, Type type, Annotation[] object2, Annotation[] annotationArray) {
        int n;
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(object2, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArray, "methodAnnotations == null");
        int n2 = this.converterFactories.indexOf(object) + 1;
        int n3 = this.converterFactories.size();
        for (n = n2; n < n3; ++n) {
            Converter converter = this.converterFactories.get(n).requestBodyConverter(type, (Annotation[])object2, annotationArray, this);
            if (converter == null) continue;
            return converter;
        }
        object2 = new StringBuilder("Could not locate RequestBody converter for ");
        ((StringBuilder)object2).append(type);
        ((StringBuilder)object2).append(".\n");
        if (object != null) {
            ((StringBuilder)object2).append("  Skipped:");
            for (n = 0; n < n2; ++n) {
                ((StringBuilder)object2).append("\n   * ");
                ((StringBuilder)object2).append(this.converterFactories.get(n).getClass().getName());
            }
            ((StringBuilder)object2).append('\n');
        }
        ((StringBuilder)object2).append("  Tried:");
        n = this.converterFactories.size();
        while (true) {
            if (n2 >= n) {
                object = new IllegalArgumentException(((StringBuilder)object2).toString());
                throw object;
            }
            ((StringBuilder)object2).append("\n   * ");
            ((StringBuilder)object2).append(this.converterFactories.get(n2).getClass().getName());
            ++n2;
        }
    }

    public <T> Converter<ResponseBody, T> nextResponseBodyConverter(@Nullable Converter.Factory object, Type type, Annotation[] object2) {
        int n;
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(object2, "annotations == null");
        int n2 = this.converterFactories.indexOf(object) + 1;
        int n3 = this.converterFactories.size();
        for (n = n2; n < n3; ++n) {
            Converter converter = this.converterFactories.get(n).responseBodyConverter(type, (Annotation[])object2, this);
            if (converter == null) continue;
            return converter;
        }
        object2 = new StringBuilder("Could not locate ResponseBody converter for ");
        ((StringBuilder)object2).append(type);
        ((StringBuilder)object2).append(".\n");
        if (object != null) {
            ((StringBuilder)object2).append("  Skipped:");
            for (n = 0; n < n2; ++n) {
                ((StringBuilder)object2).append("\n   * ");
                ((StringBuilder)object2).append(this.converterFactories.get(n).getClass().getName());
            }
            ((StringBuilder)object2).append('\n');
        }
        ((StringBuilder)object2).append("  Tried:");
        n = this.converterFactories.size();
        while (true) {
            if (n2 >= n) {
                object = new IllegalArgumentException(((StringBuilder)object2).toString());
                throw object;
            }
            ((StringBuilder)object2).append("\n   * ");
            ((StringBuilder)object2).append(this.converterFactories.get(n2).getClass().getName());
            ++n2;
        }
    }

    public <T> Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArray, Annotation[] annotationArray2) {
        return this.nextRequestBodyConverter(null, type, annotationArray, annotationArray2);
    }

    public <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotationArray) {
        return this.nextResponseBodyConverter(null, type, annotationArray);
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotationArray) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArray, "annotations == null");
        int n = this.converterFactories.size();
        int n2 = 0;
        while (n2 < n) {
            Converter converter = this.converterFactories.get(n2).stringConverter(type, annotationArray, this);
            if (converter != null) {
                return converter;
            }
            ++n2;
        }
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }
}
