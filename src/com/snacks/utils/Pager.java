package com.snacks.utils;

import java.util.List;

public class Pager {

	int currentPage;

	int numPerPage = 20;

	int totalPage;

	int totalCount;

	int start;

	int end;
	
	List<?> dataList;

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {

		if (currentPage < 1) {
			currentPage = 1;
		} else {
			start = numPerPage * (currentPage - 1);
		}

		this.currentPage = currentPage;

	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		this.totalCount = totalCount;

		if (totalPage < currentPage) {

			currentPage = totalPage;
			if(totalCount == 0){
				start = 0;
			}else{
				start = numPerPage * (currentPage - 1);
			}
		} 
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
