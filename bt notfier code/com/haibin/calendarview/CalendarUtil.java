/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.LunarCalendar
 */
package com.haibin.calendarview;

import android.content.Context;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.LunarCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

final class CalendarUtil {
    private static final long ONE_DAY = 86400000L;

    CalendarUtil() {
    }

    static int compareTo(int n, int n2, int n3, int n4, int n5, int n6) {
        Calendar calendar = new Calendar();
        calendar.setYear(n);
        calendar.setMonth(n2);
        calendar.setDay(n3);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(n4);
        calendar2.setMonth(n5);
        calendar2.setDay(n6);
        return calendar.compareTo(calendar2);
    }

    static int differ(Calendar calendar, Calendar calendar2) {
        if (calendar == null) {
            return Integer.MIN_VALUE;
        }
        if (calendar2 == null) {
            return Integer.MAX_VALUE;
        }
        java.util.Calendar calendar3 = java.util.Calendar.getInstance();
        calendar3.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        long l = calendar3.getTimeInMillis();
        calendar3.set(calendar2.getYear(), calendar2.getMonth() - 1, calendar2.getDay());
        return (int)((l - calendar3.getTimeInMillis()) / 86400000L);
    }

    static int dipToPx(Context context, float f) {
        return (int)(f * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    static int getDate(String string, Date date) {
        return Integer.parseInt(new SimpleDateFormat(string).format(date));
    }

    static Calendar getFirstCalendarFromMonthViewPager(int n, CalendarViewDelegate calendarViewDelegate) {
        Calendar calendar;
        Calendar calendar2 = new Calendar();
        int n2 = calendarViewDelegate.getMinYearMonth();
        boolean bl = true;
        calendar2.setYear((n2 + n - 1) / 12 + calendarViewDelegate.getMinYear());
        calendar2.setMonth((n + calendarViewDelegate.getMinYearMonth() - 1) % 12 + 1);
        if (calendarViewDelegate.getDefaultCalendarSelectDay() != 0) {
            n = CalendarUtil.getMonthDaysCount(calendar2.getYear(), calendar2.getMonth());
            calendar = calendarViewDelegate.mIndexCalendar;
            if (calendar != null && calendar.getDay() != 0) {
                if (n >= calendar.getDay()) {
                    n = calendar.getDay();
                }
            } else {
                n = 1;
            }
            calendar2.setDay(n);
        } else {
            calendar2.setDay(1);
        }
        calendar = calendar2;
        if (!CalendarUtil.isCalendarInRange(calendar2, calendarViewDelegate)) {
            calendar = CalendarUtil.isMinRangeEdge(calendar2, calendarViewDelegate) ? calendarViewDelegate.getMinRangeCalendar() : calendarViewDelegate.getMaxRangeCalendar();
        }
        if (calendar.getYear() != calendarViewDelegate.getCurrentDay().getYear() || calendar.getMonth() != calendarViewDelegate.getCurrentDay().getMonth()) {
            bl = false;
        }
        calendar.setCurrentMonth(bl);
        calendar.setCurrentDay(calendar.equals((Object)calendarViewDelegate.getCurrentDay()));
        LunarCalendar.setupLunarCalendar((Calendar)calendar);
        return calendar;
    }

    static Calendar getFirstCalendarStartWithMinCalendar(int n, int n2, int n3, int n4, int n5) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(n, n2 - 1, n3);
        long l = calendar.getTimeInMillis();
        l = (long)((n4 - 1) * 7) * 86400000L + l;
        calendar.setTimeInMillis(l);
        calendar.setTimeInMillis(l - (long)CalendarUtil.getWeekViewStartDiff(calendar.get(1), calendar.get(2) + 1, calendar.get(5), n5) * 86400000L);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(calendar.get(1));
        calendar2.setMonth(calendar.get(2) + 1);
        calendar2.setDay(calendar.get(5));
        return calendar2;
    }

    static int getMonthDaysCount(int n, int n2) {
        int n3 = n2 != 1 && n2 != 3 && n2 != 5 && n2 != 7 && n2 != 8 && n2 != 10 && n2 != 12 ? 0 : 31;
        if (n2 == 4 || n2 == 6 || n2 == 9 || n2 == 11) {
            n3 = 30;
        }
        if (n2 != 2) return n3;
        n3 = CalendarUtil.isLeapYear(n) ? 29 : 28;
        return n3;
    }

    static int getMonthEndDiff(int n, int n2, int n3) {
        return CalendarUtil.getMonthEndDiff(n, n2, CalendarUtil.getMonthDaysCount(n, n2), n3);
    }

    private static int getMonthEndDiff(int n, int n2, int n3, int n4) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(n, n2 - 1, n3);
        n = calendar.get(7);
        if (n4 == 1) {
            return 7 - n;
        }
        if (n4 == 2) {
            n = n == 1 ? 0 : 7 - n + 1;
            return n;
        }
        n = n == 7 ? 6 : 7 - n - 1;
        return n;
    }

