package i9.defence.platform.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StreamOriginExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StreamOriginExample() {
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
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andJsonstrIsNull() {
			addCriterion("jsonstr is null");
			return (Criteria) this;
		}

		public Criteria andJsonstrIsNotNull() {
			addCriterion("jsonstr is not null");
			return (Criteria) this;
		}

		public Criteria andJsonstrEqualTo(String value) {
			addCriterion("jsonstr =", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrNotEqualTo(String value) {
			addCriterion("jsonstr <>", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrGreaterThan(String value) {
			addCriterion("jsonstr >", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrGreaterThanOrEqualTo(String value) {
			addCriterion("jsonstr >=", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrLessThan(String value) {
			addCriterion("jsonstr <", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrLessThanOrEqualTo(String value) {
			addCriterion("jsonstr <=", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrLike(String value) {
			addCriterion("jsonstr like", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrNotLike(String value) {
			addCriterion("jsonstr not like", value, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrIn(List<String> values) {
			addCriterion("jsonstr in", values, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrNotIn(List<String> values) {
			addCriterion("jsonstr not in", values, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrBetween(String value1, String value2) {
			addCriterion("jsonstr between", value1, value2, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andJsonstrNotBetween(String value1, String value2) {
			addCriterion("jsonstr not between", value1, value2, "jsonstr");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIsNull() {
			addCriterion("submitDate is null");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIsNotNull() {
			addCriterion("submitDate is not null");
			return (Criteria) this;
		}

		public Criteria andSubmitDateEqualTo(Date value) {
			addCriterion("submitDate =", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotEqualTo(Date value) {
			addCriterion("submitDate <>", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateGreaterThan(Date value) {
			addCriterion("submitDate >", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateGreaterThanOrEqualTo(Date value) {
			addCriterion("submitDate >=", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateLessThan(Date value) {
			addCriterion("submitDate <", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateLessThanOrEqualTo(Date value) {
			addCriterion("submitDate <=", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIn(List<Date> values) {
			addCriterion("submitDate in", values, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotIn(List<Date> values) {
			addCriterion("submitDate not in", values, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateBetween(Date value1, Date value2) {
			addCriterion("submitDate between", value1, value2, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotBetween(Date value1, Date value2) {
			addCriterion("submitDate not between", value1, value2, "submitDate");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNull() {
			addCriterion("channelId is null");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNotNull() {
			addCriterion("channelId is not null");
			return (Criteria) this;
		}

		public Criteria andChannelIdEqualTo(String value) {
			addCriterion("channelId =", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotEqualTo(String value) {
			addCriterion("channelId <>", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThan(String value) {
			addCriterion("channelId >", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
			addCriterion("channelId >=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThan(String value) {
			addCriterion("channelId <", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThanOrEqualTo(String value) {
			addCriterion("channelId <=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLike(String value) {
			addCriterion("channelId like", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotLike(String value) {
			addCriterion("channelId not like", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdIn(List<String> values) {
			addCriterion("channelId in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotIn(List<String> values) {
			addCriterion("channelId not in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdBetween(String value1, String value2) {
			addCriterion("channelId between", value1, value2, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotBetween(String value1, String value2) {
			addCriterion("channelId not between", value1, value2, "channelId");
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