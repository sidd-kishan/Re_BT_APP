/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.CipherSuite$Companion
 */
package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.CipherSuite;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\t"}, d2={"Lokhttp3/CipherSuite;", "", "javaName", "", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "toString", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class CipherSuite {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, CipherSuite> INSTANCES;
    private static final Comparator<String> ORDER_BY_NAME;
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256;
    public static final CipherSuite TLS_AES_128_CCM_SHA256;
    public static final CipherSuite TLS_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    public static final CipherSuite TLS_FALLBACK_SCSV;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5;
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256;
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;
    private final String javaName;

    static {
        ORDER_BY_NAME = (Comparator)new /* Unavailable Anonymous Inner Class!! */;
        INSTANCES = new LinkedHashMap();
        TLS_RSA_WITH_NULL_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_WITH_NULL_MD5", (int)1);
        TLS_RSA_WITH_NULL_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_WITH_NULL_SHA", (int)2);
        TLS_RSA_EXPORT_WITH_RC4_40_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_EXPORT_WITH_RC4_40_MD5", (int)3);
        TLS_RSA_WITH_RC4_128_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_WITH_RC4_128_MD5", (int)4);
        TLS_RSA_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_WITH_RC4_128_SHA", (int)5);
        TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", (int)8);
        TLS_RSA_WITH_DES_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_WITH_DES_CBC_SHA", (int)9);
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_RSA_WITH_3DES_EDE_CBC_SHA", (int)10);
        TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", (int)17);
        TLS_DHE_DSS_WITH_DES_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DHE_DSS_WITH_DES_CBC_SHA", (int)18);
        TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", (int)19);
        TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", (int)20);
        TLS_DHE_RSA_WITH_DES_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DHE_RSA_WITH_DES_CBC_SHA", (int)21);
        TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", (int)22);
        TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", (int)23);
        TLS_DH_anon_WITH_RC4_128_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DH_anon_WITH_RC4_128_MD5", (int)24);
        TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", (int)25);
        TLS_DH_anon_WITH_DES_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DH_anon_WITH_DES_CBC_SHA", (int)26);
        TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", (int)27);
        TLS_KRB5_WITH_DES_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_WITH_DES_CBC_SHA", (int)30);
        TLS_KRB5_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_WITH_3DES_EDE_CBC_SHA", (int)31);
        TLS_KRB5_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_WITH_RC4_128_SHA", (int)32);
        TLS_KRB5_WITH_DES_CBC_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_WITH_DES_CBC_MD5", (int)34);
        TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_WITH_3DES_EDE_CBC_MD5", (int)35);
        TLS_KRB5_WITH_RC4_128_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_WITH_RC4_128_MD5", (int)36);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", (int)38);
        TLS_KRB5_EXPORT_WITH_RC4_40_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_EXPORT_WITH_RC4_40_SHA", (int)40);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", (int)41);
        TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_KRB5_EXPORT_WITH_RC4_40_MD5", (int)43);
        TLS_RSA_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_AES_128_CBC_SHA", (int)47);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", (int)50);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_AES_128_CBC_SHA", (int)51);
        TLS_DH_anon_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DH_anon_WITH_AES_128_CBC_SHA", (int)52);
        TLS_RSA_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_AES_256_CBC_SHA", (int)53);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_AES_256_CBC_SHA", (int)56);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_AES_256_CBC_SHA", (int)57);
        TLS_DH_anon_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DH_anon_WITH_AES_256_CBC_SHA", (int)58);
        TLS_RSA_WITH_NULL_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_NULL_SHA256", (int)59);
        TLS_RSA_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_AES_128_CBC_SHA256", (int)60);
        TLS_RSA_WITH_AES_256_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_AES_256_CBC_SHA256", (int)61);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", (int)64);
        TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", (int)65);
        TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", (int)68);
        TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", (int)69);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", (int)103);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", (int)106);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", (int)107);
        TLS_DH_anon_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DH_anon_WITH_AES_128_CBC_SHA256", (int)108);
        TLS_DH_anon_WITH_AES_256_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DH_anon_WITH_AES_256_CBC_SHA256", (int)109);
        TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", (int)132);
        TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", (int)135);
        TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", (int)136);
        TLS_PSK_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_PSK_WITH_RC4_128_SHA", (int)138);
        TLS_PSK_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_PSK_WITH_3DES_EDE_CBC_SHA", (int)139);
        TLS_PSK_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_PSK_WITH_AES_128_CBC_SHA", (int)140);
        TLS_PSK_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_PSK_WITH_AES_256_CBC_SHA", (int)141);
        TLS_RSA_WITH_SEED_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_SEED_CBC_SHA", (int)150);
        TLS_RSA_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_AES_128_GCM_SHA256", (int)156);
        TLS_RSA_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_RSA_WITH_AES_256_GCM_SHA384", (int)157);
        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", (int)158);
        TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", (int)159);
        TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", (int)162);
        TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", (int)163);
        TLS_DH_anon_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DH_anon_WITH_AES_128_GCM_SHA256", (int)166);
        TLS_DH_anon_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DH_anon_WITH_AES_256_GCM_SHA384", (int)167);
        TLS_EMPTY_RENEGOTIATION_INFO_SCSV = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_EMPTY_RENEGOTIATION_INFO_SCSV", (int)255);
        TLS_FALLBACK_SCSV = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_FALLBACK_SCSV", (int)22016);
        TLS_ECDH_ECDSA_WITH_NULL_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_NULL_SHA", (int)49153);
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_RC4_128_SHA", (int)49154);
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", (int)49155);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", (int)49156);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", (int)49157);
        TLS_ECDHE_ECDSA_WITH_NULL_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_NULL_SHA", (int)49158);
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", (int)49159);
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", (int)49160);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", (int)49161);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", (int)49162);
        TLS_ECDH_RSA_WITH_NULL_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_NULL_SHA", (int)49163);
        TLS_ECDH_RSA_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_RC4_128_SHA", (int)49164);
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", (int)49165);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", (int)49166);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", (int)49167);
        TLS_ECDHE_RSA_WITH_NULL_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_NULL_SHA", (int)49168);
        TLS_ECDHE_RSA_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_RC4_128_SHA", (int)49169);
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", (int)49170);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", (int)49171);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", (int)49172);
        TLS_ECDH_anon_WITH_NULL_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_anon_WITH_NULL_SHA", (int)49173);
        TLS_ECDH_anon_WITH_RC4_128_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_anon_WITH_RC4_128_SHA", (int)49174);
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", (int)49175);
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_anon_WITH_AES_128_CBC_SHA", (int)49176);
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_anon_WITH_AES_256_CBC_SHA", (int)49177);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", (int)49187);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", (int)49188);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", (int)49189);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", (int)49190);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", (int)49191);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", (int)49192);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", (int)49193);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", (int)49194);
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", (int)49195);
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", (int)49196);
        TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", (int)49197);
        TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", (int)49198);
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", (int)49199);
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", (int)49200);
        TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", (int)49201);
        TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", (int)49202);
        TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", (int)49205);
        TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", (int)49206);
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", (int)52392);
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", (int)52393);
        TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", (int)52394);
        TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", (int)52396);
        TLS_AES_128_GCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_AES_128_GCM_SHA256", (int)4865);
        TLS_AES_256_GCM_SHA384 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_AES_256_GCM_SHA384", (int)4866);
        TLS_CHACHA20_POLY1305_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_CHACHA20_POLY1305_SHA256", (int)4867);
        TLS_AES_128_CCM_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_AES_128_CCM_SHA256", (int)4868);
        TLS_AES_128_CCM_8_SHA256 = okhttp3.CipherSuite$Companion.access$init((Companion)Companion, (String)"TLS_AES_128_CCM_8_SHA256", (int)4869);
    }

    private CipherSuite(String string) {
        this.javaName = string;
    }

    public /* synthetic */ CipherSuite(String string, DefaultConstructorMarker defaultConstructorMarker) {
        this(string);
    }

    public static final /* synthetic */ Map access$getINSTANCES$cp() {
        return INSTANCES;
    }

    public static final /* synthetic */ Comparator access$getORDER_BY_NAME$cp() {
        return ORDER_BY_NAME;
    }

    @JvmStatic
    public static final CipherSuite forJavaName(String object) {
        synchronized (CipherSuite.class) {
            object = Companion.forJavaName((String)object);
            return object;
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="javaName", imports={}))
    public final String _deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }
}
