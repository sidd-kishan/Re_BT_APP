/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzaua
 *  com.google.android.gms.internal.ads.zzaub
 *  com.google.android.gms.internal.ads.zzauf
 *  com.google.android.gms.internal.ads.zzaug
 *  com.google.android.gms.internal.ads.zzauh
 *  com.google.android.gms.internal.ads.zzaui
 *  com.google.android.gms.internal.ads.zzauo
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzave
 *  com.google.android.gms.internal.ads.zzcjt
 *  com.google.android.gms.internal.ads.zzcki
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaua;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzauf;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzauh;
import com.google.android.gms.internal.ads.zzaui;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzcjt;
import com.google.android.gms.internal.ads.zzcki;
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

final class zzcju
implements zzaui {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzc = new AtomicReference();
    private final SSLSocketFactory zzd = new zzcjt(this);
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzauh zzh;
    private final zzauo<? super zzcju> zzi;
    private zzaub zzj;
    private HttpURLConnection zzk;
    private InputStream zzl;
    private boolean zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private int zzr;
    private final Set<Socket> zzs = new HashSet<Socket>();

    zzcju(String string, zzauo<? super zzcju> zzauo2, int n, int n2, int n3) {
        zzaup.zzf((String)string);
        this.zzg = string;
        this.zzi = zzauo2;
        this.zzh = new zzauh();
        this.zze = n;
        this.zzf = n2;
        this.zzr = n3;
    }

    static /* synthetic */ int zzf(zzcju zzcju2) {
        return zzcju2.zzr;
    }

    static /* synthetic */ void zzh(zzcju zzcju2, Socket socket) {
        zzcju2.zzs.add(socket);
    }

    private final void zzi() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection == null) return;
        try {
            httpURLConnection.disconnect();
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unexpected error while disconnecting", (Throwable)exception);
        }
        this.zzk = null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public final long zza(zzaub var1_1) throws zzauf {
        block27: {
            block29: {
                block30: {
                    block28: {
                        this.zzj = var1_1;
                        this.zzq = 0L;
                        this.zzp = 0L;
                        try {
                            var12_2 = new URL(var1_1.zza.toString());
                            var4_5 = var1_1.zzc;
                            var6_6 = var1_1.zzd;
                            var2_7 = 0;
lbl9:
                            // 2 sources

                            while (true) {
                                var3_8 = var2_7 + 1;
                                if (var2_7 > 20) ** GOTO lbl163
                                var14_13 = (HttpURLConnection)var12_2.openConnection();
                                if (var14_13 instanceof HttpsURLConnection) {
                                    ((HttpsURLConnection)var14_13).setSSLSocketFactory(this.zzd);
                                }
                                var14_13.setConnectTimeout(this.zze);
                                var14_13.setReadTimeout(this.zzf);
                                for (Object var13_10 : this.zzh.zza().entrySet()) {
                                    var14_13.setRequestProperty((String)var13_10.getKey(), (String)var13_10.getValue());
                                }
                                var8_9 = -1L;
                                if (var4_5 != 0L || var6_6 != -1L) {
                                    var13_10 = new StringBuilder(27);
                                    var13_10.append("bytes=");
                                    var13_10.append(var4_5);
                                    var13_10.append("-");
                                    var13_10 = var13_10.toString();
                                    if (var6_6 != -1L) {
                                        var2_7 = var13_10.length();
                                        var15_15 = new StringBuilder(var2_7 + 20);
                                        var15_15.append((String)var13_10);
                                        var15_15.append(var4_5 + var6_6 - 1L);
                                        var13_10 = var15_15.toString();
                                    }
                                    var14_13.setRequestProperty("Range", (String)var13_10);
                                }
                                var14_13.setRequestProperty("User-Agent", this.zzg);
                                var14_13.setRequestProperty("Accept-Encoding", "identity");
                                var14_13.setInstanceFollowRedirects(false);
                                var14_13.setDoOutput(false);
                                var14_13.connect();
                                var2_7 = var14_13.getResponseCode();
                                if (var2_7 != 300 && var2_7 != 301 && var2_7 != 302 && var2_7 != 303 && var2_7 != 307 && var2_7 != 308) {
                                    this.zzk = var14_13;
                                }
                                ** GOTO lbl-1000
                                break;
                            }
                        }
                        catch (IOException var13_12) {
                            var12_2 = String.valueOf(var1_1.zza.toString());
                            var12_2 = var12_2.length() != 0 ? "Unable to connect to ".concat((String)var12_2) : new String("Unable to connect to ");
                            var1_1 = new zzauf((String)var12_2, var13_12, var1_1, 1);
                            throw var1_1;
                        }
                        try {
                            var2_7 = var14_13.getResponseCode();
                            if (var2_7 < 200 || var2_7 > 299) break block27;
                            if (var2_7 != 200 || (var4_5 = var1_1.zzc) == 0L) {
                                var4_5 = 0L;
                            }
                            this.zzn = var4_5;
                            var4_5 = var1_1.zzd;
                            if (var4_5 == -1L) break block28;
                            this.zzo = var4_5;
                            break block29;
                        }
                        catch (IOException var13_11) {
                            this.zzi();
                            var12_2 = String.valueOf(var1_1.zza.toString());
                            var12_2 = var12_2.length() != 0 ? "Unable to connect to ".concat((String)var12_2) : new String("Unable to connect to ");
                            throw new zzauf((String)var12_2, var13_11, var1_1, 1);
                        }
                    }
                    var13_10 = this.zzk;
                    var12_2 = var13_10.getHeaderField("Content-Length");
                    if (!TextUtils.isEmpty((CharSequence)var12_2)) {
                        try {
                            var6_6 = Long.parseLong((String)var12_2);
                            break block30;
                        }
                        catch (NumberFormatException var14_14) {
                            var14_13 = new StringBuilder(String.valueOf(var12_2).length() + 28);
                            var14_13.append("Unexpected Content-Length [");
                            var14_13.append((String)var12_2);
                            var14_13.append("]");
                            com.google.android.gms.ads.internal.util.zze.zzf((String)var14_13.toString());
                        }
                    }
                    var6_6 = -1L;
                }
                var13_10 = var13_10.getHeaderField("Content-Range");
                var4_5 = var6_6;
                if (!TextUtils.isEmpty((CharSequence)var13_10)) {
                    var14_13 = zzcju.zzb.matcher((CharSequence)var13_10);
                    var4_5 = var6_6;
                    if (var14_13.find()) {
                        try {
                            var10_16 = Long.parseLong(var14_13.group(2)) - Long.parseLong(var14_13.group(1)) + 1L;
                            if (var6_6 < 0L) {
                                var4_5 = var10_16;
                            } else {
                                var4_5 = var6_6;
                                if (var6_6 != var10_16) {
                                    var2_7 = String.valueOf(var12_2).length();
                                    var3_8 = String.valueOf(var13_10).length();
                                    var14_13 = new StringBuilder(var2_7 + 26 + var3_8);
                                    var14_13.append("Inconsistent headers [");
                                    var14_13.append((String)var12_2);
                                    var14_13.append("] [");
                                    var14_13.append((String)var13_10);
                                    var14_13.append("]");
                                    com.google.android.gms.ads.internal.util.zze.zzi((String)var14_13.toString());
                                    var4_5 = Math.max(var6_6, var10_16);
                                }
                            }
                        }
                        catch (NumberFormatException var12_3) {
                            var12_2 = new StringBuilder(String.valueOf(var13_10).length() + 27);
                            var12_2.append("Unexpected Content-Range [");
                            var12_2.append((String)var13_10);
                            var12_2.append("]");
                            com.google.android.gms.ads.internal.util.zze.zzf((String)var12_2.toString());
                            var4_5 = var6_6;
                        }
                    }
                }
                var6_6 = var8_9;
                if (var4_5 != -1L) {
                    var6_6 = var4_5 - this.zzn;
                }
                this.zzo = var6_6;
            }
            try {
                this.zzl = this.zzk.getInputStream();
                this.zzm = true;
                var12_2 = this.zzi;
                if (var12_2 == null) return this.zzo;
            }
            catch (IOException var12_4) {
                this.zzi();
                throw new zzauf(var12_4, var1_1, 1);
            }
            ((zzcki)var12_2).zzR((zzatz)this, var1_1);
            return this.zzo;
        }
        var12_2 = this.zzk.getHeaderFields();
        this.zzi();
        var1_1 = new zzaug(var2_7, (Map)var12_2, var1_1);
        if (var2_7 != 416) throw var1_1;
        var1_1.initCause((Throwable)new zzaua(0));
        throw var1_1;
lbl-1000:
        // 1 sources

        {
            var15_15 = var14_13.getHeaderField("Location");
            var14_13.disconnect();
            if (var15_15 == null) {
                var12_2 = new ProtocolException("Null location redirect");
                throw var12_2;
            }
            var13_10 = new URL((URL)var12_2, (String)var15_15);
            if (!"https".equals(var12_2 = var13_10.getProtocol()) && !"http".equals(var12_2)) {
                var12_2 = (var12_2 = String.valueOf(var12_2)).length() != 0 ? "Unsupported protocol redirect: ".concat((String)var12_2) : new String("Unsupported protocol redirect: ");
                var13_10 = new ProtocolException((String)var12_2);
                throw var13_10;
            }
            var12_2 = var13_10;
            var2_7 = var3_8;
            ** continue;
lbl163:
            // 1 sources

            var12_2 = new StringBuilder(31);
            var12_2.append("Too many redirects: ");
            var12_2.append(var3_8);
            var13_10 = new NoRouteToHostException(var12_2.toString());
            throw var13_10;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final int zzb(byte[] object, int n, int n2) throws zzauf {
        try {
            int n3;
            int n4;
            long l = this.zzp;
            long l2 = this.zzn;
            int n5 = 0;
            if (l != l2) {
                byte[] byArray;
                byte[] byArray2 = byArray = (byte[])zzc.getAndSet(null);
                if (byArray == null) {
                    byArray2 = new byte[4096];
                }
                while ((l = this.zzp) != (l2 = this.zzn)) {
                    int n6 = (int)Math.min(l2 - l, (long)byArray2.length);
                    n6 = this.zzl.read(byArray2, 0, n6);
                    if (Thread.interrupted()) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException();
                        throw interruptedIOException;
                    }
                    if (n6 == -1) {
                        EOFException eOFException = new EOFException();
                        throw eOFException;
                    }
                    this.zzp += (long)n6;
                    zzauo<? super zzcju> zzauo2 = this.zzi;
                    if (zzauo2 == null) continue;
                    ((zzcki)zzauo2).zzS((zzatz)this, n6);
                }
                zzc.set(byArray2);
            }
            if (n4 == 0) {
                return n5;
            }
            l = this.zzo;
            n5 = n4;
            if (l != -1L) {
                if ((l -= this.zzq) == 0L) return -1;
                n5 = (int)Math.min((long)n4, l);
            }
            if ((n4 = this.zzl.read((byte[])object, n3, n5)) != -1) {
                this.zzq += (long)n4;
                zzauo<? super zzcju> zzauo3 = this.zzi;
                n3 = n4;
                if (zzauo3 == null) return n3;
                ((zzcki)zzauo3).zzS((zzatz)this, n4);
                return n4;
            }
            if (this.zzo == -1L) return -1;
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        catch (IOException iOException) {
            zzauf zzauf2 = new zzauf(iOException, this.zzj, 2);
            throw zzauf2;
        }
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection != null) return Uri.parse((String)httpURLConnection.getURL().toString());
        return null;
    }

    public final void zzd() throws zzauf {
        try {
            Object object;
            block14: {
                int n;
                if (this.zzl == null) return;
                object = this.zzk;
                long l = this.zzo;
                if (l != -1L) {
                    l -= this.zzq;
                }
                if (zzave.zza == 19 || (n = zzave.zza) == 20) {
                    try {
                        object = ((URLConnection)object).getInputStream();
                        if (l == -1L) {
                            if (((InputStream)object).read() == -1) break block14;
                        } else if (l <= 2048L) break block14;
                        Object object2 = object.getClass().getName();
                        if (((String)object2).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || ((String)object2).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                            object2 = object.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                            ((AccessibleObject)object2).setAccessible(true);
                            ((Method)object2).invoke(object, new Object[0]);
                        }
                    }
                    catch (Exception exception) {}
                }
            }
            try {
                this.zzl.close();
            }
            catch (IOException iOException) {
                object = new zzauf(iOException, this.zzj, 3);
                throw object;
            }
            return;
        }
        finally {
            this.zzl = null;
            this.zzi();
            if (this.zzm) {
                this.zzm = false;
            }
            this.zzs.clear();
        }
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection != null) return httpURLConnection.getHeaderFields();
        return null;
    }

    final void zzg(int n) {
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
