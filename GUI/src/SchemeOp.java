
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alan
 */
public class SchemeOp {
    
    
    public int result,rand1,rand2,Id;
    public char operator;
    
   
    
    SchemeOp(int min ,int  max ){
        String operators = "+-*/";
        Random r = new Random();
        operator = operators.charAt(r.nextInt(4));
        rand1 = r.nextInt(max-min)+ min;
        rand2 = r.nextInt(max-min)+ min;
        result = SchemeResult();
        Id = (int) ((Math.random() * (1000 - 1)) + 1);

    }
    
    
    private int SchemeResult() {
        switch(operator) {
			case '+':
				result=rand1+rand2;
				break;
			case '-':
				result=rand1-rand2;
				
				break;
			case '*':
				result=rand1*rand2;
				break;
			case '/':
				result=rand1/rand2;
				break;
			default:
				break;
		}		
        return result;
    }
    public String SchemeFormat(){
        
        return String.format("(%s %s %s)", operator,rand1,rand2);
    }
    public int GetId(){
        return Id;
        
    }
}

