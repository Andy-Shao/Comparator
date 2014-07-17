package comparator.action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import andy.shao.util.ArrayTools;
import andy.shao.util.StringTools;

import comparator.DifferentResult;
import comparator.LineMsgFactory;
import comparator.Md5LineMessage;
import comparator.MessageComparator;
import comparator.impl.ReaderFile;

public class DifferentComparator {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
	private static final Log LOG = LogFactory.getLog(DifferentComparator.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		LOG.info("Comparating the files is starting!!");
		LOG.info("the file A is " + args[0]);
		LOG.info("the file B is " + args[1]);
		LOG.info("the comparator file is " + args[2]);
		String[] xmlPathes = new String[] { "classpath:comparator/action/differentComparator.xml", "classpath:init.xml" };
		xmlPathes = ArrayTools.mergeArray(String[].class, xmlPathes, StringTools.split(args[2], "#"));
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPathes);
		LineMsgFactory<String, Md5LineMessage> lineMsgFactory = context.getBean("lineMsgFactory", LineMsgFactory.class);
		MessageComparator<DifferentResult<Md5LineMessage>, Iterator<Md5LineMessage>, Iterator<Md5LineMessage>> messageComparator = context.getBean(
				"messageComparator", MessageComparator.class);
		Iterator<Md5LineMessage> dataA = new ReaderFile<Md5LineMessage>(new BufferedReader(new InputStreamReader(new FileInputStream(args[0]))), lineMsgFactory);
		Iterator<Md5LineMessage> dataB = new ReaderFile<Md5LineMessage>(new BufferedReader(new InputStreamReader(new FileInputStream(args[1]))), lineMsgFactory);

		DifferentResult<Md5LineMessage> differentResult = messageComparator.compare(dataA, dataB);

		LOG.info("onlyFileAHas size: " + differentResult.onlyFileAHas().size());
		LOG.info("onlyFileBHas Size: " + differentResult.onlyFileBHas().size());
		LOG.info("different size: " + differentResult.differences().size());

		if (PublicKey.EXPORT_DETAIL.constainKey()) {
			String onlyFileAHas = PublicKey.ONLY_FILE_A_HAS.constainKey() ? PublicKey.ONLY_FILE_A_HAS.getProperties() : getFileName(PublicKey.OUTPUT_PATH.getProperties() + "onlyFileAHas", ".dat");
			String onlyFileBHas = PublicKey.ONLY_FILE_B_HAS.constainKey() ? PublicKey.ONLY_FILE_B_HAS.getProperties() : getFileName(PublicKey.OUTPUT_PATH.getProperties() + "onlyFileBHas", ".dat");
			String different = PublicKey.DIFFERENT.constainKey() ? PublicKey.DIFFERENT.getProperties() : getFileName(PublicKey.OUTPUT_PATH.getProperties() + "different", ".dat");
			LOG.info("START export the different information.");
			LOG.info("Export onlyFileAHas to " + onlyFileAHas);
			DifferentComparator.wirteObject(differentResult.onlyFileAHas(), onlyFileAHas);
			LOG.info("Export onlyFileBHas to " + onlyFileBHas);
			DifferentComparator.wirteObject(differentResult.onlyFileBHas(), onlyFileBHas);
			LOG.info("Export different to " + different);
			DifferentComparator.wirteObject(differentResult.differences(), different);
			LOG.info("FINISHED export the different information.");
		}
		LOG.info("Comparating the files is finished!!");
	}

	public static String getFileName(String head, String ext) {
		return new StringBuilder(head).append(DATE_FORMAT.format(new Date())).append(ext).toString();
	}

	public static void serializable(Object object, OutputStream outputStream) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(object);
	}

	public static void wirteObject(Object object, String filePath) throws IOException {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			serializable(object, fileOutputStream);
		} finally {
			if (fileOutputStream != null) fileOutputStream.close();
		}
	}
}
