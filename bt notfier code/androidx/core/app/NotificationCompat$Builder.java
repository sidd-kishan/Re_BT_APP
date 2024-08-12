/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$Builder
 *  android.app.PendingIntent
 *  android.app.Person
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Icon
 *  android.media.AudioAttributes$Builder
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.widget.RemoteViews
 *  androidx.core.R$dimen
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Action
 *  androidx.core.app.NotificationCompat$Action$Builder
 *  androidx.core.app.NotificationCompat$BubbleMetadata
 *  androidx.core.app.NotificationCompat$Extender
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.core.app.NotificationCompatBuilder
 *  androidx.core.app.Person
 *  androidx.core.content.LocusIdCompat
 *  androidx.core.content.pm.ShortcutInfoCompat
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatBuilder;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
public static class NotificationCompat.Builder {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    public ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    boolean mAllowSystemGeneratedContextualActions;
    int mBadgeIcon = 0;
    RemoteViews mBigContentView;
    NotificationCompat.BubbleMetadata mBubbleMetadata;
    String mCategory;
    String mChannelId;
    boolean mChronometerCountDown;
    int mColor = 0;
    boolean mColorized;
    boolean mColorizedSet;
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    RemoteViews mContentView;
    public Context mContext;
    Bundle mExtras;
    PendingIntent mFullScreenIntent;
    int mGroupAlertBehavior = 0;
    String mGroupKey;
    boolean mGroupSummary;
    RemoteViews mHeadsUpContentView;
    ArrayList<NotificationCompat.Action> mInvisibleActions;
    Bitmap mLargeIcon;
    boolean mLocalOnly = false;
    LocusIdCompat mLocusId;
    Notification mNotification;
    int mNumber;
    @Deprecated
    public ArrayList<String> mPeople;
    public ArrayList<Person> mPersonList = new ArrayList();
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    Notification mPublicVersion;
    CharSequence[] mRemoteInputHistory;
    CharSequence mSettingsText;
    String mShortcutId;
    boolean mShowWhen = true;
    boolean mSilent;
    Icon mSmallIcon;
    String mSortKey;
    NotificationCompat.Style mStyle;
    CharSequence mSubText;
    RemoteViews mTickerView;
    long mTimeout;
    boolean mUseChronometer;
    int mVisibility = 0;

    @Deprecated
    public NotificationCompat.Builder(Context context) {
        this(context, (String)null);
    }

