/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.google.android.gms.ads.AdLoader
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.AdView
 *  com.google.android.gms.ads.admanager.AdManagerAdView
 *  com.google.android.gms.ads.admanager.AdManagerInterstitialAd
 *  com.google.android.gms.ads.interstitial.InterstitialAd
 *  com.google.android.gms.ads.search.SearchAdView
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzblf
 *  com.google.android.gms.internal.ads.zzcgk
 *  com.google.android.gms.internal.ads.zzcgl
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzfla
 */
package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzcgk;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzfla;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzcgm {
    public static final Handler zza = new zzfla(Looper.getMainLooper());
    private static final String zzb = AdView.class.getName();
    private static final String zzc = InterstitialAd.class.getName();
    private static final String zzd = AdManagerAdView.class.getName();
    private static final String zze = AdManagerInterstitialAd.class.getName();
    private static final String zzf = SearchAdView.class.getName();
    private static final String zzg = AdLoader.class.getName();
    private float zzh = -1.0f;

    public static String zzd(String string) {
        int n = 0;
        while (n < 2) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(string.getBytes());
                Object object = Locale.US;
                BigInteger bigInteger = new BigInteger(1, messageDigest.digest());
                object = String.format((Locale)object, "%032X", bigInteger);
                return object;
            }
            catch (ArithmeticException arithmeticException) {
                return null;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        return null;
    }

    public static String zzf() {
        Object object = UUID.randomUUID();
        byte[] byArray = BigInteger.valueOf(((UUID)object).getLeastSignificantBits()).toByteArray();
        byte[] byArray2 = BigInteger.valueOf(((UUID)object).getMostSignificantBits()).toByteArray();
        object = new BigInteger(1, byArray).toString();
        int n = 0;
        while (n < 2) {
            block3: {
                Object object2;
                try {
                    Object object3 = MessageDigest.getInstance("MD5");
                    ((MessageDigest)object3).update(byArray);
                    ((MessageDigest)object3).update(byArray2);
                    object2 = new byte[8];
                    System.arraycopy(((MessageDigest)object3).digest(), 0, object2, 0, 8);
                    object3 = new BigInteger(1, (byte[])object2);
                    object2 = ((BigInteger)object3).toString();
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    break block3;
                }
                object = object2;
            }
            ++n;
        }
        return object;
    }

    public static Throwable zzg(Throwable throwable) {
        if (((Boolean)zzblf.zzf.zze()).booleanValue()) {
            return throwable;
        }
        LinkedList<Throwable> linkedList = new LinkedList<Throwable>();
        while (throwable != null) {
            linkedList.push(throwable);
            throwable = throwable.getCause();
        }
        throwable = null;
        while (!linkedList.isEmpty()) {
            Throwable throwable2 = (Throwable)linkedList.pop();
            StackTraceElement[] stackTraceElementArray = throwable2.getStackTrace();
            ArrayList<StackTraceElement> arrayList = new ArrayList<StackTraceElement>();
            arrayList.add(new StackTraceElement(throwable2.getClass().getName(), "<filtered>", "<filtered>", 1));
            int n = stackTraceElementArray.length;
            boolean bl = false;
            for (int i = 0; i < n; ++i) {
                StackTraceElement stackTraceElement = stackTraceElementArray[i];
                if (zzcgm.zzi(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    bl = true;
                    continue;
                }
                String string = stackTraceElement.getClassName();
                if (TextUtils.isEmpty((CharSequence)string) || !string.startsWith("android.") && !string.startsWith("java.")) {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                    continue;
                }
                arrayList.add(stackTraceElement);
            }
            if (!bl) continue;
            throwable = throwable == null ? new Throwable(throwable2.getMessage()) : new Throwable(throwable2.getMessage(), throwable);
            throwable.setStackTrace(arrayList.toArray(new StackTraceElement[0]));
        }
        return throwable;
    }

    public static AdSize zzh(Context context, int n, int n2, int n3) {
        n2 = zzcgm.zzj(context, n3);
        if (n2 == -1) {
            return AdSize.INVALID;
        }
        n3 = Math.min(90, Math.round((float)n2 * 0.15f));
        n2 = n > 655 ? Math.round((float)n / 728.0f * 90.0f) : (n > 632 ? 81 : (n > 526 ? Math.round((float)n / 468.0f * 60.0f) : (n > 432 ? 68 : Math.round((float)n / 320.0f * 50.0f))));
        return new AdSize(n, Math.max(Math.min(n2, n3), 50));
    }

    public static boolean zzi(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) return string.startsWith((String)zzblf.zzd.zze());
        return false;
    }

    public static int zzj(Context context, int n) {
        if (context == null) {
            return -1;
        }
        Context context2 = context;
        if (context.getApplicationContext() != null) {
            context2 = context.getApplicationContext();
        }
        if ((context2 = context2.getResources()) == null) {
            return -1;
        }
        context = context2.getDisplayMetrics();
        if (context == null) {
            return -1;
        }
        if ((context2 = context2.getConfiguration()) == null) {
            return -1;
        }
        int n2 = context2.orientation;
        int n3 = n;
        if (n == 0) {
            n3 = n2;
        }
        if (n3 != n2) return Math.round((float)context.widthPixels / context.density);
        return Math.round((float)context.heightPixels / context.density);
    }

    public static final int zzk(DisplayMetrics displayMetrics, int n) {
        return (int)TypedValue.applyDimension((int)1, (float)n, (DisplayMetrics)displayMetrics);
    }

    public static final String zzl(StackTraceElement[] object, String string) {
        CharSequence charSequence;
        Object object2;
        int n;
        block4: {
            int n2;
            n = 0;
            while ((n2 = n + 1) < ((StackTraceElement[])object).length) {
                object2 = object[n];
                charSequence = ((StackTraceElement)object2).getClassName();
                if ("loadAd".equalsIgnoreCase(((StackTraceElement)object2).getMethodName()) && (zzb.equalsIgnoreCase((String)charSequence) || zzc.equalsIgnoreCase((String)charSequence) || zzd.equalsIgnoreCase((String)charSequence) || zze.equalsIgnoreCase((String)charSequence) || zzf.equalsIgnoreCase((String)charSequence) || zzg.equalsIgnoreCase((String)charSequence))) {
                    object = object[n2].getClassName();
                    break block4;
                }
                n = n2;
            }
            object = null;
        }
        if (string == null) return null;
        object2 = new StringTokenizer(string, ".");
        charSequence = new StringBuilder();
        if (((StringTokenizer)object2).hasMoreElements()) {
            ((StringBuilder)charSequence).append(((StringTokenizer)object2).nextToken());
            for (n = 2; n > 0 && ((StringTokenizer)object2).hasMoreElements(); --n) {
                ((StringBuilder)charSequence).append(".");
                ((StringBuilder)charSequence).append(((StringTokenizer)object2).nextToken());
            }
            string = ((StringBuilder)charSequence).toString();
        }
        if (object == null) return null;
        if (object.contains(string)) return null;
        return object;
    }

    public static final boolean zzm() {
        return Build.DEVICE.startsWith("generic");
    }

    public static final boolean zzn(Context context, int n) {
        if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, n) != 0) return false;
        return true;
    }

    public static final boolean zzo(Context context) {
        int n = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000);
        if (n == 0) return true;
        if (n != 2) return false;
        return true;
    }

    public static final boolean zzp() {
        if (Looper.myLooper() != Looper.getMainLooper()) return false;
        return true;
    }

    public static final int zzq(DisplayMetrics displayMetrics, int n) {
        return Math.round((float)n / displayMetrics.density);
    }

    public static final void zzr(Context object, String string, String object2, Bundle bundle, boolean bl, zzcgl zzcgl2) {
        Context context = object.getApplicationContext();
        object2 = context;
        if (context == null) {
            object2 = object;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", object2.getPackageName());
        object2 = string;
        if (string == null) {
            int n = GoogleApiAvailabilityLight.getInstance().getApkVersion((Context)object);
            object = new StringBuilder(23);
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(".213806000");
            object2 = ((StringBuilder)object).toString();
        }
        bundle.putString("js", (String)object2);
        string = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps");
        object2 = bundle.keySet().iterator();
        while (true) {
            if (!object2.hasNext()) {
                zzcgl2.zza(string.toString());
                return;
            }
            object = (String)object2.next();
            string.appendQueryParameter((String)object, bundle.getString((String)object));
        }
    }

    public static final int zzs(Context context, int n) {
        return zzcgm.zzk(context.getResources().getDisplayMetrics(), n);
    }

    public static final String zzt(Context object) {
        if ((object = (object = object.getContentResolver()) == null ? null : Settings.Secure.getString((ContentResolver)object, (String)"android_id")) != null) {
            if (!zzcgm.zzm()) return zzcgm.zzd((String)object);
        }
        object = "emulator";
        return zzcgm.zzd((String)object);
    }

    private static final void zzu(ViewGroup viewGroup, zzbdl zzbdl2, String string, int n, int n2) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText((CharSequence)string);
        textView.setTextColor(n);
        textView.setBackgroundColor(n2);
        string = new FrameLayout(context);
        string.setBackgroundColor(n);
        n = zzcgm.zzs(context, 3);
        string.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(zzbdl2.zzf - n, zzbdl2.zzc - n, 17));
        viewGroup.addView((View)string, zzbdl2.zzf, zzbdl2.zzc);
    }

    public final int zza(Context context, int n) {
        if (!(this.zzh < 0.0f)) return Math.round((float)n / this.zzh);
        synchronized (this) {
            if (!(this.zzh < 0.0f)) return Math.round((float)n / this.zzh);
            if ((context = (WindowManager)context.getSystemService("window")) == null) {
                return 0;
            }
            Display display = context.getDefaultDisplay();
            context = new DisplayMetrics();
            display.getMetrics((DisplayMetrics)context);
            this.zzh = context.density;
        }
        return Math.round((float)n / this.zzh);
    }

    public final void zzb(ViewGroup viewGroup, zzbdl zzbdl2, String string, String string2) {
        if (string2 != null) {
            zzcgt.zzi((String)string2);
        }
        zzcgm.zzu(viewGroup, zzbdl2, string, -65536, -16777216);
    }

    public final void zzc(ViewGroup viewGroup, zzbdl zzbdl2, String string) {
        zzcgm.zzu(viewGroup, zzbdl2, "Ads by Google", -16777216, -1);
    }

    public final void zze(Context context, String string, String string2, Bundle bundle, boolean bl) {
        zzcgm.zzr(context, string, "gmob-apps", bundle, true, (zzcgl)new zzcgk(this));
    }
}
