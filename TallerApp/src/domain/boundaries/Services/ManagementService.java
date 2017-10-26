package domain.boundaries.Services;

public interface ManagementService<E> {

    void insert(E entity);

    void update(E entity);
    
    void load(E entity);
}
