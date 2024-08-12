/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Build$VERSION
 */
package androidx.core.content;

import android.content.Intent;
import android.os.Build;

public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    private IntentCompat() {
    }

    public static Intent makeMainSelectorActivity(String string, String string2) {
        if (Build.VERSION.SDK_INT >= 15) {
            return Intent.makeMainSelectorActivity((String)string, (String)string2);
        }
        string = new Intent(string);
        string.addCategory(string2);
        return string;
    }
}
