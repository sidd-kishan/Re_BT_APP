/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowManager$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzflk
 *  com.google.android.gms.internal.ads.zzfmg
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzfmg;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzca {
    public static boolean zza(int n) {
        zzbjd zzbjd2 = zzbjl.zzbY;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return true;
        zzbjd2 = zzbjl.zzbZ;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return true;
        if (n > 15299999) return false;
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public static JSONObject zzb(Context var0, View var1_7) {
        block25: {
            block22: {
                var4_8 = new JSONObject();
                if (var1_7 == null) {
                    return var4_8;
                }
                try {
                    var5_9 = zzca.zzg(var1_7);
                    var6_10 = new int[]{var1_7.getMeasuredWidth(), var1_7.getMeasuredHeight()};
                    var3_11 = var1_7.getParent();
                    while (var3_11 instanceof ViewGroup) {
                        var7_12 = (ViewGroup)var3_11;
                        var6_10[0] = Math.min(var7_12.getMeasuredWidth(), var6_10[0]);
                        var6_10[1] = Math.min(var7_12.getMeasuredHeight(), var6_10[1]);
                        var3_11 = var3_11.getParent();
                    }
                    var3_11 = new JSONObject();
                    var2_13 = var1_7.getMeasuredWidth();
                    var3_11.put("width", zzber.zza().zza((Context)var0, var2_13));
                    var2_13 = var1_7.getMeasuredHeight();
                    var3_11.put("height", zzber.zza().zza((Context)var0, var2_13));
                }
                catch (Exception var0_1) {
                    zze.zzi((String)"Unable to get native ad view bounding box");
                    break block22;
                }
                var2_13 = var5_9[0];
                {
                    var3_11.put("x", zzber.zza().zza((Context)var0, var2_13));
                }
                var2_13 = var5_9[1];
                {
                    var3_11.put("y", zzber.zza().zza((Context)var0, var2_13));
                }
                var2_13 = var6_10[0];
                {
                    var3_11.put("maximum_visible_width", zzber.zza().zza((Context)var0, var2_13));
                }
                var2_13 = var6_10[1];
                {
                    block24: {
                        var3_11.put("maximum_visible_height", zzber.zza().zza((Context)var0, var2_13));
                        var3_11.put("relative_to", (Object)"window");
                        var4_8.put("frame", (Object)var3_11);
                        var3_11 = new Rect();
                        if (!var1_7.getGlobalVisibleRect((Rect)var3_11)) break block24;
                        var0 = zzca.zzk((Context)var0, (Rect)var3_11);
                        ** GOTO lbl60
                    }
                    var3_11 = new JSONObject();
                    var3_11.put("width", 0);
                    var3_11.put("height", 0);
                }
                var2_13 = var5_9[0];
                {
                    var3_11.put("x", zzber.zza().zza((Context)var0, var2_13));
                }
                var2_13 = var5_9[1];
                {
                    var3_11.put("y", zzber.zza().zza((Context)var0, var2_13));
                    var3_11.put("relative_to", (Object)"window");
                    var0 = var3_11;
lbl60:
                    // 2 sources

                    var4_8.put("visible_bounds", var0);
                }
            }
            var0 = zzbjl.zzez;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)var0) == false) return var4_8;
            var0 = var1_7.getParent();
            if (var0 == null) break block25;
            try {
                var0 = (String)var0.getClass().getMethod("getTemplateTypeName", new Class[0]).invoke(var0, new Object[0]);
                ** GOTO lbl80
            }
            catch (InvocationTargetException var0_2) {
            }
            catch (IllegalAccessException var0_3) {
            }
            catch (SecurityException var0_4) {
                // empty catch block
            }
        }
