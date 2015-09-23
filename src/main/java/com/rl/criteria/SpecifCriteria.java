package com.rl.criteria;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linghongbo on 2015/9/14.
 * 定义一个自定条件查询容器
 */

public class SpecifCriteria<T> implements Specification<T> {

    private List<ICustomCriterion> criterions = new ArrayList<ICustomCriterion>();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if (!criterions.isEmpty()) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            for (ICustomCriterion custom : criterions) {
                predicates.add(custom.toPredicate(root, criteriaQuery, criteriaBuilder));
            }

            if (predicates.size() > 0) {
                predicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }
        return predicate;
    }

    public void add(ICustomCriterion criterion){
        if(criterion!=null){
            criterions.add(criterion);
        }
    }

}
