/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$BubbleMetadata
 *  android.app.PendingIntent
 *  android.app.Person
 *  android.app.RemoteInput
 *  android.content.LocusId
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  androidx.core.app.NotificationCompat$Action
 *  androidx.core.app.NotificationCompat$BubbleMetadata
 *  androidx.core.app.NotificationCompatJellybean
 *  androidx.core.app.Person
 *  androidx.core.app.Person$Builder
 *  androidx.core.app.RemoteInput
 *  androidx.core.content.LocusIdCompat
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    @Deprecated
    public NotificationCompat() {
    }

    public static Action getAction(Notification notification, int n) {
        if (Build.VERSION.SDK_INT >= 20) {
            return NotificationCompat.getActionCompatFromAction(notification.actions[n]);
        }
        int n2 = Build.VERSION.SDK_INT;
        Object var3_3 = null;
        if (n2 >= 19) {
            Notification.Action action = notification.actions[n];
            SparseArray sparseArray = notification.extras.getSparseParcelableArray("android.support.actionExtras");
            notification = var3_3;
            if (sparseArray == null) return NotificationCompatJellybean.readAction((int)action.icon, (CharSequence)action.title, (PendingIntent)action.actionIntent, (Bundle)notification);
            notification = (Bundle)sparseArray.get(n);
            return NotificationCompatJellybean.readAction((int)action.icon, (CharSequence)action.title, (PendingIntent)action.actionIntent, (Bundle)notification);
        }
        if (Build.VERSION.SDK_INT < 16) return null;
        return NotificationCompatJellybean.getAction((Notification)notification, (int)n);
    }

    static Action getActionCompatFromAction(Notification.Action action) {
        boolean bl;
        int n;
        RemoteInput[] remoteInputArray;
        android.app.RemoteInput[] remoteInputArray2 = action.getRemoteInputs();
        IconCompat iconCompat = null;
        if (remoteInputArray2 == null) {
            remoteInputArray = null;
        } else {
            remoteInputArray = new RemoteInput[remoteInputArray2.length];
            for (n = 0; n < remoteInputArray2.length; ++n) {
                android.app.RemoteInput remoteInput = remoteInputArray2[n];
                String string = remoteInput.getResultKey();
                CharSequence charSequence = remoteInput.getLabel();
                CharSequence[] charSequenceArray = remoteInput.getChoices();
                bl = remoteInput.getAllowFreeFormInput();
                int n2 = Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0;
                remoteInputArray[n] = new RemoteInput(string, charSequence, charSequenceArray, bl, n2, remoteInput.getExtras(), null);
            }
        }
        bl = Build.VERSION.SDK_INT >= 24 ? action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies() : action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        boolean bl2 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        n = Build.VERSION.SDK_INT >= 28 ? action.getSemanticAction() : action.getExtras().getInt("android.support.action.semanticAction", 0);
        boolean bl3 = Build.VERSION.SDK_INT >= 29 ? action.isContextual() : false;
        if (Build.VERSION.SDK_INT < 23) return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArray, null, bl, n, bl2, bl3);
        if (action.getIcon() == null && action.icon != 0) {
            return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArray, null, bl, n, bl2, bl3);
        }
        if (action.getIcon() == null) return new Action(iconCompat, action.title, action.actionIntent, action.getExtras(), remoteInputArray, null, bl, n, bl2, bl3);
        iconCompat = IconCompat.createFromIconOrNullIfZeroResId((Icon)action.getIcon());
        return new Action(iconCompat, action.title, action.actionIntent, action.getExtras(), remoteInputArray, null, bl, n, bl2, bl3);
    }

    public static int getActionCount(Notification notification) {
        int n = Build.VERSION.SDK_INT;
        int n2 = 0;
        if (n >= 19) {
            if (notification.actions == null) return n2;
            n2 = notification.actions.length;
            return n2;
        }
        if (Build.VERSION.SDK_INT < 16) return 0;
        return NotificationCompatJellybean.getActionCount((Notification)notification);
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        if (Build.VERSION.SDK_INT < 29) return false;
        return notification.getAllowSystemGeneratedContextualActions();
    }

    public static boolean getAutoCancel(Notification notification) {
        boolean bl = (notification.flags & 0x10) != 0;
        return bl;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT < 26) return 0;
        return notification.getBadgeIconType();
    }

    public static BubbleMetadata getBubbleMetadata(Notification notification) {
        if (Build.VERSION.SDK_INT < 29) return null;
        return BubbleMetadata.fromPlatform((Notification.BubbleMetadata)notification.getBubbleMetadata());
    }

    public static String getCategory(Notification notification) {
        if (Build.VERSION.SDK_INT < 21) return null;
        return notification.category;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT < 26) return null;
        return notification.getChannelId();
    }

    public static int getColor(Notification notification) {
        if (Build.VERSION.SDK_INT < 21) return 0;
        return notification.color;
    }

    public static CharSequence getContentInfo(Notification notification) {
        return notification.extras.getCharSequence("android.infoText");
    }

    public static CharSequence getContentText(Notification notification) {
        return notification.extras.getCharSequence("android.text");
    }

    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence("android.title");
    }

    public static Bundle getExtras(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT < 16) return null;
        return NotificationCompatJellybean.getExtras((Notification)notification);
    }

    public static String getGroup(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return notification.getGroup();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getString("android.support.groupKey");
        }
        if (Build.VERSION.SDK_INT < 16) return null;
        return NotificationCompatJellybean.getExtras((Notification)notification).getString("android.support.groupKey");
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT < 26) return 0;
        return notification.getGroupAlertBehavior();
    }

    static boolean getHighPriority(Notification notification) {
        boolean bl = (notification.flags & 0x80) != 0;
        return bl;
    }

    public static List<Action> getInvisibleActions(Notification notification) {
        ArrayList<Action> arrayList = new ArrayList<Action>();
        if (Build.VERSION.SDK_INT < 19) return arrayList;
        notification = notification.extras.getBundle("android.car.EXTENSIONS");
        if (notification == null) {
            return arrayList;
        }
        if ((notification = notification.getBundle("invisible_actions")) == null) return arrayList;
        int n = 0;
        while (n < notification.size()) {
            arrayList.add(NotificationCompatJellybean.getActionFromBundle((Bundle)notification.getBundle(Integer.toString(n))));
            ++n;
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n >= 20) {
            if ((notification.flags & 0x100) == 0) return bl;
            bl = true;
            return bl;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean("android.support.localOnly");
        }
        if (Build.VERSION.SDK_INT < 16) return false;
        return NotificationCompatJellybean.getExtras((Notification)notification).getBoolean("android.support.localOnly");
    }

    public static LocusIdCompat getLocusId(Notification notification) {
        LocusIdCompat locusIdCompat;
        int n = Build.VERSION.SDK_INT;
        LocusIdCompat locusIdCompat2 = locusIdCompat = null;
        if (n < 29) return locusIdCompat2;
        locusIdCompat2 = (notification = notification.getLocusId()) == null ? locusIdCompat : LocusIdCompat.toLocusIdCompat((LocusId)notification);
        return locusIdCompat2;
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String string) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(string);
        if (parcelableArray instanceof Notification[]) return (Notification[])parcelableArray;
        if (parcelableArray == null) {
            return (Notification[])parcelableArray;
        }
        Notification[] notificationArray = new Notification[parcelableArray.length];
        int n = 0;
        while (true) {
            if (n >= parcelableArray.length) {
                bundle.putParcelableArray(string, (Parcelable[])notificationArray);
                return notificationArray;
            }
            notificationArray[n] = (Notification)parcelableArray[n];
            ++n;
        }
    }

    public static boolean getOngoing(Notification notification) {
        boolean bl = (notification.flags & 2) != 0;
        return bl;
    }

    public static boolean getOnlyAlertOnce(Notification notification) {
        boolean bl = (notification.flags & 8) != 0;
        return bl;
    }

    public static List<Person> getPeople(Notification object) {
        ArrayList<Person> arrayList = new ArrayList<Person>();
        if (Build.VERSION.SDK_INT >= 28) {
            object = ((Notification)object).extras.getParcelableArrayList("android.people.list");
            if (object == null) return arrayList;
            if (((ArrayList)object).isEmpty()) return arrayList;
            object = ((ArrayList)object).iterator();
            while (object.hasNext()) {
                arrayList.add(Person.fromAndroidPerson((android.app.Person)((android.app.Person)object.next())));
            }
            return arrayList;
        }
        if (Build.VERSION.SDK_INT < 19) return arrayList;
        String[] stringArray = ((Notification)object).extras.getStringArray("android.people");
        if (stringArray == null) return arrayList;
        if (stringArray.length == 0) return arrayList;
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            object = stringArray[n2];
            arrayList.add(new Person.Builder().setUri((String)object).build());
            ++n2;
        }
        return arrayList;
    }

    public static Notification getPublicVersion(Notification notification) {
        if (Build.VERSION.SDK_INT < 21) return null;
        return notification.publicVersion;
    }

    public static CharSequence getSettingsText(Notification notification) {
        if (Build.VERSION.SDK_INT < 26) return null;
        return notification.getSettingsText();
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT < 26) return null;
        return notification.getShortcutId();
    }

    public static boolean getShowWhen(Notification notification) {
        return notification.extras.getBoolean("android.showWhen");
    }

    public static String getSortKey(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return notification.getSortKey();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getString("android.support.sortKey");
        }
        if (Build.VERSION.SDK_INT < 16) return null;
        return NotificationCompatJellybean.getExtras((Notification)notification).getString("android.support.sortKey");
    }

    public static CharSequence getSubText(Notification notification) {
        return notification.extras.getCharSequence("android.subText");
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT < 26) return 0L;
        return notification.getTimeoutAfter();
    }

    public static boolean getUsesChronometer(Notification notification) {
        return notification.extras.getBoolean("android.showChronometer");
    }

    public static int getVisibility(Notification notification) {
        if (Build.VERSION.SDK_INT < 21) return 0;
        return notification.visibility;
    }

    public static boolean isGroupSummary(Notification notification) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n >= 20) {
            if ((notification.flags & 0x200) == 0) return bl;
            bl = true;
            return bl;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean("android.support.isGroupSummary");
        }
        if (Build.VERSION.SDK_INT < 16) return false;
        return NotificationCompatJellybean.getExtras((Notification)notification).getBoolean("android.support.isGroupSummary");
    }
}
