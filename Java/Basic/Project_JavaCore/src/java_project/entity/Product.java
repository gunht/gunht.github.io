package java_project.entity;

public class Product extends AbstractId {
    private String name;
    private int price;
    private long categoryId;
    private Category category;

    public Product(String name, int price, long categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return getId() + ". " + getName() + " " + getPrice() + "đ";
    }
}
