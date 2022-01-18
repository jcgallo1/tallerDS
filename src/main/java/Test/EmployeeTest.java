package Test;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tallerpruebas.Employee;
import tallerpruebas.EmployeeType;

public class EmployeeTest {
	Employee empleado;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	//Casos prueba para Tipo de trabajador Worker
	
	@Test
	public void workerTest() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Worker);		
		assertEquals(489.3333,empleado.cs(),0.0001);
		
	}

	//Casos prueba para Tipo de trabajador Supervisor
	@Test
	public void supervisorTest() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Supervisor);
		assertEquals(498.08333,empleado.cs(),0.0001);
	}
	//Casos prueba para Tipo de trabajador Manager
	@Test 
	public void managerTest() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Manager);
		assertEquals(506.83333,empleado.cs(),0.0001);
		
	}
	
	//Casos prueba para Tipo de trabajador Worker con diferente divisa 
	@Test
	public void workerCurrencyTest() {
		empleado=new Employee(425.0f,"EUR",25.0f, EmployeeType.Worker);
		assertEquals(468.083333,empleado.cs(),0.0001);
	}
	@Test
	public void SupervisorCurrencyTest() {
		empleado=new Employee(425.0f,"EUR",25.0f, EmployeeType.Supervisor);
		assertEquals(476.83333,empleado.cs(),0.0001);
	}
	@Test
	public void managerCurrencyTest() {
		empleado=new Employee(425.0f,"EUR",25.0f, EmployeeType.Manager);
		assertEquals(485.583333,empleado.cs(),0.0001);
	}
	//caso prueba para bono trabajador Worker con diferente divisa
	@Test
	public void workerBonoCurrency() {
		empleado=new Employee(425.0f,"EUR",25.0f, EmployeeType.Worker);
		assertEquals(386,empleado.CalculateYearBonus(),0.001);
	}
	//Caso prueba para bono supervisor
	@Test
	public void bonoSupervisor() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Supervisor);
		assertEquals(618,empleado.CalculateYearBonus(),0.01);
		
	}
	//Caso prueba para bono manager
	@Test
	public void bonoManager() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Manager);
		
		assertEquals(811,empleado.CalculateYearBonus(),0.0001);
		
	}
	//Caso prueba para bono supervisor con diferente divisas
	@Test
	public void supervisorBonoCurrencyTest() {
		empleado=new Employee(425.0f,"JPY",25.0f, EmployeeType.Supervisor);
		assertEquals(596.75,empleado.CalculateYearBonus(),0.0001);
	}
	//Caso prueba con mes par
		/*
		@Test	
		public void WorkerTestFecha() {
				empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Worker);
				
				try {
					Process process=Runtime.getRuntime().exec("cmd /c date 17-02-2022");
					InputStream inputstream = process.getInputStream();
					BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				assertEquals(425,empleado.cs(),0.001);
								
		}
		 */
	
}
