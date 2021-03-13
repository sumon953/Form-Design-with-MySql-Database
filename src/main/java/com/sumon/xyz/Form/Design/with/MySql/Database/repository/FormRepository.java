package com.sumon.xyz.Form.Design.with.MySql.Database.repository;

import com.sumon.xyz.Form.Design.with.MySql.Database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<User,Long> {

}
