import java.util.Objects;

public class Smartphone {

    private String name;
    private int price;
    private int releaseYear;
    private int memorySize;
    private Color color;
    private double diagonalScreenSize;

    public Smartphone() {
    }

    public Smartphone(String name, int price, int releaseYear, int memorySize, Color color, double diagonalScreenSize) {
        this.name = name;
        this.price = price;
        this.releaseYear = releaseYear;
        this.memorySize = memorySize;
        this.color = color;
        this.diagonalScreenSize = diagonalScreenSize;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getMemorySize() {
        return this.memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDiagonalScreenSize() {
        return this.diagonalScreenSize;
    }

    public void setDiagonalScreenSize(double diagonalScreenSize) {
        this.diagonalScreenSize = diagonalScreenSize;
    }

    public Smartphone name(String name) {
        setName(name);
        return this;
    }

    public Smartphone price(int price) {
        setPrice(price);
        return this;
    }

    public Smartphone releaseYear(int releaseYear) {
        setReleaseYear(releaseYear);
        return this;
    }

    public Smartphone memorySize(int memorySize) {
        setMemorySize(memorySize);
        return this;
    }

    public Smartphone color(Color color) {
        setColor(color);
        return this;
    }

    public Smartphone diagonalScreenSize(double diagonalScreenSize) {
        setDiagonalScreenSize(diagonalScreenSize);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Smartphone)) {
            return false;
        }
        Smartphone smartphone = (Smartphone) o;
        return Objects.equals(name, smartphone.name) && price == smartphone.price && releaseYear == smartphone.releaseYear && memorySize == smartphone.memorySize && Objects.equals(color, smartphone.color) && diagonalScreenSize == smartphone.diagonalScreenSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, releaseYear, memorySize, color, diagonalScreenSize);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", releaseYear='" + getReleaseYear() + "'" +
            ", memorySize='" + getMemorySize() + "'" +
            ", color='" + getColor() + "'" +
            ", diagonalScreenSize='" + getDiagonalScreenSize() + "'" +
            "}";
    }

    
}