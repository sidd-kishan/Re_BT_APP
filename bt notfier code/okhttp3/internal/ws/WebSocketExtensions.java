/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.ws.WebSocketExtensions$Companion
 */
package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketExtensions;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean bl, Integer n, boolean bl2, Integer n2, boolean bl3, boolean bl4) {
        this.perMessageDeflate = bl;
        this.clientMaxWindowBits = n;
        this.clientNoContextTakeover = bl2;
        this.serverMaxWindowBits = n2;
        this.serverNoContextTakeover = bl3;
        this.unknownValues = bl4;
    }

    public /* synthetic */ WebSocketExtensions(boolean bl, Integer n, boolean bl2, Integer n2, boolean bl3, boolean bl4, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            bl = false;
        }
        defaultConstructorMarker = null;
        if ((n3 & 2) != 0) {
            n = null;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        if ((n3 & 8) != 0) {
            n2 = defaultConstructorMarker;
        }
        if ((n3 & 0x10) != 0) {
            bl3 = false;
        }
        if ((n3 & 0x20) != 0) {
            bl4 = false;
        }
        this(bl, n, bl2, n2, bl3, bl4);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean bl, Integer n, boolean bl2, Integer n2, boolean bl3, boolean bl4, int n3, Object object) {
        if ((n3 & 1) != 0) {
            bl = webSocketExtensions.perMessageDeflate;
        }
        if ((n3 & 2) != 0) {
            n = webSocketExtensions.clientMaxWindowBits;
        }
        if ((n3 & 4) != 0) {
            bl2 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((n3 & 8) != 0) {
            n2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((n3 & 0x10) != 0) {
            bl3 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((n3 & 0x20) == 0) return webSocketExtensions.copy(bl, n, bl2, n2, bl3, bl4);
        bl4 = webSocketExtensions.unknownValues;
        return webSocketExtensions.copy(bl, n, bl2, n2, bl3, bl4);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean bl, Integer n, boolean bl2, Integer n2, boolean bl3, boolean bl4) {
        return new WebSocketExtensions(bl, n, bl2, n2, bl3, bl4);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WebSocketExtensions)) {
            return false;
        }
        object = (WebSocketExtensions)object;
        if (this.perMessageDeflate != ((WebSocketExtensions)object).perMessageDeflate) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.clientMaxWindowBits, (Object)((WebSocketExtensions)object).clientMaxWindowBits)) {
            return false;
        }
        if (this.clientNoContextTakeover != ((WebSocketExtensions)object).clientNoContextTakeover) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.serverMaxWindowBits, (Object)((WebSocketExtensions)object).serverMaxWindowBits)) {
            return false;
        }
        if (this.serverNoContextTakeover != ((WebSocketExtensions)object).serverNoContextTakeover) {
            return false;
        }
        if (this.unknownValues == ((WebSocketExtensions)object).unknownValues) return true;
        return false;
    }

    public int hashCode() {
        int n;
        int n2;
        int n3 = this.perMessageDeflate;
        int n4 = 1;
        int n5 = n3;
        if (n3 != 0) {
            n5 = 1;
        }
        Integer n6 = this.clientMaxWindowBits;
        int n7 = 0;
        n3 = n6 == null ? 0 : ((Object)n6).hashCode();
        int n8 = n2 = this.clientNoContextTakeover;
        if (n2 != 0) {
            n8 = 1;
        }
        if ((n6 = this.serverMaxWindowBits) != null) {
            n7 = ((Object)n6).hashCode();
        }
        n2 = n = this.serverNoContextTakeover;
        if (n != 0) {
            n2 = 1;
        }
        if ((n = this.unknownValues) != 0) return ((((n5 * 31 + n3) * 31 + n8) * 31 + n7) * 31 + n2) * 31 + n4;
        n4 = n;
        return ((((n5 * 31 + n3) * 31 + n8) * 31 + n7) * 31 + n2) * 31 + n4;
    }

    public final boolean noContextTakeover(boolean bl) {
        bl = bl ? this.clientNoContextTakeover : this.serverNoContextTakeover;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebSocketExtensions(perMessageDeflate=");
        stringBuilder.append(this.perMessageDeflate);
        stringBuilder.append(", clientMaxWindowBits=");
        stringBuilder.append(this.clientMaxWindowBits);
        stringBuilder.append(", clientNoContextTakeover=");
        stringBuilder.append(this.clientNoContextTakeover);
        stringBuilder.append(", serverMaxWindowBits=");
        stringBuilder.append(this.serverMaxWindowBits);
        stringBuilder.append(", serverNoContextTakeover=");
        stringBuilder.append(this.serverNoContextTakeover);
        stringBuilder.append(", unknownValues=");
        stringBuilder.append(this.unknownValues);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
