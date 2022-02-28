package LamdaExample.Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
  public static void main(String[] args) {
    List<Integer> list1 = List.of(1,3,2,8,6,4,12,15,36,98,75,48,65,32);
    List<Integer> ans = list1.stream().filter(i-> i%2==0).collect(Collectors.toList());
    System.out.println(list1);
    System.out.println(ans);
    
    List<Student> studentList = new ArrayList<Student>();
    studentList.add(new Student(101,"Raj",85.36f));
    studentList.add(new Student(102,"Raja",865.36f));
    studentList.add(new Student(103,"Rajesh",45.36f));
    studentList.add(new Student(104,"Raju",65.36f));
    studentList.add(new Student(105,"Rajeshwari",55.36f));
    
    List<Integer> id = studentList.stream().map(n -> n.getId()).collect(Collectors.toList());
    id.forEach(e -> System.out.println(e));
  Map<Integer, String> collect = studentList.stream().collect(Collectors.toMap(i -> i.hashCode(), i-> i.getName()));
    
  }
}
