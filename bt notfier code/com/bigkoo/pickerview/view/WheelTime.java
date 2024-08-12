/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.bigkoo.pickerview.R$id
 *  com.bigkoo.pickerview.R$string
 *  com.bigkoo.pickerview.adapter.ArrayWheelAdapter
 *  com.bigkoo.pickerview.adapter.NumericWheelAdapter
 *  com.bigkoo.pickerview.listener.ISelectTimeCallback
 *  com.bigkoo.pickerview.utils.ChinaDate
 *  com.bigkoo.pickerview.utils.LunarCalendar
 *  com.contrarywind.adapter.WheelAdapter
 *  com.contrarywind.listener.OnItemSelectedListener
 *  com.contrarywind.view.WheelView
 *  com.contrarywind.view.WheelView$DividerType
 */
package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.adapter.NumericWheelAdapter;
import com.bigkoo.pickerview.listener.ISelectTimeCallback;
import com.bigkoo.pickerview.utils.ChinaDate;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class WheelTime {
    private static final int DEFAULT_END_DAY = 31;
    private static final int DEFAULT_END_MONTH = 12;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_DAY = 1;
    private static final int DEFAULT_START_MONTH = 1;
    private static final int DEFAULT_START_YEAR = 1900;
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int currentYear;
    private int dividerColor;
    private WheelView.DividerType dividerType;
    private int endDay = 31;
    private int endMonth = 12;
    private int endYear = 2100;
    private int gravity;
    private boolean isLunarCalendar = false;
    private float lineSpacingMultiplier;
    private ISelectTimeCallback mSelectChangeCallback;
    private int startDay = 1;
    private int startMonth = 1;
    private int startYear = 1900;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private boolean[] type;
    private View view;
    private WheelView wv_day;
    private WheelView wv_hours;
    private WheelView wv_minutes;
    private WheelView wv_month;
    private WheelView wv_seconds;
    private WheelView wv_year;

    public WheelTime(View view, boolean[] blArray, int n, int n2) {
        this.view = view;
        this.type = blArray;
        this.gravity = n;
        this.textSize = n2;
    }

    static /* synthetic */ int access$000(WheelTime wheelTime) {
        return wheelTime.startYear;
    }

    static /* synthetic */ WheelView access$100(WheelTime wheelTime) {
        return wheelTime.wv_month;
    }

    static /* synthetic */ int access$1000(WheelTime wheelTime) {
        return wheelTime.endDay;
    }

    static /* synthetic */ void access$1100(WheelTime wheelTime, int n, int n2, int n3, int n4, List list, List list2) {
        wheelTime.setReDay(n, n2, n3, n4, list, list2);
    }

    static /* synthetic */ WheelView access$200(WheelTime wheelTime) {
        return wheelTime.wv_day;
    }

    static /* synthetic */ ISelectTimeCallback access$300(WheelTime wheelTime) {
        return wheelTime.mSelectChangeCallback;
    }

    static /* synthetic */ WheelView access$400(WheelTime wheelTime) {
        return wheelTime.wv_year;
    }

    static /* synthetic */ int access$500(WheelTime wheelTime) {
        return wheelTime.currentYear;
    }

    static /* synthetic */ int access$502(WheelTime wheelTime, int n) {
        wheelTime.currentYear = n;
        return n;
    }

    static /* synthetic */ int access$600(WheelTime wheelTime) {
        return wheelTime.endYear;
    }

    static /* synthetic */ int access$700(WheelTime wheelTime) {
        return wheelTime.startMonth;
    }

    static /* synthetic */ int access$800(WheelTime wheelTime) {
        return wheelTime.endMonth;
    }

    static /* synthetic */ int access$900(WheelTime wheelTime) {
        return wheelTime.startDay;
    }

    /*
     * Unable to fully structure code
     */
    private String getLunarTime() {
        block4: {
            block3: {
                block2: {
                    var5_1 = new StringBuilder();
                    var2_2 = this.wv_year.getCurrentItem() + this.startYear;
                    if (ChinaDate.leapMonth((int)var2_2) != 0) break block2;
                    var1_3 = this.wv_month.getCurrentItem();
                    break block3;
                }
                if (this.wv_month.getCurrentItem() + 1 - ChinaDate.leapMonth((int)var2_2) > 0) break block4;
                var1_3 = this.wv_month.getCurrentItem();
            }
            ++var1_3;
            ** GOTO lbl18
        }
        if (this.wv_month.getCurrentItem() + 1 - ChinaDate.leapMonth((int)var2_2) == 1) {
            var1_3 = this.wv_month.getCurrentItem();
            var3_4 = true;
        } else {
            var1_3 = this.wv_month.getCurrentItem();
lbl18:
            // 2 sources

            var3_4 = false;
        }
        var4_5 = LunarCalendar.lunarToSolar((int)var2_2, (int)var1_3, (int)(this.wv_day.getCurrentItem() + 1), (boolean)var3_4);
        var5_1.append(var4_5[0]);
        var5_1.append("-");
        var5_1.append(var4_5[1]);
        var5_1.append("-");
        var5_1.append(var4_5[2]);
        var5_1.append(" ");
        var5_1.append(this.wv_hours.getCurrentItem());
        var5_1.append(":");
        var5_1.append(this.wv_minutes.getCurrentItem());
        var5_1.append(":");
        var5_1.append(this.wv_seconds.getCurrentItem());
        return var5_1.toString();
    }

    private void setChangedListener(WheelView wheelView) {
        if (this.mSelectChangeCallback == null) return;
        wheelView.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void setContentTextSize() {
        this.wv_day.setTextSize((float)this.textSize);
        this.wv_month.setTextSize((float)this.textSize);
        this.wv_year.setTextSize((float)this.textSize);
        this.wv_hours.setTextSize((float)this.textSize);
        this.wv_minutes.setTextSize((float)this.textSize);
        this.wv_seconds.setTextSize((float)this.textSize);
    }

    private void setDividerColor() {
        this.wv_day.setDividerColor(this.dividerColor);
        this.wv_month.setDividerColor(this.dividerColor);
        this.wv_year.setDividerColor(this.dividerColor);
        this.wv_hours.setDividerColor(this.dividerColor);
        this.wv_minutes.setDividerColor(this.dividerColor);
        this.wv_seconds.setDividerColor(this.dividerColor);
    }

    private void setDividerType() {
        this.wv_day.setDividerType(this.dividerType);
        this.wv_month.setDividerType(this.dividerType);
        this.wv_year.setDividerType(this.dividerType);
        this.wv_hours.setDividerType(this.dividerType);
        this.wv_minutes.setDividerType(this.dividerType);
        this.wv_seconds.setDividerType(this.dividerType);
    }

    private void setLineSpacingMultiplier() {
        this.wv_day.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_month.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_year.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_hours.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_minutes.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_seconds.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    private void setLunar(int n, int n2, int n3, boolean bl, int n4, int n5, int n6) {
        WheelView wheelView;
        this.wv_year = wheelView = (WheelView)this.view.findViewById(R.id.year);
        wheelView.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getYears((int)this.startYear, (int)this.endYear)));
        this.wv_year.setLabel("");
        this.wv_year.setCurrentItem(n - this.startYear);
        this.wv_year.setGravity(this.gravity);
        this.wv_month = wheelView = (WheelView)this.view.findViewById(R.id.month);
        wheelView.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getMonths((int)n)));
        this.wv_month.setLabel("");
        n6 = ChinaDate.leapMonth((int)n);
        if (n6 != 0 && (n2 > n6 - 1 || bl)) {
            this.wv_month.setCurrentItem(n2 + 1);
        } else {
            this.wv_month.setCurrentItem(n2);
        }
        this.wv_month.setGravity(this.gravity);
        this.wv_day = (WheelView)this.view.findViewById(R.id.day);
        if (ChinaDate.leapMonth((int)n) == 0) {
            this.wv_day.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.monthDays((int)n, (int)n2))));
        } else {
            this.wv_day.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.leapDays((int)n))));
        }
        this.wv_day.setLabel("");
        this.wv_day.setCurrentItem(n3 - 1);
        this.wv_day.setGravity(this.gravity);
        this.wv_hours = wheelView = (WheelView)this.view.findViewById(R.id.hour);
        n2 = 0;
        wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(0, 23));
        this.wv_hours.setCurrentItem(n4);
        this.wv_hours.setGravity(this.gravity);
        this.wv_minutes = wheelView = (WheelView)this.view.findViewById(R.id.min);
        wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(0, 59));
        this.wv_minutes.setCurrentItem(n5);
        this.wv_minutes.setGravity(this.gravity);
        this.wv_seconds = wheelView = (WheelView)this.view.findViewById(R.id.second);
        wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(0, 59));
        this.wv_seconds.setCurrentItem(n5);
        this.wv_seconds.setGravity(this.gravity);
        this.wv_year.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
        this.wv_month.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
        this.setChangedListener(this.wv_day);
        this.setChangedListener(this.wv_hours);
        this.setChangedListener(this.wv_minutes);
        this.setChangedListener(this.wv_seconds);
        boolean[] blArray = this.type;
        if (blArray.length != 6) throw new RuntimeException("type[] length is not 6");
        wheelView = this.wv_year;
        n = blArray[0] ? 0 : 8;
        wheelView.setVisibility(n);
        wheelView = this.wv_month;
        n = this.type[1] ? 0 : 8;
        wheelView.setVisibility(n);
        wheelView = this.wv_day;
        n = this.type[2] ? 0 : 8;
        wheelView.setVisibility(n);
        wheelView = this.wv_hours;
        n = this.type[3] ? 0 : 8;
        wheelView.setVisibility(n);
        wheelView = this.wv_minutes;
        n = this.type[4] ? 0 : 8;
        wheelView.setVisibility(n);
        wheelView = this.wv_seconds;
        n = this.type[5] ? n2 : 8;
        wheelView.setVisibility(n);
        this.setContentTextSize();
    }

    private void setReDay(int n, int n2, int n3, int n4, List<String> list, List<String> list2) {
        int n5 = this.wv_day.getCurrentItem();
        if (list.contains(String.valueOf(n2))) {
            n = n4;
            if (n4 > 31) {
                n = 31;
            }
            this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(n3, n));
        } else if (list2.contains(String.valueOf(n2))) {
            n = n4;
            if (n4 > 30) {
                n = 30;
            }
            this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(n3, n));
        } else if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
            n = n4;
            if (n4 > 29) {
                n = 29;
            }
            this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(n3, n));
        } else {
            n = n4;
            if (n4 > 28) {
                n = 28;
            }
            this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(n3, n));
        }
        if (n5 <= this.wv_day.getAdapter().getItemsCount() - 1) return;
        n = this.wv_day.getAdapter().getItemsCount();
        this.wv_day.setCurrentItem(n - 1);
    }

    private void setSolar(int n, int n2, int n3, int n4, int n5, int n6) {
        WheelView wheelView;
        WheelView wheelView2 = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        Object object = Arrays.asList("4", "6", "9", "11");
        this.currentYear = n;
        this.wv_year = wheelView = (WheelView)this.view.findViewById(R.id.year);
        wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startYear, this.endYear));
        this.wv_year.setCurrentItem(n - this.startYear);
        this.wv_year.setGravity(this.gravity);
        this.wv_month = wheelView = (WheelView)this.view.findViewById(R.id.month);
        int n7 = this.startYear;
        int n8 = this.endYear;
        if (n7 == n8) {
            wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startMonth, this.endMonth));
            this.wv_month.setCurrentItem(n2 + 1 - this.startMonth);
        } else if (n == n7) {
            wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startMonth, 12));
            this.wv_month.setCurrentItem(n2 + 1 - this.startMonth);
        } else if (n == n8) {
            wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(1, this.endMonth));
            this.wv_month.setCurrentItem(n2);
        } else {
            wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(1, 12));
            this.wv_month.setCurrentItem(n2);
        }
        this.wv_month.setGravity(this.gravity);
        this.wv_day = (WheelView)this.view.findViewById(R.id.day);
        if (this.startYear == this.endYear && this.startMonth == this.endMonth) {
            if (wheelView2.contains(String.valueOf(++n2))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, this.endDay));
            } else if (object.contains(String.valueOf(n2))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, this.endDay));
            } else if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, this.endDay));
            } else {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, this.endDay));
            }
            this.wv_day.setCurrentItem(n3 - this.startDay);
        } else if (n == this.startYear && (n8 = n2 + 1) == this.startMonth) {
            if (wheelView2.contains(String.valueOf(n8))) {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, 31));
            } else if (object.contains(String.valueOf(n8))) {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, 30));
            } else if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, 29));
            } else {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(this.startDay, 28));
            }
            this.wv_day.setCurrentItem(n3 - this.startDay);
        } else if (n == this.endYear && (n8 = n2 + 1) == this.endMonth) {
            if (wheelView2.contains(String.valueOf(n8))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, this.endDay));
            } else if (object.contains(String.valueOf(n8))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, this.endDay));
            } else if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, this.endDay));
            } else {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, this.endDay));
            }
            this.wv_day.setCurrentItem(n3 - 1);
        } else {
            if (wheelView2.contains(String.valueOf(++n2))) {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, 31));
            } else if (object.contains(String.valueOf(n2))) {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, 30));
            } else if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, 29));
            } else {
                this.wv_day.setAdapter((WheelAdapter)new NumericWheelAdapter(1, 28));
            }
            this.wv_day.setCurrentItem(n3 - 1);
        }
        this.wv_day.setGravity(this.gravity);
        this.wv_hours = wheelView = (WheelView)this.view.findViewById(R.id.hour);
        n2 = 0;
        wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(0, 23));
        this.wv_hours.setCurrentItem(n4);
        this.wv_hours.setGravity(this.gravity);
        this.wv_minutes = wheelView = (WheelView)this.view.findViewById(R.id.min);
        wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(0, 59));
        this.wv_minutes.setCurrentItem(n5);
        this.wv_minutes.setGravity(this.gravity);
        this.wv_seconds = wheelView = (WheelView)this.view.findViewById(R.id.second);
        wheelView.setAdapter((WheelAdapter)new NumericWheelAdapter(0, 59));
        this.wv_seconds.setCurrentItem(n6);
        this.wv_seconds.setGravity(this.gravity);
        this.wv_year.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
        this.wv_month.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
        this.setChangedListener(this.wv_day);
        this.setChangedListener(this.wv_hours);
        this.setChangedListener(this.wv_minutes);
        this.setChangedListener(this.wv_seconds);
        object = this.type;
        if (((Object)object).length != 6) throw new IllegalArgumentException("type[] length is not 6");
        wheelView2 = this.wv_year;
        n = object[0] != false ? 0 : 8;
        wheelView2.setVisibility(n);
        object = this.wv_month;
        n = this.type[1] ? 0 : 8;
        object.setVisibility(n);
        object = this.wv_day;
        n = this.type[2] ? 0 : 8;
        object.setVisibility(n);
        object = this.wv_hours;
        n = this.type[3] ? 0 : 8;
        object.setVisibility(n);
        object = this.wv_minutes;
        n = this.type[4] ? 0 : 8;
        object.setVisibility(n);
        object = this.wv_seconds;
        n = this.type[5] ? n2 : 8;
        object.setVisibility(n);
        this.setContentTextSize();
    }

    private void setTextColorCenter() {
        this.wv_day.setTextColorCenter(this.textColorCenter);
        this.wv_month.setTextColorCenter(this.textColorCenter);
        this.wv_year.setTextColorCenter(this.textColorCenter);
        this.wv_hours.setTextColorCenter(this.textColorCenter);
        this.wv_minutes.setTextColorCenter(this.textColorCenter);
        this.wv_seconds.setTextColorCenter(this.textColorCenter);
    }

    private void setTextColorOut() {
        this.wv_day.setTextColorOut(this.textColorOut);
        this.wv_month.setTextColorOut(this.textColorOut);
        this.wv_year.setTextColorOut(this.textColorOut);
        this.wv_hours.setTextColorOut(this.textColorOut);
        this.wv_minutes.setTextColorOut(this.textColorOut);
        this.wv_seconds.setTextColorOut(this.textColorOut);
    }

    public int getEndYear() {
        return this.endYear;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public String getTime() {
        if (this.isLunarCalendar) {
            return this.getLunarTime();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.currentYear == this.startYear) {
            int n;
            int n2 = this.wv_month.getCurrentItem();
            if (n2 + (n = this.startMonth) == n) {
                stringBuilder.append(this.wv_year.getCurrentItem() + this.startYear);
                stringBuilder.append("-");
                stringBuilder.append(this.wv_month.getCurrentItem() + this.startMonth);
                stringBuilder.append("-");
                stringBuilder.append(this.wv_day.getCurrentItem() + this.startDay);
                stringBuilder.append(" ");
                stringBuilder.append(this.wv_hours.getCurrentItem());
                stringBuilder.append(":");
                stringBuilder.append(this.wv_minutes.getCurrentItem());
                stringBuilder.append(":");
                stringBuilder.append(this.wv_seconds.getCurrentItem());
            } else {
                stringBuilder.append(this.wv_year.getCurrentItem() + this.startYear);
                stringBuilder.append("-");
                stringBuilder.append(this.wv_month.getCurrentItem() + this.startMonth);
                stringBuilder.append("-");
                stringBuilder.append(this.wv_day.getCurrentItem() + 1);
                stringBuilder.append(" ");
                stringBuilder.append(this.wv_hours.getCurrentItem());
                stringBuilder.append(":");
                stringBuilder.append(this.wv_minutes.getCurrentItem());
                stringBuilder.append(":");
                stringBuilder.append(this.wv_seconds.getCurrentItem());
            }
        } else {
            stringBuilder.append(this.wv_year.getCurrentItem() + this.startYear);
            stringBuilder.append("-");
            stringBuilder.append(this.wv_month.getCurrentItem() + 1);
            stringBuilder.append("-");
            stringBuilder.append(this.wv_day.getCurrentItem() + 1);
            stringBuilder.append(" ");
            stringBuilder.append(this.wv_hours.getCurrentItem());
            stringBuilder.append(":");
            stringBuilder.append(this.wv_minutes.getCurrentItem());
            stringBuilder.append(":");
            stringBuilder.append(this.wv_seconds.getCurrentItem());
        }
        return stringBuilder.toString();
    }

    public View getView() {
        return this.view;
    }

    public void isCenterLabel(boolean bl) {
        this.wv_day.isCenterLabel(bl);
        this.wv_month.isCenterLabel(bl);
        this.wv_year.isCenterLabel(bl);
        this.wv_hours.isCenterLabel(bl);
        this.wv_minutes.isCenterLabel(bl);
        this.wv_seconds.isCenterLabel(bl);
    }

    public boolean isLunarMode() {
        return this.isLunarCalendar;
    }

    public void setCyclic(boolean bl) {
        this.wv_year.setCyclic(bl);
        this.wv_month.setCyclic(bl);
        this.wv_day.setCyclic(bl);
        this.wv_hours.setCyclic(bl);
        this.wv_minutes.setCyclic(bl);
        this.wv_seconds.setCyclic(bl);
    }

    public void setDividerColor(int n) {
        this.dividerColor = n;
        this.setDividerColor();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dividerType = dividerType;
        this.setDividerType();
    }

    public void setEndYear(int n) {
        this.endYear = n;
    }

    public void setLabels(String string2, String string3, String string4, String string5, String string6, String string7) {
        if (this.isLunarCalendar) {
            return;
        }
        if (string2 != null) {
            this.wv_year.setLabel(string2);
        } else {
            this.wv_year.setLabel(this.view.getContext().getString(R.string.pickerview_year));
        }
        if (string3 != null) {
            this.wv_month.setLabel(string3);
        } else {
            this.wv_month.setLabel(this.view.getContext().getString(R.string.pickerview_month));
        }
        if (string4 != null) {
            this.wv_day.setLabel(string4);
        } else {
            this.wv_day.setLabel(this.view.getContext().getString(R.string.pickerview_day));
        }
        if (string5 != null) {
            this.wv_hours.setLabel(string5);
        } else {
            this.wv_hours.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
        }
        if (string6 != null) {
            this.wv_minutes.setLabel(string6);
        } else {
            this.wv_minutes.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
        }
        if (string7 != null) {
            this.wv_seconds.setLabel(string7);
        } else {
            this.wv_seconds.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        this.setLineSpacingMultiplier();
    }

    public void setLunarMode(boolean bl) {
        this.isLunarCalendar = bl;
    }

    public void setPicker(int n, int n2, int n3) {
        this.setPicker(n, n2, n3, 0, 0, 0);
    }

    public void setPicker(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.isLunarCalendar) {
            int[] nArray = LunarCalendar.solarToLunar((int)n, (int)(n2 + 1), (int)n3);
            n = nArray[0];
            n2 = nArray[1];
            n3 = nArray[2];
            boolean bl = nArray[3] == 1;
            this.setLunar(n, n2 - 1, n3, bl, n4, n5, n6);
        } else {
            this.setSolar(n, n2, n3, n4, n5, n6);
        }
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int n = calendar2.get(1);
            int n2 = calendar2.get(2) + 1;
            int n3 = calendar2.get(5);
            int n4 = this.startYear;
            if (n > n4) {
                this.endYear = n;
                this.endMonth = n2;
                this.endDay = n3;
            } else {
                if (n != n4) return;
                n4 = this.startMonth;
                if (n2 > n4) {
                    this.endYear = n;
                    this.endMonth = n2;
                    this.endDay = n3;
                } else {
                    if (n2 != n4) return;
                    if (n3 <= this.startDay) return;
                    this.endYear = n;
                    this.endMonth = n2;
                    this.endDay = n3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int n = calendar.get(1);
            int n5 = calendar.get(2) + 1;
            int n6 = calendar.get(5);
            int n7 = this.endYear;
            if (n < n7) {
                this.startMonth = n5;
                this.startDay = n6;
                this.startYear = n;
            } else {
                if (n != n7) return;
                n7 = this.endMonth;
                if (n5 < n7) {
                    this.startMonth = n5;
                    this.startDay = n6;
                    this.startYear = n;
                } else {
                    if (n5 != n7) return;
                    if (n6 >= this.endDay) return;
                    this.startMonth = n5;
                    this.startDay = n6;
                    this.startYear = n;
                }
            }
        } else {
            if (calendar == null) return;
            if (calendar2 == null) return;
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.startMonth = calendar.get(2) + 1;
            this.endMonth = calendar2.get(2) + 1;
            this.startDay = calendar.get(5);
            this.endDay = calendar2.get(5);
        }
    }

    public void setSelectChangeCallback(ISelectTimeCallback iSelectTimeCallback) {
        this.mSelectChangeCallback = iSelectTimeCallback;
    }

    public void setStartYear(int n) {
        this.startYear = n;
    }

    public void setTextColorCenter(int n) {
        this.textColorCenter = n;
        this.setTextColorCenter();
    }

    public void setTextColorOut(int n) {
        this.textColorOut = n;
        this.setTextColorOut();
    }

    public void setTextXOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        this.wv_year.setTextXOffset(n);
        this.wv_month.setTextXOffset(n2);
        this.wv_day.setTextXOffset(n3);
        this.wv_hours.setTextXOffset(n4);
        this.wv_minutes.setTextXOffset(n5);
        this.wv_seconds.setTextXOffset(n6);
    }
}
