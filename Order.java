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

    static int Pen_p = 20;
    static int TB_p  = 50;
    static int HB_p = 120;
    static int MS_p = 30;

    static int amt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orderCount = 0;
        int userChoice;
        do {
            System.out.println("Enter\n1]Create Order\n2]Add Quantity\n3]Display Quantities\n4]Finish");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    createOrder(scanner);
                    orderCount++;
                    System.out.println("Orders count: " + orderCount);
                    break;
                case 2:
                    addQuantity(scanner);
                    break;
                case 3:
                    displayQuantities();
                    break;
                case 4:
                    System.out.println("It was a GREAT DAY!!");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (userChoice != 4);
    }

    static void addQuantity(Scanner scanner) { // To select the product and updating its quantity
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

    static void createOrder(Scanner scanner) { // To select the product and reduce the quantity
        int productChoice;
        do {
            System.out.println(
                    "Which product?\n1]Seed pen\n2]Wooden tooth brush\n3]Handmade books\n4]Metal straws\n5]Finish");
            productChoice = scanner.nextInt();
            switch (productChoice) {
                case 1:
                    System.out.print("Enter quantity for Seed pen: ");
                    int penQuantity = scanner.nextInt();
                    input_o(Pen, penQuantity);
                    amt += calculateAmount("pen", penQuantity);
                    break;
                case 2:
                    System.out.print("Enter quantity for Wooden tooth brush: ");
                    int tbQuantity = scanner.nextInt();
                    input_o(TB, tbQuantity);
                    amt += calculateAmount("toothbrush", tbQuantity);
                    break;
                case 3:
                    System.out.print("Enter quantity for Handmade books: ");
                    int hbQuantity = scanner.nextInt();
                    input_o(HB, hbQuantity);
                    amt += calculateAmount("books", hbQuantity);
                    break;
                case 4:
                    System.out.print("Enter quantity for Metal straws: ");
                    int msQuantity = scanner.nextInt();
                    input_o(MS, msQuantity);
                    amt += calculateAmount("straws", msQuantity);
                    break;
                case 5:
                    System.out.println("Order Complete");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (productChoice != 5);
        System.out.println("Order Amount: " + amt);
        amt = 0; // Reset amount for the next order
    }

    static int calculateAmount(String prod, int quantity) {
        switch (prod) {
            case "pen": return Pen_p * quantity;
            case "toothbrush": return TB_p * quantity;
            case "books": return HB_p * quantity;
            case "straws": return MS_p * quantity;
            default: return 0;
        }
    }

    static void displayQuantities() {
        System.out.println("Quantity of products remaining:");
        System.out.println("Seed pens: " + Pen.q);
        System.out.println("Wooden tooth brushes: " + TB.q);
        System.out.println("Handmade books: " + HB.q);
        System.out.println("Metal straws: " + MS.q);
    }
}
