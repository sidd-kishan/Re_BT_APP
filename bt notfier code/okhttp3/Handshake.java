/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CipherSuite
 *  okhttp3.Handshake$Companion
 *  okhttp3.TlsVersion
 */
package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSession;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.TlsVersion;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\u0002\u0010\u000bJ\r\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u00a2\u0006\u0002\b J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u00a2\u0006\u0002\b!J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u00a2\u0006\u0002\b\"J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007\u00a2\u0006\u0002\b#J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0017H\u0016R\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8G\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8G\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006'"}, d2={"Lokhttp3/Handshake;", "", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "localCertificates", "", "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lkotlin/Function0;", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "localPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "peerCertificates", "peerCertificates$delegate", "Lkotlin/Lazy;", "peerPrincipal", "()Lokhttp3/TlsVersion;", "name", "", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "-deprecated_cipherSuite", "equals", "", "other", "hashCode", "", "-deprecated_localCertificates", "-deprecated_localPrincipal", "-deprecated_peerCertificates", "-deprecated_peerPrincipal", "-deprecated_tlsVersion", "toString", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Handshake {
    public static final Companion Companion = new Companion(null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final Lazy peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics.checkNotNullParameter((Object)tlsVersion, (String)"tlsVersion");
        Intrinsics.checkNotNullParameter((Object)cipherSuite, (String)"cipherSuite");
        Intrinsics.checkNotNullParameter(list, (String)"localCertificates");
        Intrinsics.checkNotNullParameter(function0, (String)"peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = LazyKt.lazy((Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */));
    }

    @JvmStatic
    public static final Handshake get(SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    @JvmStatic
    public static final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }

    private final String getName(Certificate object) {
        if (object instanceof X509Certificate) {
            object = ((Object)((X509Certificate)object).getSubjectDN()).toString();
        } else {
            object = ((Certificate)object).getType();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"type");
        }
        return object;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cipherSuite", imports={}))
    public final CipherSuite _deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="localCertificates", imports={}))
    public final List<Certificate> _deprecated_localCertificates() {
        return this.localCertificates;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="localPrincipal", imports={}))
    public final Principal _deprecated_localPrincipal() {
        return this.localPrincipal();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="peerCertificates", imports={}))
    public final List<Certificate> _deprecated_peerCertificates() {
        return this.peerCertificates();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="peerPrincipal", imports={}))
    public final Principal _deprecated_peerPrincipal() {
        return this.peerPrincipal();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="tlsVersion", imports={}))
    public final TlsVersion _deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof Handshake)) return false;
        object = (Handshake)object;
        if (((Handshake)object).tlsVersion != this.tlsVersion) return false;
        if (!Intrinsics.areEqual((Object)((Handshake)object).cipherSuite, (Object)this.cipherSuite)) return false;
        if (!Intrinsics.areEqual(((Handshake)object).peerCertificates(), this.peerCertificates())) return false;
        if (!Intrinsics.areEqual(((Handshake)object).localCertificates, this.localCertificates)) return false;
        return true;
    }

    public int hashCode() {
        return (((527 + this.tlsVersion.hashCode()) * 31 + this.cipherSuite.hashCode()) * 31 + ((Object)this.peerCertificates()).hashCode()) * 31 + ((Object)this.localCertificates).hashCode();
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object object = CollectionsKt.firstOrNull(this.localCertificates);
        boolean bl = object instanceof X509Certificate;
        Object var3_3 = null;
        object = bl ? (X509Certificate)object : null;
        object = object == null ? var3_3 : ((X509Certificate)object).getSubjectX500Principal();
        return (Principal)object;
    }

    public final List<Certificate> peerCertificates() {
        return (List)this.peerCertificates$delegate.getValue();
    }

    public final Principal peerPrincipal() {
        Object object = CollectionsKt.firstOrNull(this.peerCertificates());
        boolean bl = object instanceof X509Certificate;
        Object var3_3 = null;
        object = bl ? (X509Certificate)object : null;
        object = object == null ? var3_3 : ((X509Certificate)object).getSubjectX500Principal();
        return (Principal)object;
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        Object object = this.peerCertificates();
        Object object2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            object2.add(this.getName((Certificate)object.next()));
        }
        object = ((List)object2).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Handshake{tlsVersion=");
        ((StringBuilder)object2).append(this.tlsVersion);
        ((StringBuilder)object2).append(" cipherSuite=");
        ((StringBuilder)object2).append(this.cipherSuite);
        ((StringBuilder)object2).append(" peerCertificates=");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" localCertificates=");
        Object object3 = this.localCertificates;
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object3, (int)10));
        object3 = object3.iterator();
        while (true) {
            if (!object3.hasNext()) {
                ((StringBuilder)object2).append((List)object);
                ((StringBuilder)object2).append('}');
                return ((StringBuilder)object2).toString();
            }
            object.add(this.getName((Certificate)object3.next()));
        }
    }
}
