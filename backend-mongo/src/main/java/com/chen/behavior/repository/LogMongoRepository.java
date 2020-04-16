package com.chen.behavior.repository;

import com.chen.behavior.entity.Behavior;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * mongo方式
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Repository
public interface LogMongoRepository extends MongoRepository<Behavior, String> {
}
