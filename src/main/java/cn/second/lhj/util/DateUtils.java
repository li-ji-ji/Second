package cn.second.lhj.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date yesterday(Date today) {
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = c.getTime();//这是昨天
		return yesterday;
	}
}
