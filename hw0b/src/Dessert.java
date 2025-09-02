public class Dessert {
    int flavor;
    int price;
    static int num = 0;
    public Dessert(int flavor, int price){
        this.flavor = flavor;
        this.price = price;
        num++;
    }

    public void printDessert(){
        System.out.println(this.flavor + " " + this.price + " " + this.num);
    }
    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
