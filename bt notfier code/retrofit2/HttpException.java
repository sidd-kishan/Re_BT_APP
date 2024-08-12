/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Response
 */
package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.Response;

public class HttpException
extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public HttpException(Response<?> response) {
        super(HttpException.getMessage(response));
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    private static String getMessage(Response<?> response) {
        Objects.requireNonNull(response, "response == null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP ");
        stringBuilder.append(response.code());
        stringBuilder.append(" ");
        stringBuilder.append(response.message());
        return stringBuilder.toString();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public Response<?> response() {
        return this.response;
    }
}
