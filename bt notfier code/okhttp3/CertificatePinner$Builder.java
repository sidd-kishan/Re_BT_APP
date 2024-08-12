/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CertificatePinner
 *  okhttp3.CertificatePinner$Pin
 */
package okhttp3;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CertificatePinner;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2={"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CertificatePinner.Builder {
    private final List<CertificatePinner.Pin> pins = new ArrayList();

    public final CertificatePinner.Builder add(String string, String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"pattern");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"pins");
        CertificatePinner.Builder builder = this;
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string2 = stringArray[n2];
            ++n2;
            builder.getPins().add(new CertificatePinner.Pin(string, string2));
        }
        return builder;
    }

    public final CertificatePinner build() {
        return new CertificatePinner(CollectionsKt.toSet((Iterable)this.pins), null, 2, null);
    }

    public final List<CertificatePinner.Pin> getPins() {
        return this.pins;
    }
}
