package MyListImplementation.parametrized;


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DefaultMyListParameterized<T> implements MyListParameterized<T>, ListIterableParameterized<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public ListIteratorParameterized<T> listIterator() {
        return new ListIteratorImplParameterized<>();
    }

    @Override
    public void add(T e) {
        final Node<T> lastNode = last;
        final Node<T> newNode = new Node<T>(lastNode, e, null);
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
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
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
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    Object unlink(Node<T> element) {
        Object obj = element.data;
        Node<T> next = element.next;
        Node<T> previous = element.previous;

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
        for (Node<T> x = first; x != null; x = x.next) {
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
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data.equals(o)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(MyListParameterized<?> c) {
        Object[] array = c.toArray();
        for (int i = 0; i < array.length; i++) {
            if (!contains(array[i])) {
                return false;
            }

        }
        return true;
    }


    private static class Node<T> {
        private Node<T> previous;
        private T data;
        private Node<T> next;


        public Node(Node<T> previous, T data, Node<T> next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl<>();
    }

    public Object removeNodeByIndex(int index) {
        return unlink(getNodeByIndex(index));

    }

    public Node<T> getNodeByIndex(int index) {
        if (index > (size - 1)) {
            return null;
        }

        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.previous;
            }
            return x;
        }
    }

    private class IteratorImpl<T> implements Iterator<T> {


        int cursor = 0;
        int lastRet = -1;



        @Override
        public boolean hasNext() {
            return cursor != size;
        }




        @Override
        public T next() {
            Node<T> next = (Node<T>) getNodeByIndex(cursor);
            if (next == null) {
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            cursor += 1;
            return next.data;
        }


        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            DefaultMyListParameterized.this.removeNodeByIndex(lastRet);
            if (lastRet < cursor) {
                cursor--;
            }
            lastRet = -1;
        }

    }

    private class ListIteratorImplParameterized<T> extends IteratorImpl<T>
            implements ListIteratorParameterized<T> {
        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }


        @Override
        public T previous() {
            cursor -= 1;
            Node<T> previous = (Node<T>) getNodeByIndex(cursor);
            if (previous == null) {
                cursor = 0;
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            return previous.data;

        }


        @Override
        public void set(T element) {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            Node<T> x = (Node<T>) getNodeByIndex(lastRet);
            x.data = element;
            lastRet = -1;
        }


    }

}




