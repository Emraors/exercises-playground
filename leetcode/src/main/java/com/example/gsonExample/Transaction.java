package com.example.gsonExample;

import java.util.Objects;

class Transaction {
	String id;
	long amount;

	public String getId() {
		return id;
	}

	public long getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Transaction that = (Transaction) o;
		return amount == that.amount && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, amount);
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"id='" + id + '\'' +
				", amount=" + amount +
				'}';
	}
}