    public NotificationCompat.Builder(Context context, Notification object) {
        this(context, NotificationCompat.getChannelId((Notification)object));
        int n;
        int n2;
        context = ((Notification)object).extras;
        Object object2 = NotificationCompat.Style.extractStyleFromNotification((Notification)object);
        this.setContentTitle(NotificationCompat.getContentTitle((Notification)object)).setContentText(NotificationCompat.getContentText((Notification)object)).setContentInfo(NotificationCompat.getContentInfo((Notification)object)).setSubText(NotificationCompat.getSubText((Notification)object)).setSettingsText(NotificationCompat.getSettingsText((Notification)object)).setStyle((NotificationCompat.Style)object2).setContentIntent(((Notification)object).contentIntent).setGroup(NotificationCompat.getGroup((Notification)object)).setGroupSummary(NotificationCompat.isGroupSummary((Notification)object)).setLocusId(NotificationCompat.getLocusId((Notification)object)).setWhen(((Notification)object).when).setShowWhen(NotificationCompat.getShowWhen((Notification)object)).setUsesChronometer(NotificationCompat.getUsesChronometer((Notification)object)).setAutoCancel(NotificationCompat.getAutoCancel((Notification)object)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce((Notification)object)).setOngoing(NotificationCompat.getOngoing((Notification)object)).setLocalOnly(NotificationCompat.getLocalOnly((Notification)object)).setLargeIcon(((Notification)object).largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType((Notification)object)).setCategory(NotificationCompat.getCategory((Notification)object)).setBubbleMetadata(NotificationCompat.getBubbleMetadata((Notification)object)).setNumber(((Notification)object).number).setTicker(((Notification)object).tickerText).setContentIntent(((Notification)object).contentIntent).setDeleteIntent(((Notification)object).deleteIntent).setFullScreenIntent(((Notification)object).fullScreenIntent, NotificationCompat.getHighPriority((Notification)object)).setSound(((Notification)object).sound, ((Notification)object).audioStreamType).setVibrate(((Notification)object).vibrate).setLights(((Notification)object).ledARGB, ((Notification)object).ledOnMS, ((Notification)object).ledOffMS).setDefaults(((Notification)object).defaults).setPriority(((Notification)object).priority).setColor(NotificationCompat.getColor((Notification)object)).setVisibility(NotificationCompat.getVisibility((Notification)object)).setPublicVersion(NotificationCompat.getPublicVersion((Notification)object)).setSortKey(NotificationCompat.getSortKey((Notification)object)).setTimeoutAfter(NotificationCompat.getTimeoutAfter((Notification)object)).setShortcutId(NotificationCompat.getShortcutId((Notification)object)).setProgress(context.getInt("android.progressMax"), context.getInt("android.progress"), context.getBoolean("android.progressIndeterminate")).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions((Notification)object)).setSmallIcon(((Notification)object).icon, ((Notification)object).iconLevel).addExtras(NotificationCompat.Builder.getExtrasWithoutDuplicateData((Notification)object, (NotificationCompat.Style)object2));
        if (Build.VERSION.SDK_INT >= 23) {
            this.mSmallIcon = object.getSmallIcon();
        }
        object2 = ((Notification)object).actions;
        int n3 = 0;
        if (object2 != null && ((Notification)object).actions.length != 0) {
            object2 = ((Notification)object).actions;
            n2 = ((Object)object2).length;
            for (n = 0; n < n2; ++n) {
                this.addAction(NotificationCompat.Action.Builder.fromAndroidAction((Notification.Action)object2[n]).build());
            }
        }
        if (Build.VERSION.SDK_INT >= 21 && !(object2 = NotificationCompat.getInvisibleActions((Notification)object)).isEmpty()) {
            object2 = object2.iterator();
            while (object2.hasNext()) {
                this.addInvisibleAction((NotificationCompat.Action)object2.next());
            }
        }
        if ((object2 = ((Notification)object).extras.getStringArray("android.people")) != null && ((Object)object2).length != 0) {
            n2 = ((Object)object2).length;
            for (n = n3; n < n2; ++n) {
                this.addPerson((String)object2[n]);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && (object = ((Notification)object).extras.getParcelableArrayList("android.people.list")) != null && !((ArrayList)object).isEmpty()) {
            object = ((ArrayList)object).iterator();
            while (object.hasNext()) {
                this.addPerson(Person.fromAndroidPerson((android.app.Person)((android.app.Person)object.next())));
            }
        }
        if (Build.VERSION.SDK_INT >= 24 && context.containsKey("android.chronometerCountDown")) {
            this.setChronometerCountDown(context.getBoolean("android.chronometerCountDown"));
        }
        if (Build.VERSION.SDK_INT < 26) return;
        if (!context.containsKey("android.colorized")) return;
        this.setColorized(context.getBoolean("android.colorized"));
    }

