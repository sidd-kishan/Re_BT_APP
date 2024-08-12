/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ShortcutInfo
 *  android.content.pm.ShortcutManager
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.core.content.ContextCompat
 *  androidx.core.content.pm.ShortcutInfoChangeListener
 *  androidx.core.content.pm.ShortcutInfoCompat
 *  androidx.core.content.pm.ShortcutInfoCompat$Builder
 *  androidx.core.content.pm.ShortcutInfoCompatSaver
 *  androidx.core.content.pm.ShortcutInfoCompatSaver$NoopImpl
 *  androidx.core.content.pm.ShortcutManagerCompat$Api25Impl
 *  androidx.core.graphics.drawable.IconCompat
 *  androidx.core.util.Preconditions
 */
package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoChangeListener;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(Context object, List<ShortcutInfoCompat> list) {
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons((Context)object, list);
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>();
            Iterator<ShortcutInfoCompat> iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.add(iterator.next().toShortcutInfo());
            }
            if (!((ShortcutManager)object.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).addShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutAdded(list);
        }
        return true;
    }

    static boolean convertUriIconToBitmapIcon(Context object, ShortcutInfoCompat shortcutInfoCompat) {
        if (shortcutInfoCompat.mIcon == null) {
            return false;
        }
        int n = shortcutInfoCompat.mIcon.mType;
        if (n != 6 && n != 4) {
            return true;
        }
        if ((object = shortcutInfoCompat.mIcon.getUriInputStream(object)) == null) {
            return false;
        }
        if ((object = BitmapFactory.decodeStream((InputStream)object)) == null) {
            return false;
        }
        object = n == 6 ? IconCompat.createWithAdaptiveBitmap((Bitmap)object) : IconCompat.createWithBitmap((Bitmap)object);
        shortcutInfoCompat.mIcon = object;
        return true;
    }

    static void convertUriIconsToBitmapIcons(Context context, List<ShortcutInfoCompat> list) {
        Iterator iterator = new ArrayList<ShortcutInfoCompat>(list).iterator();
        while (iterator.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat)iterator.next();
            if (ShortcutManagerCompat.convertUriIconToBitmapIcon(context, shortcutInfoCompat)) continue;
            list.remove(shortcutInfoCompat);
        }
    }

    public static Intent createShortcutResultIntent(Context object, ShortcutInfoCompat shortcutInfoCompat) {
        object = Build.VERSION.SDK_INT >= 26 ? ((ShortcutManager)object.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo()) : null;
        Context context = object;
        if (object != null) return shortcutInfoCompat.addToIntent((Intent)context);
        context = new Intent();
        return shortcutInfoCompat.addToIntent((Intent)context);
    }

    public static void disableShortcuts(Context object, List<String> list, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutRemoved(list);
        }
    }

    public static void enableShortcuts(Context object, List<ShortcutInfoCompat> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<String> arrayList = new ArrayList<String>(list.size());
            Iterator<ShortcutInfoCompat> iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.add(iterator.next().mId);
            }
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).addShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutAdded(list);
        }
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context object) {
        if (Build.VERSION.SDK_INT >= 25) {
            Object object2 = ((ShortcutManager)object.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
            ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<ShortcutInfoCompat>(object2.size());
            object2 = object2.iterator();
            while (object2.hasNext()) {
                arrayList.add(new ShortcutInfoCompat.Builder(object, (ShortcutInfo)object2.next()).build());
            }
            return arrayList;
        }
        try {
            object = ShortcutManagerCompat.getShortcutInfoSaverInstance(object).getShortcuts();
            return object;
        }
        catch (Exception exception) {
            return new ArrayList<ShortcutInfoCompat>();
        }
    }

    private static int getIconDimensionInternal(Context context, boolean bl) {
        ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
        int n = Build.VERSION.SDK_INT >= 19 && activityManager != null && !activityManager.isLowRamDevice() ? 0 : 1;
        n = n != 0 ? 48 : 96;
        n = Math.max(1, n);
        context = context.getResources().getDisplayMetrics();
        float f = bl ? context.xdpi : context.ydpi;
        return (int)((float)n * (f /= 160.0f));
    }

    public static int getIconMaxHeight(Context context) {
        Preconditions.checkNotNull((Object)context);
        if (Build.VERSION.SDK_INT < 25) return ShortcutManagerCompat.getIconDimensionInternal(context, false);
        return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    }

    public static int getIconMaxWidth(Context context) {
        Preconditions.checkNotNull((Object)context);
        if (Build.VERSION.SDK_INT < 25) return ShortcutManagerCompat.getIconDimensionInternal(context, true);
        return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    }

    public static int getMaxShortcutCountPerActivity(Context context) {
        Preconditions.checkNotNull((Object)context);
        if (Build.VERSION.SDK_INT < 25) return 5;
        return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> object) {
        Iterator<ShortcutInfoCompat> iterator = object.iterator();
        int n = -1;
        object = null;
        while (iterator.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = iterator.next();
            if (shortcutInfoCompat.getRank() <= n) continue;
            object = shortcutInfoCompat.getId();
            n = shortcutInfoCompat.getRank();
        }
        return object;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        if (sShortcutInfoChangeListeners != null) return sShortcutInfoChangeListeners;
        ArrayList<ShortcutInfoChangeListener> arrayList = new ArrayList<ShortcutInfoChangeListener>();
        if (Build.VERSION.SDK_INT >= 21) {
            Object object = context.getPackageManager();
            Object object2 = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            object2.setPackage(context.getPackageName());
            object = object.queryIntentActivities(object2, 128).iterator();
            while (object.hasNext()) {
                object2 = ((ResolveInfo)object.next()).activityInfo;
                if (object2 == null || (object2 = object2.metaData) == null || (object2 = object2.getString("androidx.core.content.pm.shortcut_listener_impl")) == null) continue;
                try {
                    arrayList.add((ShortcutInfoChangeListener)Class.forName((String)object2, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                }
                catch (Exception exception) {}
            }
        }
        if (sShortcutInfoChangeListeners != null) return sShortcutInfoChangeListeners;
        sShortcutInfoChangeListeners = arrayList;
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver != null) return sShortcutInfoCompatSaver;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver)Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (sShortcutInfoCompatSaver != null) return sShortcutInfoCompatSaver;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
        return sShortcutInfoCompatSaver;
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context object, int n) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ShortcutInfoCompat.fromShortcuts((Context)object, (List)((ShortcutManager)object.getSystemService(ShortcutManager.class)).getShortcuts(n));
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ShortcutManager shortcutManager = (ShortcutManager)object.getSystemService(ShortcutManager.class);
            ArrayList arrayList = new ArrayList();
            if ((n & 1) != 0) {
                arrayList.addAll(shortcutManager.getManifestShortcuts());
            }
            if ((n & 2) != 0) {
                arrayList.addAll(shortcutManager.getDynamicShortcuts());
            }
            if ((n & 4) == 0) return ShortcutInfoCompat.fromShortcuts((Context)object, arrayList);
            arrayList.addAll(shortcutManager.getPinnedShortcuts());
            return ShortcutInfoCompat.fromShortcuts((Context)object, arrayList);
        }
        if ((n & 2) == 0) return Collections.emptyList();
        try {
            object = ShortcutManagerCompat.getShortcutInfoSaverInstance(object).getShortcuts();
            return object;
        }
        catch (Exception exception) {
        }
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(Context context) {
        Preconditions.checkNotNull((Object)context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
        }
        boolean bl = ShortcutManagerCompat.getShortcuts(context, 3).size() == ShortcutManagerCompat.getMaxShortcutCountPerActivity(context);
        return bl;
    }

    public static boolean isRequestPinShortcutSupported(Context object) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager)object.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        if (ContextCompat.checkSelfPermission((Context)object, (String)"com.android.launcher.permission.INSTALL_SHORTCUT") != 0) {
            return false;
        }
        Iterator iterator = object.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).iterator();
        do {
            if (!iterator.hasNext()) return false;
            object = ((ResolveInfo)iterator.next()).activityInfo.permission;
            if (TextUtils.isEmpty((CharSequence)object)) return true;
        } while (!"com.android.launcher.permission.INSTALL_SHORTCUT".equals(object));
        return true;
    }

    public static boolean pushDynamicShortcut(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        Object object;
        Object object2;
        Preconditions.checkNotNull((Object)context);
        Preconditions.checkNotNull((Object)shortcutInfoCompat);
        int n = ShortcutManagerCompat.getMaxShortcutCountPerActivity(context);
        if (n == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconToBitmapIcon(context, shortcutInfoCompat);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            ((ShortcutManager)context.getSystemService(ShortcutManager.class)).pushDynamicShortcut(shortcutInfoCompat.toShortcutInfo());
        } else if (Build.VERSION.SDK_INT >= 25) {
            object2 = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            if (object2.isRateLimitingActive()) {
                return false;
            }
            object = object2.getDynamicShortcuts();
            if (object.size() >= n) {
                object2.removeDynamicShortcuts(Arrays.asList(Api25Impl.getShortcutInfoWithLowestRank((List)object)));
            }
            object2.addDynamicShortcuts(Arrays.asList(shortcutInfoCompat.toShortcutInfo()));
        }
        object = ShortcutManagerCompat.getShortcutInfoSaverInstance(context);
        try {
            object2 = object.getShortcuts();
            if (object2.size() >= n) {
                object.removeShortcuts(Arrays.asList(ShortcutManagerCompat.getShortcutInfoCompatWithLowestRank((List<ShortcutInfoCompat>)object2)));
            }
            object.addShortcuts(Arrays.asList(shortcutInfoCompat));
            object2 = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        }
        catch (Throwable throwable) {
            object = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
            while (true) {
                if (!object.hasNext()) {
                    ShortcutManagerCompat.reportShortcutUsed(context, shortcutInfoCompat.getId());
                    throw throwable;
                }
                ((ShortcutInfoChangeListener)object.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
        }
        catch (Exception exception) {
            Iterator<ShortcutInfoChangeListener> iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    ShortcutManagerCompat.reportShortcutUsed(context, shortcutInfoCompat.getId());
                    return false;
                }
                iterator.next().onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
        }
        while (true) {
            if (!object2.hasNext()) {
                ShortcutManagerCompat.reportShortcutUsed(context, shortcutInfoCompat.getId());
                return true;
            }
            ((ShortcutInfoChangeListener)object2.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
        }
    }

    public static void removeAllDynamicShortcuts(Context object) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeAllShortcuts();
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(Context object, List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutRemoved(list);
        }
    }

    public static void removeLongLivedShortcuts(Context object, List<String> list) {
        if (Build.VERSION.SDK_INT < 30) {
            ShortcutManagerCompat.removeDynamicShortcuts((Context)object, list);
            return;
        }
        ((ShortcutManager)object.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutRemoved(list);
        }
    }

    public static void reportShortcutUsed(Context object, String string) {
        Preconditions.checkNotNull((Object)object);
        Preconditions.checkNotNull((Object)string);
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).reportShortcutUsed(string);
        }
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutUsageReported(Collections.singletonList(string));
        }
    }

    public static boolean requestPinShortcut(Context context, ShortcutInfoCompat shortcutInfoCompat, IntentSender intentSender) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
        }
        if (!ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
            return false;
        }
        shortcutInfoCompat = shortcutInfoCompat.addToIntent(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
        if (intentSender == null) {
            context.sendBroadcast((Intent)shortcutInfoCompat);
            return true;
        }
        context.sendOrderedBroadcast((Intent)shortcutInfoCompat, null, (BroadcastReceiver)new /* Unavailable Anonymous Inner Class!! */, null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(Context context, List<ShortcutInfoCompat> list) {
        Iterator<ShortcutInfoCompat> iterator;
        Preconditions.checkNotNull((Object)context);
        Preconditions.checkNotNull(list);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>(list.size());
            iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.add(iterator.next().toShortcutInfo());
            }
            if (!((ShortcutManager)context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeAllShortcuts();
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(list);
        iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        while (iterator.hasNext()) {
            context = (ShortcutInfoChangeListener)iterator.next();
            context.onAllShortcutsRemoved();
            context.onShortcutAdded(list);
        }
        return true;
    }

    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> list) {
        sShortcutInfoChangeListeners = list;
    }

    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> shortcutInfoCompatSaver) {
        sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
    }

    public static boolean updateShortcuts(Context object, List<ShortcutInfoCompat> list) {
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons((Context)object, list);
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>();
            Iterator<ShortcutInfoCompat> iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.add(iterator.next().toShortcutInfo());
            }
            if (!((ShortcutManager)object.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList)) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).addShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutUpdated(list);
        }
        return true;
    }
}
