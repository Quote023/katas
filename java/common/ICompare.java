package common;

public interface ICompare<T> {
    boolean run(T value, T next);
}
