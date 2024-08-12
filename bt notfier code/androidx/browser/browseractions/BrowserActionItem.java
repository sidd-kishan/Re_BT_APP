/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 */
package androidx.browser.browseractions;

import android.app.PendingIntent;

public class BrowserActionItem {
    private final PendingIntent mAction;
    private final int mIconId;
    private final String mTitle;

    public BrowserActionItem(String string, PendingIntent pendingIntent) {
        this(string, pendingIntent, 0);
    }

    public BrowserActionItem(String string, PendingIntent pendingIntent, int n) {
        this.mTitle = string;
        this.mAction = pendingIntent;
        this.mIconId = n;
    }

    public PendingIntent getAction() {
        return this.mAction;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public String getTitle() {
        return this.mTitle;
    }
}
