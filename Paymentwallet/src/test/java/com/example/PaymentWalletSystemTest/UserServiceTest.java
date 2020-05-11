package com.example.PaymentWalletSystemTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.UserDao;
import com.example.entity.Userdata;
import com.example.service.UserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	   
	             @Mock
	          private UserDao userdao;
	            @InjectMocks
	        private UserServiceImpl toDoService;
		
	             @Before
	          public void setup(){
			MockitoAnnotations.initMocks(this);
		}
	
	              @Test
		
	public void testGetAllUsers(){
			List<Userdata> toDoList = new ArrayList<Userdata>();
			toDoList.add(new Userdata(120,"Charan","Charan123",9845633112L,"charan@gmail.com"));
			
	                          toDoList.add(new Userdata(121,"Sindhu","sindh23",9523663312L,"sindhu345@gmail.com"));
			toDoList.add(new Userdata(122,"Swetha","swetha89",9825843112L,"swetha855@gmail.com"));
			
	                            when(userdao.findAll()).thenReturn(toDoList);
			
			List<Userdata> result = toDoService.getAllUsers();
			
	                            assertEquals(3, result.size());
		}
		
		
	              @Test
	      public void testgetuserbyid(){
			Userdata toDo = new Userdata(120,"Charan","Charan123",9845633112L,"charan@gmail.com");
			
			when(userdao.findById(toDo.getUserId())).thenReturn(Optional.of(toDo));
			
	        Userdata result = toDoService.getuserbyid(120);
			assertEquals(120, result.getUserId());
			assertEquals("Charan", result.getUserName());
			assertEquals("Charan123", result.getUserPassword());
			assertEquals(9845633112L, result.getUserPhoneno());
			assertEquals("charan@gmail.com", result.getUserEmail());           
		}

	                @Test
		public void addUser(){
	                	
			Userdata toDo = new Userdata(128,"Ramya","Ram23",9844103612L,"ramyachinnu23@gmail.com");
	        when(userdao.save(toDo)).thenReturn(toDo);
			Userdata result = toDoService.addUser(toDo);
			assertEquals(128, result.getUserId());
			assertEquals("Ramya", result.getUserName());
			assertEquals("Ram23", result.getUserPassword());
			assertEquals(9844103612L, result.getUserPhoneno());
			assertEquals("ramyachinnu23@gmail.com", result.getUserEmail());		
		}
		
	                @Test
		public void testdeleteUser(){
			Userdata toDo = new Userdata(128,"Ramya","Ram23",9844103612L,"ramyachinnu23@gmail.com");
			toDoService.deleteUser(toDo.getUserId());
	        verify(userdao, times(1)).deleteById(toDo.getUserId());;
		}
	                
	                
	                 @Test
	    public void testLoginUser(){
	        Userdata toDo = new Userdata(125,"satish123");
	        when(userdao.findById(toDo.getUserId())).thenReturn(Optional.of(toDo));  		
	            Boolean result = toDoService.loginUser(toDo);
	      		assertEquals(true,result);      		
	    }
}

