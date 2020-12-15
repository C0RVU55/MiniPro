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
		Reader fr = new FileReader("C:\\javaStudy\\workspace\\MiniPro\\src\\com\\javaex\\ex01\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		// line 초기화
		String line = "";

		// 파일 먼저 읽어오기
		// 원래 이걸 num==1에 넣었었는데 이러니까 리스트등록리스트하면 중복되고 등록리스트하면 기존 데이터가 사라졌음.
		// 배열 오류도 났었는데 메뉴 입력 반복문 전에 이걸로 먼저 파일 내용을 person에서 list로 넣어놓고 시작하면 됨.
		while (true) {
			line = br.readLine();
			if (line == null) {
				break;
			}
			String[] pInfo = line.split(",");
			Person person = new Person(pInfo[0], pInfo[1], pInfo[2]);
			list.add(person);
		}
		
		// 시작화면
		System.out.println("****************************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("****************************************");

		// 메뉴 입력
		while (true) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();

			if (num == 1) {
				System.out.println("<1.리스트>");

				for (int i = 0; i < list.size(); i++) {
					System.out.println((i + 1) + ".\t" + list.get(i).getName() + "\t" + list.get(i).getHp() + "\t" + list.get(i).getCompany());

				}

				System.out.println("");

			} else if (num == 2) {

				Writer fw = new FileWriter("C:\\javaStudy\\workspace\\MiniPro\\src\\com\\javaex\\ex01\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				System.out.println("<2.등록>");

				Person person = new Person();

				System.out.print(">이름: ");
				person.setName(sc.next()); // nextLine으로 해서 계속 타이핑 위치 이상했음

				System.out.print(">휴대전화: ");
				person.setHp(sc.next());

				System.out.print(">회사전화: ");
				person.setCompany(sc.next());

				list.add(person);

				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
					bw.newLine();

				}

				System.out.println("[등록되었습니다]");
				System.out.println("");

				bw.close();

			} else if (num == 3) {
				Writer fw = new FileWriter("C:\\javaStudy\\workspace\\MiniPro\\src\\com\\javaex\\ex01\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int no = sc.nextInt();
				list.remove((no - 1));

				for (Person p : list) {
					bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
					bw.newLine();
				}

				System.out.println("삭제되었습니다.");
				System.out.println("");

				bw.close();

			} else if (num == 4) {
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String n = sc.next();

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().contains(n)) { // indexOf() != -1 <-- 값 없으면 -1 반환하는 이걸로 써도 됨.
						System.out.println((i + 1) + ".\t" + list.get(i).getName() + "\t" + list.get(i).getHp() + "\t"+ list.get(i).getCompany());
					}
				}

				System.out.println("");

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
