package edu.uel.proteo.services;

import java.util.Iterator;

import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.model.CharacteristicState;

public interface CharacteristicService extends StdDocumentService<Characteristic, Long> {
	
	Characteristic add(Characteristic characteristic, CharacteristicState state);
	Characteristic addAll(Characteristic characteristic, Iterator<CharacteristicState> state);
}
