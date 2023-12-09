package dao;

import model.Produto;

public interface CarrinhoDB {
     void delete(String cod);
   void add(Produto e);
   Produto get(String cod);
}
