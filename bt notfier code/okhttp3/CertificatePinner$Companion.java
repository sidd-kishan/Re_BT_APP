/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.ByteString
 *  okio.ByteString$Companion
 */
package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", "", "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CertificatePinner.Companion {
    private CertificatePinner.Companion() {
    }

    public /* synthetic */ CertificatePinner.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final String pin(Certificate certificate) {
        Intrinsics.checkNotNullParameter((Object)certificate, (String)"certificate");
        if (!(certificate instanceof X509Certificate)) throw (Throwable)new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        return Intrinsics.stringPlus((String)"sha256/", (Object)this.sha256Hash((X509Certificate)certificate).base64());
    }

    @JvmStatic
    public final ByteString sha1Hash(X509Certificate object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        ByteString.Companion companion = ByteString.Companion;
        object = ((Certificate)object).getPublicKey().getEncoded();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"publicKey.encoded");
        return ByteString.Companion.of$default((ByteString.Companion)companion, (byte[])object, (int)0, (int)0, (int)3, null).sha1();
    }

    @JvmStatic
    public final ByteString sha256Hash(X509Certificate object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        ByteString.Companion companion = ByteString.Companion;
        object = ((Certificate)object).getPublicKey().getEncoded();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"publicKey.encoded");
        return ByteString.Companion.of$default((ByteString.Companion)companion, (byte[])object, (int)0, (int)0, (int)3, null).sha256();
    }
}
