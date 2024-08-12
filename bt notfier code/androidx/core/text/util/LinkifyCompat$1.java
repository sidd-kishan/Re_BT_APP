/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.util.LinkifyCompat$LinkSpec
 */
package androidx.core.text.util;

import androidx.core.text.util.LinkifyCompat;
import java.util.Comparator;

class LinkifyCompat.1
implements Comparator<LinkifyCompat.LinkSpec> {
    LinkifyCompat.1() {
    }

    @Override
    public int compare(LinkifyCompat.LinkSpec linkSpec, LinkifyCompat.LinkSpec linkSpec2) {
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
