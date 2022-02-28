package LamdaExample.Lamda;

public class Student {
private Integer id;
private String name;
private float per;

public Student() {
	// TODO Auto-generated constructor stub
}
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
public float getPer() {
	return per;
}
public void setPer(float per) {
	this.per = per;
}
public Student(Integer id, String name, float per) {
	super();
	this.id = id;
	this.name = name;
	this.per = per;
}

}
