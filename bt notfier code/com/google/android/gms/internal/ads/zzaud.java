/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaua
 *  com.google.android.gms.internal.ads.zzaub
 *  com.google.android.gms.internal.ads.zzauf
 *  com.google.android.gms.internal.ads.zzaug
 *  com.google.android.gms.internal.ads.zzauh
 *  com.google.android.gms.internal.ads.zzaui
 *  com.google.android.gms.internal.ads.zzauo
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzauz
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.ads.zzaua;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzauf;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzauh;
import com.google.android.gms.internal.ads.zzaui;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzauz;
import com.google.android.gms.internal.ads.zzave;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class zzaud
implements zzaui {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzc = new AtomicReference();
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzauh zzg;
    private final zzauo<? super zzaud> zzh;
    private zzaub zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;

    public zzaud(String string, zzauz<String> zzauz2, zzauo<? super zzaud> zzauo2, int n, int n2, boolean bl, zzauh zzauh2) {
        zzaup.zzf((String)string);
        this.zzf = string;
        this.zzh = zzauo2;
        this.zzg = new zzauh();
        this.zzd = n;
        this.zze = n2;
    }

    private final void zzf() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) return;
        try {
            httpURLConnection.disconnect();
        }
        catch (Exception exception) {
            Log.e((String)"DefaultHttpDataSource", (String)"Unexpected error while disconnecting", (Throwable)exception);
        }
        this.zzj = null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final long zza(zzaub var1_1) throws zzauf {
        block29: {
            block28: {
                this.zzi = var1_1;
                this.zzp = 0L;
                this.zzo = 0L;
                try {
                    var12_2 = new URL(var1_1.zza.toString());
                    var6_5 = var1_1.zzc;
                    var4_6 = var1_1.zzd;
                    var2_7 = 0;
lbl9:
                    // 2 sources

                    while (true) {
                        var3_8 = var2_7 + 1;
                        if (var2_7 > 20) ** GOTO lbl168
                        var15_15 = (HttpURLConnection)var12_2.openConnection();
                        var15_15.setConnectTimeout(this.zzd);
                        var15_15.setReadTimeout(this.zze);
                        var14_13 = this.zzg.zza().entrySet().iterator();
                        while (var14_13.hasNext()) {
                            var13_10 = var14_13.next();
                            var15_15.setRequestProperty((String)var13_10.getKey(), (String)var13_10.getValue());
                        }
                        var8_9 = -1L;
                        if (var6_5 != 0L || var4_6 != -1L) {
                            var13_10 = new StringBuilder(27);
                            var13_10.append("bytes=");
                            var13_10.append(var6_5);
                            var13_10.append("-");
                            var13_10 = var14_13 = var13_10.toString();
                            if (var4_6 != -1L) {
                                var2_7 = var14_13.length();
                                var13_10 = new StringBuilder(var2_7 + 20);
                                var13_10.append((String)var14_13);
                                var13_10.append(var6_5 + var4_6 - 1L);
                                var13_10 = var13_10.toString();
                            }
                            var15_15.setRequestProperty("Range", (String)var13_10);
                        }
                        var15_15.setRequestProperty("User-Agent", this.zzf);
                        var15_15.setRequestProperty("Accept-Encoding", "identity");
                        var15_15.setInstanceFollowRedirects(false);
                        var15_15.setDoOutput(false);
                        var15_15.connect();
                        var2_7 = var15_15.getResponseCode();
                        if (var2_7 != 300 && var2_7 != 301 && var2_7 != 302 && var2_7 != 303 && var2_7 != 307 && var2_7 != 308) {
                            this.zzj = var15_15;
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
                    var2_7 = var15_15.getResponseCode();
                    if (var2_7 >= 200 && var2_7 <= 299) break block28;
                    break block29;
                }
                catch (IOException var13_11) {
                    this.zzf();
                    var12_2 = String.valueOf(var1_1.zza.toString());
                    var12_2 = var12_2.length() != 0 ? "Unable to connect to ".concat((String)var12_2) : new String("Unable to connect to ");
                    throw new zzauf((String)var12_2, var13_11, var1_1, 1);
                }
            }
            this.zzj.getContentType();
            if (var2_7 != 200 || (var4_6 = var1_1.zzc) == 0L) {
                var4_6 = 0L;
            }
            this.zzm = var4_6;
            var4_6 = var1_1.zzd;
            if (var4_6 != -1L) {
                this.zzn = var4_6;
            } else {
                block30: {
                    var13_10 = this.zzj;
                    var12_2 = var13_10.getHeaderField("Content-Length");
                    if (!TextUtils.isEmpty((CharSequence)var12_2)) {
                        try {
                            var6_5 = Long.parseLong((String)var12_2);
                            break block30;
                        }
                        catch (NumberFormatException var14_14) {
                            var14_13 = new StringBuilder(String.valueOf(var12_2).length() + 28);
                            var14_13.append("Unexpected Content-Length [");
                            var14_13.append((String)var12_2);
                            var14_13.append("]");
                            Log.e((String)"DefaultHttpDataSource", (String)var14_13.toString());
                        }
                    }
                    var6_5 = -1L;
                }
                var13_10 = var13_10.getHeaderField("Content-Range");
                var4_6 = var6_5;
                if (!TextUtils.isEmpty((CharSequence)var13_10)) {
                    var14_13 = zzaud.zzb.matcher((CharSequence)var13_10);
                    var4_6 = var6_5;
                    if (var14_13.find()) {
                        try {
                            var10_16 = Long.parseLong(var14_13.group(2)) - Long.parseLong(var14_13.group(1)) + 1L;
                            if (var6_5 < 0L) {
                                var4_6 = var10_16;
                            } else {
                                var4_6 = var6_5;
                                if (var6_5 != var10_16) {
                                    var2_7 = String.valueOf(var12_2).length();
                                    var3_8 = String.valueOf(var13_10).length();
                                    var14_13 = new StringBuilder(var2_7 + 26 + var3_8);
                                    var14_13.append("Inconsistent headers [");
                                    var14_13.append((String)var12_2);
                                    var14_13.append("] [");
                                    var14_13.append((String)var13_10);
                                    var14_13.append("]");
                                    Log.w((String)"DefaultHttpDataSource", (String)var14_13.toString());
                                    var4_6 = Math.max(var6_5, var10_16);
                                }
                            }
                        }
                        catch (NumberFormatException var12_3) {
                            var12_2 = new StringBuilder(String.valueOf(var13_10).length() + 27);
                            var12_2.append("Unexpected Content-Range [");
                            var12_2.append((String)var13_10);
                            var12_2.append("]");
                            Log.e((String)"DefaultHttpDataSource", (String)var12_2.toString());
                            var4_6 = var6_5;
                        }
                    }
                }
                var6_5 = var8_9;
                if (var4_6 != -1L) {
                    var6_5 = var4_6 - this.zzm;
                }
                this.zzn = var6_5;
            }
            try {
                this.zzk = this.zzj.getInputStream();
                this.zzl = true;
                var12_2 = this.zzh;
                if (var12_2 == null) return this.zzn;
            }
            catch (IOException var12_4) {
                this.zzf();
                throw new zzauf(var12_4, var1_1, 1);
            }
            var12_2.zzj((Object)this, var1_1);
            return this.zzn;
        }
        var12_2 = this.zzj.getHeaderFields();
        this.zzf();
        var1_1 = new zzaug(var2_7, (Map)var12_2, var1_1);
        if (var2_7 != 416) throw var1_1;
        var1_1.initCause((Throwable)new zzaua(0));
        throw var1_1;
lbl-1000:
        // 1 sources

        {
            var14_13 = var15_15.getHeaderField("Location");
            var15_15.disconnect();
            if (var14_13 == null) {
                var12_2 = new ProtocolException("Null location redirect");
                throw var12_2;
            }
            var13_10 = new URL((URL)var12_2, (String)var14_13);
            if (!"https".equals(var12_2 = var13_10.getProtocol()) && !"http".equals(var12_2)) {
                var12_2 = (var12_2 = String.valueOf(var12_2)).length() != 0 ? "Unsupported protocol redirect: ".concat((String)var12_2) : new String("Unsupported protocol redirect: ");
                var13_10 = new ProtocolException((String)var12_2);
                throw var13_10;
            }
            var12_2 = var13_10;
            var2_7 = var3_8;
            ** continue;
lbl168:
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
            long l = this.zzo;
            long l2 = this.zzm;
            int n5 = 0;
            if (l != l2) {
                byte[] byArray;
                byte[] byArray2 = byArray = (byte[])zzc.getAndSet(null);
                if (byArray == null) {
                    byArray2 = new byte[4096];
                }
                while ((l = this.zzo) != (l2 = this.zzm)) {
                    int n6 = (int)Math.min(l2 - l, (long)byArray2.length);
                    n6 = this.zzk.read(byArray2, 0, n6);
                    if (Thread.interrupted()) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException();
                        throw interruptedIOException;
                    }
                    if (n6 == -1) {
                        EOFException eOFException = new EOFException();
                        throw eOFException;
                    }
                    this.zzo += (long)n6;
                    zzauo<? super zzaud> zzauo2 = this.zzh;
                    if (zzauo2 == null) continue;
                    zzauo2.zzk((Object)this, n6);
                }
                zzc.set(byArray2);
            }
            if (n4 == 0) {
                return n5;
            }
            l2 = this.zzn;
            n5 = n4;
            if (l2 != -1L) {
                if ((l2 -= this.zzp) == 0L) return -1;
                n5 = (int)Math.min((long)n4, l2);
            }
            if ((n4 = this.zzk.read((byte[])object, n3, n5)) != -1) {
                this.zzp += (long)n4;
                zzauo<? super zzaud> zzauo3 = this.zzh;
                n3 = n4;
                if (zzauo3 == null) return n3;
                zzauo3.zzk((Object)this, n4);
                return n4;
            }
            if (this.zzn == -1L) return -1;
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        catch (IOException iOException) {
            zzauf zzauf2 = new zzauf(iOException, this.zzi, 2);
            throw zzauf2;
        }
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) return Uri.parse((String)httpURLConnection.getURL().toString());
        return null;
    }

    public final void zzd() throws zzauf {
        try {
            Object object;
            block14: {
                int n;
                if (this.zzk == null) return;
                object = this.zzj;
                long l = this.zzn;
                if (l != -1L) {
                    l -= this.zzp;
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
                this.zzk.close();
            }
            catch (IOException iOException) {
                object = new zzauf(iOException, this.zzi, 3);
                throw object;
            }
            return;
        }
        finally {
            this.zzk = null;
            this.zzf();
            if (this.zzl) {
                this.zzl = false;
            }
        }
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) return httpURLConnection.getHeaderFields();
        return null;
    }
}
