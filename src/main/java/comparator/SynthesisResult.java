package comparator;

public interface SynthesisResult<T extends Item<?>> extends ComparatorResult{
	DifferentResult<T> getDifferentResult();
	ComformityResult<T> getComformityResult();
}
