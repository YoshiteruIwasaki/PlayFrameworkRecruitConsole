package utils.base;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import play.Logger;
import play.db.DB;

public class EbeanUtil {

	public static String getDatabase() {
		try {
			DataSource dataSource = DB.getDataSource();
			Connection connection2 = dataSource.getConnection();
			DatabaseMetaData metaData = connection2.getMetaData();
			return metaData.getDatabaseProductName();
		} catch (SQLException e) {
			Logger.error("EbeanUtil.getDatabase", e);
		}
		return "";
	}

	public static boolean isMySQL() {
		return "mysql".equalsIgnoreCase(getDatabase()) ? true : false;
	}

	public static boolean isPostgreSQL() {
		return "postgresql".equalsIgnoreCase(getDatabase()) ? true : false;
	}

	public static String getRandom() {
		if (isMySQL()) {
			return "RAND()";
		} else if (isPostgreSQL()) {
			return "RANDOM()";
		}
		return "";
	}
}
