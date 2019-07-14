package edu.uel.proteo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uel.proteo.model.Trial;
import edu.uel.proteo.repository.TrialRepository;

@Service
public class TrialServiceImpl extends StdRecordServiceImpl<Trial, Long> implements TrialService {

	@Autowired
	public TrialServiceImpl(TrialRepository trialRepository) {
		super(trialRepository, Trial.class);
	}
}
