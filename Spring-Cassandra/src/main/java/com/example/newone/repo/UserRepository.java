package com.example.newone.repo;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.example.newone.entity.User;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {
 
 
}
