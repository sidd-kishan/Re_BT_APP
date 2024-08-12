/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzvk
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvp
 *  com.google.android.gms.internal.ads.zzvu
 *  com.google.android.gms.internal.ads.zzvv
 *  com.google.android.gms.internal.ads.zzvx
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzvz
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwj
 *  com.google.android.gms.internal.ads.zzwk
 *  com.google.android.gms.internal.ads.zzwl
 *  com.google.android.gms.internal.ads.zzwo
 *  com.google.android.gms.internal.ads.zzwq
 *  com.google.android.gms.internal.ads.zzwt
 *  com.google.android.gms.internal.ads.zzwz
 *  com.google.android.gms.internal.ads.zzxa
 *  com.google.android.gms.internal.ads.zzxb
 *  com.google.android.gms.internal.ads.zzxd
 *  com.google.android.gms.internal.ads.zzxf
 *  com.google.android.gms.internal.ads.zzxg
 */
package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzvk;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvp;
import com.google.android.gms.internal.ads.zzvu;
import com.google.android.gms.internal.ads.zzvv;
import com.google.android.gms.internal.ads.zzvx;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzvz;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwj;
import com.google.android.gms.internal.ads.zzwk;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwo;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzwt;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxb;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxf;
import com.google.android.gms.internal.ads.zzxg;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class zzwr
implements zzvv {
    protected final zzwt zza;
    @Deprecated
    protected final zzwq zzb;
    private final zzwq zzc;

    public zzwr(zzwq zzwq2) {
        zzwt zzwt2 = new zzwt(4096);
        this.zzc = zzwq2;
        this.zzb = zzwq2;
        this.zza = zzwt2;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public zzvy zza(zzwc<?> var1_1) throws zzwl {
        var5_2 = SystemClock.elapsedRealtime();
        while (true) lbl-1000:
        // 2 sources

        {
            block63: {
                block64: {
                    block66: {
                        block61: {
                            block65: {
                                block58: {
                                    block60: {
                                        block59: {
                                            Collections.emptyList();
                                            var2_3 = 1;
                                            var11_19 /* !! */  = var1_1.zzl();
                                            if (var11_19 /* !! */  == null) {
                                                var9_7 /* !! */  = Collections.emptyMap();
                                            } else {
                                                var9_7 /* !! */  = new HashMap();
                                                var10_11 = var11_19 /* !! */ .zzb;
                                                if (var10_11 != null) {
                                                    var9_7 /* !! */ .put("If-None-Match", var10_11);
                                                }
                                                if ((var7_6 = var11_19 /* !! */ .zzd) > 0L) {
                                                    var9_7 /* !! */ .put("If-Modified-Since", zzwz.zzc((long)var7_6));
                                                }
                                            }
                                            var10_11 = var1_1.zzi();
                                            var11_19 /* !! */  = new HashMap();
                                            var11_19 /* !! */ .putAll(var9_7 /* !! */ );
                                            var11_19 /* !! */ .putAll(var1_1.zzn());
                                            var9_7 /* !! */  = new URL((String)var10_11);
                                            var10_11 = (HttpURLConnection)var9_7 /* !! */ .openConnection();
                                            var10_11.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
                                            var3_4 = var1_1.zzp();
                                            var10_11.setConnectTimeout(var3_4);
                                            var10_11.setReadTimeout(var3_4);
                                            var10_11.setUseCaches(false);
                                            var10_11.setDoInput(true);
                                            "https".equals(var9_7 /* !! */ .getProtocol());
                                            var9_7 /* !! */  = var11_19 /* !! */ .keySet().iterator();
                                            while (var9_7 /* !! */ .hasNext()) {
                                                var12_21 = (String)var9_7 /* !! */ .next();
                                                var10_11.setRequestProperty(var12_21, (String)var11_19 /* !! */ .get(var12_21));
                                            }
                                            if (var1_1.zzb() != 0) {
                                                var10_11.setRequestMethod("POST");
                                                var9_7 /* !! */  = (zzxf)var1_1.zzo();
                                                if (var9_7 /* !! */  != null) {
                                                    var10_11.setDoOutput(true);
                                                    if (!var10_11.getRequestProperties().containsKey("Content-Type")) {
                                                        var10_11.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                                                    }
                                                    var11_19 /* !! */  = new DataOutputStream(var10_11.getOutputStream());
                                                    var11_19 /* !! */ .write((byte[])var9_7 /* !! */ );
                                                    var11_19 /* !! */ .close();
                                                }
                                            } else {
                                                var10_11.setRequestMethod("GET");
                                            }
                                            if ((var3_4 = var10_11.getResponseCode()) == -1) break block58;
                                            var1_1.zzb();
                                            if (var3_4 >= 100 && var3_4 < 200 || var3_4 == 204 || var3_4 == 304) break block59;
                                            try {
                                                var9_7 /* !! */  = zzxd.zza(var10_11.getHeaderFields());
                                                var4_5 = var10_11.getContentLength();
                                                var11_19 /* !! */  = new zzxb((HttpURLConnection)var10_11);
                                                var9_7 /* !! */  = new zzxa(var3_4, (List)var9_7 /* !! */ , var4_5, (InputStream)var11_19 /* !! */ );
                                                break block60;
                                            }
                                            catch (Throwable var9_8) {
                                                break block61;
                                            }
                                        }
                                        var9_7 /* !! */  = new zzxa(var3_4, zzxd.zza(var10_11.getHeaderFields()), -1, null);
                                        var10_11.disconnect();
                                    }
                                    var2_3 = var9_7 /* !! */ .zza();
                                    var12_22 = var9_7 /* !! */ .zzb();
                                    if (var2_3 == 304) {
                                        var7_6 = SystemClock.elapsedRealtime() - var5_2;
                                        var11_19 /* !! */  = var1_1.zzl();
                                        if (var11_19 /* !! */  == null) {
                                            var10_11 = new zzvy(304, null, true, var7_6, var12_22);
                                            return var10_11;
                                        }
                                        var10_11 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                                        if (!var12_22.isEmpty()) {
                                            var13_31 = var12_22.iterator();
                                            while (var13_31.hasNext()) {
                                                var10_11.add(((zzvu)var13_31.next()).zza());
                                            }
                                        }
                                        var13_31 = new ArrayList(var12_22);
                                        var12_23 = var11_19 /* !! */ .zzh;
                                        if (var12_23 != null) {
                                            if (var12_23.isEmpty() != false) return var10_11;
                                            var14_32 = var11_19 /* !! */ .zzh.iterator();
                                            while (var14_32.hasNext() != false) {
                                                var12_25 = (zzvu)var14_32.next();
                                                if (var10_11.contains(var12_25.zza())) continue;
                                                var13_31.add(var12_25);
                                            }
                                            var10_11 = new zzvy(304, var11_19 /* !! */ .zza, true, var7_6, (List)var13_31);
                                            return var10_11;
                                        }
                                        if (var11_19 /* !! */ .zzg.isEmpty() != false) return var10_11;
                                        var15_33 = var11_19 /* !! */ .zzg.entrySet().iterator();
                                        while (var15_33.hasNext() != false) {
                                            var12_27 = (Map.Entry)var15_33.next();
                                            if (var10_11.contains(var12_27.getKey())) continue;
                                            var14_32 = new zzvu((String)var12_27.getKey(), (String)var12_27.getValue());
                                            var13_31.add(var14_32);
                                        }
                                        return var10_11;
                                    }
                                    var15_33 = var9_7 /* !! */ .zzd();
                                    if (var15_33 == null) ** GOTO lbl145
                                    var3_4 = var9_7 /* !! */ .zzc();
                                    var13_31 = this.zza;
                                    var14_32 = new zzxg((zzwt)var13_31, var3_4);
                                    var11_19 /* !! */  = (zzvl)var13_31.zza(1024);
                                    while ((var3_4 = var15_33.read((byte[])var11_19 /* !! */ )) != -1) {
                                        var14_32.write((byte[])var11_19 /* !! */ , 0, var3_4);
                                    }
                                    var10_11 = var14_32.toByteArray();
                                    try {
                                        var15_33.close();
                                        ** GOTO lbl127
                                    }
                                    catch (IOException var15_34) {
                                        block62: {
                                            zzwo.zza((String)"Error occurred when closing InputStream", (Object[])new Object[0]);
lbl127:
                                            // 2 sources

                                            var13_31.zzb((byte[])var11_19 /* !! */ );
                                            var14_32.close();
                                            ** GOTO lbl146
                                            {
                                                catch (IOException var10_14) {}
                                            }
                                            catch (Throwable var10_12) {
                                                break block62;
                                            }
                                            catch (Throwable var10_13) {
                                                var11_19 /* !! */  = null;
                                            }
                                        }
                                        try {
                                            var15_33.close();
                                            ** GOTO lbl142
                                        }
                                        catch (IOException var12_28) {
                                            zzwo.zza((String)"Error occurred when closing InputStream", (Object[])new Object[0]);
lbl142:
                                            // 2 sources

                                            var13_31.zzb((byte[])var11_19 /* !! */ );
                                            var14_32.close();
                                            throw var10_11;
lbl145:
                                            // 1 sources

                                            var10_11 = new byte[0];
lbl146:
                                            // 2 sources

                                            try {
                                                var7_6 = SystemClock.elapsedRealtime() - var5_2;
                                                if (zzwo.zzb || var7_6 > 3000L) {
                                                    var11_19 /* !! */  = var10_11 != null ? Integer.valueOf(((zzvy)var10_11).length) : "null";
                                                    zzwo.zzb((String)"HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", (Object[])new Object[]{var1_1, var7_6, var11_19 /* !! */ , var2_3, var1_1.zzy().zzb()});
                                                }
                                                if (var2_3 >= 200 && var2_3 <= 299) {
                                                    return new zzvy(var2_3, (byte[])var10_11, false, SystemClock.elapsedRealtime() - var5_2, var12_22);
                                                }
                                                var11_19 /* !! */  = new IOException();
                                                throw var11_19 /* !! */ ;
                                            }
                                            catch (IOException var12_29) {
                                                var11_19 /* !! */  = var10_11;
                                                var10_11 = var12_29;
                                                break block63;
                                            }
                                        }
                                    }
                                    break block64;
                                    catch (IOException var10_15) {}
                                    break block64;
                                }
                                try {
                                    var9_7 /* !! */  = new IOException("Could not retrieve response code from HttpUrlConnection.");
                                    throw var9_7 /* !! */ ;
                                }
                                catch (Throwable var9_9) {}
                                break block65;
                                catch (Throwable var9_10) {
                                    // empty catch block
                                }
                            }
                            var2_3 = 0;
                        }
                        if (var2_3 != 0) throw var9_7 /* !! */ ;
                        try {
                            var10_11.disconnect();
                            throw var9_7 /* !! */ ;
                        }
                        catch (IOException var10_16) {}
                        break block66;
                        catch (IOException var10_17) {
                            // empty catch block
                        }
                    }
                    var9_7 /* !! */  = null;
                }
                var11_19 /* !! */  = null;
            }
            if (var10_11 instanceof SocketTimeoutException) {
                var9_7 /* !! */  = new zzxf("socket", (zzwl)new zzwk(), null);
            } else {
                if (var10_11 instanceof MalformedURLException) {
                    if ((var1_1 = String.valueOf(var1_1.zzi())).length() != 0) {
                        var1_1 = "Bad URL ".concat((String)var1_1);
                        throw new RuntimeException((String)var1_1, (Throwable)var10_11);
                    }
                    var1_1 = new String("Bad URL ");
                    throw new RuntimeException((String)var1_1, (Throwable)var10_11);
                }
                if (var9_7 /* !! */  == null) {
                    var1_1 = new zzvz((Throwable)var10_11);
                    throw var1_1;
                }
                var2_3 = var9_7 /* !! */ .zza();
                zzwo.zzc((String)"Unexpected response code %d for %s", (Object[])new Object[]{var2_3, var1_1.zzi()});
                if (var11_19 /* !! */  != null) {
                    var9_7 /* !! */  = var9_7 /* !! */ .zzb();
                    var9_7 /* !! */  = new zzvy(var2_3, (byte[])var11_19 /* !! */ , false, SystemClock.elapsedRealtime() - var5_2, (List)var9_7 /* !! */ );
                    if (var2_3 != 401 && var2_3 != 403) {
                        if (var2_3 < 400) throw new zzwj((zzvy)var9_7 /* !! */ );
                        if (var2_3 > 499) throw new zzwj((zzvy)var9_7 /* !! */ );
                        throw new zzvp((zzvy)var9_7 /* !! */ );
                    }
                    var9_7 /* !! */  = new zzxf("auth", (zzwl)new zzvk((zzvy)var9_7 /* !! */ ), null);
                } else {
                    var9_7 /* !! */  = new zzxf("network", (zzwl)new zzvx(), null);
                }
            }
            var10_11 = var1_1.zzy();
            var2_3 = var1_1.zzp();
            var10_11.zzc(zzxf.zzb((zzxf)var9_7 /* !! */ ));
            break;
        }
        catch (zzwl var10_18) {
            var1_1.zzd(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{zzxf.zza((zzxf)var9_7 /* !! */ ), var2_3}));
            throw var10_18;
        }
        {
            var1_1.zzd(String.format("%s-retry [timeout=%s]", new Object[]{zzxf.zza((zzxf)var9_7 /* !! */ ), var2_3}));
            ** while (true)
        }
    }
}
