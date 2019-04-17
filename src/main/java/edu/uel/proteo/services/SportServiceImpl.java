package edu.uel.proteo.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.Sport;

@Service
public class SportServiceImpl implements SportService {

	@Override
	public List<String> getAllNames() {
		return Arrays.asList(Sport.values()).stream().map(Sport::name).collect(Collectors.toList());
	}

}
