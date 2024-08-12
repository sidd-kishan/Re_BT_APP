/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.Selection
 *  android.text.Spannable
 *  android.view.DragEvent
 *  android.view.View
 *  android.widget.TextView
 *  androidx.core.view.ContentInfoCompat
 *  androidx.core.view.ContentInfoCompat$Builder
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

private static final class AppCompatReceiveContentHelper.OnDropApi24Impl {
    private AppCompatReceiveContentHelper.OnDropApi24Impl() {
    }

    static boolean onDropForTextView(DragEvent dragEvent, TextView textView, Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        int n = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable)((Spannable)textView.getText()), (int)n);
            activity = new ContentInfoCompat.Builder(dragEvent.getClipData(), 3);
            ViewCompat.performReceiveContent((View)textView, (ContentInfoCompat)activity.build());
            return true;
        }
        finally {
            textView.endBatchEdit();
        }
    }

    static boolean onDropForView(DragEvent dragEvent, View view, Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        ViewCompat.performReceiveContent((View)view, (ContentInfoCompat)new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
        return true;
    }
}
