/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  androidx.appcompat.app.ActionBar$OnNavigationListener
 */
package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

class NavItemSelectedListener
implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener onNavigationListener) {
        this.mListener = onNavigationListener;
    }

    public void onItemSelected(AdapterView<?> onNavigationListener, View view, int n, long l) {
        onNavigationListener = this.mListener;
        if (onNavigationListener == null) return;
        onNavigationListener.onNavigationItemSelected(n, l);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
