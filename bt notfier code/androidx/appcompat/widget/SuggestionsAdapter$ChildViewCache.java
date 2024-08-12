/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.R$id
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;

private static final class SuggestionsAdapter.ChildViewCache {
    public final ImageView mIcon1;
    public final ImageView mIcon2;
    public final ImageView mIconRefine;
    public final TextView mText1;
    public final TextView mText2;

    public SuggestionsAdapter.ChildViewCache(View view) {
        this.mText1 = (TextView)view.findViewById(16908308);
        this.mText2 = (TextView)view.findViewById(16908309);
        this.mIcon1 = (ImageView)view.findViewById(16908295);
        this.mIcon2 = (ImageView)view.findViewById(16908296);
        this.mIconRefine = (ImageView)view.findViewById(R.id.edit_query);
    }
}
