
import scala.io.StdIn.readLine

object inven{
	
	case class item(name:String, quantity:Int, price:Double)
	
	var inventory1 : Map[Int, item] = Map(100-> item("Apple", 50 , 20.00) ,
					      101-> item("Orange", 60 , 15.00) ,
					      102-> item("Banana", 55 , 25.00));
					
	var inventory2 : Map[Int, item] = Map(100-> item("Apple", 40 , 25.00) ,
					      101-> item("Orange", 55 , 22.00) ,
					      102-> item("Banana", 65 , 20.00) ,
					      103-> item("Pineapple", 35 , 30.00));
	
	
	def displayProducts() = {
	
	println("\nProducts in inventory1 : ");
    		inventory1.keys.foreach { key => 
      			println("\t"+key + " : " + inventory1(key));
    		}
  	}
  	
  	def totalValue():Double = {
  		
  		var value = 0.00;
  		
  		inventory1.foreach { case (_, item) => 
      			
      			value = value + (item.quantity*item.price)
    		}
    		
    		value;
  	}
  	
  	def isEmpty():Boolean = {
  		
  		inventory1.isEmpty;
  	}
  	
  	def mergeInventories(): Unit = {
    		inventory2.foreach { case (id, item2) =>
      			inventory1.get(id) match {
        			case Some(item1) =>
          				inventory1 = inventory1.updated(id, item(item1.name,
          				 item1.quantity+item2.quantity, math.max(item1.price,item2.price)))
        		case None =>
          			inventory1 += (id -> item2)
      			}
    		}
    		
  	}
  	
  	def checkItem():Unit = {
  	
  		var id = readLine("\nEnter product ID to check : ").toInt;
  		
  		inventory1.get(id) match {
    			case Some(item) =>
      				println(item);
    			case None =>
      				println("Item not found");
  		}
  	}
	
	def main(args: Array[String]):Unit = {
		
		displayProducts();
		
		println("\nHigest price :   Rs " + totalValue());
		
		var check = isEmpty();
		
		println(if (check) "\nInventory1 is empty" else "\nInventory 1 is not empty");
		
		mergeInventories();
    
    		println("\nMerged inventory :");
		inventory1.foreach{ case (_, item) =>
			println("\t" + item.name + " = "+item.quantity);
			}
			
		checkItem();
	}
}
