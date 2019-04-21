package edu.uel.proteo.services;

import java.util.Iterator;

import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.model.Protocol;

public interface ProtocolService extends StdRecordService<Protocol, Long> {
	
	Protocol add(Protocol protocol, Characteristic characteristic);
	Protocol addAll(Protocol protocol, Iterator<Characteristic> characteristic);
}
