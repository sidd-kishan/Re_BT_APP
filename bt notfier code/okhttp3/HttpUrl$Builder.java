/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  okhttp3.HttpUrl
 *  okhttp3.HttpUrl$Builder$Companion
 *  okhttp3.HttpUrl$Companion
 *  okhttp3.internal.HostnamesKt
 *  okhttp3.internal.Util
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020\u0000H\u0000\u00a2\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b\u00a8\u0006W"}, d2={"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", "build", "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", "base", "parse$okhttp", "password", "pop", "", "push", "pos", "limit", "addTrailingSlash", "query", "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class HttpUrl.Builder {
    public static final Companion Companion = new Companion(null);
    public static final String INVALID_HOST = "Invalid URL host";
    private String encodedFragment;
    private String encodedPassword = "";
    private final List<String> encodedPathSegments;
    private List<String> encodedQueryNamesAndValues;
    private String encodedUsername = "";
    private String host;
    private int port = -1;
    private String scheme;

    public HttpUrl.Builder() {
        List list;
        this.encodedPathSegments = list = (List)new ArrayList();
        list.add("");
    }

    private final HttpUrl.Builder addPathSegments(String string, boolean bl) {
        int n;
        HttpUrl.Builder builder = this;
        int n2 = 0;
        do {
            boolean bl2 = (n = Util.delimiterOffset((String)string, (String)"/\\", (int)n2, (int)string.length())) < string.length();
            builder.push(string, n2, n, bl2, bl);
            n2 = ++n;
        } while (n <= string.length());
        return builder;
    }

    private final int effectivePort() {
        int n = this.port;
        if (n != -1) return n;
        HttpUrl.Companion companion = HttpUrl.Companion;
        String string = this.scheme;
        Intrinsics.checkNotNull((Object)string);
        n = companion.defaultPort(string);
        return n;
    }

    private final boolean isDot(String string) {
        boolean bl;
        boolean bl2 = Intrinsics.areEqual((Object)string, (Object)".");
        boolean bl3 = bl = true;
        if (bl2) return bl3;
        bl3 = StringsKt.equals((String)string, (String)"%2e", (boolean)true) ? bl : false;
        return bl3;
    }

    private final boolean isDotDot(String string) {
        boolean bl;
        boolean bl2 = Intrinsics.areEqual((Object)string, (Object)"..");
        boolean bl3 = bl = true;
        if (bl2) return bl3;
        bl3 = bl;
        if (StringsKt.equals((String)string, (String)"%2e.", (boolean)true)) return bl3;
        bl3 = bl;
        if (StringsKt.equals((String)string, (String)".%2e", (boolean)true)) return bl3;
        bl3 = StringsKt.equals((String)string, (String)"%2e%2e", (boolean)true) ? bl : false;
        return bl3;
    }

    private final void pop() {
        List<String> list = this.encodedPathSegments;
        boolean bl = ((CharSequence)list.remove(list.size() - 1)).length() == 0;
        if (bl && ((Collection)this.encodedPathSegments).isEmpty() ^ true) {
            list = this.encodedPathSegments;
            list.set(list.size() - 1, "");
        } else {
            this.encodedPathSegments.add("");
        }
    }

    private final void push(String string, int n, int n2, boolean bl, boolean bl2) {
        if (this.isDot(string = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)n, (int)n2, (String)" \"<>^`{}|/\\?#", (boolean)bl2, (boolean)false, (boolean)false, (boolean)false, null, (int)240, null))) {
            return;
        }
        if (this.isDotDot(string)) {
            this.pop();
            return;
        }
        List<String> list = this.encodedPathSegments;
        n = ((CharSequence)list.get(list.size() - 1)).length() == 0 ? 1 : 0;
        if (n != 0) {
            list = this.encodedPathSegments;
            list.set(list.size() - 1, string);
        } else {
            this.encodedPathSegments.add(string);
        }
        if (!bl) return;
        this.encodedPathSegments.add("");
    }

    private final void removeAllCanonicalQueryParameters(String string) {
        List<String> list = this.encodedQueryNamesAndValues;
        Intrinsics.checkNotNull(list);
        int n = list.size() - 2;
        int n2 = ProgressionUtilKt.getProgressionLastElement((int)n, (int)0, (int)-2);
        if (n2 > n) return;
        while (true) {
            list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            if (Intrinsics.areEqual((Object)string, (Object)list.get(n))) {
                list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                list.remove(n + 1);
                list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                list.remove(n);
                list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                if (list.isEmpty()) {
                    this.encodedQueryNamesAndValues = null;
                    return;
                }
            }
            if (n == n2) {
                return;
            }
            n -= 2;
        }
    }

    private final void resolvePath(String string, int n, int n2) {
        if (n == n2) {
            return;
        }
        int n3 = string.charAt(n);
        if (n3 != 47 && n3 != 92) {
            List<String> list = this.encodedPathSegments;
            list.set(list.size() - 1, "");
        } else {
            this.encodedPathSegments.clear();
            this.encodedPathSegments.add("");
            ++n;
        }
        while (n < n2) {
            n3 = Util.delimiterOffset((String)string, (String)"/\\", (int)n, (int)n2);
            boolean bl = n3 < n2;
            this.push(string, n, n3, bl, true);
            n = n3;
            if (!bl) continue;
            n = n3 + 1;
        }
    }

    public final HttpUrl.Builder addEncodedPathSegment(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedPathSegment");
        HttpUrl.Builder builder = this;
        builder.push(string, 0, string.length(), false, true);
        return builder;
    }

    public final HttpUrl.Builder addEncodedPathSegments(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedPathSegments");
        return this.addPathSegments(string, true);
    }

    public final HttpUrl.Builder addEncodedQueryParameter(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedName");
        HttpUrl.Builder builder = this;
        if (builder.getEncodedQueryNamesAndValues$okhttp() == null) {
            builder.setEncodedQueryNamesAndValues$okhttp(new ArrayList());
        }
        List<String> list = builder.getEncodedQueryNamesAndValues$okhttp();
        Intrinsics.checkNotNull(list);
        list.add(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"'<>#&=", (boolean)true, (boolean)false, (boolean)true, (boolean)false, null, (int)211, null));
        list = builder.getEncodedQueryNamesAndValues$okhttp();
        Intrinsics.checkNotNull(list);
        string = string2 == null ? null : HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string2, (int)0, (int)0, (String)" \"'<>#&=", (boolean)true, (boolean)false, (boolean)true, (boolean)false, null, (int)211, null);
        list.add(string);
        return builder;
    }

    public final HttpUrl.Builder addPathSegment(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"pathSegment");
        HttpUrl.Builder builder = this;
        builder.push(string, 0, string.length(), false, false);
        return builder;
    }

    public final HttpUrl.Builder addPathSegments(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"pathSegments");
        return this.addPathSegments(string, false);
    }

    public final HttpUrl.Builder addQueryParameter(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        HttpUrl.Builder builder = this;
        if (builder.getEncodedQueryNamesAndValues$okhttp() == null) {
            builder.setEncodedQueryNamesAndValues$okhttp(new ArrayList());
        }
        List<String> list = builder.getEncodedQueryNamesAndValues$okhttp();
        Intrinsics.checkNotNull(list);
        list.add(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" !\"#$&'(),/:;<=>?@[]\\^`{|}~", (boolean)false, (boolean)false, (boolean)true, (boolean)false, null, (int)219, null));
        list = builder.getEncodedQueryNamesAndValues$okhttp();
        Intrinsics.checkNotNull(list);
        string = string2 == null ? null : HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string2, (int)0, (int)0, (String)" !\"#$&'(),/:;<=>?@[]\\^`{|}~", (boolean)false, (boolean)false, (boolean)true, (boolean)false, null, (int)219, null);
        list.add(string);
        return builder;
    }

    public final HttpUrl build() {
        Object object;
        Object object2;
        String string = this.scheme;
        if (string == null) {
            IllegalStateException illegalStateException = new IllegalStateException("scheme == null");
            throw illegalStateException;
        }
        String string2 = HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)this.encodedUsername, (int)0, (int)0, (boolean)false, (int)7, null);
        String string3 = HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)this.encodedPassword, (int)0, (int)0, (boolean)false, (int)7, null);
        String string4 = this.host;
        if (string4 == null) throw new IllegalStateException("host == null");
        int n = this.effectivePort();
        Object object3 = this.encodedPathSegments;
        Object object4 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object3, (int)10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object2 = (String)object3.next();
            object4.add((String)HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)object2, (int)0, (int)0, (boolean)false, (int)7, null));
        }
        object2 = (List)object4;
        object4 = this.encodedQueryNamesAndValues;
        object3 = null;
        if (object4 == null) {
            object4 = null;
        } else {
            object4 = (Iterable)object4;
            object = new ArrayList(CollectionsKt.collectionSizeOrDefault(object4, (int)10));
            Iterator<String> iterator = object4.iterator();
            while (iterator.hasNext()) {
                object4 = iterator.next();
                object4 = object4 == null ? null : HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)object4, (int)0, (int)0, (boolean)true, (int)3, null);
                object.add(object4);
            }
            object4 = (List)object;
        }
        object = this.encodedFragment;
        if (object == null) return new HttpUrl(string, string2, string3, string4, n, (List)object2, object4, (String)object3, this.toString());
        object3 = HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)object, (int)0, (int)0, (boolean)false, (int)7, null);
        return new HttpUrl(string, string2, string3, string4, n, (List)object2, object4, (String)object3, this.toString());
    }

    public final HttpUrl.Builder encodedFragment(String string) {
        HttpUrl.Builder builder = this;
        string = string == null ? null : HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)"", (boolean)true, (boolean)false, (boolean)false, (boolean)true, null, (int)179, null);
        builder.setEncodedFragment$okhttp(string);
        return builder;
    }

    public final HttpUrl.Builder encodedPassword(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedPassword");
        HttpUrl.Builder builder = this;
        builder.setEncodedPassword$okhttp(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"':;<=>@[]^`{}|/\\?#", (boolean)true, (boolean)false, (boolean)false, (boolean)false, null, (int)243, null));
        return builder;
    }

    public final HttpUrl.Builder encodedPath(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedPath");
        HttpUrl.Builder builder = this;
        if (!StringsKt.startsWith$default((String)string, (String)"/", (boolean)false, (int)2, null)) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"unexpected encodedPath: ", (Object)string).toString());
        builder.resolvePath(string, 0, string.length());
        return builder;
    }

    public final HttpUrl.Builder encodedQuery(String object) {
        HttpUrl.Builder builder = this;
        if (object == null) {
            object = null;
        } else {
            object = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)object, (int)0, (int)0, (String)" \"'<>#", (boolean)true, (boolean)false, (boolean)true, (boolean)false, null, (int)211, null);
            object = HttpUrl.Companion.toQueryNamesAndValues$okhttp((String)object);
        }
        builder.setEncodedQueryNamesAndValues$okhttp((List<String>)object);
        return builder;
    }

    public final HttpUrl.Builder encodedUsername(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedUsername");
        HttpUrl.Builder builder = this;
        builder.setEncodedUsername$okhttp(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"':;<=>@[]^`{}|/\\?#", (boolean)true, (boolean)false, (boolean)false, (boolean)false, null, (int)243, null));
        return builder;
    }

    public final HttpUrl.Builder fragment(String string) {
        HttpUrl.Builder builder = this;
        string = string == null ? null : HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)"", (boolean)false, (boolean)false, (boolean)false, (boolean)true, null, (int)187, null);
        builder.setEncodedFragment$okhttp(string);
        return builder;
    }

    public final String getEncodedFragment$okhttp() {
        return this.encodedFragment;
    }

    public final String getEncodedPassword$okhttp() {
        return this.encodedPassword;
    }

    public final List<String> getEncodedPathSegments$okhttp() {
        return this.encodedPathSegments;
    }

    public final List<String> getEncodedQueryNamesAndValues$okhttp() {
        return this.encodedQueryNamesAndValues;
    }

    public final String getEncodedUsername$okhttp() {
        return this.encodedUsername;
    }

    public final String getHost$okhttp() {
        return this.host;
    }

    public final int getPort$okhttp() {
        return this.port;
    }

    public final String getScheme$okhttp() {
        return this.scheme;
    }

    public final HttpUrl.Builder host(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"host");
        HttpUrl.Builder builder = this;
        String string2 = HostnamesKt.toCanonicalHost((String)HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (boolean)false, (int)7, null));
        if (string2 == null) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"unexpected host: ", (Object)string));
        builder.setHost$okhttp(string2);
        return builder;
    }

    public final HttpUrl.Builder parse$okhttp(HttpUrl object, String charSequence) {
        int n;
        int n2;
        int n3;
        String string;
        block22: {
            Object object2;
            block21: {
                block20: {
                    block19: {
                        block18: {
                            string = charSequence;
                            Intrinsics.checkNotNullParameter((Object)string, (String)"input");
                            n3 = Util.indexOfFirstNonAsciiWhitespace$default((String)string, (int)0, (int)0, (int)3, null);
                            n2 = Util.indexOfLastNonAsciiWhitespace$default((String)string, (int)n3, (int)0, (int)2, null);
                            n = okhttp3.HttpUrl$Builder$Companion.access$schemeDelimiterOffset((Companion)Companion, (String)string, (int)n3, (int)n2);
                            object2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
                            if (n == -1) break block18;
                            if (StringsKt.startsWith((String)string, (String)"https:", (int)n3, (boolean)true)) {
                                this.scheme = "https";
                                n3 += 6;
                            } else {
                                if (!StringsKt.startsWith((String)string, (String)"http:", (int)n3, (boolean)true)) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("Expected URL scheme 'http' or 'https' but was '");
                                    charSequence = string.substring(0, n);
                                    Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                                    ((StringBuilder)object).append((String)charSequence);
                                    ((StringBuilder)object).append('\'');
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                this.scheme = "http";
                                n3 += 5;
                            }
                            break block19;
                        }
                        if (object == null) break block20;
                        this.scheme = object.scheme();
                    }
                    n = okhttp3.HttpUrl$Builder$Companion.access$slashCount((Companion)Companion, (String)string, (int)n3, (int)n2);
                    if (n >= 2 || object == null || !Intrinsics.areEqual((Object)object.scheme(), (Object)this.scheme)) break block21;
                    this.encodedUsername = object.encodedUsername();
                    this.encodedPassword = object.encodedPassword();
                    this.host = object.host();
                    this.port = object.port();
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.addAll(object.encodedPathSegments());
                    if (n3 == n2 || string.charAt(n3) == '#') {
                        this.encodedQuery(object.encodedQuery());
                    }
                    break block22;
                }
                object = string;
                if (((String)charSequence).length() > 6) {
                    object = Intrinsics.stringPlus((String)StringsKt.take((String)string, (int)6), (Object)"...");
                }
                object = new IllegalArgumentException(Intrinsics.stringPlus((String)"Expected URL scheme 'http' or 'https' but no scheme was found for ", (Object)object));
                throw object;
            }
            int n4 = n3 + n;
            n = 0;
            int n5 = 0;
            n3 = n2;
            object = object2;
            while (true) {
                String string2;
                int n6;
                int n7;
                if ((n7 = (n6 = Util.delimiterOffset((String)string, (String)"@/\\?#", (int)n4, (int)n3)) != n3 ? (int)string.charAt(n6) : -1) == 64) {
                    if (n == 0) {
                        n2 = Util.delimiterOffset((String)string, (char)':', (int)n4, (int)n6);
                        string2 = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)n4, (int)n2, (String)" \"':;<=>@[]^`{}|/\\?#", (boolean)true, (boolean)false, (boolean)false, (boolean)false, null, (int)240, null);
                        object2 = string2;
                        if (n5 != 0) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append(this.encodedUsername);
                            ((StringBuilder)object2).append("%40");
                            ((StringBuilder)object2).append(string2);
                            object2 = ((StringBuilder)object2).toString();
                        }
                        this.encodedUsername = object2;
                        if (n2 != n6) {
                            this.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)(n2 + 1), (int)n6, (String)" \"':;<=>@[]^`{}|/\\?#", (boolean)true, (boolean)false, (boolean)false, (boolean)false, null, (int)240, null);
                            n = 1;
                        }
                        n5 = 1;
                    } else {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(this.encodedPassword);
                        ((StringBuilder)object2).append("%40");
                        ((StringBuilder)object2).append(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)n4, (int)n6, (String)" \"':;<=>@[]^`{}|/\\?#", (boolean)true, (boolean)false, (boolean)false, (boolean)false, null, (int)240, null));
                        this.encodedPassword = ((StringBuilder)object2).toString();
                    }
                    n4 = n6 + 1;
                    n2 = n3;
                    object2 = object;
                    continue;
                }
                n2 = n3;
                boolean bl = n7 == -1 || n7 == 47;
                bl = bl || n7 == 92;
                n7 = (bl = bl || n7 == 63) ? 1 : (n7 == 35 ? 1 : 0);
                if (n7 != 0) {
                    n = okhttp3.HttpUrl$Builder$Companion.access$portColonOffset((Companion)Companion, (String)string, (int)n4, (int)n6);
                    n5 = n + 1;
                    if (n5 < n6) {
                        this.host = HostnamesKt.toCanonicalHost((String)HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)n4, (int)n, (boolean)false, (int)4, null));
                        this.port = n3 = okhttp3.HttpUrl$Builder$Companion.access$parsePort((Companion)Companion, (String)string, (int)n5, (int)n6);
                        if ((n3 = n3 != -1 ? 1 : 0) == 0) {
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append("Invalid URL port: \"");
                            string = string.substring(n5, n6);
                            Intrinsics.checkNotNullExpressionValue((Object)string, (String)object);
                            ((StringBuilder)charSequence).append(string);
                            ((StringBuilder)charSequence).append('\"');
                            throw (Throwable)new IllegalArgumentException(((StringBuilder)charSequence).toString().toString());
                        }
                    } else {
                        this.host = HostnamesKt.toCanonicalHost((String)HttpUrl.Companion.percentDecode$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)n4, (int)n, (boolean)false, (int)4, null));
                        object2 = HttpUrl.Companion;
                        string2 = this.scheme;
                        Intrinsics.checkNotNull((Object)string2);
                        this.port = object2.defaultPort(string2);
                    }
                    n3 = this.host != null ? 1 : 0;
                    if (n3 == 0) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Invalid URL host: \"");
                        string = string.substring(n4, n);
                        Intrinsics.checkNotNullExpressionValue((Object)string, (String)object);
                        ((StringBuilder)charSequence).append(string);
                        ((StringBuilder)charSequence).append('\"');
                        throw (Throwable)new IllegalArgumentException(((StringBuilder)charSequence).toString().toString());
                    }
                    n3 = n6;
                    break;
                }
                object2 = object;
            }
        }
        n = Util.delimiterOffset((String)string, (String)"?#", (int)n3, (int)n2);
        this.resolvePath(string, n3, n);
        n3 = n;
        if (n < n2) {
            n3 = n;
            if (string.charAt(n) == '?') {
                n3 = Util.delimiterOffset((String)string, (char)'#', (int)n, (int)n2);
                this.encodedQueryNamesAndValues = HttpUrl.Companion.toQueryNamesAndValues$okhttp(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)(n + 1), (int)n3, (String)" \"'<>#", (boolean)true, (boolean)false, (boolean)true, (boolean)false, null, (int)208, null));
            }
        }
        if (n3 >= n2) return this;
        if (string.charAt(n3) != '#') return this;
        this.encodedFragment = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)(n3 + 1), (int)n2, (String)"", (boolean)true, (boolean)false, (boolean)false, (boolean)true, null, (int)176, null);
        return this;
    }

    public final HttpUrl.Builder password(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"password");
        HttpUrl.Builder builder = this;
        builder.setEncodedPassword$okhttp(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"':;<=>@[]^`{}|/\\?#", (boolean)false, (boolean)false, (boolean)false, (boolean)false, null, (int)251, null));
        return builder;
    }

    public final HttpUrl.Builder port(int n) {
        boolean bl;
        HttpUrl.Builder builder = this;
        boolean bl2 = bl = false;
        if (1 <= n) {
            bl2 = bl;
            if (n <= 65535) {
                bl2 = true;
            }
        }
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"unexpected port: ", (Object)n).toString());
        builder.setPort$okhttp(n);
        return builder;
    }

    public final HttpUrl.Builder query(String object) {
        HttpUrl.Builder builder = this;
        if (object == null) {
            object = null;
        } else {
            object = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)object, (int)0, (int)0, (String)" \"'<>#", (boolean)false, (boolean)false, (boolean)true, (boolean)false, null, (int)219, null);
            object = HttpUrl.Companion.toQueryNamesAndValues$okhttp((String)object);
        }
        builder.setEncodedQueryNamesAndValues$okhttp((List<String>)object);
        return builder;
    }

    public final HttpUrl.Builder reencodeForUri$okhttp() {
        List<String> list;
        int n;
        int n2;
        HttpUrl.Builder builder = this;
        CharSequence charSequence = builder.getHost$okhttp();
        Object var6_3 = null;
        if (charSequence == null) {
            charSequence = null;
        } else {
            charSequence = charSequence;
            charSequence = new Regex("[\"<>^`{|}]").replace(charSequence, "");
        }
        builder.setHost$okhttp((String)charSequence);
        int n3 = builder.getEncodedPathSegments$okhttp().size();
        int n4 = 0;
        if (n3 > 0) {
            n2 = 0;
            while (true) {
                n = n2 + 1;
                builder.getEncodedPathSegments$okhttp().set(n2, HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)builder.getEncodedPathSegments$okhttp().get(n2), (int)0, (int)0, (String)"[]", (boolean)true, (boolean)true, (boolean)false, (boolean)false, null, (int)227, null));
                if (n >= n3) break;
                n2 = n;
            }
        }
        if ((list = builder.getEncodedQueryNamesAndValues$okhttp()) != null && (n = list.size()) > 0) {
            n2 = n4;
            while (true) {
                n4 = n2 + 1;
                charSequence = list.get(n2);
                charSequence = charSequence == null ? null : HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)0, (int)0, (String)"\\^`{|}", (boolean)true, (boolean)true, (boolean)true, (boolean)false, null, (int)195, null);
                list.set(n2, (String)charSequence);
                if (n4 >= n) break;
                n2 = n4;
            }
        }
        charSequence = (charSequence = builder.getEncodedFragment$okhttp()) == null ? var6_3 : HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)charSequence, (int)0, (int)0, (String)" \"#<>\\^`{|}", (boolean)true, (boolean)true, (boolean)false, (boolean)true, null, (int)163, null);
        builder.setEncodedFragment$okhttp((String)charSequence);
        return builder;
    }

    public final HttpUrl.Builder removeAllEncodedQueryParameters(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedName");
        HttpUrl.Builder builder = this;
        if (builder.getEncodedQueryNamesAndValues$okhttp() == null) {
            return builder;
        }
        builder.removeAllCanonicalQueryParameters(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"'<>#&=", (boolean)true, (boolean)false, (boolean)true, (boolean)false, null, (int)211, null));
        return builder;
    }

    public final HttpUrl.Builder removeAllQueryParameters(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        HttpUrl.Builder builder = this;
        if (builder.getEncodedQueryNamesAndValues$okhttp() == null) {
            return builder;
        }
        builder.removeAllCanonicalQueryParameters(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" !\"#$&'(),/:;<=>?@[]\\^`{|}~", (boolean)false, (boolean)false, (boolean)true, (boolean)false, null, (int)219, null));
        return builder;
    }

    public final HttpUrl.Builder removePathSegment(int n) {
        HttpUrl.Builder builder = this;
        builder.getEncodedPathSegments$okhttp().remove(n);
        if (!builder.getEncodedPathSegments$okhttp().isEmpty()) return builder;
        builder.getEncodedPathSegments$okhttp().add("");
        return builder;
    }

    public final HttpUrl.Builder scheme(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"scheme");
        HttpUrl.Builder builder = this;
        if (StringsKt.equals((String)string, (String)"http", (boolean)true)) {
            builder.setScheme$okhttp("http");
        } else {
            if (!StringsKt.equals((String)string, (String)"https", (boolean)true)) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"unexpected scheme: ", (Object)string));
            builder.setScheme$okhttp("https");
        }
        return builder;
    }

    public final void setEncodedFragment$okhttp(String string) {
        this.encodedFragment = string;
    }

    public final void setEncodedPassword$okhttp(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.encodedPassword = string;
    }

    public final HttpUrl.Builder setEncodedPathSegment(int n, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedPathSegment");
        HttpUrl.Builder builder = this;
        String string2 = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"<>^`{}|/\\?#", (boolean)true, (boolean)false, (boolean)false, (boolean)false, null, (int)243, null);
        builder.getEncodedPathSegments$okhttp().set(n, string2);
        n = !builder.isDot(string2) && !builder.isDotDot(string2) ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"unexpected path segment: ", (Object)string).toString());
        return builder;
    }

    public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
        this.encodedQueryNamesAndValues = list;
    }

    public final HttpUrl.Builder setEncodedQueryParameter(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"encodedName");
        HttpUrl.Builder builder = this;
        builder.removeAllEncodedQueryParameters(string);
        builder.addEncodedQueryParameter(string, string2);
        return builder;
    }

    public final void setEncodedUsername$okhttp(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.encodedUsername = string;
    }

    public final void setHost$okhttp(String string) {
        this.host = string;
    }

    public final HttpUrl.Builder setPathSegment(int n, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"pathSegment");
        HttpUrl.Builder builder = this;
        String string2 = HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"<>^`{}|/\\?#", (boolean)false, (boolean)false, (boolean)false, (boolean)false, null, (int)251, null);
        boolean bl = !builder.isDot(string2) && !builder.isDotDot(string2);
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"unexpected path segment: ", (Object)string).toString());
        builder.getEncodedPathSegments$okhttp().set(n, string2);
        return builder;
    }

    public final void setPort$okhttp(int n) {
        this.port = n;
    }

    public final HttpUrl.Builder setQueryParameter(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        HttpUrl.Builder builder = this;
        builder.removeAllQueryParameters(string);
        builder.addQueryParameter(string, string2);
        return builder;
    }

    public final void setScheme$okhttp(String string) {
        this.scheme = string;
    }

    public String toString() {
        Object object;
        String string;
        CharSequence charSequence;
        block12: {
            int n;
            block13: {
                charSequence = new StringBuilder();
                if (this.getScheme$okhttp() != null) {
                    ((StringBuilder)charSequence).append(this.getScheme$okhttp());
                    ((StringBuilder)charSequence).append("://");
                } else {
                    ((StringBuilder)charSequence).append("//");
                }
                n = ((CharSequence)this.getEncodedUsername$okhttp()).length();
                int n2 = 1;
                n = n > 0 ? 1 : 0;
                if (n != 0 || (n = ((CharSequence)this.getEncodedPassword$okhttp()).length() > 0 ? 1 : 0) != 0) {
                    ((StringBuilder)charSequence).append(this.getEncodedUsername$okhttp());
                    n = ((CharSequence)this.getEncodedPassword$okhttp()).length() > 0 ? n2 : 0;
                    if (n != 0) {
                        ((StringBuilder)charSequence).append(':');
                        ((StringBuilder)charSequence).append(this.getEncodedPassword$okhttp());
                    }
                    ((StringBuilder)charSequence).append('@');
                }
                if (this.getHost$okhttp() != null) {
                    string = this.getHost$okhttp();
                    Intrinsics.checkNotNull((Object)string);
                    if (StringsKt.contains$default((CharSequence)string, (char)':', (boolean)false, (int)2, null)) {
                        ((StringBuilder)charSequence).append('[');
                        ((StringBuilder)charSequence).append(this.getHost$okhttp());
                        ((StringBuilder)charSequence).append(']');
                    } else {
                        ((StringBuilder)charSequence).append(this.getHost$okhttp());
                    }
                }
                if (this.getPort$okhttp() == -1 && this.getScheme$okhttp() == null) break block12;
                n = this.effectivePort();
                if (this.getScheme$okhttp() == null) break block13;
                string = HttpUrl.Companion;
                object = this.getScheme$okhttp();
                Intrinsics.checkNotNull((Object)object);
                if (n == string.defaultPort((String)object)) break block12;
            }
            ((StringBuilder)charSequence).append(':');
            ((StringBuilder)charSequence).append(n);
        }
        HttpUrl.Companion.toPathString$okhttp(this.getEncodedPathSegments$okhttp(), (StringBuilder)charSequence);
        if (this.getEncodedQueryNamesAndValues$okhttp() != null) {
            ((StringBuilder)charSequence).append('?');
            string = HttpUrl.Companion;
            object = this.getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull((Object)object);
            string.toQueryString$okhttp((List)object, (StringBuilder)charSequence);
        }
        if (this.getEncodedFragment$okhttp() != null) {
            ((StringBuilder)charSequence).append('#');
            ((StringBuilder)charSequence).append(this.getEncodedFragment$okhttp());
        }
        charSequence = ((StringBuilder)charSequence).toString();
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }

    public final HttpUrl.Builder username(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"username");
        HttpUrl.Builder builder = this;
        builder.setEncodedUsername$okhttp(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" \"':;<=>@[]^`{}|/\\?#", (boolean)false, (boolean)false, (boolean)false, (boolean)false, null, (int)251, null));
        return builder;
    }
}
