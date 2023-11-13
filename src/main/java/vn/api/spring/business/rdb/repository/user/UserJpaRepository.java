package vn.api.spring.business.rdb.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.api.spring.business.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
