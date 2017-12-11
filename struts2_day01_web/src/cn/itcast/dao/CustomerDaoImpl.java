package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.itcast.entity.Customer;
import cn.itcast.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	//使用hibernate实现查询列表
	public List<Customer> findAll() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();
			//开启事务
			tx = session.beginTransaction();
			
			//查询所有记录
			Criteria criteria = session.createCriteria(Customer.class);
//			criteria.add(Restrictions.eq(propertyName, value))
			List<Customer> list = criteria.list();

			//提交事务
			tx.commit();
			return list;
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory不需要关闭
//			sessionFactory.close();
		}
		return null;
	}

	//添加客户的方法
	public void addCustomer(Customer customer) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();
			//开启事务
			tx = session.beginTransaction();
			
			//添加代码
			//返回值：添加到数据库里面，生成id值，返回id值
			Serializable id = session.save(customer);
			if(id != null) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}
			//提交事务
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory不需要关闭
//			sessionFactory.close();
		}
	}

}
