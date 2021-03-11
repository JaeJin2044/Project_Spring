package com.java.webproject.model;

import org.springframework.stereotype.Component;

@Component
public class PageVO {
	private int m_pk;
	private int m_category;
	private int page;
	private int startPage;
	private int endPage;
	private int rowCnt;
	private int maxPageNum;
	private int sIdx;
	private int totalPage;
	private int c_seq;
	private String searchText;
	private int cntPage = 10;
	private int start;
	private int end;
	private int lastPage;
	private boolean prev;
	private boolean next;

	public PageVO() {
	}

	public PageVO(String searchText, int page, int rowCnt, int m_category) {
		setM_category(m_category);
		setSearchText(searchText);
		setPage(page);
		setRowCnt(rowCnt);
		setsIdx((page - 1) * getRowCnt());
	}

	public void dataCalc() {
		setTotalPage(getMaxPageNum() / getRowCnt());
		if (getTotalPage() < 1) {
			setLastPage(0);
			setEndPage(0);
		} else {
			calcLastPage(getMaxPageNum(), getRowCnt());
			calcStartEndPage(getPage(), getCntPage());
			calcStartEnd(getPage(), getCntPage());
		}
	}

	// 제일 마지막 페이지 계산
	public void calcLastPage(int maxPageNum, int rowCnt) {
		setLastPage((int) Math.ceil((double) maxPageNum / (double) rowCnt));
	}

	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int page, int cntPage) {
		setEndPage(((int) Math.ceil((double) page / (double) cntPage) * cntPage));

		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}

		if (getLastPage() < 10) {
			setStartPage(1);
		} else if (getEndPage() % 10 != 0) {
			setStartPage(getPage());
		} else {
			setStartPage(getEndPage() - cntPage + 1);
		}

		prev = getStartPage() == 1 ? false : true;
		next = getEndPage() * getRowCnt() >= getMaxPageNum() ? false : true;
	}

	public void calcStartEnd(int page, int rowCnt) {
		setEnd(page * rowCnt);
		setStart(getEnd() - rowCnt + 1);
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
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

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getC_seq() {
		return c_seq;
	}

	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getMaxPageNum() {
		return maxPageNum;
	}

	public void setMaxPageNum(int maxPageNum) {
		this.maxPageNum = maxPageNum;
	}

	public int getM_pk() {
		return m_pk;
	}

	public void setM_pk(int m_pk) {
		this.m_pk = m_pk;
	}

	public int getM_category() {
		return m_category;
	}

	public void setM_category(int m_category) {
		this.m_category = m_category;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

}
