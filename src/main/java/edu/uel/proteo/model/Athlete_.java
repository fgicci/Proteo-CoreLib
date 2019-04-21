package edu.uel.proteo.model;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Athlete.class)
public class Athlete_ extends Record_ {
	
	public static volatile SingularAttribute<Athlete, String> firstName;
	public static volatile SingularAttribute<Athlete, String> lastName;
	public static volatile SingularAttribute<Athlete, Date> birth;
}
