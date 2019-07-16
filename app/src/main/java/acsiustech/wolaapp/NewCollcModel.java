package acsiustech.wolaapp;

/**
 * Created by SAI on 09-07-2019.
 */

public class NewCollcModel {

    private int image;
    private String Name;
    private String currency;
    private String price;

    public NewCollcModel(int image, String name, String currency, String price) {
        this.image = image;
        Name = name;
        this.currency = currency;
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
}
