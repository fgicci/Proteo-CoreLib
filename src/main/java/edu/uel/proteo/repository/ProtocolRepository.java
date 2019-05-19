package edu.uel.proteo.repository;

import org.springframework.stereotype.Repository;

import edu.uel.proteo.model.Protocol;

@Repository("protocolRepository")
public interface ProtocolRepository extends StdRecordRepository<Protocol, Long> {}