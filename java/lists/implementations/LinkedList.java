package lists.implementations;

import common.Node;
import lists.interfaces.ListDAT;

public class LinkedList<T>  implements ListDAT<T> {

  protected Node<T> start,end;
  protected int size = 0;


  @Override
  public void appendEnd(ListDAT<T> values) {
    int lSize = values.size();
    if(lSize < 1) return;

    if(values instanceof LinkedList) {
      LinkedList<T> l = (LinkedList<T>) values;

      end.next  = l.start;
      end       = l.end;
      size      = size + lSize;
      return;
    }

    for(int i = 0; i < lSize; ++i)
        appendEnd(values.getAt(i));
  }

  /**
   * Append every value from a given array to the end of the list<br/>
   */
  @Override
  public void appendEnd(T[] values) { for (T val : values) this.appendEnd(val); }

  @Override
  public void appendEnd(T val) {
    Node<T> newEnd = new Node<>(val);

    if (start == null) start = newEnd;
    else end.next = newEnd;

    end = newEnd;
    size += 1;
  }


  @Override
  public void appendStart(ListDAT<T> values) {
    int lSize = values.size();
    if(lSize < 1) return;

    if(values instanceof LinkedList) {
      LinkedList<T> l = (LinkedList<T>) values;

      l.end.next  = start;
      start       = l.start;
      size        = size + lSize;
      return;
    }

    for(int i = lSize - 1; i >= 0; --i)
      appendStart(values.getAt(i));
  }


  /**
   * Append every value from a given array to the start of the list<br/>
   * <u>keeps the original order!</u>
   */
  @Override
  public void appendStart(T[] values) {
    for (int i = values.length - 1; i >= 0; i--) this.appendStart(values[i]);
  }

  @Override
  public void appendStart(T value) {
    Node<T> newStart = new Node<>(value);

    if (start == null) end = newStart;
    else newStart.next = start;

    start = newStart;
    size  = size + 1;
  }

  @Override
  public T getAt(int index){
    Node<T> node = start;

    for(int i = 0; node.next != null; ++i){
      if(i == index) break;
      node = node.next;
    }

    return node.value;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    start = null;
    end = null;
    size = 0;
  }

  @Override
  public boolean contains(T val) {
    return contains(val, 0, size - 1);
  }

  @Override
  public boolean contains(T val, int startIndex) {
    return contains(val, startIndex,size - 1);
  }

  @Override
  public boolean contains(T val, int startIndex, int until) {
    Node<T> node = start;

    for(int i = 0; node != null && i < until;++i){
      if(i >= startIndex && val.equals(node.value)) return true;
      node = node.next;
    }

    return false;
  }

  @Override
  public T[] toArray() {

    //noinspection unchecked
    T[] arr = (T[])new Object[size];
    if(size == 0) return  arr;

    Node<T> node = start;

    for(int i = 0; node != null; ++i){
      arr[i] = node.value;
      node = node.next;
    }

    return arr;
  }

  @Override
  public String join(String separator) {
    Node<T> node = start;
    StringBuilder joinedList = new StringBuilder();
    if (node == null) return "";

    for(int i = 0; node != null && i < size;++i){
      joinedList.append(node.value).append(separator);
      node = node.next;
    }

    return joinedList.toString();
  }
}
