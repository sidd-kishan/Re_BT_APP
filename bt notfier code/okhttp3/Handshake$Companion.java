/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CipherSuite
 *  okhttp3.Handshake
 *  okhttp3.TlsVersion
 *  okhttp3.internal.Util
 */
package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0007J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0011\u0010\u0010\u001a\u00020\u0004*\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0003J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0012H\u0002\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lokhttp3/Handshake$Companion;", "", "()V", "get", "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Handshake.Companion {
    private Handshake.Companion() {
    }

    public /* synthetic */ Handshake.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final List<Certificate> toImmutableList(Certificate[] object) {
        object = object != null ? Util.immutableListOf((Object[])Arrays.copyOf(object, ((Certificate[])object).length)) : CollectionsKt.emptyList();
        return object;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="sslSession.handshake()", imports={}))
    public final Handshake _deprecated_get(SSLSession sSLSession) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sSLSession, (String)"sslSession");
        return this.get(sSLSession);
    }

    @JvmStatic
    public final Handshake get(SSLSession sSLSession) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sSLSession, (String)"<this>");
        Object object = sSLSession.getCipherSuite();
        if (object == null) throw (Throwable)new IllegalStateException("cipherSuite == null".toString());
        boolean bl = Intrinsics.areEqual((Object)object, (Object)"TLS_NULL_WITH_NULL_NULL") ? true : Intrinsics.areEqual((Object)object, (Object)"SSL_NULL_WITH_NULL_NULL");
        if (bl) throw new IOException(Intrinsics.stringPlus((String)"cipherSuite == ", (Object)object));
        CipherSuite cipherSuite = CipherSuite.Companion.forJavaName((String)object);
        object = sSLSession.getProtocol();
        if (object == null) throw (Throwable)new IllegalStateException("tlsVersion == null".toString());
        if (Intrinsics.areEqual((Object)"NONE", (Object)object)) throw new IOException("tlsVersion == NONE");
        TlsVersion tlsVersion = TlsVersion.Companion.forJavaName((String)object);
        try {
            object = this.toImmutableList(sSLSession.getPeerCertificates());
        }
        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
            object = CollectionsKt.emptyList();
        }
        return new Handshake(tlsVersion, cipherSuite, this.toImmutableList(sSLSession.getLocalCertificates()), (Function0)new /* Unavailable Anonymous Inner Class!! */);
    }

    @JvmStatic
    public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        Intrinsics.checkNotNullParameter((Object)tlsVersion, (String)"tlsVersion");
        Intrinsics.checkNotNullParameter((Object)cipherSuite, (String)"cipherSuite");
        Intrinsics.checkNotNullParameter(list, (String)"peerCertificates");
        Intrinsics.checkNotNullParameter(list2, (String)"localCertificates");
        list = Util.toImmutableList(list);
        return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list2), (Function0)new /* Unavailable Anonymous Inner Class!! */);
    }
}
