package ua.org.gostroy.oracleExamples.hr.web.jquery;


import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;

public class DataTableRequest implements Serializable {

	@XmlElement(name = "sEcho")
	private int echo;

	@XmlElement(name = "iColumns")
	private int numColumns;

	@XmlElement(name = "sColumns")
	private String columns;

	@XmlElement(name = "iDisplayStart")
	private int displayStart;

	@XmlElement(name = "iDisplayLength")
	private int displayLength;

	// has to be revisited for Object type dataProps.
	@XmlElement(name = "amDataProp")
	private List<Integer> dataProp;

	@XmlElement(name = "sSearch")
	private String searchQuery;

	@XmlElement(name = "asSearch")
	private List<String> columnSearches;

	@XmlElement(name = "bRegex")
	private boolean hasRegex;

	@XmlElement(name = "abRegex")
	private List<Boolean> regexColumns;

	@XmlElement(name = "abSearchable")
	private List<Boolean> searchColumns;

	@XmlElement(name = "iSortingCols")
	private int sortingCols;

	@XmlElement(name = "aiSortCol")
	private List<Integer> sortedColumns;

	@XmlElement(name = "asSortDir")
	private List<String> sortDirections;

	@XmlElement(name = "abSortable")
	private List<Boolean> sortableColumns;

	public int getEcho() {
		return echo;
	}

	public void setEcho(int echo) {
		this.echo = echo;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public int getDisplayStart() {
		return displayStart;
	}

	public void setDisplayStart(int displayStart) {
		this.displayStart = displayStart;
	}

	public int getDisplayLength() {
		return displayLength;
	}

	public void setDisplayLength(int displayLength) {
		this.displayLength = displayLength;
	}

	public List<Integer> getDataProp() {
		return dataProp;
	}

	public void setDataProp(List<Integer> dataProp) {
		this.dataProp = dataProp;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public List<String> getColumnSearches() {
		return columnSearches;
	}

	public void setColumnSearches(List<String> columnSearches) {
		this.columnSearches = columnSearches;
	}

	public boolean isHasRegex() {
		return hasRegex;
	}

	public void setHasRegex(boolean hasRegex) {
		this.hasRegex = hasRegex;
	}

	public List<Boolean> getRegexColumns() {
		return regexColumns;
	}

	public void setRegexColumns(List<Boolean> regexColumns) {
		this.regexColumns = regexColumns;
	}

	public List<Boolean> getSearchColumns() {
		return searchColumns;
	}

	public void setSearchColumns(List<Boolean> searchColumns) {
		this.searchColumns = searchColumns;
	}

	public int getSortingCols() {
		return sortingCols;
	}

	public void setSortingCols(int sortingCols) {
		this.sortingCols = sortingCols;
	}

	public List<Integer> getSortedColumns() {
		return sortedColumns;
	}

	public void setSortedColumns(List<Integer> sortedColumns) {
		this.sortedColumns = sortedColumns;
	}

	public List<String> getSortDirections() {
		return sortDirections;
	}

	public void setSortDirections(List<String> sortDirections) {
		this.sortDirections = sortDirections;
	}

	public List<Boolean> getSortableColumns() {
		return sortableColumns;
	}

	public void setSortableColumns(List<Boolean> sortableColumns) {
		this.sortableColumns = sortableColumns;
	}


}
