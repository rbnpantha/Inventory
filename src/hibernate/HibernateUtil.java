package hibernate;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static HibernateUtil instance = null;
	private static String configFile ="xml/hibernate.cfg.xml";
	private Configuration configuration = null;

	private HibernateUtil() {
		configuration = setConfiguration();

	}

	public static Configuration getConfiguration() {
		if (instance == null) {
			synchronized (HibernateUtil.class) {
				if (instance == null) {

					instance = new HibernateUtil();

				}

			}
		}

		return instance.configuration;

	}

	private Configuration setConfiguration() {
		Configuration cfg = null;
		cfg = new Configuration();
		cfg.configure(configFile);
		return cfg;

	}

}
