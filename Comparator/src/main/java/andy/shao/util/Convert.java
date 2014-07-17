package andy.shao.util;

public interface Convert<IN, OUT> {
	OUT convert(IN in);
	
	public static final Convert<Object, String> OBJ_2_STR = new Convert<Object, String>() {
		@Override
        public String convert(Object in) {
	        return Objects.toString(in);
        }
	}; 
}
