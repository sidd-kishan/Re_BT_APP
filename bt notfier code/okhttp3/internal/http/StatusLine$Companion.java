/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Protocol
 *  okhttp3.Response
 *  okhttp3.internal.http.StatusLine
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.internal.http.StatusLine;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/http/StatusLine$Companion;", "", "()V", "HTTP_CONTINUE", "", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "get", "Lokhttp3/internal/http/StatusLine;", "response", "Lokhttp3/Response;", "parse", "statusLine", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class StatusLine.Companion {
    private StatusLine.Companion() {
    }

    public /* synthetic */ StatusLine.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final StatusLine get(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        return new StatusLine(response.protocol(), response.code(), response.message());
    }

    public final StatusLine parse(String string) throws IOException {
        Protocol protocol;
        int n;
        Intrinsics.checkNotNullParameter((Object)string, (String)"statusLine");
        boolean bl = StringsKt.startsWith$default((String)string, (String)"HTTP/1.", (boolean)false, (int)2, null);
        int n2 = 9;
        if (bl) {
            if (string.length() < 9) throw new ProtocolException(Intrinsics.stringPlus((String)"Unexpected status line: ", (Object)string));
            if (string.charAt(8) != ' ') throw new ProtocolException(Intrinsics.stringPlus((String)"Unexpected status line: ", (Object)string));
            n = string.charAt(7) - 48;
            if (n != 0) {
                if (n != 1) throw new ProtocolException(Intrinsics.stringPlus((String)"Unexpected status line: ", (Object)string));
                protocol = Protocol.HTTP_1_1;
            } else {
                protocol = Protocol.HTTP_1_0;
            }
        } else {
            if (!StringsKt.startsWith$default((String)string, (String)"ICY ", (boolean)false, (int)2, null)) throw new ProtocolException(Intrinsics.stringPlus((String)"Unexpected status line: ", (Object)string));
            protocol = Protocol.HTTP_1_0;
            n2 = 4;
        }
        int n3 = string.length();
        n = n2 + 3;
        if (n3 < n) throw new ProtocolException(Intrinsics.stringPlus((String)"Unexpected status line: ", (Object)string));
        try {
            String string2 = string.substring(n2, n);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            n3 = Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            throw new ProtocolException(Intrinsics.stringPlus((String)"Unexpected status line: ", (Object)string));
        }
        if (string.length() > n) {
            if (string.charAt(n) != ' ') throw new ProtocolException(Intrinsics.stringPlus((String)"Unexpected status line: ", (Object)string));
            string = string.substring(n2 + 4);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        } else {
            string = "";
        }
        return new StatusLine(protocol, n3, string);
    }
}
