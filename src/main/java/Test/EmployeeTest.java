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
	
	/*LOS CASOS DE PRUEBA IDENTIFICADOS SON
	Al momento de creación de un tipo de trabajador, el calculo de su respectivo salario.
	Y sus variaciones conllevarían al correcto funcionamiento del código en los diferentes tipos de tipo de trabajador y tipo de divisa en la que se 
	paga su salario.
	*/
	
	//Casos prueba para Tipo de trabajador Worker
	
	//Validando el empleado de tipo worker con un sueldo de 425
	//Valor esperado 489.3333
	@Test
	public void workerTest() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Worker);		
		assertEquals(489.3333,empleado.cs(),0.0001);
		
	}

	//Casos prueba para Tipo de trabajador Supervisor
	//Validando de tipo supervisor con un sueldo de 425
	//Valor esperado 498.08333
	@Test
	public void supervisorTest() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Supervisor);
		assertEquals(498.08333,empleado.cs(),0.0001);
	}
	
	//Casos prueba para Tipo de trabajador Manager
	//Validando manager con un sueldo de 425
	//Valor esperado 506.83333
	@Test 
	public void managerTest() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Manager);
		assertEquals(506.83333,empleado.cs(),0.0001);
		
	}
	
	//Casos prueba para Tipo de trabajador Worker con diferente divisa 
	//Para los siguientes 3, se valida la creación de los 3 tipos de empleados, con una divisa diferente a los USD, debe ejecutarse correctamente el sueldo del mismo
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
	//Caso prueba para bono supervisor con USD
	@Test
	public void bonoSupervisor() {
		empleado=new Employee(425.0f,"USD",25.0f, EmployeeType.Supervisor);
		assertEquals(618,empleado.CalculateYearBonus(),0.01);
		
	}
	//Caso prueba para bono manager con USD
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
	
	
	
	//Este caso de prueba es de calculo del CS con mes par pero no pudimos hacer bien el cambio de fecha de la VM
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
