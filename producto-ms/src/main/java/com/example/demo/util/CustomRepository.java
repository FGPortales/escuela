package com.example.demo.util;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
///no se necesita en persona repository utilizar extend crudrepository ... ya que si extiende de esta clase ..esta tiene JpaRepository el cual contiene al crud 
public interface CustomRepository <T,ID extends Serializable> extends JpaRepository<T, ID>{	
	void refresh(T t);
}
