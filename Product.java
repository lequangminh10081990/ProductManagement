public class Product {
    //Mã sản phẩm, tên sản phẩm, đơn giá, số lượng.
    private String productID;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(String productID, String productName, int productQuantity, double productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductID(){
        return this.productID;
    }
    public String getProductName(){
        return this.productName;
    }
    public double getProductPrice(){
        return this.productPrice;
    }
    public int getProductQuantity(){
        return this.productQuantity;
    }

    @Override
    public String toString(){
        String length = " ";
        for (int i = 0; i < 21 - this.productName.length(); i++){
            length += " ";
        }
        String result = "";
        result = "|   " + this.productID + "\t\t|  " + this.productName + length + "| " + this.productQuantity + "\t\t\t   |  " + this.productPrice + "\t\t  |" ;
        return result;
    }
}
