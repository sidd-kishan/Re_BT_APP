/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.Rect
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  android.view.WindowManager$LayoutParams
 *  com.google.android.gms.ads.internal.util.zzaa
 *  com.google.android.gms.ads.internal.util.zzab
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzaa;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzac
extends zzaa {
    static final /* synthetic */ WindowInsets zzs(Activity activity, View view, WindowInsets windowInsets) {
        if (zzt.zzg().zzp().zzz() == null) {
            Object object2 = windowInsets.getDisplayCutout();
            String string = "";
            if (object2 == null) {
                zzt.zzg().zzp().zzA("");
            } else {
                zzg zzg2 = zzt.zzg().zzp();
                for (Object object2 : object2.getBoundingRects()) {
                    String string2 = String.format(Locale.US, "%d,%d,%d,%d", ((Rect)object2).left, ((Rect)object2).top, ((Rect)object2).right, ((Rect)object2).bottom);
                    object2 = string;
                    if (!TextUtils.isEmpty((CharSequence)string)) {
                        object2 = String.valueOf(string).concat("|");
                    }
                    string = String.valueOf(object2);
                    object2 = String.valueOf(string2);
                    if (((String)object2).length() != 0) {
                        string = string.concat((String)object2);
                        continue;
                    }
                    string = new String(string);
                }
                zzg2.zzA(string);
            }
        }
        zzac.zzv(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static final void zzv(boolean bl, Activity activity) {
        activity = activity.getWindow();
        WindowManager.LayoutParams layoutParams = activity.getAttributes();
        int n = layoutParams.layoutInDisplayCutoutMode;
        int n2 = 1;
        if (!bl) {
            n2 = 2;
        }
        if (n2 == n) return;
        layoutParams.layoutInDisplayCutoutMode = n2;
        activity.setAttributes(layoutParams);
    }

    public final void zzr(Activity activity) {
        zzbjd zzbjd2 = zzbjl.zzaN;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        if (zzt.zzg().zzp().zzz() != null) return;
        if (activity.isInMultiWindowMode()) return;
        zzac.zzv(true, activity);
        activity.getWindow().getDecorView().setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)new zzab(this, activity));
    }
}
