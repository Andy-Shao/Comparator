package comparator;

public interface LineMsgFactory<INPUT, E extends Item<?>> {

	E buildLineMsg(INPUT input);
}
