/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigTextStyle
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Style
 */
package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static class NotificationCompat.BigTextStyle
extends NotificationCompat.Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
    private CharSequence mBigText;

    public NotificationCompat.BigTextStyle() {
    }

    public NotificationCompat.BigTextStyle(NotificationCompat.Builder builder) {
        this.setBuilder(builder);
    }

    public void addCompatExtras(Bundle bundle) {
        super.addCompatExtras(bundle);
        if (Build.VERSION.SDK_INT >= 21) return;
        bundle.putCharSequence("android.bigText", this.mBigText);
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT < 16) return;
        notificationBuilderWithBuilderAccessor = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
        if (!this.mSummaryTextSet) return;
        notificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
    }

    public NotificationCompat.BigTextStyle bigText(CharSequence charSequence) {
        this.mBigText = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        return this;
    }

    protected void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.bigText");
    }

    protected String getClassName() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }

    protected void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        this.mBigText = bundle.getCharSequence("android.bigText");
    }

    public NotificationCompat.BigTextStyle setBigContentTitle(CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        return this;
    }

    public NotificationCompat.BigTextStyle setSummaryText(CharSequence charSequence) {
        this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}
