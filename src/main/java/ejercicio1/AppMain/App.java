package ejercicio1.AppMain;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ejercicio1.controllers.Controlador;
import ejercicio1.views.VistaEjercicio1;
import models.Modelo;

public class App 
{
    public static void main( String[] args )
    {
        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(UnsupportedLookAndFeelException e) {
        	
        } catch(ClassNotFoundException e) {
        	
        } catch(InstantiationException e) {
        	
        } catch(IllegalAccessException e) {
        	
        }
        
        Modelo modelo = new Modelo();
        VistaEjercicio1 vista = new VistaEjercicio1();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciarVista();
    }
}
