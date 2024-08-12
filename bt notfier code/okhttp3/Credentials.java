/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  okio.ByteString
 */
package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Lokhttp3/Credentials;", "", "()V", "basic", "", "username", "password", "charset", "Ljava/nio/charset/Charset;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @JvmStatic
    public static final String basic(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"username");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"password");
        return Credentials.basic$default(string, string2, null, 4, null);
    }

    @JvmStatic
    public static final String basic(String string, String string2, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"username");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"password");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(':');
        stringBuilder.append(string2);
        string = stringBuilder.toString();
        return Intrinsics.stringPlus((String)"Basic ", (Object)ByteString.Companion.encodeString(string, charset).base64());
    }

    public static /* synthetic */ String basic$default(String string, String string2, Charset charset, int n, Object object) {
        if ((n & 4) == 0) return Credentials.basic(string, string2, charset);
        charset = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue((Object)charset, (String)"ISO_8859_1");
        return Credentials.basic(string, string2, charset);
    }
}
