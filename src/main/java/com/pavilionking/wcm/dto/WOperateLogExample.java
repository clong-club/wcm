package com.pavilionking.wcm.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WOperateLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WOperateLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNull() {
            addCriterion("VISITOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNotNull() {
            addCriterion("VISITOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdEqualTo(Integer value) {
            addCriterion("VISITOR_ID =", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotEqualTo(Integer value) {
            addCriterion("VISITOR_ID <>", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThan(Integer value) {
            addCriterion("VISITOR_ID >", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("VISITOR_ID >=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThan(Integer value) {
            addCriterion("VISITOR_ID <", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThanOrEqualTo(Integer value) {
            addCriterion("VISITOR_ID <=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIn(List<Integer> values) {
            addCriterion("VISITOR_ID in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotIn(List<Integer> values) {
            addCriterion("VISITOR_ID not in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdBetween(Integer value1, Integer value2) {
            addCriterion("VISITOR_ID between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("VISITOR_ID not between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andOperateIpIsNull() {
            addCriterion("OPERATE_IP is null");
            return (Criteria) this;
        }

        public Criteria andOperateIpIsNotNull() {
            addCriterion("OPERATE_IP is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIpEqualTo(String value) {
            addCriterion("OPERATE_IP =", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotEqualTo(String value) {
            addCriterion("OPERATE_IP <>", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThan(String value) {
            addCriterion("OPERATE_IP >", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_IP >=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThan(String value) {
            addCriterion("OPERATE_IP <", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_IP <=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLike(String value) {
            addCriterion("OPERATE_IP like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotLike(String value) {
            addCriterion("OPERATE_IP not like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpIn(List<String> values) {
            addCriterion("OPERATE_IP in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotIn(List<String> values) {
            addCriterion("OPERATE_IP not in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpBetween(String value1, String value2) {
            addCriterion("OPERATE_IP between", value1, value2, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotBetween(String value1, String value2) {
            addCriterion("OPERATE_IP not between", value1, value2, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("OPERATOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("OPERATOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("OPERATOR_NAME =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("OPERATOR_NAME <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("OPERATOR_NAME >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("OPERATOR_NAME <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("OPERATOR_NAME like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("OPERATOR_NAME not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("OPERATOR_NAME in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("OPERATOR_NAME not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatoModelIsNull() {
            addCriterion("OPERATO_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andOperatoModelIsNotNull() {
            addCriterion("OPERATO_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andOperatoModelEqualTo(String value) {
            addCriterion("OPERATO_MODEL =", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelNotEqualTo(String value) {
            addCriterion("OPERATO_MODEL <>", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelGreaterThan(String value) {
            addCriterion("OPERATO_MODEL >", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATO_MODEL >=", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelLessThan(String value) {
            addCriterion("OPERATO_MODEL <", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelLessThanOrEqualTo(String value) {
            addCriterion("OPERATO_MODEL <=", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelLike(String value) {
            addCriterion("OPERATO_MODEL like", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelNotLike(String value) {
            addCriterion("OPERATO_MODEL not like", value, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelIn(List<String> values) {
            addCriterion("OPERATO_MODEL in", values, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelNotIn(List<String> values) {
            addCriterion("OPERATO_MODEL not in", values, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelBetween(String value1, String value2) {
            addCriterion("OPERATO_MODEL between", value1, value2, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andOperatoModelNotBetween(String value1, String value2) {
            addCriterion("OPERATO_MODEL not between", value1, value2, "operatoModel");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andOperateMethodIsNull() {
            addCriterion("OPERATE_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andOperateMethodIsNotNull() {
            addCriterion("OPERATE_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andOperateMethodEqualTo(String value) {
            addCriterion("OPERATE_METHOD =", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodNotEqualTo(String value) {
            addCriterion("OPERATE_METHOD <>", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodGreaterThan(String value) {
            addCriterion("OPERATE_METHOD >", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_METHOD >=", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodLessThan(String value) {
            addCriterion("OPERATE_METHOD <", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_METHOD <=", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodLike(String value) {
            addCriterion("OPERATE_METHOD like", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodNotLike(String value) {
            addCriterion("OPERATE_METHOD not like", value, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodIn(List<String> values) {
            addCriterion("OPERATE_METHOD in", values, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodNotIn(List<String> values) {
            addCriterion("OPERATE_METHOD not in", values, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodBetween(String value1, String value2) {
            addCriterion("OPERATE_METHOD between", value1, value2, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateMethodNotBetween(String value1, String value2) {
            addCriterion("OPERATE_METHOD not between", value1, value2, "operateMethod");
            return (Criteria) this;
        }

        public Criteria andOperateParamIsNull() {
            addCriterion("OPERATE_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andOperateParamIsNotNull() {
            addCriterion("OPERATE_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andOperateParamEqualTo(String value) {
            addCriterion("OPERATE_PARAM =", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamNotEqualTo(String value) {
            addCriterion("OPERATE_PARAM <>", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamGreaterThan(String value) {
            addCriterion("OPERATE_PARAM >", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_PARAM >=", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamLessThan(String value) {
            addCriterion("OPERATE_PARAM <", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_PARAM <=", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamLike(String value) {
            addCriterion("OPERATE_PARAM like", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamNotLike(String value) {
            addCriterion("OPERATE_PARAM not like", value, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamIn(List<String> values) {
            addCriterion("OPERATE_PARAM in", values, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamNotIn(List<String> values) {
            addCriterion("OPERATE_PARAM not in", values, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamBetween(String value1, String value2) {
            addCriterion("OPERATE_PARAM between", value1, value2, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateParamNotBetween(String value1, String value2) {
            addCriterion("OPERATE_PARAM not between", value1, value2, "operateParam");
            return (Criteria) this;
        }

        public Criteria andOperateResultIsNull() {
            addCriterion("OPERATE_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andOperateResultIsNotNull() {
            addCriterion("OPERATE_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andOperateResultEqualTo(String value) {
            addCriterion("OPERATE_RESULT =", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultNotEqualTo(String value) {
            addCriterion("OPERATE_RESULT <>", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultGreaterThan(String value) {
            addCriterion("OPERATE_RESULT >", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_RESULT >=", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultLessThan(String value) {
            addCriterion("OPERATE_RESULT <", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_RESULT <=", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultLike(String value) {
            addCriterion("OPERATE_RESULT like", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultNotLike(String value) {
            addCriterion("OPERATE_RESULT not like", value, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultIn(List<String> values) {
            addCriterion("OPERATE_RESULT in", values, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultNotIn(List<String> values) {
            addCriterion("OPERATE_RESULT not in", values, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultBetween(String value1, String value2) {
            addCriterion("OPERATE_RESULT between", value1, value2, "operateResult");
            return (Criteria) this;
        }

        public Criteria andOperateResultNotBetween(String value1, String value2) {
            addCriterion("OPERATE_RESULT not between", value1, value2, "operateResult");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}