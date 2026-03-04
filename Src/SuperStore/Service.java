package SuperStore;

import java.util.*;

public class Service {
	Scanner sc=new Scanner(System.in);
	Product product=new Product();
	Category category=new Category();
	View view=new View();
	Bill bill=new Bill();
	public void sellService(List<Category>list){
		System.out.println("----------------");
		System.out.println("Choose The Category...");
		int count=1;
		for(Category c:list) {
			System.out.println(count+" "+c.toString());
			count++;
		}
		System.out.println(count+" "+"Add New Category");
		System.out.println("----------------");
		int opt=sc.nextInt();
		if(opt==count) {
		boolean check=category.addCategory(list);
		if(!check)return;
		System.out.println("Category Added Successfully..");
		}
		product.newProduct(list.get(opt-1));
	}
	public void buyService(List<Category>list){
		List<Product>result=new ArrayList<>();
		while(true) {
			view.showMenu();
			int op=sc.nextInt();
			switch(op) {
			case 1->{
				addItem(list,result);
			}case 2->{
				bill.designBill(result);
				System.exit(0);
			}
			case 3->{
				view.showItem(result);
			}case 4->{
			removeProduct(result,list);
			}case 5->{
				return;
			}
			}
		}
	}
	public void addItem(List<Category> list,List<Product> result) {
		System.out.println("----------------------------------");
		System.out.println("Category-Id"+" "+"Category-Name");
		for(Category c:list) {
			System.out.println(c.toString());
		}System.out.println("----------------------------------");
		int opt=sc.nextInt();
		Category category=list.stream().filter(a->a.getCategoryId()==opt).findAny().orElse(null);
		if(category==null ) {
			System.out.println("Invalid Item...");
			return;
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Id"+" "+"Name"+" "+"price"+" "+"Available Quantity");
		for(Product p:category.getProducts()) {
		System.out.println(p.toString());
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the product Id:-");
		int pd=sc.nextInt();
		Product product=category.getProducts().stream().filter(a->a.getProductId()==pd).findFirst().orElse(null);
		if(product==null) {
			System.out.println("Invalid Product...");
			return;
		}else {
			addProduct(result, product,opt);
		}
	}public void addProduct(List<Product>result,Product product,int ct) {
		System.out.println("Enter the quantity");
		int q=sc.nextInt();
		if(product.getQuantity()<q) {
			System.out.println("Invalid Stock");
			return ;
		}
		product.setQuantity(product.getQuantity()-q);
		Product exist=result.stream().filter(a->a.getProductId()==product.getProductId()).findAny().orElse(null);
		if(exist==null) {
		Product up=new Product(product.getProductId(),product.getProductName(),product.getPrice(),q,ct);
		System.out.println("Item Added Successfully");
		result.add(up);
		}else {
			exist.setQuantity(exist.getQuantity()+q);
			System.out.println("Item Added Successfully");
		}
	}public void removeProduct(List<Product>result,List<Category>list) {
		int i=1;
	for(Product p:result) {
		System.out.println((i++)+" "+p.toString());
	}
	System.out.println("Choose the Item to remove...");
	int it=sc.nextInt();
	if(result.size()<it) {
		System.out.println("Invalid Item ");
		return;
	}
	Product p=result.get(it-1);
	System.out.println(p.toString());
	System.out.println("Enter count the to remove...");
	int c=sc.nextInt();
	if(p.getQuantity()<c) {
		System.out.println("Invalid Stock");
		return;
	}
	Category ct=list.stream().filter(a->a.getCategoryId()==p.getCategoryId()).findFirst().orElse(null);
	if(ct==null) {
		System.out.println("Un Execpted Error Occur");
		return;
	}
	Product pt=ct.getProducts().stream().filter(a->a.getProductId()==p.getProductId()).findFirst().orElse(null);
	if(pt==null) {
		System.out.println("Un Execpted Error Occur");
		return;
	}
	pt.setQuantity(pt.getQuantity()+c);
	if(c==p.getQuantity()) {
		result.remove(p);
	}else {
		p.setQuantity(p.getQuantity()-c);
	}
	System.out.println("Item Removed SuccessFully ...");
	}
}
