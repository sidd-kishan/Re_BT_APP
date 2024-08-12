/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.Response
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.OkHttpCall
 *  retrofit2.Response
 *  retrofit2.Utils
 */
package retrofit2;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.OkHttpCall;
import retrofit2.Response;
import retrofit2.Utils;

class OkHttpCall.1
implements okhttp3.Callback {
    final OkHttpCall this$0;
    final Callback val$callback;

    OkHttpCall.1() {
        this.this$0 = okHttpCall;
        this.val$callback = callback;
    }

    private void callFailure(Throwable throwable) {
        try {
            this.val$callback.onFailure((Call)this.this$0, throwable);
        }
        catch (Throwable throwable2) {
            Utils.throwIfFatal((Throwable)throwable2);
            throwable2.printStackTrace();
        }
    }

    public void onFailure(okhttp3.Call call, IOException iOException) {
        this.callFailure(iOException);
    }

    public void onResponse(okhttp3.Call call, okhttp3.Response response) {
        try {
            call = this.this$0.parseResponse(response);
        }
        catch (Throwable throwable) {
            Utils.throwIfFatal((Throwable)throwable);
            this.callFailure(throwable);
            return;
        }
        try {
            this.val$callback.onResponse((Call)this.this$0, (Response)call);
        }
        catch (Throwable throwable) {
            Utils.throwIfFatal((Throwable)throwable);
            throwable.printStackTrace();
        }
    }
}
