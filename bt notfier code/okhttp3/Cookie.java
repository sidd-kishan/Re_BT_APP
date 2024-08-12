/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  $r8$backportedMethods$utility$Boolean$1$hashCode
 *  $r8$backportedMethods$utility$Long$1$hashCode
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Cookie$Builder
 *  okhttp3.Cookie$Companion
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.internal.http.DatesKt
 */
package okhttp3;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.http.DatesKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0002'(BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\r\u0010\b\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b J\r\u0010\f\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b!J\r\u0010\t\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\"J\b\u0010#\u001a\u00020\u0003H\u0016J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\nH\u0000\u00a2\u0006\u0002\b%J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b&R\u0013\u0010\u0007\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f\u00a8\u0006)"}, d2={"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "newBuilder", "Lokhttp3/Cookie$Builder;", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Cookie {
    public static final Companion Companion = new Companion(null);
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    private static final Pattern YEAR_PATTERN;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    static {
        YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private Cookie(String string, String string2, long l, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.name = string;
        this.value = string2;
        this.expiresAt = l;
        this.domain = string3;
        this.path = string4;
        this.secure = bl;
        this.httpOnly = bl2;
        this.persistent = bl3;
        this.hostOnly = bl4;
    }

    public /* synthetic */ Cookie(String string, String string2, long l, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4, DefaultConstructorMarker defaultConstructorMarker) {
        this(string, string2, l, string3, string4, bl, bl2, bl3, bl4);
    }

    public static final /* synthetic */ Pattern access$getDAY_OF_MONTH_PATTERN$cp() {
        return DAY_OF_MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getMONTH_PATTERN$cp() {
        return MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getTIME_PATTERN$cp() {
        return TIME_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getYEAR_PATTERN$cp() {
        return YEAR_PATTERN;
    }

    @JvmStatic
    public static final Cookie parse(HttpUrl httpUrl, String string) {
        return Companion.parse(httpUrl, string);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="domain", imports={}))
    public final String _deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="expiresAt", imports={}))
    public final long _deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="hostOnly", imports={}))
    public final boolean _deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="httpOnly", imports={}))
    public final boolean _deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="name", imports={}))
    public final String _deprecated_name() {
        return this.name;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="path", imports={}))
    public final String _deprecated_path() {
        return this.path;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="persistent", imports={}))
    public final boolean _deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="secure", imports={}))
    public final boolean _deprecated_secure() {
        return this.secure;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="value", imports={}))
    public final String _deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof Cookie)) return false;
        object = (Cookie)object;
        if (!Intrinsics.areEqual((Object)((Cookie)object).name, (Object)this.name)) return false;
        if (!Intrinsics.areEqual((Object)((Cookie)object).value, (Object)this.value)) return false;
        if (((Cookie)object).expiresAt != this.expiresAt) return false;
        if (!Intrinsics.areEqual((Object)((Cookie)object).domain, (Object)this.domain)) return false;
        if (!Intrinsics.areEqual((Object)((Cookie)object).path, (Object)this.path)) return false;
        if (((Cookie)object).secure != this.secure) return false;
        if (((Cookie)object).httpOnly != this.httpOnly) return false;
        if (((Cookie)object).persistent != this.persistent) return false;
        if (((Cookie)object).hostOnly != this.hostOnly) return false;
        return true;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        return ((((((((527 + this.name.hashCode()) * 31 + this.value.hashCode()) * 31 + .r8.backportedMethods.utility.Long.1.hashCode.hashCode((long)this.expiresAt)) * 31 + this.domain.hashCode()) * 31 + this.path.hashCode()) * 31 + .r8.backportedMethods.utility.Boolean.1.hashCode.hashCode((boolean)this.secure)) * 31 + .r8.backportedMethods.utility.Boolean.1.hashCode.hashCode((boolean)this.httpOnly)) * 31 + .r8.backportedMethods.utility.Boolean.1.hashCode.hashCode((boolean)this.persistent)) * 31 + .r8.backportedMethods.utility.Boolean.1.hashCode.hashCode((boolean)this.hostOnly);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        boolean bl = this.hostOnly ? Intrinsics.areEqual((Object)httpUrl.host(), (Object)this.domain) : okhttp3.Cookie$Companion.access$domainMatch((Companion)Companion, (String)httpUrl.host(), (String)this.domain);
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if (!okhttp3.Cookie$Companion.access$pathMatch((Companion)Companion, (HttpUrl)httpUrl, (String)this.path)) {
            return false;
        }
        if (this.secure) {
            bl = bl2;
            if (!httpUrl.isHttps()) return bl;
        }
        bl = true;
        return bl;
    }

    public final String name() {
        return this.name;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return this.toString$okhttp(false);
    }

    public final String toString$okhttp(boolean bl) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append(this.name());
        charSequence.append('=');
        charSequence.append(this.value());
        if (this.persistent()) {
            if (this.expiresAt() == Long.MIN_VALUE) {
                charSequence.append("; max-age=0");
            } else {
                charSequence.append("; expires=");
                charSequence.append(DatesKt.toHttpDateString((Date)new Date(this.expiresAt())));
            }
        }
        if (!this.hostOnly()) {
            charSequence.append("; domain=");
            if (bl) {
                charSequence.append(".");
            }
            charSequence.append(this.domain());
        }
        charSequence.append("; path=");
        charSequence.append(this.path());
        if (this.secure()) {
            charSequence.append("; secure");
        }
        if (this.httpOnly()) {
            charSequence.append("; httponly");
        }
        charSequence = charSequence.toString();
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"toString()");
        return charSequence;
    }

    public final String value() {
        return this.value;
    }
}
