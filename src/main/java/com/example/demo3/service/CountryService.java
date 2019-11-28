package com.example.demo3.service;

import java.util.List;

import com.example.demo3.entity.Country;

public interface CountryService {

	Country getByCode(String code);

	List<Country> saveFromCsv(String file);

}
