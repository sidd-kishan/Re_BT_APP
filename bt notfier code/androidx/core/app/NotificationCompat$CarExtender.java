/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.app.RemoteInput
 *  android.app.RemoteInput$Builder
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$CarExtender$UnreadConversation
 *  androidx.core.app.NotificationCompat$Extender
 *  androidx.core.app.RemoteInput
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class NotificationCompat.CarExtender
implements NotificationCompat.Extender {
    static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";
    static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";
    private int mColor = 0;
    private Bitmap mLargeIcon;
    private UnreadConversation mUnreadConversation;

    public NotificationCompat.CarExtender() {
    }

    public NotificationCompat.CarExtender(Notification object) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        object = NotificationCompat.getExtras((Notification)object) == null ? null : NotificationCompat.getExtras((Notification)object).getBundle("android.car.EXTENSIONS");
        if (object == null) return;
        this.mLargeIcon = (Bitmap)object.getParcelable("large_icon");
        this.mColor = object.getInt("app_color", 0);
        this.mUnreadConversation = NotificationCompat.CarExtender.getUnreadConversationFromBundle(object.getBundle("car_conversation"));
    }

    private static Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
        Bundle bundle = new Bundle();
        Object object = unreadConversation.getParticipants();
        object = object != null && unreadConversation.getParticipants().length > 1 ? unreadConversation.getParticipants()[0] : null;
        int n = unreadConversation.getMessages().length;
        Parcelable[] parcelableArray = new Parcelable[n];
        for (int i = 0; i < n; ++i) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("text", unreadConversation.getMessages()[i]);
            bundle2.putString("author", (String)object);
            parcelableArray[i] = bundle2;
        }
        bundle.putParcelableArray("messages", parcelableArray);
        object = unreadConversation.getRemoteInput();
        if (object != null) {
            bundle.putParcelable("remote_input", (Parcelable)new RemoteInput.Builder(object.getResultKey()).setLabel(object.getLabel()).setChoices(object.getChoices()).setAllowFreeFormInput(object.getAllowFreeFormInput()).addExtras(object.getExtras()).build());
        }
        bundle.putParcelable("on_reply", (Parcelable)unreadConversation.getReplyPendingIntent());
        bundle.putParcelable("on_read", (Parcelable)unreadConversation.getReadPendingIntent());
        bundle.putStringArray("participants", unreadConversation.getParticipants());
        bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
        return bundle;
    }

    private static UnreadConversation getUnreadConversationFromBundle(Bundle bundle) {
        int n;
        String[] stringArray;
        CharSequence[] charSequenceArray = null;
        String string = null;
        if (bundle == null) {
            return null;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("messages");
        if (parcelableArray == null) {
            stringArray = null;
        } else {
            block8: {
                int n2 = parcelableArray.length;
                stringArray = new String[n2];
                for (n = 0; n < n2; ++n) {
                    if (parcelableArray[n] instanceof Bundle) {
                        stringArray[n] = ((Bundle)parcelableArray[n]).getString("text");
                        if (stringArray[n] != null) continue;
                    }
                    n = 0;
                    break block8;
                }
                n = 1;
            }
            if (n == 0) return null;
        }
        PendingIntent pendingIntent = (PendingIntent)bundle.getParcelable("on_read");
        PendingIntent pendingIntent2 = (PendingIntent)bundle.getParcelable("on_reply");
        android.app.RemoteInput remoteInput = (android.app.RemoteInput)bundle.getParcelable("remote_input");
        String[] stringArray2 = bundle.getStringArray("participants");
        parcelableArray = charSequenceArray;
        if (stringArray2 == null) return parcelableArray;
        if (stringArray2.length != 1) {
            parcelableArray = charSequenceArray;
        } else {
            parcelableArray = string;
            if (remoteInput != null) {
                string = remoteInput.getResultKey();
                parcelableArray = remoteInput.getLabel();
                charSequenceArray = remoteInput.getChoices();
                boolean bl = remoteInput.getAllowFreeFormInput();
                n = Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0;
                parcelableArray = new RemoteInput(string, (CharSequence)parcelableArray, charSequenceArray, bl, n, remoteInput.getExtras(), null);
            }
            parcelableArray = new UnreadConversation(stringArray, (RemoteInput)parcelableArray, pendingIntent2, pendingIntent, stringArray2, bundle.getLong("timestamp"));
        }
        return parcelableArray;
    }

    public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
        int n;
        if (Build.VERSION.SDK_INT < 21) {
            return builder;
        }
        Bundle bundle = new Bundle();
        Bitmap bitmap = this.mLargeIcon;
        if (bitmap != null) {
            bundle.putParcelable("large_icon", (Parcelable)bitmap);
        }
        if ((n = this.mColor) != 0) {
            bundle.putInt("app_color", n);
        }
        if ((bitmap = this.mUnreadConversation) != null) {
            bundle.putBundle("car_conversation", NotificationCompat.CarExtender.getBundleForUnreadConversation((UnreadConversation)bitmap));
        }
        builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
        return builder;
    }

    public int getColor() {
        return this.mColor;
    }

    public Bitmap getLargeIcon() {
        return this.mLargeIcon;
    }

    @Deprecated
    public UnreadConversation getUnreadConversation() {
        return this.mUnreadConversation;
    }

    public NotificationCompat.CarExtender setColor(int n) {
        this.mColor = n;
        return this;
    }

    public NotificationCompat.CarExtender setLargeIcon(Bitmap bitmap) {
        this.mLargeIcon = bitmap;
        return this;
    }

    @Deprecated
    public NotificationCompat.CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
        this.mUnreadConversation = unreadConversation;
        return this;
    }
}
