/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.Html
 *  androidx.core.app.ShareCompat$Api16Impl
 *  androidx.core.util.Preconditions
 */
package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.Html;
import androidx.core.app.ShareCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ShareCompat.IntentBuilder {
    private ArrayList<String> mBccAddresses;
    private ArrayList<String> mCcAddresses;
    private CharSequence mChooserTitle;
    private final Context mContext;
    private final Intent mIntent;
    private ArrayList<Uri> mStreams;
    private ArrayList<String> mToAddresses;

    public ShareCompat.IntentBuilder(Context context) {
        block2: {
            Intent intent;
            this.mContext = (Context)Preconditions.checkNotNull((Object)context);
            this.mIntent = intent = new Intent().setAction("android.intent.action.SEND");
            intent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.mIntent.addFlags(524288);
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    context = (Activity)context;
                    break block2;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            context = null;
        }
        if (context == null) return;
        context = context.getComponentName();
        this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", (Parcelable)context);
        this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", (Parcelable)context);
    }

    private void combineArrayExtra(String string, ArrayList<String> arrayList) {
        String[] stringArray = this.mIntent.getStringArrayExtra(string);
        int n = stringArray != null ? stringArray.length : 0;
        String[] stringArray2 = new String[arrayList.size() + n];
        arrayList.toArray(stringArray2);
        if (stringArray != null) {
            System.arraycopy(stringArray, 0, stringArray2, arrayList.size(), n);
        }
        this.mIntent.putExtra(string, stringArray2);
    }

    private void combineArrayExtra(String string, String[] stringArray) {
        Intent intent = this.getIntent();
        String[] stringArray2 = intent.getStringArrayExtra(string);
        int n = stringArray2 != null ? stringArray2.length : 0;
        String[] stringArray3 = new String[stringArray.length + n];
        if (stringArray2 != null) {
            System.arraycopy(stringArray2, 0, stringArray3, 0, n);
        }
        System.arraycopy(stringArray, 0, stringArray3, n, stringArray.length);
        intent.putExtra(string, stringArray3);
    }

    @Deprecated
    public static ShareCompat.IntentBuilder from(Activity activity) {
        return new ShareCompat.IntentBuilder((Context)activity);
    }

    public ShareCompat.IntentBuilder addEmailBcc(String string) {
        if (this.mBccAddresses == null) {
            this.mBccAddresses = new ArrayList();
        }
        this.mBccAddresses.add(string);
        return this;
    }

    public ShareCompat.IntentBuilder addEmailBcc(String[] stringArray) {
        this.combineArrayExtra("android.intent.extra.BCC", stringArray);
        return this;
    }

    public ShareCompat.IntentBuilder addEmailCc(String string) {
        if (this.mCcAddresses == null) {
            this.mCcAddresses = new ArrayList();
        }
        this.mCcAddresses.add(string);
        return this;
    }

    public ShareCompat.IntentBuilder addEmailCc(String[] stringArray) {
        this.combineArrayExtra("android.intent.extra.CC", stringArray);
        return this;
    }

    public ShareCompat.IntentBuilder addEmailTo(String string) {
        if (this.mToAddresses == null) {
            this.mToAddresses = new ArrayList();
        }
        this.mToAddresses.add(string);
        return this;
    }

    public ShareCompat.IntentBuilder addEmailTo(String[] stringArray) {
        this.combineArrayExtra("android.intent.extra.EMAIL", stringArray);
        return this;
    }

    public ShareCompat.IntentBuilder addStream(Uri uri) {
        if (this.mStreams == null) {
            this.mStreams = new ArrayList();
        }
        this.mStreams.add(uri);
        return this;
    }

    public Intent createChooserIntent() {
        return Intent.createChooser((Intent)this.getIntent(), (CharSequence)this.mChooserTitle);
    }

    Context getContext() {
        return this.mContext;
    }

    public Intent getIntent() {
        ArrayList<String> arrayList = this.mToAddresses;
        if (arrayList != null) {
            this.combineArrayExtra("android.intent.extra.EMAIL", arrayList);
            this.mToAddresses = null;
        }
        if ((arrayList = this.mCcAddresses) != null) {
            this.combineArrayExtra("android.intent.extra.CC", arrayList);
            this.mCcAddresses = null;
        }
        if ((arrayList = this.mBccAddresses) != null) {
            this.combineArrayExtra("android.intent.extra.BCC", arrayList);
            this.mBccAddresses = null;
        }
        arrayList = this.mStreams;
        boolean bl = true;
        if (arrayList == null || arrayList.size() <= 1) {
            bl = false;
        }
        if (!bl) {
            this.mIntent.setAction("android.intent.action.SEND");
            arrayList = this.mStreams;
            if (arrayList != null && !arrayList.isEmpty()) {
                this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
                if (Build.VERSION.SDK_INT < 16) return this.mIntent;
                ShareCompat.Api16Impl.migrateExtraStreamToClipData((Intent)this.mIntent, this.mStreams);
            } else {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
                if (Build.VERSION.SDK_INT < 16) return this.mIntent;
                ShareCompat.Api16Impl.removeClipData((Intent)this.mIntent);
            }
        } else {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            if (Build.VERSION.SDK_INT < 16) return this.mIntent;
            ShareCompat.Api16Impl.migrateExtraStreamToClipData((Intent)this.mIntent, this.mStreams);
        }
        return this.mIntent;
    }

    public ShareCompat.IntentBuilder setChooserTitle(int n) {
        return this.setChooserTitle(this.mContext.getText(n));
    }

    public ShareCompat.IntentBuilder setChooserTitle(CharSequence charSequence) {
        this.mChooserTitle = charSequence;
        return this;
    }

    public ShareCompat.IntentBuilder setEmailBcc(String[] stringArray) {
        this.mIntent.putExtra("android.intent.extra.BCC", stringArray);
        return this;
    }

    public ShareCompat.IntentBuilder setEmailCc(String[] stringArray) {
        this.mIntent.putExtra("android.intent.extra.CC", stringArray);
        return this;
    }

    public ShareCompat.IntentBuilder setEmailTo(String[] stringArray) {
        if (this.mToAddresses != null) {
            this.mToAddresses = null;
        }
        this.mIntent.putExtra("android.intent.extra.EMAIL", stringArray);
        return this;
    }

    public ShareCompat.IntentBuilder setHtmlText(String string) {
        this.mIntent.putExtra("android.intent.extra.HTML_TEXT", string);
        if (this.mIntent.hasExtra("android.intent.extra.TEXT")) return this;
        this.setText((CharSequence)Html.fromHtml((String)string));
        return this;
    }

    public ShareCompat.IntentBuilder setStream(Uri uri) {
        this.mStreams = null;
        if (uri == null) return this;
        this.addStream(uri);
        return this;
    }

    public ShareCompat.IntentBuilder setSubject(String string) {
        this.mIntent.putExtra("android.intent.extra.SUBJECT", string);
        return this;
    }

    public ShareCompat.IntentBuilder setText(CharSequence charSequence) {
        this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }

    public ShareCompat.IntentBuilder setType(String string) {
        this.mIntent.setType(string);
        return this;
    }

    public void startChooser() {
        this.mContext.startActivity(this.createChooserIntent());
    }
}
