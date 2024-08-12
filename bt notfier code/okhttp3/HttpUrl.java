/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntProgression
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  okhttp3.HttpUrl$Builder
 *  okhttp3.HttpUrl$Companion
 *  okhttp3.internal.Util
 *  okhttp3.internal.publicsuffix.PublicSuffixDatabase
 */
package okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00a2\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00a2\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007\u00a2\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007\u00a2\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007\u00a2\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007\u00a2\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007\u00a2\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007\u00a2\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010\u00a8\u0006K"}, d2={"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class HttpUrl {
    public static final Companion Companion = new Companion(null);
    public static final String FORM_ENCODE_SET = " !\"#$&'()+,/:;<=>?@[\\]^`{|}~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    public HttpUrl(String string, String string2, String string3, String string4, int n, List<String> list, List<String> list2, String string5, String string6) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"scheme");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"username");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"password");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"host");
        Intrinsics.checkNotNullParameter(list, (String)"pathSegments");
        Intrinsics.checkNotNullParameter((Object)string6, (String)"url");
        this.scheme = string;
        this.username = string2;
        this.password = string3;
        this.host = string4;
        this.port = n;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = string5;
        this.url = string6;
        this.isHttps = Intrinsics.areEqual((Object)string, (Object)"https");
    }

    public static final /* synthetic */ char[] access$getHEX_DIGITS$cp() {
        return HEX_DIGITS;
    }

    @JvmStatic
    public static final int defaultPort(String string) {
        return Companion.defaultPort(string);
    }

    @JvmStatic
    public static final HttpUrl get(String string) {
        return Companion.get(string);
    }

    @JvmStatic
    public static final HttpUrl get(URI uRI) {
        return Companion.get(uRI);
    }

    @JvmStatic
    public static final HttpUrl get(URL uRL) {
        return Companion.get(uRL);
    }

    @JvmStatic
    public static final HttpUrl parse(String string) {
        return Companion.parse(string);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedFragment", imports={}))
    public final String _deprecated_encodedFragment() {
        return this.encodedFragment();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedPassword", imports={}))
    public final String _deprecated_encodedPassword() {
        return this.encodedPassword();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedPath", imports={}))
    public final String _deprecated_encodedPath() {
        return this.encodedPath();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedPathSegments", imports={}))
    public final List<String> _deprecated_encodedPathSegments() {
        return this.encodedPathSegments();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedQuery", imports={}))
    public final String _deprecated_encodedQuery() {
        return this.encodedQuery();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedUsername", imports={}))
    public final String _deprecated_encodedUsername() {
        return this.encodedUsername();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="fragment", imports={}))
    public final String _deprecated_fragment() {
        return this.fragment;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="host", imports={}))
    public final String _deprecated_host() {
        return this.host;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="password", imports={}))
    public final String _deprecated_password() {
        return this.password;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="pathSegments", imports={}))
    public final List<String> _deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="pathSize", imports={}))
    public final int _deprecated_pathSize() {
        return this.pathSize();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="port", imports={}))
    public final int _deprecated_port() {
        return this.port;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="query", imports={}))
    public final String _deprecated_query() {
        return this.query();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="queryParameterNames", imports={}))
    public final Set<String> _deprecated_queryParameterNames() {
        return this.queryParameterNames();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="querySize", imports={}))
    public final int _deprecated_querySize() {
        return this.querySize();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="scheme", imports={}))
    public final String _deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to toUri()", replaceWith=@ReplaceWith(expression="toUri()", imports={}))
    public final URI _deprecated_uri() {
        return this.uri();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to toUrl()", replaceWith=@ReplaceWith(expression="toUrl()", imports={}))
    public final URL _deprecated_url() {
        return this.url();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="username", imports={}))
    public final String _deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int n = StringsKt.indexOf$default((CharSequence)this.url, (char)'#', (int)0, (boolean)false, (int)6, null);
        String string = this.url;
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(n + 1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        return string;
    }

    public final String encodedPassword() {
        int n = ((CharSequence)this.password).length() == 0 ? 1 : 0;
        if (n != 0) {
            return FRAGMENT_ENCODE_SET;
        }
        n = StringsKt.indexOf$default((CharSequence)this.url, (char)':', (int)(this.scheme.length() + 3), (boolean)false, (int)4, null);
        int n2 = StringsKt.indexOf$default((CharSequence)this.url, (char)'@', (int)0, (boolean)false, (int)6, null);
        String string = this.url;
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(n + 1, n2);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final String encodedPath() {
        int n = StringsKt.indexOf$default((CharSequence)this.url, (char)'/', (int)(this.scheme.length() + 3), (boolean)false, (int)4, null);
        String string = this.url;
        int n2 = Util.delimiterOffset((String)string, (String)"?#", (int)n, (int)string.length());
        string = this.url;
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final List<String> encodedPathSegments() {
        int n = StringsKt.indexOf$default((CharSequence)this.url, (char)'/', (int)(this.scheme.length() + 3), (boolean)false, (int)4, null);
        Object object = this.url;
        int n2 = Util.delimiterOffset((String)object, (String)"?#", (int)n, (int)((String)object).length());
        object = new ArrayList();
        while (n < n2) {
            int n3 = n + 1;
            n = Util.delimiterOffset((String)this.url, (char)'/', (int)n3, (int)n2);
            String string = this.url;
            if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            string = string.substring(n3, n);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            object.add(string);
        }
        return object;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int n = StringsKt.indexOf$default((CharSequence)this.url, (char)'?', (int)0, (boolean)false, (int)6, null) + 1;
        String string = this.url;
        int n2 = Util.delimiterOffset((String)string, (char)'#', (int)n, (int)string.length());
        string = this.url;
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final String encodedUsername() {
        int n = ((CharSequence)this.username).length() == 0 ? 1 : 0;
        if (n != 0) {
            return FRAGMENT_ENCODE_SET;
        }
        n = this.scheme.length() + 3;
        String string = this.url;
        int n2 = Util.delimiterOffset((String)string, (String)":@", (int)n, (int)string.length());
        string = this.url;
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof HttpUrl && Intrinsics.areEqual((Object)((HttpUrl)object).url, (Object)this.url);
        return bl;
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(this.encodedUsername());
        builder.setEncodedPassword$okhttp(this.encodedPassword());
        builder.setHost$okhttp(this.host);
        int n = this.port != Companion.defaultPort(this.scheme) ? this.port : -1;
        builder.setPort$okhttp(n);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll((Collection)this.encodedPathSegments());
        builder.encodedQuery(this.encodedQuery());
        builder.setEncodedFragment$okhttp(this.encodedFragment());
        return builder;
    }

    public final Builder newBuilder(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"link");
        try {
            Builder builder = new Builder();
            string = builder.parse$okhttp(this, string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = null;
        }
        return string;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, stringBuilder);
        return stringBuilder.toString();
    }

    public final String queryParameter(String string) {
        int n;
        int n2;
        int n3;
        block8: {
            int n4;
            block7: {
                Intrinsics.checkNotNullParameter((Object)string, (String)"name");
                IntProgression intProgression = this.queryNamesAndValues;
                if (intProgression == null) {
                    return null;
                }
                intProgression = RangesKt.step((IntProgression)((IntProgression)RangesKt.until((int)0, (int)intProgression.size())), (int)2);
                n4 = intProgression.getFirst();
                n3 = intProgression.getLast();
                n2 = intProgression.getStep();
                if (n2 <= 0) break block7;
                n = n4;
                if (n4 <= n3) break block8;
            }
            if (n2 >= 0) return null;
            if (n3 > n4) return null;
            n = n4;
        }
        while (!Intrinsics.areEqual((Object)string, (Object)this.queryNamesAndValues.get(n))) {
            if (n == n3) {
                return null;
            }
            n += n2;
        }
        return this.queryNamesAndValues.get(n + 1);
    }

    public final String queryParameterName(int n) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) throw new IndexOutOfBoundsException();
        list = list.get(n * 2);
        Intrinsics.checkNotNull((Object)list);
        return (String)((Object)list);
    }

    public final Set<String> queryParameterNames() {
        LinkedHashSet<String> linkedHashSet;
        block7: {
            int n;
            int n2;
            int n3;
            Object object;
            block6: {
                int n4;
                block5: {
                    if (this.queryNamesAndValues == null) {
                        return SetsKt.emptySet();
                    }
                    linkedHashSet = new LinkedHashSet();
                    object = RangesKt.step((IntProgression)((IntProgression)RangesKt.until((int)0, (int)this.queryNamesAndValues.size())), (int)2);
                    n4 = object.getFirst();
                    n3 = object.getLast();
                    n2 = object.getStep();
                    if (n2 <= 0) break block5;
                    n = n4;
                    if (n4 <= n3) break block6;
                }
                if (n2 >= 0 || n3 > n4) break block7;
                n = n4;
            }
            while (true) {
                object = this.queryNamesAndValues.get(n);
                Intrinsics.checkNotNull((Object)object);
                linkedHashSet.add((String)object);
                if (n == n3) break;
                n += n2;
            }
        }
        linkedHashSet = Collections.unmodifiableSet((Set)linkedHashSet);
        Intrinsics.checkNotNullExpressionValue(linkedHashSet, (String)"unmodifiableSet(result)");
        return linkedHashSet;
    }

    public final String queryParameterValue(int n) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) throw new IndexOutOfBoundsException();
        return list.get(n * 2 + 1);
    }

    public final List<String> queryParameterValues(String object) {
        List list;
        block8: {
            int n;
            int n2;
            int n3;
            block7: {
                int n4;
                block6: {
                    Intrinsics.checkNotNullParameter((Object)object, (String)"name");
                    if (this.queryNamesAndValues == null) {
                        return CollectionsKt.emptyList();
                    }
                    list = new ArrayList();
                    IntProgression intProgression = RangesKt.step((IntProgression)((IntProgression)RangesKt.until((int)0, (int)this.queryNamesAndValues.size())), (int)2);
                    n4 = intProgression.getFirst();
                    n3 = intProgression.getLast();
                    n2 = intProgression.getStep();
                    if (n2 <= 0) break block6;
                    n = n4;
                    if (n4 <= n3) break block7;
                }
                if (n2 >= 0 || n3 > n4) break block8;
                n = n4;
            }
            while (true) {
                if (Intrinsics.areEqual((Object)object, (Object)this.queryNamesAndValues.get(n))) {
                    list.add(this.queryNamesAndValues.get(n + 1));
                }
                if (n == n3) break;
                n += n2;
            }
        }
        object = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"unmodifiableList(result)");
        return object;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        int n = list != null ? list.size() / 2 : 0;
        return n;
    }

    public final String redact() {
        Builder builder = this.newBuilder("/...");
        Intrinsics.checkNotNull((Object)builder);
        return builder.username(FRAGMENT_ENCODE_SET).password(FRAGMENT_ENCODE_SET).build().toString();
    }

    public final HttpUrl resolve(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"link");
        object = this.newBuilder((String)object);
        object = object == null ? null : object.build();
        return object;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        String string = Util.canParseAsIpAddress((String)this.host) ? (String)null : PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
        return string;
    }

    public final URI uri() {
        URI uRI;
        CharSequence charSequence = this.newBuilder().reencodeForUri$okhttp().toString();
        try {
            uRI = new URI((String)charSequence);
        }
        catch (URISyntaxException uRISyntaxException) {
            try {
                charSequence = charSequence;
                uRI = new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                uRI = URI.create(uRI.replace(charSequence, FRAGMENT_ENCODE_SET));
            }
            catch (Exception exception) {
                throw new RuntimeException(uRISyntaxException);
            }
            Intrinsics.checkNotNullExpressionValue((Object)uRI, (String)"{\n      // Unlikely edge\u2026Unexpected!\n      }\n    }");
        }
        return uRI;
    }

    public final URL url() {
        try {
            URL uRL = new URL(this.url);
            return uRL;
        }
        catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }

    public final String username() {
        return this.username;
    }
}
