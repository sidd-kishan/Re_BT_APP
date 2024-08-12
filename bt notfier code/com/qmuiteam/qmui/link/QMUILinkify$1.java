/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.link.QMUILinkify$WebUrlMatcher
 *  com.qmuiteam.qmui.link.QMUILinkify$WebUrlPattern
 */
package com.qmuiteam.qmui.link;

import com.qmuiteam.qmui.link.QMUILinkify;
import java.util.regex.Pattern;

/*
 * Exception performing whole class analysis ignored.
 */
static final class QMUILinkify.1
implements QMUILinkify.WebUrlMatcher {
    QMUILinkify.1() {
    }

    public Pattern getPattern() {
        return QMUILinkify.WebUrlPattern.access$000();
    }
}
