package mgp;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Test;

public class HelloJob {
	public static void main() {
		
	}
	
	private String msg;
	
	public String sayHello(String msg) {
		
		if (msg == null || msg == "") {
			 this.msg = "Hello~~~";
		}
		return this.msg;
	}
	
	public String addMsg(String msg) {
		this.msg.concat(msg);
		return this.msg;
	}
	
	public void deleteMsg() {
		this.msg = null;
	}
	
	public class AuthDao{
		
		private String id ;
		
		public void setId (String id) {
			
			this.id = id;
		}
		
		public String getId () {
			if(this.id == null) {
				this.id = "Jessica";
			}
			return this.id;
		}
		
		public boolean isLogin(String id) {
			if(id != null) {
				return true;
			}else {
				return false;
			}
		}
	}

	
	
	@Mock
	HelloJob p;
	AuthDao dao;
	
	@InjectMocks
	AuthServiceInject ser;
	
	@Test
	public void example(){
		//HelloJob p = mock(HelloJob.class);
		MockitoAnnotations.initMocks(this);
		when(p.addMsg(msg)).thenReturn("OK");
		doThrow(new IllegalArgumentException()).when(p).addMsg(eq("HighFive"));
		//doNothing().when(p).deleteMsg();
		//verify(p, timeout(100).atLeast(1)).deleteMsg();
		verify(p, never()).deleteMsg();
	    //assertTrue( p != null );
		dao.getId();
		//when(dao.isLogin(eq("Jessica"))).thenReturn(true);
	}
}

