package com.rl.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by linghongbo on 2015/9/14.
 * 条件接口
 * 用户需实现并提供条件表达式逻辑
 */
public interface ICustomCriterion {

    public enum Operator {
        EQ, NE, LIKE, GT, LT, GTE, LTE, AND, OR
    }
    public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder);
}