    static int getMonthViewHeight(int n, int n2, int n3, int n4) {
        java.util.Calendar.getInstance().set(n, n2 - 1, 1);
        int n5 = CalendarUtil.getMonthViewStartDiff(n, n2, n4);
        int n6 = CalendarUtil.getMonthDaysCount(n, n2);
        return (n5 + n6 + CalendarUtil.getMonthEndDiff(n, n2, n6, n4)) / 7 * n3;
    }

    static int getMonthViewHeight(int n, int n2, int n3, int n4, int n5) {
        if (n5 != 0) return CalendarUtil.getMonthViewHeight(n, n2, n3, n4);
        return n3 * 6;
    }

    static int getMonthViewLineCount(int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            return 6;
        }
        n4 = CalendarUtil.getMonthEndDiff(n, n2, n3);
        return (CalendarUtil.getMonthViewStartDiff(n, n2, n3) + CalendarUtil.getMonthDaysCount(n, n2) + n4) / 7;
    }

    static int getMonthViewStartDiff(int n, int n2, int n3) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(n, n2 - 1, 1);
        n2 = calendar.get(7);
        if (n3 == 1) {
            return n2 - 1;
        }
        if (n3 != 2) {
            n = n2;
            if (n2 != 7) return n;
            n = 0;
            return n;
        }
        n = n2 == 1 ? 6 : n2 - n3;
        return n;
    }

    static int getMonthViewStartDiff(Calendar calendar, int n) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, 1);
        int n2 = calendar2.get(7);
        if (n == 1) {
            return n2 - 1;
        }
        if (n != 2) {
            n = n2;
            if (n2 != 7) return n;
            n = 0;
            return n;
        }
        n = n2 == 1 ? 6 : n2 - n;
        return n;
    }

    static Calendar getNextCalendar(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        calendar2.setTimeInMillis(calendar2.getTimeInMillis() + 86400000L);
        calendar = new Calendar();
        calendar.setYear(calendar2.get(1));
        calendar.setMonth(calendar2.get(2) + 1);
        calendar.setDay(calendar2.get(5));
        return calendar;
    }

    static Calendar getPreCalendar(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        calendar2.setTimeInMillis(calendar2.getTimeInMillis() - 86400000L);
        calendar = new Calendar();
        calendar.setYear(calendar2.get(1));
        calendar.setMonth(calendar2.get(2) + 1);
        calendar.setDay(calendar2.get(5));
        return calendar;
    }

    static Calendar getRangeEdgeCalendar(Calendar calendar, CalendarViewDelegate calendarViewDelegate) {
        if (CalendarUtil.isCalendarInRange(calendarViewDelegate.getCurrentDay(), calendarViewDelegate) && calendarViewDelegate.getDefaultCalendarSelectDay() != 2) {
            return calendarViewDelegate.createCurrentDate();
        }
        if (CalendarUtil.isCalendarInRange(calendar, calendarViewDelegate)) {
            return calendar;
        }
        if (!calendarViewDelegate.getMinRangeCalendar().isSameMonth(calendar)) return calendarViewDelegate.getMaxRangeCalendar();
        return calendarViewDelegate.getMinRangeCalendar();
    }

    static List<Calendar> getWeekCalendars(Calendar calendar, CalendarViewDelegate calendarViewDelegate) {
        int n;
        long l = calendar.getTimeInMillis();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        int n2 = calendar2.get(7);
        if (calendarViewDelegate.getWeekStart() == 1) {
            n = n2 - 1;
        } else if (calendarViewDelegate.getWeekStart() == 2) {
            n = n2 == 1 ? 6 : n2 - calendarViewDelegate.getWeekStart();
        } else {
            n = n2;
            if (n2 == 7) {
                n = 0;
            }
        }
        long l2 = n;
        calendar2 = java.util.Calendar.getInstance();
        calendar2.setTimeInMillis(l - l2 * 86400000L);
        calendar = new Calendar();
        calendar.setYear(calendar2.get(1));
        calendar.setMonth(calendar2.get(2) + 1);
        calendar.setDay(calendar2.get(5));
        return CalendarUtil.initCalendarForWeekView(calendar, calendarViewDelegate, calendarViewDelegate.getWeekStart());
    }

    static int getWeekCountBetweenBothCalendar(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(n, n2 - 1, n3);
        long l = calendar.getTimeInMillis();
        n = CalendarUtil.getWeekViewStartDiff(n, n2, n3, n7);
        calendar.set(n4, n5 - 1, n6);
        long l2 = calendar.getTimeInMillis();
        return (n + CalendarUtil.getWeekViewEndDiff(n4, n5, n6, n7) + ((int)((l2 - l) / 86400000L) + 1)) / 7;
    }

    static int getWeekFormCalendar(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        return calendar2.get(7) - 1;
    }

    static int getWeekFromCalendarStartWithMinCalendar(Calendar calendar, int n, int n2, int n3, int n4) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(n, n2 - 1, n3);
        long l = calendar2.getTimeInMillis();
        n2 = CalendarUtil.getWeekViewStartDiff(n, n2, n3, n4);
        n = CalendarUtil.getWeekViewStartDiff(calendar.getYear(), calendar.getMonth(), calendar.getDay(), n4);
        n4 = calendar.getYear();
        n3 = calendar.getMonth();
        n = n == 0 ? calendar.getDay() + 1 : calendar.getDay();
        calendar2.set(n4, n3 - 1, n);
        return (n2 + (int)((calendar2.getTimeInMillis() - l) / 86400000L)) / 7 + 1;
    }

    static int getWeekFromDayInMonth(Calendar calendar, int n) {
        java.util.Calendar.getInstance().set(calendar.getYear(), calendar.getMonth() - 1, 1);
        n = CalendarUtil.getMonthViewStartDiff(calendar, n);
        return (calendar.getDay() + n - 1) / 7 + 1;
    }

    private static int getWeekViewEndDiff(int n, int n2, int n3, int n4) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(n, n2 - 1, n3);
        n = calendar.get(7);
        if (n4 == 1) {
            return 7 - n;
        }
        if (n4 == 2) {
            n = n == 1 ? 0 : 7 - n + 1;
            return n;
        }
        n = n == 7 ? 6 : 7 - n - 1;
        return n;
    }

    static int getWeekViewIndexFromCalendar(Calendar calendar, int n) {
        return CalendarUtil.getWeekViewStartDiff(calendar.getYear(), calendar.getMonth(), calendar.getDay(), n);
    }

    private static int getWeekViewStartDiff(int n, int n2, int n3, int n4) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(n, n2 - 1, n3);
        n2 = calendar.get(7);
        if (n4 == 1) {
            return n2 - 1;
        }
        if (n4 != 2) {
            n = n2;
            if (n2 != 7) return n;
            n = 0;
            return n;
        }
        n = n2 == 1 ? 6 : n2 - n4;
        return n;
    }

    static List<Calendar> initCalendarForMonthView(int n, int n2, Calendar calendar, int n3) {
        int n4;
        int n5;
        int n6;
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        int n7 = n2 - 1;
        calendar2.set(n, n7, 1);
        int n8 = CalendarUtil.getMonthViewStartDiff(n, n2, n3);
        int n9 = CalendarUtil.getMonthDaysCount(n, n2);
        ArrayList<Calendar> arrayList = new ArrayList<Calendar>();
        int n10 = 12;
        int n11 = 0;
        if (n2 == 1) {
            n7 = n - 1;
            n3 = n8 == 0 ? 0 : CalendarUtil.getMonthDaysCount(n7, 12);
            n6 = n3;
            n5 = n2 + 1;
            n4 = n;
            n3 = n7;
            n7 = n10;
            n10 = n5;
        } else if (n2 == 12) {
            n3 = n8 == 0 ? 0 : CalendarUtil.getMonthDaysCount(n, n7);
            n4 = n + 1;
            n6 = n3;
            n10 = 1;
            n3 = n;
        } else {
            n3 = n8 == 0 ? 0 : CalendarUtil.getMonthDaysCount(n, n7);
            n6 = n3;
            n3 = n;
            n10 = n2 + 1;
            n4 = n3;
        }
        n5 = 1;
        while (n11 < 42) {
            calendar2 = new Calendar();
            if (n11 < n8) {
                calendar2.setYear(n3);
                calendar2.setMonth(n7);
                calendar2.setDay(n6 - n8 + n11 + 1);
            } else if (n11 >= n9 + n8) {
                calendar2.setYear(n4);
                calendar2.setMonth(n10);
                calendar2.setDay(n5);
                ++n5;
            } else {
                calendar2.setYear(n);
                calendar2.setMonth(n2);
                calendar2.setCurrentMonth(true);
                calendar2.setDay(n11 - n8 + 1);
            }
            if (calendar2.equals(calendar)) {
                calendar2.setCurrentDay(true);
            }
            LunarCalendar.setupLunarCalendar((Calendar)calendar2);
            arrayList.add((Calendar)calendar2);
            ++n11;
        }
        return arrayList;
    }

    static List<Calendar> initCalendarForWeekView(Calendar object, CalendarViewDelegate calendarViewDelegate, int n) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(object.getYear(), object.getMonth() - 1, object.getDay());
        long l = calendar.getTimeInMillis();
        int n2 = CalendarUtil.getWeekViewEndDiff(object.getYear(), object.getMonth(), object.getDay(), n);
        object = new ArrayList();
        calendar.setTimeInMillis(l);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(calendar.get(1));
        calendar2.setMonth(calendar.get(2) + 1);
        calendar2.setDay(calendar.get(5));
        if (calendar2.equals((Object)calendarViewDelegate.getCurrentDay())) {
            calendar2.setCurrentDay(true);
        }
        LunarCalendar.setupLunarCalendar((Calendar)calendar2);
        calendar2.setCurrentMonth(true);
        object.add(calendar2);
        n = 1;
        while (n <= n2) {
            calendar.setTimeInMillis((long)n * 86400000L + l);
            calendar2 = new Calendar();
            calendar2.setYear(calendar.get(1));
            calendar2.setMonth(calendar.get(2) + 1);
            calendar2.setDay(calendar.get(5));
            if (calendar2.equals((Object)calendarViewDelegate.getCurrentDay())) {
                calendar2.setCurrentDay(true);
            }
            LunarCalendar.setupLunarCalendar((Calendar)calendar2);
            calendar2.setCurrentMonth(true);
            object.add(calendar2);
            ++n;
        }
        return object;
    }

    static boolean isCalendarInRange(Calendar calendar, int n, int n2, int n3, int n4, int n5, int n6) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        boolean bl = true;
        calendar2.set(n, n2 - 1, n3);
        long l = calendar2.getTimeInMillis();
        calendar2.set(n4, n5 - 1, n6);
        long l2 = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        long l3 = calendar2.getTimeInMillis();
        if (l3 >= l && l3 <= l2) return bl;
        bl = false;
        return bl;
    }

    static boolean isCalendarInRange(Calendar calendar, CalendarViewDelegate calendarViewDelegate) {
        return CalendarUtil.isCalendarInRange(calendar, calendarViewDelegate.getMinYear(), calendarViewDelegate.getMinYearMonth(), calendarViewDelegate.getMinYearDay(), calendarViewDelegate.getMaxYear(), calendarViewDelegate.getMaxYearMonth(), calendarViewDelegate.getMaxYearDay());
    }

    static boolean isLeapYear(int n) {
        boolean bl = n % 4 == 0 && n % 100 != 0 || n % 400 == 0;
        return bl;
    }

    private static boolean isMinRangeEdge(Calendar calendar, CalendarViewDelegate calendarViewDelegate) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        int n = calendarViewDelegate.getMinYear();
        int n2 = calendarViewDelegate.getMinYearMonth();
        boolean bl = true;
        calendar2.set(n, n2 - 1, calendarViewDelegate.getMinYearDay());
        long l = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        if (calendar2.getTimeInMillis() < l) return bl;
        bl = false;
        return bl;
    }

    static boolean isMonthInRange(int n, int n2, int n3, int n4, int n5, int n6) {
        boolean bl = !(n < n3 || n > n5 || n == n3 && n2 < n4 || n == n5 && n2 > n6);
        return bl;
    }

    static boolean isWeekend(Calendar calendar) {
        int n = CalendarUtil.getWeekFormCalendar(calendar);
        boolean bl = n == 0 || n == 6;
        return bl;
    }
}
