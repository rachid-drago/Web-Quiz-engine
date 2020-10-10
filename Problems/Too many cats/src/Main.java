class Cat {

    // write static and instance variables
    static int num = 0;
    int age;
    String name;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        num++;
        if (num > 5) {
            System.out.println("You have too many cats");
        }
        // implement the constructor
        // do not forget to check the number of cats
    }

    public static int getNumberOfCats() {
        return num;
        // implement the static method
    }
}