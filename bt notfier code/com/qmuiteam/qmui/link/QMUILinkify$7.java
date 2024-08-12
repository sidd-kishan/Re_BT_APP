/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.link.QMUILinkify$LinkSpec
 */
package com.qmuiteam.qmui.link;

import com.qmuiteam.qmui.link.QMUILinkify;
import java.util.Comparator;

static final class QMUILinkify.7
implements Comparator<QMUILinkify.LinkSpec> {
    QMUILinkify.7() {
    }

    @Override
    public final int compare(QMUILinkify.LinkSpec linkSpec, QMUILinkify.LinkSpec linkSpec2) {
        if (linkSpec.start < linkSpec2.start) {
            return -1;
        }
        if (linkSpec.start > linkSpec2.start) {
            return 1;
        }
        if (linkSpec.end < linkSpec2.end) {
            return 1;
        }
        if (linkSpec.end <= linkSpec2.end) return 0;
        return -1;
    }
}
