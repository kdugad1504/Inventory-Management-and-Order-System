import java.util.Scanner;

class Quantity { // In this class only Quantity of Products gets manipulated
    int q;

    Quantity(int z) {
        q = z;
    }

    void add_q(int z) {
        q += z;
    }

    void sub_q(int z) {
        q -= z;
    }

}

public class Order extends Quantity { // subclass of Quantity
    static final int MAX_VALUE = 100;

    Order(int z) {
        super(z);
    }

    static void add_o(Order product, int quantity) { // To add quantity in middle of the day
        product.add_q(quantity);
    }

    static void input_o(Order product, int quantity) { // To subtract the ordered quantity from main quantity
        product.sub_q(quantity);
    }

    static Order Pen = new Order(MAX_VALUE); // Seed Pens
    static Order TB = new Order(MAX_VALUE); // Wooden Tooth Brush
    static Order HB = new Order(MAX_VALUE); // Handmade books
    static Order MS = new Order(MAX_VALUE); // Metal Straws

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orderCount = 0;
        int userChoice;
        do {
            System.out.println("Enter\n1]Create Order\n2]Add Quantity\n3]Finish");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    createOrder();
                    orderCount++;
                    System.out.println("Orders count: " + orderCount);
                    displayQuantities();
                    break;
                case 2:
                    addQuantity();
                    break;
                case 3:
                    System.out.println("It was a GREAT DAY!!");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (userChoice != 3);

    }

    static void addQuantity() { // To select the product and updating it's quantity
        Scanner scanner = new Scanner(System.in);
        int productChoice;
        do {
            System.out.println(
                    "Which product?\n1]Seed pen\n2]Wooden tooth brush\n3]Handmade books\n4]Metal straws\n5]Finish");
            productChoice = scanner.nextInt();
            switch (productChoice) {
                case 1:
                    System.out.print("Enter quantity for Seed pen added: ");
                    add_o(Pen, scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter quantity for Wooden tooth brush added: ");
                    add_o(TB, scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter quantity for Handmade books added: ");
                    add_o(HB, scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter quantity for Metal straws added: ");
                    add_o(MS, scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Complete");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (productChoice != 5);
    }

    static void createOrder() { // To select the product and reduce the quantity
        Scanner scanner = new Scanner(System.in);
        int productChoice;
        do {
            System.out.println(
                    "Which product?\n1]Seed pen\n2]Wooden tooth brush\n3]Handmade books\n4]Metal straws\n5]Finish");
            productChoice = scanner.nextInt();
            switch (productChoice) {
                case 1:
                    System.out.print("Enter quantity for Seed pen: ");
                    input_o(Pen, scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter quantity for Wooden tooth brush: ");
                    input_o(TB, scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter quantity for Handmade books: ");
                    input_o(HB, scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter quantity for Metal straws: ");
                    input_o(MS, scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Order Complete");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (productChoice != 5);
    }

    static void displayQuantities() {
        System.out.println("Quantity of products remaining:");
        System.out.println("Seed pens: " + Pen.q);
        System.out.println("Wooden tooth brushes: " + TB.q);
        System.out.println("Handmade books: " + HB.q);
        System.out.println("Metal straws: " + MS.q);
    }
}
