public class LinkListDriver {
 
    public static void main(String[] args) {
        iLinkedList lList = new iLinkedList();
        System.out.println("is the list empty? Yes if true, No if false::: " + lList.isEmpty());
        System.out.println("lList contains 5, {-1 equals false} :::: " + lList.contains("5"));
        System.out.println("Add 3 to list");
        System.out.println("Add 4 to list");
        System.out.println("Add 7 to list");
        System.out.println("Add 2 to list");
        System.out.println("Add 9 to list");
        lList.add("3");
        lList.add("4");
        lList.add("7");
        lList.add("2");
        lList.add("9");
 
        System.out.println("lList contains 9, {-1 equals false} :::: " + lList.contains("9"));
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList.size() - print linkedlist size: " + lList.size());
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.remove(3) - remove 3rd element: " + lList.remove(3));
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.size() - print linkedlist size: " + lList.size());
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList.remove() - remove last element: " + lList.remove());
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("is the list empty? Yes if true, No if false::: " + lList.isEmpty());
        System.out.println("lList contains 2, {-1 equals false} :::: " + lList.contains("2"));
    }
}