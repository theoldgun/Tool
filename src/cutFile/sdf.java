package cutFile;

public class sdf {

		public static String isLimitedDecimalPlaces(String value, int limitNum) {

			if ( value.contains(".")) {
				String[] tmp = value.split("\\.");
				if (tmp.length == 2) {
					if (tmp[1].trim().length() >= 2)
						return "duoge douhao ";
				}
			}
			return "1weixiaoshu";
		}
		public static void main(String[] args) {
			String a = "qwqwd.asdf";
			String aa = isLimitedDecimalPlaces(a, 2);
			System.out.println(aa);
		}
}
