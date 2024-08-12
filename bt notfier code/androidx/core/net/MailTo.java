/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.core.net.ParseException
 *  androidx.core.util.Preconditions
 */
package androidx.core.net;

import android.net.Uri;
import androidx.core.net.ParseException;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders = new HashMap();

    private MailTo() {
    }

    public static boolean isMailTo(Uri uri) {
        boolean bl = uri != null && MAILTO.equals(uri.getScheme());
        return bl;
    }

    public static boolean isMailTo(String string) {
        boolean bl = string != null && string.startsWith(MAILTO_SCHEME);
        return bl;
    }

    public static MailTo parse(Uri uri) throws ParseException {
        return MailTo.parse(uri.toString());
    }

    public static MailTo parse(String string) throws ParseException {
        String string2;
        Preconditions.checkNotNull((Object)string);
        if (!MailTo.isMailTo(string)) {
            string = new ParseException("Not a mailto scheme");
            throw string;
        }
        int n = string.indexOf(35);
        CharSequence charSequence = string;
        if (n != -1) {
            charSequence = string.substring(0, n);
        }
        if ((n = ((String)charSequence).indexOf(63)) == -1) {
            string = Uri.decode((String)((String)charSequence).substring(7));
            charSequence = null;
        } else {
            string = Uri.decode((String)((String)charSequence).substring(7, n));
            charSequence = ((String)charSequence).substring(n + 1);
        }
        MailTo mailTo = new MailTo();
        if (charSequence != null) {
            String[] stringArray = ((String)charSequence).split("&");
            int n2 = stringArray.length;
            for (n = 0; n < n2; ++n) {
                charSequence = stringArray[n].split("=", 2);
                if (((CharSequence)charSequence).length == 0) continue;
                string2 = Uri.decode((String)charSequence[0]).toLowerCase(Locale.ROOT);
                charSequence = ((CharSequence)charSequence).length > 1 ? Uri.decode((String)charSequence[1]) : null;
                mailTo.mHeaders.put(string2, (String)charSequence);
            }
        }
        string2 = mailTo.getTo();
        charSequence = string;
        if (string2 != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append(", ");
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        mailTo.mHeaders.put(TO, (String)charSequence);
        return mailTo;
    }

    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    public String getBody() {
        return this.mHeaders.get(BODY);
    }

    public String getCc() {
        return this.mHeaders.get(CC);
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    public String getTo() {
        return this.mHeaders.get(TO);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(MAILTO_SCHEME);
        stringBuilder.append('?');
        Iterator<Map.Entry<String, String>> iterator = this.mHeaders.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            stringBuilder.append(Uri.encode((String)entry.getKey()));
            stringBuilder.append('=');
            stringBuilder.append(Uri.encode((String)entry.getValue()));
            stringBuilder.append('&');
        }
        return stringBuilder.toString();
    }
}
