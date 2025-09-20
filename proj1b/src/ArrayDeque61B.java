import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] items;
    int size;
    int addFirstIndex;
    int addLastIndex;

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        size = 0;
        addFirstIndex = 0;
        addLastIndex = 1;
    }

    //检查数组是否已满
    private boolean isAlreadyFull() {
        return size == items.length;
    }

    @Override
    public void addFirst(T x) {
        //检查列表是否满了
        if (isAlreadyFull()) {
            System.out.println("需要扩容");
        }
        items[addFirstIndex] = x;
        addFirstIndex--;
        addFirstIndex = Math.floorMod(addFirstIndex, items.length);
        size++;
    }

    @Override
    public void addLast(T x) {
        //检查列表是否满了
        if (isAlreadyFull()) {
            System.out.println("需要扩容");
        }
        items[addLastIndex] = x;
        addLastIndex++;
        addLastIndex = Math.floorMod(addLastIndex, items.length);
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            int realindex = getRealIndex(index);
            list.add(items[realindex]);
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    private int getFirstIndex(int index) {
        int firstindex = index + 1;
        firstindex = Math.floorMod(firstindex, items.length);
        return firstindex;
    }

    private int getLastIndex(int addLastIndex) {
        int lastindex = addLastIndex - 1;
        lastindex = Math.floorMod(lastindex, items.length);
        return lastindex;
    }

    @Override
    public T removeFirst() {
        int firstIndex = getFirstIndex(addFirstIndex);
        T removeItem = items[firstIndex];
        items[firstIndex] = null;
        addFirstIndex++;
        addFirstIndex = getRealIndex(addFirstIndex);
        size--;
        return removeItem;
    }

    @Override
    public T removeLast() {
        int lastIndex = getLastIndex(addLastIndex);
        T removeItem = items[lastIndex];
        items[lastIndex] = null;
        addLastIndex--;
        addLastIndex = getRealIndex(addLastIndex);
        size--;
        return removeItem;
    }

    private int getRealIndex(int index) {
        return Math.floorMod(addFirstIndex + 1 + index, items.length);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > items.length) {
            return null;
        }

        int realindex = getRealIndex(index);
        return items[realindex];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    public static void main(String[] args) {
        ArrayDeque61B<Integer> items = new ArrayDeque61B<>();
        items.addFirst(1);
        items.addFirst(5);
        items.addFirst(7);
        //test toList()
        List<Integer> list = items.toList();
        System.out.println("list is :" + list);
        //test size()
        System.out.println("size :" + items.size());

        //test isEmpty()
        System.out.println("is empty :" + items.isEmpty());
        //test remove
        System.out.println("remove first item :" + items.removeFirst());
        System.out.println("size :" + items.size());
        System.out.println("remove last item :" + items.removeLast());
        System.out.println("size :" + items.size());
    }
}
