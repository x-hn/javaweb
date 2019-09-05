package com.xhn.Service;

import com.xhn.model.Lend;

public interface ILendService {

	int countByBookId(int id);

	int countByUserId(int id);

	int add(Lend lend);

}
