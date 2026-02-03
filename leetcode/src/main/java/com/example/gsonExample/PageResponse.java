package com.example.gsonExample;

import java.util.List;
import java.util.Objects;

class PageResponse {

	List<Transaction> data;
	int page;
	int total_pages;

	public List<Transaction> getData() {
		return data;
	}

	public int getPage() {
		return page;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PageResponse that = (PageResponse) o;
		return page == that.page && total_pages == that.total_pages && Objects.equals(data, that.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, page, total_pages);
	}

	@Override
	public String toString() {
		return "PageResponse{" +
				"data=" + data +
				", page=" + page +
				", total_pages=" + total_pages +
				'}';
	}
}

