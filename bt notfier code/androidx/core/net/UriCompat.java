/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.net;

import android.net.Uri;

public final class UriCompat {
    private UriCompat() {
    }

    public static String toSafeString(Uri object) {
        String string;
        String string2;
        block7: {
            CharSequence charSequence;
            block6: {
                block8: {
                    string2 = object.getScheme();
                    string = object.getSchemeSpecificPart();
                    charSequence = string;
                    if (string2 == null) break block6;
                    if (string2.equalsIgnoreCase("tel") || string2.equalsIgnoreCase("sip") || string2.equalsIgnoreCase("sms") || string2.equalsIgnoreCase("smsto") || string2.equalsIgnoreCase("mailto") || string2.equalsIgnoreCase("nfc")) break block7;
                    if (string2.equalsIgnoreCase("http") || string2.equalsIgnoreCase("https") || string2.equalsIgnoreCase("ftp")) break block8;
                    charSequence = string;
                    if (!string2.equalsIgnoreCase("rtsp")) break block6;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("//");
                charSequence = object.getHost();
                string = "";
                charSequence = charSequence != null ? object.getHost() : "";
                stringBuilder.append((String)charSequence);
                charSequence = string;
                if (object.getPort() != -1) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(":");
                    ((StringBuilder)charSequence).append(object.getPort());
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                stringBuilder.append((String)charSequence);
                stringBuilder.append("/...");
                charSequence = stringBuilder.toString();
            }
            object = new StringBuilder(64);
            if (string2 != null) {
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(':');
            }
            if (charSequence == null) return ((StringBuilder)object).toString();
            ((StringBuilder)object).append((String)charSequence);
            return ((StringBuilder)object).toString();
        }
        object = new StringBuilder(64);
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(':');
        if (string == null) return ((StringBuilder)object).toString();
        int n = 0;
        while (n < string.length()) {
            char c = string.charAt(n);
            if (c != '-' && c != '@' && c != '.') {
                ((StringBuilder)object).append('x');
            } else {
                ((StringBuilder)object).append(c);
            }
            ++n;
        }
        return ((StringBuilder)object).toString();
    }
}
