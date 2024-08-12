/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  okhttp3.Cookie
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.internal.HostnamesKt
 *  okhttp3.internal.Util
 *  okhttp3.internal.publicsuffix.PublicSuffixDatabase
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000\u00a2\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Cookie.Companion {
    private Cookie.Companion() {
    }

    public /* synthetic */ Cookie.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ boolean access$domainMatch(Cookie.Companion companion, String string, String string2) {
        return companion.domainMatch(string, string2);
    }

    public static final /* synthetic */ boolean access$pathMatch(Cookie.Companion companion, HttpUrl httpUrl, String string) {
        return companion.pathMatch(httpUrl, string);
    }

    private final int dateCharacterOffset(String string, int n, int n2, boolean bl) {
        if (n >= n2) return n2;
        while (true) {
            boolean bl2;
            int n3;
            block7: {
                block6: {
                    n3 = n + 1;
                    char c = string.charAt(n);
                    boolean bl3 = false;
                    if (c < ' ' && c != '\t' || c >= '\u007f' || (bl2 = c <= '9' && '0' <= c) || (bl2 = c <= 'z' && 'a' <= c) || (bl2 = c <= 'Z' && 'A' <= c)) break block6;
                    bl2 = bl3;
                    if (c != ':') break block7;
                }
                bl2 = true;
            }
            if (bl2 == (bl ^ true)) {
                return n;
            }
            if (n3 >= n2) {
                return n2;
            }
            n = n3;
        }
    }

    private final boolean domainMatch(String string, String string2) {
        boolean bl = Intrinsics.areEqual((Object)string, (Object)string2);
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        if (StringsKt.endsWith$default((String)string, (String)string2, (boolean)false, (int)2, null) && string.charAt(string.length() - string2.length() - 1) == '.' && !Util.canParseAsIpAddress((String)string)) return bl2;
        bl2 = false;
        return bl2;
    }

    private final String parseDomain(String string) {
        if (!(StringsKt.endsWith$default((String)string, (String)".", (boolean)false, (int)2, null) ^ true)) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        if ((string = HostnamesKt.toCanonicalHost((String)StringsKt.removePrefix((String)string, (CharSequence)"."))) == null) throw new IllegalArgumentException();
        return string;
    }

    private final long parseExpires(String object, int n, int n2) {
        int n3;
        int n4 = this.dateCharacterOffset((String)object, n, n2, false);
        Matcher matcher = Cookie.access$getTIME_PATTERN$cp().matcher((CharSequence)object);
        n = -1;
        int n5 = -1;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        int n9 = -1;
        while (n4 < n2) {
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            String string;
            int n15 = this.dateCharacterOffset((String)object, n4 + 1, n2, true);
            matcher.region(n4, n15);
            if (n5 == -1 && matcher.usePattern(Cookie.access$getTIME_PATTERN$cp()).matches()) {
                string = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(1)");
                n14 = Integer.parseInt(string);
                string = matcher.group(2);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(2)");
                n13 = Integer.parseInt(string);
                string = matcher.group(3);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(3)");
                n12 = Integer.parseInt(string);
                n3 = n;
                n11 = n6;
                n10 = n7;
            } else if (n6 == -1 && matcher.usePattern(Cookie.access$getDAY_OF_MONTH_PATTERN$cp()).matches()) {
                string = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(1)");
                n11 = Integer.parseInt(string);
                n3 = n;
                n14 = n5;
                n10 = n7;
                n13 = n8;
                n12 = n9;
            } else if (n7 == -1 && matcher.usePattern(Cookie.access$getMONTH_PATTERN$cp()).matches()) {
                string = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(1)");
                Object object2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"US");
                string = string.toLowerCase((Locale)object2);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toLowerCase(locale)");
                object2 = Cookie.access$getMONTH_PATTERN$cp().pattern();
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"MONTH_PATTERN.pattern()");
                n10 = StringsKt.indexOf$default((CharSequence)((CharSequence)object2), (String)string, (int)0, (boolean)false, (int)6, null) / 4;
                n3 = n;
                n14 = n5;
                n11 = n6;
                n13 = n8;
                n12 = n9;
            } else {
                n3 = n;
                n14 = n5;
                n11 = n6;
                n10 = n7;
                n13 = n8;
                n12 = n9;
                if (n == -1) {
                    n3 = n;
                    n14 = n5;
                    n11 = n6;
                    n10 = n7;
                    n13 = n8;
                    n12 = n9;
                    if (matcher.usePattern(Cookie.access$getYEAR_PATTERN$cp()).matches()) {
                        string = matcher.group(1);
                        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(1)");
                        n3 = Integer.parseInt(string);
                        n12 = n9;
                        n13 = n8;
                        n10 = n7;
                        n11 = n6;
                        n14 = n5;
                    }
                }
            }
            n4 = this.dateCharacterOffset((String)object, n15 + 1, n2, false);
            n = n3;
            n5 = n14;
            n6 = n11;
            n7 = n10;
            n8 = n13;
            n9 = n12;
        }
        n3 = 70 <= n && n <= 99 ? 1 : 0;
        n2 = n;
        if (n3 != 0) {
            n2 = n + 1900;
        }
        n3 = n2 >= 0 && n2 <= 69 ? 1 : 0;
        n = n2;
        if (n3 != 0) {
            n = n2 + 2000;
        }
        if ((n2 = n >= 1601 ? 1 : 0) == 0) {
            object = new IllegalArgumentException("Failed requirement.".toString());
            throw object;
        }
        n2 = n7 != -1 ? 1 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        n2 = 1 <= n6 && n6 <= 31 ? 1 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        n2 = n5 >= 0 && n5 <= 23 ? 1 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        n2 = n8 >= 0 && n8 <= 59 ? 1 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        n2 = n9 >= 0 && n9 <= 59 ? 1 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        object = new GregorianCalendar(Util.UTC);
        ((Calendar)object).setLenient(false);
        ((Calendar)object).set(1, n);
        ((Calendar)object).set(2, n7 - 1);
        ((Calendar)object).set(5, n6);
        ((Calendar)object).set(11, n5);
        ((Calendar)object).set(12, n8);
        ((Calendar)object).set(13, n9);
        ((Calendar)object).set(14, 0);
        return ((Calendar)object).getTimeInMillis();
    }

    private final long parseMaxAge(String string) {
        long l = Long.MIN_VALUE;
        try {
            long l2 = Long.parseLong(string);
            if (l2 <= 0L) return l;
            l = l2;
            return l;
        }
        catch (NumberFormatException numberFormatException) {
            CharSequence charSequence = string;
            if (!new Regex("-?\\d+").matches(charSequence)) throw numberFormatException;
            if (StringsKt.startsWith$default((String)string, (String)"-", (boolean)false, (int)2, null)) return l;
            l = Long.MAX_VALUE;
            return l;
        }
    }

    private final boolean pathMatch(HttpUrl object, String string) {
        if (Intrinsics.areEqual((Object)(object = object.encodedPath()), (Object)string)) {
            return true;
        }
        if (!StringsKt.startsWith$default((String)object, (String)string, (boolean)false, (int)2, null)) return false;
        if (StringsKt.endsWith$default((String)string, (String)"/", (boolean)false, (int)2, null)) {
            return true;
        }
        if (((String)object).charAt(string.length()) != '/') return false;
        return true;
    }

    @JvmStatic
    public final Cookie parse(HttpUrl httpUrl, String string) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        Intrinsics.checkNotNullParameter((Object)string, (String)"setCookie");
        return this.parse$okhttp(System.currentTimeMillis(), httpUrl, string);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final Cookie parse$okhttp(long l, HttpUrl object, String string) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"url");
        Intrinsics.checkNotNullParameter((Object)string, (String)"setCookie");
        int n = Util.delimiterOffset$default((String)string, (char)';', (int)0, (int)0, (int)6, null);
        int n2 = Util.delimiterOffset$default((String)string, (char)'=', (int)0, (int)n, (int)2, null);
        if (n2 == n) {
            return null;
        }
        String string2 = Util.trimSubstring$default((String)string, (int)0, (int)n2, (int)1, null);
        int n3 = ((CharSequence)string2).length() == 0 ? 1 : 0;
        if (n3 != 0) return null;
        if (Util.indexOfControlOrNonAscii((String)string2) != -1) {
            return null;
        }
        String string3 = Util.trimSubstring((String)string, (int)(n2 + 1), (int)n);
        if (Util.indexOfControlOrNonAscii((String)string3) != -1) {
            return null;
        }
        n3 = n + 1;
        n2 = string.length();
        String string4 = null;
        String string5 = null;
        long l2 = -1L;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = true;
        long l3 = 253402300799999L;
        while (true) {
            long l4;
            String string6;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            long l5;
            String string7;
            int n4;
            block23: {
                block26: {
                    block27: {
                        block28: {
                            block25: {
                                block21: {
                                    String string8;
                                    block24: {
                                        block22: {
                                            block20: {
                                                if (n3 >= n2) break block21;
                                                n4 = Util.delimiterOffset((String)string, (char)';', (int)n3, (int)n2);
                                                n = Util.delimiterOffset((String)string, (char)'=', (int)n3, (int)n4);
                                                string8 = Util.trimSubstring((String)string, (int)n3, (int)n);
                                                string7 = n < n4 ? Util.trimSubstring((String)string, (int)(n + 1), (int)n4) : "";
                                                if (StringsKt.equals((String)string8, (String)"expires", (boolean)true)) {
                                                    l3 = l5 = this.parseExpires(string7, 0, string7.length());
                                                    break block20;
                                                }
                                                if (!StringsKt.equals((String)string8, (String)"max-age", (boolean)true)) break block22;
                                                try {
                                                    l2 = l5 = this.parseMaxAge(string7);
                                                }
                                                catch (IllegalArgumentException | NumberFormatException illegalArgumentException) {
                                                    string7 = string4;
                                                    l5 = l2;
                                                    bl7 = bl;
                                                    bl6 = bl3;
                                                    bl5 = bl4;
                                                    string6 = string5;
                                                    l4 = l3;
                                                }
                                            }
                                            bl6 = true;
                                            string7 = string4;
                                            l5 = l2;
                                            bl7 = bl;
                                            bl5 = bl4;
                                            string6 = string5;
                                            l4 = l3;
                                            break block23;
                                        }
                                        if (StringsKt.equals((String)string8, (String)"domain", (boolean)true)) {
                                            string7 = this.parseDomain(string7);
                                            bl5 = false;
                                            l5 = l2;
                                            bl7 = bl;
                                            bl6 = bl3;
                                            string6 = string5;
                                            l4 = l3;
                                        }
                                        if (!StringsKt.equals((String)string8, (String)"path", (boolean)true)) break block24;
                                        string6 = string7;
                                        string7 = string4;
                                        l5 = l2;
                                        bl7 = bl;
                                        bl6 = bl3;
                                        bl5 = bl4;
                                        l4 = l3;
                                        break block23;
                                    }
                                    if (StringsKt.equals((String)string8, (String)"secure", (boolean)true)) {
                                        bl7 = true;
                                        string7 = string4;
                                        l5 = l2;
                                        bl6 = bl3;
                                        bl5 = bl4;
                                        string6 = string5;
                                        l4 = l3;
                                        break block23;
                                    } else {
                                        string7 = string4;
                                        l5 = l2;
                                        bl7 = bl;
                                        bl6 = bl3;
                                        bl5 = bl4;
                                        string6 = string5;
                                        l4 = l3;
                                        if (StringsKt.equals((String)string8, (String)"httponly", (boolean)true)) {
                                            bl2 = true;
                                            l4 = l3;
                                            string6 = string5;
                                            bl5 = bl4;
                                            bl6 = bl3;
                                            bl7 = bl;
                                            l5 = l2;
                                            string7 = string4;
                                        }
                                    }
                                    break block23;
                                }
                                l5 = Long.MIN_VALUE;
                                if (l2 != Long.MIN_VALUE) break block25;
                                l = l5;
                                break block26;
                            }
                            if (l2 == -1L) break block27;
                            l3 = l2 <= 9223372036854775L ? l2 * (long)1000 : Long.MAX_VALUE;
                            if ((l3 = l + l3) < l) break block28;
                            l = l3;
                            if (l3 <= 253402300799999L) break block26;
                        }
                        l = 253402300799999L;
                        break block26;
                    }
                    l = l3;
                }
                string7 = object.host();
                if (string4 == null) {
                    string = string7;
                } else {
                    if (!this.domainMatch(string7, string4)) {
                        return null;
                    }
                    string = string4;
                }
                if (string7.length() != string.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(string) == null) {
                    return null;
                }
                string4 = "/";
                if (string5 != null && StringsKt.startsWith$default((String)string5, (String)"/", (boolean)false, (int)2, null)) {
                    object = string5;
                    return new Cookie(string2, string3, l, string, (String)object, bl, bl2, bl3, bl4, null);
                }
                string5 = object.encodedPath();
                n3 = StringsKt.lastIndexOf$default((CharSequence)string5, (char)'/', (int)0, (boolean)false, (int)6, null);
                object = string4;
                if (n3 == 0) return new Cookie(string2, string3, l, string, (String)object, bl, bl2, bl3, bl4, null);
                if (string5 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                object = string5.substring(0, n3);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                return new Cookie(string2, string3, l, string, (String)object, bl, bl2, bl3, bl4, null);
            }
            n3 = n4 + 1;
            string4 = string7;
            l2 = l5;
            bl = bl7;
            bl3 = bl6;
            bl4 = bl5;
            string5 = string6;
            l3 = l4;
        }
    }

    @JvmStatic
    public final List<Cookie> parseAll(HttpUrl object, Headers headers) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"url");
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        List list = headers.values("Set-Cookie");
        int n = list.size();
        headers = null;
        Object object2 = null;
        if (n > 0) {
            int n2 = 0;
            headers = object2;
            while (true) {
                int n3 = n2 + 1;
                Cookie cookie = this.parse((HttpUrl)object, (String)list.get(n2));
                if (cookie != null) {
                    object2 = headers;
                    if (headers == null) {
                        object2 = new ArrayList();
                    }
                    object2.add(cookie);
                    headers = object2;
                }
                if (n3 >= n) break;
                n2 = n3;
            }
        }
        if (headers != null) {
            object = Collections.unmodifiableList(headers);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"{\n        Collections.un\u2026ableList(cookies)\n      }");
        } else {
            object = CollectionsKt.emptyList();
        }
        return object;
    }
}
