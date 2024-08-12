/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.InflateException
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 */
package androidx.appcompat.view;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;

private static class SupportMenuInflater.InflatedOnMenuItemClickListener
implements MenuItem.OnMenuItemClickListener {
    private static final Class<?>[] PARAM_TYPES = new Class[]{MenuItem.class};
    private Method mMethod;
    private Object mRealOwner;

    public SupportMenuInflater.InflatedOnMenuItemClickListener(Object object, String string) {
        this.mRealOwner = object;
        Class<?> clazz = object.getClass();
        try {
            this.mMethod = clazz.getMethod(string, PARAM_TYPES);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't resolve menu item onClick handler ");
            stringBuilder.append(string);
            stringBuilder.append(" in class ");
            stringBuilder.append(clazz.getName());
            string = new InflateException(stringBuilder.toString());
            string.initCause((Throwable)exception);
            throw string;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.mMethod.getReturnType() == Boolean.TYPE) {
                return (Boolean)this.mMethod.invoke(this.mRealOwner, menuItem);
            }
            this.mMethod.invoke(this.mRealOwner, menuItem);
            return true;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
