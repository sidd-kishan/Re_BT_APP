/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.R$anim
 */
package com.bigkoo.pickerview.utils;

import com.bigkoo.pickerview.R;

public class PickerViewAnimateUtil {
    private static final int INVALID = -1;

    public static int getAnimationResource(int n, boolean bl) {
        if (n != 80) {
            return -1;
        }
        n = bl ? R.anim.pickerview_slide_in_bottom : R.anim.pickerview_slide_out_bottom;
        return n;
    }
}
