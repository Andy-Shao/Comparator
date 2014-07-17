package comparator;

public class Md5LineMsgFactory implements LineMsgFactory<String, Md5LineMessage> {

	@Override
	public Md5LineMessage buildLineMsg(String input) {
		return new Md5LineMessage(input);
	}

}
