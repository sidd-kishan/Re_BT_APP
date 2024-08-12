/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigPictureStyle
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat$BigPictureStyle$Api16Impl
 *  androidx.core.app.NotificationCompat$BigPictureStyle$Api23Impl
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.core.app.NotificationCompatBuilder
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatBuilder;
import androidx.core.graphics.drawable.IconCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static class NotificationCompat.BigPictureStyle
extends NotificationCompat.Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
    private IconCompat mBigLargeIcon;
    private boolean mBigLargeIconSet;
    private Bitmap mPicture;

    public NotificationCompat.BigPictureStyle() {
    }

    public NotificationCompat.BigPictureStyle(NotificationCompat.Builder builder) {
        this.setBuilder(builder);
    }

    private static IconCompat asIconCompat(Parcelable parcelable) {
        if (parcelable == null) return null;
        if (Build.VERSION.SDK_INT >= 23 && parcelable instanceof Icon) {
            return IconCompat.createFromIcon((Icon)((Icon)parcelable));
        }
        if (!(parcelable instanceof Bitmap)) return null;
        return IconCompat.createWithBitmap((Bitmap)((Bitmap)parcelable));
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT < 16) return;
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
        if (this.mBigLargeIconSet) {
            IconCompat iconCompat = this.mBigLargeIcon;
            Context context = null;
            if (iconCompat == null) {
                Api16Impl.setBigLargeIcon((Notification.BigPictureStyle)bigPictureStyle, null);
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                    context = ((NotificationCompatBuilder)notificationBuilderWithBuilderAccessor).getContext();
                }
                Api23Impl.setBigLargeIcon((Notification.BigPictureStyle)bigPictureStyle, (Icon)this.mBigLargeIcon.toIcon(context));
            } else if (this.mBigLargeIcon.getType() == 1) {
                Api16Impl.setBigLargeIcon((Notification.BigPictureStyle)bigPictureStyle, (Bitmap)this.mBigLargeIcon.getBitmap());
            } else {
                Api16Impl.setBigLargeIcon((Notification.BigPictureStyle)bigPictureStyle, null);
            }
        }
        if (!this.mSummaryTextSet) return;
        Api16Impl.setSummaryText((Notification.BigPictureStyle)bigPictureStyle, (CharSequence)this.mSummaryText);
    }

    public NotificationCompat.BigPictureStyle bigLargeIcon(Bitmap object) {
        object = object == null ? null : IconCompat.createWithBitmap((Bitmap)object);
        this.mBigLargeIcon = object;
        this.mBigLargeIconSet = true;
        return this;
    }

    public NotificationCompat.BigPictureStyle bigPicture(Bitmap bitmap) {
        this.mPicture = bitmap;
        return this;
    }

    protected void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.largeIcon.big");
        bundle.remove("android.picture");
    }

    protected String getClassName() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    protected void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        if (bundle.containsKey("android.largeIcon.big")) {
            this.mBigLargeIcon = NotificationCompat.BigPictureStyle.asIconCompat(bundle.getParcelable("android.largeIcon.big"));
            this.mBigLargeIconSet = true;
        }
        this.mPicture = (Bitmap)bundle.getParcelable("android.picture");
    }

    public NotificationCompat.BigPictureStyle setBigContentTitle(CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        return this;
    }

    public NotificationCompat.BigPictureStyle setSummaryText(CharSequence charSequence) {
        this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}
