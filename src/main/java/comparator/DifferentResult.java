package comparator;

import java.io.Serializable;
import java.util.List;

import andy.shao.util.Objects;

public interface DifferentResult<T extends Item<?>> extends ComparatorResult {

	List<T> onlyFileAHas();

	List<T> onlyFileBHas();

	List<LineCouple<T>> differences();

	static interface LineCouple<E extends Item<?>> {
		E getFileA();

		E getFileB();
	}

	@SuppressWarnings("serial")
	static class DefaultLineCouple<E extends Item<?>> implements LineCouple<E>, Serializable {
		private volatile E fileA;
		private volatile E fileB;

		public DefaultLineCouple(E fileA, E fileB) {
			this.fileA = fileA;
			this.fileB = fileB;
		}

		@Override
		public E getFileA() {
			return this.fileA;
		}

		@Override
		public E getFileB() {
			return this.fileB;
		}

		@Override
		public String toString() {
			return "DefaultLineCouple [fileA=" + fileA + ", fileB=" + fileB + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.fileA, this.fileB);
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof DefaultLineCouple) {
				DefaultLineCouple<E> that = (DefaultLineCouple<E>) obj;
				return Objects.equals(this.fileA, that.fileA) && Objects.equals(this.fileB, that.fileB);
			}

			return false;
		}
	}
}
