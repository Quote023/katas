package lists.interfaces;

import common.ICompare;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface ListDAT<T> {

  void appendEnd(T val);
  void appendEnd(ListDAT<T> val);
  void appendEnd(T[] val);

/**
* Append every value from a given array to the end of the list<br/>
*/
  void appendStart(ListDAT<T> val);
  void appendStart(T val);
  void appendStart(T[] val);

  boolean removeAt(int index);
  boolean remove(T val);
  boolean remove(T val, int startIndex);
  boolean remove(T val, int startIndex, int maxIndex);

  T getAt(int index);
  int size();

  void sort(ICompare<T> swap);
  void clear();

  boolean contains(T val);
  boolean contains(T val, int startIndex);
  boolean contains(T val, int startIndex, int maxIndex);

  T[] toArray();


  String join(String separator);


}
