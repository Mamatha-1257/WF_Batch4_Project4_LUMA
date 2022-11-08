package com.wf.loan.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wf.loan.model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item,Integer> {
 
	@Query("SELECT t from Item t where t.item_status = 'Y'")
	List<Item> getAvailableItems();


	@Query(value="SELECT * FROM items_master  where item_id= :item_id",nativeQuery = true)
	Item findItemByItemId(@Param("item_id") String item_id);
}

