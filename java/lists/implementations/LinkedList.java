package lists.implementations;

import common.ICompare;
import common.Node;
import lists.interfaces.ListDAT;

@SuppressWarnings("unused")
public class LinkedList<T>  implements ListDAT<T> {

  protected Node<T> start,end;
  protected int size = 0;

  public LinkedList(){} public LinkedList(Node<T> start, Node<T> end){
    if(start == null && end == null) return;

    this.start  = start;
    this.end    = end;
    size = start.connections() + 1;
  }

  public LinkedList<T> deepClone(){
    LinkedList<T> list = new LinkedList<>();
    for(Node<T> node = start; node.next() != null; node = node.next()) list.appendEnd(node);
    return list;
  }

  @Override public void appendEnd(ListDAT<T> values) {
    int lSize = values.size(); if(lSize < 1) return;

    if(values instanceof LinkedList) {
      LinkedList<T> l = (LinkedList<T>) values;

      end.pointTo(l.start);
      end   = l.end;
      size += l.size();
      return;
    }

    for(int i = 0; i < lSize; ++i) appendEnd(values.getAt(i));
  }

  @Override public void appendEnd(T[] values) { for (T val : values) this.appendEnd(val); }
  @Override public void appendEnd(T val) { appendEnd(new Node<>(val));}
  protected void appendEnd(Node<T> newEnd){
    if (start == null) start = newEnd;
    else end.pointTo(newEnd);

    size += (newEnd.connections() + 1);
    end = newEnd;
  }


  @Override public void appendStart(ListDAT<T> values) {
    int lSize = values.size(); if(lSize < 1) return;

    if(values instanceof LinkedList) {
      LinkedList<T> l = (LinkedList<T>) values;
      l.end.pointTo(start);

      start = l.start; //new start will be the appended list's
      size += l.size();
      return;
    }

    for(int i = lSize - 1; i >= 0; --i) appendStart(values.getAt(i));
  }

  @Override public void appendStart(T[] values) { for (int i = values.length - 1; i >= 0; i--) this.appendStart(values[i]); }
  @Override public void appendStart(T value) { appendStart(new Node<>(value));}
  protected void appendStart(Node<T> newStart){
    if (start == null) end = newStart;
    else newStart.pointTo(start);

    size += (newStart.connections() + 1);
    start = newStart;
  }

  @Override public boolean removeAt(int index) {
    if(index == 0){
      start = start.next();
      size -= 1;
      return true;
    }

    Node<T> previous = this.getNodeAt(index - 1);
    if(previous == null || previous.next() == null) return false;

    previous.pointTo(previous.next().next());
    size -= 1;
    return true;
  }

  @Override public boolean remove(T val) { return remove(val,0); }
  @Override public boolean remove(T val, int startIndex) { return remove(val,startIndex,size);}
  @Override public boolean remove(T val, int startIndex, int maxIndex) {
    if(maxIndex < 0) return false;
    if(0 == startIndex && start.value().equals(val)) return removeAt(0);
    Node<T> node = start;

    for(int i = 0; node.next() != null && i <= maxIndex;++i){

      if(i >= startIndex && val.equals(node.next().value())) {
        node.pointTo(node.next().next());

        size -= 1;
        if(i == (size() - 1)) end = node;
        return true;
      }

      node = node.next();
    }
    return false;
  }

  protected Node<T> getNodeAt(int index){
    if(index < 0 || index >= size()) return null;
    return start.connectionAt(index);
  }

  @Override public T getAt(int index){
    return this.getNodeAt(index).value();
  }

  @Override public int size() {
    if(start == null)  return 0;
    return size;
  }

  @Override public void clear() { start = null; end = null; size = 0;}

  @Override public boolean contains(T val) { return contains(val, 0, size() - 1);}
  @Override public boolean contains(T val, int startIndex) { return contains(val, startIndex,size() - 1);}
  @Override public boolean contains(T val, int startIndex, int until) {
    Node<T> node = start;

    for(int i = 0; node != null && i <= until;++i){
      if(i >= startIndex && val.equals(node.value())) return true;
      node = node.next();
    }

    return false;
  }

  @Override public T[] toArray() {
    //noinspection unchecked
    T[] arr = (T[])new Object[size()];
    if(size() == 0) return  arr;

    Node<T> node = start;
    for(int i = 0; node != null; ++i){
      arr[i] = node.value();
      node = node.next();
    }

    return arr;
  }

  @Override public String join(String separator) {
    Node<T> node = start;
    StringBuilder joinedList = new StringBuilder();
    if (node == null) return "";
    for(int i = 0; node != null && i < size();++i){
      joinedList.append(node.value());
      if(i < (size() - 1)) joinedList.append(separator);

      node = node.next();
    }

    return joinedList.toString();
  }

  public void reverse(){ reverse(0); }
  public void reverse(int index){
    int startIndex = index < 0 ? size - 1 - index : index;
    Node<T> anchor = getNodeAt(startIndex - 1);


    Node<T> prev = null;
    Node<T> curr = startIndex == 0 ? start : anchor.next();

    // A -> B -> C -> D
    // A -> NULL { prev: A; curr: B; next: B  }
    // B -> A -> NULL { prev: B; curr: C; next: C  }
    // C -> B -> A -> NULL { prev: C; curr: D; next: D  }
    // D -> C -> B -> A -> NULL { prev: D; curr: NULL; next: NULL  }

    while (curr != null){
      Node<T> next = curr.next();
      curr.pointTo(prev);
      prev = curr;
      curr = next;
    }

    if(anchor != null) {
      end = anchor.next();
      anchor.pointTo(prev);
    }else{
      end = start;
      start = prev;
    }
  }

  public void distinct() {
    if(size <= 1) return;
    Node<T> lastValidNode = start;
    int i = 0;

    for (Node<T> node = lastValidNode.next(); node != null; node = node.next()) {
      //check every number before
      if (!this.contains(node.value(),0, i)) {
        lastValidNode = node;
        i++;
        continue;
      }

      //if it found something: remove it
      lastValidNode.pointTo(node.next());
      size -= 1;
      if(i == (size() - 1)) end = node;
    }

  }

  @Override public String toString() {
    if(size() == 0) return "[ ]";
    if(size() == 1) return "[ " + start + " ]";
    return "[ " + join(",") + " ]";
  }

  public void sort(ICompare<T> shouldSwap){
    bubbleSort(shouldSwap);
  }

  public void bubbleSort(ICompare<T> shouldSwap) {
    if (size() <= 1) return;
    int max = size();

    for (int i = 0; i < max - 1; i++) {
      Node<T> A = start,B = start.next(),Z = null;
      for (int j = 0; j < max - i - 1; ++j) {
        if (shouldSwap.run(A.value(), B.value())) {

          //SWAP
          //Z -> [A -> B] -> C
          //Z -> B | A -> B -> C
          //Z -> B | A -> C
          //Z -> [B -> A] -> C

          if (Z == null) start = B;  // at start
          else Z.pointTo(B); //everywhere else [Z -> B] - >C

          A.pointTo(B.next()); //A -> C
          B.pointTo(A);  //Z -> [B -> A] -> C

          B = A.next(); // Next B will be C, so B(now as Z) -> [A -> C (now as B)] -> D (now as C)
        } else {
          A = A.next();
          B = B.next();
        }

        Z = Z == null ? start : Z.next();
      }
    }
  }
}
