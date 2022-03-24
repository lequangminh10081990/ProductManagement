public class Node {
    private Product data;
    private Node nextNode;

    public Node(Product data){
        this.data = data;
    }
    public Product getData(){
        return this.data;
    }
    public Node getNextNode(){
        return this.nextNode;
    }

    public void setData(Product data){
        this.data = data;
    }
    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    @Override
    public String toString(){
        return this.data.toString();
    }
}


