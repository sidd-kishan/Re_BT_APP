/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.CacheControl
 *  okhttp3.Headers
 *  okhttp3.internal.Util
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.internal.Util;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CacheControl.Companion {
    private CacheControl.Companion() {
    }

    public /* synthetic */ CacheControl.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int indexOfElement(String string, String string2, int n) {
        int n2 = string.length();
        if (n >= n2) return string.length();
        while (true) {
            int n3 = n + 1;
            if (StringsKt.contains$default((CharSequence)string2, (char)string.charAt(n), (boolean)false, (int)2, null)) {
                return n;
            }
            if (n3 >= n2) {
                return string.length();
            }
            n = n3;
        }
    }

    static /* synthetic */ int indexOfElement$default(CacheControl.Companion companion, String string, String string2, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return companion.indexOfElement(string, string2, n);
        n = 0;
        return companion.indexOfElement(string, string2, n);
    }

    @JvmStatic
    public final CacheControl parse(Headers object) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        int n;
        int n2;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        int n3;
        int n4;
        boolean bl7;
        boolean bl8;
        String string;
        int n5;
        block27: {
            int n6;
            block26: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"headers");
                n6 = object.size();
                if (n6 > 0) break block26;
                n5 = 1;
                string = null;
                bl8 = false;
                bl7 = false;
                n4 = -1;
                n3 = -1;
                bl6 = false;
                bl5 = false;
                bl4 = false;
                n2 = -1;
                n = -1;
                bl3 = false;
                bl2 = false;
                bl = false;
                break block27;
            }
            n5 = 0;
            string = null;
            bl5 = false;
            bl7 = false;
            n4 = -1;
            n3 = -1;
            bl6 = false;
            boolean bl9 = false;
            bl4 = false;
            n2 = -1;
            n = -1;
            bl8 = false;
            bl2 = false;
            bl = false;
            int n7 = 1;
            while (true) {
                int n8;
                block31: {
                    String string2;
                    String string3;
                    block30: {
                        block29: {
                            block28: {
                                n8 = n5 + 1;
                                string3 = object.name(n5);
                                string2 = object.value(n5);
                                if (!StringsKt.equals((String)string3, (String)"Cache-Control", (boolean)true)) break block28;
                                if (string != null) break block29;
                                string = string2;
                                break block30;
                            }
                            if (!StringsKt.equals((String)string3, (String)"Pragma", (boolean)true)) break block31;
                        }
                        n7 = 0;
                    }
                    n5 = 0;
                    while (n5 < string2.length()) {
                        int n9;
                        int n10;
                        int n11;
                        int n12 = this.indexOfElement(string2, "=,;", n5);
                        if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        string3 = string2.substring(n5, n12);
                        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        if (string3 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        String string4 = ((Object)StringsKt.trim((CharSequence)string3)).toString();
                        if (n12 != string2.length() && string2.charAt(n12) != ',' && string2.charAt(n12) != ';') {
                            if ((n12 = Util.indexOfNonWhitespace((String)string2, (int)(n12 + 1))) < string2.length() && string2.charAt(n12) == '\"') {
                                n5 = n12 + 1;
                                n12 = StringsKt.indexOf$default((CharSequence)string2, (char)'\"', (int)n5, (boolean)false, (int)4, null);
                                if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                string3 = string2.substring(n5, n12);
                                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                                n5 = n12 + 1;
                            } else {
                                n5 = this.indexOfElement(string2, ",;", n12);
                                if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                string3 = string2.substring(n12, n5);
                                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                                if (string3 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                string3 = ((Object)StringsKt.trim((CharSequence)string3)).toString();
                            }
                        } else {
                            n5 = n12 + 1;
                            string3 = null;
                        }
                        bl3 = true;
                        if (StringsKt.equals((String)"no-cache", (String)string4, (boolean)true)) {
                            bl5 = bl3;
                            continue;
                        }
                        if (StringsKt.equals((String)"no-store", (String)string4, (boolean)true)) {
                            bl7 = true;
                            continue;
                        }
                        if (StringsKt.equals((String)"max-age", (String)string4, (boolean)true)) {
                            n11 = Util.toNonNegativeInt((String)string3, (int)-1);
                            n10 = n;
                            n12 = n2;
                            n9 = n3;
                        } else if (StringsKt.equals((String)"s-maxage", (String)string4, (boolean)true)) {
                            n9 = Util.toNonNegativeInt((String)string3, (int)-1);
                            n11 = n4;
                            n12 = n2;
                            n10 = n;
                        } else {
                            if (StringsKt.equals((String)"private", (String)string4, (boolean)true)) {
                                bl6 = true;
                                continue;
                            }
                            if (StringsKt.equals((String)"public", (String)string4, (boolean)true)) {
                                bl9 = true;
                                continue;
                            }
                            if (StringsKt.equals((String)"must-revalidate", (String)string4, (boolean)true)) {
                                bl4 = true;
                                continue;
                            }
                            if (StringsKt.equals((String)"max-stale", (String)string4, (boolean)true)) {
                                n12 = Util.toNonNegativeInt((String)string3, (int)Integer.MAX_VALUE);
                                n11 = n4;
                                n9 = n3;
                                n10 = n;
                            } else if (StringsKt.equals((String)"min-fresh", (String)string4, (boolean)true)) {
                                n10 = Util.toNonNegativeInt((String)string3, (int)-1);
                                n11 = n4;
                                n9 = n3;
                                n12 = n2;
                            } else {
                                if (StringsKt.equals((String)"only-if-cached", (String)string4, (boolean)true)) {
                                    bl8 = true;
                                    continue;
                                }
                                if (StringsKt.equals((String)"no-transform", (String)string4, (boolean)true)) {
                                    bl2 = true;
                                    continue;
                                }
                                n11 = n4;
                                n9 = n3;
                                n12 = n2;
                                n10 = n;
                                if (StringsKt.equals((String)"immutable", (String)string4, (boolean)true)) {
                                    bl = true;
                                    continue;
                                }
                            }
                        }
                        n4 = n11;
                        n3 = n9;
                        n2 = n12;
                        n = n10;
                    }
                }
                if (n8 >= n6) {
                    bl3 = bl8;
                    n5 = n7;
                    bl8 = bl5;
                    bl5 = bl9;
                    break;
                }
                n5 = n8;
            }
        }
        object = n5 == 0 ? null : string;
        return new CacheControl(bl8, bl7, n4, n3, bl6, bl5, bl4, n2, n, bl3, bl2, bl, (String)object, null);
    }
}
