package top.linsir.jd_shopping_mall.model.bean;

/**
 * Created by linSir
 * date at 2018/2/6.
 * describe: 商品model
 */

public class Goods {

    private int id;
    private String name;
    private String img;
    private int count;

    public Goods() {

    }

    public Goods(int id, String name, String img, int count) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.count = count;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
