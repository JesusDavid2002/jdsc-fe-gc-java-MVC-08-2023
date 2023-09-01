package ejercicio2.AppMain;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ejercicio1.views.VistaEjercicio1;
import ejercicio2.controllers.Controlador;
import ejercicio2.views.VistaEjercicio2;
import ejercicio2.views.VistaGlobal;
import models.Modelo;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(UnsupportedLookAndFeelException e) {
        	
        } catch(ClassNotFoundException e) {
        	
        } catch(InstantiationException e) {
        	
        } catch(IllegalAccessException e) {
        	
        }
        
        Modelo modelo = new Modelo();
        VistaGlobal vista = new VistaGlobal();
        VistaEjercicio1 vista1 = new VistaEjercicio1();
        VistaEjercicio2 vista2 = new VistaEjercicio2();
        Controlador controlador = new Controlador(modelo, vista, vista1, vista2);
        controlador.iniciarVista();
    }

}
