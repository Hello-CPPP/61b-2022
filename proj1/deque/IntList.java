package deque;

public class IntList {
    int first;
    IntList next; //这里命名为next更加合理

    IntList() {

    }
    IntList(int x, IntList L) {
        //IntList returnList = new IntList();
        //returnList.first = x;
        //returnList.next = l;
        //return returnList;
        first = x;
        next = L;
    }

    IntList addFirst(int x) {
        //IntList returnList = new IntList();
        //returnList.first = x;
        //returnList.next = this;
        //return returnList;
        return new IntList(x, this);
    }

    // calculate size recursively
    int size() {
        if (next == null) {
            return 1;
        }
        return 1 + this.next.size();
    }

    // calculate size in a loop
    int sizeLoop() {
        IntList p = this;
        int size = 1;
        while (p.next != null) {
            ++size;
            p = p.next;
        }
        return size;
    }

    int sizeIterative(IntList l) {
        int k = 0;
        for (int i = 0; l != null; i++) {
            l = l.next;
            ++k;
        }
        return k;
    }

    public static void main(String[] args) {
        IntList L = new IntList();
        L  = L.addFirst(5);
        L  = L.addFirst(15);
        L  = L.addFirst(25);
        System.out.println(L.size());
        System.out.println(L.sizeLoop());
        System.out.println(L.sizeIterative(L));


    }

}
