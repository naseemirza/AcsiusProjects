package acsiustech.wolaapp.Lititon;

/**
 * Created by SAI on 17-07-2019.
 */

public class LititonModel {

    private String currency;
    private String price;
    private int image;
    private String Name;
    private String offtxt;
   // private String SoldItems;
   // private String OrdrdItems;


    public LititonModel(String currency, String price, int image, String name, String offtxt) {
        this.currency = currency;
        this.price = price;
        this.image = image;
        Name = name;
        this.offtxt = offtxt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOfftxt() {
        return offtxt;
    }

    public void setOfftxt(String offtxt) {
        this.offtxt = offtxt;
    }
}
