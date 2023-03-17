package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.NewEntity;
@Repository
public interface INewRepository extends JpaRepository<NewEntity, Long>{

	@Query(value="select * from new as n where n.id =:max", nativeQuery= true)
	public List<NewEntity> findByIDLimit(int max);
}
