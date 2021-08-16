package common;

@SuppressWarnings("unused")
public class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) { this.setValue(value); }

  @Override
  public String toString() {
    return value().toString();
  }

  public T value() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void pointTo(Node<T> node){
    this.next = node;
  }

  public Node<T> next(){
    return next;
  }

  public Node<T> end(){
    Node<T> node = this;
    while(node.next != null){
      node = node.next;
    }
    return node;
  }

  public int connections() {
    int size = 0;
    for (Node<T> n = this; n.next != null; n = n.next) size++;
    return size;
  }

  public Node<T> connectionAt(int index){
    Node<T> node = this;

    for(int i = 0; node != null; i++){
      if(i == index) return node;
      node = node.next;
    }
    return null;
  }


  public Node<T> middle(){
    Node<T> slow = this;
    Node<T> fast = this;

    //As the slow pointer is always halfway through the fast one
    //When the fast pointer reaches the end the slow point will be in the middle
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }


}
