/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.haibin.calendarview.R$array
 */
package com.haibin.calendarview;

import android.content.Context;
import com.haibin.calendarview.R;

public final class TrunkBranchAnnals {
    private static String[] BRANCH_STR;
    private static String[] TRUNK_STR;

    public static int getBranchInt(int n) {
        n = (n %= 12) == 0 ? 11 : --n;
        return n;
    }

    public static String getBranchString(int n) {
        return BRANCH_STR[TrunkBranchAnnals.getBranchInt(n)];
    }

    public static String getTrunkBranchYear(int n) {
        return String.format("%s%s", TrunkBranchAnnals.getTrunkString(n), TrunkBranchAnnals.getBranchString(n));
    }

    public static int getTrunkInt(int n) {
        n = (n %= 10) == 0 ? 9 : --n;
        return n;
    }

    public static String getTrunkString(int n) {
        return TRUNK_STR[TrunkBranchAnnals.getTrunkInt(n)];
    }

    public static void init(Context context) {
        if (TRUNK_STR != null) {
            return;
        }
        TRUNK_STR = context.getResources().getStringArray(R.array.trunk_string_array);
        BRANCH_STR = context.getResources().getStringArray(R.array.branch_string_array);
    }
}
