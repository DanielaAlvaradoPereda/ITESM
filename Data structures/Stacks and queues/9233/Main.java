/*
 * Daniela Alvarado Pereda A01329233
 * 22/08/2017
 * This class demonstrates the classes Stack and Queue using them to evaluate arithmetic expressions.
 */
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for(int i = 0; i < n; i++){
			try{
				Stack<Double> operands = new Stack<Double>(100);
				Stack<Character> operators = new Stack<Character>(100);
				Queue<Character> brackets = new Queue<Character>(100);
				boolean number = false;
				boolean point = false;
				char[] line = sc.next().toCharArray();

				for(int c = 0; c < line.length; c++){
					if(Character.isDigit(line[c])){
						operands.push((double)Character.getNumericValue(line[c]));

						if(number){
							operands.push(operands.pop() + operands.pop() * 10);
							}

						number = true;
					}
					else{
						if(line[c] == '.'){
							point = true;
						}
						else{
							if(point){
								double temp = operands.pop();
								operands.push(temp / Math.pow(10, Integer.toString((int)temp).length()) + operands.pop());

								point = false;
							}
							switch(line[c]){
								case '(':
									brackets.insert(line[c]);
									break;
								case ')':
									brackets.remove();

									if(!operators.isEmpty()){
										double op2 = operands.pop();
										char o = operators.pop();
										double op = operands.pop();

										switch(o){
											case '+':
												operands.push(op + op2);
												break;
											case '-':
												operands.push(op - op2);
												break;
											case '*':
												operands.push(op * op2);
												break;
											case '/':
												operands.push(op / op2);
												break;
										}
									}
									break;
								case '+':
								case '-':
								case '*':
								case '/':
									operators.push(line[c]);
									break;
							}
						}
						number = false;
					}
				}
				System.out.println(operators.isEmpty() || operands.isEmpty() ? operands.pop() : "There are missing brackets in the expression");
			}
			catch(Exception e){
				System.out.printf("%s, there could be excess brackets in the expression%n", e.getMessage());
			}
		}
	}
}