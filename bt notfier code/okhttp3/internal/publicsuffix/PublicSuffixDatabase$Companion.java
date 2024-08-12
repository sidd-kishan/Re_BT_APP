/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.publicsuffix.PublicSuffixDatabase
 */
package okhttp3.internal.publicsuffix;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class PublicSuffixDatabase.Companion {
    private PublicSuffixDatabase.Companion() {
    }

    public /* synthetic */ PublicSuffixDatabase.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ String access$binarySearch(PublicSuffixDatabase.Companion companion, byte[] byArray, byte[][] byArray2, int n) {
        return companion.binarySearch(byArray, byArray2, n);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final String binarySearch(byte[] var1_1, byte[][] var2_2, int var3_3) {
        block14: {
            block16: {
                var8_4 = var1_1 /* !! */ .length;
                var7_5 = 0;
                block0: while (true) {
                    block15: {
                        if (var7_5 >= var8_4) {
                            var1_1 /* !! */  = null;
                            break block14;
                        }
                        for (var4_6 = (var7_5 + var8_4) / 2; var4_6 > -1 && var1_1 /* !! */ [var4_6] != (byte)10; --var4_6) {
                        }
                        var11_11 = var4_6 + 1;
                        var4_6 = 1;
                        while (var1_1 /* !! */ [var12_12 = var11_11 + var4_6] != (byte)10) {
                            ++var4_6;
                        }
                        var13_13 = var12_12 - var11_11;
                        var9_9 = var3_3;
                        var5_7 = 0;
                        var4_6 = 0;
                        var6_8 = 0;
                        while (true) {
                            block18: {
                                block17: {
                                    if (var5_7 != 0) {
                                        var10_10 = 46;
                                        var5_7 = 0;
                                    } else {
                                        var10_10 = Util.and((byte)var2_2 /* !! */ [var9_9][var4_6], (int)255);
                                    }
                                    if ((var10_10 -= Util.and((byte)var1_1 /* !! */ [var11_11 + var6_8], (int)255)) != 0) break block17;
                                    ++var4_6;
                                    if (++var6_8 == var13_13) break block17;
                                    if (var2_2 /* !! */ [var9_9].length != var4_6) continue;
                                    if (var9_9 != ((Object[])var2_2 /* !! */ ).length - 1) break block18;
                                }
                                if (var10_10 < 0) break;
                                if (var10_10 > 0) break block15;
                                var10_10 = var13_13 - var6_8;
                                var4_6 = var2_2 /* !! */ [var9_9].length - var4_6;
                                var6_8 = var9_9 + 1;
                                var9_9 = ((Object[])var2_2 /* !! */ ).length;
                                var5_7 = var4_6;
                                if (var6_8 < var9_9) {
                                    var5_7 = var6_8;
                                    break block0;
                                }
                                break block16;
                            }
                            ++var9_9;
                            var5_7 = 1;
                            var4_6 = -1;
                        }
lbl47:
                        // 2 sources

                        while (true) {
                            var8_4 = var11_11 - 1;
                            continue block0;
                            break;
                        }
                    }
lbl51:
                    // 2 sources

                    while (true) {
                        var7_5 = var12_12 + 1;
                        continue block0;
                        break;
                    }
                    break;
                }
                while (true) {
                    var6_8 = var5_7 + 1;
                    var4_6 += var2_2 /* !! */ [var5_7].length;
                    if (var6_8 >= var9_9) {
                        var5_7 = var4_6;
                        break;
                    }
                    var5_7 = var6_8;
                }
            }
            ** while (var5_7 < var10_10)
lbl64:
            // 1 sources

            ** while (var5_7 > var10_10)
lbl65:
            // 1 sources

            var2_2 /* !! */  = (byte[][])StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue((Object)var2_2 /* !! */ , (String)"UTF_8");
            var1_1 /* !! */  = (byte[])new String(var1_1 /* !! */ , var11_11, var13_13, (Charset)var2_2 /* !! */ );
        }
        return var1_1 /* !! */ ;
    }

    public final PublicSuffixDatabase get() {
        return PublicSuffixDatabase.access$getInstance$cp();
    }
}
