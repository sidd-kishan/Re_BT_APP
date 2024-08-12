/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationChannelGroup
 *  android.app.NotificationManager
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 *  android.provider.Settings$Secure
 *  androidx.core.app.NotificationChannelCompat
 *  androidx.core.app.NotificationChannelGroupCompat
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationManagerCompat$CancelTask
 *  androidx.core.app.NotificationManagerCompat$NotifyTask
 *  androidx.core.app.NotificationManagerCompat$SideChannelManager
 *  androidx.core.app.NotificationManagerCompat$Task
 */
package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationChannelGroupCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet<String>();
        sLock = new Object();
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager)context.getSystemService("notification");
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    /*
     * Enabled force condition propagation
     */
    public static Set<String> getEnabledListenerPackages(Context object) {
        String string = Settings.Secure.getString((ContentResolver)object.getContentResolver(), (String)SETTING_ENABLED_NOTIFICATION_LISTENERS);
        Object object2 = sEnabledNotificationListenersLock;
        synchronized (object2) {
            if (string == null) return sEnabledNotificationListenerPackages;
            if (string.equals(sEnabledNotificationListeners)) return sEnabledNotificationListenerPackages;
            String[] stringArray = string.split(":", -1);
            HashSet<String> hashSet = new HashSet<String>(stringArray.length);
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                ComponentName componentName = ComponentName.unflattenFromString((String)stringArray[i]);
                if (componentName == null) continue;
                hashSet.add(componentName.getPackageName());
            }
            sEnabledNotificationListenerPackages = hashSet;
            sEnabledNotificationListeners = string;
            return sEnabledNotificationListenerPackages;
        }
    }

    private void pushSideChannelQueue(Task task) {
        Object object = sLock;
        synchronized (object) {
            if (sSideChannelManager == null) {
                SideChannelManager sideChannelManager;
                sSideChannelManager = sideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());
            }
            sSideChannelManager.queueTask(task);
            return;
        }
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        boolean bl = (notification = NotificationCompat.getExtras((Notification)notification)) != null && notification.getBoolean(EXTRA_USE_SIDE_CHANNEL);
        return bl;
    }

    public boolean areNotificationsEnabled() {
        boolean bl;
        block4: {
            boolean bl2;
            if (Build.VERSION.SDK_INT >= 24) {
                return this.mNotificationManager.areNotificationsEnabled();
            }
            int n = Build.VERSION.SDK_INT;
            bl = bl2 = true;
            if (n < 19) return bl;
            AppOpsManager appOpsManager = (AppOpsManager)this.mContext.getSystemService("appops");
            Object object = this.mContext.getApplicationInfo();
            String string = this.mContext.getApplicationContext().getPackageName();
            n = ((ApplicationInfo)object).uid;
            try {
                object = Class.forName(AppOpsManager.class.getName());
                n = (Integer)((Class)object).getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, (int)((Integer)((Class)object).getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)), n, string);
                if (n == 0) {
                    bl = bl2;
                    break block4;
                }
                bl = false;
            }
            catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException exception) {
                bl = bl2;
            }
        }
        return bl;
    }

    public void cancel(int n) {
        this.cancel(null, n);
    }

    public void cancel(String string, int n) {
        this.mNotificationManager.cancel(string, n);
        if (Build.VERSION.SDK_INT > 19) return;
        this.pushSideChannelQueue((Task)new CancelTask(this.mContext.getPackageName(), n, string));
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
        if (Build.VERSION.SDK_INT > 19) return;
        this.pushSideChannelQueue((Task)new CancelTask(this.mContext.getPackageName()));
    }

    public void createNotificationChannel(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT < 26) return;
        this.mNotificationManager.createNotificationChannel(notificationChannel);
    }

    public void createNotificationChannel(NotificationChannelCompat notificationChannelCompat) {
        this.createNotificationChannel(notificationChannelCompat.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT < 26) return;
        this.mNotificationManager.createNotificationChannelGroup(notificationChannelGroup);
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat notificationChannelGroupCompat) {
        this.createNotificationChannelGroup(notificationChannelGroupCompat.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT < 26) return;
        this.mNotificationManager.createNotificationChannelGroups(list);
    }

    public void createNotificationChannelGroupsCompat(List<NotificationChannelGroupCompat> object) {
        if (Build.VERSION.SDK_INT < 26) return;
        if (object.isEmpty()) return;
        ArrayList<NotificationChannelGroup> arrayList = new ArrayList<NotificationChannelGroup>(object.size());
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.mNotificationManager.createNotificationChannelGroups(arrayList);
                return;
            }
            arrayList.add(((NotificationChannelGroupCompat)object.next()).getNotificationChannelGroup());
        }
    }

    public void createNotificationChannels(List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT < 26) return;
        this.mNotificationManager.createNotificationChannels(list);
    }

    public void createNotificationChannelsCompat(List<NotificationChannelCompat> object) {
        if (Build.VERSION.SDK_INT < 26) return;
        if (object.isEmpty()) return;
        ArrayList<NotificationChannel> arrayList = new ArrayList<NotificationChannel>(object.size());
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.mNotificationManager.createNotificationChannels(arrayList);
                return;
            }
            arrayList.add(((NotificationChannelCompat)object.next()).getNotificationChannel());
        }
    }

    public void deleteNotificationChannel(String string) {
        if (Build.VERSION.SDK_INT < 26) return;
        this.mNotificationManager.deleteNotificationChannel(string);
    }

    public void deleteNotificationChannelGroup(String string) {
        if (Build.VERSION.SDK_INT < 26) return;
        this.mNotificationManager.deleteNotificationChannelGroup(string);
    }

    public void deleteUnlistedNotificationChannels(Collection<String> collection) {
        if (Build.VERSION.SDK_INT < 26) return;
        Iterator iterator = this.mNotificationManager.getNotificationChannels().iterator();
        while (iterator.hasNext()) {
            NotificationChannel notificationChannel = (NotificationChannel)iterator.next();
            if (collection.contains(notificationChannel.getId()) || Build.VERSION.SDK_INT >= 30 && collection.contains(notificationChannel.getParentChannelId())) continue;
            this.mNotificationManager.deleteNotificationChannel(notificationChannel.getId());
        }
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT < 24) return -1000;
        return this.mNotificationManager.getImportance();
    }

    public NotificationChannel getNotificationChannel(String string) {
        if (Build.VERSION.SDK_INT < 26) return null;
        return this.mNotificationManager.getNotificationChannel(string);
    }

    public NotificationChannel getNotificationChannel(String string, String string2) {
        if (Build.VERSION.SDK_INT < 30) return this.getNotificationChannel(string);
        return this.mNotificationManager.getNotificationChannel(string, string2);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String string) {
        if (Build.VERSION.SDK_INT < 26) return null;
        if ((string = this.getNotificationChannel(string)) == null) return null;
        return new NotificationChannelCompat((NotificationChannel)string);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String string, String string2) {
        if (Build.VERSION.SDK_INT < 26) return null;
        if ((string = this.getNotificationChannel(string, string2)) == null) return null;
        return new NotificationChannelCompat((NotificationChannel)string);
    }

    public NotificationChannelGroup getNotificationChannelGroup(String string) {
        NotificationChannelGroup notificationChannelGroup;
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mNotificationManager.getNotificationChannelGroup(string);
        }
        if (Build.VERSION.SDK_INT < 26) return null;
        Iterator<NotificationChannelGroup> iterator = this.getNotificationChannelGroups().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(notificationChannelGroup = iterator.next()).getId().equals(string));
        return notificationChannelGroup;
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String string) {
        if (Build.VERSION.SDK_INT >= 28) {
            if ((string = this.getNotificationChannelGroup(string)) == null) return null;
            return new NotificationChannelGroupCompat((NotificationChannelGroup)string);
        }
        if (Build.VERSION.SDK_INT < 26) return null;
        if ((string = this.getNotificationChannelGroup(string)) == null) return null;
        return new NotificationChannelGroupCompat((NotificationChannelGroup)string, this.getNotificationChannels());
    }

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT < 26) return Collections.emptyList();
        return this.mNotificationManager.getNotificationChannelGroups();
    }

    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        if (Build.VERSION.SDK_INT < 26) return Collections.emptyList();
        NotificationChannelGroup notificationChannelGroup = this.getNotificationChannelGroups();
        if (notificationChannelGroup.isEmpty()) return Collections.emptyList();
        List<Object> list = Build.VERSION.SDK_INT >= 28 ? Collections.emptyList() : this.getNotificationChannels();
        ArrayList<NotificationChannelGroupCompat> arrayList = new ArrayList<NotificationChannelGroupCompat>(notificationChannelGroup.size());
        Iterator<NotificationChannelGroup> iterator = notificationChannelGroup.iterator();
        while (iterator.hasNext()) {
            notificationChannelGroup = iterator.next();
            if (Build.VERSION.SDK_INT >= 28) {
                arrayList.add(new NotificationChannelGroupCompat(notificationChannelGroup));
                continue;
            }
            arrayList.add(new NotificationChannelGroupCompat(notificationChannelGroup, list));
        }
        return arrayList;
    }

    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) return Collections.emptyList();
        return this.mNotificationManager.getNotificationChannels();
    }

    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT < 26) return Collections.emptyList();
        List<NotificationChannel> list = this.getNotificationChannels();
        if (list.isEmpty()) return Collections.emptyList();
        ArrayList<NotificationChannelCompat> arrayList = new ArrayList<NotificationChannelCompat>(list.size());
        list = list.iterator();
        while (list.hasNext()) {
            arrayList.add(new NotificationChannelCompat((NotificationChannel)list.next()));
        }
        return arrayList;
    }

    public void notify(int n, Notification notification) {
        this.notify(null, n, notification);
    }

    public void notify(String string, int n, Notification notification) {
        if (NotificationManagerCompat.useSideChannelForNotification(notification)) {
            this.pushSideChannelQueue((Task)new NotifyTask(this.mContext.getPackageName(), n, string, notification));
            this.mNotificationManager.cancel(string, n);
        } else {
            this.mNotificationManager.notify(string, n, notification);
        }
    }
}
