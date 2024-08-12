/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.app.NotificationChannelGroupCompat
 */
package androidx.core.app;

import androidx.core.app.NotificationChannelGroupCompat;

public static class NotificationChannelGroupCompat.Builder {
    final NotificationChannelGroupCompat mGroup;

    public NotificationChannelGroupCompat.Builder(String string) {
        this.mGroup = new NotificationChannelGroupCompat(string);
    }

    public NotificationChannelGroupCompat build() {
        return this.mGroup;
    }

    public NotificationChannelGroupCompat.Builder setDescription(String string) {
        this.mGroup.mDescription = string;
        return this;
    }

    public NotificationChannelGroupCompat.Builder setName(CharSequence charSequence) {
        this.mGroup.mName = charSequence;
        return this;
    }
}
