/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.DragEvent
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatReceiveContentHelper$OnDropApi24Impl
 *  androidx.core.view.ContentInfoCompat
 *  androidx.core.view.ContentInfoCompat$Builder
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatReceiveContentHelper;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;

/*
 * Exception performing whole class analysis ignored.
 */
final class AppCompatReceiveContentHelper {
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final String LOG_TAG = "ReceiveContent";

    private AppCompatReceiveContentHelper() {
    }

    static InputConnectionCompat.OnCommitContentListener createOnCommitContentListener(View view) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(View view, DragEvent object) {
        if (Build.VERSION.SDK_INT < 24) return false;
        if (object.getLocalState() != null) return false;
        if (ViewCompat.getOnReceiveContentMimeTypes((View)view) == null) {
            return false;
        }
        Activity activity = AppCompatReceiveContentHelper.tryGetActivity(view);
        if (activity == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Can't handle drop: no activity: view=");
            ((StringBuilder)object).append(view);
            Log.i((String)"ReceiveContent", (String)((StringBuilder)object).toString());
            return false;
        }
        if (object.getAction() == 1) {
            return view instanceof TextView ^ true;
        }
        if (object.getAction() != 3) return false;
        boolean bl = view instanceof TextView ? OnDropApi24Impl.onDropForTextView((DragEvent)object, (TextView)((TextView)view), (Activity)activity) : OnDropApi24Impl.onDropForView((DragEvent)object, (View)view, (Activity)activity);
        return bl;
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView textView, int n) {
        int n2 = 0;
        if (n != 0x1020022) {
            if (n != 16908337) return false;
        }
        if (ViewCompat.getOnReceiveContentMimeTypes((View)textView) == null) {
            return false;
        }
        Object object = (ClipboardManager)textView.getContext().getSystemService("clipboard");
        object = object == null ? null : object.getPrimaryClip();
        if (object == null) return true;
        if (object.getItemCount() <= 0) return true;
        object = new ContentInfoCompat.Builder((ClipData)object, 1);
        n = n == 0x1020022 ? n2 : 1;
        ViewCompat.performReceiveContent((View)textView, (ContentInfoCompat)object.setFlags(n).build());
        return true;
    }

    static Activity tryGetActivity(View view) {
        view = view.getContext();
        while (view instanceof ContextWrapper) {
            if (view instanceof Activity) {
                return (Activity)view;
            }
            view = ((ContextWrapper)view).getBaseContext();
        }
        return null;
    }
}
