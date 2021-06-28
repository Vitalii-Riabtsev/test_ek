package com.rv.ek.nutrition;

import com.rv.ek.nutrition.models.WeekDay;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class NutritionHelper {
    public static Date getTomorrowDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
}
