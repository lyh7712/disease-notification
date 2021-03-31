package nsuproject.diseasenotification.koreadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class KoreaDataController {

    @Autowired
    private KoreaDataService service;

    @RequestMapping("/korea")
    public void getKoreaData() {

        String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=";

        service.insertNewsData(url);
    }
}
