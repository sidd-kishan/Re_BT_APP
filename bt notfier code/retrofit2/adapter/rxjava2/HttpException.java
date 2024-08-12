/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.HttpException
 *  retrofit2.Response
 */
package retrofit2.adapter.rxjava2;

import retrofit2.Response;

@Deprecated
public final class HttpException
extends retrofit2.HttpException {
    public HttpException(Response<?> response) {
        super(response);
    }
}
