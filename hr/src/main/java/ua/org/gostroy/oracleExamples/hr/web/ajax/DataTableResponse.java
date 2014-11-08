package ua.org.gostroy.oracleExamples.hr.web.ajax;


import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//  DataTableResponse<T>
public class DataTableResponse implements Serializable {

	@XmlElement(name = "iTotalRecords")
	private long totalRecords;

	@XmlElement(name = "iTotalDisplayRecords")
	private long totalDisplayRecords;

	@XmlElement(name = "sEcho")
	private int echo;

	@XmlElement(name = "sColumns")
	private String columns;

	@XmlElement(name = "aaData")
	private List<List<String>> data = new ArrayList<List<String>>();

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public long getTotalDisplayRecords() {
		return totalDisplayRecords;
	}

	public void setTotalDisplayRecords(long totalDisplayRecords) {
		this.totalDisplayRecords = totalDisplayRecords;
	}

	public int getEcho() {
		return echo;
	}

	public void setEcho(int echo) {
		this.echo = echo;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> pagedRecords) {
		this.data = pagedRecords;
	}
}