    public NotificationCompat.Builder(Context context, String string) {
        Notification notification;
        this.mInvisibleActions = new ArrayList();
        this.mNotification = notification = new Notification();
        this.mContext = context;
        this.mChannelId = string;
        notification.when = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    private static Bundle getExtrasWithoutDuplicateData(Notification notification, NotificationCompat.Style style) {
        if (notification.extras == null) {
            return null;
        }
        notification = new Bundle(notification.extras);
        notification.remove("android.title");
        notification.remove("android.text");
        notification.remove("android.infoText");
        notification.remove("android.subText");
        notification.remove("android.intent.extra.CHANNEL_ID");
        notification.remove("android.intent.extra.CHANNEL_GROUP_ID");
        notification.remove("android.showWhen");
        notification.remove("android.progress");
        notification.remove("android.progressMax");
        notification.remove("android.progressIndeterminate");
        notification.remove("android.chronometerCountDown");
        notification.remove("android.colorized");
        notification.remove("android.people.list");
        notification.remove("android.people");
        notification.remove("android.support.sortKey");
        notification.remove("android.support.groupKey");
        notification.remove("android.support.isGroupSummary");
        notification.remove("android.support.localOnly");
        notification.remove("android.support.actionExtras");
        Bundle bundle = notification.getBundle("android.car.EXTENSIONS");
        if (bundle != null) {
            bundle = new Bundle(bundle);
            bundle.remove("invisible_actions");
            notification.putBundle("android.car.EXTENSIONS", bundle);
        }
        if (style == null) return notification;
        style.clearCompatExtraKeys((Bundle)notification);
        return notification;
    }

    protected static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        if (charSequence == null) {
            return charSequence;
        }
        CharSequence charSequence2 = charSequence;
        if (charSequence.length() <= 5120) return charSequence2;
        charSequence2 = charSequence.subSequence(0, 5120);
        return charSequence2;
    }

