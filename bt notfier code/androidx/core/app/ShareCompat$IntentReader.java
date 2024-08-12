/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.Html
 *  android.text.Spanned
 *  android.util.Log
 *  androidx.core.app.ShareCompat
 *  androidx.core.util.Preconditions
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import androidx.core.app.ShareCompat;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ShareCompat.IntentReader {
    private static final String TAG = "IntentReader";
    private final ComponentName mCallingActivity;
    private final String mCallingPackage;
    private final Context mContext;
    private final Intent mIntent;
    private ArrayList<Uri> mStreams;

    public ShareCompat.IntentReader(Activity activity) {
        this((Context)Preconditions.checkNotNull((Object)activity), activity.getIntent());
    }

    public ShareCompat.IntentReader(Context context, Intent intent) {
        this.mContext = (Context)Preconditions.checkNotNull((Object)context);
        this.mIntent = (Intent)Preconditions.checkNotNull((Object)intent);
        this.mCallingPackage = ShareCompat.getCallingPackage((Intent)intent);
        this.mCallingActivity = ShareCompat.getCallingActivity((Intent)intent);
    }

    @Deprecated
    public static ShareCompat.IntentReader from(Activity activity) {
        return new ShareCompat.IntentReader(activity);
    }

    private static void withinStyle(StringBuilder stringBuilder, CharSequence charSequence, int n, int n2) {
        while (n < n2) {
            char c = charSequence.charAt(n);
            if (c == '<') {
                stringBuilder.append("&lt;");
            } else if (c == '>') {
                stringBuilder.append("&gt;");
            } else if (c == '&') {
                stringBuilder.append("&amp;");
            } else if (c <= '~' && c >= ' ') {
                if (c == ' ') {
                    int n3;
                    while ((n3 = n + 1) < n2 && charSequence.charAt(n3) == ' ') {
                        stringBuilder.append("&nbsp;");
                        n = n3;
                    }
                    stringBuilder.append(' ');
                } else {
                    stringBuilder.append(c);
                }
            } else {
                stringBuilder.append("&#");
                stringBuilder.append((int)c);
                stringBuilder.append(";");
            }
            ++n;
        }
    }

    public ComponentName getCallingActivity() {
        return this.mCallingActivity;
    }

    public Drawable getCallingActivityIcon() {
        if (this.mCallingActivity == null) {
            return null;
        }
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            packageManager = packageManager.getActivityIcon(this.mCallingActivity);
            return packageManager;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)"IntentReader", (String)"Could not retrieve icon for calling activity", (Throwable)nameNotFoundException);
            return null;
        }
    }

    public Drawable getCallingApplicationIcon() {
        if (this.mCallingPackage == null) {
            return null;
        }
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            packageManager = packageManager.getApplicationIcon(this.mCallingPackage);
            return packageManager;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)"IntentReader", (String)"Could not retrieve icon for calling application", (Throwable)nameNotFoundException);
            return null;
        }
    }

    public CharSequence getCallingApplicationLabel() {
        if (this.mCallingPackage == null) {
            return null;
        }
        Object object = this.mContext.getPackageManager();
        try {
            object = object.getApplicationLabel(object.getApplicationInfo(this.mCallingPackage, 0));
            return object;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)"IntentReader", (String)"Could not retrieve label for calling application", (Throwable)nameNotFoundException);
            return null;
        }
    }

    public String getCallingPackage() {
        return this.mCallingPackage;
    }

    public String[] getEmailBcc() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }

    public String[] getEmailCc() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
    }

    public String[] getEmailTo() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }

    public String getHtmlText() {
        String string = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
        CharSequence charSequence = string;
        if (string != null) return charSequence;
        CharSequence charSequence2 = this.getText();
        if (charSequence2 instanceof Spanned) {
            charSequence = Html.toHtml((Spanned)((Spanned)charSequence2));
        } else {
            charSequence = string;
            if (charSequence2 == null) return charSequence;
            if (Build.VERSION.SDK_INT >= 16) {
                charSequence = Html.escapeHtml((CharSequence)charSequence2);
            } else {
                charSequence = new StringBuilder();
                ShareCompat.IntentReader.withinStyle((StringBuilder)charSequence, charSequence2, 0, charSequence2.length());
                charSequence = ((StringBuilder)charSequence).toString();
            }
        }
        return charSequence;
    }

    public Uri getStream() {
        return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }

    public Uri getStream(int n) {
        Serializable serializable;
        if (this.mStreams == null && this.isMultipleShare()) {
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if ((serializable = this.mStreams) != null) {
            return ((ArrayList)serializable).get(n);
        }
        if (n == 0) {
            return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("Stream items available: ");
        ((StringBuilder)serializable).append(this.getStreamCount());
        ((StringBuilder)serializable).append(" index requested: ");
        ((StringBuilder)serializable).append(n);
        throw new IndexOutOfBoundsException(((StringBuilder)serializable).toString());
    }

    public int getStreamCount() {
        ArrayList<Uri> arrayList;
        if (this.mStreams == null && this.isMultipleShare()) {
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if ((arrayList = this.mStreams) == null) return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        return arrayList.size();
    }

    public String getSubject() {
        return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }

    public CharSequence getText() {
        return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }

    public String getType() {
        return this.mIntent.getType();
    }

    public boolean isMultipleShare() {
        return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
    }

    public boolean isShareIntent() {
        String string = this.mIntent.getAction();
        boolean bl = "android.intent.action.SEND".equals(string) || "android.intent.action.SEND_MULTIPLE".equals(string);
        return bl;
    }

    public boolean isSingleShare() {
        return "android.intent.action.SEND".equals(this.mIntent.getAction());
    }
}
