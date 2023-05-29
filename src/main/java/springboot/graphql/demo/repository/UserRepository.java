package springboot.graphql.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.graphql.demo.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
