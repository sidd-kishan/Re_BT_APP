/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.util.FindAddress$ZipRange
 */
package androidx.core.text.util;

import androidx.core.text.util.FindAddress;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FindAddress {
    private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final String HOUSE_END = "(?=[,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String HOUSE_POST_DELIM = ",\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String HOUSE_PRE_DELIM = ":,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int MAX_ADDRESS_LINES = 5;
    private static final int MAX_ADDRESS_WORDS = 14;
    private static final int MAX_LOCATION_NAME_DISTANCE = 5;
    private static final int MIN_ADDRESS_WORDS = 4;
    private static final String NL = "\n\u000b\f\r\u0085\u2028\u2029";
    private static final String SP = "\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000";
    private static final String WORD_DELIM = ",*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String WORD_END = "(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String WS = "\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int kMaxAddressNameWordLength = 25;
    private static final Pattern sHouseNumberRe;
    private static final Pattern sLocationNameRe;
    private static final Pattern sStateRe;
    private static final ZipRange[] sStateZipCodeRanges;
    private static final Pattern sSuffixedNumberRe;
    private static final Pattern sWordRe;
    private static final Pattern sZipCodeRe;

    static {
        sStateZipCodeRanges = new ZipRange[]{new ZipRange(99, 99, -1, -1), new ZipRange(35, 36, -1, -1), new ZipRange(71, 72, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(85, 86, -1, -1), new ZipRange(90, 96, -1, -1), new ZipRange(80, 81, -1, -1), new ZipRange(6, 6, -1, -1), new ZipRange(20, 20, -1, -1), new ZipRange(19, 19, -1, -1), new ZipRange(32, 34, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(30, 31, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(50, 52, -1, -1), new ZipRange(83, 83, -1, -1), new ZipRange(60, 62, -1, -1), new ZipRange(46, 47, -1, -1), new ZipRange(66, 67, 73, -1), new ZipRange(40, 42, -1, -1), new ZipRange(70, 71, -1, -1), new ZipRange(1, 2, -1, -1), new ZipRange(20, 21, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(48, 49, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(63, 65, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(38, 39, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(27, 28, -1, -1), new ZipRange(58, 58, -1, -1), new ZipRange(68, 69, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(7, 8, -1, -1), new ZipRange(87, 88, 86, -1), new ZipRange(88, 89, 96, -1), new ZipRange(10, 14, 0, 6), new ZipRange(43, 45, -1, -1), new ZipRange(73, 74, -1, -1), new ZipRange(97, 97, -1, -1), new ZipRange(15, 19, -1, -1), new ZipRange(6, 6, 0, 9), new ZipRange(96, 96, -1, -1), new ZipRange(2, 2, -1, -1), new ZipRange(29, 29, -1, -1), new ZipRange(57, 57, -1, -1), new ZipRange(37, 38, -1, -1), new ZipRange(75, 79, 87, 88), new ZipRange(84, 84, -1, -1), new ZipRange(22, 24, 20, -1), new ZipRange(6, 9, -1, -1), new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1)};
        sWordRe = Pattern.compile("[^,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+of[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+states[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+of[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+mariana[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+carolina)|(nd|north[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+hampshire)|(nj|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+jersey)|(nm|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+island)|(sc|south[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+carolina)|(sd|south[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+virginia)|(wy|wyoming))(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
        sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    }

    private FindAddress() {
    }

    private static int attemptMatch(String string, MatchResult object) {
        int n;
        block20: {
            int n2 = object.end();
            Matcher matcher = sWordRe.matcher(string);
            object = "";
            int n3 = 1;
            int n4 = 1;
            int n5 = 1;
            boolean bl = false;
            int n6 = -1;
            int n7 = -1;
            while (true) {
                int n8;
                int n9;
                boolean bl2;
                n = n2;
                if (n2 >= string.length()) break;
                if (!matcher.find(n2)) {
                    n = string.length();
                    break block20;
                }
                if (matcher.end() - matcher.start() > 25) {
                    n = matcher.end();
                    break block20;
                }
                for (n = n2; n < matcher.start(); ++n) {
                    n2 = n3;
                    if (NL.indexOf(string.charAt(n)) != -1) {
                        n2 = n3 + 1;
                    }
                    n3 = n2;
                }
                if (n3 > 5 || ++n4 > 14) break;
                if (FindAddress.matchHouseNumber(string, n) != null) {
                    if (n5 != 0 && n3 > 1) {
                        return -n;
                    }
                    n2 = n5;
                    bl2 = bl;
                    n9 = n6;
                    n8 = n7;
                    if (n6 == -1) {
                        n2 = n5;
                        bl2 = bl;
                        n9 = n;
                        n8 = n7;
                    }
                } else if (FindAddress.isValidLocationName(matcher.group(0))) {
                    n2 = 0;
                    bl2 = true;
                    n9 = n6;
                    n8 = n7;
                } else {
                    if (n4 == 5 && !bl) {
                        n = matcher.end();
                        break;
                    }
                    n2 = n7;
                    if (bl) {
                        n2 = n7;
                        if (n4 > 4) {
                            MatchResult matchResult = FindAddress.matchState(string, n);
                            n2 = n7;
                            if (matchResult != null) {
                                if (((String)object).equals("et") && matchResult.group(0).equals("al")) {
                                    n = matchResult.end();
                                    break;
                                }
                                object = sWordRe.matcher(string);
                                if (((Matcher)object).find(matchResult.end())) {
                                    n2 = n7;
                                    if (FindAddress.isValidZipCode(((Matcher)object).group(0), matchResult)) {
                                        return ((Matcher)object).end();
                                    }
                                } else {
                                    n2 = matchResult.end();
                                }
                            }
                        }
                    }
                    n = 0;
                    n8 = n2;
                    n9 = n6;
                    bl2 = bl;
                    n2 = n;
                }
                object = matcher.group(0);
                n = matcher.end();
                n5 = n2;
                bl = bl2;
                n6 = n9;
                n7 = n8;
                n2 = n;
            }
            if (n7 > 0) {
                return n7;
            }
            if (n6 > 0) return -n6;
            n6 = n;
            return -n6;
        }
        return -n;
    }

    private static boolean checkHouseNumber(String object) {
        int n;
        int n2 = 0;
        for (n = 0; n < ((String)object).length(); ++n) {
            int n3 = n2;
            if (Character.isDigit(((String)object).charAt(n))) {
                n3 = n2 + 1;
            }
            n2 = n3;
        }
        if (n2 > 5) {
            return false;
        }
        if (!((Matcher)(object = sSuffixedNumberRe.matcher((CharSequence)object))).find()) return true;
        n = Integer.parseInt(((Matcher)object).group(1));
        if (n == 0) {
            return false;
        }
        String string = ((Matcher)object).group(2).toLowerCase(Locale.getDefault());
        n2 = n % 10;
        object = "th";
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return string.equals("th");
                }
                if (n % 100 == 13) return string.equals(object);
                object = "rd";
                return string.equals(object);
            }
            if (n % 100 == 12) return string.equals(object);
            object = "nd";
            return string.equals(object);
        }
        if (n % 100 == 11) return string.equals(object);
        object = "st";
        return string.equals(object);
    }

    static String findAddress(String string) {
        Matcher matcher = sHouseNumberRe.matcher(string);
        int n = 0;
        while (matcher.find(n)) {
            if (FindAddress.checkHouseNumber(matcher.group(0))) {
                int n2 = matcher.start();
                n = FindAddress.attemptMatch(string, matcher);
                if (n > 0) {
                    return string.substring(n2, n);
                }
                n = -n;
                continue;
            }
            n = matcher.end();
        }
        return null;
    }

    public static boolean isValidLocationName(String string) {
        return sLocationNameRe.matcher(string).matches();
    }

    public static boolean isValidZipCode(String string) {
        return sZipCodeRe.matcher(string).matches();
    }

    public static boolean isValidZipCode(String string, String string2) {
        return FindAddress.isValidZipCode(string, FindAddress.matchState(string2, 0));
    }

    private static boolean isValidZipCode(String string, MatchResult matchResult) {
        int n;
        boolean bl = false;
        if (matchResult == null) {
            return false;
        }
        int n2 = matchResult.groupCount();
        while (true) {
            n = n2;
            if (n2 <= 0) break;
            n = n2 - 1;
            if (matchResult.group(n2) != null) break;
            n2 = n;
        }
        boolean bl2 = bl;
        if (!sZipCodeRe.matcher(string).matches()) return bl2;
        bl2 = bl;
        if (!sStateZipCodeRanges[n].matches(string)) return bl2;
        bl2 = true;
        return bl2;
    }

    public static MatchResult matchHouseNumber(String object, int n) {
        if (n > 0 && HOUSE_PRE_DELIM.indexOf(((String)object).charAt(n - 1)) == -1) {
            return null;
        }
        if (!((Matcher)(object = sHouseNumberRe.matcher((CharSequence)object).region(n, ((String)object).length()))).lookingAt()) return null;
        if (!FindAddress.checkHouseNumber((object = ((Matcher)object).toMatchResult()).group(0))) return null;
        return object;
    }

    public static MatchResult matchState(String object, int n) {
        Object var2_2 = null;
        if (n > 0 && WORD_DELIM.indexOf(((String)object).charAt(n - 1)) == -1) {
            return null;
        }
        Matcher matcher = sStateRe.matcher((CharSequence)object).region(n, ((String)object).length());
        object = var2_2;
        if (!matcher.lookingAt()) return object;
        object = matcher.toMatchResult();
        return object;
    }
}
