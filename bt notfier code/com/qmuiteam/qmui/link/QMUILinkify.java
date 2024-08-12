/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.text.style.URLSpan
 *  android.util.Patterns
 *  android.webkit.WebView
 *  android.widget.TextView
 *  com.qmuiteam.qmui.link.QMUILinkify$LinkSpec
 *  com.qmuiteam.qmui.link.QMUILinkify$MatchFilter
 *  com.qmuiteam.qmui.link.QMUILinkify$TransformFilter
 *  com.qmuiteam.qmui.link.QMUILinkify$WebUrlMatcher
 *  com.qmuiteam.qmui.span.QMUIOnSpanClickListener
 */
package com.qmuiteam.qmui.link;

import android.content.res.ColorStateList;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.webkit.WebView;
import android.widget.TextView;
import com.qmuiteam.qmui.link.QMUILinkify;
import com.qmuiteam.qmui.span.QMUIOnSpanClickListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QMUILinkify {
    public static final int ALL = 15;
    public static final int EMAIL_ADDRESSES = 2;
    public static final int MAP_ADDRESSES = 8;
    private static final int MAX_NUMBER = 21;
    public static final Pattern NOT_PHONE;
    public static final int PHONE_NUMBERS = 4;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 7;
    public static final WebUrlMatcher QMUI_WEB_URL_MATCHER;
    private static final String UrlEndAppendNextChars = "[$]";
    public static final int WEB_URLS = 1;
    public static final Pattern WECHAT_PHONE;
    public static final MatchFilter sPhoneNumberMatchFilter;
    public static final TransformFilter sPhoneNumberTransformFilter;
    public static final MatchFilter sUrlMatchFilter;
    private static WebUrlMatcher sWebUrlMatcher;

    static {
        WECHAT_PHONE = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})");
        NOT_PHONE = Pattern.compile("^\\d+(\\.\\d+)+(-\\d+)*$");
        QMUI_WEB_URL_MATCHER = new /* Unavailable Anonymous Inner Class!! */;
        sWebUrlMatcher = new /* Unavailable Anonymous Inner Class!! */;
        sUrlMatchFilter = new /* Unavailable Anonymous Inner Class!! */;
        sPhoneNumberMatchFilter = new /* Unavailable Anonymous Inner Class!! */;
        sPhoneNumberTransformFilter = new /* Unavailable Anonymous Inner Class!! */;
    }

    private static void addLinkMovementMethod(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if (movementMethod != null) {
            if (movementMethod instanceof LinkMovementMethod) return;
        }
        if (!textView.getLinksClickable()) return;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void addLinks(TextView textView, Pattern pattern, String string) {
        QMUILinkify.addLinks(textView, pattern, string, null, null);
    }

    public static void addLinks(TextView textView, Pattern pattern, String string, MatchFilter matchFilter, TransformFilter transformFilter) {
        SpannableString spannableString = SpannableString.valueOf((CharSequence)textView.getText());
        if (!QMUILinkify.addLinks((Spannable)spannableString, pattern, string, matchFilter, transformFilter)) return;
        textView.setText((CharSequence)spannableString);
        QMUILinkify.addLinkMovementMethod(textView);
    }

    public static boolean addLinks(Spannable spannable, int n, ColorStateList colorStateList, ColorStateList colorStateList2, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        Object object;
        Pattern pattern;
        if (n == 0) {
            return false;
        }
        Object object2 = (URLSpan[])spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i = ((URLSpan[])object2).length - 1; i >= 0; --i) {
            spannable.removeSpan((Object)object2[i]);
        }
        object2 = new ArrayList();
        if ((n & 1) != 0) {
            pattern = sWebUrlMatcher.getPattern();
            object = sUrlMatchFilter;
            QMUILinkify.gatherLinks((ArrayList<LinkSpec>)object2, spannable, pattern, new String[]{"http://", "https://", "rtsp://"}, (MatchFilter)object, null);
        }
        if ((n & 2) != 0) {
            QMUILinkify.gatherLinks((ArrayList<LinkSpec>)object2, spannable, Patterns.EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((n & 4) != 0) {
            Pattern pattern2 = WECHAT_PHONE;
            pattern = NOT_PHONE;
            MatchFilter matchFilter = sPhoneNumberMatchFilter;
            object = sPhoneNumberTransformFilter;
            QMUILinkify.gatherPhoneLinks((ArrayList<LinkSpec>)object2, spannable, pattern2, new Pattern[]{pattern}, new String[]{"tel:"}, matchFilter, (TransformFilter)object);
        }
        if ((n & 8) != 0) {
            QMUILinkify.gatherMapLinks((ArrayList<LinkSpec>)object2, spannable);
        }
        QMUILinkify.pruneOverlaps((ArrayList<LinkSpec>)object2);
        if (((ArrayList)object2).size() == 0) {
            return false;
        }
        object = ((ArrayList)object2).iterator();
        while (object.hasNext()) {
            object2 = (LinkSpec)object.next();
            QMUILinkify.applyLink(((LinkSpec)object2).url, ((LinkSpec)object2).start, ((LinkSpec)object2).end, spannable, colorStateList, colorStateList2, qMUIOnSpanClickListener);
        }
        return true;
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String string) {
        return QMUILinkify.addLinks(spannable, pattern, string, null, null);
    }

    public static boolean addLinks(Spannable spannable, Pattern object, String string, MatchFilter matchFilter, TransformFilter transformFilter) {
        string = string == null ? "" : string.toLowerCase(Locale.ROOT);
        object = ((Pattern)object).matcher((CharSequence)spannable);
        boolean bl = false;
        while (((Matcher)object).find()) {
            int n = ((Matcher)object).start();
            int n2 = ((Matcher)object).end();
            boolean bl2 = matchFilter != null ? matchFilter.acceptMatch((CharSequence)spannable, n, n2) : true;
            if (!bl2) continue;
            QMUILinkify.applyLink(QMUILinkify.makeUrl(((Matcher)object).group(0), new String[]{string}, (Matcher)object, transformFilter), n, n2, spannable, null, null, null);
            bl = true;
        }
        return bl;
    }

    public static boolean addLinks(TextView textView, int n, ColorStateList colorStateList, ColorStateList colorStateList2, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        if (n == 0) {
            return false;
        }
        CharSequence charSequence = textView.getText();
        if (charSequence instanceof Spannable) {
            if (!QMUILinkify.addLinks((Spannable)charSequence, n, colorStateList, colorStateList2, qMUIOnSpanClickListener)) return false;
            QMUILinkify.addLinkMovementMethod(textView);
            return true;
        }
        if (!QMUILinkify.addLinks((Spannable)(charSequence = SpannableString.valueOf((CharSequence)charSequence)), n, colorStateList, colorStateList2, qMUIOnSpanClickListener)) return false;
        QMUILinkify.addLinkMovementMethod(textView);
        textView.setText(charSequence);
        return true;
    }

    private static void applyLink(String string, int n, int n2, Spannable spannable, ColorStateList colorStateList, ColorStateList colorStateList2, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        spannable.setSpan((Object)new /* Unavailable Anonymous Inner Class!! */, n, n2, 33);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern object, String[] stringArray, MatchFilter matchFilter, TransformFilter transformFilter) {
        object = ((Pattern)object).matcher((CharSequence)spannable);
        while (((Matcher)object).find()) {
            int n = ((Matcher)object).start();
            int n2 = ((Matcher)object).end();
            if (matchFilter != null && !matchFilter.acceptMatch((CharSequence)spannable, n, n2)) continue;
            LinkSpec linkSpec = new LinkSpec(null);
            linkSpec.url = QMUILinkify.makeUrl(((Matcher)object).group(0), stringArray, (Matcher)object, transformFilter);
            linkSpec.start = n;
            linkSpec.end = n2;
            arrayList.add(linkSpec);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable object) {
        object = object.toString();
        int n = 0;
        try {
            CharSequence charSequence;
            while ((charSequence = WebView.findAddress((String)object)) != null) {
                String string;
                int n2 = ((String)object).indexOf((String)charSequence);
                if (n2 < 0) {
                    return;
                }
                LinkSpec linkSpec = new LinkSpec(null);
                int n3 = ((String)charSequence).length() + n2;
                linkSpec.start = n2 + n;
                linkSpec.end = n += n3;
                object = ((String)object).substring(n3);
                try {
                    string = URLEncoder.encode((String)charSequence, "UTF-8");
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("geo:0,0?q=");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    continue;
                }
                ((StringBuilder)charSequence).append(string);
                linkSpec.url = ((StringBuilder)charSequence).toString();
                arrayList.add(linkSpec);
            }
            return;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            return;
        }
    }

    private static void gatherPhoneLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern object, Pattern[] patternArray, String[] stringArray, MatchFilter matchFilter, TransformFilter transformFilter) {
        object = ((Pattern)object).matcher((CharSequence)spannable);
        while (((Matcher)object).find()) {
            if (QMUILinkify.isInExcepts(((Matcher)object).group(), patternArray)) continue;
            int n = ((Matcher)object).start();
            int n2 = ((Matcher)object).end();
            if (matchFilter != null && !matchFilter.acceptMatch((CharSequence)spannable, n, n2)) continue;
            LinkSpec linkSpec = new LinkSpec(null);
            linkSpec.url = QMUILinkify.makeUrl(((Matcher)object).group(0), stringArray, (Matcher)object, transformFilter);
            linkSpec.start = n;
            linkSpec.end = n2;
            arrayList.add(linkSpec);
        }
    }

    private static boolean isInExcepts(CharSequence charSequence, Pattern[] patternArray) {
        int n = patternArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (patternArray[n2].matcher(charSequence).find()) {
                return true;
            }
            ++n2;
        }
        return QMUILinkify.isTooLarge(charSequence);
    }

    private static boolean isTooLarge(CharSequence charSequence) {
        if (charSequence.length() <= 21) {
            return false;
        }
        int n = charSequence.length();
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            int n4 = n3++;
            if (Character.isDigit(charSequence.charAt(n2))) {
                n4 = n3;
                if (n3 > 21) {
                    return true;
                }
            }
            ++n2;
            n3 = n4;
        }
        return false;
    }

    private static String makeUrl(String charSequence, String[] stringArray, Matcher object, TransformFilter transformFilter) {
        int n;
        block4: {
            String string = charSequence;
            if (transformFilter != null) {
                string = transformFilter.transformUrl((Matcher)object, (String)charSequence);
            }
            int n2 = stringArray.length;
            n = 0;
            while (true) {
                int n3 = 1;
                if (n >= n2) break;
                object = stringArray[n];
                if (string.regionMatches(true, 0, (String)object, 0, ((String)object).length())) {
                    n = n3;
                    charSequence = string;
                    if (!string.regionMatches(false, 0, (String)object, 0, ((String)object).length())) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)object);
                        ((StringBuilder)charSequence).append(string.substring(((String)object).length()));
                        charSequence = ((StringBuilder)charSequence).toString();
                        n = n3;
                    }
                    break block4;
                }
                ++n;
            }
            n = 0;
            charSequence = string;
        }
        object = charSequence;
        if (n != 0) return object;
        object = new StringBuilder();
        ((StringBuilder)object).append(stringArray[0]);
        ((StringBuilder)object).append((String)charSequence);
        object = ((StringBuilder)object).toString();
        return object;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList) {
        Collections.sort(arrayList, new /* Unavailable Anonymous Inner Class!! */);
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n - 1) {
            int n3;
            LinkSpec linkSpec = arrayList.get(n2);
            int n4 = n2 + 1;
            LinkSpec linkSpec2 = arrayList.get(n4);
            if (linkSpec.start <= linkSpec2.start && linkSpec.end > linkSpec2.start && (n3 = linkSpec2.end <= linkSpec.end || linkSpec.end - linkSpec.start > linkSpec2.end - linkSpec2.start ? n4 : (linkSpec.end - linkSpec.start < linkSpec2.end - linkSpec2.start ? n2 : -1)) != -1) {
                arrayList.remove(n3);
                --n;
                continue;
            }
            n2 = n4;
        }
    }

    public static void setWebUrlMatcher(WebUrlMatcher webUrlMatcher) {
        sWebUrlMatcher = webUrlMatcher;
    }

    public static void useQmuiWebUrlMatcher() {
        sWebUrlMatcher = QMUI_WEB_URL_MATCHER;
    }
}
