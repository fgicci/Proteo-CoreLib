package edu.uel.proteo.services;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import edu.uel.proteo.exception.ResourceNotFoundException;
import edu.uel.proteo.model.Characteristic;
import edu.uel.proteo.model.Protocol;
import edu.uel.proteo.model.Protocol_;
import edu.uel.proteo.repository.ProtocolRepository;
import edu.uel.proteo.utils.RecordUtils;

@Service
public class ProtocolServiceImpl implements ProtocolService {

	private static final String RESOURCE_NAME = Protocol.class.getName();
	
	@Autowired 
	private ProtocolRepository protocolRepository;
	
	@Override
	public Protocol findById(Long id) {
		return protocolRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", String.valueOf(id)));
	}

	@Override
	public List<Protocol> findAll() {
		return protocolRepository.findAll(new Specification<Protocol>() {
			@Override
			public Predicate toPredicate(Root<Protocol> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Boolean>get(Protocol_.active), RecordUtils.ACTIVE);
			}
		});
	}

	@Override
	public Protocol save(Protocol protocol) {
		protocol.setActive(RecordUtils.ACTIVE);
		return protocolRepository.save(protocol);
	}

	@Override
	public Protocol update(Protocol protocol) {
		findById(protocol.getId());
		if (protocol.getActive() == null) protocol.setActive(RecordUtils.ACTIVE);
		return protocolRepository.save(protocol);
	}

	@Override
	public void delete(Long key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Protocol entity) {
		// TODO Auto-generated method stub
		
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
