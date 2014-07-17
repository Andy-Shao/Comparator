package comparator;

public interface MessageComparator<E extends ComparatorResult, CHANNEL_A, CHANNEL_B> {

	E compare(CHANNEL_A channelA, CHANNEL_B channelB) throws CompareException;

	public static class CompareException extends RuntimeException {
		private static final long serialVersionUID = -4919876927424240150L;

		public CompareException() {
		}

		public CompareException(Throwable e) {
			super(e);
		}

		public CompareException(String message) {
			super(message);
		}

		public CompareException(String message, Throwable e) {
			super(message, e);
		}
	}
}
