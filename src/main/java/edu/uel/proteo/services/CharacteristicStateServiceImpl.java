package edu.uel.proteo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uel.proteo.exception.ResourceNotFoundException;
import edu.uel.proteo.model.CharacteristicState;
import edu.uel.proteo.repository.CharacteristicStateRepository;
import edu.uel.proteo.utils.RecordUtils;

@Service
public class CharacteristicStateServiceImpl implements CharacteristicStateService {

	@Autowired
	private CharacteristicStateRepository characteristicStateRepository;
	
	@Override
	public CharacteristicState findById(Long id) {
		return characteristicStateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Characteristic State", "id", id.toString()));
	}

	@Override
	@Transactional(readOnly = true)
	public List<CharacteristicState> findAll() {
		return characteristicStateRepository.findAll();
	}

	@Override
	@Transactional
	public CharacteristicState save(CharacteristicState characteristicState) {
		characteristicState.setActive(RecordUtils.ACTIVE);
		return characteristicStateRepository.save(characteristicState);
	}

	@Override
	@Transactional
	public CharacteristicState update(CharacteristicState characteristicState) {
		return characteristicStateRepository.save(characteristicState);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(CharacteristicState type) {
		// TODO Auto-generated method stub

	}

}
