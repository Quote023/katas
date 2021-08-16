package lists.implementations;

import common.Node;

public class CircularList<T> extends LinkedList<T>{

  @Override public void appendEnd(T val) {
    super.appendEnd(val);
    end.pointTo(start);
  }

  @Override public void appendStart(T val) {
    super.appendStart(val);
    end.pointTo(start);
  }

  @Override public Node<T> getNodeAt(int index) { return start.connectionAt(index);}

  @Override public boolean removeAt(int index) {
    if(index == 0) end.pointTo(start.next().next());
    return super.removeAt(index);
  }

}
