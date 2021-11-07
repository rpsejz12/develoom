package controller.action;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class shoes {
	public static void main(String[] args) {
		String url="https://kream.co.kr/search?category_id=1&sort=popular&per_page=40";
		String httpUrl = null;
		String brandname= null;
		String sname=null;
		String spk=null;
		String sdate = null;
		String price = null;
		String imgurl = null;


		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();


			Elements element = doc.select(".search_result_item");

			for(int i=0; i<element.size(); i++) { // element.size() 있는 정보 모두 가져오기
				httpUrl = "https://kream.co.kr"+element.get(i).select("a").attr("href");
				System.out.println("http 주소: "+httpUrl);

				doc = Jsoup.connect(httpUrl).get();
				Elements el = null;
				
				
				imgurl = doc.select(".product > img").attr("src");

				el = doc.select(".brand"); 
				brandname= el.get(0).text();

				el = doc.select(".title"); 
				sname=el.get(0).text();

				//  element = doc.select(".product_info");
				// spk=element.get(0).text();

				//element = doc.select(".product_info");
				//sdate=element.get(1).text();

				//element = doc.select(".product_info");
				//price=element.get(3).text();


				System.out.println("+++++++++++++++++++++++++++++");
				System.out.println("이미지: "+ imgurl);
				System.out.println("브랜드: "+ brandname);
				System.out.println("상품이름: "+sname);
				//  System.out.println("품번: "+ spk);
				// System.out.println("출시일: "+ sdate);
				//System.out.println("가격: "+ price);

				System.out.println("+++++++++++++++++++++++++++++");



			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}