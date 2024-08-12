/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.activity.contextaware.OnContextAvailableListener
 *  androidx.appcompat.app.AppCompatActivity
 */
package androidx.appcompat.app;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatActivity;

class AppCompatActivity.2
implements OnContextAvailableListener {
    final AppCompatActivity this$0;

    AppCompatActivity.2(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
    }

    public void onContextAvailable(Context context) {
        context = this.this$0.getDelegate();
        context.installViewFactory();
        context.onCreate(this.this$0.getSavedStateRegistry().consumeRestoredStateForKey("androidx:appcompat"));
    }
}
