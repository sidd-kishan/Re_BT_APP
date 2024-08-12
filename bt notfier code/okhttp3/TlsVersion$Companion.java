/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.TlsVersion
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.TlsVersion;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Lokhttp3/TlsVersion$Companion;", "", "()V", "forJavaName", "Lokhttp3/TlsVersion;", "javaName", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class TlsVersion.Companion {
    private TlsVersion.Companion() {
    }

    public /* synthetic */ TlsVersion.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final TlsVersion forJavaName(String string) {
        block7: {
            block8: {
                block5: {
                    block6: {
                        Intrinsics.checkNotNullParameter((Object)string, (String)"javaName");
                        int n = string.hashCode();
                        if (n == 79201641) break block5;
                        if (n == 79923350) break block6;
                        switch (n) {
                            default: {
                                break block7;
                            }
                            case -503070501: {
                                if (!string.equals("TLSv1.3")) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected TLS version: ", (Object)string));
                                string = TlsVersion.TLS_1_3;
                                break;
                            }
                            case -503070502: {
                                if (!string.equals("TLSv1.2")) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected TLS version: ", (Object)string));
                                string = TlsVersion.TLS_1_2;
                                break;
                            }
                            case -503070503: {
                                if (!string.equals("TLSv1.1")) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected TLS version: ", (Object)string));
                                string = TlsVersion.TLS_1_1;
                                break;
                            }
                        }
                        break block8;
                    }
                    if (!string.equals("TLSv1")) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected TLS version: ", (Object)string));
                    string = TlsVersion.TLS_1_0;
                    break block8;
                }
                if (!string.equals("SSLv3")) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected TLS version: ", (Object)string));
                string = TlsVersion.SSL_3_0;
            }
            return string;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected TLS version: ", (Object)string));
    }
}
