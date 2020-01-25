package com.springcore.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.config.AppConfig;
import com.springcore.dao.MobileDao;
import com.springcore.pojo.Mobile;

public class MobileMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MobileDao mobileDAO = context.getBean(MobileDao.class);

		System.out.println("List of mobiles is:");

		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}

		System.out.println("\nGet mobile with ID 101");

		Mobile mobileById = mobileDAO.getMobileById(101);
		System.out.println(mobileById);

		System.out.println("\nCreating person: ");
		Mobile mobile = new Mobile(103,70,20000,"Oppo","Android");
		System.out.println(mobile);
		mobileDAO.createMobile(mobile);
		System.out.println("\nList of mobile is:");

		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}

		System.out.println("\nDeleting person with ID 102");
		mobileDAO.deleteMobile(mobileById);

		System.out.println("\nUpdate mobile with ID 103");

		Mobile m = mobileDAO.getMobileById(103);
		m.setName("CHANGED");
		mobileDAO.updateMobile(m);

		System.out.println("\nList of mobile is:");
		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}

		context.close();

	}

}
