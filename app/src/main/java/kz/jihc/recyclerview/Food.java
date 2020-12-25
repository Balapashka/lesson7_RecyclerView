package kz.jihc.recyclerview;

public class Food {
    int photo;
    String title;
    String desc;
    int price;


    public Food(int photo, String title, String desc, int price){
        this.photo = photo;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }
}
