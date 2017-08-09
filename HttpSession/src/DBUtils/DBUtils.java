package DBUtils;

import java.util.HashMap;
import java.util.Map;

import Product.Book;

public class DBUtils {
	private static Map<String,Book> books = new HashMap<>();
	static{
		books.put("1", new Book("1","JAVA入门",30,"yier"));
		books.put("2", new Book("2","C++入门",40,"chuanger"));
		books.put("3", new Book("3","Python入门",25,"yier"));
	}
	public static Map<String,Book> getBooks(){
		return books;
	}
	public static Book findBookById(String id){
		return books.get(id);
	}
}
