package edu.uel.proteo.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.uel.proteo.model.CharacteristicStateType;

@Service
public class CharacteristicStateTypeServiceImpl implements CharacteristicStateTypeService {

	@Override
	public List<String> getAllNames() {
		return Arrays.asList(CharacteristicStateType.values()).stream().map(CharacteristicStateType::name).collect(Collectors.toList());
	}

}
