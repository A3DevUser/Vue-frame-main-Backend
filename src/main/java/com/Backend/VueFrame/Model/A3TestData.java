package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_A3_OBR_OUTPUT_TBL")
public class A3TestData {
	
	  
		@Id
		@Column(name = "ID")
		private String idData;
		
		@Column(name = "VENDOR_CODE")
		private String vendor_name;
		
		@Column(name = "TEST_ID")
		private String id;
		
		@Column(name = "TEST_TITLE")
		private String testTitle;
		
		@Column(name = "RESPONSE")
		private String response;

		public String getIdData() {
			return idData;
		}

		public void setIdData(String idData) {
			this.idData = idData;
		}

		public String getVendor_name() {
			return vendor_name;
		}

		public void setVendor_name(String vendor_name) {
			this.vendor_name = vendor_name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTestTitle() {
			return testTitle;
		}

		public void setTestTitle(String testTitle) {
			this.testTitle = testTitle;
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		
		
		public A3TestData(String idData, String vendor_name, String id, String testTitle, String response) {
			super();
			this.idData = idData;
			this.vendor_name = vendor_name;
			this.id = id;
			this.testTitle = testTitle;
			this.response = response;
		}

		public A3TestData() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
		
		
	    


}
