package common;

public class DoublyLinkedNode<T> extends Node<T> {
  public Node<T> prev;

  public DoublyLinkedNode(T value) { super(value); }
}
