package vn.api.spring.business.rdb.repository.issue;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.api.spring.business.entity.Issue;

public interface IssueJpaRepository extends JpaRepository<Issue, Integer>{

}
