/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 *  okhttp3.CertificatePinner$Builder
 *  okhttp3.CertificatePinner$Companion
 *  okhttp3.CertificatePinner$Pin
 *  okhttp3.internal.tls.CertificateChainCleaner
 *  okio.ByteString
 */
package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.CertificatePinner;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0000\u00a2\u0006\u0002\b\u0014J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0007\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006$"}, d2={"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "getPins", "()Ljava/util/Set;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(set, (String)"pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            certificateChainCleaner = null;
        }
        this(set, certificateChainCleaner);
    }

    @JvmStatic
    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    @JvmStatic
    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @JvmStatic
    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String string, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hostname");
        Intrinsics.checkNotNullParameter(list, (String)"peerCertificates");
        this.check$okhttp(string, (Function0<? extends List<? extends X509Certificate>>)((Function0)new /* Unavailable Anonymous Inner Class!! */));
    }

    @Deprecated(message="replaced with {@link #check(String, List)}.", replaceWith=@ReplaceWith(expression="check(hostname, peerCertificates.toList())", imports={}))
    public final void check(String string, Certificate ... certificateArray) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hostname");
        Intrinsics.checkNotNullParameter((Object)certificateArray, (String)"peerCertificates");
        this.check(string, ArraysKt.toList((Object[])certificateArray));
    }

    /*
     * Unable to fully structure code
     */
    public final void check$okhttp(String var1_1, Function0<? extends List<? extends X509Certificate>> var2_2) {
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"hostname");
        Intrinsics.checkNotNullParameter(var2_2, (String)"cleanedPeerCertificatesFn");
        var5_3 = this.findMatchingPins((String)var1_1);
        if (var5_3.isEmpty()) {
            return;
        }
        var6_4 = (List)var2_2.invoke();
        var8_5 = var6_4.iterator();
        block0: while (true) {
            if (!var8_5.hasNext()) {
                var2_2 = new StringBuilder();
                var2_2.append("Certificate pinning failure!");
                var2_2.append("\n  Peer certificate chain:");
                for (Object var4_7 : var6_4) {
                    var2_2.append("\n    ");
                    var2_2.append(CertificatePinner.Companion.pin((Certificate)var4_7));
                    var2_2.append(": ");
                    var2_2.append(var4_7.getSubjectDN().getName());
                }
                var2_2.append("\n  Pinned certificates for ");
                var2_2.append((String)var1_1);
                var2_2.append(":");
                var3_6 = var5_3.iterator();
                while (true) {
                    if (!var3_6.hasNext()) {
                        var1_1 = var2_2.toString();
                        Intrinsics.checkNotNullExpressionValue((Object)var1_1, (String)"StringBuilder().apply(builderAction).toString()");
                        var1_1 = new SSLPeerUnverifiedException((String)var1_1);
                        throw var1_1;
                    }
                    var1_1 = (Pin)var3_6.next();
                    var2_2.append("\n    ");
                    var2_2.append(var1_1);
                }
            }
            var7_8 = (X509Certificate)var8_5.next();
            var9_9 = var5_3.iterator();
            var3_6 = null;
            var2_2 = null;
            do lbl-1000:
            // 3 sources

            {
                block9: {
                    if (!var9_9.hasNext()) continue block0;
                    var10_10 = var9_9.next();
                    var4_7 = var10_10.getHashAlgorithm();
                    if (!Intrinsics.areEqual((Object)var4_7, (Object)"sha256")) break block9;
                    var4_7 = var3_6;
                    if (var3_6 == null) {
                        var4_7 = CertificatePinner.Companion.sha256Hash(var7_8);
                    }
                    var3_6 = var4_7;
                    if (!Intrinsics.areEqual((Object)var10_10.getHash(), (Object)var4_7)) ** GOTO lbl-1000
                    return;
                }
                if (Intrinsics.areEqual(var4_7, (Object)"sha1") == false) throw new AssertionError((Object)Intrinsics.stringPlus((String)"unsupported hashAlgorithm: ", (Object)var10_10.getHashAlgorithm()));
                var4_7 = var2_2;
                if (var2_2 == null) {
                    var4_7 = CertificatePinner.Companion.sha1Hash(var7_8);
                }
                var2_2 = var4_7;
            } while (!Intrinsics.areEqual((Object)var10_10.getHash(), (Object)var4_7));
            break;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof CertificatePinner)) return false;
        object = (CertificatePinner)object;
        if (!Intrinsics.areEqual(((CertificatePinner)object).pins, this.pins)) return false;
        if (!Intrinsics.areEqual((Object)((CertificatePinner)object).certificateChainCleaner, (Object)this.certificateChainCleaner)) return false;
        return true;
    }

    public final List<Pin> findMatchingPins(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hostname");
        Iterable iterable = this.pins;
        Iterable iterable2 = CollectionsKt.emptyList();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t = iterator.next();
            if (!((Pin)t).matchesHostname(string)) continue;
            iterable = iterable2;
            if (iterable2.isEmpty()) {
                iterable = new ArrayList();
            }
            TypeIntrinsics.asMutableList((Object)iterable).add(t);
            iterable2 = iterable;
        }
        return iterable2;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int n = ((Object)this.pins).hashCode();
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        int n2 = certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0;
        return (1517 + n) * 41 + n2;
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"certificateChainCleaner");
        object = Intrinsics.areEqual((Object)this.certificateChainCleaner, (Object)object) ? this : new CertificatePinner(this.pins, (CertificateChainCleaner)object);
        return object;
    }
}
