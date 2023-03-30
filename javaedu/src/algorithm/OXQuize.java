package algorithm;

public class OXQuize {

	public static void main(String[] args) {
		String [] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
		String [] answer =  new String[quiz.length];
		String [] str = null;
		
		for(int i = 0 ; i < quiz.length; i++) {
			 str= quiz[i].split(" ");
			if(str[1].equals("+")) {
				answer[i] = (Integer.parseInt(str[0]) + Integer.parseInt(str[2]) == Integer.parseInt(str[4])) ? "O" : "X";
			}else answer[i] = (Integer.parseInt(str[0]) - Integer.parseInt(str[2]) == Integer.parseInt(str[4])) ? "O" : "X";
			
			}
		}
	
}
