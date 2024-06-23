import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Freezer implements Container<Product> {

    private List<Product> products;
    private int occupiedSpace;
    private int emptySpace;
    private int capacity;

    public Freezer(int capacit){
        occupiedSpace=0;
        emptySpace = capacit;
        this.capacity = capacit;
        this.products = new ArrayList<>();
    }

    public int getOccupied() { return occupiedSpace;}
    public int getEmptySpace() { return emptySpace;}

    static class LastingDateComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.date.compareTo(p2.date);
        }
    }

    @Override
    public boolean put(Product item) {
        if (item.size > emptySpace) return false;
        products.add(item);
        products.sort(new LastingDateComparator());
        occupiedSpace += item.size;
        emptySpace = capacity - occupiedSpace;
        return true;
    }

    @Override
    public Product remove() {
        if (products.isEmpty()) return null;
        occupiedSpace -= products.getFirst().size;
        emptySpace = capacity - occupiedSpace;
        return products.removeFirst();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
