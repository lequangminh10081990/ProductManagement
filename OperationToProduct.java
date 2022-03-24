import java.io.*;

public class OperationToProduct {

    //Hàm in ra màn hình console và ghi dữ liệu in ra vào file
    public static void consoleIntoFile(String myOutputFile, String output, int check){
        try {
            //Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File outputFile = new File(myOutputFile);
            FileWriter writeData = new FileWriter(outputFile, true);
            if (check == 2){ //Check = 2, in ra dòng xong sẽ xuống dòng và lưu vào file
                System.out.print(output + "\n");
            } else if (check == 1) { //Check = 1, in ra 1 dòng nhưng không xuống dòng và lưu vào file
                System.out.print(output);
            } else if (check == 0){} //Check == 0 thì không in ra console mà chỉ lưu vào file

            writeData.write(output + "\n");
            // Đóng luồng
            writeData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Menu
    public static void menu(String myOutputFile){

            String output = "\n"
                            + "|==================================MENU===============================|\n"
                            + "| Choose one of options below                                         |\n"
                            + "| 1.  Load data from file and display                                 |\n"
                            + "| 2.  Input data and add in the end of linked list                    |\n"
                            + "| 3.  Display data of linked list                                     |\n"
                            + "| 4.  Save product list to file                                       |\n"
                            + "| 5.  Search product by ID                                            |\n"
                            + "| 6.  Delete product by ID                                            |\n"
                            + "| 7.  Selection sort by ID using recursion                            |\n"
                            + "| 8.  Convert quantity of first product to binary using recursion     |\n"
                            + "| 9.  Load data into stack and display                                |\n"
                            + "| 10. Load data into queue and display                                |\n"
                            + "| 0.  Exit                                                            |\n"
                            + "|_____________________________________________________________________|\n";

            consoleIntoFile(myOutputFile, output, 2);//In ra menu và lưu vào file console_output
    }

    //Đọc dữ liệu từ file add vào linked list và in ra màn hình console
    public static void readFileAndAddIntoLinkedList(String myFile, MyList productList, String myOutputFile){
        try {

            //Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File inputFile = new File(myFile);
            FileReader readData = new FileReader(inputFile);
            //Đọc dữ liệu
            BufferedReader read = new BufferedReader(readData);
            String line;
            String productID, productName;
            String productPrices;
            String productQuantity;

            //Tách ra các dòng hiển thị khung menu ra màn hình console
            line = read.readLine();
            consoleIntoFile(myOutputFile, line, 2);//In ra và lưu vào file console_output

            line = read.readLine();
            consoleIntoFile(myOutputFile, line, 2);//In ra và lưu vào file console_output

            line = read.readLine();
            consoleIntoFile(myOutputFile, line, 2);//In ra và lưu vào file console_output

            line = read.readLine();
            consoleIntoFile(myOutputFile, line, 2);//In ra và lưu vào file console_output

            //Hiển thị và lấy dữ liệu
            while ((line = read.readLine()) != null){
                consoleIntoFile(myOutputFile, line, 2);//In ra và lưu vào file console_output

                productID = "";
                productName = "";
                productPrices = "";
                productQuantity = "";
                int i;
                //Lấy ra productID từ chuỗi
                for (i = 0; i < line.length(); i++){
                    if (line.charAt(i) != ' '  && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productID += line.charAt(i);
                    i++;
                }
                productID = productID.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productID);
                //System.out.println("i = " + i);
                //Lấy ra productName từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productName += line.charAt(i);
                    i++;
                }
                productName = productName.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productName);
                //System.out.println("i = " + i);

                //Lấy ra productQuantity từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productQuantity += line.charAt(i);
                    i++;
                }
                productQuantity = productQuantity.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productQuantity);
                //System.out.println("i = " + i);
                //Lấy ra productPrices từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productPrices += line.charAt(i);
                    i++;
                }
                productPrices = productPrices.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productPrices);
                //System.out.println("i = " + i);
                Product newProduct = new Product(productID, productName, Integer.parseInt(productQuantity), Double.parseDouble(productPrices));
                productList.addAtTail(newProduct);
            }
            consoleIntoFile(myOutputFile, "|---------------------------------------------------------------------|", 2);//In ra và lưu vào file console_output
            consoleIntoFile(myOutputFile, "Reading file successfully", 2);//In ra và lưu vào file console_output
            // Đóng luồng
            read.close();
            readData.close();
        } catch (IOException ex){
            System.out.println("File reading failed");
            ex.printStackTrace();
        }
    }

    //Nhập và thêm 1 sản phẩm vào cuối linked list
    public static void inputProduct(MyList list, String myOutputFile){
        String productName;
        double productPrice;
        int productQuantity;
        consoleIntoFile(myOutputFile, "Infomation of new product:", 2);//In ra và lưu vào file console_output
        consoleIntoFile(myOutputFile, "Product's Name: ", 1);
        productName = ASM2_Main.sc.nextLine();
        consoleIntoFile(myOutputFile, productName, 0);//Lưu dữ liệu người dùng nhập vào vào file console output

        consoleIntoFile(myOutputFile, "Product's Prices: ", 1);
        productPrice = ASM2_Main.sc.nextDouble();
        consoleIntoFile(myOutputFile, String.valueOf(productPrice), 0);//Lưu dữ liệu người dùng nhập vào vào file console output

        consoleIntoFile(myOutputFile, "Product's Quantity: ", 1);
        productQuantity = ASM2_Main.sc.nextInt();
        consoleIntoFile(myOutputFile, String.valueOf(productQuantity), 0);//Lưu dữ liệu người dùng nhập vào vào file console output

        String productID = productName.substring(0,3).toUpperCase(); //Mã sản phẩm sẽ lấy theo 3 kí tự đầu của tên sản phẩm
        Product product = new Product(productID, productName, productQuantity, productPrice);
        list.addAtTail(product);
    }

    //Hiển thị thông tin của các sản phẩm trong danh sách móc nối
    public static void display(MyList list, String myOutputFile){
        String output = "List of product\n"
                        + "|---------------------------------------------------------------------|\n"
                        + "|    ID     |         Product        |     Quantity    |     Price    |\n"
                        + "|---------------------------------------------------------------------|\n"
                        + list.toString()
                        + "\n"
                        + "|---------------------------------------------------------------------|\n";

        consoleIntoFile(myOutputFile, output, 2);
    }

    //Lưu danh sách móc nối các sản phẩm vào file
    public static void saveLinkedListIntoFile(String myFile, MyList productList, String myOutputFile){
        try {
            //Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File outputFile = new File(myFile);
            FileWriter writeData = new FileWriter(outputFile);
            //Ghi dữ liệu
            writeData.write("List of product\n");
            writeData.write("|---------------------------------------------------------------------|\n");
            writeData.write("|    ID     |         Product        |     Quantity    |     Price    |\n");
            writeData.write("|---------------------------------------------------------------------|\n");
            writeData.write(productList.toString());
            // Đóng luồng
            writeData.close();
            consoleIntoFile(myOutputFile,"File recording success", 2);
        } catch (IOException ex){
            System.err.println("File recording failed");
            ex.printStackTrace();
        }
    }

    //Tìm kiếm thông tin của sản phẩm theo ID
    public static void searchByID(MyList list, String myOutputFile){
        consoleIntoFile(myOutputFile, "Input product's ID you want to search: ", 1);
        String id = ASM2_Main.sc.next();
        consoleIntoFile(myOutputFile, id, 0);//Lưu dữ liệu người dùng nhập vào vào file console output
        consoleIntoFile(myOutputFile, "Search results: ", 2);
        if (list.searchID(id) == null){
            consoleIntoFile(myOutputFile, "The ID you are looking for does not exist, please check again!", 2);
        } else {
            String output =   "|---------------------------------------------------------------------|\n"
                            + "|    ID     |         Product        |     Quantity    |     Price    |\n"
                            + "|---------------------------------------------------------------------|\n"
                            + list.searchID(id)
                            + "\n"
                            + "|---------------------------------------------------------------------|\n";
            consoleIntoFile(myOutputFile, output, 2);
        }
    }

    //Xóa sản phẩm trong danh sách theo ID
    public static void deleteByID(MyList list, String myOutputFile){
        consoleIntoFile(myOutputFile, "Input product's ID you want to delete: ", 1);
        String id = ASM2_Main.sc.next();
        consoleIntoFile(myOutputFile, id, 0);//Lưu dữ liệu người dùng nhập vào vào file console output
        if (list.searchAndDelNodeByID(id)) {
            consoleIntoFile(myOutputFile, "List of product after delete", 2);
            String output =   "|---------------------------------------------------------------------|\n"
                            + "|    ID     |         Product        |     Quantity    |     Price    |\n"
                            + "|---------------------------------------------------------------------|\n"
                            + list.toString()
                            + "\n"
                            + "|---------------------------------------------------------------------|\n";
            consoleIntoFile(myOutputFile, output, 2);
        }
    }

    //Chuyển đổi số tự nhiên từ hệ 10 sang hệ 2 dùng đệ quy
    public static void convertToBinary(int n, String myOutputFile){
        if (n == 0){
            consoleIntoFile(myOutputFile, "0", 1);
            return;
        }
        if (n == 1){
            consoleIntoFile(myOutputFile, "1", 1);
            return;
        }
        convertToBinary(n/2, myOutputFile);
        consoleIntoFile(myOutputFile, String.valueOf(n%2), 1);
        //System.out.print(n%2);
    }

    //Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Hiển thị ra màn hình các sản phẩm có trong stack.
    public static void readFileAndAddIntoStack(String myFile, MyStack productStack, String myOutputFile){
        try {
            //Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File file = new File(myFile);
            FileReader readData = new FileReader(file);
            //Đọc dữ liệu
            BufferedReader read = new BufferedReader(readData);
            String line;
            String productID, productName;
            String productPrices;
            String productQuantity;

            //Tách ra các dòng hiển thị khung menu ra màn hình console
            line = read.readLine();
            //System.out.println(line);
            line = read.readLine();
            //System.out.println(line);
            line = read.readLine();
            //System.out.println(line);
            line = read.readLine();
            //System.out.println(line);

            //Hiển thị và lấy dữ liệu
            while ((line = read.readLine()) != null){
                //System.out.println(line);
                productID = "";
                productName = "";
                productPrices = "";
                productQuantity = "";
                int i;
                //Lấy ra productID từ chuỗi
                for (i = 0; i < line.length(); i++){
                    if (line.charAt(i) != ' '  && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productID += line.charAt(i);
                    i++;
                }
                productID = productID.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productID);
                //System.out.println("i = " + i);
                //Lấy ra productName từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productName += line.charAt(i);
                    i++;
                }
                productName = productName.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productName);
                //System.out.println("i = " + i);

                //Lấy ra productQuantity từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productQuantity += line.charAt(i);
                    i++;
                }
                productQuantity = productQuantity.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productQuantity);
                //System.out.println("i = " + i);
                //Lấy ra productPrices từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productPrices += line.charAt(i);
                    i++;
                }
                productPrices = productPrices.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productPrices);
                //System.out.println("i = " + i);
                Product newProduct = new Product(productID, productName, Integer.parseInt(productQuantity), Double.parseDouble(productPrices));
                productStack.push(newProduct);
            }
            // Đóng luồng
            read.close();
            readData.close();
            consoleIntoFile(myOutputFile, "Reading file and push into stack successfully", 2);
        } catch (IOException ex){
            System.out.println("File reading failed");
            ex.printStackTrace();
        }
        String output = "List of product in Stack\n"
                        + "|---------------------------------------------------------------------|\n"
                        + "|    ID     |         Product        |     Quantity    |     Price    |\n"
                        + "|---------------------------------------------------------------------|\n"
                        + productStack.toString()
                        + "|---------------------------------------------------------------------|\n";
        consoleIntoFile(myOutputFile, output, 2);
        /*System.out.println("List of product in Stack");
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|    ID     |         Product        |     Quantity    |     Price    |");
        System.out.println("|---------------------------------------------------------------------|");
        consoleIntoFile(myOutputFile, productStack.toString(),2);
        System.out.println("|---------------------------------------------------------------------|");*/
    }

    //Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.
    public static void readFileAndAddIntoQueue(String myFile, MyQueue productQueue, String myOutputFile){
        try {
            //Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File file = new File(myFile);
            FileReader readData = new FileReader(file);
            //Đọc dữ liệu
            BufferedReader read = new BufferedReader(readData);
            String line;
            String productID, productName;
            String productPrices;
            String productQuantity;

            //Tách ra các dòng hiển thị khung menu ra màn hình console
            line = read.readLine();
            //System.out.println(line);
            line = read.readLine();
            //System.out.println(line);
            line = read.readLine();
            //System.out.println(line);
            line = read.readLine();
            //System.out.println(line);

            //Hiển thị và lấy dữ liệu
            while ((line = read.readLine()) != null){
                //System.out.println(line);
                productID = "";
                productName = "";
                productPrices = "";
                productQuantity = "";
                int i;
                //Lấy ra productID từ chuỗi
                for (i = 0; i < line.length(); i++){
                    if (line.charAt(i) != ' '  && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productID += line.charAt(i);
                    i++;
                }
                productID = productID.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productID);
                //System.out.println("i = " + i);
                //Lấy ra productName từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productName += line.charAt(i);
                    i++;
                }
                productName = productName.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productName);
                //System.out.println("i = " + i);

                //Lấy ra productQuantity từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productQuantity += line.charAt(i);
                    i++;
                }
                productQuantity = productQuantity.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productQuantity);
                //System.out.println("i = " + i);
                //Lấy ra productPrices từ chuỗi
                for (; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != '|'){
                        break;
                    }
                }
                while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '|'){
                    productPrices += line.charAt(i);
                    i++;
                }
                productPrices = productPrices.replaceAll("\t","");//Xóa các kí tự \t
                //System.out.println(productPrices);
                //System.out.println("i = " + i);
                Product newProduct = new Product(productID, productName, Integer.parseInt(productQuantity), Double.parseDouble(productPrices));
                productQueue.enqueue(newProduct);
            }
            // Đóng luồng
            read.close();
            readData.close();
            consoleIntoFile(myOutputFile, "Reading file and push into queue successfully", 2);
        } catch (IOException ex){
            System.out.println("File reading failed");
            ex.printStackTrace();
        }
        String output = "List of product in Queue\n"
                + "|---------------------------------------------------------------------|\n"
                + "|    ID     |         Product        |     Quantity    |     Price    |\n"
                + "|---------------------------------------------------------------------|\n"
                + productQueue.toString()
                + "|---------------------------------------------------------------------|\n";
        consoleIntoFile(myOutputFile, output, 2);
        /*System.out.println("List of product in Queue");
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|    ID     |         Product        |     Quantity    |     Price    |");
        System.out.println("|---------------------------------------------------------------------|");
        productQueue.display();
        System.out.println("|---------------------------------------------------------------------|");*/
    }
}
