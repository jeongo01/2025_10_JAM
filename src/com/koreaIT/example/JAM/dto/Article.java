package com.koreaIT.example.JAM.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class Article {
	// 필드
	public int id;
	public LocalDateTime regDate;
	public LocalDateTime updateDate;
	public String title;
	public String body;
	
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	// 생성자 역할 : DB에서 받아온 인자(실제값)를 받아서 객체 필드에 저장하는 과정. 
	public Article(int id, LocalDateTime regDate, LocalDateTime updateDate, String title, String body) {   // (생성자의 선언부) 파라미터 : id, title, body (DB에서 가져온 값을 받는 변수)
		this.id = id;    // 인자로 받아온 데이터를 파라미터 저장하고, 파라미터 id가 필드 this.id 에 저장된다.  
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
	}
	// 애초에 new Article(...)을 호출하면, Article 객체가 힙 메모리에 생성되고, 그 안의 필드(id, regDate, updateDate, 등등)도 초기화된다.
	// 초기화된 필드들은 기본값을 가진다. id = 0, String(참조형) 타입인 나머지들은 Null을 갖는다.
	
	public Article(Map<String, Object> articleMap) {
		this.id = (int) articleMap.get("id");  
		this.regDate = (LocalDateTime) articleMap.get("regDate");
		this.updateDate = (LocalDateTime) articleMap.get("updateDate");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");
	}
}