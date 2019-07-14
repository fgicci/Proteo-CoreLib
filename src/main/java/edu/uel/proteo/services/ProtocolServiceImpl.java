package edu.uel.proteo.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.repository.ProtocolRepository;

@Service
public class ProtocolServiceImpl extends StdRecordServiceImpl<Protocol, Long> implements ProtocolService {

	ProtocolRepository protocolRepository;
	
	@Autowired 
	public ProtocolServiceImpl(ProtocolRepository protocolRepository) {
		super(protocolRepository, Protocol.class);
		this.protocolRepository = protocolRepository;
	}

	@Override
	public Protocol add(Protocol protocol, Characteristic characteristic) {
		protocol.addCharacteristic(characteristic);
		return update(protocol);
	}

	@Override
	public Protocol addAll(Protocol protocol, Iterator<Characteristic> characteristic) {
		// TODO Auto-generated method stub
		return null;
	}

}
