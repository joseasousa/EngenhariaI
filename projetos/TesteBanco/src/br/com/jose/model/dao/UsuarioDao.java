package br.com.jose.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jose.model.Usuario;
import br.com.jose.util.JPAUtil;



public class UsuarioDao {
	
	EntityManager manager;
	
	public UsuarioDao(){
		manager = new JPAUtil().getEntityManager();
	}
	
	public void addUser(Usuario u){
		manager.getTransaction().begin();
		manager.persist(u);
		
		manager.getTransaction().commit();

		manager.close();
	}
	
	public List<Usuario> getUsers(){
		//manager.getTransaction().begin();
		Query query = manager.createQuery("select u from Usuario u");
		
		List<Usuario> users = query.getResultList();
		manager.close(); // fechando EntityManager
		return users;

	}
	
	public Usuario getUsuarioById(int id){
		manager.getTransaction().begin();
		Usuario u = manager.find(Usuario.class, id);
		
		return u;
	}
	
	public void updateUser(Usuario u){		
		manager.merge(u);
		manager.getTransaction().commit();

		manager.close();
	}
	
	public void delUsuario(Usuario u){		
		Query q = manager.createQuery("delete Usuario where id = ?0");		
		q.setParameter(0, u.getId());
		q.executeUpdate();
		
		manager.getTransaction().commit();

		manager.close();		
	}	
}
