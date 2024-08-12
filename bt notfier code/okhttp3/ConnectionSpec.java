/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CipherSuite
 *  okhttp3.ConnectionSpec$Builder
 *  okhttp3.ConnectionSpec$Companion
 *  okhttp3.TlsVersion
 *  okhttp3.internal.Internal
 *  okhttp3.internal.Util
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.TlsVersion;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002%&B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0000\u00a2\u0006\u0002\b\u0019J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0017J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\"J\u0015\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\b#J\b\u0010$\u001a\u00020\u0007H\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010\u00a8\u0006'"}, d2={"Lokhttp3/ConnectionSpec;", "", "isTls", "", "supportsTlsExtensions", "cipherSuitesAsString", "", "", "tlsVersionsAsString", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "cipherSuites", "", "Lokhttp3/CipherSuite;", "()Ljava/util/List;", "getCipherSuitesAsString$okhttp", "()[Ljava/lang/String;", "[Ljava/lang/String;", "()Z", "tlsVersions", "Lokhttp3/TlsVersion;", "apply", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "-deprecated_cipherSuites", "equals", "other", "hashCode", "", "isCompatible", "socket", "supportedSpec", "-deprecated_supportsTlsExtensions", "-deprecated_tlsVersions", "toString", "Builder", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final Companion Companion;
    public static final ConnectionSpec MODERN_TLS;
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES;
    public static final ConnectionSpec RESTRICTED_TLS;
    private final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    private final String[] tlsVersionsAsString;

    static {
        Companion = new Companion(null);
        RESTRICTED_CIPHER_SUITES = new CipherSuite[]{CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
        APPROVED_CIPHER_SUITES = new CipherSuite[]{CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        CipherSuite[] cipherSuiteArray = new Builder(true);
        Builder builder = RESTRICTED_CIPHER_SUITES;
        RESTRICTED_TLS = cipherSuiteArray.cipherSuites(Arrays.copyOf(builder, ((CipherSuite[])builder).length)).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2}).supportsTlsExtensions(true).build();
        builder = new Builder(true);
        cipherSuiteArray = APPROVED_CIPHER_SUITES;
        MODERN_TLS = builder.cipherSuites(Arrays.copyOf(cipherSuiteArray, cipherSuiteArray.length)).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2}).supportsTlsExtensions(true).build();
        builder = new Builder(true);
        cipherSuiteArray = APPROVED_CIPHER_SUITES;
        COMPATIBLE_TLS = builder.cipherSuites(Arrays.copyOf(cipherSuiteArray, cipherSuiteArray.length)).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0}).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    public ConnectionSpec(boolean bl, boolean bl2, String[] stringArray, String[] stringArray2) {
        this.isTls = bl;
        this.supportsTlsExtensions = bl2;
        this.cipherSuitesAsString = stringArray;
        this.tlsVersionsAsString = stringArray2;
    }

    public static final /* synthetic */ String[] access$getTlsVersionsAsString$p(ConnectionSpec connectionSpec) {
        return connectionSpec.tlsVersionsAsString;
    }

    private final ConnectionSpec supportedSpec(SSLSocket stringArray, boolean bl) {
        String[] stringArray2 = stringArray.getEnabledCipherSuites();
        Intrinsics.checkNotNullExpressionValue((Object)stringArray2, (String)"socketEnabledCipherSuites");
        String[] stringArray3 = Internal.effectiveCipherSuites((ConnectionSpec)this, (String[])stringArray2);
        if (this.tlsVersionsAsString != null) {
            stringArray2 = stringArray.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue((Object)stringArray2, (String)"sslSocket.enabledProtocols");
            stringArray2 = Util.intersect((String[])stringArray2, (String[])this.tlsVersionsAsString, (Comparator)ComparisonsKt.naturalOrder());
        } else {
            stringArray2 = stringArray.getEnabledProtocols();
        }
        String[] stringArray4 = stringArray.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue((Object)stringArray4, (String)"supportedCipherSuites");
        int n = Util.indexOf((String[])stringArray4, (String)"TLS_FALLBACK_SCSV", (Comparator)CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        stringArray = stringArray3;
        if (bl) {
            stringArray = stringArray3;
            if (n != -1) {
                stringArray = stringArray4[n];
                Intrinsics.checkNotNullExpressionValue((Object)stringArray, (String)"supportedCipherSuites[indexOfFallbackScsv]");
                stringArray = Util.concat((String[])stringArray3, (String)stringArray);
            }
        }
        stringArray = new Builder(this).cipherSuites(Arrays.copyOf(stringArray, stringArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)stringArray2, (String)"tlsVersionsIntersection");
        return stringArray.tlsVersions(Arrays.copyOf(stringArray2, stringArray2.length)).build();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cipherSuites", imports={}))
    public final List<CipherSuite> _deprecated_cipherSuites() {
        return this.cipherSuites();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="supportsTlsExtensions", imports={}))
    public final boolean _deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="tlsVersions", imports={}))
    public final List<TlsVersion> _deprecated_tlsVersions() {
        return this.tlsVersions();
    }

    public final void apply$okhttp(SSLSocket sSLSocket, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        ConnectionSpec connectionSpec = this.supportedSpec(sSLSocket, bl);
        if (connectionSpec.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(connectionSpec.tlsVersionsAsString);
        }
        if (connectionSpec.cipherSuites() == null) return;
        sSLSocket.setEnabledCipherSuites(connectionSpec.cipherSuitesAsString);
    }

    public final List<CipherSuite> cipherSuites() {
        Collection collection;
        String[] stringArray = this.cipherSuitesAsString;
        if (stringArray == null) {
            collection = null;
        } else {
            collection = new ArrayList(stringArray.length);
            for (String string : stringArray) {
                collection.add(CipherSuite.Companion.forJavaName(string));
            }
            collection = CollectionsKt.toList((Iterable)((List)collection));
        }
        return collection;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConnectionSpec)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        boolean bl = this.isTls;
        object = (ConnectionSpec)object;
        if (bl != ((ConnectionSpec)object).isTls) {
            return false;
        }
        if (!bl) return true;
        if (!Arrays.equals(this.cipherSuitesAsString, ((ConnectionSpec)object).cipherSuitesAsString)) {
            return false;
        }
        if (!Arrays.equals(this.tlsVersionsAsString, ((ConnectionSpec)object).tlsVersionsAsString)) {
            return false;
        }
        if (this.supportsTlsExtensions == ((ConnectionSpec)object).supportsTlsExtensions) return true;
        return false;
    }

    public final String[] getCipherSuitesAsString$okhttp() {
        return this.cipherSuitesAsString;
    }

    public int hashCode() {
        int n;
        if (this.isTls) {
            Object[] objectArray = this.cipherSuitesAsString;
            int n2 = 0;
            n = objectArray == null ? 0 : Arrays.hashCode(objectArray);
            objectArray = this.tlsVersionsAsString;
            if (objectArray != null) {
                n2 = Arrays.hashCode(objectArray);
            }
            n = ((527 + n) * 31 + n2) * 31 + (this.supportsTlsExtensions ^ 1);
        } else {
            n = 17;
        }
        return n;
    }

    public final boolean isCompatible(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"socket");
        if (!this.isTls) {
            return false;
        }
        String[] stringArray = this.tlsVersionsAsString;
        if (stringArray != null && !Util.hasIntersection((String[])stringArray, (String[])sSLSocket.getEnabledProtocols(), (Comparator)ComparisonsKt.naturalOrder())) {
            return false;
        }
        stringArray = this.cipherSuitesAsString;
        if (stringArray == null) return true;
        if (Util.hasIntersection((String[])stringArray, (String[])sSLSocket.getEnabledCipherSuites(), (Comparator)CipherSuite.Companion.getORDER_BY_NAME$okhttp())) return true;
        return false;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final List<TlsVersion> tlsVersions() {
        Collection collection;
        String[] stringArray = this.tlsVersionsAsString;
        if (stringArray == null) {
            collection = null;
        } else {
            collection = new ArrayList(stringArray.length);
            for (String string : stringArray) {
                collection.add(TlsVersion.Companion.forJavaName(string));
            }
            collection = CollectionsKt.toList((Iterable)((List)collection));
        }
        return collection;
    }

    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionSpec(cipherSuites=");
        stringBuilder.append((Object)Objects.toString(this.cipherSuites(), "[all enabled]"));
        stringBuilder.append(", tlsVersions=");
        stringBuilder.append((Object)Objects.toString(this.tlsVersions(), "[all enabled]"));
        stringBuilder.append(", supportsTlsExtensions=");
        stringBuilder.append(this.supportsTlsExtensions);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