lbl78:
        // 3 sources

        while (true) {
            block23: {
                var0 = "";
lbl80:
                // 2 sources

                try {
                    block27: {
                        block26: {
                            var2_13 = var0.hashCode();
                            if (var2_13 == -2066603854) break block26;
                            if (var2_13 != 2019754500 || !var0.equals("medium_template")) ** GOTO lbl-1000
                            var2_13 = 1;
                            break block27;
                        }
                        if (var0.equals("small_template")) {
                            var2_13 = 0;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_13 = -1;
                        }
                    }
                    if (var2_13 == 0) ** GOTO lbl105
                    if (var2_13 != 1) {
                    }
                    ** GOTO lbl102
                }
                catch (JSONException var0_5) {
                    zze.zzg((String)"Could not log native template signal to JSON", (Throwable)var0_5);
                    break block23;
                }
                {
                    var4_8.put("native_template_type", 0);
                    break block23;
lbl102:
                    // 1 sources

                    var4_8.put("native_template_type", 2);
                    break block23;
lbl105:
                    // 1 sources

                    var4_8.put("native_template_type", 1);
                }
            }
            return var4_8;
        }
        catch (NoSuchMethodException var0_6) {
        }
        zze.zzg((String)"Cannot access method getTemplateTypeName: ", (Throwable)var0);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public static JSONObject zzc(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzbjd zzbjd2 = zzbjl.zzfF;
            boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
            boolean bl2 = false;
            boolean bl3 = false;
            if (bl) {
                zzt.zzc();
                for (view = view.getParent(); view != null && !(view instanceof ScrollView); view = view.getParent()) {
                }
                if (view != null) {
                    bl3 = true;
                }
                jSONObject.put("contained_in_scroll_view", bl3);
                return jSONObject;
            }
            zzt.zzc();
            for (zzbjd2 = view.getParent(); zzbjd2 != null && !(zzbjd2 instanceof AdapterView); zzbjd2 = zzbjd2.getParent()) {
            }
            int n = zzbjd2 == null ? -1 : ((AdapterView)zzbjd2).getPositionForView(view);
            bl3 = bl2;
            if (n != -1) {
                bl3 = true;
            }
            jSONObject.put("contained_in_scroll_view", bl3);
            return jSONObject;
        }
        catch (Exception exception) {
            return jSONObject;
        }
    }

    public static JSONObject zzd(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzt.zzc();
            jSONObject.put("can_show_on_lock_screen", zzs.zzt((View)view));
            zzt.zzc();
            jSONObject.put("is_keyguard_locked", zzs.zzG((Context)context));
        }
        catch (JSONException jSONException) {
            zze.zzi((String)"Unable to get lock screen information");
        }
        return jSONObject;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static JSONObject zze(Context context, Map<String, WeakReference<View>> iterator, Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (iterator == null) return jSONObject;
        if (view == null) {
            return jSONObject;
        }
        int[] nArray = zzca.zzg(view);
        iterator = iterator.entrySet().iterator();
        view = jSONObject;
        while (iterator.hasNext()) {
            block11: {
                String string;
                Map.Entry entry = iterator.next();
                View view2 = (View)((WeakReference)entry.getValue()).get();
                if (view2 == null) continue;
                int[] nArray2 = zzca.zzg(view2);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                int n = view2.getMeasuredWidth();
                try {
                    void var7_10;
                    jSONObject3.put("width", zzber.zza().zza(context, n));
                    n = view2.getMeasuredHeight();
                    jSONObject3.put("height", zzber.zza().zza(context, n));
                    n = nArray2[0];
                    int n2 = nArray[0];
                    jSONObject3.put("x", zzber.zza().zza(context, n - n2));
                    n = nArray2[1];
                    n2 = nArray[1];
                    jSONObject3.put("y", zzber.zza().zza(context, n - n2));
                    jSONObject3.put("relative_to", (Object)"ad_view");
                    jSONObject2.put("frame", (Object)jSONObject3);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        JSONObject jSONObject4 = zzca.zzk(context, rect);
                    } else {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("width", 0);
                        jSONObject5.put("height", 0);
                        n2 = nArray2[0];
                        n = nArray[0];
                        jSONObject5.put("x", zzber.zza().zza(context, n2 - n));
                        n = nArray2[1];
                        n2 = nArray[1];
                        jSONObject5.put("y", zzber.zza().zza(context, n - n2));
                        jSONObject5.put("relative_to", (Object)"ad_view");
                    }
                    jSONObject2.put("visible_bounds", (Object)var7_10);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView)view2;
                        jSONObject2.put("text_color", textView.getCurrentTextColor());
                        jSONObject2.put("font_size", (double)textView.getTextSize());
                        jSONObject2.put("text", (Object)textView.getText());
                    }
                    boolean bl = map != null && map.containsKey(entry.getKey()) && view2.isClickable();
                    jSONObject2.put("is_clickable", bl);
                    string = (String)entry.getKey();
                }
                catch (JSONException jSONException) {}
                try {
                    view.put(string, (Object)jSONObject2);
                    continue;
                }
                catch (JSONException jSONException) {}
                break block11;
                catch (JSONException jSONException) {
                    // empty catch block
                }
            }
            zze.zzi((String)"Unable to get asset views information");
        }
        return view;
    }

    /*
     * WARNING - void declaration
     */
    public static JSONObject zzf(String string, Context context, Point point, Point point2) {
        Object object;
        block7: {
            void var1_5;
            block6: {
                JSONObject jSONObject = null;
                Object var7_9 = null;
                try {
                    object = new JSONObject();
                }
                catch (Exception exception) {
                    string = jSONObject;
                    break block6;
                }
                try {
                    jSONObject = new JSONObject();
                    try {
                        int n = point2.x;
                        jSONObject.put("x", zzber.zza().zza(context, n));
                        n = point2.y;
                        jSONObject.put("y", zzber.zza().zza(context, n));
                        n = point.x;
                        jSONObject.put("start_x", zzber.zza().zza(context, n));
                        n = point.y;
                        jSONObject.put("start_y", zzber.zza().zza(context, n));
                        context = jSONObject;
                    }
                    catch (JSONException jSONException) {
                        zze.zzg((String)"Error occurred while putting signals into JSON object.", (Throwable)jSONException);
                        context = var7_9;
                    }
                    object.put("click_point", (Object)context);
                    object.put("asset_id", (Object)string);
                    break block7;
                }
                catch (Exception exception) {
                    string = object;
                }
            }
            zze.zzg((String)"Error occurred while grabbing click signals.", (Throwable)var1_5);
            object = string;
        }
        return object;
    }

    public static int[] zzg(View view) {
        int[] nArray = new int[2];
        if (view == null) return nArray;
        view.getLocationOnScreen(nArray);
        return nArray;
    }

    public static Point zzh(MotionEvent motionEvent, View object) {
        object = zzca.zzg(object);
        float f = motionEvent.getRawX();
        View view = object[0];
        float f2 = motionEvent.getRawY();
        View view2 = object[1];
        return new Point((int)f - view, (int)f2 - view2);
    }

    public static boolean zzi(Context object, zzezz object2) {
        if (!((zzezz)object2).zzJ) {
            return false;
        }
        object2 = zzbjl.zzfG;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) {
            object = zzbjl.zzfJ;
            return (Boolean)zzbet.zzc().zzc((zzbjd)object);
        }
        object2 = zzbjl.zzfH;
        object2 = (String)zzbet.zzc().zzc((zzbjd)object2);
        if (((String)object2).isEmpty()) return false;
        if (object == null) {
            return false;
        }
        object = object.getPackageName();
        object2 = zzfmg.zzb((zzflk)zzflk.zzb((char)';')).zzd((CharSequence)object2).iterator();
        do {
            if (!object2.hasNext()) return false;
        } while (!((String)object2.next()).equals(object));
        return true;
    }

    public static WindowManager.LayoutParams zzj() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        zzbjd zzbjd2 = zzbjl.zzfI;
        layoutParams.flags = (Integer)zzbet.zzc().zzc(zzbjd2);
        layoutParams.type = 2;
        layoutParams.gravity = 0x800033;
        return layoutParams;
    }

    private static JSONObject zzk(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int n = rect.right;
        int n2 = rect.left;
        jSONObject.put("width", zzber.zza().zza(context, n - n2));
        n2 = rect.bottom;
        n = rect.top;
        jSONObject.put("height", zzber.zza().zza(context, n2 - n));
        n = rect.left;
        jSONObject.put("x", zzber.zza().zza(context, n));
        n = rect.top;
        jSONObject.put("y", zzber.zza().zza(context, n));
        jSONObject.put("relative_to", (Object)"self");
        return jSONObject;
    }
}
