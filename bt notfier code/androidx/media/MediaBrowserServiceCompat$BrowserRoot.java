/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;

public static final class MediaBrowserServiceCompat.BrowserRoot {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    @Deprecated
    public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
    private final Bundle mExtras;
    private final String mRootId;

    public MediaBrowserServiceCompat.BrowserRoot(String string, Bundle bundle) {
        if (string == null) throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        this.mRootId = string;
        this.mExtras = bundle;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getRootId() {
        return this.mRootId;
    }
}
