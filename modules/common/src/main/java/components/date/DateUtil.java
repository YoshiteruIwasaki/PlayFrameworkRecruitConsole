package components.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
	public static DateFormat getFormat(String fmt) {
		return new SimpleDateFormat(fmt, new Locale("Asia/Tokyo"));
	}

	public static final long time = new Date().getTime();

	public static DateFormat getDateFormatJP() {
		return getFormat("yyyy年M月d日");
	}

	public static DateFormat getDateFormatWithDateJP() {
		SimpleDateFormat format = new SimpleDateFormat("M/d(E)", Locale.JAPAN);
		format.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		return format;
	}

	public static DateFormat getDateFormatWithHourJP() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年 M月 d日 H時 m分",
				Locale.JAPAN);
		format.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		return format;
	}

	public static String getLastDateStartString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy'年'MM'月'dd'日'");
		return simpleDateFormat.format(getLastDateStart());
	}

	public static DateFormat getDateFormat() {
		return getFormat("yyyy.MM.dd");
	}

	public static DateFormat getDateWithTimeFormat() {
		return getFormat("yyyy.MM.dd HH:mm");
	}

	public static DateFormat getDateDetailFormat() {
		return getFormat("yyyy.MM.dd HH:mm");
	}

	public static DateFormat getDateDaylFormat() {
		return getFormat("yyyy-MM-dd");
	}

	public static DateFormat getBirthDayDateFormat() {
		return getFormat("MM-dd");
	}

	public static String getTimestampString(Date date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf1.format(date);
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static Date getLastDateStart() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getPreviousDateStart() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getTodayStart() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getNextDay() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	public static int differenceDays(Date date1, Date date2) {
		long datetime1 = date1.getTime();
		long datetime2 = date2.getTime();
		long one_date_time = 1000 * 60 * 60 * 24;
		long diffDays = (datetime1 - datetime2) / one_date_time;
		return (int) diffDays;
	}

	public static String getTimelineDate() {
		Date date = new Date();
		return getDateFormat().format(date);
	}

	public static String getTimelineDateDetail() {
		Date date = new Date();
		return getDateDetailFormat().format(date);
	}

	public static Date getDayStartTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Calendar toCalendar(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static String makeTwitterDate(Date date) {
		Date now = new Date();
		Long diff = now.getTime() - date.getTime();

		if (diff < 1000 * 60) { // 1分未満
			return Math.round(diff / 1000) + "秒前";
		} else if (diff < 1000 * 60 * 60) { // １時間未満
			return Math.round(diff / (1000 * 60)) + "分前";
		} else if (diff < 1000 * 60 * 60 * 24) { // 一日未満
			return "約" + Math.round(diff / (1000 * 60 * 60)) + "時間前";
		} else { // 一日以上

			Calendar calendar = DateUtil.toCalendar(date);
			Calendar now_calendar = DateUtil.toCalendar(now);

			// 時
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			String ampm = "午前";
			if (hour > 12) {
				hour = hour - 12;
				ampm = "午後";
			}
			String suffix_hour = "時";
			// 分
			int minutes = calendar.get(Calendar.MINUTE);
			String suffix_min = "分";
			// 日
			int day = calendar.get(Calendar.DATE);
			String suffix_day = "日";
			// 曜日
			String day_of_week = "";
			switch (calendar.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				day_of_week = "(日)";
				break;
			case Calendar.MONDAY:
				day_of_week = "(月)";
				break;
			case Calendar.TUESDAY:
				day_of_week = "(火)";
				break;
			case Calendar.WEDNESDAY:
				day_of_week = "(水)";
				break;
			case Calendar.THURSDAY:
				day_of_week = "(木)";
				break;
			case Calendar.FRIDAY:
				day_of_week = "(金)";
				break;
			case Calendar.SATURDAY:
				day_of_week = "(土)";
				break;
			default:
				break;
			}
			// 月
			int month = calendar.get(Calendar.MONTH) + 1;
			String suffix_month = "月";
			// 年が違ったら年も表示
			String suffix_year = "年";
			int year;
			if (now_calendar.get(Calendar.YEAR) != calendar.get(Calendar.YEAR)) {
				year = calendar.get(Calendar.YEAR);
				return year + suffix_year + month + suffix_month + day
						+ suffix_day + day_of_week + " " + ampm + hour
						+ suffix_hour + minutes + suffix_min;
			}
			return month + suffix_month + day + suffix_day + day_of_week + " "
					+ ampm + hour + suffix_hour + minutes + suffix_min;
		}
	}
}
