/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 */
package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
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

    /*
     * Enabled unnecessary exception pruning
     */
    public T convert(ResponseBody responseBody) throws IOException {
        JsonReader jsonReader = this.gson.newJsonReader(responseBody.charStream());
        try {
            T t = this.adapter.read(jsonReader);
            JsonToken jsonToken = jsonReader.peek();
            JsonToken jsonToken2 = JsonToken.END_DOCUMENT;
            if (jsonToken == jsonToken2) {
                return t;
            }
            JsonIOException jsonIOException = new JsonIOException("JSON document was not fully consumed.");
            throw jsonIOException;
        }
        finally {
            responseBody.close();
        }
    }
}
