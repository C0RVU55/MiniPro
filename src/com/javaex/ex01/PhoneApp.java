package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		// mini project 전화번호 관리 프로그램

		// 리스트
		List<Person> list = new ArrayList<Person>();

		// 스캐너
		Scanner sc = new Scanner(System.in);

		// 입출력
		Reader fr = new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		// line 초기화
		String line = "";

		// 시작화면
		System.out.println("****************************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("****************************************");
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("----------------------------------------");

		// 입력
		while (true) {

			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();

			if (num == 1) {
				System.out.println("<1.리스트>");

				while (true) {
					line = br.readLine();
					if (line == null) {
						break;
					}
					String[] pInfo = line.split(",");
					Person person = new Person(pInfo[0], pInfo[1], pInfo[2]);
					list.add(person);
				}

				for (int i = 0; i < list.size(); i++) {
					System.out.print((i + 1) + "." + "   ");
					list.get(i).showInfo();
				}

				System.out.println("");

			} else if (num == 2) { // 중복으로 출력됨, ArrayIndexOutOfBoundsException, 계속 돌리면 텍스트파일 데이터 사라짐 --> 대충 해결됐는데 다시 해보기

				Writer fw = new FileWriter("C:\\javaStudy\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				Person person = new Person();

				System.out.println("<2.등록>");

				System.out.print(">이름: ");
				person.setName(sc.next()); // nextLine으로 해서 계속 타이핑 위치 이상했음

				System.out.print(">휴대전화: ");
				person.setHp(sc.next());

				System.out.print(">회사전화: ");
				person.setCompany(sc.next());

				list.add(person);

				for (Person p : list) {
					String str = p.getName() + "," + p.getHp() + "," + p.getCompany();
					bw.write(str);
					bw.newLine();
				}
				System.out.println("[등록되었습니다]");
				System.out.println("");

				bw.close();

			} else if (num == 3) {
				Writer fw = new FileWriter("C:\\javaStudy\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int no = sc.nextInt();
				list.remove((no - 1));

				for (Person p : list) {
					String str = p.getName() + "," + p.getHp() + "," + p.getCompany();
					bw.write(str);
					bw.newLine();
				}
				System.out.println("삭제되었습니다.");
				System.out.println("");

				bw.close();

			} else if (num == 4) { //검색 못 짰음.
				System.out.println("<4.검색>");

			} else if (num == 5) {
				System.out.println("****************************************");
				System.out.println("*              감사합니다              *");
				System.out.println("****************************************");
				break;
			} else {
				System.out.println("[다시 입력해 주세요.]");
				System.out.println("");
			}

		}

		br.close();
		sc.close();
	}

}
