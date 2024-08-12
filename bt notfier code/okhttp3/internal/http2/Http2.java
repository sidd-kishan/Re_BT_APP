/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.internal.Util
 *  okio.ByteString
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0000\u00a2\u0006\u0002\b#J.\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", "flags", "formattedType", "formattedType$okhttp", "frameLog", "inbound", "", "streamId", "length", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2 {
    private static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE;
    private static final String[] FLAGS;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        Object object;
        Object object2;
        String[] stringArray;
        Object object3;
        INSTANCE = new Http2();
        CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        Object object4 = new String[256];
        int n = 0;
        for (object3 = 0; object3 < 256; ++object3) {
            stringArray = Integer.toBinaryString(object3);
            Intrinsics.checkNotNullExpressionValue((Object)stringArray, (String)"toBinaryString(it)");
            object4[object3] = StringsKt.replace$default((String)Util.format((String)"%8s", (Object[])new Object[]{stringArray}), (char)' ', (char)'0', (boolean)false, (int)4, null);
        }
        BINARY = object4;
        object4 = FLAGS;
        object4[0] = "";
        object4[1] = "END_STREAM";
        stringArray = (String[])new int[1];
        stringArray[0] = true;
        object4[8] = "PADDED";
        for (object3 = 0; object3 < 1; ++object3) {
            object2 = stringArray[object3];
            object4 = FLAGS;
            object4[object2 | 8] = Intrinsics.stringPlus((String)object4[object2], (Object)"|PADDED");
        }
        object4 = FLAGS;
        object4[4] = "END_HEADERS";
        object4[32] = "PRIORITY";
        object4[36] = "END_HEADERS|PRIORITY";
        object2 = false;
        block2: while (object2 < 3) {
            int n2 = (new int[]{4, 32, 36})[object2];
            object = object2 + true;
            object3 = 0;
            while (true) {
                object2 = object;
                if (object3 >= 1) continue block2;
                object2 = stringArray[object3];
                ++object3;
                object4 = FLAGS;
                int n3 = object2 | n2;
                String[] stringArray2 = new StringBuilder();
                stringArray2.append((Object)FLAGS[object2]);
                stringArray2.append('|');
                stringArray2.append((Object)FLAGS[n2]);
                object4[n3] = stringArray2.toString();
                stringArray2 = FLAGS;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append((Object)FLAGS[object2]);
                ((StringBuilder)object4).append('|');
                ((StringBuilder)object4).append((Object)FLAGS[n2]);
                ((StringBuilder)object4).append("|PADDED");
                stringArray2[n3 | 8] = ((StringBuilder)object4).toString();
            }
        }
        object = FLAGS.length - 1;
        if (object < 0) return;
        object3 = n;
        while (true) {
            object2 = object3 + 1;
            stringArray = FLAGS;
            if (stringArray[object3] == null) {
                stringArray[object3] = BINARY[object3];
            }
            if (object2 > object) {
                return;
            }
            object3 = object2;
        }
    }

    private Http2() {
    }

    public final String formatFlags(int n, int n2) {
        if (n2 == 0) {
            return "";
        }
        if (n == 2) return BINARY[n2];
        if (n == 3) return BINARY[n2];
        if (n != 4 && n != 6) {
            if (n == 7) return BINARY[n2];
            if (n == 8) return BINARY[n2];
            Object object = FLAGS;
            if (n2 < ((String[])object).length) {
                object = object[n2];
                Intrinsics.checkNotNull((Object)object);
            } else {
                object = BINARY[n2];
            }
            Object object2 = object;
            if (n == 5 && (n2 & 4) != 0) {
                object = StringsKt.replace$default((String)object2, (String)"HEADERS", (String)"PUSH_PROMISE", (boolean)false, (int)4, null);
            } else {
                object = object2;
                if (n != 0) return object;
                object = object2;
                if ((n2 & 0x20) == 0) return object;
                object = StringsKt.replace$default((String)object2, (String)"PRIORITY", (String)"COMPRESSED", (boolean)false, (int)4, null);
            }
            return object;
        }
        String string = n2 == 1 ? "ACK" : BINARY[n2];
        return string;
    }

    public final String formattedType$okhttp(int n) {
        Object object = FRAME_NAMES;
        object = n < ((String[])object).length ? object[n] : Util.format((String)"0x%02x", (Object[])new Object[]{n});
        return object;
    }

    public final String frameLog(boolean bl, int n, int n2, int n3, int n4) {
        String string = this.formattedType$okhttp(n3);
        String string2 = this.formatFlags(n3, n4);
        String string3 = bl ? "<<" : ">>";
        return Util.format((String)"%s 0x%08x %5d %-13s %s", (Object[])new Object[]{string3, n, n2, string, string2});
    }
}
