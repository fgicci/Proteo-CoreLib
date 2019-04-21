package edu.uel.proteo.model;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Record.class)
public abstract class Record_ {

	public static volatile SingularAttribute<Record, Long> id;
	public static volatile SingularAttribute<Record, Long> version;
	public static volatile SingularAttribute<Record, Date> createDate;
	public static volatile SingularAttribute<Record, Date> updateDate;
	public static volatile SingularAttribute<Record, Boolean> active;
}
