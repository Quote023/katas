package lists.implementations;

public class CircularList<T> extends LinkedList<T>{

  @Override
  public void appendEnd(T val) {
    super.appendEnd(val);
    end.next = start;
  }

  @Override
  public void appendStart(T val) {
    super.appendStart(val);
    end.next = start;
  }
}
