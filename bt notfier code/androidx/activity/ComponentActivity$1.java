/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  androidx.activity.ComponentActivity
 */
package androidx.activity;

import android.text.TextUtils;
import androidx.activity.ComponentActivity;

/*
 * Exception performing whole class analysis ignored.
 */
class ComponentActivity.1
implements Runnable {
    final ComponentActivity this$0;

    ComponentActivity.1(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override
    public void run() {
        try {
            ComponentActivity.access$001((ComponentActivity)this.this$0);
        }
        catch (IllegalStateException illegalStateException) {
            if (!TextUtils.equals((CharSequence)illegalStateException.getMessage(), (CharSequence)"Can not perform this action after onSaveInstanceState")) throw illegalStateException;
        }
    }
}
