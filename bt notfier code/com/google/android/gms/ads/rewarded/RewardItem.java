/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.rewarded.zza
 */
package com.google.android.gms.ads.rewarded;

import com.google.android.gms.ads.rewarded.zza;

public interface RewardItem {
    public static final RewardItem DEFAULT_REWARD = new zza();

    public int getAmount();

    public String getType();
}
