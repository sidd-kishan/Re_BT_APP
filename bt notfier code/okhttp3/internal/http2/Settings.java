/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http2.Settings$Companion
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0000J\u0019\u0010\t\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0086\u0002J\u0006\u0010\u001a\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lokhttp3/internal/http2/Settings;", "", "()V", "headerTableSize", "", "getHeaderTableSize", "()I", "initialWindowSize", "getInitialWindowSize", "set", "values", "", "clear", "", "get", "id", "getEnablePush", "", "defaultValue", "getMaxConcurrentStreams", "getMaxFrameSize", "getMaxHeaderListSize", "isSet", "merge", "other", "value", "size", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public final void clear() {
        this.set = 0;
        ArraysKt.fill$default((int[])this.values, (int)0, (int)0, (int)0, (int)6, null);
    }

    public final int get(int n) {
        return this.values[n];
    }

    public final boolean getEnablePush(boolean bl) {
        if ((this.set & 4) == 0) return bl;
        bl = this.values[2] == 1;
        return bl;
    }

    public final int getHeaderTableSize() {
        int n = (this.set & 2) != 0 ? this.values[1] : -1;
        return n;
    }

    public final int getInitialWindowSize() {
        int n = (this.set & 0x80) != 0 ? this.values[7] : 65535;
        return n;
    }

    public final int getMaxConcurrentStreams() {
        int n = (this.set & 0x10) != 0 ? this.values[4] : Integer.MAX_VALUE;
        return n;
    }

    public final int getMaxFrameSize(int n) {
        if ((this.set & 0x20) == 0) return n;
        n = this.values[5];
        return n;
    }

    public final int getMaxHeaderListSize(int n) {
        if ((this.set & 0x40) == 0) return n;
        n = this.values[6];
        return n;
    }

    public final boolean isSet(int n) {
        boolean bl = true;
        if ((1 << n & this.set) != 0) return bl;
        bl = false;
        return bl;
    }

    public final void merge(Settings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"other");
        int n = 0;
        while (true) {
            int n2 = n + 1;
            if (settings.isSet(n)) {
                this.set(n, settings.get(n));
            }
            if (n2 >= 10) {
                return;
            }
            n = n2;
        }
    }

    public final Settings set(int n, int n2) {
        if (n < 0) return this;
        int[] nArray = this.values;
        if (n >= nArray.length) return this;
        this.set = 1 << n | this.set;
        nArray[n] = n2;
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
