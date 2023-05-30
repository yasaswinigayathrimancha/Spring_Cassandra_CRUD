package com.example.demo.repository;



import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.User;

@Repository
public interface UserRepo extends CassandraRepository<User, String> {

	//@Query(value = "select * from user_table where user_name = ?1")
	Optional<User> findByUserName(String userName);

}
