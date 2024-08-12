/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.MultipartBody$Part
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 */
package retrofit2;

import javax.annotation.Nullable;
import okhttp3.MultipartBody;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;

static final class ParameterHandler.RawPart
extends ParameterHandler<MultipartBody.Part> {
    static final ParameterHandler.RawPart INSTANCE = new ParameterHandler.RawPart();

    private ParameterHandler.RawPart() {
    }

    void apply(RequestBuilder requestBuilder, @Nullable MultipartBody.Part part) {
        if (part == null) return;
        requestBuilder.addPart(part);
    }
}
