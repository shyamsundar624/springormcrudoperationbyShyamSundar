package com.spring.orm.tutorials;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
        StudentDao bean = context.getBean("studentDao",StudentDao.class);
       
//        Student student=new Student(1399,"SHYAM","KANPUR");
//       int r= bean.insert(student);
//       System.out.println("Done "+r);
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
        boolean go=true;
        while(go)
        {
        System.out.println("Press 1 for add new Student");
        System.out.println("Press 2 for display all Student");
        System.out.println("Press 3 for get details of single Student");
        System.out.println("Press 4 for delete Student");
        System.out.println("Press 5 for for update Student");
        System.out.println("Press 6 for add exit");
        
        try {
        	int input=Integer.parseInt(br.readLine());
      switch (input) {
		case 1://add a new student
			System.out.println("Enter Student Id");
			int id=Integer.parseInt(br.readLine());
			System.out.println("Enter Student Name");
			String name=br.readLine();
			System.out.println("Enter Student City");
			String city=br.readLine();
			
			Student s=new Student();
			s.setId(id);
			s.setName(name);
            s.setCity(city);
            //saving student objects to DB by calling insert of student
            int r = bean.insert(s);
            System.out.println(r+" Student Added");
            System.out.println("****************************************");
            System.out.println();
            break;
            
		case 2:
			System.out.println("**************************************************");
			List<Student> allStudent = bean.getAllStudent();
			for(Student st: allStudent)
			{
				System.out.println("ID   : "+st.getId());
				System.out.println("Name : "+st.getName());
				System.out.println("City : "+st.getCity());
				System.out.println("_________________________________________________");
			}
			System.out.println("**************************************************");
			break;
			
			case 3://getting single student data
				System.out.println("Enter Student id");
				int id1=Integer.parseInt(br.readLine());
				Student student=bean.getStudent(id1);
				System.out.println("ID   : "+student.getId());
				System.out.println("Name : "+student.getName());
				System.out.println("City : "+student.getCity());
				System.out.println("_________________________________________________");
			
				break;
				
			case 4:
				System.out.println("Enter Student id");
				int id2=Integer.parseInt(br.readLine());
				bean.deleteStudent(id2);
				System.out.println("Student Record Deleted of ID "+id2);
				
				break;
			case 5:
				
				System.out.println("Enter Student Id");
				int sid=Integer.parseInt(br.readLine());
				System.out.println("Enter Student Name");
				String sname=br.readLine();
				System.out.println("Enter Student City");
				String scity=br.readLine();
				
				Student s2=new Student();
				s2.setId(sid);
				s2.setName(sname);
	            s2.setCity(scity);
	            bean.updateStudent(s2);
	            System.out.println("Record updtaed");
				break;
			case 6:
				go=false;
				break;
		default:
			break;
		}
        }
        catch(Exception e)
        {
        	System.out.println("Invalid input try with another one");
        }
        }
        System.out.println("Thank U for Using My App");
        System.out.print("Design & Developed By SHYAM");
    }
}
