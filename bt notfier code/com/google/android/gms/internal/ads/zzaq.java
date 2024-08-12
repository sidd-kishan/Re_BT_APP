/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzap
 *  com.google.android.gms.internal.ads.zzat
 *  com.google.android.gms.internal.ads.zzav
 *  com.google.android.gms.internal.ads.zzaw
 *  com.google.android.gms.internal.ads.zzfly
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzap;
import com.google.android.gms.internal.ads.zzat;
import com.google.android.gms.internal.ads.zzav;
import com.google.android.gms.internal.ads.zzaw;
import com.google.android.gms.internal.ads.zzfly;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzaq
extends zzag
implements zzaw {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzav zzf;
    private final zzav zzg;
    private zzan zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzaq() {
        this(null, 8000, 8000, false, null, null, false);
    }

    private zzaq(String string, int n, int n2, boolean bl, zzav zzav2, zzfly<String> zzfly2, boolean bl2) {
        super(true);
        this.zze = string;
        this.zzc = n;
        this.zzd = n2;
        this.zzb = bl;
        this.zzf = zzav2;
        this.zzg = new zzav();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzaq(String string, int n, int n2, boolean bl, zzav zzav2, zzfly zzfly2, boolean bl2, zzap zzap2) {
        this(string, n, n2, bl, zzav2, null, false);
    }

    /*
     * WARNING - void declaration
     */
    private final HttpURLConnection zzk(URL object4, int n, byte[] object2, long l, long l2, boolean bl, boolean bl2, Map<String, String> object3) throws IOException {
        void var9_18;
        void var1_12;
        void var8_17;
        String string;
        void var1_8;
        void var6_16;
        void var4_15;
        Iterator iterator;
        HttpURLConnection httpURLConnection = (HttpURLConnection)((URL)object4).openConnection();
        httpURLConnection.setConnectTimeout(this.zzc);
        httpURLConnection.setReadTimeout(this.zzd);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.zzf.zza());
        hashMap.putAll(this.zzg.zza());
        hashMap.putAll(iterator);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
        }
        if (var4_15 == 0L && var6_16 == -1L) {
            Object var1_5 = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("bytes=");
            stringBuilder.append((long)var4_15);
            stringBuilder.append("-");
            if (var6_16 != -1L) {
                stringBuilder.append((long)(var4_15 + var6_16 - 1L));
            }
            String string2 = stringBuilder.toString();
        }
        if (var1_8 != null) {
            httpURLConnection.setRequestProperty("Range", (String)var1_8);
        }
        if ((string = this.zze) != null) {
            httpURLConnection.setRequestProperty("User-Agent", string);
        }
        if (true != var8_17) {
            String string3 = "identity";
        } else {
            String string4 = "gzip";
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", (String)var1_12);
        httpURLConnection.setInstanceFollowRedirects((boolean)var9_18);
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setRequestMethod(zzan.zza((int)1));
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL object, String string, zzan zzan2) throws zzat {
        Serializable serializable;
        block3: {
            if (string == null) throw new zzat("Null location redirect", zzan2, 2001, 1);
            try {
                serializable = new URL((URL)object, string);
                string = ((URL)serializable).getProtocol();
                if ("https".equals(string) || "http".equals(string)) break block3;
            }
            catch (MalformedURLException malformedURLException) {
                throw new zzat((IOException)malformedURLException, zzan2, 2001, 1);
            }
            object = String.valueOf(string);
            object = ((String)object).length() != 0 ? "Unsupported protocol redirect: ".concat((String)object) : new String("Unsupported protocol redirect: ");
            throw new zzat((String)object, zzan2, 2001, 1);
        }
        if (this.zzb) return serializable;
        if (string.equals(((URL)object).getProtocol())) {
            return serializable;
        }
        object = ((URL)object).getProtocol();
        serializable = new StringBuilder(String.valueOf(object).length() + 41 + String.valueOf(string).length());
        ((StringBuilder)serializable).append("Disallowed cross-protocol redirect (");
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append(" to ");
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append(")");
        throw new zzat(((StringBuilder)serializable).toString(), zzan2, 2001, 1);
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) return;
        try {
            httpURLConnection.disconnect();
        }
        catch (Exception exception) {
            zzaln.zzb((String)"DefaultHttpDataSource", (String)"Unexpected error while disconnecting", (Throwable)exception);
        }
        this.zzi = null;
    }

    public final Map<String, List<String>> zzf() {
        Object object = this.zzi;
        object = object == null ? Collections.emptyMap() : ((URLConnection)object).getHeaderFields();
        return object;
    }

    /*
     * Enabled force condition propagation
     */
    public final int zzg(byte[] byArray, int n, int n2) throws zzat {
        int n3 = -1;
        if (n2 == 0) {
            return 0;
        }
        try {
            long l = this.zzm;
            int n4 = n2;
            if (l != -1L) {
                if ((l -= this.zzn) == 0L) {
                    return n3;
                }
                n4 = (int)Math.min((long)n2, l);
            }
            InputStream inputStream = this.zzj;
            n2 = zzamq.zza;
            if ((n = inputStream.read(byArray, n, n4)) == -1) {
                return n3;
            }
            this.zzn += (long)n;
            this.zzd(n);
            return n;
        }
        catch (IOException iOException) {
            zzan zzan2 = this.zzh;
            n = zzamq.zza;
            throw zzat.zza((IOException)iOException, (zzan)zzan2, (int)2);
        }
    }

    /*
     * Exception decompiling
     */
    public final long zzh(zzan var1_1) throws zzat {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 11[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final Uri zzi() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) return Uri.parse((String)httpURLConnection.getURL().toString());
        return null;
    }

    public final void zzj() throws zzat {
        try {
            Object object;
            int n;
            Object object2;
            InputStream inputStream;
            block13: {
                inputStream = this.zzj;
                if (inputStream == null) return;
                long l = this.zzm;
                l = l == -1L ? -1L : (l -= this.zzn);
                object2 = this.zzi;
                if (object2 != null && zzamq.zza >= 19 && (n = zzamq.zza) <= 20) {
                    try {
                        object2 = ((URLConnection)object2).getInputStream();
                        if (l == -1L) {
                            if (((InputStream)object2).read() == -1) break block13;
                        } else if (l <= 2048L) break block13;
                        object = object2.getClass().getName();
                        if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(object) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(object)) {
                            object = object2.getClass().getSuperclass();
                            if (object == null) throw null;
                            object = ((Class)object).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                            ((AccessibleObject)object).setAccessible(true);
                            ((Method)object).invoke(object2, new Object[0]);
                        }
                    }
                    catch (Exception exception) {}
                }
            }
            try {
                inputStream.close();
            }
            catch (IOException iOException) {
                object2 = this.zzh;
                n = zzamq.zza;
                object = new zzat(iOException, (zzan)object2, 2000, 3);
                throw object;
            }
            return;
        }
        finally {
            this.zzj = null;
            this.zzm();
            if (this.zzk) {
                this.zzk = false;
                this.zze();
            }
        }
    }
}
