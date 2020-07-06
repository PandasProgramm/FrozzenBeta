package de.miguel.frozzenlist.frozzenbetaa;

public class Product {


    private String name;
    private int ProductID;
    private String typ;
    private int frozzenDate;


    public void setName(String name) {
        this.name = name;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }


    @Override
    public String toString() {
        return "Product [name=" + name + ", ProductID=" + ProductID + ", typ=" + typ + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ProductID;
        result = prime * result + frozzenDate;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((typ == null) ? 0 : typ.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (ProductID != other.ProductID)
            return false;
        if (frozzenDate != other.frozzenDate)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (typ != other.typ)
            return false;
        return true;
    }
}
