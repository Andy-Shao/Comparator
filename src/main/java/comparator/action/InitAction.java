package comparator.action;

import java.io.File;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class InitAction {
	private static final Log LOG = LogFactory.getLog(InitAction.class);

	public void init() {
		LOG.info("START init!!");

		formateKey(PublicKey.INPUT_PATH);
		formateKey(PublicKey.OUTPUT_PATH);
		formateKey(PublicKey.LOG_PATH);
		formateKey(PublicKey.BANKING_BOOK_OUTPUT);
		formateKey(PublicKey.TRADING_BOOK_OUTPUT);
		PublicKey.SEPARATOR_CHAR.setProperties(PublicKey.SEPARATOR_CHAR.getenv());

		// printSystemProperty();
		LOG.info("FINISH init!!");
	}

	static void printSystemProperty() {
		StringBuilder result = new StringBuilder();
		result.append("System properties:\n");
		result.append("**********************\n");
		for (Map.Entry<Object, Object> entry : System.getProperties().entrySet())
			result.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
		result.append("**********************");
		LOG.info(result);
	}

	public static void createDirectory(String directoryPath) {
		File file = new File(directoryPath);
		if (!file.exists() || !file.isDirectory()) file.mkdirs();
	}

	public static void formateKey(PublicKey publicKey){
		String key = publicKey.constainKeyInEnv() ? publicKey.getenv() : publicKey.getProperties();
		if(!key.endsWith(File.separator)) key = key + File.separator;
		createDirectory(key);
		publicKey.setProperties(key);
	}
}
