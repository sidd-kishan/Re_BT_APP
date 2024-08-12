/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.textclassifier.TextClassificationManager
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 *  androidx.core.util.Preconditions
 */
package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    AppCompatTextClassifierHelper(TextView textView) {
        this.mTextView = (TextView)Preconditions.checkNotNull((Object)textView);
    }

    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier;
        TextClassifier textClassifier2 = textClassifier = this.mTextClassifier;
        if (textClassifier != null) return textClassifier2;
        textClassifier2 = (TextClassificationManager)this.mTextView.getContext().getSystemService(TextClassificationManager.class);
        if (textClassifier2 != null) {
            return textClassifier2.getTextClassifier();
        }
        textClassifier2 = TextClassifier.NO_OP;
        return textClassifier2;
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        this.mTextClassifier = textClassifier;
    }
}
