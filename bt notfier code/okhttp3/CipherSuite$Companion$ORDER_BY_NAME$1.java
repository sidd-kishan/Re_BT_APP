/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package okhttp3;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2={"okhttp3/CipherSuite$Companion$ORDER_BY_NAME$1", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "compare", "", "a", "b", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CipherSuite.Companion.ORDER_BY_NAME.1
implements Comparator<String> {
    CipherSuite.Companion.ORDER_BY_NAME.1() {
    }

    @Override
    public int compare(String string, String string2) {
        int n;
        block2: {
            Intrinsics.checkNotNullParameter((Object)string, (String)"a");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"b");
            int n2 = Math.min(string.length(), string2.length());
            int n3 = 4;
            while (true) {
                char c;
                n = -1;
                if (n3 >= n2) break;
                char c2 = string.charAt(n3);
                if (c2 != (c = string2.charAt(n3))) {
                    if (Intrinsics.compare((int)c2, (int)c) < 0) return n;
                    n = 1;
                    break block2;
                }
                ++n3;
            }
            n2 = string.length();
            if (n2 == (n3 = string2.length())) return 0;
            if (n2 < n3) return n;
            n = 1;
            return n;
        }
        return n;
    }
}
