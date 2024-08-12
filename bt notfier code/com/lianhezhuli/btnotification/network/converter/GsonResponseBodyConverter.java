/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.exception.ApiException
 *  com.lianhezhuli.btnotification.network.response.CheckResponse
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 */
package com.lianhezhuli.btnotification.network.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.lianhezhuli.btnotification.network.exception.ApiException;
import com.lianhezhuli.btnotification.network.response.CheckResponse;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T>
implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        String string = responseBody.string();
        CheckResponse checkResponse = this.gson.fromJson(string, CheckResponse.class);
        if (!checkResponse.isSuccess()) {
            responseBody.close();
            throw new ApiException(checkResponse.getCode(), checkResponse.getMsg(), string);
        }
        try {
            string = this.adapter.fromJson(string);
            return (T)string;
        }
        finally {
            responseBody.close();
        }
    }
}
