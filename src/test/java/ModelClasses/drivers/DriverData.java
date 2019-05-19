package ModelClasses.drivers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DriverData {
	
	DriverData MRData;
	
	String xmlns;
	String series;
	String url;
	String limit;
	String offset;
	String total;
	
	DriverTable DriverTable;
	
	public DriverData getMRData() {
		return MRData;
	}
	public void setMRData(DriverData mRData) {
		MRData = mRData;
	}
	public String getXmlns() {
		return xmlns;
	}
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public DriverTable getDriverTable() {
		return DriverTable;
	}
	public void setDriverTable(DriverTable driverTable) {
		DriverTable = driverTable;
	}
	
}
