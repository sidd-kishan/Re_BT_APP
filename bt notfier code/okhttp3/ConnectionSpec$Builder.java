/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CipherSuite
 *  okhttp3.ConnectionSpec
 *  okhttp3.TlsVersion
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.TlsVersion;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u0006J\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n\u00a2\u0006\u0002\u0010\u001cJ\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\t\"\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0007J\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n\u00a2\u0006\u0002\u0010\u001cJ\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\t\"\u00020\u001f\u00a2\u0006\u0002\u0010 R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e\u00a8\u0006!"}, d2={"Lokhttp3/ConnectionSpec$Builder;", "", "tls", "", "(Z)V", "connectionSpec", "Lokhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "cipherSuites", "", "", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "getTls$okhttp", "setTls$okhttp", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "allEnabledCipherSuites", "allEnabledTlsVersions", "build", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ConnectionSpec.Builder {
    private String[] cipherSuites;
    private boolean supportsTlsExtensions;
    private boolean tls;
    private String[] tlsVersions;

    public ConnectionSpec.Builder(ConnectionSpec connectionSpec) {
        Intrinsics.checkNotNullParameter((Object)connectionSpec, (String)"connectionSpec");
        this.tls = connectionSpec.isTls();
        this.cipherSuites = connectionSpec.getCipherSuitesAsString$okhttp();
        this.tlsVersions = ConnectionSpec.access$getTlsVersionsAsString$p((ConnectionSpec)connectionSpec);
        this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
    }

    public ConnectionSpec.Builder(boolean bl) {
        this.tls = bl;
    }

    public final ConnectionSpec.Builder allEnabledCipherSuites() {
        ConnectionSpec.Builder builder = this;
        if (!builder.getTls$okhttp()) throw (Throwable)new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        builder.setCipherSuites$okhttp(null);
        return builder;
    }

    public final ConnectionSpec.Builder allEnabledTlsVersions() {
        ConnectionSpec.Builder builder = this;
        if (!builder.getTls$okhttp()) throw (Throwable)new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        builder.setTlsVersions$okhttp(null);
        return builder;
    }

    public final ConnectionSpec build() {
        return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
    }

    public final ConnectionSpec.Builder cipherSuites(String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"cipherSuites");
        ConnectionSpec.Builder builder = this;
        if (!builder.getTls$okhttp()) throw (Throwable)new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        boolean bl = stringArray.length == 0;
        if (!(bl ^ true)) throw (Throwable)new IllegalArgumentException("At least one cipher suite is required".toString());
        builder.setCipherSuites$okhttp((String[])stringArray.clone());
        return builder;
    }

    public final ConnectionSpec.Builder cipherSuites(CipherSuite ... object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"cipherSuites");
        ConnectionSpec.Builder builder = this;
        if (!builder.getTls$okhttp()) {
            object = new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            throw object;
        }
        Collection collection = new ArrayList(((CipherSuite[])object).length);
        int n = ((CipherSuite[])object).length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object = ((Collection)((List)collection)).toArray(new String[0]);
                if (object == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                object = (String[])object;
                return builder.cipherSuites((String[])Arrays.copyOf(object, ((CipherSuite[])object).length));
            }
            collection.add(object[n2].javaName());
            ++n2;
        }
    }

    public final String[] getCipherSuites$okhttp() {
        return this.cipherSuites;
    }

    public final boolean getSupportsTlsExtensions$okhttp() {
        return this.supportsTlsExtensions;
    }

    public final boolean getTls$okhttp() {
        return this.tls;
    }

    public final String[] getTlsVersions$okhttp() {
        return this.tlsVersions;
    }

    public final void setCipherSuites$okhttp(String[] stringArray) {
        this.cipherSuites = stringArray;
    }

    public final void setSupportsTlsExtensions$okhttp(boolean bl) {
        this.supportsTlsExtensions = bl;
    }

    public final void setTls$okhttp(boolean bl) {
        this.tls = bl;
    }

    public final void setTlsVersions$okhttp(String[] stringArray) {
        this.tlsVersions = stringArray;
    }

    @Deprecated(message="since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
    public final ConnectionSpec.Builder supportsTlsExtensions(boolean bl) {
        ConnectionSpec.Builder builder = this;
        if (!builder.getTls$okhttp()) throw (Throwable)new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        builder.setSupportsTlsExtensions$okhttp(bl);
        return builder;
    }

    public final ConnectionSpec.Builder tlsVersions(String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tlsVersions");
        ConnectionSpec.Builder builder = this;
        if (!builder.getTls$okhttp()) throw (Throwable)new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        boolean bl = stringArray.length == 0;
        if (!(bl ^ true)) throw (Throwable)new IllegalArgumentException("At least one TLS version is required".toString());
        builder.setTlsVersions$okhttp((String[])stringArray.clone());
        return builder;
    }

    public final ConnectionSpec.Builder tlsVersions(TlsVersion ... object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"tlsVersions");
        ConnectionSpec.Builder builder = this;
        if (!builder.getTls$okhttp()) {
            object = new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            throw object;
        }
        Collection collection = new ArrayList(((TlsVersion[])object).length);
        int n = ((TlsVersion[])object).length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object = ((Collection)((List)collection)).toArray(new String[0]);
                if (object == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                object = (String[])object;
                return builder.tlsVersions((String[])Arrays.copyOf(object, ((TlsVersion[])object).length));
            }
            collection.add(object[n2].javaName());
            ++n2;
        }
    }
}
