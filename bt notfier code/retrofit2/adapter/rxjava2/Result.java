/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Response
 */
package retrofit2.adapter.rxjava2;

import javax.annotation.Nullable;
import retrofit2.Response;

public final class Result<T> {
    @Nullable
    private final Throwable error;
    @Nullable
    private final Response<T> response;

    private Result(@Nullable Response<T> response, @Nullable Throwable throwable) {
        this.response = response;
        this.error = throwable;
    }

    public static <T> Result<T> error(Throwable throwable) {
        if (throwable == null) throw new NullPointerException("error == null");
        return new Result<T>(null, throwable);
    }

    public static <T> Result<T> response(Response<T> response) {
        if (response == null) throw new NullPointerException("response == null");
        return new Result<T>(response, null);
    }

    @Nullable
    public Throwable error() {
        return this.error;
    }

    public boolean isError() {
        boolean bl = this.error != null;
        return bl;
    }

    @Nullable
    public Response<T> response() {
        return this.response;
    }
}
