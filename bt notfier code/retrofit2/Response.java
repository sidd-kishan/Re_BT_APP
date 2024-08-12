/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Headers
 *  okhttp3.Protocol
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.Response$Builder
 *  okhttp3.ResponseBody
 *  retrofit2.OkHttpCall$NoContentResponseBody
 */
package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.OkHttpCall;

public final class Response<T> {
    @Nullable
    private final T body;
    @Nullable
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    private Response(okhttp3.Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = responseBody;
    }

    public static <T> Response<T> error(int n, ResponseBody object) {
        Objects.requireNonNull(object, "body == null");
        if (n >= 400) {
            return Response.error((ResponseBody)object, new Response.Builder().body((ResponseBody)new OkHttpCall.NoContentResponseBody(object.contentType(), object.contentLength())).code(n).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("code < 400: ");
        ((StringBuilder)object).append(n);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) throw new IllegalArgumentException("rawResponse should not be successful response");
        return new Response<Object>(response, null, responseBody);
    }

    public static <T> Response<T> success(int n, @Nullable T object) {
        if (n >= 200 && n < 300) {
            return Response.success(object, new Response.Builder().code(n).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("code < 200 or >= 300: ");
        ((StringBuilder)object).append(n);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public static <T> Response<T> success(@Nullable T t) {
        return Response.success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(@Nullable T t, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        return Response.success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(@Nullable T t, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) throw new IllegalArgumentException("rawResponse must be successful response");
        return new Response<T>(response, t, null);
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.code();
    }

    @Nullable
    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
