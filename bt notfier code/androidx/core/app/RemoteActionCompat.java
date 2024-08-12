/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.RemoteAction
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  androidx.core.graphics.drawable.IconCompat
 *  androidx.core.util.Preconditions
 *  androidx.versionedparcelable.VersionedParcelable
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat
implements VersionedParcelable {
    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    public RemoteActionCompat() {
    }

    public RemoteActionCompat(RemoteActionCompat remoteActionCompat) {
        Preconditions.checkNotNull((Object)remoteActionCompat);
        this.mIcon = remoteActionCompat.mIcon;
        this.mTitle = remoteActionCompat.mTitle;
        this.mContentDescription = remoteActionCompat.mContentDescription;
        this.mActionIntent = remoteActionCompat.mActionIntent;
        this.mEnabled = remoteActionCompat.mEnabled;
        this.mShouldShowIcon = remoteActionCompat.mShouldShowIcon;
    }

    public RemoteActionCompat(IconCompat iconCompat, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        this.mIcon = (IconCompat)Preconditions.checkNotNull((Object)iconCompat);
        this.mTitle = (CharSequence)Preconditions.checkNotNull((Object)charSequence);
        this.mContentDescription = (CharSequence)Preconditions.checkNotNull((Object)charSequence2);
        this.mActionIntent = (PendingIntent)Preconditions.checkNotNull((Object)pendingIntent);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    public static RemoteActionCompat createFromRemoteAction(RemoteAction remoteAction) {
        Preconditions.checkNotNull((Object)remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon((Icon)remoteAction.getIcon()), remoteAction.getTitle(), remoteAction.getContentDescription(), remoteAction.getActionIntent());
        remoteActionCompat.setEnabled(remoteAction.isEnabled());
        if (Build.VERSION.SDK_INT < 28) return remoteActionCompat;
        remoteActionCompat.setShouldShowIcon(remoteAction.shouldShowIcon());
        return remoteActionCompat;
    }

    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean bl) {
        this.mEnabled = bl;
    }

    public void setShouldShowIcon(boolean bl) {
        this.mShouldShowIcon = bl;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    public RemoteAction toRemoteAction() {
        RemoteAction remoteAction = new RemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        remoteAction.setEnabled(this.isEnabled());
        if (Build.VERSION.SDK_INT < 28) return remoteAction;
        remoteAction.setShouldShowIcon(this.shouldShowIcon());
        return remoteAction;
    }
}
