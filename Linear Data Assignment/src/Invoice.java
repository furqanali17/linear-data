public class Invoice {
    //Fields
    public String partNumber;
    public String partDescription;
    public int quantityOfPurchase;
    public double pricePerItem;

    //Constructor
    public Invoice(String partNumber, String partDescription, int quantityOfPurchase, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantityOfPurchase = Math.max(quantityOfPurchase, 0);
        this.pricePerItem = Math.max(pricePerItem, 0.0);
    }

    //Set Methods
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setQuantityOfPurchase(int quantityOfPurchase) {
        //setting quantityOfPurchase to 0 is the value entered is negative by using Math.max
        this.quantityOfPurchase = Math.max(quantityOfPurchase, 0);
    }

    public void setPricePerItem(double pricePerItem) {
        //setting pricePerItem to 0 is the value entered is negative by using Math.max
        this.pricePerItem = Math.max(pricePerItem, 0.0);
    }

    //Get Methods
    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantityOfPurchased() {
        return quantityOfPurchase;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public double getInvoiceAmount() {
        return pricePerItem * quantityOfPurchase;
    }
}






