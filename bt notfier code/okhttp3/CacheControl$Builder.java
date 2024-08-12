/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CacheControl
 */
package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CacheControl.Builder {
    private boolean immutable;
    private int maxAgeSeconds = -1;
    private int maxStaleSeconds = -1;
    private int minFreshSeconds = -1;
    private boolean noCache;
    private boolean noStore;
    private boolean noTransform;
    private boolean onlyIfCached;

    private final int clampToInt(long l) {
        int n = l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l;
        return n;
    }

    public final CacheControl build() {
        return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
    }

    public final CacheControl.Builder immutable() {
        CacheControl.Builder builder = this;
        builder.immutable = true;
        return builder;
    }

    public final CacheControl.Builder maxAge(int n, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
        CacheControl.Builder builder = this;
        boolean bl = n >= 0;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"maxAge < 0: ", (Object)n).toString());
        builder.maxAgeSeconds = builder.clampToInt(timeUnit.toSeconds(n));
        return builder;
    }

    public final CacheControl.Builder maxStale(int n, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
        CacheControl.Builder builder = this;
        boolean bl = n >= 0;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"maxStale < 0: ", (Object)n).toString());
        builder.maxStaleSeconds = builder.clampToInt(timeUnit.toSeconds(n));
        return builder;
    }

    public final CacheControl.Builder minFresh(int n, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
        CacheControl.Builder builder = this;
        boolean bl = n >= 0;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"minFresh < 0: ", (Object)n).toString());
        builder.minFreshSeconds = builder.clampToInt(timeUnit.toSeconds(n));
        return builder;
    }

    public final CacheControl.Builder noCache() {
        CacheControl.Builder builder = this;
        builder.noCache = true;
        return builder;
    }

    public final CacheControl.Builder noStore() {
        CacheControl.Builder builder = this;
        builder.noStore = true;
        return builder;
    }

    public final CacheControl.Builder noTransform() {
        CacheControl.Builder builder = this;
        builder.noTransform = true;
        return builder;
    }

    public final CacheControl.Builder onlyIfCached() {
        CacheControl.Builder builder = this;
        builder.onlyIfCached = true;
        return builder;
    }
}
