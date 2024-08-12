/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

private static class AppCompatViewInflater.DeclaredOnClickListener
implements View.OnClickListener {
    private final View mHostView;
    private final String mMethodName;
    private Context mResolvedContext;
    private Method mResolvedMethod;

    public AppCompatViewInflater.DeclaredOnClickListener(View view, String string) {
        this.mHostView = view;
        this.mMethodName = string;
    }

    private void resolveMethod(Context object) {
        Object object2;
        while (object != null) {
            try {
                if (!object.isRestricted() && (object2 = object.getClass().getMethod(this.mMethodName, View.class)) != null) {
                    this.mResolvedMethod = object2;
                    this.mResolvedContext = object;
                    return;
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            if (object instanceof ContextWrapper) {
                object = ((ContextWrapper)object).getBaseContext();
                continue;
            }
            object = null;
        }
        int n = this.mHostView.getId();
        if (n == -1) {
            object = "";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append(" with id '");
            ((StringBuilder)object).append(this.mHostView.getContext().getResources().getResourceEntryName(n));
            ((StringBuilder)object).append("'");
            object = ((StringBuilder)object).toString();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Could not find method ");
        ((StringBuilder)object2).append(this.mMethodName);
        ((StringBuilder)object2).append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
        ((StringBuilder)object2).append(this.mHostView.getClass());
        ((StringBuilder)object2).append((String)object);
        object = new IllegalStateException(((StringBuilder)object2).toString());
        throw object;
    }

    public void onClick(View view) {
        if (this.mResolvedMethod == null) {
            this.resolveMethod(this.mHostView.getContext());
        }
        try {
            this.mResolvedMethod.invoke(this.mResolvedContext, view);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new IllegalStateException("Could not execute method for android:onClick", invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", illegalAccessException);
        }
    }
}
