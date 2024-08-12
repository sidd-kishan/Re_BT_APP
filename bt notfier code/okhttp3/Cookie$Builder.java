/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Cookie
 *  okhttp3.internal.HostnamesKt
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.internal.HostnamesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lokhttp3/Cookie$Builder;", "", "()V", "cookie", "Lokhttp3/Cookie;", "(Lokhttp3/Cookie;)V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", "build", "hostOnlyDomain", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Cookie.Builder {
    private String domain;
    private long expiresAt;
    private boolean hostOnly;
    private boolean httpOnly;
    private String name;
    private String path;
    private boolean persistent;
    private boolean secure;
    private String value;

    public Cookie.Builder() {
        this.expiresAt = 253402300799999L;
        this.path = "/";
    }

    public Cookie.Builder(Cookie cookie) {
        Intrinsics.checkNotNullParameter((Object)cookie, (String)"cookie");
        this.expiresAt = 253402300799999L;
        this.path = "/";
        this.name = cookie.name();
        this.value = cookie.value();
        this.expiresAt = cookie.expiresAt();
        this.domain = cookie.domain();
        this.path = cookie.path();
        this.secure = cookie.secure();
        this.httpOnly = cookie.httpOnly();
        this.persistent = cookie.persistent();
        this.hostOnly = cookie.hostOnly();
    }

    private final Cookie.Builder domain(String string, boolean bl) {
        Cookie.Builder builder = this;
        String string2 = HostnamesKt.toCanonicalHost((String)string);
        if (string2 == null) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"unexpected domain: ", (Object)string));
        builder.domain = string2;
        builder.hostOnly = bl;
        return builder;
    }

    public final Cookie build() {
        String string = this.name;
        if (string == null) throw new NullPointerException("builder.name == null");
        String string2 = this.value;
        if (string2 == null) throw new NullPointerException("builder.value == null");
        long l = this.expiresAt;
        String string3 = this.domain;
        if (string3 == null) throw new NullPointerException("builder.domain == null");
        return new Cookie(string, string2, l, string3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
    }

    public final Cookie.Builder domain(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"domain");
        return this.domain(string, false);
    }

    public final Cookie.Builder expiresAt(long l) {
        Cookie.Builder builder = this;
        long l2 = l;
        if (l <= 0L) {
            l2 = Long.MIN_VALUE;
        }
        l = l2;
        if (l2 > 253402300799999L) {
            l = 253402300799999L;
        }
        builder.expiresAt = l;
        builder.persistent = true;
        return builder;
    }

    public final Cookie.Builder hostOnlyDomain(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"domain");
        return this.domain(string, true);
    }

    public final Cookie.Builder httpOnly() {
        Cookie.Builder builder = this;
        builder.httpOnly = true;
        return builder;
    }

    public final Cookie.Builder name(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Cookie.Builder builder = this;
        if (!Intrinsics.areEqual((Object)((Object)StringsKt.trim((CharSequence)string)).toString(), (Object)string)) throw (Throwable)new IllegalArgumentException("name is not trimmed".toString());
        builder.name = string;
        return builder;
    }

    public final Cookie.Builder path(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"path");
        Cookie.Builder builder = this;
        if (!StringsKt.startsWith$default((String)string, (String)"/", (boolean)false, (int)2, null)) throw (Throwable)new IllegalArgumentException("path must start with '/'".toString());
        builder.path = string;
        return builder;
    }

    public final Cookie.Builder secure() {
        Cookie.Builder builder = this;
        builder.secure = true;
        return builder;
    }

    public final Cookie.Builder value(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        Cookie.Builder builder = this;
        if (!Intrinsics.areEqual((Object)((Object)StringsKt.trim((CharSequence)string)).toString(), (Object)string)) throw (Throwable)new IllegalArgumentException("value is not trimmed".toString());
        builder.value = string;
        return builder;
    }
}
