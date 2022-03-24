public class MyQueue {
    Node front, rear;

    public MyQueue(){
        this.front = null;
        this.rear = null;
    }

    //Thêm dữ liệu vào queue
    public void enqueue(Product product){
        Node temp = new Node(product);
        if (this.rear == null){
            this.front = this.rear = temp;
            return;
        }
        this.rear.setNextNode(temp);
        this.rear = temp;
    }

    //Xóa dữ liệu khỏi queue
    public void dequeue(){
        if (this.front == null){
            return;
        }
        //Node temp = this.front;
        this.front = this.front.getNextNode();
        if (this.front == null){
            this.rear = null;
        }
    }

    @Override
    public String toString(){
        String result = "";
        if (this.front == null){
            return result;
        }
        Node current = this.front;
        while (current != null){
            result += current.getData().toString() + "\n";
            current = current.getNextNode();
        }
        return result;
    }

    //Hàm hiển thị thông tin trong queue
    public void display(){
        if (this.front == null){
            System.out.println("Queue is empty");
            return;
        }
        Node current = this.front;
        while (current != null){
            System.out.println(current.getData().toString());
            current = current.getNextNode();
        }
    }
}
