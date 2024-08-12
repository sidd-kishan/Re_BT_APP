/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ArrayAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.widget.ArrayAdapter;

private static class AlertController.CheckedItemAdapter
extends ArrayAdapter<CharSequence> {
    public AlertController.CheckedItemAdapter(Context context, int n, int n2, CharSequence[] charSequenceArray) {
        super(context, n, n2, (Object[])charSequenceArray);
    }

    public long getItemId(int n) {
        return n;
    }

    public boolean hasStableIds() {
        return true;
    }
}
