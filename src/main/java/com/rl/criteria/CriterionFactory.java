package com.rl.criteria;

/**
 * Created by linghongbo on 2015/9/15.
 * 条件构造器，根据条件操作返回相应条件对象
 */
public class CriterionFactory {

    public static ICustomCriterion eq(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.EQ);
    }

    public static ICustomCriterion ne(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.NE);
    }

    public static ICustomCriterion like(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.LIKE);
    }

    public static ICustomCriterion gt(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.GT);
    }

    public static ICustomCriterion lt(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.LT);
    }

    public static ICustomCriterion gte(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.GTE);
    }

    public static ICustomCriterion lte(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.LTE);
    }

    public static ICustomCriterion and(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.AND);
    }

    public static ICustomCriterion or(String key, Object value, boolean allowNull) {
        checkValue(value, allowNull);
        return new CustomCriterion(key, value, ICustomCriterion.Operator.OR);
    }

    private static void checkValue(Object value, boolean allowNull) {
        //如果不允许value值为null
        if (!allowNull && value == null) {
            throw new IllegalStateException("checkValue object don't is null!");
        }
    }
}
