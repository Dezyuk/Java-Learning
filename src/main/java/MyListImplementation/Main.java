import MyListImplementation.DefaultMyList;

public static void main(String[] args) {
    DefaultMyList myList = new DefaultMyList();
    for (int i =0;i<10;i++){

        myList.add(i);
    }
    System.out.println(myList.toString());
    System.out.println( Arrays.toString(myList.toArray()));

}
