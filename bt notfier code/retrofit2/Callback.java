/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.Response
 */
package retrofit2;

import retrofit2.Call;
import retrofit2.Response;

public interface Callback<T> {
    public void onFailure(Call<T> var1, Throwable var2);

    public void onResponse(Call<T> var1, Response<T> var2);
}
