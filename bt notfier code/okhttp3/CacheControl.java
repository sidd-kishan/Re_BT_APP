/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CacheControl$Builder
 *  okhttp3.CacheControl$Companion
 *  okhttp3.Headers
 */
package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014\u00a8\u0006\""}, d2={"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class CacheControl {
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK;
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    static {
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }

    private CacheControl(boolean bl, boolean bl2, int n, int n2, boolean bl3, boolean bl4, boolean bl5, int n3, int n4, boolean bl6, boolean bl7, boolean bl8, String string) {
        this.noCache = bl;
        this.noStore = bl2;
        this.maxAgeSeconds = n;
        this.sMaxAgeSeconds = n2;
        this.isPrivate = bl3;
        this.isPublic = bl4;
        this.mustRevalidate = bl5;
        this.maxStaleSeconds = n3;
        this.minFreshSeconds = n4;
        this.onlyIfCached = bl6;
        this.noTransform = bl7;
        this.immutable = bl8;
        this.headerValue = string;
    }

    public /* synthetic */ CacheControl(boolean bl, boolean bl2, int n, int n2, boolean bl3, boolean bl4, boolean bl5, int n3, int n4, boolean bl6, boolean bl7, boolean bl8, String string, DefaultConstructorMarker defaultConstructorMarker) {
        this(bl, bl2, n, n2, bl3, bl4, bl5, n3, n4, bl6, bl7, bl8, string);
    }

    @JvmStatic
    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="immutable", imports={}))
    public final boolean _deprecated_immutable() {
        return this.immutable;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="maxAgeSeconds", imports={}))
    public final int _deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="maxStaleSeconds", imports={}))
    public final int _deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="minFreshSeconds", imports={}))
    public final int _deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="mustRevalidate", imports={}))
    public final boolean _deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="noCache", imports={}))
    public final boolean _deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="noStore", imports={}))
    public final boolean _deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="noTransform", imports={}))
    public final boolean _deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="onlyIfCached", imports={}))
    public final boolean _deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sMaxAgeSeconds", imports={}))
    public final int _deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String string = this.headerValue;
        CharSequence charSequence = string;
        if (string != null) return charSequence;
        charSequence = new StringBuilder();
        if (this.noCache()) {
            ((StringBuilder)charSequence).append("no-cache, ");
        }
        if (this.noStore()) {
            ((StringBuilder)charSequence).append("no-store, ");
        }
        if (this.maxAgeSeconds() != -1) {
            ((StringBuilder)charSequence).append("max-age=");
            ((StringBuilder)charSequence).append(this.maxAgeSeconds());
            ((StringBuilder)charSequence).append(", ");
        }
        if (this.sMaxAgeSeconds() != -1) {
            ((StringBuilder)charSequence).append("s-maxage=");
            ((StringBuilder)charSequence).append(this.sMaxAgeSeconds());
            ((StringBuilder)charSequence).append(", ");
        }
        if (this.isPrivate()) {
            ((StringBuilder)charSequence).append("private, ");
        }
        if (this.isPublic()) {
            ((StringBuilder)charSequence).append("public, ");
        }
        if (this.mustRevalidate()) {
            ((StringBuilder)charSequence).append("must-revalidate, ");
        }
        if (this.maxStaleSeconds() != -1) {
            ((StringBuilder)charSequence).append("max-stale=");
            ((StringBuilder)charSequence).append(this.maxStaleSeconds());
            ((StringBuilder)charSequence).append(", ");
        }
        if (this.minFreshSeconds() != -1) {
            ((StringBuilder)charSequence).append("min-fresh=");
            ((StringBuilder)charSequence).append(this.minFreshSeconds());
            ((StringBuilder)charSequence).append(", ");
        }
        if (this.onlyIfCached()) {
            ((StringBuilder)charSequence).append("only-if-cached, ");
        }
        if (this.noTransform()) {
            ((StringBuilder)charSequence).append("no-transform, ");
        }
        if (this.immutable()) {
            ((StringBuilder)charSequence).append("immutable, ");
        }
        if (((StringBuilder)charSequence).length() == 0) {
            return "";
        }
        ((StringBuilder)charSequence).delete(((StringBuilder)charSequence).length() - 2, ((StringBuilder)charSequence).length());
        charSequence = ((StringBuilder)charSequence).toString();
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
        this.headerValue = charSequence;
        return charSequence;
    }
}
