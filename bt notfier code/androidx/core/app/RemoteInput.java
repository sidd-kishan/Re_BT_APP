/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.RemoteInput
 *  android.app.RemoteInput$Builder
 *  android.content.ClipData
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.core.app.RemoteInput$Builder
 */
package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.RemoteInput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    RemoteInput(String string, CharSequence charSequence, CharSequence[] charSequenceArray, boolean bl, int n, Bundle bundle, Set<String> set) {
        this.mResultKey = string;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArray;
        this.mAllowFreeFormTextInput = bl;
        this.mEditChoicesBeforeSending = n;
        this.mExtras = bundle;
        this.mAllowedDataTypes = set;
        if (this.getEditChoicesBeforeSending() != 2) return;
        if (!this.getAllowFreeFormInput()) throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }

    /*
     * WARNING - void declaration
     */
    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> object2) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.app.RemoteInput.addDataResultToIntent((android.app.RemoteInput)RemoteInput.fromCompat(remoteInput), (Intent)intent, (Map)object2);
        } else {
            Intent intent2;
            if (Build.VERSION.SDK_INT < 16) return;
            Intent intent3 = intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
            if (intent2 == null) {
                intent3 = new Intent();
            }
            for (Map.Entry entry : object2.entrySet()) {
                void var2_7;
                String string = (String)entry.getKey();
                Uri uri = (Uri)entry.getValue();
                if (string == null) continue;
                Intent intent4 = intent2 = intent3.getBundleExtra(RemoteInput.getExtraResultsKeyForData(string));
                if (intent2 == null) {
                    Bundle bundle = new Bundle();
                }
                var2_7.putString(remoteInput.getResultKey(), uri.toString());
                intent3.putExtra(RemoteInput.getExtraResultsKeyForData(string), (Bundle)var2_7);
            }
            intent.setClipData(ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent3));
        }
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArray, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[])RemoteInput.fromCompat(remoteInputArray), (Intent)intent, (Bundle)bundle);
        } else {
            int n = Build.VERSION.SDK_INT;
            int n2 = 0;
            if (n >= 20) {
                Object object = RemoteInput.getResultsFromIntent(intent);
                int n3 = RemoteInput.getResultsSource(intent);
                if (object != null) {
                    object.putAll(bundle);
                    bundle = object;
                }
                for (RemoteInput remoteInput : remoteInputArray) {
                    object = RemoteInput.getDataResultsFromIntent(intent, remoteInput.getResultKey());
                    android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[])RemoteInput.fromCompat(new RemoteInput[]{remoteInput}), (Intent)intent, (Bundle)bundle);
                    if (object == null) continue;
                    RemoteInput.addDataResultToIntent(remoteInput, intent, (Map<String, Uri>)object);
                }
                RemoteInput.setResultsSource(intent, n3);
            } else {
                Intent intent2;
                if (Build.VERSION.SDK_INT < 16) return;
                Intent intent3 = intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
                if (intent2 == null) {
                    intent3 = new Intent();
                }
                Object object = intent3.getBundleExtra(EXTRA_RESULTS_DATA);
                intent2 = object;
                if (object == null) {
                    intent2 = new Bundle();
                }
                n = remoteInputArray.length;
                while (n2 < n) {
                    object = remoteInputArray[n2];
                    Object object2 = bundle.get(((RemoteInput)object).getResultKey());
                    if (object2 instanceof CharSequence) {
                        intent2.putCharSequence(((RemoteInput)object).getResultKey(), (CharSequence)object2);
                    }
                    ++n2;
                }
                intent3.putExtra(EXTRA_RESULTS_DATA, (Bundle)intent2);
                intent.setClipData(ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent3));
            }
        }
    }

    static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        Object object;
        RemoteInput.Builder builder = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 26 && (object = remoteInput.getAllowedDataTypes()) != null) {
            object = object.iterator();
            while (object.hasNext()) {
                builder.setAllowDataType((String)object.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT < 29) return builder.build();
        builder.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        return builder.build();
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArray) {
        if (remoteInputArray == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArray2 = new android.app.RemoteInput[remoteInputArray.length];
        int n = 0;
        while (n < remoteInputArray.length) {
            remoteInputArray2[n] = RemoteInput.fromCompat(remoteInputArray[n]);
            ++n;
        }
        return remoteInputArray2;
    }

    static RemoteInput fromPlatform(android.app.RemoteInput remoteInput) {
        Object object;
        Builder builder = new Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 26 && (object = remoteInput.getAllowedDataTypes()) != null) {
            object = object.iterator();
            while (object.hasNext()) {
                builder.setAllowDataType((String)object.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT < 29) return builder.build();
        builder.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        return builder.build();
    }

    private static Intent getClipDataIntentFromIntent(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        intent = clipData.getDescription();
        if (!intent.hasMimeType("text/vnd.android.intent")) {
            return null;
        }
        if (intent.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) return clipData.getItemAt(0).getIntent();
        return null;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent object, String string) {
        HashMap<Object, Uri> hashMap;
        if (Build.VERSION.SDK_INT >= 26) {
            return android.app.RemoteInput.getDataResultsFromIntent((Intent)object, (String)string);
        }
        int n = Build.VERSION.SDK_INT;
        HashMap<Object, Uri> hashMap2 = hashMap = null;
        if (n < 16) return hashMap2;
        Intent intent = RemoteInput.getClipDataIntentFromIntent((Intent)object);
        if (intent == null) {
            return null;
        }
        hashMap2 = new HashMap<Object, Uri>();
        Iterator iterator = intent.getExtras().keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                if (!hashMap2.isEmpty()) return hashMap2;
                hashMap2 = hashMap;
                return hashMap2;
            }
            String string2 = (String)iterator.next();
            if (!string2.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA) || ((String)(object = string2.substring(39))).isEmpty() || (string2 = intent.getBundleExtra(string2).getString(string)) == null || string2.isEmpty()) continue;
            hashMap2.put(object, Uri.parse((String)string2));
        }
    }

    private static String getExtraResultsKeyForData(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EXTRA_DATA_TYPE_RESULTS_DATA);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        if (Build.VERSION.SDK_INT >= 20) {
            return android.app.RemoteInput.getResultsFromIntent((Intent)intent);
        }
        if (Build.VERSION.SDK_INT < 16) return null;
        if ((intent = RemoteInput.getClipDataIntentFromIntent(intent)) != null) return (Bundle)intent.getExtras().getParcelable(EXTRA_RESULTS_DATA);
        return null;
    }

    public static int getResultsSource(Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return android.app.RemoteInput.getResultsSource((Intent)intent);
        }
        if (Build.VERSION.SDK_INT < 16) return 0;
        if ((intent = RemoteInput.getClipDataIntentFromIntent(intent)) != null) return intent.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
        return 0;
    }

    public static void setResultsSource(Intent intent, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            android.app.RemoteInput.setResultsSource((Intent)intent, (int)n);
        } else {
            Intent intent2;
            if (Build.VERSION.SDK_INT < 16) return;
            Intent intent3 = intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
            if (intent2 == null) {
                intent3 = new Intent();
            }
            intent3.putExtra(EXTRA_RESULTS_SOURCE, n);
            intent.setClipData(ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent3));
        }
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        boolean bl = !this.getAllowFreeFormInput() && (this.getChoices() == null || this.getChoices().length == 0) && this.getAllowedDataTypes() != null && !this.getAllowedDataTypes().isEmpty();
        return bl;
    }
}
