package de.miguel.frozzenlist.frozzenbetaa;

import java.util.ArrayList;

public class Tray {

    private int trayID;
    private ArrayList<Product> productList= new ArrayList<Product>();

    public Tray(int trayID, int userID,ArrayList<Product>productList) {
        this.trayID = trayID;
        this.productList=productList;
    }
    public void showTray() {
        toStringForListInformation();
    }
    public void addProduct(ArrayList<Product>productList, Product product){

        productList.add(product);
    }
    public void removeProduct(int input,ArrayList<Product>productlist) {
        toStringForListInformation();
        toStringQuestionWhichIndexRemove();
        productlist.remove(input);
    }
    public int getTrayID() {
        return trayID;
    }
    public void setTrayID(int trayID) {
        this.trayID = trayID;
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void addProduct(String name,String typ,int productID) {
        Product product =new Product();
        product.setName(name);
        product.setTyp(typ);
        product.setProductID(productID);
        productList.add(product);
    }
    public void removeProduct(int input) {
        for(int i=0;i<productList.size();i++) {
            while(input==i) {
                productList.remove(i);
            }toStringMessageOutOfBons();
        }
    }
    public void changeProduct(int input,String name,String typ,int productID) {
        for(int i=0;i<productList.size();i++) {
            while(input==i) {
                productList.get(i);
                Product product =new Product();
                product.setName(name);
                product.setTyp(typ);
                product.setProductID(productID);
                productList.add(i, product);


            }toStringMessageOutOfBons();
        }
    }

    @Override
    public String toString() {
        return "Tray [trayID=" + trayID + ", productList=" + productList + "]";
    }
    @SuppressWarnings("unused")
    public String toStringForListInformation() {

        for(int i=0;i<productList.size();i++) {

            return "Listung des Faches: "+trayID+"\n "+productList.get(i);
        }
        return "Keine Liste vorhanden";
    }
    public static String toStringQuestionWhichIndexRemove() {
        return "Welchen Index wollen Sie löschen?";
    }
    public static String toStringMessageOutOfBons() {
        return "Falsche Eingabe. Deine Eingabe ist außerhalb der Indexreichweite!\nVersuche es nochmal";
    }
}
