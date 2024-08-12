/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.UiModeManager
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.Display
 *  androidx.core.view.DisplayCompat$Api17Impl
 *  androidx.core.view.DisplayCompat$Api23Impl
 *  androidx.core.view.DisplayCompat$ModeCompat
 */
package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.view.DisplayCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    private DisplayCompat() {
    }

    static Point getCurrentDisplaySizeFromWorkarounds(Context context, Display display) {
        Point point = Build.VERSION.SDK_INT < 28 ? DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display) : DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        if (point != null) {
            return point;
        }
        boolean bl = DisplayCompat.isSonyBravia4kTv(context);
        point = null;
        context = point;
        if (!bl) return context;
        context = point;
        if (!DisplayCompat.isCurrentModeTheLargestMode(display)) return context;
        context = new Point(3840, 2160);
        return context;
    }

    private static Point getDisplaySize(Context context, Display display) {
        if ((context = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display)) != null) {
            return context;
        }
        context = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.getRealSize((Display)display, (Point)context);
        } else {
            display.getSize((Point)context);
        }
        return context;
    }

    public static ModeCompat getMode(Context context, Display display) {
        if (Build.VERSION.SDK_INT < 23) return new ModeCompat(DisplayCompat.getDisplaySize(context, display));
        return Api23Impl.getMode((Context)context, (Display)display);
    }

    public static ModeCompat[] getSupportedModes(Context context, Display display) {
        if (Build.VERSION.SDK_INT < 23) return new ModeCompat[]{DisplayCompat.getMode(context, display)};
        return Api23Impl.getSupportedModes((Context)context, (Display)display);
    }

    private static String getSystemProperty(String string) {
        try {
            Class<?> clazz = Class.forName("android.os.SystemProperties");
            string = (String)clazz.getMethod("get", String.class).invoke(clazz, string);
            return string;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static boolean isCurrentModeTheLargestMode(Display display) {
        if (Build.VERSION.SDK_INT < 23) return true;
        return Api23Impl.isCurrentModeTheLargestMode((Display)display);
    }

    private static boolean isSonyBravia4kTv(Context context) {
        boolean bl = DisplayCompat.isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
        return bl;
    }

    private static boolean isTv(Context context) {
        boolean bl = (context = (UiModeManager)context.getSystemService("uimode")) != null && context.getCurrentModeType() == 4;
        return bl;
    }

    private static Point parseDisplaySize(String stringArray) throws NumberFormatException {
        if ((stringArray = stringArray.trim().split("x", -1)).length != 2) throw new NumberFormatException();
        int n = Integer.parseInt(stringArray[0]);
        int n2 = Integer.parseInt(stringArray[1]);
        if (n <= 0) throw new NumberFormatException();
        if (n2 <= 0) throw new NumberFormatException();
        return new Point(n, n2);
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String string, Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        if (TextUtils.isEmpty((CharSequence)(string = DisplayCompat.getSystemProperty(string)))) {
            return null;
        }
        try {
            string = DisplayCompat.parseDisplaySize(string);
            return string;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
}
