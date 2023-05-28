
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import producerconsumer.Buffer;
import producerconsumer.Producer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alan
 */
public class SchemeOp {
    
    
    public int result,rand1,rand2;
    public char operator;
   
    
    SchemeOp(int min ,int  max ){
        String operators = "+-*/";
        Random r = new Random(System.currentTimeMillis());
        operator = operators.charAt(r.nextInt(5));
        rand1 = r.nextInt(max-min)+ min;
        rand2 = r.nextInt(max-min)+ min;
        result = SchemeResult();
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
}

