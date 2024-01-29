package com.mekanapp.mekanuserms.account;

import com.mekanapp.mekanuserms.shared.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDto> {



}
