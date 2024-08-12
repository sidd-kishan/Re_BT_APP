/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okio.Buffer
 *  okio.ForwardingSource
 *  okio.Source
 *  retrofit2.OkHttpCall$ExceptionCatchingResponseBody
 */
package retrofit2;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import retrofit2.OkHttpCall;

class OkHttpCall.ExceptionCatchingResponseBody.1
extends ForwardingSource {
    final OkHttpCall.ExceptionCatchingResponseBody this$0;

    OkHttpCall.ExceptionCatchingResponseBody.1(OkHttpCall.ExceptionCatchingResponseBody exceptionCatchingResponseBody, Source source) {
        this.this$0 = exceptionCatchingResponseBody;
        super(source);
    }

    public long read(Buffer buffer, long l) throws IOException {
        try {
            l = super.read(buffer, l);
            return l;
        }
        catch (IOException iOException) {
            this.this$0.thrownException = iOException;
            throw iOException;
        }
    }
}
