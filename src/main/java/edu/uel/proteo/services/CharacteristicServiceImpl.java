package edu.uel.proteo.services;

import java.util.Iterator;

import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.model.CharacteristicState;
import edu.uel.proteo.repository.CharacteristicRepository;

@Service
public class CharacteristicServiceImpl extends StdRecordServiceImpl<Characteristic, Long> implements CharacteristicService {

	
	CharacteristicRepository characteristicRepository;
	
	@Autowired
	public CharacteristicServiceImpl(CharacteristicRepository characteristicRepository) {
		super(characteristicRepository);
		this.characteristicRepository = characteristicRepository;
	}

	@Override
	public Characteristic add(Characteristic characteristic, CharacteristicState state) {
		characteristic.addState(state);
		return update(characteristic);
	}

	@Override
	@Transactional
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public Characteristic addAll(Characteristic characteristic, Iterator<CharacteristicState> states) {
		// TODO Auto-generated method stub
		return null;
	}
}
