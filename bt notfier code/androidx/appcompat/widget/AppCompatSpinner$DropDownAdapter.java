/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.database.DataSetObserver
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ListAdapter
 *  android.widget.SpinnerAdapter
 *  android.widget.ThemedSpinnerAdapter
 *  androidx.appcompat.widget.ThemedSpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

private static class AppCompatSpinner.DropDownAdapter
implements ListAdapter,
SpinnerAdapter {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;

    public AppCompatSpinner.DropDownAdapter(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
        this.mAdapter = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.mListAdapter = (ListAdapter)spinnerAdapter;
        }
        if (theme == null) return;
        if (Build.VERSION.SDK_INT >= 23 && spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter) {
            if ((spinnerAdapter = (android.widget.ThemedSpinnerAdapter)spinnerAdapter).getDropDownViewTheme() == theme) return;
            spinnerAdapter.setDropDownViewTheme(theme);
        } else {
            if (!(spinnerAdapter instanceof ThemedSpinnerAdapter)) return;
            if ((spinnerAdapter = (ThemedSpinnerAdapter)spinnerAdapter).getDropDownViewTheme() != null) return;
            spinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.mListAdapter;
        if (listAdapter == null) return true;
        return listAdapter.areAllItemsEnabled();
    }

    public int getCount() {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        int n = spinnerAdapter == null ? 0 : spinnerAdapter.getCount();
        return n;
    }

    public View getDropDownView(int n, View object, ViewGroup viewGroup) {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        object = spinnerAdapter == null ? null : spinnerAdapter.getDropDownView(n, object, viewGroup);
        return object;
    }

    public Object getItem(int n) {
        Object object = this.mAdapter;
        object = object == null ? null : object.getItem(n);
        return object;
    }

    public long getItemId(int n) {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        long l = spinnerAdapter == null ? -1L : spinnerAdapter.getItemId(n);
        return l;
    }

    public int getItemViewType(int n) {
        return 0;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        return this.getDropDownView(n, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        boolean bl = spinnerAdapter != null && spinnerAdapter.hasStableIds();
        return bl;
    }

    public boolean isEmpty() {
        boolean bl = this.getCount() == 0;
        return bl;
    }

    public boolean isEnabled(int n) {
        ListAdapter listAdapter = this.mListAdapter;
        if (listAdapter == null) return true;
        return listAdapter.isEnabled(n);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter == null) return;
        spinnerAdapter.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter == null) return;
        spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
    }
}
