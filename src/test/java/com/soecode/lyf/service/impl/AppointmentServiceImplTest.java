package java.com.soecode.lyf.service.impl;

import java.com.soecode.lyf.BaseTest;
import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.entity.Appointment;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.AppointmentOracleService;
import com.soecode.lyf.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentServiceImplTest extends BaseTest {

	@Autowired
	private AppointmentOracleService appointmentOracleService;


	@Test
	public void getById() throws Exception {
		Appointment appointment = appointmentOracleService.queryById(1003);
		System.out.println(appointment.toString());
	}

}
