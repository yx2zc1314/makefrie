package com.lechuang.bean;

import java.io.Serializable;

public class Person implements Serializable{
	  	private Integer id;
	    private String  name;
	    private Integer age;
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public Integer getAge() {
	        return age; 
	    }
	    public void setAge(Integer age) {
	        this.age = age;
	    }
	    
	    public Person(){
	        super();
	    }
	    
	     @Override
	        public String toString() {
	            return "Person [Id=" + id + ", Name=" + name
	                    + ", age=" + age + "]";
	        }
}
