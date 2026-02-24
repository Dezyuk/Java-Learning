package MyListImplementation;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DefaultMyList implements MyList {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(Object e) {
        final Node lastNode = last;
        final Node newNode = new Node(lastNode, e, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.next = null;
            x.data = null;
            x.previous = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (x.data.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    Object unlink(Node element) {
        Object obj = element.data;
        Node next = element.next;
        Node previous = element.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            element.previous = null;
        }
        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            element.next = null;
        }

        element.data = null;
        size--;
        return obj;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            objects[i++] = x.data;
        }
        return objects;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.data == null) {
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (x.data.equals(o)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] array = c.toArray();
        for (int i = 0; i < array.length; i++) {
            if (!contains(array[i])) {
                return false;
            }
            ;
        }
        return true;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('{');

        for (Node x = first; x != null; x = x.next) {
            sb.append('[')
                    .append(x.data);

            if (x.next == null) {
                break;
            }
            sb.append(']')
                    .append(',')
                    .append(' ');
        }

        return sb.append(']')
                .append('}')
                .toString();
    }
    public Node getNodeByIndex(int index) {
        if (index > (size -1)) {
            return null;
        }

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.previous;
            }
            return x;
        }
    }
    public Object removeNodeByIndex(int index) {
        return unlink(getNodeByIndex(index));

    }

    private class IteratorImpl implements Iterator<Object> {
        int cursor = 0;
        int lastRet = -1;
        public boolean hasNext() {
            return cursor != size;
        }


        public Object next() {
            Object next = getNodeByIndex(cursor);
            if (next == null) {
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            cursor += 1;
            return next;
        }

        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            DefaultMyList.this.removeNodeByIndex(lastRet);
            if (lastRet < cursor) {
                cursor--;
            }
            lastRet = -1;
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void forEach(Consumer<? super Object> action) {
        MyList.super.forEach(action);
    }

    @Override
    public Spliterator<Object> spliterator() {
        return MyList.super.spliterator();
    }

    private static class Node {
        private Node previous;
        private Object data;
        private Node next;

        public Node(Node previous, Object data, Node next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
