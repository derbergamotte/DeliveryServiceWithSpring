package com.ak.interfaces;

import com.ak.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GenericDao<T extends BaseEntity> extends JpaRepository<T, Long> {

}
