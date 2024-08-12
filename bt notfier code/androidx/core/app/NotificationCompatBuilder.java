/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action$Builder
 *  android.app.Notification$Builder
 *  android.app.RemoteInput
 *  android.content.Context
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.widget.RemoteViews
 *  androidx.collection.ArraySet
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Action
 *  androidx.core.app.NotificationCompat$BubbleMetadata
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.core.app.NotificationCompatJellybean
 *  androidx.core.app.Person
 *  androidx.core.app.RemoteInput
 */
package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class NotificationCompatBuilder
implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList = new ArrayList<Bundle>();
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras = new Bundle();
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        this.mBuilderCompat = builder;
        this.mContext = builder.mContext;
        this.mBuilder = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(builder.mContext, builder.mChannelId) : new Notification.Builder(builder.mContext);
        Notification notification = builder.mNotification;
        Object object = this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean bl = (notification.flags & 2) != 0;
        object = object.setOngoing(bl);
        bl = (notification.flags & 8) != 0;
        object = object.setOnlyAlertOnce(bl);
        bl = (notification.flags & 0x10) != 0;
        object = object.setAutoCancel(bl).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent);
        Object object22 = builder.mFullScreenIntent;
        bl = (notification.flags & 0x80) != 0;
        object.setFullScreenIntent(object22, bl).setLargeIcon(builder.mLargeIcon).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        if (Build.VERSION.SDK_INT < 21) {
            this.mBuilder.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.mBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
            object = builder.mActions.iterator();
            while (object.hasNext()) {
                this.addAction((NotificationCompat.Action)object.next());
            }
            if (builder.mExtras != null) {
                this.mExtras.putAll(builder.mExtras);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (builder.mLocalOnly) {
                    this.mExtras.putBoolean("android.support.localOnly", true);
                }
                if (builder.mGroupKey != null) {
                    this.mExtras.putString("android.support.groupKey", builder.mGroupKey);
                    if (builder.mGroupSummary) {
                        this.mExtras.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.mExtras.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (builder.mSortKey != null) {
                    this.mExtras.putString("android.support.sortKey", builder.mSortKey);
                }
            }
            this.mContentView = builder.mContentView;
            this.mBigContentView = builder.mBigContentView;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.mBuilder.setShowWhen(builder.mShowWhen);
        }
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21 && (object = NotificationCompatBuilder.combineLists(NotificationCompatBuilder.getPeople(builder.mPersonList), builder.mPeople)) != null && !object.isEmpty()) {
            this.mExtras.putStringArray("android.people", object.toArray(new String[object.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.mBuilder.setLocalOnly(builder.mLocalOnly).setGroup(builder.mGroupKey).setGroupSummary(builder.mGroupSummary).setSortKey(builder.mSortKey);
            this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mBuilder.setCategory(builder.mCategory).setColor(builder.mColor).setVisibility(builder.mVisibility).setPublicVersion(builder.mPublicVersion).setSound(notification.sound, notification.audioAttributes);
            object = Build.VERSION.SDK_INT < 28 ? NotificationCompatBuilder.combineLists(NotificationCompatBuilder.getPeople(builder.mPersonList), builder.mPeople) : builder.mPeople;
            if (object != null && !object.isEmpty()) {
                object = object.iterator();
                while (object.hasNext()) {
                    object22 = (String)object.next();
                    this.mBuilder.addPerson((String)object22);
                }
            }
            this.mHeadsUpContentView = builder.mHeadsUpContentView;
            if (builder.mInvisibleActions.size() > 0) {
                object22 = builder.getExtras().getBundle("android.car.EXTENSIONS");
                object = object22;
                if (object22 == null) {
                    object = new Bundle();
                }
                Bundle bundle = new Bundle((Bundle)object);
                object22 = new Bundle();
                for (int i = 0; i < builder.mInvisibleActions.size(); ++i) {
                    object22.putBundle(Integer.toString(i), NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action)((NotificationCompat.Action)builder.mInvisibleActions.get(i))));
                }
                object.putBundle("invisible_actions", (Bundle)object22);
                bundle.putBundle("invisible_actions", (Bundle)object22);
                builder.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)object);
                this.mExtras.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && builder.mSmallIcon != null) {
            this.mBuilder.setSmallIcon(builder.mSmallIcon);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.mBuilder.setExtras(builder.mExtras).setRemoteInputHistory(builder.mRemoteInputHistory);
            if (builder.mContentView != null) {
                this.mBuilder.setCustomContentView(builder.mContentView);
            }
            if (builder.mBigContentView != null) {
                this.mBuilder.setCustomBigContentView(builder.mBigContentView);
            }
            if (builder.mHeadsUpContentView != null) {
                this.mBuilder.setCustomHeadsUpContentView(builder.mHeadsUpContentView);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder.setBadgeIconType(builder.mBadgeIcon).setSettingsText(builder.mSettingsText).setShortcutId(builder.mShortcutId).setTimeoutAfter(builder.mTimeout).setGroupAlertBehavior(builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                this.mBuilder.setColorized(builder.mColorized);
            }
            if (!TextUtils.isEmpty((CharSequence)builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            for (Object object22 : builder.mPersonList) {
                this.mBuilder.addPerson(object22.toAndroidPerson());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.mBuilder.setAllowSystemGeneratedContextualActions(builder.mAllowSystemGeneratedContextualActions);
            this.mBuilder.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform((NotificationCompat.BubbleMetadata)builder.mBubbleMetadata));
            if (builder.mLocusId != null) {
                this.mBuilder.setLocusId(builder.mLocusId.toLocusId());
            }
        }
        if (!builder.mSilent) return;
        this.mGroupAlertBehavior = this.mBuilderCompat.mGroupSummary ? 2 : 1;
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        notification.defaults &= 0xFFFFFFFE;
        notification.defaults &= 0xFFFFFFFD;
        this.mBuilder.setDefaults(notification.defaults);
        if (Build.VERSION.SDK_INT < 26) return;
        if (TextUtils.isEmpty((CharSequence)this.mBuilderCompat.mGroupKey)) {
            this.mBuilder.setGroup("silent");
        }
        this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
    }

    private void addAction(NotificationCompat.Action action) {
        if (Build.VERSION.SDK_INT >= 20) {
            Bundle bundle;
            Object object = action.getIconCompat();
            int n = Build.VERSION.SDK_INT;
            int n2 = 0;
            if (n >= 23) {
                object = object != null ? object.toIcon() : null;
                object = new Notification.Action.Builder((Icon)object, action.getTitle(), action.getActionIntent());
            } else {
                n = object != null ? object.getResId() : 0;
                object = new Notification.Action.Builder(n, action.getTitle(), action.getActionIntent());
            }
            if (action.getRemoteInputs() != null) {
                bundle = RemoteInput.fromCompat((RemoteInput[])action.getRemoteInputs());
                int n3 = ((android.app.RemoteInput[])bundle).length;
                for (n = n2; n < n3; ++n) {
                    object.addRemoteInput((android.app.RemoteInput)bundle[n]);
                }
            }
            bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT >= 24) {
                object.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
            if (Build.VERSION.SDK_INT >= 28) {
                object.setSemanticAction(action.getSemanticAction());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                object.setContextual(action.isContextual());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
            object.addExtras(bundle);
            this.mBuilder.addAction(object.build());
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras((Notification.Builder)this.mBuilder, (NotificationCompat.Action)action));
        }
    }

    private static List<String> combineLists(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList<String>((Collection<String>)arraySet);
    }

    private static List<String> getPeople(List<Person> object) {
        if (object == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(((Person)object.next()).resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= 0xFFFFFFFE;
        notification.defaults &= 0xFFFFFFFD;
    }

    public Notification build() {
        NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply((NotificationBuilderWithBuilderAccessor)this);
        }
        RemoteViews remoteViews = style != null ? style.makeContentView((NotificationBuilderWithBuilderAccessor)this) : null;
        Notification notification = this.buildInternal();
        if (remoteViews != null) {
            notification.contentView = remoteViews;
        } else if (this.mBuilderCompat.mContentView != null) {
            notification.contentView = this.mBuilderCompat.mContentView;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (remoteViews = style.makeBigContentView((NotificationBuilderWithBuilderAccessor)this)) != null) {
            notification.bigContentView = remoteViews;
        }
        if (Build.VERSION.SDK_INT >= 21 && style != null && (remoteViews = this.mBuilderCompat.mStyle.makeHeadsUpContentView((NotificationBuilderWithBuilderAccessor)this)) != null) {
            notification.headsUpContentView = remoteViews;
        }
        if (Build.VERSION.SDK_INT < 16) return notification;
        if (style == null) return notification;
        remoteViews = NotificationCompat.getExtras((Notification)notification);
        if (remoteViews == null) return notification;
        style.addCompatExtras((Bundle)remoteViews);
        return notification;
    }

    protected Notification buildInternal() {
        String string2;
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mBuilder.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification notification = this.mBuilder.build();
            if (this.mGroupAlertBehavior == 0) return notification;
            if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2) {
                this.removeSoundAndVibration(notification);
            }
            if (notification.getGroup() == null) return notification;
            if ((notification.flags & 0x200) != 0) return notification;
            if (this.mGroupAlertBehavior != 1) return notification;
            this.removeSoundAndVibration(notification);
            return notification;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mBuilder.setExtras(this.mExtras);
            Notification notification = this.mBuilder.build();
            RemoteViews remoteViews = this.mContentView;
            if (remoteViews != null) {
                notification.contentView = remoteViews;
            }
            if ((remoteViews = this.mBigContentView) != null) {
                notification.bigContentView = remoteViews;
            }
            if ((remoteViews = this.mHeadsUpContentView) != null) {
                notification.headsUpContentView = remoteViews;
            }
            if (this.mGroupAlertBehavior == 0) return notification;
            if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2) {
                this.removeSoundAndVibration(notification);
            }
            if (notification.getGroup() == null) return notification;
            if ((notification.flags & 0x200) != 0) return notification;
            if (this.mGroupAlertBehavior != 1) return notification;
            this.removeSoundAndVibration(notification);
            return notification;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.mBuilder.setExtras(this.mExtras);
            Notification notification = this.mBuilder.build();
            RemoteViews remoteViews = this.mContentView;
            if (remoteViews != null) {
                notification.contentView = remoteViews;
            }
            if ((remoteViews = this.mBigContentView) != null) {
                notification.bigContentView = remoteViews;
            }
            if (this.mGroupAlertBehavior == 0) return notification;
            if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2) {
                this.removeSoundAndVibration(notification);
            }
            if (notification.getGroup() == null) return notification;
            if ((notification.flags & 0x200) != 0) return notification;
            if (this.mGroupAlertBehavior != 1) return notification;
            this.removeSoundAndVibration(notification);
            return notification;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SparseArray sparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (sparseArray != null) {
                this.mExtras.putSparseParcelableArray("android.support.actionExtras", sparseArray);
            }
            this.mBuilder.setExtras(this.mExtras);
            sparseArray = this.mBuilder.build();
            RemoteViews remoteViews = this.mContentView;
            if (remoteViews != null) {
                sparseArray.contentView = remoteViews;
            }
            if ((remoteViews = this.mBigContentView) == null) return sparseArray;
            sparseArray.bigContentView = remoteViews;
            return sparseArray;
        }
        if (Build.VERSION.SDK_INT < 16) return this.mBuilder.getNotification();
        Notification notification = this.mBuilder.build();
        Bundle bundle = NotificationCompat.getExtras((Notification)notification);
        Bundle bundle2 = new Bundle(this.mExtras);
        for (String string2 : this.mExtras.keySet()) {
            if (!bundle.containsKey(string2)) continue;
            bundle2.remove(string2);
        }
        bundle.putAll(bundle2);
        string2 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (string2 != null) {
            NotificationCompat.getExtras((Notification)notification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)string2);
        }
        if ((string2 = this.mContentView) != null) {
            notification.contentView = string2;
        }
        if ((string2 = this.mBigContentView) == null) return notification;
        notification.bigContentView = string2;
        return notification;
    }

    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }
}
