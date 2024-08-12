/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.RemoteInput
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static class NotificationCompat.Action {
    static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
    static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
    public static final int SEMANTIC_ACTION_ARCHIVE = 5;
    public static final int SEMANTIC_ACTION_CALL = 10;
    public static final int SEMANTIC_ACTION_DELETE = 4;
    public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
    public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
    public static final int SEMANTIC_ACTION_MUTE = 6;
    public static final int SEMANTIC_ACTION_NONE = 0;
    public static final int SEMANTIC_ACTION_REPLY = 1;
    public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
    public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
    public static final int SEMANTIC_ACTION_UNMUTE = 7;
    public PendingIntent actionIntent;
    @Deprecated
    public int icon;
    private boolean mAllowGeneratedReplies;
    private final RemoteInput[] mDataOnlyRemoteInputs;
    final Bundle mExtras;
    private IconCompat mIcon;
    private final boolean mIsContextual;
    private final RemoteInput[] mRemoteInputs;
    private final int mSemanticAction;
    boolean mShowsUserInterface;
    public CharSequence title;

    public NotificationCompat.Action(int n, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat iconCompat = null;
        if (n != 0) {
            iconCompat = IconCompat.createWithResource(null, (String)"", (int)n);
        }
        this(iconCompat, charSequence, pendingIntent);
    }

    NotificationCompat.Action(int n, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, RemoteInput[] remoteInputArray2, boolean bl, int n2, boolean bl2, boolean bl3) {
        IconCompat iconCompat = null;
        if (n != 0) {
            iconCompat = IconCompat.createWithResource(null, (String)"", (int)n);
        }
        this(iconCompat, charSequence, pendingIntent, bundle, remoteInputArray, remoteInputArray2, bl, n2, bl2, bl3);
    }

    public NotificationCompat.Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
    }

    NotificationCompat.Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, RemoteInput[] remoteInputArray2, boolean bl, int n, boolean bl2, boolean bl3) {
        this.mShowsUserInterface = true;
        this.mIcon = iconCompat;
        if (iconCompat != null && iconCompat.getType() == 2) {
            this.icon = iconCompat.getResId();
        }
        this.title = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        this.actionIntent = pendingIntent;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.mExtras = bundle;
        this.mRemoteInputs = remoteInputArray;
        this.mDataOnlyRemoteInputs = remoteInputArray2;
        this.mAllowGeneratedReplies = bl;
        this.mSemanticAction = n;
        this.mShowsUserInterface = bl2;
        this.mIsContextual = bl3;
    }

    public PendingIntent getActionIntent() {
        return this.actionIntent;
    }

    public boolean getAllowGeneratedReplies() {
        return this.mAllowGeneratedReplies;
    }

    public RemoteInput[] getDataOnlyRemoteInputs() {
        return this.mDataOnlyRemoteInputs;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    @Deprecated
    public int getIcon() {
        return this.icon;
    }

    public IconCompat getIconCompat() {
        if (this.mIcon != null) return this.mIcon;
        int n = this.icon;
        if (n == 0) return this.mIcon;
        this.mIcon = IconCompat.createWithResource(null, (String)"", (int)n);
        return this.mIcon;
    }

    public RemoteInput[] getRemoteInputs() {
        return this.mRemoteInputs;
    }

    public int getSemanticAction() {
        return this.mSemanticAction;
    }

    public boolean getShowsUserInterface() {
        return this.mShowsUserInterface;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public boolean isContextual() {
        return this.mIsContextual;
    }
}
