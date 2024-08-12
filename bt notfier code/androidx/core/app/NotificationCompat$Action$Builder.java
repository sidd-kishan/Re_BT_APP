/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Action
 *  android.app.PendingIntent
 *  android.app.RemoteInput
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.core.app.NotificationCompat$Action
 *  androidx.core.app.NotificationCompat$Action$Extender
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.RemoteInput
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class NotificationCompat.Action.Builder {
    private boolean mAllowGeneratedReplies;
    private final Bundle mExtras;
    private final IconCompat mIcon;
    private final PendingIntent mIntent;
    private boolean mIsContextual;
    private ArrayList<RemoteInput> mRemoteInputs;
    private int mSemanticAction;
    private boolean mShowsUserInterface;
    private final CharSequence mTitle;

    public NotificationCompat.Action.Builder(int n, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat iconCompat = null;
        if (n != 0) {
            iconCompat = IconCompat.createWithResource(null, (String)"", (int)n);
        }
        this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
    }

    public NotificationCompat.Action.Builder(NotificationCompat.Action action) {
        this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface, action.isContextual());
    }

    public NotificationCompat.Action.Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
    }

    private NotificationCompat.Action.Builder(IconCompat object, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, boolean bl, int n, boolean bl2, boolean bl3) {
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
        this.mIcon = object;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        this.mIntent = pendingIntent;
        this.mExtras = bundle;
        object = remoteInputArray == null ? null : new ArrayList<RemoteInput>(Arrays.asList(remoteInputArray));
        this.mRemoteInputs = object;
        this.mAllowGeneratedReplies = bl;
        this.mSemanticAction = n;
        this.mShowsUserInterface = bl2;
        this.mIsContextual = bl3;
    }

    private void checkContextualActionNullFields() {
        if (!this.mIsContextual) {
            return;
        }
        if (this.mIntent == null) throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
    }

    public static NotificationCompat.Action.Builder fromAndroidAction(Notification.Action action) {
        android.app.RemoteInput[] remoteInputArray;
        NotificationCompat.Action.Builder builder = Build.VERSION.SDK_INT >= 23 && action.getIcon() != null ? new NotificationCompat.Action.Builder(IconCompat.createFromIcon((Icon)action.getIcon()), action.title, action.actionIntent) : new NotificationCompat.Action.Builder(action.icon, action.title, action.actionIntent);
        if (Build.VERSION.SDK_INT >= 20 && (remoteInputArray = action.getRemoteInputs()) != null && remoteInputArray.length != 0) {
            int n = remoteInputArray.length;
            for (int i = 0; i < n; ++i) {
                builder.addRemoteInput(RemoteInput.fromPlatform((android.app.RemoteInput)remoteInputArray[i]));
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            builder.mAllowGeneratedReplies = action.getAllowGeneratedReplies();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(action.getSemanticAction());
        }
        if (Build.VERSION.SDK_INT < 29) return builder;
        builder.setContextual(action.isContextual());
        return builder;
    }

    public NotificationCompat.Action.Builder addExtras(Bundle bundle) {
        if (bundle == null) return this;
        this.mExtras.putAll(bundle);
        return this;
    }

    public NotificationCompat.Action.Builder addRemoteInput(RemoteInput remoteInput) {
        if (this.mRemoteInputs == null) {
            this.mRemoteInputs = new ArrayList();
        }
        if (remoteInput == null) return this;
        this.mRemoteInputs.add(remoteInput);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public NotificationCompat.Action build() {
        void var3_8;
        this.checkContextualActionNullFields();
        Object object = new ArrayList();
        ArrayList<RemoteInput> arrayList = new ArrayList<RemoteInput>();
        ArrayList<RemoteInput> remoteInputArray2 = this.mRemoteInputs;
        if (remoteInputArray2 != null) {
            for (RemoteInput remoteInput : remoteInputArray2) {
                if (remoteInput.isDataOnly()) {
                    object.add(remoteInput);
                    continue;
                }
                arrayList.add(remoteInput);
            }
        }
        boolean bl = object.isEmpty();
        Object var3_6 = null;
        object = bl ? null : object.toArray(new RemoteInput[object.size()]);
        if (arrayList.isEmpty()) return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, (RemoteInput[])var3_8, object, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
        RemoteInput[] remoteInputArray = arrayList.toArray(new RemoteInput[arrayList.size()]);
        return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, (RemoteInput[])var3_8, object, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
    }

    public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Extender extender) {
        extender.extend(this);
        return this;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public NotificationCompat.Action.Builder setAllowGeneratedReplies(boolean bl) {
        this.mAllowGeneratedReplies = bl;
        return this;
    }

    public NotificationCompat.Action.Builder setContextual(boolean bl) {
        this.mIsContextual = bl;
        return this;
    }

    public NotificationCompat.Action.Builder setSemanticAction(int n) {
        this.mSemanticAction = n;
        return this;
    }

    public NotificationCompat.Action.Builder setShowsUserInterface(boolean bl) {
        this.mShowsUserInterface = bl;
        return this;
    }
}
