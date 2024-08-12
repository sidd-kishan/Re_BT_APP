/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory$Options
 *  android.os.Build$VERSION
 *  android.util.Log
 *  com.bumptech.glide.load.DecodeFormat
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

final class HardwareConfigState {
    private static final File FD_SIZE_LIST = new File("/proc/self/fd");
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    private static final int MIN_HARDWARE_DIMENSION = 128;
    private static volatile HardwareConfigState instance;
    private volatile int decodesSinceLastFdCheck;
    private volatile boolean isHardwareConfigAllowed = true;

    private HardwareConfigState() {
    }

    static HardwareConfigState getInstance() {
        if (instance != null) return instance;
        synchronized (HardwareConfigState.class) {
            HardwareConfigState hardwareConfigState;
            if (instance != null) return instance;
            instance = hardwareConfigState = new HardwareConfigState();
        }
        return instance;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private boolean isFdSizeBelowHardwareLimit() {
        synchronized (this) {
            int n = this.decodesSinceLastFdCheck;
            boolean bl = true;
            {
                this.decodesSinceLastFdCheck = ++n;
                if (n >= 50) {
                    this.decodesSinceLastFdCheck = 0;
                    n = FD_SIZE_LIST.list().length;
                    if (n >= 700) {
                        bl = false;
                    }
                    this.isHardwareConfigAllowed = bl;
                    if (!this.isHardwareConfigAllowed && Log.isLoggable((String)"Downsampler", (int)5)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                        stringBuilder.append(n);
                        stringBuilder.append(", limit ");
                        stringBuilder.append(700);
                        Log.w((String)"Downsampler", (String)stringBuilder.toString());
                    }
                }
                bl = this.isHardwareConfigAllowed;
                return bl;
            }
        }
    }

    boolean setHardwareConfigIfAllowed(int n, int n2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean bl, boolean bl2) {
        if (!bl) return false;
        if (Build.VERSION.SDK_INT < 26) return false;
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) return false;
        if (bl2) {
            return false;
        }
        bl = n >= 128 && n2 >= 128 && this.isFdSizeBelowHardwareLimit();
        if (!bl) return bl;
        options.inPreferredConfig = Bitmap.Config.HARDWARE;
        options.inMutable = false;
        return bl;
    }
}
