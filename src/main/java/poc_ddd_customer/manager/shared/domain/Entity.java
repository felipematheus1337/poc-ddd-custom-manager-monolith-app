package poc_ddd_customer.manager.shared.domain;

import java.util.Objects;

public abstract class Entity<ID> {

    protected final ID id;

   protected Entity(ID id) {
       this.id = Objects.requireNonNull(id, "ID cannot be null");
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
