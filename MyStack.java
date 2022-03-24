import java.util.EmptyStackException;

public class MyStack {
    Node root;

    public boolean isEmpty(){
        return (root == null);
    }

    //Thêm dữ liệu vào Stack
    public void push(Product product){
        Node newNode = new Node(product);
        if (root == null){
            root = newNode;
        } else {
            Node temp = root;
            root = newNode;
            newNode.setNextNode(temp);
        }
        //System.out.println("Finish pushed data into stack");
    }

    //Lấy và xóa dữ liệu phần tử cuối cùng của stack
    public Product pop(){
        Product popped;
        if (root == null){
            System.out.println("Stack UnderFlow");
            throw new EmptyStackException();
        } else {
            popped = root.getData();
            root = root.getNextNode();
        }
        return popped;
    }

    //Lấy dữ liệu phàn tử cuối cùng của stack
    public Product peek(){
        if (root == null){
            System.out.println("Stack UnderFlow");
            throw new EmptyStackException();
        } else {
            return root.getData();
        }
    }

    @Override
    public String toString(){
        String result = "";
        while (root != null){
            result += root.getData().toString() + "\n";
            //System.out.println(root.getData().toString());
            root = root.getNextNode();
        }
        return result;
    }
}
