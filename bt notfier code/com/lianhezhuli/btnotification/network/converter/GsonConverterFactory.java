/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.converter.GsonRequestBodyConverter
 *  com.lianhezhuli.btnotification.network.converter.GsonResponseBodyConverter
 *  okhttp3.RequestBody
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 */
package com.lianhezhuli.btnotification.network.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.lianhezhuli.btnotification.network.converter.GsonRequestBodyConverter;
import com.lianhezhuli.btnotification.network.converter.GsonResponseBodyConverter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class GsonConverterFactory
extends Converter.Factory {
    private final Gson gson;

    private GsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    public static GsonConverterFactory create() {
        return GsonConverterFactory.create(new Gson());
    }

    public static GsonConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new GsonConverterFactory(gson);
    }

    public Converter<?, RequestBody> requestBodyConverter(Type object, Annotation[] annotationArray, Annotation[] annotationArray2, Retrofit retrofit) {
        object = this.gson.getAdapter(TypeToken.get((Type)object));
        return new GsonRequestBodyConverter(this.gson, (TypeAdapter)object);
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type object, Annotation[] annotationArray, Retrofit retrofit) {
        object = this.gson.getAdapter(TypeToken.get((Type)object));
        return new GsonResponseBodyConverter(this.gson, (TypeAdapter)object);
    }
}
