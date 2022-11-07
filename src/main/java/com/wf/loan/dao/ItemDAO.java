package com.wf.loan.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wf.loan.model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item,Integer> {
 
	@Query("SELECT t from Item t where t.item_status = 'Y'")
	List<Item> getAvailableItems();
}

