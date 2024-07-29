
import scala.io.StdIn.readLine

object hello{

	case class student(name:String,marks:Array[Int]);
	
	var records : Map[Int, student] = Map();
	
	
	def getStudentInfo():Unit = {
	
		var condition1 = true;
		var condition2 = false;
		var mark = 0;
		var num = 1;
		var name:String = "";
		var marks:Array[Int] = Array();
		var id = 101;
		
	
		while(condition1){
		
			condition2 = true;
		
			println("\nEnter student's details");
			name = readLine("Enter student name (done to stop) : ").toString;
			
			if(name == "done"){
				condition1 = false;
			}else if(name.isEmpty){
				println("Name can't be an empty string");
			}
			else{
			
				println("\nEnter student's marks\n");
				while(condition2){
					mark = readLine("mark" + num + "(-1 to stop) : ").toInt;
					if(mark == -1){
						condition2 = false
					}else if(mark < -1 || mark > 100)
					{
						println("Invalid mark, please enter a non-negative value or -1 to stop.");
					}
					else{
						marks :+= mark;
						num = num + 1;
					}
			}
			
			records += (id -> student(name,marks));
    			
    			id = id + 1;
			}
    			
		}
	}
	
	
	def printRecord():Unit = {
	
		var total = 0;
		var per = 0;
		var grade = 'A';
		
		println("\nStudents records : ");
		
		records.keys.foreach { key => 
				  total = records(key).marks.sum;
				  per = total/records(key).marks.length;
				  
				  grade = per match {
				  	case x if per >= 90 => 'A'
				  	case x if per >= 75 => 'B'
				  	case x if per >= 50 => 'C'
				  	case _ => 'D'
				  }
				  
      				  println(s"\t$key : ${records(key).name} : ${records(key).marks.mkString(", ")} : $total : $per% : $grade ");
    			}
	}


	def main(args : Array[String]):Unit = {
	
	getStudentInfo();
	
	printRecord();
	
	}
}
