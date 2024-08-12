/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.zza
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzbdm
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbdm;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzcgm;

public final class zzbdl
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdl> CREATOR = new zzbdm();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final zzbdl[] zzg;
    public final boolean zzh;
    public final boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public boolean zzl;
    public boolean zzm;
    public boolean zzn;
    public boolean zzo;

    public zzbdl() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }

    public zzbdl(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public zzbdl(Context context, AdSize[] adSizeArray) {
        int n;
        block22: {
            int n2;
            int n3;
            Object object;
            block18: {
                block21: {
                    block19: {
                        block20: {
                            DisplayMetrics displayMetrics;
                            int n4;
                            block17: {
                                block16: {
                                    block15: {
                                        block14: {
                                            boolean bl;
                                            object = adSizeArray[0];
                                            this.zzd = false;
                                            this.zzi = object.isFluid();
                                            this.zzm = com.google.android.gms.ads.zza.zzf((AdSize)object);
                                            this.zzn = com.google.android.gms.ads.zza.zzg((AdSize)object);
                                            this.zzo = bl = com.google.android.gms.ads.zza.zzd((AdSize)object);
                                            if (this.zzi) {
                                                this.zze = AdSize.BANNER.getWidth();
                                                this.zzb = n = AdSize.BANNER.getHeight();
                                            } else if (this.zzn) {
                                                this.zze = object.getWidth();
                                                this.zzb = n = com.google.android.gms.ads.zza.zzh((AdSize)object);
                                            } else if (bl) {
                                                this.zze = object.getWidth();
                                                this.zzb = n = com.google.android.gms.ads.zza.zze((AdSize)object);
                                            } else {
                                                this.zze = object.getWidth();
                                                this.zzb = n = object.getHeight();
                                            }
                                            n4 = this.zze;
                                            displayMetrics = context.getResources().getDisplayMetrics();
                                            if (n4 != -1) break block14;
                                            zzber.zza();
                                            if (context.getResources().getConfiguration().orientation != 2) break block15;
                                            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                                            if ((int)((float)displayMetrics2.heightPixels / displayMetrics2.density) >= 600) break block15;
                                            zzber.zza();
                                            displayMetrics2 = context.getResources().getDisplayMetrics();
                                            Object object2 = (WindowManager)context.getSystemService("window");
                                            if (object2 == null) break block15;
                                            Display display = object2.getDefaultDisplay();
                                            if (PlatformVersion.isAtLeastJellyBeanMR1()) {
                                                display.getRealMetrics(displayMetrics2);
                                                n3 = displayMetrics2.heightPixels;
                                                n2 = displayMetrics2.widthPixels;
                                            } else {
                                                object2 = (Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(display, new Object[0]);
                                                Integer n5 = (Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(display, new Object[0]);
                                                n3 = object2 == null ? 0 : (Integer)object2;
                                                n2 = n5 == null ? 0 : n5;
                                            }
                                            display.getMetrics(displayMetrics2);
                                            int n6 = displayMetrics2.heightPixels;
                                            int n7 = displayMetrics2.widthPixels;
                                            if (n6 != n3 || n7 != n2) break block15;
                                            n3 = displayMetrics.widthPixels;
                                            zzber.zza();
                                            n2 = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
                                            n2 = n2 > 0 ? context.getResources().getDimensionPixelSize(n2) : 0;
                                            this.zzf = n2 = n3 - n2;
                                            break block16;
                                        }
                                        n2 = this.zze;
                                        zzber.zza();
                                        this.zzf = zzcgm.zzk((DisplayMetrics)displayMetrics, (int)this.zze);
                                        break block17;
                                        catch (Exception exception) {}
                                    }
                                    this.zzf = n2 = displayMetrics.widthPixels;
                                }
                                double d = (float)n2 / displayMetrics.density;
                                n3 = (int)d;
                                double d2 = n3;
                                Double.isNaN(d);
                                Double.isNaN(d2);
                                n2 = n3;
                                if (d - d2 >= 0.01) {
                                    n2 = n3 + 1;
                                }
                            }
                            n3 = n == -2 ? zzbdl.zzf(displayMetrics) : this.zzb;
                            zzber.zza();
                            this.zzc = zzcgm.zzk((DisplayMetrics)displayMetrics, (int)n3);
                            if (n4 == -1 || n == -2) break block18;
                            if (this.zzn || this.zzo) break block19;
                            if (!this.zzi) break block20;
                            object = "320x50_mb";
                            break block21;
                        }
                        this.zza = object.toString();
                        break block22;
                    }
                    n = this.zze;
                    n2 = this.zzb;
                    object = new StringBuilder(26);
                    ((StringBuilder)object).append(n);
                    ((StringBuilder)object).append("x");
                    ((StringBuilder)object).append(n2);
                    ((StringBuilder)object).append("_as");
                    object = ((StringBuilder)object).toString();
                }
                this.zza = object;
                break block22;
            }
            object = new StringBuilder(26);
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append("_as");
            this.zza = ((StringBuilder)object).toString();
        }
        n = adSizeArray.length;
        if (n > 1) {
            this.zzg = new zzbdl[n];
            for (n = 0; n < adSizeArray.length; ++n) {
                this.zzg[n] = new zzbdl(context, adSizeArray[n]);
            }
        } else {
            this.zzg = null;
        }
        this.zzh = false;
        this.zzj = false;
    }

    zzbdl(String string, int n, int n2, boolean bl, int n3, int n4, zzbdl[] zzbdlArray, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        this.zza = string;
        this.zzb = n;
        this.zzc = n2;
        this.zzd = bl;
        this.zze = n3;
        this.zzf = n4;
        this.zzg = zzbdlArray;
        this.zzh = bl2;
        this.zzi = bl3;
        this.zzj = bl4;
        this.zzk = bl5;
        this.zzl = bl6;
        this.zzm = bl7;
        this.zzn = bl8;
        this.zzo = bl9;
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return (int)((float)zzbdl.zzf(displayMetrics) * displayMetrics.density);
    }

    public static zzbdl zzb() {
        return new zzbdl("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false);
    }

    public static zzbdl zzc() {
        return new zzbdl("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }

    public static zzbdl zzd() {
        return new zzbdl("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false);
    }

    public static zzbdl zze() {
        return new zzbdl("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
    }

    private static int zzf(DisplayMetrics displayMetrics) {
        int n = (int)((float)displayMetrics.heightPixels / displayMetrics.density);
        if (n <= 400) {
            return 32;
        }
        if (n > 720) return 90;
        return 50;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzb);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)4, (int)this.zzc);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.zzd);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)6, (int)this.zze);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)7, (int)this.zzf);
        SafeParcelWriter.writeTypedArray((Parcel)parcel, (int)8, (Parcelable[])this.zzg, (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)9, (boolean)this.zzh);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)10, (boolean)this.zzi);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)11, (boolean)this.zzj);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)12, (boolean)this.zzk);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)13, (boolean)this.zzl);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)14, (boolean)this.zzm);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)15, (boolean)this.zzn);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)16, (boolean)this.zzo);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
