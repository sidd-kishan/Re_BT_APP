/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.MediaType
 *  okhttp3.Request
 *  retrofit2.Invocation
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 *  retrofit2.RequestFactory$Builder
 *  retrofit2.Retrofit
 */
package retrofit2;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import retrofit2.Invocation;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.RequestFactory;
import retrofit2.Retrofit;

final class RequestFactory {
    private final HttpUrl baseUrl;
    @Nullable
    private final MediaType contentType;
    private final boolean hasBody;
    @Nullable
    private final Headers headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    @Nullable
    private final String relativeUrl;

    RequestFactory(Builder builder) {
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
        this.isKotlinSuspendFunction = builder.isKotlinSuspendFunction;
    }

    static RequestFactory parseAnnotations(Retrofit retrofit, Method method) {
        return new Builder(retrofit, method).build();
    }

    Request create(Object[] object) throws IOException {
        int n = ((Object[])object).length;
        ParameterHandler<?>[] parameterHandlerArray = this.parameterHandlers;
        if (n != parameterHandlerArray.length) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Argument count (");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(") doesn't match expected count (");
            ((StringBuilder)object).append(parameterHandlerArray.length);
            ((StringBuilder)object).append(")");
            object = new IllegalArgumentException(((StringBuilder)object).toString());
            throw object;
        }
        RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        int n2 = n;
        if (this.isKotlinSuspendFunction) {
            n2 = n - 1;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n2);
        n = 0;
        while (n < n2) {
            arrayList.add(object[n]);
            parameterHandlerArray[n].apply(requestBuilder, object[n]);
            ++n;
        }
        return requestBuilder.get().tag(Invocation.class, (Object)new Invocation(this.method, arrayList)).build();
    }
}
