package deque;

public class LinkList<T> {
    int size; // recording the length of linklist
    T item; // a single linklist node
    T next;
    T front; // front sentinel, using it to add and remove
    T last; // tail sentinel, using it to add and remove

    LinkList(T item, LinkList L) {
        size = 0;

    }
}
