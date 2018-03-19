package i9.defence.platform.model;

import java.util.Date;

import i9.defence.platform.utils.StringUtil;

public class UpStreamDecode {
    private Integer id;

    private String hexStr;

    private Date submitDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHexStr() {
        return hexStr;
    }

    public void setHexStr(String hexStr) {
        this.hexStr = hexStr == null ? null : hexStr.trim();
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
    public String getSubmitDateStr() {
    	if(submitDate != null) {
    		return StringUtil.dateToStringWithoutTime(submitDate);
    	}
        return "";
    }
}