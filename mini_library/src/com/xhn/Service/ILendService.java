package com.xhn.Service;

import java.util.List;

import com.xhn.model.Lend;

public interface ILendService {

	int countByBookId(int id);

	int countByUserId(int id);

	int add(Lend lend);

	List<Lend> get(int parseInt);

	Lend getLend(int parseInt);

	int delete(int id);

	int record(int parseInt, int parseInt2);


}
