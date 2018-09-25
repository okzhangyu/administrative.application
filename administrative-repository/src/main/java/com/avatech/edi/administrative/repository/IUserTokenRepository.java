package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.dto.UserToken;
import org.springframework.data.repository.CrudRepository;

public interface IUserTokenRepository extends CrudRepository<UserToken,String> {
}
