/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.Logger
 */
package org.greenrobot.eventbus;

import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

public static class Logger.JavaLogger
implements Logger {
    protected final java.util.logging.Logger logger;

    public Logger.JavaLogger(String string) {
        this.logger = java.util.logging.Logger.getLogger(string);
    }

    public void log(Level level, String string) {
        this.logger.log(level, string);
    }

    public void log(Level level, String string, Throwable throwable) {
        this.logger.log(level, string, throwable);
    }
}
