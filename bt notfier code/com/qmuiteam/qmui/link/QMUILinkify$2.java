/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Patterns
 *  com.qmuiteam.qmui.link.QMUILinkify$WebUrlMatcher
 */
package com.qmuiteam.qmui.link;

import android.util.Patterns;
import com.qmuiteam.qmui.link.QMUILinkify;
import java.util.regex.Pattern;

static final class QMUILinkify.2
implements QMUILinkify.WebUrlMatcher {
    QMUILinkify.2() {
    }

    public Pattern getPattern() {
        return Patterns.WEB_URL;
    }
}
