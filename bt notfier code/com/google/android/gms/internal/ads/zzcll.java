/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzak
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzat
 *  com.google.android.gms.internal.ads.zzau
 *  com.google.android.gms.internal.ads.zzav
 *  com.google.android.gms.internal.ads.zzaw
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzclk
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzak;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzat;
import com.google.android.gms.internal.ads.zzau;
import com.google.android.gms.internal.ads.zzav;
import com.google.android.gms.internal.ads.zzaw;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzclk;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

final class zzcll
extends zzag
implements zzaw {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzc = new AtomicReference();
    private final SSLSocketFactory zzd = new zzclk(this);
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzav zzh;
    private zzan zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private int zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private int zzr;
    private final Set<Socket> zzs = new HashSet<Socket>();

    zzcll(String string, zzay zzay2, int n, int n2, int n3) {
        super(true);
        zzakt.zzf((String)string);
        this.zzg = string;
        this.zzh = new zzav();
        this.zze = n;
        this.zzf = n2;
        this.zzr = n3;
        if (zzay2 == null) return;
        this.zza(zzay2);
    }

    static /* synthetic */ int zzk(zzcll zzcll2) {
        return zzcll2.zzr;
    }

    static /* synthetic */ void zzm(zzcll zzcll2, Socket socket) {
        zzcll2.zzs.add(socket);
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) return;
        try {
            httpURLConnection.disconnect();
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unexpected error while disconnecting", (Throwable)exception);
        }
        this.zzj = null;
    }

    public final Map<String, List<String>> zzf() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) return httpURLConnection.getHeaderFields();
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public final int zzg(byte[] object, int n, int n2) throws zzat {
        try {
            int n3;
            void var3_8;
            long l = this.zzp;
            long l2 = this.zzn;
            int n4 = 0;
            if (l != l2) {
                byte[] byArray;
                byte[] byArray2 = byArray = (byte[])zzc.getAndSet(null);
                if (byArray == null) {
                    byArray2 = new byte[4096];
                }
                while ((l = this.zzp) != (l2 = this.zzn)) {
                    int n5 = (int)Math.min(l2 - l, (long)byArray2.length);
                    n5 = this.zzk.read(byArray2, 0, n5);
                    if (Thread.interrupted()) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException();
                        throw interruptedIOException;
                    }
                    if (n5 == -1) {
                        EOFException eOFException = new EOFException();
                        throw eOFException;
                    }
                    this.zzp += (long)n5;
                    this.zzd(n5);
                }
                zzc.set(byArray2);
            }
            if (var3_8 == false) {
                return n4;
            }
            l2 = this.zzo;
            n4 = var3_8;
            if (l2 != -1L) {
                if ((l2 -= this.zzq) == 0L) return -1;
                n4 = (int)Math.min((long)var3_8, l2);
            }
            if ((n3 = this.zzk.read((byte[])object, n3, n4)) != -1) {
                this.zzq += (long)n3;
                this.zzd(n3);
                return n3;
            }
            if (this.zzo == -1L) return -1;
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        catch (IOException iOException) {
            zzat zzat2 = new zzat(iOException, this.zzi, 2000, 2);
            throw zzat2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final long zzh(zzan var1_1) throws zzat {
        block32: {
            this.zzi = var1_1;
            this.zzq = 0L;
            this.zzp = 0L;
            try {
                var13_2 = new URL(var1_1.zza.toString());
                var14_5 = var1_1.zzc;
                var7_8 = var1_1.zzf;
                var5_9 = var1_1.zzg;
                var4_10 = var1_1.zzb(1);
                var2_11 = 0;
lbl11:
                // 2 sources

                while (true) {
                    var3_13 = var2_11 + 1;
                    if (var2_11 > 20) ** GOTO lbl168
                    var16_12 = (HttpURLConnection)var13_2.openConnection();
                    if (var16_12 instanceof HttpsURLConnection) {
                        ((HttpsURLConnection)var16_12).setSSLSocketFactory(this.zzd);
                    }
                    var16_12.setConnectTimeout(this.zze);
                    var16_12.setReadTimeout(this.zzf);
                    var15_15 = this.zzh.zza().entrySet().iterator();
                    while (var15_15.hasNext()) {
                        var14_5 = var15_15.next();
                        var16_12.setRequestProperty((String)var14_5.getKey(), (String)var14_5.getValue());
                    }
                    var9_14 = -1L;
                    if (var7_8 != 0L || var5_9 != -1L) {
                        var14_5 = new StringBuilder(27);
                        var14_5.append("bytes=");
                        var14_5.append(var7_8);
                        var14_5.append("-");
                        var14_5 = var15_15 = var14_5.toString();
                        if (var5_9 != -1L) {
                            var2_11 = var15_15.length();
                            var14_5 = new StringBuilder(var2_11 + 20);
                            var14_5.append((String)var15_15);
                            var14_5.append(var7_8 + var5_9 - 1L);
                            var14_5 = var14_5.toString();
                        }
                        var16_12.setRequestProperty("Range", (String)var14_5);
                    }
                    var16_12.setRequestProperty("User-Agent", this.zzg);
                    if (!var4_10) {
                        var16_12.setRequestProperty("Accept-Encoding", "identity");
                    }
                    var16_12.setInstanceFollowRedirects(false);
                    var16_12.setDoOutput(false);
                    var16_12.connect();
                    var2_11 = var16_12.getResponseCode();
                    if (var2_11 != 300 && var2_11 != 301 && var2_11 != 302 && var2_11 != 303 && var2_11 != 307 && var2_11 != 308) {
                        this.zzj = var16_12;
                    }
                    ** GOTO lbl-1000
                    break;
                }
            }
            catch (IOException var14_7) {
                var13_2 = String.valueOf(var1_1.zza.toString());
                var13_2 = var13_2.length() != 0 ? "Unable to connect to ".concat((String)var13_2) : new String("Unable to connect to ");
                var1_1 = new zzat((String)var13_2, var14_7, var1_1, 1);
                throw var1_1;
            }
            try {
                this.zzm = var2_11 = var16_12.getResponseCode();
                if (var2_11 < 200 || var2_11 > 299) break block32;
                if (var2_11 != 200 || (var5_9 = var1_1.zzf) == 0L) {
                    var5_9 = 0L;
                }
                this.zzn = var5_9;
            }
            catch (IOException var14_6) {
                this.zzn();
                var13_2 = String.valueOf(var1_1.zza.toString());
                var13_2 = var13_2.length() != 0 ? "Unable to connect to ".concat((String)var13_2) : new String("Unable to connect to ");
                throw new zzat((String)var13_2, var14_6, var1_1, 1);
            }
            if (!var1_1.zzb(1)) {
                var5_9 = var1_1.zzg;
                if (var5_9 != -1L) {
                    this.zzo = var5_9;
                } else {
                    block33: {
                        var14_5 = this.zzj;
                        var13_2 = var14_5.getHeaderField("Content-Length");
                        if (!TextUtils.isEmpty((CharSequence)var13_2)) {
                            try {
                                var7_8 = Long.parseLong((String)var13_2);
                                break block33;
                            }
                            catch (NumberFormatException var15_16) {
                                var15_15 = new StringBuilder(String.valueOf(var13_2).length() + 28);
                                var15_15.append("Unexpected Content-Length [");
                                var15_15.append((String)var13_2);
                                var15_15.append("]");
                                com.google.android.gms.ads.internal.util.zze.zzf((String)var15_15.toString());
                            }
                        }
                        var7_8 = -1L;
                    }
                    var14_5 = var14_5.getHeaderField("Content-Range");
                    var5_9 = var7_8;
                    if (!TextUtils.isEmpty((CharSequence)var14_5)) {
                        var15_15 = zzcll.zzb.matcher((CharSequence)var14_5);
                        var5_9 = var7_8;
                        if (var15_15.find()) {
                            try {
                                var11_17 = Long.parseLong(var15_15.group(2)) - Long.parseLong(var15_15.group(1)) + 1L;
                                if (var7_8 < 0L) {
                                    var5_9 = var11_17;
                                } else {
                                    var5_9 = var7_8;
                                    if (var7_8 != var11_17) {
                                        var2_11 = String.valueOf(var13_2).length();
                                        var3_13 = String.valueOf(var14_5).length();
                                        var15_15 = new StringBuilder(var2_11 + 26 + var3_13);
                                        var15_15.append("Inconsistent headers [");
                                        var15_15.append((String)var13_2);
                                        var15_15.append("] [");
                                        var15_15.append((String)var14_5);
                                        var15_15.append("]");
                                        com.google.android.gms.ads.internal.util.zze.zzi((String)var15_15.toString());
                                        var5_9 = Math.max(var7_8, var11_17);
                                    }
                                }
                            }
                            catch (NumberFormatException var13_3) {
                                var13_2 = new StringBuilder(String.valueOf(var14_5).length() + 27);
                                var13_2.append("Unexpected Content-Range [");
                                var13_2.append((String)var14_5);
                                var13_2.append("]");
                                com.google.android.gms.ads.internal.util.zze.zzf((String)var13_2.toString());
                                var5_9 = var7_8;
                            }
                        }
                    }
                    var7_8 = var9_14;
                    if (var5_9 != -1L) {
                        var7_8 = var5_9 - this.zzn;
                    }
                    this.zzo = var7_8;
                }
            } else {
                this.zzo = var1_1.zzg;
            }
            try {
                this.zzk = this.zzj.getInputStream();
                this.zzl = true;
            }
            catch (IOException var13_4) {
                this.zzn();
                throw new zzat(var13_4, var1_1, 2000, 1);
            }
            this.zzc(var1_1);
            return this.zzo;
        }
        var13_2 = this.zzj.getHeaderFields();
        this.zzn();
        var1_1 = new zzau(this.zzm, null, null, (Map)var13_2, var1_1, zzamq.zzf);
        if (this.zzm != 416) throw var1_1;
        var1_1.initCause((Throwable)new zzak(2008));
        throw var1_1;
lbl-1000:
        // 1 sources

        {
            var15_15 = var16_12.getHeaderField("Location");
            var16_12.disconnect();
            if (var15_15 == null) {
                var13_2 = new ProtocolException("Null location redirect");
                throw var13_2;
            }
            var14_5 = new URL((URL)var13_2, (String)var15_15);
            if (!"https".equals(var13_2 = var14_5.getProtocol()) && !"http".equals(var13_2)) {
                var13_2 = (var13_2 = String.valueOf(var13_2)).length() != 0 ? "Unsupported protocol redirect: ".concat((String)var13_2) : new String("Unsupported protocol redirect: ");
                var14_5 = new ProtocolException((String)var13_2);
                throw var14_5;
            }
            var13_2 = var14_5;
            var2_11 = var3_13;
            ** continue;
lbl168:
            // 1 sources

            var14_5 = new StringBuilder;
            var14_5 = new StringBuilder(31);
            var14_5.append("Too many redirects: ");
            var14_5.append(var3_13);
            var13_2 = new NoRouteToHostException(var14_5.toString());
            throw var13_2;
        }
    }

    public final Uri zzi() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) return Uri.parse((String)httpURLConnection.getURL().toString());
        return null;
    }

    public final void zzj() throws zzat {
        try {
            Object object;
            block14: {
                int n;
                if (this.zzk == null) return;
                Object object2 = this.zzj;
                long l = this.zzo;
                if (l != -1L) {
                    l -= this.zzq;
                }
                if (zzamq.zza == 19 || (n = zzamq.zza) == 20) {
                    try {
                        object2 = ((URLConnection)object2).getInputStream();
                        if (l == -1L) {
                            if (((InputStream)object2).read() == -1) break block14;
                        } else if (l <= 2048L) break block14;
                        object = object2.getClass().getName();
                        if (((String)object).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || ((String)object).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                            object = object2.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                            ((AccessibleObject)object).setAccessible(true);
                            ((Method)object).invoke(object2, new Object[0]);
                        }
                    }
                    catch (Exception exception) {}
                }
            }
            try {
                this.zzk.close();
            }
            catch (IOException iOException) {
                object = new zzat(iOException, this.zzi, 2000, 3);
                throw object;
            }
            return;
        }
        finally {
            this.zzk = null;
            this.zzn();
            if (this.zzl) {
                this.zzl = false;
                this.zze();
            }
            this.zzs.clear();
        }
    }

    final void zzl(int n) {
        this.zzr = n;
        Iterator<Socket> iterator = this.zzs.iterator();
        while (iterator.hasNext()) {
            Socket socket = iterator.next();
            if (socket.isClosed()) continue;
            try {
                socket.setReceiveBufferSize(this.zzr);
            }
            catch (SocketException socketException) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to update receive buffer size.", (Throwable)socketException);
            }
        }
    }
}
