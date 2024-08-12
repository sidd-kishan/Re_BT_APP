/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.CertificatePinner
 *  okhttp3.internal.HostnamesKt
 *  okio.ByteString
 */
package okhttp3;

import java.security.cert.X509Certificate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CertificatePinner;
import okhttp3.internal.HostnamesKt;
import okio.ByteString;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0019"}, d2={"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "equals", "", "other", "hashCode", "", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "matchesHostname", "hostname", "toString", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CertificatePinner.Pin {
    private final ByteString hash;
    private final String hashAlgorithm;
    private final String pattern;

    public CertificatePinner.Pin(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"pattern");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"pin");
        boolean bl = StringsKt.startsWith$default((String)string, (String)"*.", (boolean)false, (int)2, null) && StringsKt.indexOf$default((CharSequence)string, (String)"*", (int)1, (boolean)false, (int)4, null) == -1 || StringsKt.startsWith$default((String)string, (String)"**.", (boolean)false, (int)2, null) && StringsKt.indexOf$default((CharSequence)string, (String)"*", (int)2, (boolean)false, (int)4, null) == -1 || StringsKt.indexOf$default((CharSequence)string, (String)"*", (int)0, (boolean)false, (int)6, null) == -1;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected pattern: ", (Object)string).toString());
        String string3 = HostnamesKt.toCanonicalHost((String)string);
        if (string3 == null) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Invalid pattern: ", (Object)string));
        this.pattern = string3;
        if (StringsKt.startsWith$default((String)string2, (String)"sha1/", (boolean)false, (int)2, null)) {
            this.hashAlgorithm = "sha1";
            string3 = ByteString.Companion;
            string = string2.substring(5);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
            string = string3.decodeBase64(string);
            if (string == null) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Invalid pin hash: ", (Object)string2));
            this.hash = string;
        } else {
            if (!StringsKt.startsWith$default((String)string2, (String)"sha256/", (boolean)false, (int)2, null)) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"pins must start with 'sha256/' or 'sha1/': ", (Object)string2));
            this.hashAlgorithm = "sha256";
            string3 = ByteString.Companion;
            string = string2.substring(7);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
            string = string3.decodeBase64(string);
            if (string == null) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Invalid pin hash: ", (Object)string2));
            this.hash = string;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CertificatePinner.Pin)) {
            return false;
        }
        String string = this.pattern;
        object = (CertificatePinner.Pin)object;
        if (!Intrinsics.areEqual((Object)string, (Object)((CertificatePinner.Pin)object).pattern)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.hashAlgorithm, (Object)((CertificatePinner.Pin)object).hashAlgorithm)) {
            return false;
        }
        if (Intrinsics.areEqual((Object)this.hash, (Object)((CertificatePinner.Pin)object).hash)) return true;
        return false;
    }

    public final ByteString getHash() {
        return this.hash;
    }

    public final String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public int hashCode() {
        return (this.pattern.hashCode() * 31 + this.hashAlgorithm.hashCode()) * 31 + this.hash.hashCode();
    }

    public final boolean matchesCertificate(X509Certificate x509Certificate) {
        Intrinsics.checkNotNullParameter((Object)x509Certificate, (String)"certificate");
        String string = this.hashAlgorithm;
        boolean bl = Intrinsics.areEqual((Object)string, (Object)"sha256") ? Intrinsics.areEqual((Object)this.hash, (Object)CertificatePinner.Companion.sha256Hash(x509Certificate)) : (Intrinsics.areEqual((Object)string, (Object)"sha1") ? Intrinsics.areEqual((Object)this.hash, (Object)CertificatePinner.Companion.sha1Hash(x509Certificate)) : false);
        return bl;
    }

    /*
     * Enabled force condition propagation
     */
    public final boolean matchesHostname(String string) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)string, (String)"hostname");
        String string2 = this.pattern;
        boolean bl2 = false;
        if (StringsKt.startsWith$default((String)string2, (String)"**.", (boolean)false, (int)2, null)) {
            int n = this.pattern.length() - 3;
            int n2 = string.length() - n;
            bl = bl2;
            if (!StringsKt.regionMatches$default((String)string, (int)(string.length() - n), (String)this.pattern, (int)3, (int)n, (boolean)false, (int)16, null)) return bl;
            if (n2 == 0) return true;
            bl = bl2;
            if (string.charAt(n2 - 1) != '.') return bl;
            return true;
        } else {
            if (!StringsKt.startsWith$default((String)this.pattern, (String)"*.", (boolean)false, (int)2, null)) {
                return Intrinsics.areEqual((Object)string, (Object)this.pattern);
            }
            int n = this.pattern.length() - 1;
            int n3 = string.length();
            bl = bl2;
            if (!StringsKt.regionMatches$default((String)string, (int)(string.length() - n), (String)this.pattern, (int)1, (int)n, (boolean)false, (int)16, null)) return bl;
            bl = bl2;
            if (StringsKt.lastIndexOf$default((CharSequence)string, (char)'.', (int)(n3 - n - 1), (boolean)false, (int)4, null) != -1) return bl;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.hashAlgorithm);
        stringBuilder.append('/');
        stringBuilder.append(this.hash.base64());
        return stringBuilder.toString();
    }
}
