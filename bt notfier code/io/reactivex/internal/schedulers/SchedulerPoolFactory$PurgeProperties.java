/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.schedulers;

import java.util.Properties;

static final class SchedulerPoolFactory.PurgeProperties {
    boolean purgeEnable;
    int purgePeriod;

    SchedulerPoolFactory.PurgeProperties() {
    }

    void load(Properties properties) {
        this.purgeEnable = properties.containsKey("rx2.purge-enabled") ? Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled")) : true;
        if (this.purgeEnable && properties.containsKey("rx2.purge-period-seconds")) {
            try {
                this.purgePeriod = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            }
            catch (NumberFormatException numberFormatException) {
                this.purgePeriod = 1;
            }
        } else {
            this.purgePeriod = 1;
        }
    }
}
