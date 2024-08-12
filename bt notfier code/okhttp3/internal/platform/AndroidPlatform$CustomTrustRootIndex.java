/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.tls.TrustRootIndex
 */
package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\b\u001a\u00020\u0005H\u00c2\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "findByIssuerAndSignatureMethod", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "component2", "copy", "equals", "", "other", "", "findByIssuerAndSignature", "Ljava/security/cert/X509Certificate;", "cert", "hashCode", "", "toString", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class AndroidPlatform.CustomTrustRootIndex
implements TrustRootIndex {
    private final Method findByIssuerAndSignatureMethod;
    private final X509TrustManager trustManager;

    public AndroidPlatform.CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        Intrinsics.checkNotNullParameter((Object)method, (String)"findByIssuerAndSignatureMethod");
        this.trustManager = x509TrustManager;
        this.findByIssuerAndSignatureMethod = method;
    }

    private final X509TrustManager component1() {
        return this.trustManager;
    }

    private final Method component2() {
        return this.findByIssuerAndSignatureMethod;
    }

    public static /* synthetic */ AndroidPlatform.CustomTrustRootIndex copy$default(AndroidPlatform.CustomTrustRootIndex customTrustRootIndex, X509TrustManager x509TrustManager, Method method, int n, Object object) {
        if ((n & 1) != 0) {
            x509TrustManager = customTrustRootIndex.trustManager;
        }
        if ((n & 2) == 0) return customTrustRootIndex.copy(x509TrustManager, method);
        method = customTrustRootIndex.findByIssuerAndSignatureMethod;
        return customTrustRootIndex.copy(x509TrustManager, method);
    }

    public final AndroidPlatform.CustomTrustRootIndex copy(X509TrustManager x509TrustManager, Method method) {
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        Intrinsics.checkNotNullParameter((Object)method, (String)"findByIssuerAndSignatureMethod");
        return new AndroidPlatform.CustomTrustRootIndex(x509TrustManager, method);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AndroidPlatform.CustomTrustRootIndex)) {
            return false;
        }
        object = (AndroidPlatform.CustomTrustRootIndex)object;
        if (!Intrinsics.areEqual((Object)this.trustManager, (Object)((AndroidPlatform.CustomTrustRootIndex)object).trustManager)) {
            return false;
        }
        if (Intrinsics.areEqual((Object)this.findByIssuerAndSignatureMethod, (Object)((AndroidPlatform.CustomTrustRootIndex)object).findByIssuerAndSignatureMethod)) return true;
        return false;
    }

    public X509Certificate findByIssuerAndSignature(X509Certificate object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"cert");
        try {
            object = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, object);
            if (object == null) {
                object = new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
                throw object;
            }
            object = ((TrustAnchor)object).getTrustedCert();
        }
        catch (InvocationTargetException invocationTargetException) {
            object = null;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("unable to get issues and signature", illegalAccessException);
        }
        return object;
    }

    public int hashCode() {
        return this.trustManager.hashCode() * 31 + this.findByIssuerAndSignatureMethod.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomTrustRootIndex(trustManager=");
        stringBuilder.append(this.trustManager);
        stringBuilder.append(", findByIssuerAndSignatureMethod=");
        stringBuilder.append(this.findByIssuerAndSignatureMethod);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
