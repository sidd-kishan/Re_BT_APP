/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckedTextView
 *  android.widget.CursorAdapter
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertController$RecycleListView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

class AlertController.AlertParams.2
extends CursorAdapter {
    private final int mIsCheckedIndex;
    private final int mLabelIndex;
    final AlertController.AlertParams this$0;
    final AlertController val$dialog;
    final AlertController.RecycleListView val$listView;

    AlertController.AlertParams.2(AlertController.AlertParams alertParams, Context context, Cursor cursor, boolean bl, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.this$0 = alertParams;
        this.val$listView = recycleListView;
        this.val$dialog = alertController;
        super(context, cursor, bl);
        alertParams = this.getCursor();
        this.mLabelIndex = alertParams.getColumnIndexOrThrow(this.this$0.mLabelColumn);
        this.mIsCheckedIndex = alertParams.getColumnIndexOrThrow(this.this$0.mIsCheckedColumn);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView)view.findViewById(16908308)).setText((CharSequence)cursor.getString(this.mLabelIndex));
        view = this.val$listView;
        int n = cursor.getPosition();
        int n2 = cursor.getInt(this.mIsCheckedIndex);
        boolean bl = true;
        if (n2 != 1) {
            bl = false;
        }
        view.setItemChecked(n, bl);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.this$0.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, viewGroup, false);
    }
}
