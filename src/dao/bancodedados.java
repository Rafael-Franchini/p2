package dao;

import model.Produto;

public interface bancodedados {
    void delete(String cod);
   void update(Produto e);
   void add(Produto e);
   Produto get(String cod);
}
