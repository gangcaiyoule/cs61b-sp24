import org.eclipse.jetty.websocket.api.UpgradeResponse;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    public class Node {
        T item;
        Node next;
        Node prev;

        public Node(T i, Node p, Node n) {
            next = n;
            prev = p;
            item = i;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node node = new Node(x, sentinel, null);
        //first.prev -> new node
        sentinel.next.prev = node;
        //node.next -> first
        node.next = sentinel.next;
        //sensinel.next(真正的first) -> new node
        sentinel.next = node;
        //node.prev -> sensinel
        node.prev = sentinel;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node node = new Node(x, null, sentinel);
        //last.next -> new node
        sentinel.prev.next = node;
        //new node.prev -> last
        node.prev = sentinel.prev;
        //sentinel.prev(真正的last) ->new node
        sentinel.prev = node;
        //node.next -> sentinal
        node.next = sentinel;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node node = sentinel.next;
        while (node != sentinel) {
            returnList.add(node.item);
            node = node.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T item = sentinel.next.item;
        //second -> sentinel
        sentinel.next.next.prev = sentinel;
        //sentinel -> second
        sentinel.next = sentinel.next.next;
        return item;
    }

    @Override
    public T removeLast() {
        T item = sentinel.prev.item;
        //the second from the end -> sentinel
        sentinel.prev.prev.next = sentinel;
        //sentinel -> the second from the end
        sentinel.prev = sentinel.prev.prev;
        return item;
    }

    @Override
    public T get(int index) {
        //index超出范围
        if (index < 0 || index >= size) {
            System.out.println("The index is out of range");
            return null;
        }

        int i = 0;
        Node p = sentinel.next;
        while (i != index) {
            p = p.next;
            i++;
        }
        return p.item;
    }


    //try recursive get
    @Override
    public T getRecursive(int index) {
        //check out of range
        if (index < 0 || index >= size) {
            return null;
        }

        Node p = sentinel.next;
        return Recursive(p, index);
    }

    private T Recursive(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        return Recursive(p.next, index - 1);
    }

    public static void main(String[] args) {
        LinkedListDeque61B<Integer> testlist = new LinkedListDeque61B<>();
        testlist.addFirst(5);
        testlist.addFirst(7);
        testlist.addLast(9);
        testlist.addLast(10);//7 5 9 10

        System.out.println(testlist.toList());
        System.out.println(testlist.size);
    }
}
