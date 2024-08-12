/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.os.StatFs
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zzu
 */
package com.google.android.gms.ads.internal.util;

import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzu;

public class zzv
extends zzu {
    public boolean zzg(View view) {
        if (super.zzg(view)) return true;
        if (view.getWindowId() == null) return false;
        return true;
    }

    public final int zzh() {
        return 14;
    }

    public final long zzi() {
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024L;
    }
}
