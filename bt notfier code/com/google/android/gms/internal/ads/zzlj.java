/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzak
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzak;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzli;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class zzlj
extends zzag {
    private final Resources zza;
    private final String zzb;
    private Uri zzc;
    private AssetFileDescriptor zzd;
    private InputStream zze;
    private long zzf;
    private boolean zzg;

    public zzlj(Context context) {
        super(false);
        this.zza = context.getResources();
        this.zzb = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int n) {
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("rawresource:///");
        stringBuilder.append(n);
        return Uri.parse((String)stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     */
    public final int zzg(byte[] var1_1, int var2_3, int var3_4) throws zzli {
        if (var3_4 == 0) {
            return 0;
        }
        var5_5 = this.zzf;
        if (var5_5 == 0L) return -1;
        var4_6 = var3_4;
        if (var5_5 == -1L) ** GOTO lbl10
        var7_7 = var3_4;
        try {
            var4_6 = (int)Math.min(var5_5, var7_7);
lbl10:
            // 2 sources

            var9_8 = this.zze;
            var3_4 = zzamq.zza;
            if ((var2_3 = var9_8.read(var1_1, var2_3, var4_6)) == -1) {
                if (this.zzf != -1L) throw new zzli("End of stream reached having not read sufficient data.", (Throwable)new EOFException(), 2000);
                return -1;
            }
        }
        catch (IOException var1_2) {
            throw new zzli(null, (Throwable)var1_2, 2000);
        }
        var5_5 = this.zzf;
        if (var5_5 != -1L) {
            this.zzf = var5_5 - (long)var2_3;
        }
        this.zzd(var2_3);
        return var2_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final long zzh(zzan var1_1) throws zzli {
        block20: {
            block21: {
                this.zzc = var11_6 = var1_1 /* !! */ .zza;
                if (TextUtils.equals((CharSequence)"rawresource", (CharSequence)var11_6.getScheme())) ** GOTO lbl-1000
                if (!TextUtils.equals((CharSequence)"android.resource", (CharSequence)var11_6.getScheme()) || var11_6.getPathSegments().size() != 1) ** GOTO lbl-1000
                var9_7 = var11_6.getLastPathSegment();
                if (var9_7 == null) throw null;
                if (!var9_7.matches("\\d+")) lbl-1000:
                // 2 sources

                {
                    if (TextUtils.equals((CharSequence)"android.resource", (CharSequence)var11_6.getScheme()) == false) throw new zzli("URI must either use scheme rawresource or android.resource", null, 1004);
                    var10_8 = var11_6.getPath();
                    if (var10_8 == null) throw null;
                    var9_7 = var10_8;
                    if (var10_8.startsWith("/")) {
                        var9_7 = var10_8.substring(1);
                    }
                    var10_8 = TextUtils.isEmpty((CharSequence)(var10_8 = var11_6.getHost())) != false ? "" : String.valueOf(var10_8).concat(":");
                    var10_8 = String.valueOf(var10_8);
                    var9_7 = String.valueOf(var9_7);
                    var9_7 = var9_7.length() != 0 ? var10_8.concat((String)var9_7) : new String((String)var10_8);
                    var2_9 = this.zza.getIdentifier((String)var9_7, "raw", this.zzb);
                    if (var2_9 == 0) throw new zzli("Resource not found.", null, 2005);
                } else lbl-1000:
                // 2 sources

                {
                    try {
                        var9_7 = var11_6.getLastPathSegment();
                        if (var9_7 == null) throw null;
                        var2_9 = Integer.parseInt((String)var9_7);
                    }
                    catch (NumberFormatException var1_5) {
                        throw new zzli("Resource identifier must be an integer.", null, 1004);
                    }
                }
                this.zzb(var1_1 /* !! */ );
                try {
                    var9_7 = this.zza.openRawResourceFd(var2_9);
                    this.zzd = var9_7;
                    if (var9_7 == null) break block20;
                }
                catch (Resources.NotFoundException var1_4) {
                    throw new zzli(null, (Throwable)var1_4, 2005);
                }
                var3_10 = var9_7.getLength();
                this.zze = var10_8 = new FileInputStream(var9_7.getFileDescriptor());
                if (var3_10 == -1L) ** GOTO lbl42
                try {
                    if (var1_1 /* !! */ .zzf > var3_10) {
                        var1_1 /* !! */  = new zzli(null, null, 2008);
                        throw var1_1 /* !! */ ;
                    }
lbl42:
                    // 3 sources

                    var5_11 = var9_7.getStartOffset();
                    if ((var5_11 = var10_8.skip(var1_1 /* !! */ .zzf + var5_11) - var5_11) != var1_1 /* !! */ .zzf) ** GOTO lbl76
                    if (var3_10 == -1L) {
                        var9_7 = var10_8.getChannel();
                        if (var9_7.size() == 0L) {
                            this.zzf = -1L;
                            var3_10 = -1L;
                        } else {
                            this.zzf = var3_10 = var9_7.size() - var9_7.position();
                            if (var3_10 < 0L) {
                                var1_1 /* !! */  = new zzli(null, null, 2008);
                                throw var1_1 /* !! */ ;
                            }
                        }
                        break block21;
                    }
                }
                catch (IOException var1_2) {
                    throw new zzli(null, (Throwable)var1_2, 2000);
                }
                catch (zzli var1_3) {
                    throw var1_3;
                }
                {
                    this.zzf = var3_10 -= var5_11;
                    if (var3_10 < 0L) ** GOTO lbl-1000
                }
            }
            var7_12 = var1_1 /* !! */ .zzg;
            if (var7_12 != -1L) {
                var5_11 = var7_12;
                if (var3_10 != -1L) {
                    var5_11 = Math.min(var3_10, var7_12);
                }
                this.zzf = var5_11;
            }
            this.zzg = true;
            this.zzc(var1_1 /* !! */ );
            var3_10 = var1_1 /* !! */ .zzg;
            if (var3_10 == -1L) return this.zzf;
            return var3_10;
lbl-1000:
            // 1 sources

            {
                var1_1 /* !! */  = new zzak(2008);
                throw var1_1 /* !! */ ;
lbl76:
                // 1 sources

                var1_1 /* !! */  = new zzli(null, null, 2008);
                throw var1_1 /* !! */ ;
            }
        }
        var1_1 /* !! */  = String.valueOf(var11_6);
        String.valueOf(var1_1 /* !! */ ).length();
        throw new zzli("Resource is compressed: ".concat(String.valueOf(var1_1 /* !! */ )), null, 2000);
    }

    public final Uri zzi() {
        return this.zzc;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void zzj() throws zzli {
        Throwable throwable4222222;
        block18: {
            Throwable throwable22222222;
            block16: {
                Throwable throwable32222222;
                block17: {
                    this.zzc = null;
                    Object object = this.zze;
                    if (object != null) {
                        object.close();
                    }
                    this.zze = null;
                    {
                        catch (Throwable throwable22222222) {
                            break block16;
                        }
                        catch (IOException iOException) {}
                        {
                            zzli zzli2 = new zzli(null, (Throwable)iOException, 2000);
                            throw zzli2;
                        }
                    }
                    object = this.zzd;
                    if (object != null) {
                        object.close();
                    }
                    this.zzd = null;
                    if (!this.zzg) return;
                    this.zzg = false;
                    {
                        catch (Throwable throwable32222222) {
                            break block17;
                        }
                        catch (IOException iOException) {}
                        {
                            object = new zzli(null, (Throwable)iOException, 2000);
                            throw object;
                        }
                    }
                    this.zze();
                    return;
                }
                this.zzd = null;
                if (!this.zzg) throw throwable32222222;
                this.zzg = false;
                this.zze();
                throw throwable32222222;
            }
            this.zze = null;
            AssetFileDescriptor assetFileDescriptor = this.zzd;
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            this.zzd = null;
            if (!this.zzg) throw throwable22222222;
            this.zzg = false;
            {
                catch (Throwable throwable4222222) {
                    break block18;
                }
                catch (IOException iOException) {}
                {
                    zzli zzli3 = new zzli(null, (Throwable)iOException, 2000);
                    throw zzli3;
                }
            }
            this.zze();
            throw throwable22222222;
        }
        this.zzd = null;
        if (!this.zzg) {
            throw throwable4222222;
        }
        this.zzg = false;
        this.zze();
        throw throwable4222222;
    }
}
