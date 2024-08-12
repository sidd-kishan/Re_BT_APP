/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.view.Display$Mode
 *  androidx.core.util.Preconditions
 */
package androidx.core.view;

import android.graphics.Point;
import android.view.Display;
import androidx.core.util.Preconditions;

public static final class DisplayCompat.ModeCompat {
    private final boolean mIsNative;
    private final Display.Mode mMode;
    private final Point mPhysicalSize;

    DisplayCompat.ModeCompat(Point point) {
        Preconditions.checkNotNull((Object)point, (Object)"physicalSize == null");
        this.mPhysicalSize = point;
        this.mMode = null;
        this.mIsNative = true;
    }

    DisplayCompat.ModeCompat(Display.Mode mode, Point point) {
        Preconditions.checkNotNull((Object)mode, (Object)"mode == null, can't wrap a null reference");
        Preconditions.checkNotNull((Object)point, (Object)"physicalSize == null");
        this.mPhysicalSize = point;
        this.mMode = mode;
        this.mIsNative = true;
    }

    DisplayCompat.ModeCompat(Display.Mode mode, boolean bl) {
        Preconditions.checkNotNull((Object)mode, (Object)"mode == null, can't wrap a null reference");
        this.mPhysicalSize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
        this.mMode = mode;
        this.mIsNative = bl;
    }

    public int getPhysicalHeight() {
        return this.mPhysicalSize.y;
    }

    public int getPhysicalWidth() {
        return this.mPhysicalSize.x;
    }

    @Deprecated
    public boolean isNative() {
        return this.mIsNative;
    }

    public Display.Mode toMode() {
        return this.mMode;
    }
}
