package businesscard;

import java.util.Iterator;
import java.util.Scanner;

public class BusinessCardUI{

    BusinessCardsDao dao = new BusinessCardsDao();

    public void mainMenu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("--명함 관리 프로그램--");
        System.out.println("항목을 선택하세요");
        System.out.println("1. 명함 입력" + "\t" + "2. 명함 조회" + "\t" + "3. 명함 수정" + "\t" + "4. 명함 삭제"+"\t"+"5. 프로그램 종료");

        String menuInput = sc.next();
        switch(menuInput){
            case "1" : addCard();
            break;

            case "2" : findCard();
            break;

            case "3" : modifyCard();
            break;

            case "4" : removeCard();
            break;

            case "5" : System.out.println("프로그램을 종료합니다.");
                break;

        }

    }

    public void addCard() {

        dao.load("/Users/bigyo/DEVEL/tmp/businesscard.json");
        Scanner sc = new Scanner(System.in);

        BusinessCardData businessCardData = new BusinessCardData();

        System.out.print("이름을 입력하세요 - ");
        String name = sc.nextLine();

        System.out.print("회사를 입력하세요 - ");
        String company = sc.nextLine();

        System.out.print("전화번호를 입력하세요 - ");
        String phone = sc.nextLine();

        int num = businessCardData.getMaxNum();

        BusinessCard businessCard = new BusinessCard(num, name, company, phone);

        dao.insert(businessCard);
        System.out.println("입력되었습니다. ");

        System.out.println("계속 입력하시겠습니까?");
        String choice = sc.nextLine();

        if(choice.equals("y")||choice.equals("Y")){
            addCard();

        }

        else{
            continueMenu();
        }


    }

    public void findCard(){
        dao.load("/Users/bigyo/DEVEL/tmp/businesscard.json");
        Scanner sc = new Scanner(System.in);
        System.out.print("이름이나 번호를 입력하세요 - ");
        String name = sc.nextLine();
        String phone = sc.nextLine();
        dao.find(name, phone);
    }

    public void modifyCard() {
        dao.load("/Users/bigyo/DEVEL/tmp/businesscard.json");
        Scanner sc = new Scanner(System.in);
        System.out.println("ID값을 입력해주세요.");
        String id = sc.nextLine();
        System.out.println("수정할 항목을 선택하세요");
        System.out.println("1. 이름" + "\t" + "2. 전화번호" + "\t" + "3. 회사이름");
        String OptionInput = sc.nextLine();
        System.out.println("수정할 내용을 입력하세요");
        String modify = sc.nextLine();
        dao.update(id, OptionInput, modify);


    }

    public void removeCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID 를 입력하세요 - ");
        String id = sc.nextLine();
        dao.remove(id);


    }



    public void continueMenu(){
        mainMenu();
    }


}




