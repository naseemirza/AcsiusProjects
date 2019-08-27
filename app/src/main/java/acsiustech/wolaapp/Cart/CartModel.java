package acsiustech.wolaapp.Cart;

public class CartModel {

    private int ImageUrl;
    private String PName;
    private String Pcurrn;
    private String PPrice;

    public CartModel(int imageUrl, String PName, String pcurrn, String PPrice) {
        ImageUrl = imageUrl;
        this.PName = PName;
        Pcurrn = pcurrn;
        this.PPrice = PPrice;
    }

    public int getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(int imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPcurrn() {
        return Pcurrn;
    }

    public void setPcurrn(String pcurrn) {
        Pcurrn = pcurrn;
    }

    public String getPPrice() {
        return PPrice;
    }

    public void setPPrice(String PPrice) {
        this.PPrice = PPrice;
    }
}
