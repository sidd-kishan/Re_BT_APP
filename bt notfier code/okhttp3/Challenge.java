/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\bJ\u001b\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0007\u00a2\u0006\u0002\b\u000eJ\r\u0010\n\u001a\u00020\u000bH\u0007\u00a2\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b\u0015J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR!\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u00078G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r\u00a8\u0006\u0019"}, d2={"Lokhttp3/Challenge;", "", "scheme", "", "realm", "(Ljava/lang/String;Ljava/lang/String;)V", "authParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "()Ljava/util/Map;", "charset", "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", "()Ljava/lang/String;", "-deprecated_authParams", "-deprecated_charset", "equals", "", "other", "hashCode", "", "-deprecated_realm", "-deprecated_scheme", "toString", "withCharset", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String string, String object) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"scheme");
        Intrinsics.checkNotNullParameter((Object)object, (String)"realm");
        object = Collections.singletonMap("realm", object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"singletonMap(\"realm\", realm)");
        this(string, (Map<String, String>)object);
    }

    public Challenge(String object, Map<String, String> object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"scheme");
        Intrinsics.checkNotNullParameter(object2, (String)"authParams");
        this.scheme = object;
        Map map = new LinkedHashMap();
        object2 = object2.entrySet().iterator();
        while (true) {
            if (!object2.hasNext()) {
                object = Collections.unmodifiableMap(map);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"unmodifiableMap<String?, String>(newAuthParams)");
                this.authParams = object;
                return;
            }
            Object object3 = (Map.Entry)object2.next();
            object = (String)object3.getKey();
            object3 = (String)object3.getValue();
            if (object == null) {
                object = null;
            } else {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
                object = ((String)object).toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).toLowerCase(locale)");
            }
            map.put(object, object3);
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="authParams", imports={}))
    public final Map<String, String> _deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="charset", imports={}))
    public final Charset _deprecated_charset() {
        return this.charset();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="realm", imports={}))
    public final String _deprecated_realm() {
        return this.realm();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="scheme", imports={}))
    public final String _deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        Object object = this.authParams.get("charset");
        if (object != null) {
            try {
                object = Charset.forName((String)object);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"forName(charset)");
                return object;
            }
            catch (Exception exception) {}
        }
        object = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"ISO_8859_1");
        return object;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof Challenge)) return false;
        object = (Challenge)object;
        if (!Intrinsics.areEqual((Object)((Challenge)object).scheme, (Object)this.scheme)) return false;
        if (!Intrinsics.areEqual(((Challenge)object).authParams, this.authParams)) return false;
        return true;
    }

    public int hashCode() {
        return (899 + this.scheme.hashCode()) * 31 + ((Object)this.authParams).hashCode();
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.scheme);
        stringBuilder.append(" authParams=");
        stringBuilder.append(this.authParams);
        return stringBuilder.toString();
    }

    public final Challenge withCharset(Charset object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"charset");
        Map map = MapsKt.toMutableMap(this.authParams);
        object = ((Charset)object).name();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"charset.name()");
        map.put("charset", object);
        return new Challenge(this.scheme, map);
    }
}
