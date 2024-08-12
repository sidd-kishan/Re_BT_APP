/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.internal.HostnamesKt
 *  okhttp3.internal.Util
 *  okio.Utf8
 */
package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\bH\u0002J\f\u0010\u0018\u001a\u00020\u000e*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "asciiToLowercase", "isAscii", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class OkHostnameVerifier
implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String string) {
        Object object = string;
        if (!this.isAscii(string)) return object;
        object = Locale.US;
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"US");
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = string.toLowerCase((Locale)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).toLowerCase(locale)");
        return object;
    }

    private final List<String> getSubjectAltNames(X509Certificate object, int n) {
        try {
            Object object2 = ((X509Certificate)object).getSubjectAlternativeNames();
            if (object2 == null) {
                return CollectionsKt.emptyList();
            }
            object = new ArrayList();
            object = (List)object;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                List list = (List)object2.next();
                if (list == null || list.size() < 2 || !Intrinsics.areEqual(list.get(0), (Object)n) || (list = list.get(1)) == null) continue;
                object.add((String)((Object)list));
            }
            return object;
        }
        catch (CertificateParsingException certificateParsingException) {
            return CollectionsKt.emptyList();
        }
    }

    private final boolean isAscii(String string) {
        int n = string.length();
        boolean bl = false;
        if (n != (int)Utf8.size$default((String)string, (int)0, (int)0, (int)3, null)) return bl;
        bl = true;
        return bl;
    }

    private final boolean verifyHostname(String string, String charSequence) {
        CharSequence charSequence2 = string;
        int n = charSequence2 != null && charSequence2.length() != 0 ? 0 : 1;
        if (n != 0) return false;
        if (StringsKt.startsWith$default((String)string, (String)".", (boolean)false, (int)2, null)) return false;
        if (StringsKt.endsWith$default((String)string, (String)"..", (boolean)false, (int)2, null)) return false;
        charSequence2 = charSequence;
        n = charSequence2 != null && charSequence2.length() != 0 ? 0 : 1;
        if (n != 0) return false;
        if (StringsKt.startsWith$default((String)charSequence, (String)".", (boolean)false, (int)2, null)) return false;
        if (StringsKt.endsWith$default((String)charSequence, (String)"..", (boolean)false, (int)2, null)) return false;
        charSequence2 = string;
        if (!StringsKt.endsWith$default((String)string, (String)".", (boolean)false, (int)2, null)) {
            charSequence2 = Intrinsics.stringPlus((String)string, (Object)".");
        }
        string = charSequence;
        if (!StringsKt.endsWith$default((String)charSequence, (String)".", (boolean)false, (int)2, null)) {
            string = Intrinsics.stringPlus((String)charSequence, (Object)".");
        }
        if (!StringsKt.contains$default((CharSequence)(charSequence = (CharSequence)(string = this.asciiToLowercase(string))), (CharSequence)"*", (boolean)false, (int)2, null)) {
            return Intrinsics.areEqual((Object)charSequence2, (Object)string);
        }
        if (!StringsKt.startsWith$default((String)string, (String)"*.", (boolean)false, (int)2, null)) return false;
        if (StringsKt.indexOf$default((CharSequence)charSequence, (char)'*', (int)1, (boolean)false, (int)4, null) != -1) return false;
        if (((String)charSequence2).length() < string.length()) {
            return false;
        }
        if (Intrinsics.areEqual((Object)"*.", (Object)string)) {
            return false;
        }
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        if (!StringsKt.endsWith$default((String)charSequence2, (String)string, (boolean)false, (int)2, null)) {
            return false;
        }
        n = ((String)charSequence2).length() - string.length();
        if (n <= 0) return true;
        if (StringsKt.lastIndexOf$default((CharSequence)charSequence2, (char)'.', (int)(n - 1), (boolean)false, (int)4, null) == -1) return true;
        return false;
    }

    private final boolean verifyHostname(String string, X509Certificate object) {
        string = this.asciiToLowercase(string);
        object = this.getSubjectAltNames((X509Certificate)object, 2);
        boolean bl = object instanceof Collection;
        boolean bl2 = false;
        if (bl && ((Collection)object).isEmpty()) {
            bl = bl2;
        } else {
            Iterator iterator = object.iterator();
            do {
                bl = bl2;
                if (!iterator.hasNext()) return bl;
            } while (!INSTANCE.verifyHostname(string, (String)(object = (String)iterator.next())));
            bl = true;
        }
        return bl;
    }

    private final boolean verifyIpAddress(String string, X509Certificate iterator) {
        string = HostnamesKt.toCanonicalHost((String)string);
        iterator = this.getSubjectAltNames((X509Certificate)((Object)iterator), 7);
        boolean bl = iterator instanceof Collection;
        boolean bl2 = false;
        if (bl && ((Collection)((Object)iterator)).isEmpty()) {
            bl = bl2;
        } else {
            iterator = iterator.iterator();
            do {
                bl = bl2;
                if (!iterator.hasNext()) return bl;
            } while (!Intrinsics.areEqual((Object)string, (Object)HostnamesKt.toCanonicalHost((String)((String)iterator.next()))));
            bl = true;
        }
        return bl;
    }

    public final List<String> allSubjectAltNames(X509Certificate object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"certificate");
        List<String> list = this.getSubjectAltNames((X509Certificate)object, 7);
        object = this.getSubjectAltNames((X509Certificate)object, 2);
        return CollectionsKt.plus((Collection)list, (Iterable)((Iterable)object));
    }

    public final boolean verify(String string, X509Certificate x509Certificate) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"host");
        Intrinsics.checkNotNullParameter((Object)x509Certificate, (String)"certificate");
        boolean bl = Util.canParseAsIpAddress((String)string) ? this.verifyIpAddress(string, x509Certificate) : this.verifyHostname(string, x509Certificate);
        return bl;
    }

    @Override
    public boolean verify(String object, SSLSession object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"host");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"session");
        boolean bl = this.isAscii((String)object);
        boolean bl2 = false;
        if (!bl) return bl2;
        try {
            object2 = object2.getPeerCertificates()[0];
            if (object2 == null) {
                object = new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                throw object;
            }
            bl2 = bl = this.verify((String)object, (X509Certificate)object2);
        }
        catch (SSLException sSLException) {}
        return bl2;
    }
}
