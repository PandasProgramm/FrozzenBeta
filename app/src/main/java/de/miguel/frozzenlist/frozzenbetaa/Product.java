package de.miguel.frozzenlist.frozzenbetaa;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Objects;

   /**
   =================================================================================================
    @author Miguel Gutierrez, project FrozzenList
    @version 1.0Beta
    @param: Object initialize Product: Attributs: name,(variable)ProductID,FrozzenDate:Expirationdate
           to set date memory.
    @link Tray
    ================================================================================================
   */

public class Product {

    private String name;
    private DateFormat frozzenDate;
    private double expirationDate;

    //Instance
    public Product(String name, DateFormat frozzenDate, double expirationDate) {
        this.name = name;
        this.frozzenDate = frozzenDate;
        //frozzenDate=DateFormat.getDateInstance(DateFormat.LONG);
        this.expirationDate=expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setExpirationDate(double expirationDate){
        this.expirationDate=expirationDate;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", ProductID="   +"]";
    }
    //option for database
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return  name.equals(product.name) &&
                frozzenDate.equals(product.frozzenDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,  frozzenDate);
    }

}