    private Bitmap reduceLargeIconSize(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) return bitmap2;
        if (Build.VERSION.SDK_INT >= 27) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = this.mContext.getResources();
            int n = bitmap2.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int n2 = bitmap2.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= n && bitmap.getHeight() <= n2) {
                return bitmap;
            }
            double d = n;
            double d2 = Math.max(1, bitmap.getWidth());
            Double.isNaN(d);
            Double.isNaN(d2);
            d /= d2;
            d2 = n2;
            double d3 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = Math.min(d, d2 / d3);
            d2 = bitmap.getWidth();
            Double.isNaN(d2);
            n = (int)Math.ceil(d2 * d);
            d2 = bitmap.getHeight();
            Double.isNaN(d2);
            bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n, (int)((int)Math.ceil(d2 * d)), (boolean)true);
        }
        return bitmap2;
    }

    private void setFlag(int n, boolean bl) {
        if (bl) {
            Notification notification = this.mNotification;
            notification.flags = n | notification.flags;
        } else {
            Notification notification = this.mNotification;
            notification.flags = ~n & notification.flags;
        }
    }

    private boolean useExistingRemoteView() {
        NotificationCompat.Style style = this.mStyle;
        boolean bl = style == null || !style.displayCustomViewInline();
        return bl;
    }

    public NotificationCompat.Builder addAction(int n, CharSequence charSequence, PendingIntent pendingIntent) {
        this.mActions.add(new NotificationCompat.Action(n, charSequence, pendingIntent));
        return this;
    }

    public NotificationCompat.Builder addAction(NotificationCompat.Action action) {
        if (action == null) return this;
        this.mActions.add(action);
        return this;
    }

    public NotificationCompat.Builder addExtras(Bundle bundle) {
        if (bundle == null) return this;
        Bundle bundle2 = this.mExtras;
        if (bundle2 == null) {
            this.mExtras = new Bundle(bundle);
        } else {
            bundle2.putAll(bundle);
        }
        return this;
    }

    public NotificationCompat.Builder addInvisibleAction(int n, CharSequence charSequence, PendingIntent pendingIntent) {
        this.mInvisibleActions.add(new NotificationCompat.Action(n, charSequence, pendingIntent));
        return this;
    }

    public NotificationCompat.Builder addInvisibleAction(NotificationCompat.Action action) {
        if (action == null) return this;
        this.mInvisibleActions.add(action);
        return this;
    }

    public NotificationCompat.Builder addPerson(Person person) {
        if (person == null) return this;
        this.mPersonList.add(person);
        return this;
    }

    @Deprecated
    public NotificationCompat.Builder addPerson(String string) {
        if (string == null) return this;
        if (string.isEmpty()) return this;
        this.mPeople.add(string);
        return this;
    }

    public Notification build() {
        return new NotificationCompatBuilder(this).build();
    }

    public NotificationCompat.Builder clearActions() {
        this.mActions.clear();
        return this;
    }

    public NotificationCompat.Builder clearInvisibleActions() {
        this.mInvisibleActions.clear();
        Bundle bundle = this.mExtras.getBundle("android.car.EXTENSIONS");
        if (bundle == null) return this;
        bundle = new Bundle(bundle);
        bundle.remove("invisible_actions");
        this.mExtras.putBundle("android.car.EXTENSIONS", bundle);
        return this;
    }

    public NotificationCompat.Builder clearPeople() {
        this.mPersonList.clear();
        this.mPeople.clear();
        return this;
    }

    public RemoteViews createBigContentView() {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        if (this.mBigContentView != null && this.useExistingRemoteView()) {
            return this.mBigContentView;
        }
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat.Style style = this.mStyle;
        if (style != null && (style = style.makeBigContentView((NotificationBuilderWithBuilderAccessor)notificationCompatBuilder)) != null) {
            return style;
        }
        notificationCompatBuilder = notificationCompatBuilder.build();
        if (Build.VERSION.SDK_INT < 24) return notificationCompatBuilder.bigContentView;
        return Notification.Builder.recoverBuilder((Context)this.mContext, (Notification)notificationCompatBuilder).createBigContentView();
    }

    public RemoteViews createContentView() {
        if (this.mContentView != null && this.useExistingRemoteView()) {
            return this.mContentView;
        }
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat.Style style = this.mStyle;
        if (style != null && (style = style.makeContentView((NotificationBuilderWithBuilderAccessor)notificationCompatBuilder)) != null) {
            return style;
        }
        notificationCompatBuilder = notificationCompatBuilder.build();
        if (Build.VERSION.SDK_INT < 24) return notificationCompatBuilder.contentView;
        return Notification.Builder.recoverBuilder((Context)this.mContext, (Notification)notificationCompatBuilder).createContentView();
    }

    public RemoteViews createHeadsUpContentView() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (this.mHeadsUpContentView != null && this.useExistingRemoteView()) {
            return this.mHeadsUpContentView;
        }
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat.Style style = this.mStyle;
        if (style != null && (style = style.makeHeadsUpContentView((NotificationBuilderWithBuilderAccessor)notificationCompatBuilder)) != null) {
            return style;
        }
        notificationCompatBuilder = notificationCompatBuilder.build();
        if (Build.VERSION.SDK_INT < 24) return notificationCompatBuilder.headsUpContentView;
        return Notification.Builder.recoverBuilder((Context)this.mContext, (Notification)notificationCompatBuilder).createHeadsUpContentView();
    }

    public NotificationCompat.Builder extend(NotificationCompat.Extender extender) {
        extender.extend(this);
        return this;
    }

    public RemoteViews getBigContentView() {
        return this.mBigContentView;
    }

    public NotificationCompat.BubbleMetadata getBubbleMetadata() {
        return this.mBubbleMetadata;
    }

    public int getColor() {
        return this.mColor;
    }

    public RemoteViews getContentView() {
        return this.mContentView;
    }

    public Bundle getExtras() {
        if (this.mExtras != null) return this.mExtras;
        this.mExtras = new Bundle();
        return this.mExtras;
    }

    public RemoteViews getHeadsUpContentView() {
        return this.mHeadsUpContentView;
    }

    @Deprecated
    public Notification getNotification() {
        return this.build();
    }

    public int getPriority() {
        return this.mPriority;
    }

    public long getWhenIfShowing() {
        long l = this.mShowWhen ? this.mNotification.when : 0L;
        return l;
    }

    public NotificationCompat.Builder setAllowSystemGeneratedContextualActions(boolean bl) {
        this.mAllowSystemGeneratedContextualActions = bl;
        return this;
    }

    public NotificationCompat.Builder setAutoCancel(boolean bl) {
        this.setFlag(16, bl);
        return this;
    }

    public NotificationCompat.Builder setBadgeIconType(int n) {
        this.mBadgeIcon = n;
        return this;
    }

    public NotificationCompat.Builder setBubbleMetadata(NotificationCompat.BubbleMetadata bubbleMetadata) {
        this.mBubbleMetadata = bubbleMetadata;
        return this;
    }

    public NotificationCompat.Builder setCategory(String string) {
        this.mCategory = string;
        return this;
    }

    public NotificationCompat.Builder setChannelId(String string) {
        this.mChannelId = string;
        return this;
    }

    public NotificationCompat.Builder setChronometerCountDown(boolean bl) {
        this.mChronometerCountDown = bl;
        this.getExtras().putBoolean("android.chronometerCountDown", bl);
        return this;
    }

    public NotificationCompat.Builder setColor(int n) {
        this.mColor = n;
        return this;
    }

    public NotificationCompat.Builder setColorized(boolean bl) {
        this.mColorized = bl;
        this.mColorizedSet = true;
        return this;
    }

    public NotificationCompat.Builder setContent(RemoteViews remoteViews) {
        this.mNotification.contentView = remoteViews;
        return this;
    }

    public NotificationCompat.Builder setContentInfo(CharSequence charSequence) {
        this.mContentInfo = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat.Builder setContentIntent(PendingIntent pendingIntent) {
        this.mContentIntent = pendingIntent;
        return this;
    }

    public NotificationCompat.Builder setContentText(CharSequence charSequence) {
        this.mContentText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat.Builder setContentTitle(CharSequence charSequence) {
        this.mContentTitle = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat.Builder setCustomBigContentView(RemoteViews remoteViews) {
        this.mBigContentView = remoteViews;
        return this;
    }

    public NotificationCompat.Builder setCustomContentView(RemoteViews remoteViews) {
        this.mContentView = remoteViews;
        return this;
    }

    public NotificationCompat.Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
        this.mHeadsUpContentView = remoteViews;
        return this;
    }

    public NotificationCompat.Builder setDefaults(int n) {
        this.mNotification.defaults = n;
        if ((n & 4) == 0) return this;
        Notification notification = this.mNotification;
        notification.flags |= 1;
        return this;
    }

    public NotificationCompat.Builder setDeleteIntent(PendingIntent pendingIntent) {
        this.mNotification.deleteIntent = pendingIntent;
        return this;
    }

    public NotificationCompat.Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    public NotificationCompat.Builder setFullScreenIntent(PendingIntent pendingIntent, boolean bl) {
        this.mFullScreenIntent = pendingIntent;
        this.setFlag(128, bl);
        return this;
    }

    public NotificationCompat.Builder setGroup(String string) {
        this.mGroupKey = string;
        return this;
    }

    public NotificationCompat.Builder setGroupAlertBehavior(int n) {
        this.mGroupAlertBehavior = n;
        return this;
    }

    public NotificationCompat.Builder setGroupSummary(boolean bl) {
        this.mGroupSummary = bl;
        return this;
    }

    public NotificationCompat.Builder setLargeIcon(Bitmap bitmap) {
        this.mLargeIcon = this.reduceLargeIconSize(bitmap);
        return this;
    }

    public NotificationCompat.Builder setLights(int n, int n2, int n3) {
        this.mNotification.ledARGB = n;
        this.mNotification.ledOnMS = n2;
        this.mNotification.ledOffMS = n3;
        n = this.mNotification.ledOnMS != 0 && this.mNotification.ledOffMS != 0 ? 1 : 0;
        Notification notification = this.mNotification;
        notification.flags = n | notification.flags & 0xFFFFFFFE;
        return this;
    }

    public NotificationCompat.Builder setLocalOnly(boolean bl) {
        this.mLocalOnly = bl;
        return this;
    }

    public NotificationCompat.Builder setLocusId(LocusIdCompat locusIdCompat) {
        this.mLocusId = locusIdCompat;
        return this;
    }

    @Deprecated
    public NotificationCompat.Builder setNotificationSilent() {
        this.mSilent = true;
        return this;
    }

    public NotificationCompat.Builder setNumber(int n) {
        this.mNumber = n;
        return this;
    }

    public NotificationCompat.Builder setOngoing(boolean bl) {
        this.setFlag(2, bl);
        return this;
    }

    public NotificationCompat.Builder setOnlyAlertOnce(boolean bl) {
        this.setFlag(8, bl);
        return this;
    }

    public NotificationCompat.Builder setPriority(int n) {
        this.mPriority = n;
        return this;
    }

    public NotificationCompat.Builder setProgress(int n, int n2, boolean bl) {
        this.mProgressMax = n;
        this.mProgress = n2;
        this.mProgressIndeterminate = bl;
        return this;
    }

    public NotificationCompat.Builder setPublicVersion(Notification notification) {
        this.mPublicVersion = notification;
        return this;
    }

    public NotificationCompat.Builder setRemoteInputHistory(CharSequence[] charSequenceArray) {
        this.mRemoteInputHistory = charSequenceArray;
        return this;
    }

    public NotificationCompat.Builder setSettingsText(CharSequence charSequence) {
        this.mSettingsText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat.Builder setShortcutId(String string) {
        this.mShortcutId = string;
        return this;
    }

    public NotificationCompat.Builder setShortcutInfo(ShortcutInfoCompat shortcutInfoCompat) {
        if (shortcutInfoCompat == null) {
            return this;
        }
        this.mShortcutId = shortcutInfoCompat.getId();
        if (this.mLocusId == null) {
            if (shortcutInfoCompat.getLocusId() != null) {
                this.mLocusId = shortcutInfoCompat.getLocusId();
            } else if (shortcutInfoCompat.getId() != null) {
                this.mLocusId = new LocusIdCompat(shortcutInfoCompat.getId());
            }
        }
        if (this.mContentTitle != null) return this;
        this.setContentTitle(shortcutInfoCompat.getShortLabel());
        return this;
    }

    public NotificationCompat.Builder setShowWhen(boolean bl) {
        this.mShowWhen = bl;
        return this;
    }

    public NotificationCompat.Builder setSilent(boolean bl) {
        this.mSilent = bl;
        return this;
    }

    public NotificationCompat.Builder setSmallIcon(int n) {
        this.mNotification.icon = n;
        return this;
    }

    public NotificationCompat.Builder setSmallIcon(int n, int n2) {
        this.mNotification.icon = n;
        this.mNotification.iconLevel = n2;
        return this;
    }

    public NotificationCompat.Builder setSmallIcon(IconCompat iconCompat) {
        this.mSmallIcon = iconCompat.toIcon(this.mContext);
        return this;
    }

    public NotificationCompat.Builder setSortKey(String string) {
        this.mSortKey = string;
        return this;
    }

    public NotificationCompat.Builder setSound(Uri uri) {
        this.mNotification.sound = uri;
        this.mNotification.audioStreamType = -1;
        if (Build.VERSION.SDK_INT < 21) return this;
        this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        return this;
    }

    public NotificationCompat.Builder setSound(Uri uri, int n) {
        this.mNotification.sound = uri;
        this.mNotification.audioStreamType = n;
        if (Build.VERSION.SDK_INT < 21) return this;
        this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(n).build();
        return this;
    }

    public NotificationCompat.Builder setStyle(NotificationCompat.Style style) {
        if (this.mStyle == style) return this;
        this.mStyle = style;
        if (style == null) return this;
        style.setBuilder(this);
        return this;
    }

    public NotificationCompat.Builder setSubText(CharSequence charSequence) {
        this.mSubText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat.Builder setTicker(CharSequence charSequence) {
        this.mNotification.tickerText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    @Deprecated
    public NotificationCompat.Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
        this.mNotification.tickerText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        this.mTickerView = remoteViews;
        return this;
    }

    public NotificationCompat.Builder setTimeoutAfter(long l) {
        this.mTimeout = l;
        return this;
    }

    public NotificationCompat.Builder setUsesChronometer(boolean bl) {
        this.mUseChronometer = bl;
        return this;
    }

    public NotificationCompat.Builder setVibrate(long[] lArray) {
        this.mNotification.vibrate = lArray;
        return this;
    }

    public NotificationCompat.Builder setVisibility(int n) {
        this.mVisibility = n;
        return this;
    }

    public NotificationCompat.Builder setWhen(long l) {
        this.mNotification.when = l;
        return this;
    }
}
