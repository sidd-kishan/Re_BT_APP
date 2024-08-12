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
 *  kotlin.ranges.IntProgression
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  okhttp3.HttpUrl
 *  okhttp3.HttpUrl$Builder
 *  okhttp3.internal.Util
 *  okio.Buffer
 */
package okhttp3;

import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a2\u0006\u0002\b\u0018J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u00a2\u0006\u0002\b\u0018J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u001cJa\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000\u00a2\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\"*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J/\u0010*\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\"H\u0000\u00a2\u0006\u0002\b+J\u0011\u0010,\u001a\u00020\u0015*\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u001aH\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u001bJ#\u0010.\u001a\u00020/*\b\u0012\u0004\u0012\u00020\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000\u00a2\u0006\u0002\b4J\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000406*\u00020\u0004H\u0000\u00a2\u0006\u0002\b7J%\u00108\u001a\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000\u00a2\u0006\u0002\b9JV\u0010:\u001a\u00020/*\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J,\u0010=\u001a\u00020/*\u00020;2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2={"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", "scheme", "get", "Lokhttp3/HttpUrl;", "uri", "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", "pos", "limit", "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class HttpUrl.Companion {
    private HttpUrl.Companion() {
    }

    public /* synthetic */ HttpUrl.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String canonicalize$okhttp$default(HttpUrl.Companion companion, String string, int n, int n2, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        if ((n3 & 8) != 0) {
            bl = false;
        }
        if ((n3 & 0x10) != 0) {
            bl2 = false;
        }
        if ((n3 & 0x20) != 0) {
            bl3 = false;
        }
        if ((n3 & 0x40) != 0) {
            bl4 = false;
        }
        if ((n3 & 0x80) == 0) return companion.canonicalize$okhttp(string, n, n2, string2, bl, bl2, bl3, bl4, charset);
        charset = null;
        return companion.canonicalize$okhttp(string, n, n2, string2, bl, bl2, bl3, bl4, charset);
    }

    private final boolean isPercentEncoded(String string, int n, int n2) {
        int n3 = n + 2;
        boolean bl = true;
        if (n3 < n2 && string.charAt(n) == '%' && Util.parseHexDigit((char)string.charAt(n + 1)) != -1 && Util.parseHexDigit((char)string.charAt(n3)) != -1) return bl;
        bl = false;
        return bl;
    }

    public static /* synthetic */ String percentDecode$okhttp$default(HttpUrl.Companion companion, String string, int n, int n2, boolean bl, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        if ((n3 & 4) == 0) return companion.percentDecode$okhttp(string, n, n2, bl);
        bl = false;
        return companion.percentDecode$okhttp(string, n, n2, bl);
    }

    private final void writeCanonicalized(Buffer buffer, String string, int n, int n2, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset) {
        String string3 = null;
        while (n < n2) {
            if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            int n3 = string.codePointAt(n);
            if (!bl || n3 != 9 && n3 != 10 && n3 != 12 && n3 != 13) {
                String string4 = "+";
                if (n3 == 32 && string2 == " !\"#$&'()+,/:;<=>?@[\\]^`{|}~") {
                    buffer.writeUtf8("+");
                } else if (n3 == 43 && bl3) {
                    if (!bl) {
                        string4 = "%2B";
                    }
                    buffer.writeUtf8(string4);
                } else if (!(n3 < 32 || n3 == 127 || n3 >= 128 && !bl4 || StringsKt.contains$default((CharSequence)string2, (char)((char)n3), (boolean)false, (int)2, null) || n3 == 37 && (!bl || bl2 && !this.isPercentEncoded(string, n, n2)))) {
                    buffer.writeUtf8CodePoint(n3);
                } else {
                    string4 = string3;
                    if (string3 == null) {
                        string4 = new Buffer();
                    }
                    if (charset != null && !Intrinsics.areEqual((Object)charset, (Object)StandardCharsets.UTF_8)) {
                        string4.writeString(string, n, Character.charCount(n3) + n, charset);
                    } else {
                        string4.writeUtf8CodePoint(n3);
                    }
                    while (true) {
                        string3 = string4;
                        if (string4.exhausted()) break;
                        int n4 = string4.readByte() & 0xFF;
                        buffer.writeByte(37);
                        buffer.writeByte((int)HttpUrl.access$getHEX_DIGITS$cp()[n4 >> 4 & 0xF]);
                        buffer.writeByte((int)HttpUrl.access$getHEX_DIGITS$cp()[n4 & 0xF]);
                    }
                }
            }
            n += Character.charCount(n3);
        }
    }

    private final void writePercentDecoded(Buffer buffer, String string, int n, int n2, boolean bl) {
        while (n < n2) {
            int n3;
            if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            int n4 = string.codePointAt(n);
            if (n4 == 37 && (n3 = n + 2) < n2) {
                int n5 = Util.parseHexDigit((char)string.charAt(n + 1));
                int n6 = Util.parseHexDigit((char)string.charAt(n3));
                if (n5 != -1 && n6 != -1) {
                    buffer.writeByte((n5 << 4) + n6);
                    n = Character.charCount(n4) + n3;
                    continue;
                }
            } else if (n4 == 43 && bl) {
                buffer.writeByte(32);
                ++n;
                continue;
            }
            buffer.writeUtf8CodePoint(n4);
            n += Character.charCount(n4);
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrl()", imports={"okhttp3.HttpUrl.Companion.toHttpUrl"}))
    public final HttpUrl _deprecated_get(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"url");
        return this.get(string);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="uri.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
    public final HttpUrl _deprecated_get(URI uRI) {
        Intrinsics.checkNotNullParameter((Object)uRI, (String)"uri");
        return this.get(uRI);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
    public final HttpUrl _deprecated_get(URL uRL) {
        Intrinsics.checkNotNullParameter((Object)uRL, (String)"url");
        return this.get(uRL);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
    public final HttpUrl _deprecated_parse(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"url");
        return this.parse(string);
    }

    public final String canonicalize$okhttp(String string, int n, int n2, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"encodeSet");
        int n3 = n;
        while (true) {
            if (n3 >= n2) {
                string = string.substring(n, n2);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                return string;
            }
            int n4 = string.codePointAt(n3);
            if (n4 < 32 || n4 == 127 || n4 >= 128 && !bl4 || StringsKt.contains$default((CharSequence)string2, (char)((char)n4), (boolean)false, (int)2, null) || n4 == 37 && (!bl || bl2 && !this.isPercentEncoded(string, n3, n2)) || n4 == 43 && bl3) break;
            n3 += Character.charCount(n4);
        }
        Buffer buffer = new Buffer();
        buffer.writeUtf8(string, n, n3);
        this.writeCanonicalized(buffer, string, n3, n2, string2, bl, bl2, bl3, bl4, charset);
        return buffer.readUtf8();
    }

    @JvmStatic
    public final int defaultPort(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"scheme");
        int n = Intrinsics.areEqual((Object)string, (Object)"http") ? 80 : (Intrinsics.areEqual((Object)string, (Object)"https") ? 443 : -1);
        return n;
    }

    @JvmStatic
    public final HttpUrl get(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        return new HttpUrl.Builder().parse$okhttp(null, string).build();
    }

    @JvmStatic
    public final HttpUrl get(URI object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = ((URI)object).toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"toString()");
        return this.parse((String)object);
    }

    @JvmStatic
    public final HttpUrl get(URL object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = ((URL)object).toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"toString()");
        return this.parse((String)object);
    }

    @JvmStatic
    public final HttpUrl parse(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        try {
            string = this.get(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = null;
        }
        return string;
    }

    public final String percentDecode$okhttp(String string, int n, int n2, boolean bl) {
        block3: {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
            if (n < n2) {
                int n3 = n;
                while (true) {
                    int n4 = n3 + 1;
                    char c = string.charAt(n3);
                    if (c == '%' || c == '+' && bl) break;
                    if (n4 < n2) {
                        n3 = n4;
                        continue;
                    }
                    break block3;
                    break;
                }
                Buffer buffer = new Buffer();
                buffer.writeUtf8(string, n, n3);
                this.writePercentDecoded(buffer, string, n3, n2, bl);
                return buffer.readUtf8();
            }
        }
        string = string.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final void toPathString$okhttp(List<String> list, StringBuilder stringBuilder) {
        Intrinsics.checkNotNullParameter(list, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)stringBuilder, (String)"out");
        int n = list.size();
        if (n <= 0) return;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            stringBuilder.append('/');
            stringBuilder.append(list.get(n2));
            if (n3 >= n) {
                return;
            }
            n2 = n3;
        }
    }

    public final List<String> toQueryNamesAndValues$okhttp(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        List list = new ArrayList();
        int n = 0;
        while (n <= string.length()) {
            int n2;
            CharSequence charSequence = string;
            int n3 = n2 = StringsKt.indexOf$default((CharSequence)charSequence, (char)'&', (int)n, (boolean)false, (int)4, null);
            if (n2 == -1) {
                n3 = string.length();
            }
            if ((n2 = StringsKt.indexOf$default((CharSequence)charSequence, (char)'=', (int)n, (boolean)false, (int)4, null)) != -1 && n2 <= n3) {
                charSequence = string.substring(n, n2);
                Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                list.add(charSequence);
                charSequence = string.substring(n2 + 1, n3);
                Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                list.add(charSequence);
            } else {
                charSequence = string.substring(n, n3);
                Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                list.add(charSequence);
                list.add(null);
            }
            n = n3 + 1;
        }
        return list;
    }

    public final void toQueryString$okhttp(List<String> list, StringBuilder stringBuilder) {
        int n;
        int n2;
        int n3;
        Object object;
        block8: {
            int n4;
            block7: {
                Intrinsics.checkNotNullParameter(list, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)stringBuilder, (String)"out");
                object = RangesKt.step((IntProgression)((IntProgression)RangesKt.until((int)0, (int)list.size())), (int)2);
                n4 = object.getFirst();
                n3 = object.getLast();
                n2 = object.getStep();
                if (n2 <= 0) break block7;
                n = n4;
                if (n4 <= n3) break block8;
            }
            if (n2 >= 0) return;
            if (n3 > n4) return;
            n = n4;
        }
        while (true) {
            String string = list.get(n);
            object = list.get(n + 1);
            if (n > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(string);
            if (object != null) {
                stringBuilder.append('=');
                stringBuilder.append((String)object);
            }
            if (n == n3) {
                return;
            }
            n += n2;
        }
    }
}
