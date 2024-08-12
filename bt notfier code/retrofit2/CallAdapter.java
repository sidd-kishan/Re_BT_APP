/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 */
package retrofit2;

import java.lang.reflect.Type;
import retrofit2.Call;

public interface CallAdapter<R, T> {
    public T adapt(Call<R> var1);

    public Type responseType();
}
