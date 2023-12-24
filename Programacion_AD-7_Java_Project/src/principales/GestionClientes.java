package principales;
import java.util.Scanner;
import modelo.daojdbc.ClienteImplMySql;
import modelo.javabean.Cliente;
public class GestionClientes {

	public static void main(String[] args) {
		ClienteImplMySql cliimpl1= new ClienteImplMySql();
		Scanner entrada=new Scanner(System.in);
        System.out.println("Seleccione una opción:\n1. Alta del Cliente \n2. Buscar un cliente \n3. Mostrar todos "
        		+ "\n4. Eliminar un cliente \n5. Salir");
        int numero=entrada.nextInt();
        switch (numero) {
        case 1:
            System.out.print("Introduzca el cif del cliente: ");
            entrada.nextLine();
            String frase1=entrada.nextLine();
            System.out.print("Introduzca el nombre del cliente: ");
            String frase2=entrada.nextLine();
            System.out.print("Introduzca los apellidos: ");
            String frase3=entrada.nextLine();
            System.out.print("Introduzca el domicilio: ");
            String frase4=entrada.nextLine();
            System.out.print("Introduzca la facturación anual: ");
            Double num1=entrada.nextDouble();
            System.out.print("Introduzca el número de empleados: ");
            int num2=entrada.nextInt();
        	Cliente cli1 = new Cliente(frase1, frase2, frase3, frase4, num1, num2);
        	System.out.println(cliimpl1.altaCliente(cli1));
        	System.out.println(cliimpl1.buscarUno(frase1));
            break;
        case 2:
            System.out.print("Introduzca el cif del cliente. ");
            entrada.nextLine();
            String frase=entrada.nextLine();
        	System.out.println(cliimpl1.buscarUno(frase));
        case 3:
        	for (Cliente ele: cliimpl1.buscarTodos())
        		System.out.println(ele);
            break;
        case 4:
            System.out.print("Introduzca el cif del cliente a dar de baja: ");
            entrada.nextLine();
        	String frase5=entrada.nextLine();
        	System.out.println(cliimpl1.bajaCliente(frase5));
            break;
        case 5:
            System.out.println("Ha salido del sistema.");
        break;
        default:
            System.out.println("La opción seleccionada no es correcta.");
        }
	}
}
