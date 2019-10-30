package cn.edu.sjtu.industry_backend.repository;

import cn.edu.sjtu.industry_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUserId(final String userId);
}
