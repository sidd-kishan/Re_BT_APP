/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.method.LinkMovementMethod
 *  android.text.style.URLSpan
 *  android.text.util.Linkify
 *  android.text.util.Linkify$MatchFilter
 *  android.text.util.Linkify$TransformFilter
 *  android.webkit.WebView
 *  android.widget.TextView
 *  androidx.core.text.util.FindAddress
 *  androidx.core.text.util.LinkifyCompat$LinkSpec
 *  androidx.core.util.PatternsCompat
 */
package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.text.util.FindAddress;
import androidx.core.text.util.LinkifyCompat;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR;
    private static final String[] EMPTY_STRING;

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = new /* Unavailable Anonymous Inner Class!! */;
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(TextView textView) {
        if (textView.getMovementMethod() instanceof LinkMovementMethod) return;
        if (!textView.getLinksClickable()) return;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void addLinks(TextView textView, Pattern pattern, String string) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string);
            return;
        }
        LinkifyCompat.addLinks(textView, pattern, string, null, null, null);
    }

    public static void addLinks(TextView textView, Pattern pattern, String string, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
            return;
        }
        LinkifyCompat.addLinks(textView, pattern, string, null, matchFilter, transformFilter);
    }

    public static void addLinks(TextView textView, Pattern pattern, String string, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string, (String[])stringArray, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
            return;
        }
        SpannableString spannableString = SpannableString.valueOf((CharSequence)textView.getText());
        if (!LinkifyCompat.addLinks((Spannable)spannableString, pattern, string, stringArray, matchFilter, transformFilter)) return;
        textView.setText((CharSequence)spannableString);
        LinkifyCompat.addLinkMovementMethod(textView);
    }

    public static boolean addLinks(Spannable spannable, int n) {
        Object object;
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks((Spannable)spannable, (int)n);
        }
        if (n == 0) {
            return false;
        }
        Object object2 = (URLSpan[])spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i = ((URLSpan[])object2).length - 1; i >= 0; --i) {
            spannable.removeSpan((Object)object2[i]);
        }
        if ((n & 4) != 0) {
            Linkify.addLinks((Spannable)spannable, (int)4);
        }
        object2 = new ArrayList();
        if ((n & 1) != 0) {
            object = PatternsCompat.AUTOLINK_WEB_URL;
            Linkify.MatchFilter matchFilter = Linkify.sUrlMatchFilter;
            LinkifyCompat.gatherLinks((ArrayList<LinkSpec>)object2, spannable, (Pattern)object, new String[]{"http://", "https://", "rtsp://"}, matchFilter, null);
        }
        if ((n & 2) != 0) {
            LinkifyCompat.gatherLinks((ArrayList<LinkSpec>)object2, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((n & 8) != 0) {
            LinkifyCompat.gatherMapLinks((ArrayList<LinkSpec>)object2, spannable);
        }
        LinkifyCompat.pruneOverlaps((ArrayList<LinkSpec>)object2, spannable);
        if (((ArrayList)object2).size() == 0) {
            return false;
        }
        object = ((ArrayList)object2).iterator();
        while (object.hasNext()) {
            object2 = (LinkSpec)object.next();
            if (((LinkSpec)object2).frameworkAddedSpan != null) continue;
            LinkifyCompat.applyLink(((LinkSpec)object2).url, ((LinkSpec)object2).start, ((LinkSpec)object2).end, spannable);
        }
        return true;
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String string) {
        if (!LinkifyCompat.shouldAddLinksFallbackToFramework()) return LinkifyCompat.addLinks(spannable, pattern, string, null, null, null);
        return Linkify.addLinks((Spannable)spannable, (Pattern)pattern, (String)string);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String string, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (!LinkifyCompat.shouldAddLinksFallbackToFramework()) return LinkifyCompat.addLinks(spannable, pattern, string, null, matchFilter, transformFilter);
        return Linkify.addLinks((Spannable)spannable, (Pattern)pattern, (String)string, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
    }

    public static boolean addLinks(Spannable spannable, Pattern object, String stringArray, String[] object2, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        String[] stringArray2;
        block8: {
            block7: {
                if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
                    return Linkify.addLinks((Spannable)spannable, (Pattern)object, (String)stringArray, (String[])object2, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
                }
                stringArray2 = stringArray;
                if (stringArray == null) {
                    stringArray2 = "";
                }
                if (object2 == null) break block7;
                stringArray = object2;
                if (((String[])object2).length >= 1) break block8;
            }
            stringArray = EMPTY_STRING;
        }
        String[] stringArray3 = new String[stringArray.length + 1];
        stringArray3[0] = stringArray2.toLowerCase(Locale.ROOT);
        int n = 0;
        while (n < stringArray.length) {
            object2 = stringArray[n];
            object2 = object2 == null ? "" : object2.toLowerCase(Locale.ROOT);
            stringArray3[++n] = object2;
        }
        object = ((Pattern)object).matcher((CharSequence)spannable);
        boolean bl = false;
        while (((Matcher)object).find()) {
            int n2 = ((Matcher)object).start();
            n = ((Matcher)object).end();
            boolean bl2 = matchFilter != null ? matchFilter.acceptMatch((CharSequence)spannable, n2, n) : true;
            if (!bl2) continue;
            LinkifyCompat.applyLink(LinkifyCompat.makeUrl(((Matcher)object).group(0), stringArray3, (Matcher)object, transformFilter), n2, n, spannable);
            bl = true;
        }
        return bl;
    }

    public static boolean addLinks(TextView textView, int n) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks((TextView)textView, (int)n);
        }
        if (n == 0) {
            return false;
        }
        CharSequence charSequence = textView.getText();
        if (charSequence instanceof Spannable) {
            if (!LinkifyCompat.addLinks((Spannable)charSequence, n)) return false;
            LinkifyCompat.addLinkMovementMethod(textView);
            return true;
        }
        if (!LinkifyCompat.addLinks((Spannable)(charSequence = SpannableString.valueOf((CharSequence)charSequence)), n)) return false;
        LinkifyCompat.addLinkMovementMethod(textView);
        textView.setText(charSequence);
        return true;
    }

    private static void applyLink(String string, int n, int n2, Spannable spannable) {
        spannable.setSpan((Object)new URLSpan(string), n, n2, 33);
    }

    private static String findAddress(String string) {
        if (Build.VERSION.SDK_INT < 28) return FindAddress.findAddress((String)string);
        return WebView.findAddress((String)string);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher((CharSequence)spannable);
        while (matcher.find()) {
            int n = matcher.start();
            int n2 = matcher.end();
            if (matchFilter != null && !matchFilter.acceptMatch((CharSequence)spannable, n, n2)) continue;
            pattern = new LinkSpec();
            ((LinkSpec)pattern).url = LinkifyCompat.makeUrl(matcher.group(0), stringArray, matcher, transformFilter);
            ((LinkSpec)pattern).start = n;
            ((LinkSpec)pattern).end = n2;
            arrayList.add((LinkSpec)pattern);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable object) {
        object = object.toString();
        int n = 0;
        try {
            String string;
            while ((string = LinkifyCompat.findAddress((String)object)) != null) {
                StringBuilder stringBuilder;
                int n2 = ((String)object).indexOf(string);
                if (n2 < 0) {
                    return;
                }
                LinkSpec linkSpec = new LinkSpec();
                int n3 = string.length() + n2;
                linkSpec.start = n2 + n;
                linkSpec.end = n += n3;
                object = ((String)object).substring(n3);
                try {
                    string = URLEncoder.encode(string, "UTF-8");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("geo:0,0?q=");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    continue;
                }
                stringBuilder.append(string);
                linkSpec.url = stringBuilder.toString();
                arrayList.add(linkSpec);
            }
            return;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            return;
        }
    }

    private static String makeUrl(String charSequence, String[] stringArray, Matcher object, Linkify.TransformFilter transformFilter) {
        int n;
        block4: {
            String string = charSequence;
            if (transformFilter != null) {
                string = transformFilter.transformUrl((Matcher)object, (String)charSequence);
            }
            int n2 = 0;
            while (true) {
                n = stringArray.length;
                int n3 = 1;
                if (n2 >= n) break;
                if (string.regionMatches(true, 0, stringArray[n2], 0, stringArray[n2].length())) {
                    n = n3;
                    charSequence = string;
                    if (!string.regionMatches(false, 0, stringArray[n2], 0, stringArray[n2].length())) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append(stringArray[n2]);
                        ((StringBuilder)charSequence).append(string.substring(stringArray[n2].length()));
                        charSequence = ((StringBuilder)charSequence).toString();
                        n = n3;
                    }
                    break block4;
                }
                ++n2;
            }
            n = 0;
            charSequence = string;
        }
        object = charSequence;
        if (n != 0) return object;
        object = charSequence;
        if (stringArray.length <= 0) return object;
        object = new StringBuilder();
        ((StringBuilder)object).append(stringArray[0]);
        ((StringBuilder)object).append((String)charSequence);
        object = ((StringBuilder)object).toString();
        return object;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        LinkSpec linkSpec;
        int n = spannable.length();
        int n2 = 0;
        LinkSpec linkSpec2 = (LinkSpec)spannable.getSpans(0, n, URLSpan.class);
        for (n = 0; n < ((URLSpan[])linkSpec2).length; ++n) {
            linkSpec = new LinkSpec();
            linkSpec.frameworkAddedSpan = linkSpec2[n];
            linkSpec.start = spannable.getSpanStart((Object)linkSpec2[n]);
            linkSpec.end = spannable.getSpanEnd((Object)linkSpec2[n]);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int n3 = arrayList.size();
        n = n2;
        while (n < n3 - 1) {
            linkSpec2 = arrayList.get(n);
            int n4 = n + 1;
            linkSpec = arrayList.get(n4);
            if (linkSpec2.start <= linkSpec.start && linkSpec2.end > linkSpec.start && (n2 = linkSpec.end <= linkSpec2.end || linkSpec2.end - linkSpec2.start > linkSpec.end - linkSpec.start ? n4 : (linkSpec2.end - linkSpec2.start < linkSpec.end - linkSpec.start ? n : -1)) != -1) {
                linkSpec2 = arrayList.get((int)n2).frameworkAddedSpan;
                if (linkSpec2 != null) {
                    spannable.removeSpan((Object)linkSpec2);
                }
                arrayList.remove(n2);
                --n3;
                continue;
            }
            n = n4;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        boolean bl = Build.VERSION.SDK_INT >= 28;
        return bl;
    }
}
