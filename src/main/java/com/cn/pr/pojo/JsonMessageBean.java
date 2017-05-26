package com.cn.pr.pojo;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class JsonMessageBean {
		
		private static final long serialVersionUID = -2993948710258547901L;
		
		@JsonProperty
		private String ACTION_NAME; //接口名称
		
		@JsonProperty
		private String ACTION_INVOKER;
		
		@JsonProperty
		private String ACTION_RETURN_CODE = "000000"; //返回码  默认成功
		
		@JsonProperty 
		private String ACTION_RETURN_MESSAGE = "成功";//返回码错误信息
		
		@JsonProperty  
		private Object ACTION_INFO; //数据体
		
		@JsonProperty
		private Map<String,Object> ACTION_TOKEN; //TOKEN
		
		@JsonIgnore
		public String getACTION_NAME() {
			return ACTION_NAME;
		}
		
		public void setACTION_NAME(String aCTION_NAME) {
			ACTION_NAME = aCTION_NAME;
		}
		
		@JsonIgnore
		public String getACTION_INVOKER() {
			return ACTION_INVOKER;
		}
		
		public void setACTION_INVOKER(String aCTION_INVOKER) {
			ACTION_INVOKER = aCTION_INVOKER;
		}
		
		@JsonIgnore
		public String getACTION_RETURN_CODE() {
			return ACTION_RETURN_CODE;
		}
		
		public void setACTION_RETURN_CODE(String aCTION_RETURN_CODE) {
			ACTION_RETURN_CODE = aCTION_RETURN_CODE;
		}
		
		@JsonIgnore
		public String getACTION_RETURN_MESSAGE() {
			return ACTION_RETURN_MESSAGE;
		}
		
		public void setACTION_RETURN_MESSAGE(String aCTION_RETURN_MESSAGE) {
			ACTION_RETURN_MESSAGE = aCTION_RETURN_MESSAGE;
		}

		public Map<String, Object> getACTION_TOKEN() {
			return ACTION_TOKEN;
		}

		public void setACTION_TOKEN(Map<String, Object> aCTION_TOKEN) {
			ACTION_TOKEN = aCTION_TOKEN;
		}

		@JsonIgnore
		public Object getACTION_INFO() {
			return ACTION_INFO;
		}

		public void setACTION_INFO(Object aCTION_INFO) {
			ACTION_INFO = aCTION_INFO;
		}

	}


