/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.link.QMUILinkify$MatchFilter
 */
package com.qmuiteam.qmui.link;

import com.qmuiteam.qmui.link.QMUILinkify;

static final class QMUILinkify.4
implements QMUILinkify.MatchFilter {
    QMUILinkify.4() {
    }

    public final boolean acceptMatch(CharSequence charSequence, int n, int n2) {
        int n3 = 0;
        int n4 = n;
        while (n4 < n2) {
            n = n3++;
            if (Character.isDigit(charSequence.charAt(n4))) {
                n = n3;
                if (n3 >= 7) {
                    return true;
                }
            }
            ++n4;
            n3 = n;
        }
        return false;
    }
}
