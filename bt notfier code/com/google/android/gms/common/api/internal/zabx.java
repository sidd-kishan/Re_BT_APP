/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.ConnectionTelemetryConfiguration
 *  com.google.android.gms.common.internal.MethodInvocation
 *  com.google.android.gms.common.internal.RootTelemetryConfigManager
 *  com.google.android.gms.common.internal.RootTelemetryConfiguration
 *  com.google.android.gms.common.util.ArrayUtils
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zabx<T>
implements OnCompleteListener<T> {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey<?> zac;
    private final long zad;

    zabx(GoogleApiManager googleApiManager, int n, ApiKey<?> apiKey, long l, String string, String string2) {
        this.zaa = googleApiManager;
        this.zab = n;
        this.zac = apiKey;
        this.zad = l;
    }

    static <T> zabx<T> zaa(GoogleApiManager googleApiManager, int n, ApiKey<?> apiKey) {
        boolean bl;
        if (!googleApiManager.zam()) {
            return null;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = RootTelemetryConfigManager.getInstance().getConfig();
        if (rootTelemetryConfiguration != null) {
            if (!rootTelemetryConfiguration.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            boolean bl2 = rootTelemetryConfiguration.getMethodTimingTelemetryEnabled();
            rootTelemetryConfiguration = googleApiManager.zag(apiKey);
            bl = bl2;
            if (rootTelemetryConfiguration != null) {
                if (!(rootTelemetryConfiguration.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient)rootTelemetryConfiguration.zaf();
                bl = bl2;
                if (baseGmsClient.hasConnectionInfo()) {
                    bl = bl2;
                    if (!baseGmsClient.isConnecting()) {
                        if ((baseGmsClient = zabx.zab(rootTelemetryConfiguration, baseGmsClient, n)) == null) {
                            return null;
                        }
                        rootTelemetryConfiguration.zas();
                        bl = baseGmsClient.getMethodTimingTelemetryEnabled();
                    }
                }
            }
        } else {
            bl = true;
        }
        long l = bl ? System.currentTimeMillis() : 0L;
        return new zabx<T>(googleApiManager, n, apiKey, l, null, null);
    }

    private static ConnectionTelemetryConfiguration zab(zabl<?> zabl2, BaseGmsClient<?> connectionTelemetryConfiguration, int n) {
        if ((connectionTelemetryConfiguration = connectionTelemetryConfiguration.getTelemetryConfiguration()) == null) return null;
        if (!connectionTelemetryConfiguration.getMethodInvocationTelemetryEnabled()) return null;
        int[] nArray = connectionTelemetryConfiguration.getMethodInvocationMethodKeyAllowlist();
        if (nArray == null ? (nArray = connectionTelemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) != null && ArrayUtils.contains((int[])nArray, (int)n) : !ArrayUtils.contains((int[])nArray, (int)n)) return null;
        if (zabl2.zar() >= connectionTelemetryConfiguration.getMaxMethodInvocationsLogged()) return null;
        return connectionTelemetryConfiguration;
    }

    /*
     * Unable to fully structure code
     */
    public final void onComplete(Task<T> var1_1) {
        block12: {
            block13: {
                block11: {
                    if (!this.zaa.zam()) {
                        return;
                    }
                    var14_2 = RootTelemetryConfigManager.getInstance().getConfig();
                    if (var14_2 != null) {
                        if (var14_2.getMethodInvocationTelemetryEnabled() == false) return;
                    }
                    if ((var15_3 = this.zaa.zag(this.zac)) == null) return;
                    if (!(var15_3.zaf() instanceof BaseGmsClient)) return;
                    var16_4 = (BaseGmsClient)var15_3.zaf();
                    var10_5 = this.zad;
                    var5_6 = 1;
                    var2_7 = var10_5 > 0L ? 1 : 0;
                    var9_8 = var16_4.getGCoreServiceId();
                    if (var14_2 != null) {
                        var6_9 = var2_7 & var14_2.getMethodTimingTelemetryEnabled();
                        var4_10 = var14_2.getBatchPeriodMillis();
                        var8_11 = var14_2.getMaxMethodInvocationsInBatch();
                        var7_12 = var14_2.getVersion();
                        var2_7 = var6_9;
                        var3_13 = var8_11;
                        if (var16_4.hasConnectionInfo()) {
                            var2_7 = var6_9;
                            var3_13 = var8_11;
                            if (!var16_4.isConnecting()) {
                                var14_2 = zabx.zab(var15_3, var16_4, this.zab);
                                if (var14_2 == null) {
                                    return;
                                }
                                var2_7 = var14_2.getMethodTimingTelemetryEnabled() != false && this.zad > 0L ? var5_6 : 0;
                                var3_13 = var14_2.getMaxMethodInvocationsLogged();
                            }
                        }
                        var6_9 = var3_13;
                        var5_6 = var2_7;
                    } else {
                        var7_12 = 0;
                        var4_10 = 5000;
                        var6_9 = 100;
                        var5_6 = var2_7;
                    }
                    var14_2 = this.zaa;
                    if (!var1_1 /* !! */ .isSuccessful()) break block11;
                    var2_7 = 0;
                    var3_13 = 0;
                    break block12;
                }
                if (!var1_1 /* !! */ .isCanceled()) break block13;
                var2_7 = 100;
                ** GOTO lbl54
            }
            if ((var1_1 /* !! */  = var1_1 /* !! */ .getException()) instanceof ApiException) {
                var1_1 /* !! */  = ((ApiException)var1_1 /* !! */ ).getStatus();
                var8_11 = var1_1 /* !! */ .getStatusCode();
                var2_7 = (var1_1 /* !! */  = var1_1 /* !! */ .getConnectionResult()) == null ? -1 : var1_1 /* !! */ .getErrorCode();
                var3_13 = var2_7;
                var2_7 = var8_11;
            } else {
                var2_7 = 101;
lbl54:
                // 2 sources

                var3_13 = -1;
            }
        }
        if (var5_6 != 0) {
            var12_14 = this.zad;
            var10_5 = System.currentTimeMillis();
        } else {
            var12_14 = 0L;
            var10_5 = 0L;
        }
        var14_2.zar(new MethodInvocation(this.zab, var2_7, var3_13, var12_14, var10_5, null, null, var9_8), var7_12, (long)var4_10, var6_9);
    }
}
