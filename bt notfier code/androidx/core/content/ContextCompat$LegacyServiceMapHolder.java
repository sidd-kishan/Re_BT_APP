/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.AccountManager
 *  android.app.ActivityManager
 *  android.app.AlarmManager
 *  android.app.AppOpsManager
 *  android.app.DownloadManager
 *  android.app.KeyguardManager
 *  android.app.NotificationManager
 *  android.app.SearchManager
 *  android.app.UiModeManager
 *  android.app.WallpaperManager
 *  android.app.admin.DevicePolicyManager
 *  android.app.job.JobScheduler
 *  android.app.usage.UsageStatsManager
 *  android.appwidget.AppWidgetManager
 *  android.bluetooth.BluetoothManager
 *  android.content.ClipboardManager
 *  android.content.RestrictionsManager
 *  android.content.pm.LauncherApps
 *  android.hardware.ConsumerIrManager
 *  android.hardware.SensorManager
 *  android.hardware.camera2.CameraManager
 *  android.hardware.display.DisplayManager
 *  android.hardware.input.InputManager
 *  android.hardware.usb.UsbManager
 *  android.location.LocationManager
 *  android.media.AudioManager
 *  android.media.MediaRouter
 *  android.media.projection.MediaProjectionManager
 *  android.media.session.MediaSessionManager
 *  android.media.tv.TvInputManager
 *  android.net.ConnectivityManager
 *  android.net.nsd.NsdManager
 *  android.net.wifi.WifiManager
 *  android.net.wifi.p2p.WifiP2pManager
 *  android.nfc.NfcManager
 *  android.os.BatteryManager
 *  android.os.Build$VERSION
 *  android.os.DropBoxManager
 *  android.os.PowerManager
 *  android.os.UserManager
 *  android.os.Vibrator
 *  android.os.storage.StorageManager
 *  android.print.PrintManager
 *  android.telecom.TelecomManager
 *  android.telephony.SubscriptionManager
 *  android.telephony.TelephonyManager
 *  android.view.LayoutInflater
 *  android.view.WindowManager
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.CaptioningManager
 *  android.view.inputmethod.InputMethodManager
 *  android.view.textservice.TextServicesManager
 */
package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.util.HashMap;

private static final class ContextCompat.LegacyServiceMapHolder {
    static final HashMap<Class<?>, String> SERVICES = new HashMap();

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            SERVICES.put(SubscriptionManager.class, "telephony_subscription_service");
            SERVICES.put(UsageStatsManager.class, "usagestats");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            SERVICES.put(AppWidgetManager.class, "appwidget");
            SERVICES.put(BatteryManager.class, "batterymanager");
            SERVICES.put(CameraManager.class, "camera");
            SERVICES.put(JobScheduler.class, "jobscheduler");
            SERVICES.put(LauncherApps.class, "launcherapps");
            SERVICES.put(MediaProjectionManager.class, "media_projection");
            SERVICES.put(MediaSessionManager.class, "media_session");
            SERVICES.put(RestrictionsManager.class, "restrictions");
            SERVICES.put(TelecomManager.class, "telecom");
            SERVICES.put(TvInputManager.class, "tv_input");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SERVICES.put(AppOpsManager.class, "appops");
            SERVICES.put(CaptioningManager.class, "captioning");
            SERVICES.put(ConsumerIrManager.class, "consumer_ir");
            SERVICES.put(PrintManager.class, "print");
        }
        if (Build.VERSION.SDK_INT >= 18) {
            SERVICES.put(BluetoothManager.class, "bluetooth");
        }
        if (Build.VERSION.SDK_INT >= 17) {
            SERVICES.put(DisplayManager.class, "display");
            SERVICES.put(UserManager.class, "user");
        }
        if (Build.VERSION.SDK_INT >= 16) {
            SERVICES.put(InputManager.class, "input");
            SERVICES.put(MediaRouter.class, "media_router");
            SERVICES.put(NsdManager.class, "servicediscovery");
        }
        SERVICES.put(AccessibilityManager.class, "accessibility");
        SERVICES.put(AccountManager.class, "account");
        SERVICES.put(ActivityManager.class, "activity");
        SERVICES.put(AlarmManager.class, "alarm");
        SERVICES.put(AudioManager.class, "audio");
        SERVICES.put(ClipboardManager.class, "clipboard");
        SERVICES.put(ConnectivityManager.class, "connectivity");
        SERVICES.put(DevicePolicyManager.class, "device_policy");
        SERVICES.put(DownloadManager.class, "download");
        SERVICES.put(DropBoxManager.class, "dropbox");
        SERVICES.put(InputMethodManager.class, "input_method");
        SERVICES.put(KeyguardManager.class, "keyguard");
        SERVICES.put(LayoutInflater.class, "layout_inflater");
        SERVICES.put(LocationManager.class, "location");
        SERVICES.put(NfcManager.class, "nfc");
        SERVICES.put(NotificationManager.class, "notification");
        SERVICES.put(PowerManager.class, "power");
        SERVICES.put(SearchManager.class, "search");
        SERVICES.put(SensorManager.class, "sensor");
        SERVICES.put(StorageManager.class, "storage");
        SERVICES.put(TelephonyManager.class, "phone");
        SERVICES.put(TextServicesManager.class, "textservices");
        SERVICES.put(UiModeManager.class, "uimode");
        SERVICES.put(UsbManager.class, "usb");
        SERVICES.put(Vibrator.class, "vibrator");
        SERVICES.put(WallpaperManager.class, "wallpaper");
        SERVICES.put(WifiP2pManager.class, "wifip2p");
        SERVICES.put(WifiManager.class, "wifi");
        SERVICES.put(WindowManager.class, "window");
    }

    private ContextCompat.LegacyServiceMapHolder() {
    }
}
