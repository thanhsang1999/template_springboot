package com.thanhsang.service;

import com.thanhsang.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
	NewDTO delete(long id);
}
