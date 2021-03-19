package nsuproject.diseasenotification.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;

public class DiseasenData {

    public static void main(String[] args) {

        String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=";

        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();


        } catch (Exception e) {
            e.printStackTrace();
        }

        Elements element = doc.select("div#content.content");

        Iterator<Element> ie1 = element.select("dd.ca_value").iterator();


        while (ie1.hasNext()) {
            System.out.println("ie1.next().text() = " + ie1.next().text());
        }
    }
}
