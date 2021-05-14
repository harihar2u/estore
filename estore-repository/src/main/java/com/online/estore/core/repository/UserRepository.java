package com.online.estore.core.repository;

import com.online.estore.core.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>  {
    User findByUsername(String username);
}

