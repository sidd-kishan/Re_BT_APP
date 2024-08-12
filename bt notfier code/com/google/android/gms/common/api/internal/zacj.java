/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.concurrent.NumberedThreadFactory
 *  com.google.android.gms.internal.base.zao
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zao;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public final class zacj {
    private static final ExecutorService zaa = zao.zaa().zac((ThreadFactory)new NumberedThreadFactory("GAC_Transform"), 1);

    public static ExecutorService zaa() {
        return zaa;
    }
}
