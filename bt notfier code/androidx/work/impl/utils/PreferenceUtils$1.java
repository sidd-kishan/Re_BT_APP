/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.work.impl.utils.PreferenceUtils
 */
package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.work.impl.utils.PreferenceUtils;

class PreferenceUtils.1
implements Function<Long, Long> {
    final PreferenceUtils this$0;

    PreferenceUtils.1(PreferenceUtils preferenceUtils) {
        this.this$0 = preferenceUtils;
    }

    public Long apply(Long l) {
        long l2 = l != null ? l : 0L;
        return l2;
    }
}
