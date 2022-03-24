import java.util.Scanner;
import java.io.*;

public class ASM2_Main {
    public static Scanner sc = new Scanner(System.in);
    //public static String myFile = "D:\\Funix\\CSD201x_02-A_VN_DN Data Structures and Algorithms\\Project\\CSD201_AS2__minhlqFX11216@funix.edu.vn\\Data.txt";
    //public static String outputFile = "D:\\Funix\\CSD201x_02-A_VN_DN Data Structures and Algorithms\\Project\\CSD201_AS2__minhlqFX11216@funix.edu.vn\\console_output.txt";
    public static String myFile = "Data.txt";
    public static String outputFile = "console_output.txt";

    public static void main(String[] args){

        String enter; // Để bắt kí tự enter thừa
        String next; // Lựa chọn có tiếp tục thao tác hay không
        MyList productList = new MyList();
        int choice;
        while (true) {
            OperationToProduct.menu(outputFile);
            OperationToProduct.consoleIntoFile(outputFile, "You choice: ", 1);
            choice = sc.nextInt();
            OperationToProduct.consoleIntoFile(outputFile, String.valueOf(choice), 0);//Lưu dữ liệu người dùng nhập vào vào file console output
            if (choice == 0){
                OperationToProduct.consoleIntoFile(outputFile,"See you again!", 2);
                break;
            }
            switch (choice){

                //Đọc dữ liệu có sẵn từ file và lưu vào danh sách móc nối và hiển thị danh sách ra màn hình
                case 1:{
                    productList = new MyList();
                    OperationToProduct.readFileAndAddIntoLinkedList(myFile, productList, outputFile);
                    break;
                }

                //Nhập và thêm một sản phẩm vào cuối của danh sách móc nối
                case 2:{
                    enter = sc.nextLine();//Bắt kí tự enter thừa
                    while (true){
                        OperationToProduct.inputProduct(productList, outputFile);
                        //System.out.println(productList);
                        enter = sc.nextLine();//Bắt kí tự enter thừa
                        OperationToProduct.consoleIntoFile(outputFile, "Do you want to add new product? Y or N\t", 1);
                        next = sc.nextLine();
                        OperationToProduct.consoleIntoFile(outputFile, next, 0);//Lưu dữ liệu người dùng nhập vào vào file console output
                        if (next.equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    break;
                }

                //Hiển thị thông tin của các sản phẩm trong danh sách móc nối
                case 3:{
                    OperationToProduct.display(productList, outputFile);
                    break;
                }

                //Lưu danh sách móc nối các sản phẩm vào file
                case 4:{
                    OperationToProduct.saveLinkedListIntoFile(myFile, productList, outputFile);
                    break;
                }

                //Tìm kiếm thông tin của sản phẩm theo ID
                case 5:{
                    enter = sc.nextLine();//Bắt kí tự enter thừa
                    while (true){
                        OperationToProduct.searchByID(productList, outputFile);
                        OperationToProduct.consoleIntoFile(outputFile, "Do you want to continue search? Y or N\t", 1);
                        enter = sc.nextLine();//Bắt kí tự enter thừa
                        next = sc.nextLine();
                        OperationToProduct.consoleIntoFile(outputFile, next, 0);//Lưu dữ liệu người dùng nhập vào vào file console output
                        if (next.equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    break;
                }

                //Xóa sản phẩm trong danh sách theo ID
                case 6:{
                    enter = sc.nextLine();//Bắt kí tự enter thừa
                    while (true){
                        OperationToProduct.deleteByID(productList, outputFile);
                        OperationToProduct.consoleIntoFile(outputFile, "Do you want to continue delete? Y or N\t", 1);
                        enter = sc.nextLine();//Bắt kí tự enter thừa
                        next = sc.nextLine();
                        OperationToProduct.consoleIntoFile(outputFile, next, 0);//Lưu dữ liệu người dùng nhập vào vào file console output
                        if (next.equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    break;
                }

                //Sắp xếp các sản phẩm  trong danh sách móc nối theo ID (Selection Sort dùng recursion
                case 7:{
                    Node head = productList.getHead();
                    productList.selectionSortUsingRecursion(head);
                    String output = "List of product after sorted\n"
                                    + "|---------------------------------------------------------------------|\n"
                                    + "|    ID     |         Product        |     Quantity    |     Price    |\n"
                                    + "|---------------------------------------------------------------------|\n"
                                    + productList.toString()
                                    + "\n|---------------------------------------------------------------------|\n";
                    OperationToProduct.consoleIntoFile(outputFile, output, 2);

                    /*System.out.println("List of product after sorted");
                    System.out.println("|---------------------------------------------------------------------|");
                    System.out.println("|    ID     |         Product        |     Quantity    |     Price    |");
                    System.out.println("|---------------------------------------------------------------------|");
                    System.out.println(productList);
                    System.out.println("|---------------------------------------------------------------------|");*/
                    break;
                }

                //Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List ra  hệ đếm nhị phân bằng phương pháp đệ quy.
                case 8:{
                    int n = productList.getQuantityOfHead();
                    OperationToProduct.consoleIntoFile(outputFile, "The first product's quantity is: " + n, 2);
                    OperationToProduct.consoleIntoFile(outputFile, "Convert to binary: ", 1);
                    OperationToProduct.convertToBinary(n, outputFile);
                    System.out.println();
                    break;
                }

                //Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Hiển thị ra màn hình các sản phẩm có trong stack.
                case 9:{
                    MyStack productStack = new MyStack();
                    OperationToProduct.readFileAndAddIntoStack(myFile, productStack, outputFile);
                    break;
                }

                //Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.
                case 10:{
                    MyQueue productQueue = new MyQueue();
                    OperationToProduct.readFileAndAddIntoQueue(myFile, productQueue, outputFile);
                    //productQueue.display();
                    break;
                }
            }
        }
    }
}
