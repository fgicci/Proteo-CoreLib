package edu.uel.proteo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.Character;
import edu.uel.proteo.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository characterRepository;
	
	
	@Override
	public Character findById(Long id) {
		return characterRepository.findById(id).get();
	}

	@Override
	public List<Character> findAll() {
		return characterRepository.findAll();
	}

	@Override
	public Character save(Character character) {
		character.setCreateDate(new Date());
		character.setUpdateDate(new Date());
		return characterRepository.save(character);
	}

	@Override
	public Character update(Character character) {
		character.setUpdateDate(new Date());
		return characterRepository.save(character);
	}

	@Override
	public void delete(Long id) {
		if (characterRepository.existsById(id))
			characterRepository.deleteById(id);
	}

}
