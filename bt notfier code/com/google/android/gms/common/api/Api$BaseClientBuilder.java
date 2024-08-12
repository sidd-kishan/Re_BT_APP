/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Scope
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.List;

public static abstract class Api.BaseClientBuilder<T extends Api.AnyClient, O> {
    public static final int API_PRIORITY_GAMES = 1;
    public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
    public static final int API_PRIORITY_PLUS = 2;

    public List<Scope> getImpliedScopes(O o) {
        return Collections.emptyList();
    }

    public int getPriority() {
        return Integer.MAX_VALUE;
    }
}
