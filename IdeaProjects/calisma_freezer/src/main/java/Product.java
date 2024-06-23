import java.time.LocalDate;
import org.apache.commons.lang3.builder.EqualsBuilder;

public abstract class Product {

    int size;
    LocalDate date;

    public Product(int siz, LocalDate dat) {
        this.size= siz;
        this.date = dat;
    }

    @Override
    public String toString() {
        return "Size:" + size + "Date:" + date;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        else if (obj == null || this.getClass() != obj.getClass()) return false;

        else {
            EqualsBuilder eq = new EqualsBuilder();
            eq.append(this.size, ((Product) obj).size);
            eq.append(this.date,((Product) obj).date);
            return eq.isEquals();
        }
    }
}
