package com.luxoft.springdb.tx.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxoft.springdb.tx.orm.model.Log;

public interface LogDao extends JpaRepository<Log, Integer>, LogDaoCustom {


}
