package randomizedtest;

public class Test {
    public static void main(String[] args) {
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList;
        System.out.println(aListNoResizing);
    }
}
