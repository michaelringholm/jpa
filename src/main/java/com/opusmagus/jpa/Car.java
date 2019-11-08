package com.opusmagus.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
public class Car {
     public Car() {
     }

     public Car(String make, String model) {
          this.Make = make;
          this.Model = model;
     }
     
	@Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     String Make = null;
     String Model = null;
     String Variant = null;
}