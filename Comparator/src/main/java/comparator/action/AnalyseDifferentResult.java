package comparator.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import andy.shao.util.ArrayTools;

import comparator.Md5LineMessage;
import comparator.DifferentResult.LineCouple;
import comparator.analyse.DifferentElement;
import comparator.analyse.DifferentResultVisitor;
import comparator.analyse.OnlyFileAHasElement;
import comparator.analyse.OnlyFileBHasElement;

public class AnalyseDifferentResult {
	private static final Log LOG = LogFactory.getLog(AnalyseDifferentResult.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		LOG.info("START analyse the information.");
		LOG.info("file path is:" + args[0]);
		LOG.info("file type is: " + args[1]);
		String[] xmlPathes = new String[] { "classpath:init.xml" };
		xmlPathes = ArrayTools.mergeArray(String[].class, xmlPathes , args[2].split("#"));
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathes);
		final String filePath = args[0];
		final String type = args[1];
		InputStream inputStream = null;
		Object object = null;
		try {
			inputStream = new FileInputStream(filePath);
			object = AnalyseDifferentResult.readObject(inputStream);
		} finally {
			if (inputStream != null) inputStream.close();
		}

		final DifferentElement<Md5LineMessage> differentElement = new DifferentElement<Md5LineMessage>(null);
		final OnlyFileAHasElement<Md5LineMessage> onlyFileAHasElement = new OnlyFileAHasElement<Md5LineMessage>(null);
		final OnlyFileBHasElement<Md5LineMessage> onlyFileBHasElement = new OnlyFileBHasElement<Md5LineMessage>(null);
		final DifferentResultVisitor<Md5LineMessage> visitor = applicationContext.getBean("analyseDifferentResultVisitor", DifferentResultVisitor.class);

		if (type.equals("onlyFileAHas")) {
			onlyFileAHasElement.setValue((List<Md5LineMessage>) object);
			visitor.visit(onlyFileAHasElement);
		} else if (type.equals("onlyFileBHas")) {
			onlyFileBHasElement.setValue((List<Md5LineMessage>) object);
			visitor.visit(onlyFileBHasElement);
		} else if (type.equals("different")) {
			differentElement.setValue((List<LineCouple<Md5LineMessage>>) object);
			visitor.visit(differentElement);
		}
		LOG.info("FINISH analyse the information");
	}

	public static Object readObject(InputStream inputStream) throws IOException, ClassNotFoundException {
    	ObjectInputStream objectInputStream = null;
    	try {
    		objectInputStream = new ObjectInputStream(inputStream);
    		return objectInputStream.readObject();
    	} finally {
    		if (objectInputStream != null) objectInputStream.close();
    	}
    }
}
