package hashcode_equals;
import java.io.*; 
  
class Emp  
{ 
      
    public String name; 
    public int id; 
          
    Emp(String name, int id)  
    { 
              
        this.name = name; 
        this.id = id; 
    } 
      
    @Override
    public boolean equals(Object obj) 
    { 
          
    // checking if both the object references are  
    // referring to the same object. 
    if(this == obj) 
            return true; 
          
        // it checks if the argument is of the  
        // type Emp by comparing the classes  
        // of the passed argument and this object. 
        // if(!(obj instanceof Emp)) return false; ---> avoid. 
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        Emp emp = (Emp) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (emp.name == this.name && emp.id == this.id); 
    } 
      
    @Override
    public int hashCode() 
    { 
          
        // We are returning the Emp_id  
        // as a hashcode value. 
        // we can also return some  
        // other calculated value or may 
        // be memory address of the  
        // Object on which it is invoked.  
        // it depends on how you implement  
        // hashCode() method. 
        return this.id; 
    } 
      
} 
  
//Driver code 
class EmpDriverClass 
{ 
      
    public static void main (String[] args) 
    { 
       
        // creating the Objects of Emp class. 
        Emp e1 = new Emp("aa", 1); 
        Emp e2 = new Emp("aa", 1); 
          
        // comparing above created Objects. 
        if(e1.hashCode() == e2.hashCode()) 
        { 
  
            if(e1.equals(e2)) 
                System.out.println("Both Objects are equal. "); 
            else
                System.out.println("Both Objects are not equal. "); 
      
        } 
        else
        System.out.println("Both Objects are not equal. ");  
    }  
}