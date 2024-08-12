/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ViewGroup
 *  androidx.transition.ViewGroupOverlayApi14
 *  androidx.transition.ViewGroupOverlayApi18
 *  androidx.transition.ViewGroupOverlayImpl
 *  androidx.transition.ViewGroupUtilsApi14
 */
package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.transition.ViewGroupOverlayApi14;
import androidx.transition.ViewGroupOverlayApi18;
import androidx.transition.ViewGroupOverlayImpl;
import androidx.transition.ViewGroupUtilsApi14;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    private ViewGroupUtils() {
    }

    /*
     * Unable to fully structure code
     */
    static int getChildDrawingOrder(ViewGroup var0, int var1_2) {
        block7: {
            block6: {
                if (Build.VERSION.SDK_INT >= 29) {
                    return var0.getChildDrawingOrder(var1_2);
                }
                if (ViewGroupUtils.sGetChildDrawingOrderMethodFetched) ** GOTO lbl-1000
                try {
                    ViewGroupUtils.sGetChildDrawingOrderMethod = var3_3 = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[]{Integer.TYPE, Integer.TYPE});
                    var3_3.setAccessible(true);
lbl7:
                    // 2 sources

                    while (true) {
                        ViewGroupUtils.sGetChildDrawingOrderMethodFetched = true;
                        break;
                    }
                }
                catch (NoSuchMethodException var3_4) {
                    ** continue;
                }
lbl-1000:
                // 2 sources

                {
                    if ((var3_3 = ViewGroupUtils.sGetChildDrawingOrderMethod) == null) return var1_2;
                    ** try [egrp 1[TRYBLOCK] [1, 2 : 65->98)] { 
lbl13:
                    // 1 sources

                    break block6;
lbl14:
                    // 2 sources

                    catch (IllegalAccessException | InvocationTargetException var0_1) {
                        break block7;
                    }
                }
            }
            var2_5 = (Integer)var3_3.invoke(var0, new Object[]{var0.getChildCount(), var1_2});
            return var2_5;
        }
        return var1_2;
    }

    static ViewGroupOverlayImpl getOverlay(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT < 18) return ViewGroupOverlayApi14.createFrom((ViewGroup)viewGroup);
        return new ViewGroupOverlayApi18(viewGroup);
    }

    private static void hiddenSuppressLayout(ViewGroup viewGroup, boolean bl) {
        if (!sTryHiddenSuppressLayout) return;
        try {
            viewGroup.suppressLayout(bl);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            sTryHiddenSuppressLayout = false;
        }
    }

    static void suppressLayout(ViewGroup viewGroup, boolean bl) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(bl);
        } else if (Build.VERSION.SDK_INT >= 18) {
            ViewGroupUtils.hiddenSuppressLayout(viewGroup, bl);
        } else {
            ViewGroupUtilsApi14.suppressLayout((ViewGroup)viewGroup, (boolean)bl);
        }
    }
}
