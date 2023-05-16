package sampleanno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood")  //default : myFoodMgr
public class MyFoodMgr{
	@Autowired
	//@Qualifier(value="unFavoriteFood")
	private Food favoriteFood;     
	@Autowired
	private Food unFavoriteFood;

	//같은 타입이 두개 일때 멤버 변수명으로 의존관계가 주입된다.
	
	@Override
	public String toString() {
		return "[favoriteFood=" + favoriteFood + ", unFavoriteFood=" + unFavoriteFood + "]";
	}
}
