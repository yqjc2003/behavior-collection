package com.chen.behavior.repository;

import com.chen.behavior.entity.Behavior;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * es方式
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Repository
public interface LogElasticRepository extends ElasticsearchRepository<Behavior, String> {
}
