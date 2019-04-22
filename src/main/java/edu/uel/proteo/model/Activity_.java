package edu.uel.proteo.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Activity.class)
public class Activity_ extends Record_ {
	
	public static volatile SingularAttribute<Activity, Protocol> protocol;
}
