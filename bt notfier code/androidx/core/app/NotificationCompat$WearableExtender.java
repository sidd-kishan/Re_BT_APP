/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$Action$Builder
 *  android.app.PendingIntent
 *  android.app.RemoteInput
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Action
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Extender
 *  androidx.core.app.NotificationCompatJellybean
 *  androidx.core.app.RemoteInput
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class NotificationCompat.WearableExtender
implements NotificationCompat.Extender {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 0x800005;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";
    @Deprecated
    public static final int SCREEN_TIMEOUT_LONG = -1;
    @Deprecated
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    @Deprecated
    public static final int SIZE_DEFAULT = 0;
    @Deprecated
    public static final int SIZE_FULL_SCREEN = 5;
    @Deprecated
    public static final int SIZE_LARGE = 4;
    @Deprecated
    public static final int SIZE_MEDIUM = 3;
    @Deprecated
    public static final int SIZE_SMALL = 2;
    @Deprecated
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = -1;
    private ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    private Bitmap mBackground;
    private String mBridgeTag;
    private int mContentActionIndex = -1;
    private int mContentIcon;
    private int mContentIconGravity = 0x800005;
    private int mCustomContentHeight;
    private int mCustomSizePreset = 0;
    private String mDismissalId;
    private PendingIntent mDisplayIntent;
    private int mFlags = 1;
    private int mGravity = 80;
    private int mHintScreenTimeout;
    private ArrayList<Notification> mPages = new ArrayList();

    public NotificationCompat.WearableExtender() {
    }

    public NotificationCompat.WearableExtender(Notification object) {
        object = NotificationCompat.getExtras((Notification)object);
        object = object != null ? object.getBundle("android.wearable.EXTENSIONS") : null;
        if (object == null) return;
        Notification[] notificationArray = object.getParcelableArrayList("actions");
        if (Build.VERSION.SDK_INT >= 16 && notificationArray != null) {
            int n = notificationArray.size();
            NotificationCompat.Action[] actionArray = new NotificationCompat.Action[n];
            for (int i = 0; i < n; ++i) {
                if (Build.VERSION.SDK_INT >= 20) {
                    actionArray[i] = NotificationCompat.getActionCompatFromAction((Notification.Action)((Notification.Action)notificationArray.get(i)));
                    continue;
                }
                if (Build.VERSION.SDK_INT < 16) continue;
                actionArray[i] = NotificationCompatJellybean.getActionFromBundle((Bundle)((Bundle)notificationArray.get(i)));
            }
            Collections.addAll(this.mActions, actionArray);
        }
        this.mFlags = object.getInt("flags", 1);
        this.mDisplayIntent = (PendingIntent)object.getParcelable("displayIntent");
        notificationArray = NotificationCompat.getNotificationArrayFromBundle((Bundle)object, (String)"pages");
        if (notificationArray != null) {
            Collections.addAll(this.mPages, notificationArray);
        }
        this.mBackground = (Bitmap)object.getParcelable("background");
        this.mContentIcon = object.getInt("contentIcon");
        this.mContentIconGravity = object.getInt("contentIconGravity", 0x800005);
        this.mContentActionIndex = object.getInt("contentActionIndex", -1);
        this.mCustomSizePreset = object.getInt("customSizePreset", 0);
        this.mCustomContentHeight = object.getInt("customContentHeight");
        this.mGravity = object.getInt("gravity", 80);
        this.mHintScreenTimeout = object.getInt("hintScreenTimeout");
        this.mDismissalId = object.getString("dismissalId");
        this.mBridgeTag = object.getString("bridgeTag");
    }

    private static Notification.Action getActionFromActionCompat(NotificationCompat.Action remoteInputArray) {
        Object object;
        int n = Build.VERSION.SDK_INT;
        int n2 = 0;
        if (n >= 23) {
            object = remoteInputArray.getIconCompat();
            object = object == null ? null : object.toIcon();
            object = new Notification.Action.Builder((Icon)object, remoteInputArray.getTitle(), remoteInputArray.getActionIntent());
        } else {
            object = remoteInputArray.getIconCompat();
            n = object != null && object.getType() == 2 ? object.getResId() : 0;
            object = new Notification.Action.Builder(n, remoteInputArray.getTitle(), remoteInputArray.getActionIntent());
        }
        Bundle bundle = remoteInputArray.getExtras() != null ? new Bundle(remoteInputArray.getExtras()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", remoteInputArray.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT >= 24) {
            object.setAllowGeneratedReplies(remoteInputArray.getAllowGeneratedReplies());
        }
        object.addExtras(bundle);
        remoteInputArray = remoteInputArray.getRemoteInputs();
        if (remoteInputArray == null) return object.build();
        remoteInputArray = RemoteInput.fromCompat((RemoteInput[])remoteInputArray);
        int n3 = remoteInputArray.length;
        n = n2;
        while (n < n3) {
            object.addRemoteInput((android.app.RemoteInput)remoteInputArray[n]);
            ++n;
        }
        return object.build();
    }

    private void setFlag(int n, boolean bl) {
        this.mFlags = bl ? n | this.mFlags : ~n & this.mFlags;
    }

    public NotificationCompat.WearableExtender addAction(NotificationCompat.Action action) {
        this.mActions.add(action);
        return this;
    }

    public NotificationCompat.WearableExtender addActions(List<NotificationCompat.Action> list) {
        this.mActions.addAll(list);
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender addPage(Notification notification) {
        this.mPages.add(notification);
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender addPages(List<Notification> list) {
        this.mPages.addAll(list);
        return this;
    }

    public NotificationCompat.WearableExtender clearActions() {
        this.mActions.clear();
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender clearPages() {
        this.mPages.clear();
        return this;
    }

    public NotificationCompat.WearableExtender clone() {
        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
        wearableExtender.mActions = new ArrayList<NotificationCompat.Action>(this.mActions);
        wearableExtender.mFlags = this.mFlags;
        wearableExtender.mDisplayIntent = this.mDisplayIntent;
        wearableExtender.mPages = new ArrayList<Notification>(this.mPages);
        wearableExtender.mBackground = this.mBackground;
        wearableExtender.mContentIcon = this.mContentIcon;
        wearableExtender.mContentIconGravity = this.mContentIconGravity;
        wearableExtender.mContentActionIndex = this.mContentActionIndex;
        wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
        wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
        wearableExtender.mGravity = this.mGravity;
        wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
        wearableExtender.mDismissalId = this.mDismissalId;
        wearableExtender.mBridgeTag = this.mBridgeTag;
        return wearableExtender;
    }

    public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
        int n;
        Object object;
        Bundle bundle = new Bundle();
        if (!this.mActions.isEmpty()) {
            if (Build.VERSION.SDK_INT < 16) {
                bundle.putParcelableArrayList("actions", null);
            } else {
                ArrayList<Object> arrayList = new ArrayList<Object>(this.mActions.size());
                object = this.mActions.iterator();
                while (object.hasNext()) {
                    NotificationCompat.Action action = (NotificationCompat.Action)object.next();
                    if (Build.VERSION.SDK_INT >= 20) {
                        arrayList.add(NotificationCompat.WearableExtender.getActionFromActionCompat(action));
                        continue;
                    }
                    if (Build.VERSION.SDK_INT < 16) continue;
                    arrayList.add(NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action)action));
                }
                bundle.putParcelableArrayList("actions", arrayList);
            }
        }
        if ((n = this.mFlags) != 1) {
            bundle.putInt("flags", n);
        }
        if ((object = this.mDisplayIntent) != null) {
            bundle.putParcelable("displayIntent", (Parcelable)object);
        }
        if (!this.mPages.isEmpty()) {
            object = this.mPages;
            bundle.putParcelableArray("pages", (Parcelable[])((ArrayList)object).toArray(new Notification[((ArrayList)object).size()]));
        }
        if ((object = this.mBackground) != null) {
            bundle.putParcelable("background", (Parcelable)object);
        }
        if ((n = this.mContentIcon) != 0) {
            bundle.putInt("contentIcon", n);
        }
        if ((n = this.mContentIconGravity) != 0x800005) {
            bundle.putInt("contentIconGravity", n);
        }
        if ((n = this.mContentActionIndex) != -1) {
            bundle.putInt("contentActionIndex", n);
        }
        if ((n = this.mCustomSizePreset) != 0) {
            bundle.putInt("customSizePreset", n);
        }
        if ((n = this.mCustomContentHeight) != 0) {
            bundle.putInt("customContentHeight", n);
        }
        if ((n = this.mGravity) != 80) {
            bundle.putInt("gravity", n);
        }
        if ((n = this.mHintScreenTimeout) != 0) {
            bundle.putInt("hintScreenTimeout", n);
        }
        if ((object = this.mDismissalId) != null) {
            bundle.putString("dismissalId", (String)object);
        }
        if ((object = this.mBridgeTag) != null) {
            bundle.putString("bridgeTag", (String)object);
        }
        builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return builder;
    }

    public List<NotificationCompat.Action> getActions() {
        return this.mActions;
    }

    @Deprecated
    public Bitmap getBackground() {
        return this.mBackground;
    }

    public String getBridgeTag() {
        return this.mBridgeTag;
    }

    public int getContentAction() {
        return this.mContentActionIndex;
    }

    @Deprecated
    public int getContentIcon() {
        return this.mContentIcon;
    }

    @Deprecated
    public int getContentIconGravity() {
        return this.mContentIconGravity;
    }

    public boolean getContentIntentAvailableOffline() {
        int n = this.mFlags;
        boolean bl = true;
        if ((n & 1) != 0) return bl;
        bl = false;
        return bl;
    }

    @Deprecated
    public int getCustomContentHeight() {
        return this.mCustomContentHeight;
    }

    @Deprecated
    public int getCustomSizePreset() {
        return this.mCustomSizePreset;
    }

    public String getDismissalId() {
        return this.mDismissalId;
    }

    @Deprecated
    public PendingIntent getDisplayIntent() {
        return this.mDisplayIntent;
    }

    @Deprecated
    public int getGravity() {
        return this.mGravity;
    }

    @Deprecated
    public boolean getHintAmbientBigPicture() {
        boolean bl = (this.mFlags & 0x20) != 0;
        return bl;
    }

    @Deprecated
    public boolean getHintAvoidBackgroundClipping() {
        boolean bl = (this.mFlags & 0x10) != 0;
        return bl;
    }

    public boolean getHintContentIntentLaunchesActivity() {
        boolean bl = (this.mFlags & 0x40) != 0;
        return bl;
    }

    @Deprecated
    public boolean getHintHideIcon() {
        boolean bl = (this.mFlags & 2) != 0;
        return bl;
    }

    @Deprecated
    public int getHintScreenTimeout() {
        return this.mHintScreenTimeout;
    }

    @Deprecated
    public boolean getHintShowBackgroundOnly() {
        boolean bl = (this.mFlags & 4) != 0;
        return bl;
    }

    @Deprecated
    public List<Notification> getPages() {
        return this.mPages;
    }

    public boolean getStartScrollBottom() {
        boolean bl = (this.mFlags & 8) != 0;
        return bl;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setBackground(Bitmap bitmap) {
        this.mBackground = bitmap;
        return this;
    }

    public NotificationCompat.WearableExtender setBridgeTag(String string) {
        this.mBridgeTag = string;
        return this;
    }

    public NotificationCompat.WearableExtender setContentAction(int n) {
        this.mContentActionIndex = n;
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setContentIcon(int n) {
        this.mContentIcon = n;
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setContentIconGravity(int n) {
        this.mContentIconGravity = n;
        return this;
    }

    public NotificationCompat.WearableExtender setContentIntentAvailableOffline(boolean bl) {
        this.setFlag(1, bl);
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setCustomContentHeight(int n) {
        this.mCustomContentHeight = n;
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setCustomSizePreset(int n) {
        this.mCustomSizePreset = n;
        return this;
    }

    public NotificationCompat.WearableExtender setDismissalId(String string) {
        this.mDismissalId = string;
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
        this.mDisplayIntent = pendingIntent;
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setGravity(int n) {
        this.mGravity = n;
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setHintAmbientBigPicture(boolean bl) {
        this.setFlag(32, bl);
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setHintAvoidBackgroundClipping(boolean bl) {
        this.setFlag(16, bl);
        return this;
    }

    public NotificationCompat.WearableExtender setHintContentIntentLaunchesActivity(boolean bl) {
        this.setFlag(64, bl);
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setHintHideIcon(boolean bl) {
        this.setFlag(2, bl);
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setHintScreenTimeout(int n) {
        this.mHintScreenTimeout = n;
        return this;
    }

    @Deprecated
    public NotificationCompat.WearableExtender setHintShowBackgroundOnly(boolean bl) {
        this.setFlag(4, bl);
        return this;
    }

    public NotificationCompat.WearableExtender setStartScrollBottom(boolean bl) {
        this.setFlag(8, bl);
        return this;
    }
}
