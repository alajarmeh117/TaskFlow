package com.thistlewick.repository;
import java.util.List;

public interface Repository<T,ID> {
      void save (T entity);    // Object -- > Task , User , Reminder -- > T 
      T findById(ID id);	  // ID - > Integer --> give me the ID and i will return the Object for this id 
      List<T> findAll();          // return list of Elemnt  
      void update(T entity);
      void delete(ID id);

}
