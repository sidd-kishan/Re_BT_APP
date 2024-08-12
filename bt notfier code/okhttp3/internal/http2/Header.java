/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http2.Header$Companion
 *  okio.ByteString
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Header;
import okio.ByteString;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\nH\u00d6\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lokhttp3/internal/http2/Header;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokio/ByteString;", "(Lokio/ByteString;Ljava/lang/String;)V", "(Lokio/ByteString;Lokio/ByteString;)V", "hpackSize", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final ByteString PSEUDO_PREFIX = ByteString.Companion.encodeUtf8(":");
    public static final ByteString RESPONSE_STATUS = ByteString.Companion.encodeUtf8(":status");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    static {
        TARGET_METHOD = ByteString.Companion.encodeUtf8(TARGET_METHOD_UTF8);
        TARGET_PATH = ByteString.Companion.encodeUtf8(TARGET_PATH_UTF8);
        TARGET_SCHEME = ByteString.Companion.encodeUtf8(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = ByteString.Companion.encodeUtf8(TARGET_AUTHORITY_UTF8);
    }

    public Header(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        this(ByteString.Companion.encodeUtf8(string), ByteString.Companion.encodeUtf8(string2));
    }

    public Header(ByteString byteString, String string) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        this(byteString, ByteString.Companion.encodeUtf8(string));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"name");
        Intrinsics.checkNotNullParameter((Object)byteString2, (String)"value");
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + this.value.size();
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int n, Object object) {
        if ((n & 1) != 0) {
            byteString = header.name;
        }
        if ((n & 2) == 0) return header.copy(byteString, byteString2);
        byteString2 = header.value;
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"name");
        Intrinsics.checkNotNullParameter((Object)byteString2, (String)"value");
        return new Header(byteString, byteString2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Header)) {
            return false;
        }
        object = (Header)object;
        if (!Intrinsics.areEqual((Object)this.name, (Object)((Header)object).name)) {
            return false;
        }
        if (Intrinsics.areEqual((Object)this.value, (Object)((Header)object).value)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode() * 31 + this.value.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name.utf8());
        stringBuilder.append(": ");
        stringBuilder.append(this.value.utf8());
        return stringBuilder.toString();
    }
}
