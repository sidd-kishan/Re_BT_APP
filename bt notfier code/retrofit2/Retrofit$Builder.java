/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call$Factory
 *  okhttp3.HttpUrl
 *  okhttp3.OkHttpClient
 *  retrofit2.BuiltInConverters
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Converter$Factory
 *  retrofit2.Platform
 *  retrofit2.Retrofit
 */
package retrofit2;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Platform;
import retrofit2.Retrofit;

public static final class Retrofit.Builder {
    @Nullable
    private HttpUrl baseUrl;
    private final List<CallAdapter.Factory> callAdapterFactories;
    @Nullable
    private Call.Factory callFactory;
    @Nullable
    private Executor callbackExecutor;
    private final List<Converter.Factory> converterFactories = new ArrayList<Converter.Factory>();
    private final Platform platform;
    private boolean validateEagerly;

    public Retrofit.Builder() {
        this(Platform.get());
    }

    Retrofit.Builder(Platform platform) {
        this.callAdapterFactories = new ArrayList<CallAdapter.Factory>();
        this.platform = platform;
    }

    Retrofit.Builder(Retrofit retrofit) {
        int n;
        this.callAdapterFactories = new ArrayList<CallAdapter.Factory>();
        this.platform = Platform.get();
        this.callFactory = retrofit.callFactory;
        this.baseUrl = retrofit.baseUrl;
        int n2 = retrofit.converterFactories.size();
        int n3 = this.platform.defaultConverterFactoriesSize();
        for (n = 1; n < n2 - n3; ++n) {
            this.converterFactories.add((Converter.Factory)retrofit.converterFactories.get(n));
        }
        n = 0;
        n2 = retrofit.callAdapterFactories.size();
        n3 = this.platform.defaultCallAdapterFactoriesSize();
        while (true) {
            if (n >= n2 - n3) {
                this.callbackExecutor = retrofit.callbackExecutor;
                this.validateEagerly = retrofit.validateEagerly;
                return;
            }
            this.callAdapterFactories.add((CallAdapter.Factory)retrofit.callAdapterFactories.get(n));
            ++n;
        }
    }

    public Retrofit.Builder addCallAdapterFactory(CallAdapter.Factory factory) {
        this.callAdapterFactories.add(Objects.requireNonNull(factory, "factory == null"));
        return this;
    }

    public Retrofit.Builder addConverterFactory(Converter.Factory factory) {
        this.converterFactories.add(Objects.requireNonNull(factory, "factory == null"));
        return this;
    }

    public Retrofit.Builder baseUrl(String string) {
        Objects.requireNonNull(string, "baseUrl == null");
        return this.baseUrl(HttpUrl.get((String)string));
    }

    public Retrofit.Builder baseUrl(URL uRL) {
        Objects.requireNonNull(uRL, "baseUrl == null");
        return this.baseUrl(HttpUrl.get((String)uRL.toString()));
    }

    public Retrofit.Builder baseUrl(HttpUrl httpUrl) {
        Objects.requireNonNull(httpUrl, "baseUrl == null");
        Object object = httpUrl.pathSegments();
        if ("".equals(object.get(object.size() - 1))) {
            this.baseUrl = httpUrl;
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("baseUrl must end in /: ");
        ((StringBuilder)object).append(httpUrl);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public Retrofit build() {
        Object object;
        if (this.baseUrl == null) throw new IllegalStateException("Base URL required.");
        Call.Factory factory = object = this.callFactory;
        if (object == null) {
            factory = new OkHttpClient();
        }
        Object object2 = this.callbackExecutor;
        object = object2;
        if (object2 == null) {
            object = this.platform.defaultCallbackExecutor();
        }
        object2 = new ArrayList<CallAdapter.Factory>(this.callAdapterFactories);
        object2.addAll(this.platform.defaultCallAdapterFactories((Executor)object));
        ArrayList<Object> arrayList = new ArrayList<Object>(this.converterFactories.size() + 1 + this.platform.defaultConverterFactoriesSize());
        arrayList.add(new BuiltInConverters());
        arrayList.addAll(this.converterFactories);
        arrayList.addAll(this.platform.defaultConverterFactories());
        return new Retrofit(factory, this.baseUrl, Collections.unmodifiableList(arrayList), Collections.unmodifiableList(object2), (Executor)object, this.validateEagerly);
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public Retrofit.Builder callFactory(Call.Factory factory) {
        this.callFactory = Objects.requireNonNull(factory, "factory == null");
        return this;
    }

    public Retrofit.Builder callbackExecutor(Executor executor) {
        this.callbackExecutor = Objects.requireNonNull(executor, "executor == null");
        return this;
    }

    public Retrofit.Builder client(OkHttpClient okHttpClient) {
        return this.callFactory((Call.Factory)Objects.requireNonNull(okHttpClient, "client == null"));
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public Retrofit.Builder validateEagerly(boolean bl) {
        this.validateEagerly = bl;
        return this;
    }
}
