public class InvoiceTest {
    public static void main(String[] args) {
        //test for an object
        Invoice test = new Invoice("A86", "Brake Pads", 17, 3);

        //printing the object to see if it works
        System.out.println("Part number; " + test.getPartNumber());
        System.out.println("Part description; " + test.getPartDescription());
        System.out.println("Amount sold; " + test.getQuantityOfPurchased());
        System.out.println("Price per item; " + test.getPricePerItem());
        System.out.println("Invoice amount; " + test.getInvoiceAmount());

        //changing the object to see if it effects the print
        test.setPartNumber("C134x");
        test.setPartDescription("Engine Gaskets");
        test.setQuantityOfPurchase(809);
        test.setPricePerItem(12);

        System.out.println(" ");
        System.out.println("-----After changing-----");
        System.out.println(" ");

        //printing after changing to see if it worked
        System.out.println("Part number; " + test.getPartNumber());
        System.out.println("Part description; " + test.getPartDescription());
        System.out.println("Amount sold; " + test.getQuantityOfPurchased());
        System.out.println("Price per item; " + test.getPricePerItem());
        System.out.println("Invoice amount; " + test.getInvoiceAmount());
    }
}