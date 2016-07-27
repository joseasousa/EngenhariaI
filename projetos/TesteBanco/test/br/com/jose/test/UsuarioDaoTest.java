package br.com.jose.test;

import java.util.List;

import org.junit.Test;

import br.com.jose.model.Usuario;
import br.com.jose.model.dao.UsuarioDao;
import junit.framework.Assert;

public class UsuarioDaoTest extends AbstractDbUnitJpaTest{
	UsuarioDao uDao = new UsuarioDao();

	@Test
	public void testFind() {		
		Usuario user = uDao.getUsuarioById(1);
		Assert.assertNotNull(user);
		Assert.assertEquals("Peter", user.getNome());
	}	
	
	
	@Test
	public void testFindAll() {
		
		List<Usuario> allUsers = uDao.getUsers();
		Assert.assertEquals(50, allUsers.size());
	}

}
