/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.KeyguardManager
 *  android.content.ActivityNotFoundException
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Rect
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.os.Process
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  androidx.browser.customtabs.CustomTabsIntent$Builder
 *  com.google.android.gms.ads.formats.zzg
 *  com.google.android.gms.ads.impl.R$string
 *  com.google.android.gms.ads.internal.util.zzbr
 *  com.google.android.gms.ads.internal.util.zzbs
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zzcb
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzf
 *  com.google.android.gms.ads.internal.util.zzk
 *  com.google.android.gms.ads.internal.util.zzl
 *  com.google.android.gms.ads.internal.util.zzm
 *  com.google.android.gms.ads.internal.util.zzn
 *  com.google.android.gms.ads.internal.util.zzo
 *  com.google.android.gms.ads.internal.util.zzp
 *  com.google.android.gms.ads.internal.util.zzr
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nativead.NativeAdView
 *  com.google.android.gms.common.util.CrashUtils
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkh
 *  com.google.android.gms.internal.ads.zzbkj
 *  com.google.android.gms.internal.ads.zzblf
 *  com.google.android.gms.internal.ads.zzcbx
 *  com.google.android.gms.internal.ads.zzcgl
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcmc
 *  com.google.android.gms.internal.ads.zzcni
 *  com.google.android.gms.internal.ads.zzdsv
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfla
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzglo
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzk;
import com.google.android.gms.ads.internal.util.zzl;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzn;
import com.google.android.gms.ads.internal.util.zzo;
import com.google.android.gms.ads.internal.util.zzp;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzcbx;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcmc;
import com.google.android.gms.internal.ads.zzcni;
import com.google.android.gms.internal.ads.zzdsv;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfla;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzglo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzs {
    public static final zzfla zza = new zzf(Looper.getMainLooper());
    private static boolean zzd = false;
    private final AtomicReference<Pattern> zzb = new AtomicReference<Object>(null);
    private final AtomicReference<Pattern> zzc = new AtomicReference<Object>(null);
    private boolean zze = true;
    private final Object zzf = new Object();
    private String zzg;
    private boolean zzh = false;
    private boolean zzi = false;
    private final Executor zzj = Executors.newSingleThreadExecutor();

    public static final long zzA(View view) {
        float f;
        float f2;
        float f3 = Float.MAX_VALUE;
        do {
            boolean bl = view instanceof View;
            f = 0.0f;
            f2 = f3;
            if (!bl) break;
            f2 = Math.min(f3, view.getAlpha());
            view = view.getParent();
            f3 = f2;
        } while (!(f2 <= 0.0f));
        if (!(f2 < 0.0f)) return Math.round(f2 * 100.0f);
        f2 = f;
        return Math.round(f2 * 100.0f);
    }

    /*
     * WARNING - void declaration
     */
    public static final WebResourceResponse zzB(Context object, String string, String string2) {
        void var0_5;
        try {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("User-Agent", zzt.zzc().zzi((Context)object, string));
            hashMap.put("Cache-Control", "max-stale=3600");
            string = new zzbr(object);
            string = (String)string.zzb(0, string2, hashMap, null).get(60L, TimeUnit.SECONDS);
            if (string == null) return null;
            object = new ByteArrayInputStream(string.getBytes("UTF-8"));
            object = new WebResourceResponse("application/javascript", "UTF-8", (InputStream)object);
            return object;
        }
        catch (TimeoutException timeoutException) {
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        com.google.android.gms.ads.internal.util.zze.zzj((String)"Could not fetch MRAID JS.", (Throwable)var0_5);
        return null;
    }

    public static final String zzC() {
        Object object = zzt.zzg().zzj();
        object = object != null ? object.getString(R.string.s7) : "Test Ad";
        return object;
    }

    public static final zzbu zzD(Context object) {
        IInterface iInterface = null;
        try {
            object = object.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            zzt.zzg().zzk((Throwable)exception, "Failed to instantiate WorkManagerUtil");
            return null;
        }
        if (!(object instanceof IBinder)) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Instantiated WorkManagerUtil not instance of IBinder.");
            return null;
        }
        object = (object = (IBinder)object) == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil")) instanceof zzbu ? (zzbu)iInterface : new zzbs((IBinder)object));
        return object;
    }

    public static final boolean zzE(Context context, String string2) {
        context = zzcbx.zza((Context)context);
        String string3 = context.getPackageName();
        if (Wrappers.packageManager((Context)context).checkPermission(string2, string3) != 0) return false;
        return true;
    }

    public static final boolean zzF(String string2) {
        int n;
        int n2;
        if (!zzcgs.zzj()) {
            return false;
        }
        Object object = zzbjl.zzdq;
        if (!((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
            return false;
        }
        object = zzbjl.zzds;
        object = (String)zzbet.zzc().zzc((zzbjd)object);
        if (!((String)object).isEmpty()) {
            object = ((String)object).split(";");
            n2 = ((Object)object).length;
            for (n = 0; n < n2; ++n) {
                if (!((String)object[n]).equals(string2)) continue;
                return false;
            }
        }
        object = zzbjl.zzdr;
        object = (String)zzbet.zzc().zzc((zzbjd)object);
        if (((String)object).isEmpty()) {
            return true;
        }
        object = ((String)object).split(";");
        n2 = ((Object)object).length;
        n = 0;
        while (n < n2) {
            if (((String)object[n]).equals(string2)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public static final boolean zzG(Context context) {
        if (context == null) return false;
        if (!PlatformVersion.isAtLeastJellyBean()) {
            return false;
        }
        if ((context = zzs.zzad(context)) == null) return false;
        if (!context.isKeyguardLocked()) return false;
        return true;
    }

    public static final boolean zzH(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        }
        catch (Throwable throwable) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error loading class.", (Throwable)throwable);
            zzt.zzg().zzk(throwable, "AdUtil.isLiteSdk");
            return false;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return true;
        }
    }

    public static final boolean zzI(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            zzbjd zzbjd2 = zzbjl.zzgb;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                synchronized (zzs.class) {
                    boolean bl = zzd;
                    return bl;
                }
            }
        }
        if ((context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) return false;
        if (!context.isConnected()) return false;
        return true;
    }

    public static final boolean zzJ(Context context) {
        try {
            Object object = (ActivityManager)context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService("keyguard");
            if (object == null) return false;
            if (keyguardManager != null) {
                if ((object = object.getRunningAppProcesses()) == null) {
                    return false;
                }
                Iterator iterator = object.iterator();
                do {
                    if (!iterator.hasNext()) return true;
                    object = (ActivityManager.RunningAppProcessInfo)iterator.next();
                } while (Process.myPid() != ((ActivityManager.RunningAppProcessInfo)object).pid);
                if (((ActivityManager.RunningAppProcessInfo)object).importance != 100) return true;
                if (keyguardManager.inKeyguardRestrictedInputMode()) return true;
                if ((context = (PowerManager)context.getSystemService("power")) == null) {
                    return true;
                }
                boolean bl = context.isScreenOn();
                if (!bl) return true;
                return false;
            }
        }
        catch (Throwable throwable) {}
        return false;
    }

    public static final boolean zzK(Context context) {
        context = zzs.zzag(context);
        String string2 = context.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
        if (!TextUtils.isEmpty((CharSequence)zzs.zzaf((Bundle)context))) return false;
        if (TextUtils.isEmpty((CharSequence)string2)) return false;
        return true;
    }

    public static final boolean zzL(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        Window window = ((Activity)context).getWindow();
        if (window == null) return false;
        if (window.getDecorView() == null) {
            return false;
        }
        context = new Rect();
        Rect rect = new Rect();
        window.getDecorView().getGlobalVisibleRect((Rect)context, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        if (context.bottom == 0) return false;
        if (rect.bottom == 0) return false;
        if (context.top != rect.top) return false;
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static final void zzM(View object, int n, MotionEvent motionEvent) {
        long l;
        int n2;
        int n3;
        int n4;
        boolean bl;
        String string2;
        Object object2 = object;
        Object object3 = new int[2];
        Object object4 = new Rect();
        try {
            string2 = object.getContext().getPackageName();
            motionEvent = object2;
            if (object2 instanceof zzdsv) {
                motionEvent = ((zzdsv)object2).getChildAt(0);
            }
            if (!(motionEvent instanceof zzg) && !(bl = motionEvent instanceof NativeAdView)) {
                object = "UNKNOWN";
                n4 = 0;
            } else {
                object = "NATIVE";
                n4 = 1;
            }
            if (motionEvent.getLocalVisibleRect(object4)) {
                n3 = object4.width();
                n2 = object4.height();
            } else {
                n2 = 0;
                n3 = 0;
            }
            zzt.zzc();
            l = zzs.zzA((View)motionEvent);
            motionEvent.getLocationOnScreen(object3);
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Failure getting view location.", (Throwable)exception);
            return;
        }
        int n5 = object3[0];
        int n6 = object3[1];
        {
            bl = motionEvent instanceof zzcni;
            String string3 = "none";
            object2 = bl && (object2 = ((zzcni)motionEvent).zzaB()) != null ? object2.zzb : "none";
            object3 = object;
            int n7 = n4;
            object4 = string3;
            if (motionEvent instanceof zzcmc) {
                zzezz zzezz2 = ((zzcmc)motionEvent).zzF();
                object3 = object;
                n7 = n4;
                object4 = string3;
                if (zzezz2 != null) {
                    object3 = zzezz.zza((int)zzezz2.zzb);
                    n7 = zzezz2.zzf;
                    object4 = zzezz2.zzE;
                }
            }
            com.google.android.gms.ads.internal.util.zze.zzh((String)String.format(Locale.US, "<Ad package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", string2, object4, object2, object3, n7, motionEvent.getClass().getName(), n5, n6, motionEvent.getWidth(), motionEvent.getHeight(), n3, n2, l, Integer.toString(n, 2)));
            return;
        }
    }

    public static final void zzN(Context context, String string2, String object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add((String)object);
        object = arrayList.iterator();
        while (object.hasNext()) {
            new zzcb(context, string2, (String)object.next()).zzc();
        }
    }

    public static final void zzO(Context context, Throwable throwable) {
        block2: {
            if (context == null) return;
            try {
                boolean bl = (Boolean)zzblf.zzb.zze();
                if (!bl) return;
            }
            catch (IllegalStateException illegalStateException) {
                break block2;
            }
            CrashUtils.addDynamiteErrorToDropBox((Context)context, (Throwable)throwable);
        }
    }

    public static final void zzP(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return;
        }
        catch (Throwable throwable) {
            intent.addFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
    }

    public static final int zzQ(String string2) {
        try {
            int n = Integer.parseInt(string2);
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Could not parse value:".concat(((Object)numberFormatException).toString()));
            return 0;
        }
    }

    public static final Map<String, String> zzR(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator iterator = uri.getQueryParameterNames().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            if (TextUtils.isEmpty((CharSequence)string2)) continue;
            hashMap.put(string2, uri.getQueryParameter(string2));
        }
        return hashMap;
    }

    public static final WebResourceResponse zzS(HttpURLConnection httpURLConnection) throws IOException {
        Object object;
        zzt.zzc();
        String string2 = httpURLConnection.getContentType();
        boolean bl = TextUtils.isEmpty((CharSequence)string2);
        Object object2 = "";
        string2 = bl ? "" : string2.split(";")[0].trim();
        zzt.zzc();
        Object object3 = httpURLConnection.getContentType();
        if (TextUtils.isEmpty((CharSequence)object3)) {
            object3 = object2;
        } else {
            object = object3.split(";");
            if (((String[])object).length == 1) {
                object3 = object2;
            } else {
                int n = 1;
                while (true) {
                    object3 = object2;
                    if (n >= ((Object)object).length) break;
                    if (((String)object[n]).trim().startsWith("charset") && ((String[])(object3 = ((String)object[n]).trim().split("="))).length > 1) {
                        object3 = object3[1].trim();
                        break;
                    }
                    ++n;
                }
            }
        }
        object = httpURLConnection.getHeaderFields();
        object2 = new HashMap(object.size());
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            if (entry.getKey() == null || entry.getValue() == null || ((List)entry.getValue()).size() <= 0) continue;
            object2.put((String)entry.getKey(), (String)((List)entry.getValue()).get(0));
        }
        return zzt.zze().zzn(string2, (String)object3, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), (Map)object2, httpURLConnection.getInputStream());
    }

    public static final int[] zzT(Activity activity) {
        if ((activity = activity.getWindow()) == null) return zzs.zzz();
        if ((activity = activity.findViewById(0x1020002)) == null) return zzs.zzz();
        return new int[]{activity.getWidth(), activity.getHeight()};
    }

    protected static final String zzU(Context object) {
        try {
            WebView webView = new WebView(object);
            object = webView.getSettings().getUserAgentString();
            return object;
        }
        catch (Throwable throwable) {
            return zzs.zzw();
        }
    }

    public static final int[] zzV(Activity activity) {
        View view;
        Object object = activity.getWindow();
        if (object != null && (view = object.findViewById(0x1020002)) != null) {
            object = new int[2];
            object[0] = (Window)view.getTop();
            object[1] = (Window)view.getBottom();
        } else {
            object = zzs.zzz();
        }
        return new int[]{zzber.zza().zza((Context)activity, (int)object[0]), zzber.zza().zza((Context)activity, (int)object[1])};
    }

    public static final boolean zzW(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean bl = zzt.zzc().zze;
        boolean bl2 = true;
        boolean bl3 = bl || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzs.zzt(view);
        long l = zzs.zzA(view);
        if (view.getVisibility() == 0 && view.isShown() && (powerManager == null || powerManager.isScreenOn()) && bl3) {
            powerManager = zzbjl.zzaQ;
            if (!((Boolean)zzbet.zzc().zzc((zzbjd)powerManager)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                view = zzbjl.zzgR;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)view) == false) return bl2;
                view = zzbjl.zzgT;
                if (l >= (long)((Integer)zzbet.zzc().zzc((zzbjd)view)).intValue()) return true;
            }
        }
        bl2 = false;
        return bl2;
    }

    public static final void zzX(Context object, Uri object2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", object2);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzs.zzu((Context)object, intent);
            bundle.putString("com.android.browser.application_id", object.getPackageName());
            object.startActivity(intent);
            object2 = object2.toString();
            int n = String.valueOf(object2).length();
            object = new StringBuilder(n + 26);
            ((StringBuilder)object).append("Opening ");
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" in a new browser.");
            com.google.android.gms.ads.internal.util.zze.zzd((String)((StringBuilder)object).toString());
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"No browser is found.", (Throwable)activityNotFoundException);
            return;
        }
    }

    public static final int[] zzY(Activity activity) {
        int[] nArray = zzs.zzT(activity);
        return new int[]{zzber.zza().zza((Context)activity, nArray[0]), zzber.zza().zza((Context)activity, nArray[1])};
    }

    public static final boolean zzZ(View view, Context context) {
        Object object = context.getApplicationContext();
        object = object != null ? (PowerManager)object.getSystemService("power") : null;
        return zzs.zzW(view, (PowerManager)object, zzs.zzad(context));
    }

    static /* synthetic */ boolean zza(boolean bl) {
        zzd = bl;
        return bl;
    }

    private final JSONArray zzaa(Collection<?> object) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        object = object.iterator();
        while (object.hasNext()) {
            this.zzab(jSONArray, object.next());
        }
        return jSONArray;
    }

    private final void zzab(JSONArray jSONArray, Object object) throws JSONException {
        if (object instanceof Bundle) {
            jSONArray.put((Object)this.zzl((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONArray.put((Object)this.zzj((Map)object));
            return;
        }
        if (object instanceof Collection) {
            jSONArray.put((Object)this.zzaa((Collection)object));
            return;
        }
        if (!(object instanceof Object[])) {
            jSONArray.put(object);
            return;
        }
        Object[] objectArray = (Object[])object;
        object = new JSONArray();
        int n = objectArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                jSONArray.put(object);
                return;
            }
            this.zzab((JSONArray)object, objectArray[n2]);
            ++n2;
        }
    }

    private final void zzac(JSONObject jSONObject, String string2, Object object) throws JSONException {
        if (object instanceof Bundle) {
            jSONObject.put(string2, (Object)this.zzl((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONObject.put(string2, (Object)this.zzj((Map)object));
            return;
        }
        if (object instanceof Collection) {
            String string3 = string2;
            if (string2 == null) {
                string3 = "null";
            }
            jSONObject.put(string3, (Object)this.zzaa((Collection)object));
            return;
        }
        if (object instanceof Object[]) {
            jSONObject.put(string2, (Object)this.zzaa(Arrays.asList((Object[])object)));
            return;
        }
        jSONObject.put(string2, object);
    }

    private static KeyguardManager zzad(Context object) {
        if ((object = object.getSystemService("keyguard")) == null) return null;
        if (!(object instanceof KeyguardManager)) return null;
        return (KeyguardManager)object;
    }

    private static boolean zzae(String string2, AtomicReference<Pattern> atomicReference, String string3) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return false;
        }
        try {
            Pattern pattern;
            block7: {
                block6: {
                    Pattern pattern2 = atomicReference.get();
                    if (pattern2 == null) break block6;
                    pattern = pattern2;
                    if (string3.equals(pattern2.pattern())) break block7;
                }
                pattern = Pattern.compile(string3);
                atomicReference.set(pattern);
            }
            boolean bl = pattern.matcher(string2).matches();
            return bl;
        }
        catch (PatternSyntaxException patternSyntaxException) {
            return false;
        }
    }

    private static String zzaf(Bundle object) {
        if (object == null) {
            return "";
        }
        if (TextUtils.isEmpty((CharSequence)(object = object.getString("com.google.android.gms.ads.APPLICATION_ID")))) {
            return "";
        }
        if (((String)object).matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) return object;
        if (!((String)object).matches("^/\\d+~.+$")) return "";
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static Bundle zzag(Context context) {
        void var0_3;
        try {
            context = Wrappers.packageManager((Context)context).getApplicationInfo((String)context.getPackageName(), (int)128).metaData;
            return context;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            // empty catch block
        }
        com.google.android.gms.ads.internal.util.zze.zzb((String)"Error getting metadata", (Throwable)var0_3);
        return null;
    }

    static /* synthetic */ boolean zzb(zzs zzs2, boolean bl) {
        zzs2.zze = bl;
        return bl;
    }

    static /* synthetic */ Object zzc(zzs zzs2) {
        return zzs2.zzf;
    }

    static /* synthetic */ String zzd(zzs zzs2, String string) {
        zzs2.zzg = string;
        return string;
    }

    public static int zze(int n) {
        if (n >= 5000) {
            return n;
        }
        if (n <= 0) return 60000;
        StringBuilder stringBuilder = new StringBuilder(97);
        stringBuilder.append("HTTP timeout too low: ");
        stringBuilder.append(n);
        stringBuilder.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
        com.google.android.gms.ads.internal.util.zze.zzi((String)stringBuilder.toString());
        return 60000;
    }

    public static void zzo(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
            return;
        }
        zzchg.zza.execute(runnable);
    }

    public static final boolean zzt(View object) {
        object = object.getRootView();
        Object var1_1 = null;
        if ((object = object != null && (object = object.getContext()) instanceof Activity ? (Activity)object : null) == null) {
            return false;
        }
        object = (object = object.getWindow()) == null ? var1_1 : object.getAttributes();
        if (object == null) return false;
        if ((object.flags & 0x80000) == 0) return false;
        return true;
    }

    public static final void zzu(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) return;
        Bundle bundle = intent.getExtras() != null ? intent.getExtras() : new Bundle();
        bundle.putBinder("android.support.customtabs.extra.SESSION", null);
        bundle.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(bundle);
    }

    public static final String zzv(Context context) {
        Context context2 = context;
        if (context.getApplicationContext() == null) return zzs.zzaf(zzs.zzag(context2));
        context2 = context.getApplicationContext();
        return zzs.zzaf(zzs.zzag(context2));
    }

    static final String zzw() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuilder.append(" ");
            stringBuilder.append(Build.VERSION.RELEASE);
        }
        stringBuilder.append("; ");
        stringBuilder.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuilder.append("; ");
            stringBuilder.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuilder.append(" Build/");
                stringBuilder.append(Build.DISPLAY);
            }
        }
        stringBuilder.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuilder.toString();
    }

    public static final String zzx() {
        String string2 = Build.MODEL;
        String string3 = Build.MANUFACTURER;
        if (string2.startsWith(string3)) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string3).length() + 1 + String.valueOf(string2).length());
        stringBuilder.append(string3);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static final DisplayMetrics zzy(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    protected static final int[] zzz() {
        return new int[]{0, 0};
    }

    public final void zzf(Context context, String string2, boolean bl, HttpURLConnection httpURLConnection, boolean bl2, int n) {
        n = zzs.zze(n);
        StringBuilder stringBuilder = new StringBuilder(39);
        stringBuilder.append("HTTP timeout: ");
        stringBuilder.append(n);
        stringBuilder.append(" milliseconds.");
        com.google.android.gms.ads.internal.util.zze.zzh((String)stringBuilder.toString());
        httpURLConnection.setConnectTimeout(n);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(n);
        httpURLConnection.setRequestProperty("User-Agent", this.zzi(context, string2));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean zzg(Context context) {
        if (this.zzh) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver((BroadcastReceiver)new zzr(this, null), intentFilter);
        this.zzh = true;
        return true;
    }

    public final boolean zzh(Context context) {
        if (this.zzi) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver((BroadcastReceiver)new zzp(this, null), intentFilter);
        this.zzi = true;
        return true;
    }

    public final String zzi(Context object, String string2) {
        Object object2 = this.zzf;
        synchronized (object2) {
            try {
                Object object3;
                String string3 = this.zzg;
                if (string3 != null) {
                    return string3;
                }
                if (string2 == null) {
                    object = zzs.zzw();
                    return object;
                }
                try {
                    this.zzg = zzt.zze().zzb(object);
                }
                catch (Exception exception) {}
                if (TextUtils.isEmpty((CharSequence)this.zzg)) {
                    zzber.zza();
                    if (zzcgm.zzp()) {
                        this.zzg = zzs.zzU(object);
                    } else {
                        this.zzg = null;
                        object3 = zza;
                        string3 = new zzm(this, object);
                        object3.post((Runnable)((Object)string3));
                        while ((string3 = this.zzg) == null) {
                            try {
                                this.zzf.wait();
                            }
                            catch (InterruptedException interruptedException) {
                                this.zzg = string3 = zzs.zzw();
                                string3 = String.valueOf(string3);
                                string3 = string3.length() != 0 ? "Interrupted, use default user agent: ".concat(string3) : new String("Interrupted, use default user agent: ");
                                com.google.android.gms.ads.internal.util.zze.zzi((String)string3);
                            }
                        }
                    }
                }
                string3 = String.valueOf(this.zzg);
                int n = String.valueOf(string3).length();
                int n2 = string2.length();
                object3 = new StringBuilder(n + 10 + n2);
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(" (Mobile; ");
                ((StringBuilder)object3).append(string2);
                this.zzg = ((StringBuilder)object3).toString();
                try {
                    if (Wrappers.packageManager((Context)object).isCallerInstantApp()) {
                        this.zzg = String.valueOf(this.zzg).concat(";aia");
                    }
                }
                catch (Exception exception) {
                    zzt.zzg().zzk((Throwable)exception, "AdUtil.getUserAgent");
                }
                object = String.valueOf(this.zzg).concat(")");
                this.zzg = object;
                return object;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final JSONObject zzj(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String string2 = iterator.next();
                this.zzac(jSONObject, string2, map.get(string2));
            }
            return jSONObject;
        }
        catch (ClassCastException classCastException) {
            String string3 = String.valueOf(classCastException.getMessage());
            string3 = string3.length() != 0 ? "Could not convert map to JSON: ".concat(string3) : new String("Could not convert map to JSON: ");
            string3 = new JSONException(string3);
            throw string3;
        }
    }

    public final JSONObject zzk(Bundle bundle, JSONObject jSONObject) {
        Object var3_4 = null;
        jSONObject = var3_4;
        if (bundle == null) return jSONObject;
        try {
            jSONObject = this.zzl(bundle);
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error converting Bundle to JSON", (Throwable)jSONException);
            jSONObject = var3_4;
        }
        return jSONObject;
    }

    public final JSONObject zzl(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            this.zzac(jSONObject, string2, bundle.get(string2));
        }
        return jSONObject;
    }

    public final zzfsm<Map<String, String>> zzm(Uri uri) {
        return zzfsd.zzd((Callable)new zzk(uri), (Executor)this.zzj);
    }

    public final void zzn(Context context, String string2, String string3, Bundle bundle, boolean bl) {
        zzt.zzc();
        bundle.putString("device", zzs.zzx());
        bundle.putString("eids", TextUtils.join((CharSequence)",", (Iterable)zzbjl.zzc()));
        zzber.zza();
        zzcgm.zzr((Context)context, (String)string2, (String)"gmob-apps", (Bundle)bundle, (boolean)true, (zzcgl)new zzn(this, context, string2));
    }

    public final boolean zzp(String string2) {
        AtomicReference<Pattern> atomicReference = this.zzb;
        zzbjd zzbjd2 = zzbjl.zzW;
        return zzs.zzae(string2, atomicReference, (String)zzbet.zzc().zzc(zzbjd2));
    }

    public final boolean zzq(String string2) {
        AtomicReference<Pattern> atomicReference = this.zzc;
        zzbjd zzbjd2 = zzbjl.zzX;
        return zzs.zzae(string2, atomicReference, (String)zzbet.zzc().zzc(zzbjd2));
    }

    public final void zzr(Context context) {
        if (!PlatformVersion.isAtLeastO()) {
            return;
        }
        zzbjd zzbjd2 = zzbjl.zzgb;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        ((ConnectivityManager)context.getSystemService("connectivity")).registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)new zzo(this));
    }

    public final int zzs(Context context, Uri uri) {
        int n;
        if (context == null) {
            com.google.android.gms.ads.internal.util.zze.zza((String)"Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            com.google.android.gms.ads.internal.util.zze.zza((String)"Chrome Custom Tabs can only work with version Jellybean onwards.");
            n = 1;
        } else if (!(context instanceof Activity)) {
            com.google.android.gms.ads.internal.util.zze.zza((String)"Chrome Custom Tabs can only work with Activity context.");
            n = 2;
        } else {
            n = 0;
        }
        zzbjd zzbjd2 = zzbjl.zzcW;
        Boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
        zzbjd2 = zzbjl.zzcX;
        if (bl.equals(zzbet.zzc().zzc(zzbjd2))) {
            n = 9;
        }
        if (n != 0) {
            zzbjd2 = new Intent("android.intent.action.VIEW");
            zzbjd2.setData(uri);
            zzbjd2.addFlags(0x10000000);
            context.startActivity((Intent)zzbjd2);
            return n;
        }
        zzbjd2 = zzbjl.zzcW;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzbjd2 = new zzbkj();
            zzbjd2.zzd((zzbkh)new zzl(this, (zzbkj)zzbjd2, context, uri));
            zzbjd2.zze((Activity)context);
        }
        zzbjd2 = zzbjl.zzcX;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return 5;
        zzbjd2 = new CustomTabsIntent.Builder().build();
        zzbjd2.intent.setPackage(zzglo.zza((Context)context));
        zzbjd2.launchUrl(context, uri);
        return 5;
    }
}
