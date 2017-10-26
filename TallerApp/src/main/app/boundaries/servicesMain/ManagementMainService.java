package main.app.boundaries.servicesMain;

public interface ManagementMainService<E> {

    void insert(E entity);

    void update(E entity);
    
    void load(E entity);
    
}
