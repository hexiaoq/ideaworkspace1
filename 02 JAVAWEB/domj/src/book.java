public class book {
    private String sn;
    private String name;
    private String author;
    private  String price;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public book() {
    }

    public book(String sn, String name, String author, String price) {
        this.sn = sn;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
       String s=sn+"-->"+name+"-->"+author+"-->"+price;
       return s;
    }
}
