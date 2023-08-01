package service;

import model.product.Product;

import java.util.List;

public interface IProductService <E>{
    List<E> getAll();
    void add(E e);
    void delete(int id);
    void edit(int id, E e);
    Product findIndexById(int id);

}
