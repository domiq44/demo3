package com.example.demo3.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo3.entity.Country;
import com.example.demo3.repository.CountryRepository;
import com.example.demo3.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country getByCode(String code) {
		Optional<Country> countryOptional = countryRepository.findById(code);
		if (countryOptional.isPresent()) {
			return countryOptional.get();
		} else {
			throw new NoSuchElementException();
		}
	}

	@Transactional
	@Override
	public List<Country> saveFromCsv(String file) {
		List<Country> countries = getCountries(file);
		return countryRepository.saveAll(countries);
	}

	private static List<Country> getCountries(String file) {
		List<Country> countries = new ArrayList<>();

		try (FileInputStream inputStream = new FileInputStream(new File(file));
				Scanner scanner = new Scanner(inputStream, "UTF-8")) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] columns = line.split(",", -1);
				countries.add(new Country(columns[1], columns[0]));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return countries;
	}
}
