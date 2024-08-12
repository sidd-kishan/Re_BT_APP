/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationManager
 *  android.util.Log
 *  androidx.appcompat.app.TwilightCalculator
 *  androidx.appcompat.app.TwilightManager$TwilightState
 *  androidx.core.content.PermissionChecker
 */
package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.appcompat.app.TwilightCalculator;
import androidx.appcompat.app.TwilightManager;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    TwilightManager(Context context, LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    static TwilightManager getInstance(Context context) {
        if (sInstance != null) return sInstance;
        context = context.getApplicationContext();
        sInstance = new TwilightManager(context, (LocationManager)context.getSystemService("location"));
        return sInstance;
    }

    private Location getLastKnownLocation() {
        int n = PermissionChecker.checkSelfPermission((Context)this.mContext, (String)"android.permission.ACCESS_COARSE_LOCATION");
        Location location = null;
        Location location2 = n == 0 ? this.getLastKnownLocationForProvider("network") : null;
        if (PermissionChecker.checkSelfPermission((Context)this.mContext, (String)"android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = this.getLastKnownLocationForProvider("gps");
        }
        if (location != null && location2 != null) {
            Location location3 = location2;
            if (location.getTime() <= location2.getTime()) return location3;
            location3 = location;
            return location3;
        }
        if (location == null) return location2;
        location2 = location;
        return location2;
    }

    private Location getLastKnownLocationForProvider(String string) {
        try {
            if (!this.mLocationManager.isProviderEnabled(string)) return null;
            string = this.mLocationManager.getLastKnownLocation(string);
            return string;
        }
        catch (Exception exception) {
            Log.d((String)TAG, (String)"Failed to get last known location", (Throwable)exception);
        }
        return null;
    }

    private boolean isStateValid() {
        boolean bl = this.mTwilightState.nextUpdate > System.currentTimeMillis();
        return bl;
    }

    static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    private void updateState(Location location) {
        TwilightState twilightState = this.mTwilightState;
        long l = System.currentTimeMillis();
        TwilightCalculator twilightCalculator = TwilightCalculator.getInstance();
        twilightCalculator.calculateTwilight(l - 86400000L, location.getLatitude(), location.getLongitude());
        long l2 = twilightCalculator.sunset;
        twilightCalculator.calculateTwilight(l, location.getLatitude(), location.getLongitude());
        boolean bl = twilightCalculator.state == 1;
        long l3 = twilightCalculator.sunrise;
        long l4 = twilightCalculator.sunset;
        twilightCalculator.calculateTwilight(86400000L + l, location.getLatitude(), location.getLongitude());
        long l5 = twilightCalculator.sunrise;
        if (l3 != -1L && l4 != -1L) {
            l = l > l4 ? 0L + l5 : (l > l3 ? 0L + l4 : 0L + l3);
            l += 60000L;
        } else {
            l = 43200000L + l;
        }
        twilightState.isNight = bl;
        twilightState.yesterdaySunset = l2;
        twilightState.todaySunrise = l3;
        twilightState.todaySunset = l4;
        twilightState.tomorrowSunrise = l5;
        twilightState.nextUpdate = l;
    }

    boolean isNight() {
        TwilightState twilightState = this.mTwilightState;
        if (this.isStateValid()) {
            return twilightState.isNight;
        }
        Location location = this.getLastKnownLocation();
        if (location != null) {
            this.updateState(location);
            return twilightState.isNight;
        }
        Log.i((String)TAG, (String)"Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int n = Calendar.getInstance().get(11);
        boolean bl = n < 6 || n >= 22;
        return bl;
    }
}
