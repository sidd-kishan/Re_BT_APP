/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.view.Display
 *  android.view.Display$Mode
 *  androidx.core.view.DisplayCompat
 *  androidx.core.view.DisplayCompat$ModeCompat
 */
package androidx.core.view;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import androidx.core.view.DisplayCompat;

/*
 * Exception performing whole class analysis ignored.
 */
static class DisplayCompat.Api23Impl {
    private DisplayCompat.Api23Impl() {
    }

    static DisplayCompat.ModeCompat getMode(Context context, Display display) {
        Display.Mode mode = display.getMode();
        context = (context = DisplayCompat.getCurrentDisplaySizeFromWorkarounds((Context)context, (Display)display)) != null && !DisplayCompat.Api23Impl.physicalSizeEquals(mode, (Point)context) ? new DisplayCompat.ModeCompat(mode, (Point)context) : new DisplayCompat.ModeCompat(mode, true);
        return context;
    }

    public static DisplayCompat.ModeCompat[] getSupportedModes(Context context, Display display) {
        int n;
        Display.Mode[] modeArray = display.getSupportedModes();
        DisplayCompat.ModeCompat[] modeCompatArray = new DisplayCompat.ModeCompat[modeArray.length];
        Display.Mode mode = display.getMode();
        display = DisplayCompat.getCurrentDisplaySizeFromWorkarounds((Context)context, (Display)display);
        int n2 = n = 0;
        if (display != null) {
            if (DisplayCompat.Api23Impl.physicalSizeEquals(mode, (Point)display)) {
                n2 = n;
            }
        } else {
            while (n2 < modeArray.length) {
                boolean bl = DisplayCompat.Api23Impl.physicalSizeEquals(modeArray[n2], mode);
                modeCompatArray[n2] = new DisplayCompat.ModeCompat(modeArray[n2], bl);
                ++n2;
            }
            return modeCompatArray;
        }
        n2 = 0;
        while (n2 < modeArray.length) {
            context = DisplayCompat.Api23Impl.physicalSizeEquals(modeArray[n2], mode) ? new DisplayCompat.ModeCompat(modeArray[n2], (Point)display) : new DisplayCompat.ModeCompat(modeArray[n2], false);
            modeCompatArray[n2] = context;
            ++n2;
        }
        return modeCompatArray;
    }

    static boolean isCurrentModeTheLargestMode(Display modeArray) {
        Display.Mode mode = modeArray.getMode();
        modeArray = modeArray.getSupportedModes();
        int n = 0;
        while (n < modeArray.length) {
            if (mode.getPhysicalHeight() < modeArray[n].getPhysicalHeight()) return false;
            if (mode.getPhysicalWidth() < modeArray[n].getPhysicalWidth()) {
                return false;
            }
            ++n;
        }
        return true;
    }

    static boolean physicalSizeEquals(Display.Mode mode, Point point) {
        boolean bl = mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y || mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x;
        return bl;
    }

    static boolean physicalSizeEquals(Display.Mode mode, Display.Mode mode2) {
        boolean bl = mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
        return bl;
    }
}
