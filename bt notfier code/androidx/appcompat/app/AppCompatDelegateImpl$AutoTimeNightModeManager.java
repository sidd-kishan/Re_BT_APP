/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.IntentFilter
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
 *  androidx.appcompat.app.TwilightManager
 */
package androidx.appcompat.app;

import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.TwilightManager;

private class AppCompatDelegateImpl.AutoTimeNightModeManager
extends AppCompatDelegateImpl.AutoNightModeManager {
    private final TwilightManager mTwilightManager;
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.AutoTimeNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl, TwilightManager twilightManager) {
        this.this$0 = appCompatDelegateImpl;
        super(appCompatDelegateImpl);
        this.mTwilightManager = twilightManager;
    }

    IntentFilter createIntentFilterForBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        return intentFilter;
    }

    public int getApplyableNightMode() {
        int n = this.mTwilightManager.isNight() ? 2 : 1;
        return n;
    }

    public void onChange() {
        this.this$0.applyDayNight();
    }
}
