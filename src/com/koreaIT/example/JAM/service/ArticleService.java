package com.koreaIT.example.JAM.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.koreaIT.example.JAM.dao.ArticleDao;
import com.koreaIT.example.JAM.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService(Connection conn) {
		this.articleDao = new ArticleDao(conn);
	}

	public int doWrite(int memberId, String title, String body) {
		return articleDao.doWrite(memberId, title, body);
	}

	public List<Article> showList() {
		
		List<Map<String, Object>> articleListMap = articleDao.showList();
		
		List<Article> articles = new ArrayList<>();

		for (Map<String, Object> articleMap : articleListMap) {
			articles.add(new Article(articleMap));
		}
		
		return articles;
	}
	
	public int getNumInCmd(String cmd) {   // 사용자가 입력한 명령어에서 숫자(id) 뽑기
		return Integer.parseInt(cmd.split(" ")[2]);
	}
	
	public int getArticleCnt(int id) {  // 게시물이 존재하는지 파악
		return articleDao.getArticleCnt(id);
	}

	public Article showDetail(int id) {
		
		Map<String, Object> articleMap = articleDao.showDetail(id);
		
		if(articleMap.isEmpty()) {
			return null;
		}
		
		return new Article(articleMap);
	}

	public void doModify(String title, String body, int id) {
		articleDao.doModify(title, body, id);
	}

	public void doDelete(int id) {
		articleDao.doDelete(id);
	}
}
