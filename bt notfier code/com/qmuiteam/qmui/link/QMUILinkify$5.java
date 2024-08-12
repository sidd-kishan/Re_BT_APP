/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Patterns
 *  com.qmuiteam.qmui.link.QMUILinkify$TransformFilter
 */
package com.qmuiteam.qmui.link;

import android.util.Patterns;
import com.qmuiteam.qmui.link.QMUILinkify;
import java.util.regex.Matcher;

static final class QMUILinkify.5
implements QMUILinkify.TransformFilter {
    QMUILinkify.5() {
    }

    public final String transformUrl(Matcher matcher, String string) {
        return Patterns.digitsAndPlusOnly((Matcher)matcher);
    }
}
