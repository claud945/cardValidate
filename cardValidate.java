import java.util.*;
public class cardValidate{
public static void main (String [] args){
Scanner input = new Scanner(System.in);
if(isValid(input.nextLong())){
	System.out.println("是合法的");
}else
	System.out.println("不是合法的參數");

}


//驗證number是否Valid，如果是valid回傳true 否則回傳false
private static boolean isValid(long number){
	if(getPrefixMatched(getPrefix(number)) != true){
		System.out.println("WRONG PREFIX NUMBER");
		return false;}
	else if((getEvenNumber(number)+getOddNumber(number))%10L != 0L)
		{System.out.println("無法整除10");
		return false;}
	else 
		return true;



}


//獲得奇數位的總和
private static long getOddNumber(Long number){
	long calcuNum=0,result = 0; 
	for(int i = 0 ; i <= getSize(number)-1 ; i = i + 2)
	{	calcuNum = 0;
		calcuNum = number / (long)Math.pow(10,i);
		calcuNum = (calcuNum % 10);
		if(calcuNum>=5)  //因為大於5 * 2 就會超過兩位數，所以直接用switch 來 mapping 所有兩位數的最後結果
			switch ((int)calcuNum){
				case 5:
					calcuNum =1L;break;
				case 6:
					calcuNum =3L;break;
				case 7:
					calcuNum =5L;break;
				case 8:
					calcuNum =7L;break;
				case 9:
					calcuNum =9L;break;
			
			}else{calcuNum= calcuNum*2;}
		result = result + calcuNum	;
	}		
	return result;

}


//偶數位的數字總和，結果會以int的方式回傳
private static long getEvenNumber(Long number){
	long calcuNum=0,result = 0;
	for(int i = 1 ; i <= getSize(number)-1 ; i = i + 2)
	{	calcuNum = 0;
		calcuNum = number / (long)Math.pow(10,i);
		calcuNum = (calcuNum % 10);
		
		if(calcuNum>=5)
			switch ((int)calcuNum){
				case 5:
					calcuNum =1L;break;
				case 6:
					calcuNum =3L;break;
				case 7:
					calcuNum =5L;break;
				case 8:
					calcuNum =7L;break;
				case 9:
					calcuNum =9L;break;
			
			}else{calcuNum= calcuNum*2;}
		result = result + calcuNum	;
	}	
	return result;

}

//獲得number的長度，可以用這個方法來推論他是幾位數的number
private static int getSize(long number){
	int count = 0;
	while(number > 0){
	number = number / 10;
	count++;
	}
	return count;
}

//驗證信用卡的prefix number是否為 37/4/5/6這幾種....
private static boolean getPrefixMatched(int number){
	if(number == 37)
		return true;
		else{
			number = number / 10;
			switch (number){
			case 4:return true;
			case 5: return true;
			case 6: return true;
			default : return false;
			}
		
		
		
		}
}

//取得信用卡的prefix number ，此處取最開頭的兩個數字
private static int getPrefix(long number){
	int thisSize = getSize(number); //檢查數字長度
	number = number / (long)Math.pow(10,thisSize-2);
	return (int)number;
}





}