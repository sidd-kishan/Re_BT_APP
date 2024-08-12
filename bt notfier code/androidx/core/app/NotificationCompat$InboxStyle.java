/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$InboxStyle
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
import java.util.ArrayList;
import java.util.Collections;

/*
 * Exception performing whole class analysis ignored.
 */
public static class NotificationCompat.InboxStyle
extends NotificationCompat.Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
    private ArrayList<CharSequence> mTexts = new ArrayList();

    public NotificationCompat.InboxStyle() {
    }

    public NotificationCompat.InboxStyle(NotificationCompat.Builder builder) {
        this.setBuilder(builder);
    }

    public NotificationCompat.InboxStyle addLine(CharSequence charSequence) {
        if (charSequence == null) return this;
        this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence));
        return this;
    }

    public void apply(NotificationBuilderWithBuilderAccessor object) {
        if (Build.VERSION.SDK_INT < 16) return;
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle(object.getBuilder()).setBigContentTitle(this.mBigContentTitle);
        if (this.mSummaryTextSet) {
            inboxStyle.setSummaryText(this.mSummaryText);
        }
        object = this.mTexts.iterator();
        while (object.hasNext()) {
            inboxStyle.addLine((CharSequence)object.next());
        }
    }

    protected void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.textLines");
    }

    protected String getClassName() {
        return "androidx.core.app.NotificationCompat$InboxStyle";
    }

    protected void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        this.mTexts.clear();
        if (!bundle.containsKey("android.textLines")) return;
        Collections.addAll(this.mTexts, bundle.getCharSequenceArray("android.textLines"));
    }

    public NotificationCompat.InboxStyle setBigContentTitle(CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        return this;
    }

    public NotificationCompat.InboxStyle setSummaryText(CharSequence charSequence) {
        this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength((CharSequence)charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}
