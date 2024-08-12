/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call
 *  okhttp3.Call$Factory
 *  okhttp3.Callback
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  okio.Timeout
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Converter
 *  retrofit2.OkHttpCall$ExceptionCatchingResponseBody
 *  retrofit2.OkHttpCall$NoContentResponseBody
 *  retrofit2.RequestFactory
 *  retrofit2.Response
 *  retrofit2.Utils
 */
package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.OkHttpCall;
import retrofit2.RequestFactory;
import retrofit2.Response;
import retrofit2.Utils;

final class OkHttpCall<T>
implements Call<T> {
    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;
    @Nullable
    private Throwable creationFailure;
    private boolean executed;
    @Nullable
    private okhttp3.Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, T> responseConverter;

    OkHttpCall(RequestFactory requestFactory, Object[] objectArray, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objectArray;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private okhttp3.Call createRawCall() throws IOException {
        okhttp3.Call call = this.callFactory.newCall(this.requestFactory.create(this.args));
        if (call == null) throw new NullPointerException("Call.Factory returned null.");
        return call;
    }

    /*
     * WARNING - void declaration
     */
    private okhttp3.Call getRawCall() throws IOException {
        void var1_5;
        Object object = this.rawCall;
        if (object != null) {
            return object;
        }
        object = this.creationFailure;
        if (object != null) {
            if (object instanceof IOException) throw (IOException)object;
            if (!(object instanceof RuntimeException)) throw (Error)object;
            throw (RuntimeException)object;
        }
        try {
            this.rawCall = object = this.createRawCall();
            return object;
        }
        catch (IOException iOException) {
        }
        catch (Error error) {
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        Utils.throwIfFatal((Throwable)var1_5);
        this.creationFailure = var1_5;
        throw var1_5;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call == null) return;
        call.cancel();
    }

    public OkHttpCall<T> clone() {
        return new OkHttpCall<T>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void enqueue(Callback<T> object) {
        Objects.requireNonNull(object, "callback == null");
        // MONITORENTER : this
        if (this.executed) {
            object = new Object("Already executed.");
            throw object;
        }
        this.executed = true;
        okhttp3.Call call = this.rawCall;
        Throwable throwable = this.creationFailure;
        okhttp3.Call call2 = call;
        Throwable throwable2 = throwable;
        if (call == null) {
            call2 = call;
            throwable2 = throwable;
            if (throwable == null) {
                try {
                    this.rawCall = call2 = this.createRawCall();
                    throwable2 = throwable;
                }
                catch (Throwable throwable3) {
                    Utils.throwIfFatal((Throwable)throwable3);
                    this.creationFailure = throwable3;
                    call2 = call;
                }
            }
        }
        // MONITOREXIT : this
        if (throwable2 != null) {
            object.onFailure((Call)this, throwable2);
            return;
        }
        if (this.canceled) {
            call2.cancel();
        }
        call2.enqueue((okhttp3.Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public Response<T> execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                okhttp3.Call call = this.getRawCall();
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl5 : MonitorExitStatement: MONITOREXIT : this
                if (!this.canceled) return this.parseResponse(call.execute());
                call.cancel();
                return this.parseResponse(call.execute());
            }
            IllegalStateException illegalStateException = new IllegalStateException("Already executed.");
            throw illegalStateException;
        }
    }

    public boolean isCanceled() {
        boolean bl = this.canceled;
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        synchronized (this) {
            if (this.rawCall == null || !this.rawCall.isCanceled()) {
                bl2 = false;
            }
            return bl2;
        }
    }

    public boolean isExecuted() {
        synchronized (this) {
            boolean bl = this.executed;
            return bl;
        }
    }

    Response<T> parseResponse(okhttp3.Response response) throws IOException {
        ResponseBody responseBody = response.body();
        okhttp3.Response response2 = response.newBuilder().body((ResponseBody)new NoContentResponseBody(responseBody.contentType(), responseBody.contentLength())).build();
        int n = response2.code();
        if (n >= 200 && n < 300) {
            if (n != 204 && n != 205) {
                response = new ExceptionCatchingResponseBody(responseBody);
                try {
                    responseBody = Response.success((Object)this.responseConverter.convert((Object)response), (okhttp3.Response)response2);
                    return responseBody;
                }
                catch (RuntimeException runtimeException) {
                    response.throwIfCaught();
                    throw runtimeException;
                }
            }
            responseBody.close();
            return Response.success(null, (okhttp3.Response)response2);
        }
        try {
            response = Response.error((ResponseBody)Utils.buffer((ResponseBody)responseBody), (okhttp3.Response)response2);
            return response;
        }
        finally {
            responseBody.close();
        }
    }

    public Request request() {
        synchronized (this) {
            try {
                try {
                    Request request = this.getRawCall().request();
                    return request;
                }
                catch (IOException iOException) {
                    RuntimeException runtimeException = new RuntimeException("Unable to create request.", iOException);
                    throw runtimeException;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public Timeout timeout() {
        synchronized (this) {
            try {
                try {
                    Timeout timeout = this.getRawCall().timeout();
                    return timeout;
                }
                catch (IOException iOException) {
                    RuntimeException runtimeException = new RuntimeException("Unable to create call.", iOException);
                    throw runtimeException;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}
