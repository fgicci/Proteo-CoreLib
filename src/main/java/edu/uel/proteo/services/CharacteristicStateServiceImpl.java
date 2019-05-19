package edu.uel.proteo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.CharacteristicState;
import edu.uel.proteo.repository.CharacteristicStateRepository;

@Service
public class CharacteristicStateServiceImpl extends StdRecordServiceImpl<CharacteristicState, Long> implements CharacteristicStateService {

	@Autowired
	public CharacteristicStateServiceImpl(CharacteristicStateRepository characteristicStateRepository) {
		super(characteristicStateRepository);
	}

	

}
