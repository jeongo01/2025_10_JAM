package com.koreaIT.example.JAM.controller;

import java.sql.Connection;
import java.util.Scanner;

import com.koreaIT.example.JAM.service.MemberService;

public class MemberController {
	private Scanner sc;
	private MemberService memberService;
	
	public  MemberController(Connection conn, Scanner sc) {
		this.sc = sc;
		this.memberService = new MemberService(conn);
	}

	public void doJoin() {

		String loginId = null;
		String loginPw = null;
		String name = null;

		System.out.println(" == 회원가입 == ");

		while (true) {
			System.out.printf("아이디 : ");
			loginId = sc.nextLine().trim();

			if (loginId.length() == 0) {
				System.out.println("아이디를 입력해주세요.");
				continue;
			}

			boolean isLoginIdDup = memberService.isLoginIdDup(loginId);

			if (isLoginIdDup) {
				System.out.printf("%s는 이미 중복된 아이디입니다.\n", loginId);
				continue;
			}

			System.out.printf("%s는 사용 가능한 아이디입니다.\n", loginId);
			break;
		}

		while (true) {

			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine().trim();

			if (loginPw.length() == 0) {
				System.out.printf("비밀번호를 입력해주세요.");
				continue;
			}

			System.out.printf("비밀번호 확인 : ");
			String loginPwChk = sc.nextLine().trim();

			if (loginPw.equals(loginPwChk) == false) {
				System.out.println("비밀번호를 확인해주세요.");
				continue;
			}
			break;

		}

		while (true) {
			System.out.printf("이름 : ");
			name = sc.nextLine().trim();

			if (name.length() == 0) {
				System.out.println("이름을 입력해주세요.");
				continue;
			}
			break;

		}
		
		memberService.doJoin(loginId, loginPw, name);

		System.out.printf("%s 회원님이 가입되었습니다.\n", name);

	}

}
