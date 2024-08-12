/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$NotFoundException
 */
package androidx.appcompat.app;

import android.content.res.Resources;

class AppCompatDelegateImpl.1
implements Thread.UncaughtExceptionHandler {
    final Thread.UncaughtExceptionHandler val$defHandler;

    AppCompatDelegateImpl.1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.val$defHandler = uncaughtExceptionHandler;
    }

    private boolean shouldWrapException(Throwable object) {
        boolean bl;
        boolean bl2 = object instanceof Resources.NotFoundException;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = ((Throwable)object).getMessage();
        bl3 = bl;
        if (object == null) return bl3;
        if (!((String)object).contains("drawable")) {
            bl3 = bl;
            if (!((String)object).contains("Drawable")) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (this.shouldWrapException(throwable)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(throwable.getMessage());
            stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            stringBuilder = new Resources.NotFoundException(stringBuilder.toString());
            ((Throwable)((Object)stringBuilder)).initCause(throwable.getCause());
            ((Throwable)((Object)stringBuilder)).setStackTrace(throwable.getStackTrace());
            this.val$defHandler.uncaughtException(thread, (Throwable)((Object)stringBuilder));
        } else {
            this.val$defHandler.uncaughtException(thread, throwable);
        }
    }
}
