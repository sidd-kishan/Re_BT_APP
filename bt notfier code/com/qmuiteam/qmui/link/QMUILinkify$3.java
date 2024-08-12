/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.link.QMUILinkify$MatchFilter
 */
package com.qmuiteam.qmui.link;

import com.qmuiteam.qmui.link.QMUILinkify;

static final class QMUILinkify.3
implements QMUILinkify.MatchFilter {
    QMUILinkify.3() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean acceptMatch(CharSequence charSequence, int n, int n2) {
        for (int i = n; i < n2; ++i) {
            char c = charSequence.charAt(i);
            if (c <= '\u0100') continue;
            return false;
        }
        try {
            boolean bl;
            char c = charSequence.charAt(n2);
            if (c < '\u0100' && "[$]".indexOf(c) < 0 && !(bl = Character.isWhitespace(c))) {
                return false;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (n == 0) {
            return true;
        }
        try {
            n = charSequence.charAt(n - 1);
            if (n != 64) return true;
            return false;
        }
        catch (Exception exception) {
            return true;
        }
    }
}
