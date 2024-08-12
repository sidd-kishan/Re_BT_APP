/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Callback
 *  okhttp3.Request
 *  okhttp3.Response
 *  okio.Timeout
 */
package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0000H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2={"Lokhttp3/Call;", "", "cancel", "", "clone", "enqueue", "responseCallback", "Lokhttp3/Callback;", "execute", "Lokhttp3/Response;", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "Factory", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface Call
extends Cloneable {
    public void cancel();

    public Call clone();

    public void enqueue(Callback var1);

    public Response execute() throws IOException;

    public boolean isCanceled();

    public boolean isExecuted();

    public Request request();

    public Timeout timeout();
}
