package mycommands.com.myloginpart;

class Item{

    String name;
    int image;
    double rating;
    boolean type;

    public Item(String name, int image, double rating, boolean type){
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.type = type;
    }

    public Item(String name){
        this.name = name;
        this.image = image;
        this.rating = rating;
    }
}
