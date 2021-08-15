package lists.interfaces;

public interface ListDAT<T> {

  void appendEnd(T val);
  void appendEnd(ListDAT<T> val);
  void appendEnd(T[] val);

  void appendStart(T val);
  void appendStart(ListDAT<T> val);
  void appendStart(T[] val);

  T getAt(int index);
  int size();

  void clear();

  boolean contains(T val);
  boolean contains(T val, int startIndex);
  boolean contains(T val, int startIndex, int maxIndex);

  T[] toArray();


  String join(String separator);


}
