/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.AsyncTimeout
 *  okio.Okio
 *  okio.Okio__JvmOkioKt
 */
package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Okio;
import okio.Okio__JvmOkioKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
final class SocketAsyncTimeout
extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        this.socket = socket;
    }

    protected IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException == null) return socketTimeoutException;
        socketTimeoutException.initCause(iOException);
        return socketTimeoutException;
    }

    protected void timedOut() {
        try {
            this.socket.close();
        }
        catch (AssertionError assertionError) {
            if (!Okio.isAndroidGetsocknameError((AssertionError)assertionError)) throw assertionError;
            Okio__JvmOkioKt.access$getLogger$p().log(Level.WARNING, Intrinsics.stringPlus((String)"Failed to close timed out socket ", (Object)this.socket), (Throwable)((Object)assertionError));
        }
        catch (Exception exception) {
            Okio__JvmOkioKt.access$getLogger$p().log(Level.WARNING, Intrinsics.stringPlus((String)"Failed to close timed out socket ", (Object)this.socket), exception);
        }
    }
}
