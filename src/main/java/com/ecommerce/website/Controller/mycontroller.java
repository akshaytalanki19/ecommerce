package com.ecommerce.website.Controller;


import java.util.List;

import javax.sql.rowset.serial.SerialException;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.website.model.Admin;
import com.ecommerce.website.model.Product;
import com.ecommerce.website.model.Reatiler;
import com.ecommerce.website.model.User;
import com.ecommerce.website.service.AdminService;
import com.ecommerce.website.service.CustomerService;
import com.ecommerce.website.service.ProductService;
import com.ecommerce.website.service.ReatilerService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet(name = "mycontroller", urlPatterns = "/products")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@Controller
public class mycontroller
{
    public static final String SAVE_DIRECTORY = "images";
	@Autowired
	private AdminService adminService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ReatilerService reatilerService;
	@Autowired
	private ProductService productService;
	public User user;
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	//Admin controller
	
	@GetMapping("/adminlogin")
	public ModelAndView adminlogin()
	{
		return new ModelAndView("adminlogin","message","enter crendentials");
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView chekadminlogin(HttpServletRequest request)
	{
	    String uname = request.getParameter("uname");
	     String pwd = request.getParameter("pwd");
		Admin admin = adminService.checkadminlogin(uname, pwd);
	    
	    if(admin!=null)
	    {
	      
	      return new ModelAndView("adminhome","a", admin);
	    }
	    else
	    {	
	    	return new ModelAndView("adminlogin","message", "Login Failed");
	    }
	    
	    
	}
	
	@GetMapping("/adminhome")
	public String adminhome() {
		return "adminhome";
	}
	
	@GetMapping("viewallusers")
	public ModelAndView viewusers()
	{
		List<User> list=adminService.viewUsers();
		return new ModelAndView("viewallusers","l",list);
	}
	
	
	//customer controller
	@GetMapping("/customerlogin")
	public ModelAndView customerlogin()
	{
		return new ModelAndView("customerlogin","message","enter credentials");
	}
	
	@GetMapping("displayprodimage")
	public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("id") int id) throws IOException, SQLException
	{
	Product product =  productService.ViewProductByID(id);
	byte [] imageBytes = null;
	imageBytes = product.getImage().getBytes(1,(int) product.getImage().length());

	return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	@PostMapping("/insertuser")
	public ModelAndView insertuser(HttpServletRequest request)
	{
		String cname=request.getParameter("name");
		String cemail=request.getParameter("email");
		String cpwd=request.getParameter("password");
		User u=new User(); 
		u.setName(cname);
		u.setEmail(cemail);
		u.setPassword(cpwd);
		String msg=customerService.insercustomer(u);
		return new ModelAndView("customerlogin","message","user inserted succesfully");
	}
	@PostMapping("/checkuser")
	public ModelAndView checkuser(HttpServletRequest request)
	{
		String name=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		User u=customerService.checkuserlogin(name,pwd);
		if(u!=null)
		{
			user=u;
			return new ModelAndView("customerhome","u",u);
		}
		else
		{
			return new ModelAndView("customerlogin","message","invalid credentials");
		}
	}
	@GetMapping("/customerhome")
	public ModelAndView customerhome()
	{
		return new ModelAndView("customerhome");
	}
	@GetMapping("/items")
	public ModelAndView items()
	{
		Product p=new Product();
		List<Product> l=productService.getItems();
		List<Product> sl=productService.getShoes();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("items");
		mv.addObject("shoes", sl);
		mv.addObject("l", l);
		mv.addObject("u",user);
		return mv;
	}
	
	//retailer
	@GetMapping("/reatilerlogin")
	public String reatilerlogin()
	{
		return "reatilerlogin";
	}
	
	@PostMapping("/insertreatiler")
	public ModelAndView insertreatler(HttpServletRequest request)
	{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		String type=request.getParameter("reatilertype");
		String loc=request.getParameter("location");
		String sname=request.getParameter("shopname");
		String template = request.getParameter("template");
		int templateNumber;
		Reatiler r=new Reatiler();
		r.setName(name);
		r.setEmail(email);
		r.setPassword(pwd);
		r.setType(type);
		r.setLocation(loc);
		r.setShopname(sname);
		r.setTemplatenum(template);
		String msg=reatilerService.insertReatiler(r);
		return new ModelAndView("reatilerlogin","message","please login");
	}
	
	@PostMapping("/checkreatiler")
	public ModelAndView checkReatiler(HttpServletRequest request)
	{
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		Reatiler r=reatilerService.checkreatiler(email,pwd);
		if(r!=null)
		{
			String template = r.getTemplatenum();
		    String viewName = "default"; // Default view if template doesn't match

		    switch (template) {
		        case "one":
		            viewName = "one";
		            break;
		        case "two":
		            viewName = "two";
		            break;
		        case "three":
		            viewName = "three";
		            break;
		        // Add more cases as needed
		        default:
		            // Handle unexpected template values
		            System.err.println("Invalid template number: " + template);
		    }

		    return new ModelAndView(viewName, "r", r);
		}
		else
		{
			return new ModelAndView("reatilerlogin","message","login failed");
		}
	}
	@GetMapping("reatilerhome")
	public String reailerhome()
	{
		return "reatilerhome";
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(HttpServletRequest request,@RequestParam("productImage") MultipartFile file) throws SerialException, SQLException, IOException, ServletException
	{
		byte[] bytes = file.getBytes();
		Blob img = new javax.sql.rowset.serial.SerialBlob(bytes);
		int id=Integer.parseInt(request.getParameter("ReatilerId"));
		String name=request.getParameter("productName");
		int price=Integer.parseInt(request.getParameter("productPrice"));
		String description=request.getParameter("productDescription");
		int quantity=Integer.parseInt(request.getParameter("Quantity"));
		Product p=new Product();
		p.setImage(img);
		p.setPname(name);
		p.setPrice(price);
		p.setDescription(description);
		p.setStock_qunatity(quantity);
		p.setRid(id);
		productService.insertProduct(p);
		return new ModelAndView("home");
	}
	
	
}