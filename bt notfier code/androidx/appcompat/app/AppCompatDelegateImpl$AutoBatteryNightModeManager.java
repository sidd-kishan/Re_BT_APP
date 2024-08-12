/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.app.AppCompatDelegateImpl$Api21Impl
 *  androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import androidx.appcompat.app.AppCompatDelegateImpl;

/*
 * Exception performing whole class analysis ignored.
 */
private class AppCompatDelegateImpl.AutoBatteryNightModeManager
extends AppCompatDelegateImpl.AutoNightModeManager {
    private final PowerManager mPowerManager;
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.AutoBatteryNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        this.this$0 = appCompatDelegateImpl;
        super(appCompatDelegateImpl);
        this.mPowerManager = (PowerManager)context.getApplicationContext().getSystemService("power");
    }

    IntentFilter createIntentFilterForBroadcastReceiver() {
        if (Build.VERSION.SDK_INT < 21) return null;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter;
    }

    public int getApplyableNightMode() {
        int n;
        int n2 = Build.VERSION.SDK_INT;
        int n3 = n = 1;
        if (n2 < 21) return n3;
        n3 = n;
        if (!AppCompatDelegateImpl.Api21Impl.isPowerSaveMode((PowerManager)this.mPowerManager)) return n3;
        n3 = 2;
        return n3;
    }

    public void onChange() {
        this.this$0.applyDayNight();
    }
}
