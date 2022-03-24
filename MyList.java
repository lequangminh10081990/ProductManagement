public class MyList {
    private Node head;
    private Node tail;

    //Hàm thêm node vào cuối linked list
    public void addAtTail(Product product){
        Node newNode = new Node(product);
        if (this.head == null){
            this.head = newNode;
        }
        if (this.tail != null){
            this.tail.setNextNode(newNode);
        }
        this.tail = newNode;
    }

    //Tìm kiếm thông tin của sản phẩm theo ID
    public Node searchID(String id){
        Node result = null;
        Node current = this.head;
        if (this.head == null){
            return null;
        } else {
            while (current != null){
               if (current.getData().getProductID().equalsIgnoreCase(id)){
                   result = current;
                   break;
               }
               current = current.getNextNode();
            }
            return result;
        }
    }

    //Tìm kiếm và xóa Node theo ID
    public boolean searchAndDelNodeByID(String id){
        Node current = this.head;
        if (this.head == null){
            System.out.println("List is empty!");
            return false;
        }
        if (current.getData().getProductID().equalsIgnoreCase(id)){
            this.head = this.head.getNextNode();
            System.out.println("Successfully deleted product whose ID is: " + id);
            return true;
        }
        while (current.getNextNode() != null){
            if (current.getNextNode().getData().getProductID().equalsIgnoreCase(id)){
                current.setNextNode(current.getNextNode().getNextNode());
                return true;
            }
            current = current.getNextNode();
        }
        if (current.getData().getProductID().equalsIgnoreCase(id)){
            current = null;
            return true;
        }
        System.out.println("Product's ID is incorrect, please check again!");
        return false;
    }

    //Hàm lấy ra số lượng của sản phẩm ở Node đầu tiên
    public int getQuantityOfHead(){
        return this.head.getData().getProductQuantity();
    }

    //Hàm lấy ra Node đầu tiên
    public Node getHead(){
        return this.head;
    }

    //Hàm tính độ dài của linked list
    public int length(){
        int length = 0;
        Node current = this.head;
        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    //Hàm sắp xếp danh sách liên kết dùng recursion
    public void selectionSortUsingRecursion(Node head){
        if (head == null){
            return;
        }
        Node minData = head;
        for (Node i = head.getNextNode(); i != null; i = i.getNextNode()){
            if (minData.getData().getProductID().toString().compareTo(i.getData().getProductID().toString()) > 0){
                minData = i;
            }
        }
        Product temp = minData.getData();
        minData.setData(head.getData());
        head.setData(temp);
        selectionSortUsingRecursion(head.getNextNode());
    }

    @Override
    public String toString(){
        String result = "";
        Node curent = this.head;
        while (curent.getNextNode() != null){
            result += curent.getData().toString() + "\n";
            curent = curent.getNextNode();
        }
        result += curent.getData().toString();
        return result;
    }
}
