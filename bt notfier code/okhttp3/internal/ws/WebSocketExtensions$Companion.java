/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Headers
 *  okhttp3.internal.Util
 *  okhttp3.internal.ws.WebSocketExtensions
 */
package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.ws.WebSocketExtensions;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class WebSocketExtensions.Companion {
    private WebSocketExtensions.Companion() {
    }

    public /* synthetic */ WebSocketExtensions.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /*
     * Unable to fully structure code
     */
    public final WebSocketExtensions parse(Headers var1_1) throws IOException {
        block20: {
            block19: {
                Intrinsics.checkNotNullParameter((Object)var1_1, (String)"responseHeaders");
                var5_2 = var1_1.size();
                if (var5_2 > 0) break block19;
                var19_19 = null;
                var1_1 = null;
                var8_9 = false;
                var14_16 = false;
                var10_8 = false;
                var9_14 = false;
                break block20;
            }
            var2_3 = 0;
            var12_4 = false;
            var18_5 = null;
            var11_6 = false;
            var16_7 = null;
            var10_8 = false;
            var8_9 = false;
            block0: while (true) {
                block21: {
                    var3_10 = var2_3 + 1;
                    if (StringsKt.equals((String)var1_1.name(var2_3), (String)"Sec-WebSocket-Extensions", (boolean)true)) break block21;
                    var9_14 = var8_9;
                    var13_15 = var10_8;
                    var14_16 = var11_6;
                    var19_19 = var18_5;
                    var15_17 = var12_4;
                    ** GOTO lbl50
                }
                var21_21 = var1_1.value(var2_3);
                var2_3 = 0;
                var17_18 = var16_7;
                while (true) {
                    var15_17 = var12_4;
                    var19_19 = var18_5;
                    var14_16 = var11_6;
                    var16_7 = var17_18;
                    var13_15 = var10_8;
                    var9_14 = var8_9;
                    if (var2_3 >= var21_21.length()) ** GOTO lbl50
                    var6_12 = Util.delimiterOffset$default((String)var21_21, (char)',', (int)var2_3, (int)0, (int)4, null);
                    var4_11 = Util.delimiterOffset((String)var21_21, (char)';', (int)var2_3, (int)var6_12);
                    var16_7 = Util.trimSubstring((String)var21_21, (int)var2_3, (int)var4_11);
                    var2_3 = var4_11 + 1;
                    if (StringsKt.equals((String)var16_7, (String)"permessage-deflate", (boolean)true)) {
                        if (var12_4) {
                            var8_9 = true;
                        }
                    } else {
                        var8_9 = true;
                        continue;
lbl50:
                        // 2 sources

                        if (var3_10 >= var5_2) {
                            var8_9 = var15_17;
                            var1_1 = var16_7;
                            var10_8 = var13_15;
                            break block0;
                        }
                        var2_3 = var3_10;
                        var12_4 = var15_17;
                        var18_5 = var19_19;
                        var11_6 = var14_16;
                        var10_8 = var13_15;
                        var8_9 = var9_14;
                        continue block0;
                    }
                    while (var2_3 < var6_12) {
                        var4_11 = Util.delimiterOffset((String)var21_21, (char)';', (int)var2_3, (int)var6_12);
                        var7_13 = Util.delimiterOffset((String)var21_21, (char)'=', (int)var2_3, (int)var4_11);
                        var22_22 = Util.trimSubstring((String)var21_21, (int)var2_3, (int)var7_13);
                        var16_7 = var7_13 < var4_11 ? StringsKt.removeSurrounding((String)Util.trimSubstring((String)var21_21, (int)(var7_13 + 1), (int)var4_11), (CharSequence)"\"") : (String)null;
                        ++var4_11;
                        if (StringsKt.equals((String)var22_22, (String)"client_max_window_bits", (boolean)true)) {
                            if (var18_5 != null) {
                                var8_9 = true;
                            }
                            var16_7 = var16_7 == null ? null : StringsKt.toIntOrNull((String)var16_7);
                            var18_5 = var16_7;
                            var2_3 = var4_11;
                            if (var16_7 != null) continue;
                            var19_19 = var16_7;
                            var20_20 = var17_18;
                        } else {
                            if (StringsKt.equals((String)var22_22, (String)"client_no_context_takeover", (boolean)true)) {
                                if (var11_6) {
                                    var8_9 = true;
                                }
                                if (var16_7 != null) {
                                    var8_9 = true;
                                }
                                var11_6 = true;
                                var2_3 = var4_11;
                                continue;
                            }
                            if (StringsKt.equals((String)var22_22, (String)"server_max_window_bits", (boolean)true)) {
                                if (var17_18 != null) {
                                    var8_9 = true;
                                }
                                var16_7 = var16_7 == null ? null : StringsKt.toIntOrNull((String)var16_7);
                                var17_18 = var16_7;
                                var2_3 = var4_11;
                                if (var16_7 != null) continue;
                                var19_19 = var18_5;
                                var20_20 = var16_7;
                            } else {
                                var19_19 = var18_5;
                                var20_20 = var17_18;
                                if (StringsKt.equals((String)var22_22, (String)"server_no_context_takeover", (boolean)true)) {
                                    if (var10_8) {
                                        var8_9 = true;
                                    }
                                    if (var16_7 != null) {
                                        var8_9 = true;
                                    }
                                    var10_8 = true;
                                    var2_3 = var4_11;
                                    continue;
                                }
                            }
                        }
                        var8_9 = true;
                        var18_5 = var19_19;
                        var17_18 = var20_20;
                        var2_3 = var4_11;
                    }
                    var12_4 = true;
                }
                break;
            }
        }
        return new WebSocketExtensions(var8_9, var19_19, var14_16, (Integer)var1_1, var10_8, var9_14);
    }
}
